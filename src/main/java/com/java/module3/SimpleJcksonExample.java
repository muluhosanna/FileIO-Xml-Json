package com.java.module3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class SimpleJcksonExample {

    String houseJson = "{ \"windowCount\" : 22, \"doorCount\" : 10," +
            " \"interiorPaintColor\" : \"medium Gray\" }";
    ObjectMapper objectMapper;

    void readSample1() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
       HouseModel house = objectMapper.readValue(houseJson, HouseModel.class);


        System.out.println(house.getInteriorPaintColor());
        System.out.println(house.getWindowCount());
        System.out.println(house.toString());
    }

    void readSample2() throws IOException {
        objectMapper = new ObjectMapper();
        HouseModel house = objectMapper.readValue(new File
                (Objects.requireNonNull(getClass().getClassLoader().getResource("house.json"))
                        .getFile()), HouseModel.class);
        System.out.println(house.getWindowCount() + " Window Count");

    }

    void writeSample1() throws IOException {
        objectMapper = new ObjectMapper();
        HouseModel house = new HouseModel(21,12, "Eggshell");
        objectMapper.writeValue(new File("house-sample.json"), house);
        String sample = objectMapper.writeValueAsString(house);
        System.out.println(sample);
    }

    void nodeSample() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        String houseJson = "{ \"windowCount\" : 22, \"doorCount\" : 10, \"interiorPaintColor\" : \"medium Gray\" }";
        JsonNode jNode = objectMapper.readTree(houseJson);
        String count = jNode.get("doorCount").asText();
        System.out.println("Door Count "+count);
    }

    /*
     * This example is why there are Annotations on workers.json. Those annotations are so
     * the object mapper knows which json value belongs to which part of the model. If the
     * WorkerModel class was constructed with the same value names as the json file, then it
     * would any require annotations.
     * */
    void listSample() throws IOException {
        File workers = new File(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("workers.json")).getFile());
        objectMapper = new ObjectMapper();
        ArrayList<WorkerModel> model = objectMapper.readValue(workers, new TypeReference<>() {});

        for(WorkerModel mod : model) {
            System.out.println(mod.getfName());
            System.out.println(mod.getPhoneList().get(1).getPhoneNumber());
        }
    }

}

package com.java.module3;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class CreateJsonFile {
    //public static void main(String[] args) throws IOException, ParseException {

    public void main() throws IOException, ParseException {
        JSONObject obj = new JSONObject();
        obj.put("name", "sadayoseph");
        obj.put("location", "USA");
        JSONArray list = new JSONArray();
        list.add("java");
        list.add("Jsp");
        list.add("servelet");
        obj.put("courses", list);
        try {
            FileWriter file = new FileWriter("myJson.json");
            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(obj);
        // in the following we are reading the above json files
        JSONArray array = new JSONArray();

        FileReader reader = new FileReader("myJson.json");
        JSONParser parser = new JSONParser();
        Object obj1 = parser.parse(reader);// java object
        JSONObject jsonObject = (JSONObject) obj1;// we changed it to jason object
        String name = (String) jsonObject.get("name");
        String location = (String) jsonObject.get("location");
        System.out.println(name);
        System.out.println(location);
        JSONArray array1 = (JSONArray) jsonObject.get("courses");
        for (int i = 0; i < array1.size(); i++) {
            array1.get(i);
            System.out.println(array1.get(i));
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/albums")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(HttpResponse::body).thenAccept(System.out::println).join();



    }


    public void exampleOnAlbum() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        File file2= new File(getClass().getClassLoader().getResource("album.json").getFile());
        FileReader reader =new FileReader(file2);
        Object object = parser.parse(reader);
        JSONArray array2 = (JSONArray) object;
        for (int i = 0; i < array2.size(); i++) {
            JSONObject jsonObject1 = (JSONObject) array2.get(i);
          BigDecimal userId = (BigDecimal) jsonObject1.get("userId");
           BigDecimal id = (BigDecimal)jsonObject1.get("id");
            String title = (String) jsonObject1.get("title");
           System.out.println("userId" + userId);
           System.out.println("id" + id);
            System.out.println("title" + title);


        }

    }
}

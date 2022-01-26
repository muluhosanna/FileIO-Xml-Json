package com.java.module3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.Objects;

public class Module3_JsonFiles {
    // Extends HashMap & Implements Map, JSONAware, JSONStreamAware
    JSONObject obj;
    // Extends ArrayList & Implements List, JSONAware, JSONStreamAware
    JSONArray simpleArray;

    // JSONAware interface with toJSONString() method
    // JSONStreamAware interface with writeJSONString(Writer var1) method

    FileWriter fileWriter;

    /*
     * In this example we use a JSONArray and JSONObject to encode JSON
     * data. Includes saving data to a file.
     * */
    @SuppressWarnings("unchecked")
    void encodeJsonExample() throws IOException {
        String result;
        simpleArray = new JSONArray();
        simpleArray.add(addPerson("Tom","Jones","someone@email.com"));
        simpleArray.add(addPerson("Jerry", "Roads", "sometwo@email.com"));
        try {
            fileWriter = new FileWriter("simple.json");
            StringWriter writer = new StringWriter();
            simpleArray.writeJSONString(writer);
            result = writer.toString();
            System.out.println("** Saving to file **" +"\n");
           fileWriter.write(result);
           System.out.println("** Using Interface writeJSONString **");
            System.out.println(result +"\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            fileWriter.close();
        }
        System.out.println("** Using Interface toJSONString **");
      System.out.println(simpleArray.toJSONString());
    }

    /*
     * In this example we use a JSONArray and JSONObject to decode JSON
     * data. We read in a file from the resources and parse it.
      */
    void decodeJsonExample() {
        JSONParser parser = new JSONParser();
        File sampleFile = new File(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("simple.json")).getFile());
        try {
            Reader read = new FileReader(sampleFile);
            simpleArray = (JSONArray) parser.parse(read);
            for (Object o : simpleArray) {
                obj = (JSONObject) o;
                System.out.print(obj.get("firstname"));
                System.out.print("\t");
                System.out.println(obj.get("lastname"));
                System.out.println(obj.get("email"));
               // System.out.println("------------------>");
               //System.out.println(obj.toJSONString());
               //System.out.println(obj.size());
            }

        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private JSONObject addPerson(String fName, String lName, String email) {
        obj = new JSONObject();
        obj.put("firstname", fName);
        obj.put("lastname", lName);
        obj.put("email", email);
        obj.toJSONString();

        return obj;
    }



}

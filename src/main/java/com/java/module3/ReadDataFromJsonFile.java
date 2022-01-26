package com.java.module3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromJsonFile {

    public static void main(String[]args) throws IOException, ParseException {
        File file = new File(ReadDataFromJsonFile.class.getClassLoader().getResource("employ.json").getFile());
        //JSONObject emloyobj= new JSONObject();
        FileReader reader = new FileReader(file);
        JSONParser parser= new JSONParser();
        Object obj=parser.parse(reader);//java object so we need to cats to json object
        JSONObject emloyobj =(JSONObject) obj;
       String firstName= (String)emloyobj.get("firstName");
       String lastName = (String) emloyobj.get("lastName");
       System.out.println("firstName"+ " " +firstName);
        System.out.println("lastName"+ " "+lastName);
       JSONArray array = (JSONArray)emloyobj.get("address");
       for (int i =0;i<array.size();i++){
            JSONObject address =(JSONObject) array.get(i);
           String street =(String)address.get("street");
           String city =(String) address.get("city");
           String state =(String) address.get("state");
           System.out.println("address" + " "+i );
           System.out.println("street" + " " +street);
           System.out.println("city" + " "+city);
           System.out.println("state" + " " +state);

       }



    }

}

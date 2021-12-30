package com.java.fileio;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[]args) throws IOException {
        //Test test = new Test();
       // test.byteArray();
        //link();
       // anotherText();
        web();

    }
    public void byteArray() throws IOException {
        File file= new File(getClass().getClassLoader().getResource("extra.txt").getFile());
        FileReader reader = new FileReader(file);
       // FileInputStream fis = new FileInputStream(file);
        int c;
        while((c=reader.read())!=-1){
            System.out.print((char) reader.read());

        }
        reader.close();
    }
    public static void link() throws FileNotFoundException {
        File file1= new File("/Users/mt093925/Desktop/link.txt");
        Scanner scanner  =  new Scanner(file1);
        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
    }
    public static void anotherText() throws IOException {
        File file2 = new File("temp.txt");
        if (!file2.exists()){
            file2.createNewFile();
        }
        FileOutputStream outputStream = new FileOutputStream(file2);
        String value ="";
        for (int i= 0;i<=10;i++){
            value +=i + " ";

        }
        byte[] name =value.getBytes();
        for (byte b:name){
            outputStream.write(b);

        }
        outputStream.close();
        Scanner scanner1 = new Scanner(file2);
        while (scanner1.hasNext()){
            System.out.println(scanner1.nextLine());
        }

    }
    public static void web() throws IOException {
        java.net.URL url  = new java.net.URL("https://snapit.solutions/");
        Scanner scan1 = new Scanner(url.openStream());
        while (scan1.hasNext()){
            System.out.println(scan1.nextLine());
        }

    }


}

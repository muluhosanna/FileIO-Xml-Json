package com.java.module3;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        //Test test = new Test();
        // test.byteArray();
        //link();
        // anotherText();
        // web();
        //bufferedStaff();
        //readArray();
        // writingArray();
        // copying();
        generatingPrimenumbers();
        //copyingAndReading();
       // leapYearTask2();


    }

    public void byteArray() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("extra.txt").getFile());
        FileReader reader = new FileReader(file);
        // FileInputStream fis = new FileInputStream(file);
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) reader.read());

        }
        reader.close();
    }

    public static void link() throws FileNotFoundException {
        File file1 = new File("/Users/mt093925/Desktop/link.txt");
        Scanner scanner = new Scanner(file1);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void anotherText() throws IOException {
        File file2 = new File("temp.txt");
        if (!file2.exists()) {
            file2.createNewFile();
        }
        FileOutputStream outputStream = new FileOutputStream(file2);
        String value = "";
        for (int i = 0; i <= 10; i++) {
            value += i + " ";

        }
        byte[] name = value.getBytes();
        for (byte b : name) {
            outputStream.write(b);

        }
        outputStream.close();
        Scanner scanner1 = new Scanner(file2);
        while (scanner1.hasNext()) {
            System.out.println(scanner1.nextLine());
        }

    }

    public static void web() throws IOException {
        java.net.URL url = new java.net.URL("https://snapit.solutions/");
        Scanner scan1 = new Scanner(url.openStream());
        while (scan1.hasNext()) {
            System.out.println(scan1.nextLine());
        }

    }

    public static void bufferedStaff() throws IOException {
        File obj = new File("/Users/mt093925/Desktop/link.txt");
        FileInputStream fin = new FileInputStream(obj);
        BufferedInputStream bufeferIn = new BufferedInputStream(fin);
        int t;
        while ((t = bufeferIn.read()) != -1) {
            System.out.print((char) bufeferIn.read());
        }
        bufeferIn.close();


    }

    public static void readArray() throws IOException {
        // File obj1= new File("rank.txt");
        String str = """
                Hello world
                where are you guys.
                we are wondering how things are gone
                """;
        byte[] bytes = str.getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int amount = byteArrayInputStream.available();
        for (int i = 0; i < amount; i++) {
            System.out.print(Character.toUpperCase((char) byteArrayInputStream.read()));
        }
        byteArrayInputStream.reset();
    }

    public static void writingArray() throws IOException {
        String sample = """
                   java input file
                   java the most love language
                   really I love it
                """;
        ByteArrayOutputStream boutPut = new ByteArrayOutputStream(900000);
        boutPut.write(sample.getBytes());
        byte[] theSample = boutPut.toByteArray();
        System.out.println("print out the stream");
        for (byte b : theSample) {
            System.out.print((char) b);
        }


    }

    public static void copying() {
        File sourceFile = new File("/Users/mt093925/Desktop/link.txt");
        File destinationFile = new File("/Users/mt093925/Desktop/link2.txt");
        try {
            Files.copy(sourceFile.toPath(), destinationFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generatingPrimenumbers() throws IOException {
        File prime = new File("sample-prime.txt.");
        FileOutputStream fOutPut = new FileOutputStream(prime);
        String value = "";
        int count = 1;
        int number = 2;
        while (count < 200) {
            // Assume the number if prime
            boolean isprime = true;// is the current number prime?
            //test whether the number is prime or not
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) {
                    isprime = false;
                    break;

                }
            }
            if (isprime) {

                value += number + " ";
                ;
            }
            number++;
            count++;

        }
        byte[] b = value.getBytes();
        for (byte name : b) {
            fOutPut.write(name);
        }
        FileInputStream fin = new FileInputStream(prime);
        int amount = fin.available();
        for (int i = 0; i < amount; i++) {
            System.out.print((char) fin.read());
        }


    }

    public static void copyingAndReading() throws IOException {
        File fileSessio1 = new File("session1-task1.txt");
        File fileSession2 = new File("session2-task2.tx");
        FileWriter fileWriter1 = new FileWriter(fileSessio1);
        fileWriter1.write("Math101");
        fileWriter1.write("com101");
        fileWriter1.write("chem101");
        fileWriter1.close();
        try {
            Files.copy(fileSessio1.toPath(), fileSession2.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] b1 = Files.readAllBytes(fileSessio1.toPath());
        ByteArrayInputStream byteArrayOutPut = new ByteArrayInputStream(b1);
        int x = byteArrayOutPut.available();
        for (int i = 0; i < x; i++) {
            System.out.println(((char) byteArrayOutPut.read()));
        }
        System.out.println("It is copied from session1");

    }

    public static void leapYearTask2() throws IOException {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(System.in);

            System.out.println("Enter characters, 'q' to quit.");

            int c ;
           do {

                c = inputStreamReader.read();
                //System.out.print(c);

           } while (c != 'q');
            int length = String.valueOf(c).length();
            System.out.println(length);
            if (length == 4 && c % 4 == 0) {
                System.out.println("it is leap year");
            } else if (length != 4) {
                System.out.println("the number you entered is in valid");


            } else if (length == 4 && c % 4 != 0) {
                System.out.println("it is not leap year");
            }
        } finally {


            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        }
    }


}






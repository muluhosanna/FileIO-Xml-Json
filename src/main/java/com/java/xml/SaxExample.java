package com.java.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class SaxExample {
    void readSax() {
        try {
            File myStudent = new File(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource("students.xml")).getFile());
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            parser.parse(myStudent, handler);
        } catch (SAXException | ParserConfigurationException | IOException sa) {
            System.out.println(sa.getMessage());
        }
    }

    void modifySax() {
        try {
            File myStudent = new File(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource("students.xml")).getFile());
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SaxModifyHandler handler = new SaxModifyHandler();
            parser.parse(myStudent, handler);

            String[] displayResult = handler.getModifiedText();
            int lines = handler.getNumLines();
            // save data to new file
            FileWriter fileWriter = new FileWriter("student-modify.xml");
            for (int i = 0; i < lines; i++) {
                fileWriter.write(displayResult[i].toCharArray());
                fileWriter.write("\n");
                System.out.println(displayResult[i]);
            }
            fileWriter.close();
        } catch (SAXException | ParserConfigurationException | IOException sa) {
            System.out.println(sa.getMessage());
        }
    }
}



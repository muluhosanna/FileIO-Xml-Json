package com.java.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParserSession3 {


    public void saxSession3() throws SAXException, ParserConfigurationException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        File file = new File(getClass().getClassLoader().getResource("session3.xml").getFile());
        SAXParser parser = saxParserFactory.newSAXParser();
        SaxHandler handler = new SaxHandler();
        parser.parse(file,handler);


    }
}

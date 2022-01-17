package com.java.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Module3_XmlExercise {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        testSates();
    }
       public static void testSates() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(ClassLoader.getSystemResourceAsStream("session3.xml"));
        NodeList numberList = doc.getElementsByTagName("session3");
          Attr id1=  doc.createAttribute("id");

        for (int i = 0; i < numberList.getLength(); i++) {


            Node p = numberList.item(i);
            if (p.getNodeType() == Node.ELEMENT_NODE) {
                Element person = (Element) p;
                NodeList nameList = person.getChildNodes();
                for (int j = 0; j < nameList.getLength(); j++) {
                    Node n = nameList.item(j);
                    if (n.getNodeType() == Node.ELEMENT_NODE) {
                        Element name = (Element) n;
                        //NodeList addressList = doc.getElementsByTagName("address");

                        System.out.println( name.getTagName() +" "   + id1 +name.getTextContent());


                    }

                }


            }
        }
    }


}

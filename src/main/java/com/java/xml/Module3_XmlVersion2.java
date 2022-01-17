package com.java.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Module3_XmlVersion2 {
    private ArrayList<SateAndBirdName> stateBirdList;

    private Document openXml() {
        Document myDoc = null;
        try {
            File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("session3.xml")).getFile());
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            myDoc = documentBuilder.parse(file);
            return myDoc;

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
        return myDoc;


    }

    ArrayList<SateAndBirdName> domRead() {
        try {
            Document doc = openXml();
            doc.getDocumentElement().normalize();

            stateBirdList = new ArrayList<>();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("state");
            System.out.println("----------------------------");
            for (int i = 0; i < nList.getLength(); i++) {
                Node stateName=nList.item(i);
                System.out.println(nList.item(2));
                Element element = (Element) stateName;
                if (element.getNodeType() == Node.ELEMENT_NODE) ;
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String year = element.getElementsByTagName("year").item(0).getTextContent();
                String birdName = element.getElementsByTagName("birdName").item(0).getTextContent();
                String abbirivation = element.getElementsByTagName("abbirivation").item(0).getTextContent();

                System.out.println(" " + stateName.getNodeName());
                System.out.println("full Name : " + name);
                System.out.println("year " + year);
                System.out.println("birdName: " + birdName);
                System.out.println("abbirivation : " + abbirivation);


                /* Adding the element data to a model */

                SateAndBirdName sname1  = new SateAndBirdName(name, year, birdName, abbirivation);
                    stateBirdList.add(sname1);

            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return stateBirdList;


    }

}

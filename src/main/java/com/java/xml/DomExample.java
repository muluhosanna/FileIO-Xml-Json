package com.java.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class DomExample {
    ArrayList<PersonModel> personList;

    private Document openXml() {
        Document myDoc = null;
        try {
            File myInfo = new File(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource("info.xml")).getFile());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            myDoc = dBuilder.parse(myInfo);
            return myDoc;
        } catch(ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return myDoc;
    }

    // This method will read the information from the XML file
    ArrayList<PersonModel> domRead() {
        try {
            Document doc = openXml();
            doc.getDocumentElement().normalize();

            personList = new ArrayList<>();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Person");
            System.out.println("----------------------------");

            /* We iterate through the nList to get our data */
            for(int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                Element staffElement = (Element) nNode;
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    String id = staffElement.getAttribute("id");

                    /* Get Person Information */
                    String firstName = staffElement.getElementsByTagName("FirstName")
                            .item(0).getTextContent();
                    String lastName = staffElement.getElementsByTagName("LastName")
                            .item(0).getTextContent();
                    String email = staffElement.getElementsByTagName("Email")
                            .item(0).getTextContent();

                    /* Get Address Attribute and Information*/
                    NodeList addressNodeList = staffElement.getElementsByTagName("Address");
                    String country = addressNodeList.item(0)
                            .getAttributes().getNamedItem("country").getTextContent();
                    String street = staffElement.getElementsByTagName("Street")
                            .item(0).getTextContent();
                    String city = staffElement.getElementsByTagName("City")
                            .item(0).getTextContent();
                    String state = staffElement.getElementsByTagName("State")
                            .item(0).getTextContent();

                    /* Print the results to the console */
                    System.out.println("Current Element :" + nNode.getNodeName());
                    System.out.println("Person Id : " + id);
                    System.out.println("First Name : " + firstName);
                    System.out.println("Last Name : " + lastName);
                    System.out.println("Address : " + country);
                    System.out.println("Street : " + street);
                    System.out.println("City : " + city);
                    System.out.println("State : " + state);
                    System.out.println("Email : " + email + "\n");

                    /* Adding the element data to a model */
                    PersonModel personModel = new PersonModel(Integer.parseInt(id),
                            firstName, lastName, country, street, city, state, email);
                    personList.add(personModel);
                }
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return personList;
    }

    // This will modify the existing document
    void modifyDom() {
        try {
            Document doc = openXml();
            Node staff = doc.getFirstChild();

            // Add Person 4 to the xml document
            Element staffElement = (Element) staff;
            Element person4 = doc.createElement("Person");
            staffElement.appendChild(person4);

            // set id attribute
            Attr fourId = doc.createAttribute("id");
            fourId.setValue("203");
            person4.setAttributeNode(fourId);

            // set Child attributes to Person 4
            person4.appendChild(setElement(doc, "FirstName", "Fourth"));
            person4.appendChild(setElement(doc, "LastName", "Four"));

            Element address = doc.createElement("Address");
            Attr country = doc.createAttribute("country");
            country.setValue("USA");
            address.setAttributeNode(country);

            address.appendChild(setElement(doc, "Street", "144 Second St"));
            address.appendChild(setElement(doc, "City", "Lees Summit"));
            address.appendChild(setElement(doc, "State", "MO"));

            person4.appendChild(address);

            person4.appendChild(setElement(doc, "Email", "somefour@email.com"));
            saveDoc(doc);
        } catch (NullPointerException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Extracted to a method for setting elements
    private Element setElement(Document doc, String name, String value) {
        Element element = doc.createElement(name);
        element.appendChild(doc.createTextNode(value));
        return element;
    }

    // This will save the updated information to a new document
    private void saveDoc(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("info-update.xml"));
        transformer.transform(source, result);
    }

}


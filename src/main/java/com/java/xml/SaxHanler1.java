package com.java.xml;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHanler1 extends DefaultHandler{
    boolean fNameT = false;
    boolean lNameT = false;
    boolean subjectT = false;
    boolean gradeT = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName.toLowerCase()) {
            case "student" ->
                    System.out.println("Student ID = " + attributes.getValue("id"));
            case "firstname" -> fNameT = true;
            case "lastname" -> lNameT = true;
            case "subject" -> subjectT = true;
            case "grade" -> gradeT = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            System.out.println("End Student Record :" + qName  + "\n");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (fNameT) {
            System.out.println("First Name: " + new String(ch, start, length));
            fNameT = false;
        } else if (lNameT) {
            System.out.println("Last Name: " + new String(ch, start, length));
            lNameT = false;
        } else if (subjectT) {
            System.out.println("Subject: " + new String(ch, start, length));
            subjectT = false;
        } else if (gradeT) {
            System.out.println("Grades: " + new String(ch, start, length));
            gradeT = false;
        }
    }

}

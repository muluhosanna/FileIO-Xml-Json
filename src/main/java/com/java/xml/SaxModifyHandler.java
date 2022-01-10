package com.java.xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxModifyHandler extends DefaultHandler {
    String[] modifiedText = new String[1000];
    String indent = "";
    int numLines = 0;
    String honorStatus = "No";

    public String[] getModifiedText() { return modifiedText; }

    public int getNumLines() { return  numLines;}

    @Override
    public void startDocument() {
        modifiedText[numLines] = indent;
        modifiedText[numLines] +="<?xml version = \"1.0\" encoding = \""+
                "UTF-8" + "\"?>";
        numLines++;
    }

    @Override
    public void processingInstruction(String target, String data) {
        modifiedText[numLines] = indent;
        modifiedText[numLines] += "<?";
        modifiedText[numLines] += target;

        if(data != null && data.length() > 0) {
            modifiedText[numLines] += ' ';
            modifiedText[numLines] += data;

        }
        modifiedText[numLines] += "?>";
        numLines++;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) {
        modifiedText[numLines] = indent;
        indent += "    ";
        modifiedText[numLines] += '<';
        modifiedText[numLines] += qName;

        if(attributes != null) {
            for(int i = 0; i < attributes.getLength(); i++) {
                modifiedText[numLines] += ' ';
                modifiedText[numLines] += attributes.getQName(i);
                modifiedText[numLines] += "=\"";
                modifiedText[numLines] += attributes.getValue(i);
                modifiedText[numLines] +='"';
            }
        }
        modifiedText[numLines] += '>';
        numLines++;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        indent = indent.substring(0, indent.length() - 4);
        modifiedText[numLines] = indent;
        modifiedText[numLines] += "</";
        modifiedText[numLines] += qName;
        modifiedText[numLines] += ">";
        numLines++;

        if(qName.equals("grade")) {
            startElement("", "honorroll","honorroll", null);
            characters(honorStatus.toCharArray(), 0, honorStatus.length());
            endElement("", "honorroll", "honorroll");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String myTrim = (new String(ch, start, length)).trim();
        if(myTrim.indexOf("\n") < 0 && myTrim.length() > 0) {
            if(myTrim.contains("A")) {
                honorStatus = "Yes";
            } else {
                honorStatus = "No";
            }
            modifiedText[numLines] = indent;
            modifiedText[numLines] += myTrim;
            numLines++;
        }
    }

}

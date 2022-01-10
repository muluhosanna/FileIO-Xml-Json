package com.java.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParserDemos {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		SaxHandler handler = new SaxHandler();
		parser.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"), handler);
		System.out.println(handler.getDriversLicense().getFirstName());
		System.out.println(handler.getDriversLicense().getLastName());
		System.out.println(handler.getDriversLicense().getNumber());
	}
}

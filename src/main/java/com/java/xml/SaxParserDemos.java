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
		parser.parse(ClassLoader.getSystemResourceAsStream("DriversLicense.xml"), handler);
		// handler.getDriversLicense().getAddress().setCity("king of purcia");
		//handler.getDriversLicense().getAddress().setStreet("stevens dr");
		//handler.getDriversLicense().getAddress().setCity("king of purcia");
		//handler.getDriversLicense().getAddress().setState("PA");
		//handler.getDriversLicense().getAddress().setZipcode("19406");
		System.out.println(handler.getDriversLicense().getNumber());
		System.out.println(handler.getDriversLicense().getFirstName());
		System.out.println(handler.getDriversLicense().getLastName());
		System.out.println(handler.getDriversLicense().getNumber());
		System.out.println(handler.getDriversLicense().getAddress().getCity());
		System.out.println(handler.getDriversLicense().getAddress().getStreet());
		System.out.println(handler.getDriversLicense().getAddress().getState());
		System.out.println(handler.getDriversLicense().getAddress().getZipcode());
		System.out.println(handler.getDriversLicense().getAddress().getCountry());

		System.out.println();
	}
}

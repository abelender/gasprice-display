package com.abelender.gaspricedisplay;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxParser {
	
	SAXParserFactory factory;
	SAXParser saxParser;
	InputStream is;
	
	public SaxParser(ContentHandler handler, String url) {
		
		try {
			
			is = new URL(url).openStream();
			factory = SAXParserFactory.newInstance();
			saxParser = factory.newSAXParser();
			saxParser.parse(is, handler);
				
		} catch (Throwable e) {
			e.printStackTrace();
		}		
	}
}
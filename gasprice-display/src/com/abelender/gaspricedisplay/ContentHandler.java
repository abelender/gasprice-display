package com.abelender.gaspricedisplay;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ContentHandler  extends DefaultHandler {

       private GasStationPrice gasStation = new GasStationPrice();	

       
       private boolean isRegularType = false;
       private boolean isPremiumType = false;
       private boolean isDieselType = false;
       private boolean isGasStation = false;
       
       
       private String temp, unpadded;
       
       

       public void characters(char[] buffer, int start, int length) {
              unpadded = new String(buffer, start, length);
              temp = unpadded + "00.00".substring(unpadded.length());
 
              if (isRegularType && temp != null && !temp.isEmpty()) {
            	  gasStation.setRegularPrice(temp);
            	  isRegularType = false;
              }
              
              if (isPremiumType && temp != null && !temp.isEmpty()) {
            	  gasStation.setPremiumPrice(temp);
            	  isPremiumType = false;
              }
              
              if (isDieselType && temp != null && !temp.isEmpty()) {
            	  gasStation.setDieselPrice(temp);
            	  isDieselType = false;
              }             
       }
      
       public void startElement(String uri, String localName,
                     String qName, Attributes attributes) throws SAXException {
    	   
    	   temp = "";
    	   
    	   	if("place".equals(qName)) {
    	   		if("11607".equals(attributes.getValue("place_id"))) {
    	   			
        	   		//gasStation = new GasStationPrice(attributes.getValue("place_id"));
    	   			gasStation.setId(attributes.getValue("place_id"));
        	   		isGasStation = true;
    	   		}  
    	    }
    	   	
    		if("gas_price".equals(qName) && isGasStation) {
    			
    			switch (attributes.getValue("type")) {
				case "regular":
					isRegularType = true;
					break;
					
				case "premium":
					isPremiumType = true;
					break;

				case "diesel":
					isDieselType = true;
					break;
				}
    		}
       }	   
    		      
       public void endElement(String uri, String localName, String qName)
                     throws SAXException {
    	   
    	   if("place".equals(qName) && isGasStation) {
    		   
//    		   System.out.println("Regular: " + gasStation.getRegularPrice() + "\n" +
//    				   		      "Premium: " + gasStation.getPremiumPrice() + "\n" +
//    				   			  "Diesel : " + gasStation.getDieselPrice());
    		   
    		   isGasStation = false;
    	   }  	 
       }

	@Override
	public void endDocument() throws SAXException {
		
		 System.out.println("Regular: " + gasStation.getRegularPrice() + "\n" +
				 			"Premium: " + gasStation.getPremiumPrice() + "\n" +
				 			"Diesel : " + gasStation.getDieselPrice());
		
		
	} 
	
	public GasStationPrice getPricesObject () {
		return gasStation;
	}
       
       
}

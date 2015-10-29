package com.sourcebits.xmlpullparser;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;


public class XmlPullParserClass
{
		
	   XmlPullParserValue xmlPullParserValue;
	   ArrayList<XmlPullParserValue> list = new ArrayList<XmlPullParserValue>();
	   
	   public volatile boolean parsingComplete = true;
	   
	   public XmlPullParserClass()
	   {
	      
	   }
	   
	    
	   public void parseXMLAndStoreIt(XmlPullParser myParser) 
	   {
	      int event;
	      
	      try {
	         event = myParser.getEventType();
	         
	         while (event != XmlPullParser.END_DOCUMENT) {
	            String name=myParser.getName();
	         
	            switch (event){
	               case XmlPullParser.START_TAG:
	               break;
	            	                        
	               case XmlPullParser.END_TAG:
	               
	            	if(name.equalsIgnoreCase("id")){  		
	               		xmlPullParserValue.setid(Integer.parseInt(myParser.getAttributeValue(null,"id")));
	                  	}
	               	else if(name.equalsIgnoreCase("companyid")){
	               		xmlPullParserValue.setcompanyid(Integer.parseInt(myParser.getAttributeValue(null,"companyid")));
	                  	}
	               	else if(name.equalsIgnoreCase("company")){
	               		xmlPullParserValue.setcompany(myParser.getAttributeValue(null,"company"));
	               	}
	               	else if(name.equalsIgnoreCase("address")){
	               		xmlPullParserValue.setaddress(myParser.getAttributeValue(null,"address"));
	               	}
	               	else if(name.equalsIgnoreCase("city")){
	               		xmlPullParserValue.setcity(myParser.getAttributeValue(null,"city"));
	               	}
	               	else if(name.equalsIgnoreCase("state")){
	               		xmlPullParserValue.setstate(myParser.getAttributeValue(null,"state"));
	               	}
	               	else if(name.equalsIgnoreCase("zipcode")){
	               		xmlPullParserValue.setzipcode(myParser.getAttributeValue(null,"zipcode"));
	               	}
	               	else if(name.equalsIgnoreCase("country")){
	               		xmlPullParserValue.setcountry(myParser.getAttributeValue(null,"country"));
	               	}
	               	else if(name.equalsIgnoreCase("telephone")){
	               		xmlPullParserValue.settelephone(myParser.getAttributeValue(null,"telephone"));
	               	}
	               	else if(name.equalsIgnoreCase("date")){
	               		xmlPullParserValue.setdate(myParser.getAttributeValue(null,"date"));
	               	}
	                           
	               else{
	               }
	               break;
	            }
	            event = myParser.next();
	         }
	         parsingComplete = false;
	      }
	      
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	    
}



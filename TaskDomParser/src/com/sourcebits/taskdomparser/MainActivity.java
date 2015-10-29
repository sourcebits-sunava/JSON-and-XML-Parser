package com.sourcebits.taskdomparser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView output 		= (TextView) findViewById(R.id.output);
		final Button bparsexml      = (Button) findViewById(R.id.bparsexml);
		
		//Static XML data 
		final String XMLData = "<?xml version=\"1.0\"?><login><status>OK</status><jobs><job><id>4</id><companyid>4</companyid><company>Android Example</company><address>Parse XML Android</address><city>Tokio</city><state>Xml Parsing Tutorial</state><zipcode>601301</zipcode><country>Japan</country><telephone>9287893558</telephone><fax>1234567890</fax><date>2012-03-15 12:00:00</date></job><job><id>5</id><companyid>6</companyid><company>Xml Parsing In Java</company><address>B-22</address><city>Cantabill</city><state>XML Parsing Basics</state><zipcode>201301</zipcode><country>America</country><telephone>9287893558</telephone><fax>1234567890</fax><date>2012-05-18 13:00:00</date></job></jobs></login>";
		
		String dataToBeParsed = "Click on button to parse XML.\n\n XML DATA : \n\n"+XMLData;
		output.setText(dataToBeParsed);
		
		
		bparsexml.setOnClickListener(new OnClickListener() {
			
		public void onClick(View v) 
		{
		
			try{
					
				InputStream is=new ByteArrayInputStream(XMLData.getBytes());
							
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();  
				Document doc = dBuilder.parse(is);  
				  
				Element element=doc.getDocumentElement();  
				element.normalize();  
				  
				NodeList nList = doc.getElementsByTagName("job");  
				for (int i=0; i<nList.getLength(); i++) 
				{  
				  
					Node node = nList.item(i);  
					if (node.getNodeType() == Node.ELEMENT_NODE) 
					{  
						Element element2 = (Element) node;  
						output.setText(output.getText()+"\ncompany : " + getValue("company", element2)+"\n");  
						output.setText(output.getText()+"address : " + getValue("address", element2)+"\n");  
						output.setText(output.getText()+"city : " + getValue("city", element2)+"\n");  
						output.setText(output.getText()+"state : " + getValue("state", element2)+"\n");  
						output.setText(output.getText()+"zipcode : " + getValue("zipcode", element2)+"\n");  
						output.setText(output.getText()+"country : " + getValue("country", element2)+"\n");  
						output.setText(output.getText()+"telephone : " + getValue("telephone", element2)+"\n");  
						output.setText(output.getText()+"date : " + getValue("date", element2)+"\n");  
						
						output.setText(output.getText()+"-----------------------");  
					}  
				}//end of for loop  
				  
				} 
			catch (Exception e) 
			{
				e.printStackTrace();}
			}
		});	   		  
	}  
	
			private static String getValue(String tag, Element element) {  
			NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();  
			Node node = (Node) nodeList.item(0);  
			return node.getNodeValue();  
			}  
			
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

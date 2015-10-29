package com.sourcebits.taskjsonparser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity
{
	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final String dataToBeParsed ="{\"items\":[{\"id\":\"A19\",\"name\":\"Extra Beans\",\"addr\":\"15 Main St\",\"hours\":{ \"monday\":\"closed\",\"tuesday\":\"9 AM to 5 PM\", \"wednesday\":\"9 AM to 6 PM\",\"thursday\":\"9 AM to 8 PM\",\"friday\":\"8 AM to 8 PM\", \"saturday\":\"noon to 5 PM\",\"sunday\":\"closed\"}] }";
		int lengthJsonArr;
		String outputData = "";
		String outPutArray[];
		JSONObject jsonResponse;
	       try {
				
						/****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
						jsonResponse = new JSONObject(dataToBeParsed);
						
						/***** Returns the value mapped by name if it exists and is a JSONArray. Returns null otherwise.*******/
						JSONArray jsonMainNode=jsonResponse.optJSONArray("items");
						
						/*********** Process each JSON Node ************/
						lengthJsonArr = jsonMainNode.length();
						outPutArray = new String[lengthJsonArr];
						for(int i=0;i<lengthJsonArr;i++)
						{
							/****** Get Object for each JSON node.***********/
							JSONObject jsonChildNode = jsonMainNode.optJSONObject(i);
							
							/******* Fetch node values **********/
							int id 		= Integer.parseInt(jsonChildNode.optString("id").toString());
				            String name 	= jsonChildNode.optString("name").toString();
				            String address	= jsonChildNode.optString("addr").toString();
				            JSONObject jsonChildobject = jsonChildNode.optJSONObject("hours");
				            
				            
				            
				            outputData = "Item ID : "+ id +" \n  Name"+ name +" \n Address "+ address +"\n Hours" + " \n Monday" + jsonChildobject.optString("monday")	+ " \n Tuesday" + jsonChildobject.optString("tuesday")+ " \n Wednesday" + jsonChildobject.optString("wednesday")+ " \n Thrusday" + jsonChildobject.optString("thrusday")+ " \n Friday" + jsonChildobject.optString("friday");			            
				            outPutArray[i] = outputData;
				            outputData = "";
				            //Log.i("JSON parse", song_name);
				       }
						
						System.out.print(outPutArray);
						listView = (ListView)findViewById(R.id.listView);
					    CustomAdapter customAdapter = new CustomAdapter(this, outPutArray);
					    listView.setAdapter(customAdapter);
					
						
					} catch (JSONException e) {
			 
						e.printStackTrace();
					}
	       
		
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

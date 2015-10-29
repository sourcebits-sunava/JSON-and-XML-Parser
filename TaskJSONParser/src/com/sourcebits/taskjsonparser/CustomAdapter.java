package com.sourcebits.taskjsonparser;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class CustomAdapter extends ArrayAdapter
{
	
	Context context;
	String list[];
	public CustomAdapter(Context context,String list[])
	{
		super(context,R.layout.row);
		this.context = context;
		this.list= list;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row;
		if(convertView== null)
		{
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
			row = inflater.inflate(R.layout.row,parent,false);
		}
		else
			row = convertView;
		TextView textView = (TextView)row.findViewById(R.id.textview);
		textView.setText(list[position]);
		
		
		return row;
	}
	
	
}

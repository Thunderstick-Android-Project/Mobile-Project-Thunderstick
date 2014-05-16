package com.thunderstick.medreminder;

import java.nio.channels.SelectionKey;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Additem extends Activity{
	
	TabHost th;
	TabSpec specs;
	
	EditText itname, qty, rol, amnt;
	Button imagebtn;
	TextView itmnm;
	RadioButton tmeslt, tmegap;
	
	int val;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itemadd);

		th = (TabHost) findViewById(R.id.tabhost);

		th.setup();
		specs = th.newTabSpec("tag1");// just set it up
		specs.setContent(R.id.Item);
		specs.setIndicator("Item");
		th.addTab(specs);

		specs = th.newTabSpec("tag2");// just set it up
		specs.setContent(R.id.Shedule);
		specs.setIndicator("Shedule");
		th.addTab(specs);
		
		itname = (EditText) findViewById(R.id.ad_txtitemname);
		qty = (EditText) findViewById(R.id.ad_txtqty);
		rol = (EditText) findViewById(R.id.ad_txtrol);
		amnt = (EditText) findViewById(R.id.ad_txtamnt);
		
		imagebtn = (Button) findViewById(R.id.ad_btnitemimg);
		
		itmnm = (TextView) findViewById(R.id.ad_txtname);
		
		tmegap = (RadioButton) findViewById(R.id.ad_radiotimegap);
		tmeslt = (RadioButton) findViewById(R.id.ad_radiotime);
		
		tmegap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final ArrayList mSelectedItems = new ArrayList();
				AlertDialog.Builder builder = new AlertDialog.Builder(Additem.this);
				builder.setTitle("Hours Gap");
		        builder.setSingleChoiceItems(R.array.colors_array, -1, new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int whichButton) {
		                //Log.d(TAG,"E' stato premuto il pulsante: "+R.array.colors_array[whichButton]);   
		            	
		           }
		       }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	                   // User clicked OK, so save the mSelectedItems results somewhere
	                   // or return them to the component that opened the dialog
	            	   val = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
	            	   itmnm.setText("hb"+val);
	            	   
	                   
	               }
	           })
	           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	                 
	               }
	           });;

		        


		        builder.create();
		       builder.show();

				
			}
		});
		
		//itmnm.setText("hb"+val);
		
		
		tmeslt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final ArrayList mSelectedItems = new ArrayList();
				AlertDialog.Builder builder = new AlertDialog.Builder(Additem.this);
				builder.setTitle("Select Session");
		        builder.setMultiChoiceItems(R.array.checkbx, null,
	                      new DialogInterface.OnMultiChoiceClickListener() {
		               @Override
		               public void onClick(DialogInterface dialog, int which,
		                       boolean isChecked) {
		                   if (isChecked) {
		                       // If the user checked the item, add it to the selected items
		                       mSelectedItems.add(which);
		                   } else if (mSelectedItems.contains(which)) {
		                       // Else, if the item is already in the array, remove it 
		                       mSelectedItems.remove(Integer.valueOf(which));
		                   }
		               }
		           }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
		               @Override
		               public void onClick(DialogInterface dialog, int id) {
		                   // User clicked OK, so save the mSelectedItems results somewhere
		                   // or return them to the component that opened the dialog
		            	   
		            	   final ArrayList mSelectedItems = new ArrayList();
		   				AlertDialog.Builder builder = new AlertDialog.Builder(Additem.this);
		   				builder.setTitle("Select Dose");
		   		        builder.setSingleChoiceItems(R.array.meals, -1, new DialogInterface.OnClickListener() {
		   		            public void onClick(DialogInterface dialog, int whichButton) {
		   		                //Log.d(TAG,"E' stato premuto il pulsante: "+fileList[whichButton]);   

		   		           }
		   		       }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
		   	               @Override
		   	               public void onClick(DialogInterface dialog, int id) {
		   	                   // User clicked OK, so save the mSelectedItems results somewhere
		   	                   // or return them to the component that opened the dialog
		   	                   
		   	               }
		   	           })
		   	           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		   	               @Override
		   	               public void onClick(DialogInterface dialog, int id) {
		   	                 
		   	               }
		   	           });;

		   		        


		   		        builder.create();
		   		       builder.show();
		                   
		               }
		           })
		           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		               @Override
		               public void onClick(DialogInterface dialog, int id) {
		                 
		               }
		           });

		        


		        builder.create();
		       builder.show();
			}
		});
		
		
	}
	
	

}

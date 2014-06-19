package com.thunderstick.medreminder;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class Setting extends Activity    {
	
	EditText personname,contacte;
	ImageButton lanuage;
	TextView langselection;
	int val;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		
		personname=(EditText)findViewById(R.id.name);
		contacte=(EditText)findViewById(R.id.conno);
		lanuage=(ImageButton)findViewById(R.id.lang);
		langselection=(TextView)findViewById(R.id.textView1);
		
		lanuage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final ArrayList mSelectedItems = new ArrayList();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						Setting.this);
				builder.setTitle("Select Language");
				builder.setSingleChoiceItems(
						R.array.language,
						-1,
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialog,
									int whichButton) {

							}
						})
						.setPositiveButton(
								"OK",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(
											DialogInterface dialog,
											int id) {

										val = ((AlertDialog) dialog)
												.getListView()
												.getCheckedItemPosition();
										switch (val) {
										case 0:langselection.setText("ENGLISH");
											
											break;


                                       case 1:langselection.setText("SINGHALA");
										
										break;
                                       case 2:langselection.setText("TAMILE");
										
										break;
										}
										 
										

									}
								})
						.setNegativeButton("Cancel",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int id) {

									}
								});
				builder.show();
			}
		});
		
		
	}

	
	
	
	
}

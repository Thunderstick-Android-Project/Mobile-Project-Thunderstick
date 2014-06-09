package com.thunderstick.medreminder;

import java.util.ArrayList;

import com.thunderstick.medreminder.MobileDatabase;
import com.thunderstick.medreminder.Edititem;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Edititem extends Activity {

	TabHost th;
	TabSpec specs;
	
	Button btndone,btnitemimg,btndelete,btndone2;
	EditText txtqty,txtrol,txtamt;
	RadioButton radiotime,radiotimeg;
	TextView rdioresult, itemname;
	
	int val;
	String date, mrng, afnn, nght, sess;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itemedit);


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
		
		btndone=(Button)findViewById(R.id.ed_btndone);
		btnitemimg=(Button)findViewById(R.id.ed_btnitemimg);
		btndelete=(Button)findViewById(R.id.ed_btndelete);
		btndone2=(Button)findViewById(R.id.ed_btndone2);
		
		txtqty=(EditText)findViewById(R.id.ed_txtqty);
		txtrol=(EditText)findViewById(R.id.ed_txtrol);
		txtamt=(EditText)findViewById(R.id.ed_txtamt);
		
		radiotime=(RadioButton)findViewById(R.id.ed_radiotime);
		radiotimeg=(RadioButton)findViewById(R.id.ed_radiotimeg);
		
		rdioresult=(TextView)findViewById(R.id.ed_txtrdioresult);
		itemname=(TextView)findViewById(R.id.ed_name);
		
		
		
		

	radiotimeg.setOnClickListener(new OnClickListener() {


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		final ArrayList mSelectedItems = new ArrayList();
		AlertDialog.Builder builder = new AlertDialog.Builder(
				Edititem.this);
		builder.setTitle("Hours Gap");
		builder.setSingleChoiceItems(R.array.colors_array, -1,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int whichButton) {

					}
				})
				.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int id) {

								val = ((AlertDialog) dialog)
										.getListView()
										.getCheckedItemPosition();

								switch (val) {
								case 0:
									rdioresult.setText("3 Hours");

									break;
								case 1:
									rdioresult.setText("4 Hours");

									break;
								case 2:
									rdioresult.setText("5 Hours");

									break;
								case 3:
									rdioresult.setText("6 Hours");

									break;
								case 4:
									rdioresult.setText("8 Hours");

									break;
								case 5:
									rdioresult.setText("10 Hours");

									break;
								case 6:
									rdioresult.setText("12 Hours");

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
		;

		builder.create();
		builder.show();

	}
});

// itmnm.setText("hb"+val);

radiotime.setOnClickListener(new OnClickListener() {

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		final ArrayList mSelectedItems = new ArrayList();
		AlertDialog.Builder builder = new AlertDialog.Builder(
				Edititem.this);
		builder.setTitle("Select Session");
		builder.setMultiChoiceItems(R.array.checkbx, null,
				new DialogInterface.OnMultiChoiceClickListener() {
					@Override
					public void onClick(DialogInterface dialog,
							int which, boolean isChecked) {
						if (isChecked) {
							// If the user checked the item, add it to
							// the selected items
							mSelectedItems.add(which);
						} else if (mSelectedItems.contains(which)) {
							// Else, if the item is already in the
							// array, remove it
							mSelectedItems.remove(Integer
									.valueOf(which));
						}
					}
		})

		.setPositiveButton("OK",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int id) {

										SparseBooleanArray checked = ((AlertDialog) dialog)
												.getListView()
												.getCheckedItemPositions();
										for (int i = 0; i < checked.size(); i++) {
											int key = checked.keyAt(i);
											boolean value = checked.get(key);
											
											

											switch (key) {
											case 0:
												mrng = ("Morning");

												break;
											case 1:
												afnn = ("Afternoon");

												break;
											case 2:
												nght = ("Night");

												break;

											}
										}
										// tmerslt.setText(""+val);
										sess = (""+mrng+" "+afnn+" "+nght);
		
										final ArrayList mSelectedItems = new ArrayList();
										AlertDialog.Builder builder = new AlertDialog.Builder(
												Edititem.this);
										builder.setTitle("Select Dose");
										builder.setSingleChoiceItems(
												R.array.meals,
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
																case 0:rdioresult.setText("After the Meal");
																	
																	break;

																case 1:rdioresult.setText("Before the Meal");
																
																break;
																}
																 
																

															}
														})
												.setNegativeButton(
														"Cancel",
														new DialogInterface.OnClickListener() {
															@Override
															public void onClick(
																	DialogInterface dialog,
																	int id) {

															}
														});
										;

										builder.create();
										builder.show();

									}
								})
						.setNegativeButton("Cancel",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int id) {

									}
								});

				builder.create();
				builder.show();
			}
		});}}
		
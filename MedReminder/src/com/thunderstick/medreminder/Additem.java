package com.thunderstick.medreminder;

import java.util.ArrayList;
import java.util.Calendar;

import com.thunderstick.medreminder.MobileDatabase;
import com.thunderstick.medreminder.Additem;

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

public class Additem extends Activity {

	TabHost th;
	TabSpec specs;

	EditText itname, qty, rol, amnt;
	Button imagebtn;
	TextView itmnm, tmerslt;
	RadioButton tmeslt, tmegap;

	int val;
	String date, mrng, afnn, nght, sess;

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
		tmerslt = (TextView) findViewById(R.id.ad_txtrdioresult);

		tmegap = (RadioButton) findViewById(R.id.ad_radiotimegap);
		tmeslt = (RadioButton) findViewById(R.id.ad_radiotime);
		
		final Calendar c = Calendar.getInstance();
	    
	    int mDay = c.get(Calendar.DAY_OF_MONTH);
	    int mHour = c.get(Calendar.HOUR_OF_DAY);
	    int mMinute = c.get(Calendar.MINUTE);

	    date = (""+mDay+"/"+mHour+"/"+mMinute+"");
	    //itmnm.setText(""+date);

		tmegap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final ArrayList mSelectedItems = new ArrayList();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						Additem.this);
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
											tmerslt.setText("3 Hours");

											break;
										case 1:
											tmerslt.setText("4 Hours");

											break;
										case 2:
											tmerslt.setText("5 Hours");

											break;
										case 3:
											tmerslt.setText("6 Hours");

											break;
										case 4:
											tmerslt.setText("8 Hours");

											break;
										case 5:
											tmerslt.setText("10 Hours");

											break;
										case 6:
											tmerslt.setText("12 Hours");

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

		tmeslt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final ArrayList mSelectedItems = new ArrayList();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						Additem.this);
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
												Additem.this);
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
																case 0:tmerslt.setText("After the Meal");
																	
																	break;

																case 1:tmerslt.setText("Before the Meal");
																
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
		});
		
		imagebtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				boolean didItWork = true;
				
				
				String mdname = itname.getText().toString();
				Integer quty = Integer.parseInt(qty.getText().toString());
				Integer reol = Integer.parseInt(rol.getText().toString());
				Integer amount = Integer.parseInt(amnt.getText().toString());
				String tmgap =  tmerslt.getText().toString();
				String session = sess;
				String adddate = date;
				String meal = tmerslt.getText().toString();

				MobileDatabase db = new MobileDatabase(Additem.this);
				try {
					db.open();

					db.insertNewItem(mdname, quty, reol, adddate, meal);
					db.insertNewSchedule(mdname, session, tmgap, amount);

					db.close();
				} catch (Exception e) {
					didItWork = false;
					String error = e.toString();
					Dialog d = new Dialog(Additem.this);
					d.setTitle("Error!");
					TextView tv = new TextView(Additem.this);
					tv.setText("InCompleted");
					d.setContentView(tv);
					d.show();
				} finally {
					if (didItWork) {
						Dialog d = new Dialog(Additem.this);
						d.setTitle("Success");
						TextView tv = new TextView(Additem.this);
						tv.setText("Completed");
						d.setContentView(tv);
						d.show();
					}

				}
			}
		});
		
	}

}

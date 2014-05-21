package com.thunderstick.medreminder;

import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Edititem extends Activity implements OnClickListener{

	TabHost th;
	TabSpec specs;
	Button btndone,btnitemimg,btndelete,btndone2;
	EditText txtitemname,txtqty,txtrol,txtname,txthr,txtamt;
	RadioButton radiotime,radiobef,radioaft,radiotimeg;
	CheckBox checkmor,checkafter,checknight;
    TextView rdioresult;
	
	int val;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.itemedit);

		th = (TabHost) findViewById(R.id.tabhost);
		
		btndone=(Button)findViewById(R.id.ed_btndone);
		btnitemimg=(Button)findViewById(R.id.ed_btnitemimg);
		btndelete=(Button)findViewById(R.id.ed_btndelete);
		btndone2=(Button)findViewById(R.id.ed_btndone2);
		
		txtitemname=(EditText)findViewById(R.id.ed_txtitemname);
		txtqty=(EditText)findViewById(R.id.ed_txtqty);
		txtrol=(EditText)findViewById(R.id.ed_txtrol);
		txtname=(EditText)findViewById(R.id.ed_txtname);
		txthr=(EditText)findViewById(R.id.ed_txthr);
		txtamt=(EditText)findViewById(R.id.ed_txtamt);
		
		radiotime=(RadioButton)findViewById(R.id.ed_radiotime);
		radiobef=(RadioButton)findViewById(R.id.ed_radiobef);
		radioaft=(RadioButton)findViewById(R.id.ed_radioaft);
		radiotimeg=(RadioButton)findViewById(R.id.ed_radiotimeg);
		
		checkmor=(CheckBox)findViewById(R.id.ed_checkmor);
		checkafter=(CheckBox)findViewById(R.id.ed_checkafter);
		checknight=(CheckBox)findViewById(R.id.ed_checknight);
		
		rdioresult=(TextView)findViewById(R.id.ed_txtrdioresult);

		th.setup();
		specs = th.newTabSpec("tag1");// just set it up
		specs.setContent(R.id.Item);
		specs.setIndicator("Item");
		th.addTab(specs);

		specs = th.newTabSpec("tag2");// just set it up
		specs.setContent(R.id.Shedule);
		specs.setIndicator("Shedule");
		th.addTab(specs);
		
		btndone.setOnClickListener(this);
	}


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
		

		builder.create();
		builder.show();

	}
}


		
		

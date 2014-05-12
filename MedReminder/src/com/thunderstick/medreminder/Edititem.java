package com.thunderstick.medreminder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Edititem extends Activity {

	TabHost th;
	TabSpec specs;
	Button btndone,btnitemimg,btndelete,btndone2;
	EditText txtitemname,txtqty,txtrol,txtname,txthr,txtamt;
	RadioButton radiotime,radiobef,radioaft,radiotimeg;
	CheckBox checkmor,checkafter,checknight;
	

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

		th.setup();
		specs = th.newTabSpec("tag1");// just set it up
		specs.setContent(R.id.Item);
		specs.setIndicator("Item");
		th.addTab(specs);

		specs = th.newTabSpec("tag2");// just set it up
		specs.setContent(R.id.Shedule);
		specs.setIndicator("Shedule");
		th.addTab(specs);
	}

}

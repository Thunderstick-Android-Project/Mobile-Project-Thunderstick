package com.thunderstick.medreminder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Additem extends Activity{

	TabHost th;
	TabSpec specs;
	EditText itname, itqty, itrol, iname, ithours, itamnt;
	Button image, done;
	RadioButton tmeslt, tmegap, befoer, after;
	CheckBox morning, evening, night;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.itemadd);
		
		image = (Button) findViewById(R.id.ad_btnitemimg);
		done = (Button) findViewById(R.id.ad_btndone);
		
		itname = (EditText) findViewById(R.id.ad_txtitemname);
		itqty = (EditText) findViewById(R.id.ad_txtqty);
		itrol = (EditText) findViewById(R.id.ad_txtrol);
		iname = (EditText) findViewById(R.id.ad_txtname);
		ithours = (EditText) findViewById(R.id.ad_txthr);
		itamnt = (EditText) findViewById(R.id.ad_txtamt);
		
		tmeslt = (RadioButton) findViewById(R.id.ad_radiotime);
		tmegap = (RadioButton) findViewById(R.id.ad_radiotimeg);
		befoer = (RadioButton) findViewById(R.id.ad_radiobef);
		after = (RadioButton) findViewById(R.id.ad_radioaft);
		
		morning = (CheckBox) findViewById(R.id.ad_checkmor);
		evening = (CheckBox) findViewById(R.id.ad_checkafter);
		night = (CheckBox) findViewById(R.id.ad_checknight);

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
	}

	public Additem() {
		// TODO Auto-generated constructor stub
	}

}

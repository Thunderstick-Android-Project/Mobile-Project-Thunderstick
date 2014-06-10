package com.thunderstick.medreminder;

import com.thunderstick.medreminder.controls.Carousel;
import com.thunderstick.medreminder.controls.CarouselAdapter;
import com.thunderstick.medreminder.controls.CarouselItem;
import com.thunderstick.medreminder.controls.CarouselAdapter.OnItemClickListener;
import com.thunderstick.medreminder.controls.CarouselAdapter.OnItemSelectedListener;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class Rotator extends Activity {
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.rotator);
	        Carousel carousel = (Carousel)findViewById(R.id.carousel);
	        carousel.setOnItemClickListener(new OnItemClickListener(){

				public void onItemClick(CarouselAdapter<?> parent, View view,
						int position, long id) {	
					
					Toast.makeText(Rotator.this, 
							String.format("%s has been clicked", 
							((CarouselItem)parent.getChildAt(position)).getName()), 
							Toast.LENGTH_SHORT).show();		
					String name=((CarouselItem)parent.getChildAt(position)).getName();
					Intent i=new Intent("com.thunderstick.medreminder."+name);
					startActivity(i);
				}
	        	
	        });

	        
	    }
}

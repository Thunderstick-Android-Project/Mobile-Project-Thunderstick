package com.thunderstick.medreminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Thread timer = new Thread(){
			public void run() {
				try{
					sleep(2000);
			} 
				catch(InterruptedException ex){
					ex.printStackTrace();
			}
				finally{
				
					Intent openStartingPoint = new Intent("com.thunderstick.medreminder.Rotator");
					startActivity(openStartingPoint);
			}
			}
		};
		timer.start();
	}
}
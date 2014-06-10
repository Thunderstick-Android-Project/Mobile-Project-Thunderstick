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
				
<<<<<<< HEAD
					Intent openStartingPoint = new Intent("com.thunderstick.medreminder.Setting");
=======
					Intent openStartingPoint = new Intent("com.thunderstick.medreminder.Rotator");
>>>>>>> bb3a4b17e96daed37f93beb01f101b98e97fb5cb
					startActivity(openStartingPoint);
			}
			}
		};
		timer.start();
	}
}
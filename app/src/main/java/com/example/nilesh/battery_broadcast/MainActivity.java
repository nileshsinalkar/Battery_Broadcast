package com.example.nilesh.battery_broadcast;


import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {


            private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
       @Override

                public void onReceive(Context c, Intent i) {

           int level = i.getIntExtra("level", 0);
          //Find the progressbar creating in main.xml
            ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
          //Set progress level with battery % value
            pb.setProgress(level);
           //Find textview control created in main.xml
          TextView tv = (TextView) findViewById(R.id.textView);
           //Set TextView with text
          tv.setText("Battery Level: " + Integer.toString(level) + "%");
         }

};

   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        //Set layout we created
       setContentView(R.layout.activity_main);
       //when battery charge is changed
      registerReceiver(mBatInfoReceiver, new IntentFilter(
                Intent.ACTION_BATTERY_CHANGED));
        }
}

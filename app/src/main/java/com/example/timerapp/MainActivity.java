package com.example.timerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Method 1
        /*
        final Handler handler= new Handler();
        Runnable run=new Runnable() {
            @Override
            public void run() {
                Log.i("Hey it's us","A second has passed");
                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);*/

        final TextView textView=(TextView)findViewById(R.id.textView);
        //Method 2 (preferable)
        new CountDownTimer(10000,100){

            public void onTick(long milliSecondsUntilDone){
                Log.i("Seconds left",String.valueOf(milliSecondsUntilDone/1000)+"."+String.valueOf(milliSecondsUntilDone/100));
                textView.setText(String.valueOf(milliSecondsUntilDone/1000));
            }
            public void onFinish(){
                Log.i("We are done","No more countdown");
                textView.setText("No more Countdown");
            }
        }.start();

    }
}
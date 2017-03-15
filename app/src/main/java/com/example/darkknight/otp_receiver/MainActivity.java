package com.example.darkknight.otp_receiver;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    MyReceiver SmsListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int GET_MY_PERMISSION = 1;
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_SMS)) {
            /* do nothing*/
            } else {

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_SMS}, GET_MY_PERMISSION);
            }
        }

        Log.d("karan", "in onResume");
        IntentFilter i = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(new MyReceiver(),i);


    }




  /*  @Override
    protected void onResume() {
        super.onResume();
        Log.d("karan", "in onResume");
        IntentFilter i = new IntentFilter(
                "android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(SmsListener, i);
    }
*/
/*
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(SmsListener);
    }*/
}

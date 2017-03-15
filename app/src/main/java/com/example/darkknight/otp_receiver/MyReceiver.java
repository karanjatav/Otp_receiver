package com.example.darkknight.otp_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DARKKNIGHT on 3/15/2017.
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String msgBody = "karan, blah blah";
        Log.d("karan", msgBody);
        Toast.makeText(context, msgBody, Toast.LENGTH_LONG).show();

        Pattern p = Pattern.compile("(|^)\\d{5}");


        Bundle bundle = intent.getExtras(); // ---get the SMS message
        // passed in---
        SmsMessage[] msgs = null;
        // String msg_from;
        if (bundle != null) {
            // ---retrieve the SMS message received---
            try {
                Object[] pdus = (Object[]) bundle.get("pdus");
                msgs = new SmsMessage[pdus.length];
                for (int i = 0; i < msgs.length; i++) {
                    msgs[i] = SmsMessage
                            .createFromPdu((byte[]) pdus[i]);
                    // msg_from = msgs[i].getOriginatingAddress();
                    msgBody = msgs[i].getMessageBody();

                }

                Pattern pattern = Pattern.compile("(\\d{5})");

//   \d is for a digit
//   {} is the number of digits here 4.

                Matcher matcher = pattern.matcher(msgBody);
                String val = "";
                if (matcher.find()) {
                    val = matcher.group(1);  // 4 digit number
                    Log.d("karan otp",val);
                }
            } catch (Exception e) {
                // Log.d("Exception caught",e.getMessage());
            }
        }
    }
}


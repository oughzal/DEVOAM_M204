package com.omarcomputer.broadcastreceivers.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i("BroadcastReceiverTAG","Action : " + intent.getAction());
        Toast.makeText(context, "Action : " + intent.getAction(), Toast.LENGTH_SHORT).show();
        switch (action){
            case Intent.ACTION_BATTERY_LOW :
                break;
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                break;
            case "com.omarcomputer.ACTION_MON_BROADCAST_PERSONNALISE" :
                break;
        }

    }
}

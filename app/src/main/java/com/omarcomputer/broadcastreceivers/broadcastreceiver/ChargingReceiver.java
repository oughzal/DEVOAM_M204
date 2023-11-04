package com.omarcomputer.broadcastreceivers.broadcastreceiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.omarcomputer.broadcastreceivers.R;

public class ChargingReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i("BroadcastReceiverTAG","Action : " + intent.getAction());
        Toast.makeText(context, "Action : " + intent.getAction(), Toast.LENGTH_SHORT).show();

    }
}

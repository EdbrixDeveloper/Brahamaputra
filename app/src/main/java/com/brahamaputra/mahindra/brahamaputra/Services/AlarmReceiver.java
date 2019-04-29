package com.brahamaputra.mahindra.brahamaputra.Services;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;


public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context, "ALARM!! ALARM!!", Toast.LENGTH_SHORT).show();
        Log.e(AlarmReceiver.class.getName(),":: onReceive");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (!isAppOnForeground(context)){
                context.startForegroundService(new Intent(context, AlarmSoundService.class));
            }
        } else {
            context.startService(new Intent(context, AlarmSoundService.class));
        }

        //Stop sound service to play sound for alarm
        //context.startService(new Intent(context, AlarmSoundService.class));

        //This will send a notification message and show notification in notification tray
        ComponentName comp = new ComponentName(context.getPackageName(), NotifyService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));

    }

    private boolean isAppOnForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        final String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }
}
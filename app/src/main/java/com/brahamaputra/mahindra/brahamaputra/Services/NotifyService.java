package com.brahamaputra.mahindra.brahamaputra.Services;


import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.NotificationUtils;
import com.brahamaputra.mahindra.brahamaputra.Activities.PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;


import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class NotifyService extends Service {
    Timer repeatTask = new Timer();
    int repeatInterval = 10000; // 10 sec
    SessionManager sessionManager;
    SimpleDateFormat df = new SimpleDateFormat("HH:mm");

    boolean flag = false;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service created!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        Log.d("ON Service", "Service stopped");
        this.stopSelf();
        repeatTask.cancel();

    }

    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show();
        sessionManager = new SessionManager(this);

        repeatTask.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Log.d("ON Service", "Service created!");
                Calendar now = Calendar.getInstance();
                try {

                    Log.d("Pref :", sessionManager.getSessionBBTestReportTime().toString());
                    Log.d("Time :", df.format(now.getTime()));
                    String nowTime = df.format(now.getTime());

                    Date date1 = df.parse(sessionManager.getSessionBBTestReportTime().toString());
                    Date date2 = df.parse(nowTime);

                    long difference = date2.getTime() - date1.getTime();
                    long days = (int) (difference / (1000 * 60 * 60 * 24));
                    long hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
                    long min = (int) (difference - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours))
                            / (1000 * 60);

                    Log.i("======= min", " :: " + min);

                    if (!flag) {
                        Log.d("Flag :", String.valueOf(flag));
                        if (min >= 0) {
                            if (!isAppIsInBackground(getApplicationContext())) {
                                setNotificationGeneration();
                            }
                            flag = true;
                        }
                    } else {
                        Log.d("Flag :", String.valueOf(flag));
                        onDestroy();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }, 0, repeatInterval);
    }

    private void setNotificationGeneration() {
        Bitmap icon = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.applogo);
        Intent resultIntent = new Intent(getApplicationContext(), PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0 /* Request code */, resultIntent, PendingIntent.FLAG_ONE_SHOT);

        String channelId = getString(R.string.default_notification_channel_id);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getApplicationContext(), channelId)
                        .setLargeIcon(icon)
                        .setSmallIcon(R.drawable.applogo)//.setSmallIcon(R.drawable.ic_circle)
                        .setContentTitle("Battery Bank Test Report")//.setContentTitle(getString(R.string.fcm_message))
                        .setContentText("Please take a next reading")
                        //.setGroup(getApplicationContext().getPackageName())
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        final int SIMPLE_NOTIFICATION_RANDOM_ID = new Random().nextInt(851) + 90;
        notificationManager.notify(SIMPLE_NOTIFICATION_RANDOM_ID /* ID of notification */, notificationBuilder.build());

    }

    public static boolean isAppIsInBackground(Context context) {
        boolean isInBackground = true;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
                if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    for (String activeProcess : processInfo.pkgList) {
                        if (activeProcess.equals(context.getPackageName())) {
                            isInBackground = false;
                        }
                    }
                }
            }
        } else {
            List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
            ComponentName componentInfo = taskInfo.get(0).topActivity;
            if (componentInfo.getPackageName().equals(context.getPackageName())) {
                isInBackground = false;
            }
        }

        return isInBackground;
    }
}

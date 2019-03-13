package com.brahamaputra.mahindra.brahamaputra.Services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Activities.DashboardCircularActivity;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.NotificationUtils;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.JsonRequest;
import com.brahamaputra.mahindra.brahamaputra.Volley.SettingsMy;
import com.brahamaputra.mahindra.brahamaputra.app.Config;
import com.brahamaputra.mahindra.brahamaputra.helper.DatabaseHelper;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class GoogleFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FirebaseMsgService";
    private NotificationUtils notificationUtils;

    private LocalBroadcastManager localBroadcastManager;
    private final String SERVICE_RESULT = "com.service.result";
    private final String SERVICE_MESSAGE = "com.service.message";
    private SessionManager sessionManager;

    @Override
        public void onNewToken(String s) {
            super.onNewToken(s);
            //doNewToken(sessionManager.getSessionDeviceToken(),s);
            sessionManager = new SessionManager(this);
            if(!(sessionManager.getSessionUserId().equals("")) && !(sessionManager.getSessionDeviceToken().equals("")))
            {
                doNewToken("",s,sessionManager);
            }else{
                sessionManager.updateSessionFCMToken(s);
            }
            Log.d(TAG,"NewToken: "+s);


    }

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // [START_EXCLUDE]
        // There are two types of messages data messages and notification messages. Data messages
        // are handled
        // here in onMessageReceived whether the app is in the foreground or background. Data
        // messages are the type
        // traditionally used with GCM. Notification messages are only received here in
        // onMessageReceived when the app
        // is in the foreground. When the app is in the background an automatically generated
        // notification is displayed.
        // When the user taps on the notification they are returned to the app. Messages
        // containing both notification
        // and data payloads are treated as notification messages. The Firebase console always
        // sends notification
        // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
        // [END_EXCLUDE]

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            try {
                JSONObject json = new JSONObject(remoteMessage.getData().toString());
                handleDataMessage(json);
            } catch (Exception e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }

            /*if ( *//*Check if data needs to be processed by long running job *//* true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                scheduleJob();
            } else {
                // Handle message within 10 seconds
                //handleNow();
                try {
                    JSONObject json = new JSONObject(remoteMessage.getData().toString());
                    handleDataMessage(json);
                } catch (Exception e) {
                    Log.e(TAG, "Exception: " + e.getMessage());
                }
            }*/

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            //Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            Log.e(TAG, "Notification Body: " + remoteMessage.getNotification().getBody());
            handleNotification(remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.

    }
    // [END receive_message]


    // [START on_new_token]

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    /*@Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(token);
    }*/
    // [END on_new_token]

    /**
     * Schedule a job using FirebaseJobDispatcher.
     */
    private void scheduleJob() {
        // [START dispatch_job]
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));
        Job myJob = dispatcher.newJobBuilder()
                .setService(GoogleJobService.class)
                .setTag("my-job-tag")
                .build();
        dispatcher.schedule(myJob);
        // [END dispatch_job]
    }

    /**
     * Handle time allotted to BroadcastReceivers.
     */
    private void handleNow() {
        Log.d(TAG, "Short lived task is done.");
    }

    /**
     * Persist token to third-party servers.
     * <p>
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to your app server.
    }

    /**
     * Create and show a simple notification containing the received FCM message.
     */
    //private void sendNotification(String messageBody) {
    private void sendNotification(Context context, String title, String message, String timeStamp, Intent intent) {
        Bitmap icon = BitmapFactory.decodeResource(this.getResources(), R.drawable.applogo);

        //Intent intent = new Intent(this, DashboardActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent, PendingIntent.FLAG_ONE_SHOT);

        String channelId = getString(R.string.default_notification_channel_id);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setLargeIcon(icon)
                        .setSmallIcon(R.drawable.applogo)//.setSmallIcon(R.drawable.ic_circle)
                        .setContentTitle(title)//.setContentTitle(getString(R.string.fcm_message))
                        .setContentText(message)
                        //.setGroup(getApplicationContext().getPackageName())
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);
        //.setGroupSummary(true);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(context.NOTIFICATION_SERVICE);

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

    /*********************************/
    private void handleNotification(String message) {
        if (!NotificationUtils.isAppIsInBackground(getApplicationContext())) {
            // app is in foreground, broadcast the push message
            Intent pushNotification = new Intent(Config.PUSH_NOTIFICATION);
            pushNotification.putExtra("message", message);
            LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);
            // play notification sound
            NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
            notificationUtils.playNotificationSound();
        } else {
            // If the app is in background, firebase itself handles the notification
        }
    }

    private void handleDataMessage(JSONObject json) {
        Log.e(TAG, "push json: " + json.toString());
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        try {
            JSONObject data = json.getJSONObject("data");

            String typeId = data.getString("typeId");
            String title = data.getString("title");
            String tempMsg = String.valueOf(Html.fromHtml(data.getString("message"), null, null));
            String message = tempMsg.replaceAll("\\[", "").replaceAll("\\]","");
            boolean isBackground = data.getBoolean("is_background");
            String imageUrl = data.getString("image");
            String timestamp = data.getString("timestamp");
            JSONObject payload = data.getJSONObject("payload");
            String fundTransfered;

            String hototicketid = "";
            if (payload.has("hototicketdetails")) {
                JSONObject hototicketdetails = payload.getJSONObject("hototicketdetails");
                if(hototicketdetails.has("hototicketid"))
                {
                    hototicketid = hototicketdetails.getString("hototicketid");
                }else if(hototicketdetails.has("Fund Transfered")){
                    fundTransfered = hototicketdetails.getString("Fund Transfered");
                }else {
                    hototicketid = "";
                    fundTransfered = "";
                }
            } else {
                Log.e(TAG, "HototicketDetails No...");
            }

            //JSONObject hototicketdetails = payload.getJSONObject("hototicketdetails");
            //String hototicketid = hototicketdetails.getString("hototicketid");
            Intent resultIntent;
            /*if (!hototicketid.isEmpty() && hototicketid != null)
                resultIntent = new Intent(getApplicationContext(), UsersHotoListActivity.class);
            else
                resultIntent = new Intent(getApplicationContext(), DashboardCircularActivity.class);*/

            ///////////////////////Handling Type Of Notification////////////////////

            if (typeId.equals("1")) {

                resultIntent = new Intent(getApplicationContext(), DashboardCircularActivity.class);
                resultIntent.putExtra("typeId", typeId);
                resultIntent.putExtra("title", title);
                resultIntent.putExtra("msg", message.replaceAll("\\[", "").replaceAll("\\]",""));
                resultIntent.putExtra("timestamp", timestamp);

            } else if (typeId.equals("2")) {

                resultIntent = new Intent(getApplicationContext(), DashboardCircularActivity.class);
                resultIntent.putExtra("typeId", typeId);

            } else if (typeId.equals("3")) {

                resultIntent = new Intent(getApplicationContext(), DashboardCircularActivity.class);
                resultIntent.putExtra("typeId", typeId);

            } else if (typeId.equals("4")) {

                resultIntent = new Intent(getApplicationContext(), DashboardCircularActivity.class);
                resultIntent.putExtra("typeId", typeId);

            } else {

                resultIntent = new Intent(getApplicationContext(), DashboardCircularActivity.class);
                resultIntent.putExtra("typeId", 0);

            }

            ////////////////////////////////////////////////////////////////
            //{"hototicketdetails":{"hototicketid":"1"}}
            //

            Log.e(TAG, "title: " + title);
            Log.e(TAG, "message: " + message);
            Log.e(TAG, "isBackground: " + isBackground);
            Log.e(TAG, "payload: " + payload.toString());
            Log.e(TAG, "imageUrl: " + imageUrl);
            Log.e(TAG, "timestamp: " + timestamp);

            databaseHelper.insert(title, message, timestamp);

            if (!NotificationUtils.isAppIsInBackground(getApplicationContext())) {
                // app is in foreground, broadcast the push message
                //Intent pushNotification = new Intent(Config.PUSH_NOTIFICATION);
                //pushNotification.putExtra("message", message);
                LocalBroadcastManager.getInstance(this).sendBroadcast(resultIntent);

                //0008
                localBroadcastManager = LocalBroadcastManager.getInstance(this);
                //0008


                // play notification sound
                NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
                notificationUtils.playNotificationSound();
                sendNotification(getApplicationContext(), title, message, timestamp, resultIntent);

                sendResult("receive");//0008 for notification list update

            } else {
                // app is in background, show the notification in notification tray

                //Intent resultIntent = new Intent(getApplicationContext(), UsersHotoListActivity.class);//DashboardCircularActivity
                //resultIntent.putExtra("message", message);

                // check for image attachment
                if (TextUtils.isEmpty(imageUrl)) {
                    showNotificationMessage(getApplicationContext(), title, message, timestamp, resultIntent);
                } else {
                    // image is present, show notification with image
                    showNotificationMessageWithBigImage(getApplicationContext(), title, message, timestamp, resultIntent, imageUrl);
                }
            }

            /*if (!NotificationUtils.isAppIsInBackground(getApplicationContext())) {
                // app is in foreground, broadcast the push message
                Intent pushNotification = new Intent(Config.PUSH_NOTIFICATION);
                pushNotification.putExtra("message", message);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);

                //0008
                localBroadcastManager = LocalBroadcastManager.getInstance(this);
                //0008


                // play notification sound
                NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
                notificationUtils.playNotificationSound();
                sendNotification(getApplicationContext(), title, message, timestamp, pushNotification);

                sendResult("receive");//0008 for notification list update

            } else {
                // app is in background, show the notification in notification tray

                Intent resultIntent = new Intent(getApplicationContext(), UsersHotoListActivity.class);//DashboardCircularActivity
                resultIntent.putExtra("message", message);

                // check for image attachment
                if (TextUtils.isEmpty(imageUrl)) {
                    showNotificationMessage(getApplicationContext(), title, message, timestamp, resultIntent);
                } else {
                    // image is present, show notification with image
                    showNotificationMessageWithBigImage(getApplicationContext(), title, message, timestamp, resultIntent, imageUrl);
                }
            }*/


        } catch (JSONException e) {
            Log.e(TAG, "Json Exception: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
    }

    /**
     * Showing notification with text only
     */
    private void showNotificationMessage(Context context, String title, String message, String timeStamp, Intent intent) {
        notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, timeStamp, intent);
        sendNotification(context, title, message, timeStamp, intent);
    }

    /**
     * Showing notification with text and image
     */
    private void showNotificationMessageWithBigImage(Context context, String title, String message, String timeStamp, Intent intent, String imageUrl) {
        notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, timeStamp, intent, imageUrl);
        sendNotification(context, title, message, timeStamp, intent);

    }


    private void sendResult(String message) {
        Intent intent = new Intent(SERVICE_RESULT);
        if (message != null)
            intent.putExtra(SERVICE_MESSAGE, message);
        localBroadcastManager.sendBroadcast(intent);
    }

    private void doNewToken(String prvToken, final String newToken,final SessionManager sessionManager) {

        if(!prvToken.equals(newToken))
        {
            try {
                JSONObject jo = new JSONObject();
                try {
                    jo.put("UserId", sessionManager.getSessionUserId());
                    jo.put("AccessToken", sessionManager.getSessionDeviceToken());
                    jo.put("DeviceId", Constants.androidDeviceid);
                    jo.put("DeviceToken", newToken);

                } catch (JSONException e) {
                    Log.e(GoogleFirebaseMessagingService.class.getName(), e.getMessage().toString());
                    return;
                }

                Log.e(GoogleFirebaseMessagingService.class.getName(),"In the doNewToken() :"+jo.toString());

                JsonRequest doNewToken = new JsonRequest(Request.Method.POST, Constants.updatedevicetoken, jo,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(@NonNull JSONObject response) {
                                try {
                                if (response != null) {
                                    if (response.has("Success")) {
                                        int success = response.getInt("Success");
                                        if (success == 1) {
                                            sessionManager.updateSessionFCMToken(newToken);
                                        } else {

                                        }
                                    }
                                }
                                } catch (Exception e) {
                                    Log.e(GoogleFirebaseMessagingService.class.getName(),"Exception :" + e.getMessage());
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //showToast(SettingsMy.getErrorMessage(error));
                        Log.e(GoogleFirebaseMessagingService.class.getName(),"onErrorResponse :" + SettingsMy.getErrorMessage(error));
                    }
                });
                doNewToken.setRetryPolicy(Application.getDefaultRetryPolice());
                doNewToken.setShouldCache(false);
                Application.getInstance().addToRequestQueue(doNewToken, "doNewToken");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

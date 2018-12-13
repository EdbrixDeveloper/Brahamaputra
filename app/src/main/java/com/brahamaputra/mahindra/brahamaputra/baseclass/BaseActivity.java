package com.brahamaputra.mahindra.brahamaputra.baseclass;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.Activities.Land_Details;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Utils.NotificationUtils;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;

import com.brahamaputra.mahindra.brahamaputra.app.Config;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.DialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.commons.ToastMessage;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;

import java.io.IOException;

/**
 * Created by rajk
 */
public class BaseActivity extends AppCompatActivity {

    //    ConnectivityMonitor connectivityMonitor;
    protected Context mContext;
    protected OnFragmentBackPressedListener onFragmentBackPressedListener;
    DialogManager dialogManager;
    GlobalMethods globalMethods;
    private ToastMessage toastMessage;
    private SessionManager sessionManager;

    public static String TicketID = "TKT_0";

    public static String checkOutBatteryData = "0";
    public static String checkInBatteryData = "0";

    public static boolean isDuplicateQRcode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManager(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        dialogManager = new DialogManager(this);
        globalMethods = new GlobalMethods();
        toastMessage = new ToastMessage(this);
//        connectivityMonitor = new ConnectivityMonitor(this, erisConnectionListener);
        mContext = this;

        displayFirebaseRegId();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
//        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
//                new IntentFilter(Config.PUSH_NOTIFICATION));
        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(getApplicationContext());
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }

    protected void showToast(String msg, int timeDuration) {
        toastMessage.showToastMsg(msg, timeDuration);
    }

    protected void showToast(String msg) {
        toastMessage.showToastMsg(msg, Toast.LENGTH_LONG);
    }

    protected void cancelToast() {
        toastMessage.cancelToast();
    }

    protected AlertDialogManager getAlertDialogManager() {
        return dialogManager.getAlertDialogManager();
    }

    protected GlobalMethods getGlobalMethods() {
        return globalMethods;
    }

    protected void showBusyProgress() {
        dialogManager.showBusyProgress();
    }

    protected void showBusyProgress(String message) {
        dialogManager.showBusyProgress(message);
    }

    protected void hideBusyProgress() {
        dialogManager.hideBusyProgress();
    }

    protected void onNetworkStatusChanged(boolean status) {

    }

    public void setOnFragmentBackPressedListener(OnFragmentBackPressedListener onFragmentBackPressedListener) {
        this.onFragmentBackPressedListener = onFragmentBackPressedListener;
    }

    protected boolean isTablet() {
        boolean xlarge = ((this.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_XLARGE);
        boolean large = ((this.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE);
        return (xlarge || large);
    }

    protected int getScreenOrientation() {
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        return display.getRotation();
    }

    public interface OnFragmentBackPressedListener {
        public void doBack();
    }

    protected BroadcastReceiver mRegistrationBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            // checking for type intent filter
            if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                // gcm successfully registered
                // now subscribe to `global` topic to receive app wide notifications
                FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);

                displayFirebaseRegId();

            } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                // new push notification is received

                String message = intent.getStringExtra("message");

                showToast("Push notification: " + message);

            }
        }
    };

    // Fetches reg id from shared preferences
    // and displays on the screen
    private void displayFirebaseRegId() {

        String regId =sessionManager.getSessionFCMToken();

        Log.e("BaseActivity", "Firebase reg id: " + regId);

//        if (!TextUtils.isEmpty(regId))
//            showToast("Firebase Reg Id: " + regId);
//        else
//            showToast("Firebase Reg Id is not received yet!");

    }

    public boolean isDuplicateQRcode (String strQrcode){

        OfflineStorageWrapper offlineStorageWrapper;
        HotoTransactionData hotoTransactionData = null;

        String ticketId = sessionManager.getSessionUserTicketId();
        String ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        String userId = sessionManager.getSessionUserId();

        offlineStorageWrapper = OfflineStorageWrapper.getInstance(this, userId, ticketName);
        //hotoTransactionData = new HotoTransactionData();

        try {
            String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");
            Gson gson = new Gson();
            hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ///Air Conditioners*
        for(int i=0;i<hotoTransactionData.getAirConditionParentData().getAirConditionersData().size();i++){
            if(hotoTransactionData.getAirConditionParentData().getAirConditionersData().get(i).getqRCodeScan().contains(strQrcode)){
                return true;
            }
        }

        ///Solar Power System*
        if(hotoTransactionData.getSolarPowerSystemData().getqRCodeScan().contains(strQrcode)){
            return true;
        }

        ///Power Plant*
        for(int i=0;i<hotoTransactionData.getPowerPlantDetailsParentData().getPowerPlantDetailsData().size();i++){
            if(hotoTransactionData.getPowerPlantDetailsParentData().getPowerPlantDetailsData().get(i).getqRCodeScan().contains(strQrcode)){
                return true;
            }else{
                for(int j=0;j<hotoTransactionData.getPowerPlantDetailsParentData().getPowerPlantDetailsData().get(i).getPowerPlantDetailsModulesData().size();j++){
                    if(hotoTransactionData.getPowerPlantDetailsParentData().getPowerPlantDetailsData().get(i).getPowerPlantDetailsModulesData().get(j).getModuleQrCodeScan().equals(strQrcode)){
                        return true;
                    }
                }
            }
        }

        ///Power Backups (DG)*
        for(int i=0;i<hotoTransactionData.getPowerBackupsDGParentData().getPowerBackupsDGData().size();i++){
            if(hotoTransactionData.getPowerBackupsDGParentData().getPowerBackupsDGData().get(i).getqRCodeScan().contains(strQrcode)){
                return true;
            }
        }

        ///Battery Set*
        for(int i=0;i<hotoTransactionData.getBatterySetParentData().getBatterySetData().size();i++){
            if(hotoTransactionData.getBatterySetParentData().getBatterySetData().get(i).getBatterySet_Qr().contains(strQrcode)){
                return true;
            }
        }

        ///Power mgmt System*
        if (hotoTransactionData.getPowerManagementSystemData().getPowerManagementSystemQR().contains(strQrcode)) {
            return true;
        }

        ///Server Stabilizer
        if (hotoTransactionData.getServoStabilizerData().getServoStabilizer_Qr().contains(strQrcode)) {
            return true;
        }

        return false;
    }
}

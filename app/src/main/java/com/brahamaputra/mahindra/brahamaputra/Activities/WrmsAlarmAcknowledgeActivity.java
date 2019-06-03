package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.brahamaputra.mahindra.brahamaputra.Data.BatteryType;
import com.brahamaputra.mahindra.brahamaputra.Data.PreventiveMaintanceSiteTransactionDetails;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GPSTracker;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;

import java.util.ArrayList;

public class WrmsAlarmAcknowledgeActivity extends BaseActivity {

    private EditText mWrmsAlarmAcknowledgeEditTextCircle;
    private EditText mWrmsAlarmAcknowledgeEditTextState;
    private EditText mWrmsAlarmAcknowledgeEditTextSsa;
    private EditText mWrmsAlarmAcknowledgeEditTextSiteID;
    private EditText mWrmsAlarmAcknowledgeEditTextNameOfSite;
    private EditText mWrmsAlarmAcknowledgeEditTextAlarmTicketNumber;
    private EditText mWrmsAlarmAcknowledgeEditTextAlarmDescription;
    private EditText mWrmsAlarmAcknowledgeEditTextAlarmSeverity;
    private EditText mWrmsAlarmAcknowledgeEditTextAlarmOccurrenceTime;
    private Button mWrmsAlarmAcknowledgeButtonAcknowledge;


    private static final String TAG = WrmsAlarmAcknowledgeActivity.class.getSimpleName();

    public static final int RESULT_PRIVENTIVE_MAINTENANCE_SITE_READING = 258;
    public GPSTracker gpsTracker;

    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "";
    private String ticketName = "";
    private String ticketId = "";
    private SessionManager sessionManager;

    private String checkInLat = "0.0";
    private String checkInLong = "0.0";
    private String checkInBatteryData = "0";

    private String checkOutLat = "0.0";
    private String checkOutLong = "0.0";
    private String checkOutBatteryData = "0";

    public double siteLongitude = 0.0;
    public double siteLatitude = 0.0;

    private AlertDialogManager alertDialogManager;
    private PreventiveMaintanceSiteTransactionDetails preventiveMaintanceSiteTransactionDetails;

    private String sitePMTicketStatus;
    ArrayList<BatteryType> batteryType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrms_alarm_acknowledge);
        assignViews();
        this.setTitle("WRMS Alarm Acknowledge");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /*Intent intent = getIntent();
        String id = intent.getStringExtra("ticketNO");
        sitePMTicketStatus = intent.getStringExtra("status");
        this.setTitle(id);

        //ticketId = intent.getStringExtra("ticketNO");
        //this.setTitle(ticketId);
        checkInLat = intent.getStringExtra("latitude");
        checkInLong = intent.getStringExtra("longitude");*/

        /*alertDialogManager = new AlertDialogManager(WrmsAlarmAcknowledgeActivity.this);
        sessionManager = new SessionManager(WrmsAlarmAcknowledgeActivity.this);
        userId = sessionManager.getSessionUserId();
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = sessionManager.getSessionUserTicketName();

        preventiveMaintanceSiteTransactionDetails = new PreventiveMaintanceSiteTransactionDetails();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(WrmsAlarmAcknowledgeActivity.this, userId, ticketName);
        getOfflineData();
        gpsTracker = new GPSTracker(WrmsAlarmAcknowledgeActivity.this);*/

        mWrmsAlarmAcknowledgeButtonAcknowledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showToast("Clicked on Acknowledge button");

            }
        });
        //checkNetworkConnection();

    }

    private void assignViews() {
        mWrmsAlarmAcknowledgeEditTextCircle = (EditText) findViewById(R.id.wrmsAlarmAcknowledge_editText_circle);
        mWrmsAlarmAcknowledgeEditTextState = (EditText) findViewById(R.id.wrmsAlarmAcknowledge_editText_state);
        mWrmsAlarmAcknowledgeEditTextSsa = (EditText) findViewById(R.id.wrmsAlarmAcknowledge_editText_ssa);
        mWrmsAlarmAcknowledgeEditTextSiteID = (EditText) findViewById(R.id.wrmsAlarmAcknowledge_editText_siteID);
        mWrmsAlarmAcknowledgeEditTextNameOfSite = (EditText) findViewById(R.id.wrmsAlarmAcknowledge_editText_nameOfSite);
        mWrmsAlarmAcknowledgeEditTextAlarmTicketNumber = (EditText) findViewById(R.id.wrmsAlarmAcknowledge_editText_alarmTicketNumber);
        mWrmsAlarmAcknowledgeEditTextAlarmDescription = (EditText) findViewById(R.id.wrmsAlarmAcknowledge_editText_alarmDescription);
        mWrmsAlarmAcknowledgeEditTextAlarmSeverity = (EditText) findViewById(R.id.wrmsAlarmAcknowledge_editText_alarmSeverity);
        mWrmsAlarmAcknowledgeEditTextAlarmOccurrenceTime = (EditText) findViewById(R.id.wrmsAlarmAcknowledge_editText_alarmOccurrenceTime);
        mWrmsAlarmAcknowledgeButtonAcknowledge = (Button) findViewById(R.id.wrmsAlarmAcknowledge_button_acknowledge);

        /*mWrmsAlarmAcknowledgeEditTextCircle.setText("");
        mWrmsAlarmAcknowledgeEditTextState.setText("");
        mWrmsAlarmAcknowledgeEditTextSsa.setText("");
        mWrmsAlarmAcknowledgeEditTextSiteID.setText("");
        mWrmsAlarmAcknowledgeEditTextNameOfSite.setText("");
        mWrmsAlarmAcknowledgeEditTextAlarmTicketNumber.setText("");
        mWrmsAlarmAcknowledgeEditTextAlarmDescription.setText("");
        mWrmsAlarmAcknowledgeEditTextAlarmSeverity.setText("");
        mWrmsAlarmAcknowledgeEditTextAlarmOccurrenceTime.setText("");*/
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.userpm_site_transaction_menu, menu);
        MenuItem shareItem = menu.findItem(R.id.menuSubmit);
        shareItem.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuSubmit:
                LocationManager lm = (LocationManager) WrmsAlarmAcknowledgeActivity.this.getSystemService(Context.LOCATION_SERVICE);
                boolean gps_enabled = false;
                boolean network_enabled = false;

                try {
                    gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
                    network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
                } catch (Exception ex) {
                }

                if (!gps_enabled && !network_enabled) {
                    alertDialogManager = new AlertDialogManager(WrmsAlarmAcknowledgeActivity.this);
                    alertDialogManager.Dialog("Information", "Location is not enabled. Do you want to enable?", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                        @Override
                        public void onPositiveClick() {
                            Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            WrmsAlarmAcknowledgeActivity.this.startActivity(myIntent);
                        }
                    }).show();
                } else {
                    if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                        siteLatitude = Double.valueOf(sessionManager.getSessionSiteLat());
                        siteLongitude = Double.valueOf(sessionManager.getSessionSiteLng());

                        checkOutLat = String.valueOf(gpsTracker.getLatitude());
                        checkOutLong = String.valueOf(gpsTracker.getLongitude());

                        showSettingsAlert();


                    } else {
                        alertDialogManager = new AlertDialogManager(WrmsAlarmAcknowledgeActivity.this);
                        alertDialogManager.Dialog("Information", "Could not get your location. Please try again.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                            @Override
                            public void onPositiveClick() {
                                if (gpsTracker.canGetLocation()) {
                                    Log.e(UserHotoTransactionActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
                                }
                            }
                        }).show();
                    }
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    private void showSettingsAlert() {

        alertDialogManager.Dialog("Confirmation", "Do you want to submit this ticket?", "Yes", "No", new AlertDialogManager.onTwoButtonClickListner() {
            @Override
            public void onPositiveClick() {
                submitDetails();
            }

            @Override
            public void onNegativeClick() {

            }
        }).show();
    }

    private void submitDetails() {
        try {
            submitPMSiteTicket();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void submitPMSiteTicket() {
        try {
            /*if (offlineStorageWrapper.checkOfflineFileIsAvailable(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt")) {
                showBusyProgress();
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt");
                Log.e("123", jsonInString);
                GsonRequest<UserLoginResponseData>
                        submitSitePmTicketRequest = new GsonRequest<>(Request.Method.POST, Constants.submitSitePMTicket, jsonInString, UserLoginResponseData.class,
                        new Response.Listener<UserLoginResponseData>() {
                            @Override
                            public void onResponse(@NonNull UserLoginResponseData response) {
                                hideBusyProgress();
                                if (response.getError() != null) {
                                    showToast(response.getError().getErrorMessage());
                                } else {
                                    if (response.getSuccess() == 1) {
                                        showToast("Ticket submitted successfully.");
                                        sessionManager.updateSessionUserTicketId(null);
                                        sessionManager.updateSessionUserTicketName(null);
                                        setResult(RESULT_OK);
                                        removeOfflineCache();
                                        finish();
                                    }
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        hideBusyProgress();
                        showToast(SettingsMy.getErrorMessage(error));
                    }
                });

                submitSitePmTicketRequest.setRetryPolicy(Application.getDefaultRetryPolice());
                submitSitePmTicketRequest.setShouldCache(false);
                Application.getInstance().addToRequestQueue(submitSitePmTicketRequest, "submitSitePmTicketRequest");
            }*/
        } catch (Exception e) {
            hideBusyProgress();
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        invalidateOptionsMenu();
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }
}

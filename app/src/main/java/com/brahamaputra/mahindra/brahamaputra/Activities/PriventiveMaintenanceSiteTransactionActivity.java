package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.brahamaputra.mahindra.brahamaputra.Data.EbMeterBox;
import com.brahamaputra.mahindra.brahamaputra.Data.PreventiveMaintanceSiteTransactionDetails;
import com.brahamaputra.mahindra.brahamaputra.Data.PreventiveMaintenanceAcTransactionData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GPSTracker;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_Selected_CustomerName;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_Selected_SiteType;

public class PriventiveMaintenanceSiteTransactionActivity extends BaseActivity {

    private static final String TAG = PriventiveMaintenanceSiteTransactionActivity.class.getSimpleName();

    private EditText mPriventiveMaintenanceSiteTransEditTextCustomerName;
    private EditText mPriventiveMaintenanceSiteTransEditTextCircle;
    private EditText mPriventiveMaintenanceSiteTransEditTextState;
    private EditText mPriventiveMaintenanceSiteTransEditTextSsa;
    private EditText mPriventiveMaintenanceSiteTransEditTextNameOfSite;
    private EditText mPriventiveMaintenanceSiteTransEditTextSiteID;
    private EditText mPriventiveMaintenanceSiteTransEditTextSheduledDateOfPm;
    private EditText mPriventiveMaintenanceSiteTransEditTextActualPmExecutionDate;
    private Button mPriventiveMaintenanceSiteTransButtonSubmit;
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

    public double siteLongitude = 0;
    public double siteLatitude = 0;

    private AlertDialogManager alertDialogManager;
    private PreventiveMaintanceSiteTransactionDetails preventiveMaintanceSiteTransactionDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priventive_maintenance_site_transaction);
        assignViews();
        this.setTitle("Priventive Maintenance Site Transaction");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        checkInBatteryData = "" + GlobalMethods.getBattery_percentage(PriventiveMaintenanceSiteTransactionActivity.this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("ticketNO");
        this.setTitle(id);
        checkInLat = intent.getStringExtra("latitude");
        checkInLong = intent.getStringExtra("longitude");

        alertDialogManager = new AlertDialogManager(PriventiveMaintenanceSiteTransactionActivity.this);
        sessionManager = new SessionManager(PriventiveMaintenanceSiteTransactionActivity.this);
        userId = sessionManager.getSessionUserId();

        preventiveMaintanceSiteTransactionDetails = new PreventiveMaintanceSiteTransactionDetails();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PriventiveMaintenanceSiteTransactionActivity.this, userId, ticketName);
        gpsTracker = new GPSTracker(PriventiveMaintenanceSiteTransactionActivity.this);

        mPriventiveMaintenanceSiteTransButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PriventiveMaintenanceSiteTransactionActivity.this, SitePreventiveMaintenanceSectionsListActivity.class);
                //intent.putExtra("ticketName", "");

                startActivityForResult(intent, RESULT_PRIVENTIVE_MAINTENANCE_SITE_READING);

            }
        });

    }

    private void assignViews() {
        mPriventiveMaintenanceSiteTransEditTextCustomerName = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_customerName);
        mPriventiveMaintenanceSiteTransEditTextCircle = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_circle);
        mPriventiveMaintenanceSiteTransEditTextState = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_state);
        mPriventiveMaintenanceSiteTransEditTextSsa = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_ssa);
        mPriventiveMaintenanceSiteTransEditTextNameOfSite = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_nameOfSite);
        mPriventiveMaintenanceSiteTransEditTextSiteID = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_siteID);
        mPriventiveMaintenanceSiteTransEditTextSheduledDateOfPm = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_sheduledDateOfPm);
        mPriventiveMaintenanceSiteTransEditTextActualPmExecutionDate = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_actualPmExecutionDate);
        mPriventiveMaintenanceSiteTransButtonSubmit = (Button) findViewById(R.id.priventiveMaintenanceSiteTrans_button_submit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.userpm_site_transaction_menu, menu);

        MenuItem shareItem = menu.findItem(R.id.menuSubmit);
        // show the button when some condition is true
        shareItem.setVisible(false);
        if (preventiveMaintanceSiteTransactionDetails.isAtLeastOneHotoFormsSubmit()) {
            shareItem.setVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuSubmit:
                if (checkValidationOnSubmitPmTransactionTicket() == true){
                    if (gpsTracker.canGetLocation()) {
                        if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                            //showToast(""+gpsTracker.distance(gpsTracker.getLatitude(),gpsTracker.getLongitude(),siteLatitude,siteLongitude));
                            if (gpsTracker.distance(gpsTracker.getLatitude(), gpsTracker.getLongitude(), siteLatitude, siteLongitude) < 0.310686) {///// ( 0.310686 MILE == 500 Meter )
                                Log.i(TAG, "" + "in Area \n" + gpsTracker.distance(gpsTracker.getLatitude(), gpsTracker.getLongitude(), siteLatitude, siteLongitude));
                                //showToast("User in Site Area");
                                showSettingsAlert();
                            } else {
                                Log.i(TAG, "" + "not in Area\n" + gpsTracker.distance(gpsTracker.getLatitude(), gpsTracker.getLongitude(), siteLatitude, siteLongitude));
                                //showToast("User not in Site Area");
                                alertDialogManager.Dialog("Information", "User not in area of site", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                                    @Override
                                    public void onPositiveClick() {

                                    }
                                }).show();
                            }
                        } else {
                            //showToast("Could not detecting location. Please try again later.");
                            alertDialogManager.Dialog("Information", "Could not get your location. Please try again.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                                @Override
                                public void onPositiveClick() {
                                    if (gpsTracker.canGetLocation()) {
                                        //showToast("Lat : "+gpsTracker.getLatitude()+"\n Long : "+gpsTracker.getLongitude()); comment By Arjun on 10-11-2018
                                        Log.e(MyEnergyListActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
                                    }
                                }
                            }).show();
                        }
                    }
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private boolean checkValidationOnSubmitPmTransactionTicket() {
        String userId = sessionManager.getSessionUserId();
        String accessToken = sessionManager.getSessionDeviceToken();
        String latitude = String.valueOf(gpsTracker.getLatitude());
        String longitude = String.valueOf(gpsTracker.getLongitude());
        String siteID = mPriventiveMaintenanceSiteTransEditTextSiteID.getText().toString();
        String customer = mPriventiveMaintenanceSiteTransEditTextCustomerName.getText().toString();
        String state = mPriventiveMaintenanceSiteTransEditTextState.getText().toString();
        String ssa = mPriventiveMaintenanceSiteTransEditTextSsa.getText().toString();
        String nameOfSite = mPriventiveMaintenanceSiteTransEditTextNameOfSite.getText().toString();
        String sheduledDatePm = mPriventiveMaintenanceSiteTransEditTextSheduledDateOfPm.getText().toString();
        String actualPmExecutionDate = mPriventiveMaintenanceSiteTransEditTextActualPmExecutionDate.getText().toString();

        if (siteID.isEmpty() || siteID == null) {
            showToast("Select Site Name");
            return false;
        } else if (customer.isEmpty() || customer == null) {
            showToast("Select DG ID / QR Code");
            return false;
        } else if (state.isEmpty() || state == null) {
            showToast("Enter Present DG HMR");
            return false;
        } else if (ssa.isEmpty() || ssa == null) {
            showToast("Upload Photo of HMR");
            return false;
        } else if (nameOfSite.isEmpty() || nameOfSite == null) {
            showToast("Enter Tank Balance Before Filling");
            return false;
        } else if (sheduledDatePm.isEmpty() || sheduledDatePm == null) {
            showToast("Enter Filling Quantity");
            return false;
        }  else if (actualPmExecutionDate.isEmpty() || actualPmExecutionDate == null) {
            showToast("Enter Diesel Price");
            return false;
        }  else return true;
    }

    private void showSettingsAlert() {

        alertDialogManager.Dialog("Confirmation", "Do you want to submit this ticket?", "Yes", "No", new AlertDialogManager.onTwoButtonClickListner() {
            @Override
            public void onPositiveClick() {
                //submitDetails();
            }

            @Override
            public void onNegativeClick() {

            }
        }).show();
    }

    private void submitDetails() {
        try {
            /*showBusyProgress();
            String userId = sessionManager.getSessionUserId();
            String accessToken = sessionManager.getSessionDeviceToken();
          *//*  String ticketId = "";
            String ticketNo = "";*//*
            String latitude = String.valueOf(gpsTracker.getLatitude());
            String longitude = String.valueOf(gpsTracker.getLongitude());

            String siteID = String.valueOf(site_id);
            String customer  = mPriventiveMaintenanceSiteTransEditTextCustomerName.getText().toString().trim();
            String circle = mPriventiveMaintenanceSiteTransEditTextCircle.getText().toString().trim();
            String state = mPriventiveMaintenanceSiteTransEditTextState.getText().toString().trim();
            String ssa = mPriventiveMaintenanceSiteTransEditTextSsa.getText().toString().trim();
            String nameOfSite = mPriventiveMaintenanceSiteTransEditTextNameOfSite.getText().toString().trim();
            String sheduledDateOfPm = mPriventiveMaintenanceSiteTransEditTextSheduledDateOfPm.getText().toString().trim();
            String actualPmExecutionDate = mPriventiveMaintenanceSiteTransEditTextActualPmExecutionDate.getText().toString().trim();

            preventiveMaintanceSiteTransactionDetails = new PreventiveMaintanceSiteTransactionDetails(userId,accessToken,latitude,longitude,siteID,customer,circle,state
            ,ssa,nameOfSite,sheduledDateOfPm,actualPmExecutionDate);*/
        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }
}

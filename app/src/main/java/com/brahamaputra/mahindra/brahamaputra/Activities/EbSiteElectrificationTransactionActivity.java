package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationTransactionData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GPSTracker;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_Selected_CustomerName;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_Selected_SiteType;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_sourceOfPower;

public class EbSiteElectrificationTransactionActivity extends AppCompatActivity {

    private static final String TAG = EbSiteElectrificationTransactionActivity.class.getSimpleName();

    private EditText mEbSiteElectrificationTransactionEditTextCustomerName;
    private EditText mEbSiteElectrificationTransactionEditTextState;
    private EditText mEbSiteElectrificationTransactionEditTextNameOfCircle;
    private EditText mEbSiteElectrificationTransactionEditTextNameOfssa;
    private EditText mEbSiteElectrificationTransactionEditTextNameOfsite;
    private EditText mEbSiteElectrificationTransactionEditTextSiteID;
    private TextView mEbSiteElectrificationTransactionTextViewTypeOfTower;
    private EditText mEbSiteElectrificationTransactionEditTextTypeOfSite;
    private EditText mEbSiteElectrificationTransactionEditTextSiteAddress;
    private TextView mEbSiteElectrificationTransactionTextViewSourceOfPower;
    private TextView mEbSiteElectrificationTransactionTextViewSourceOfPowerVal;
    private Button mEbSiteElectrificationTransactionButtonSubmitEbSiteElectrificationTransaction;

    public GPSTracker gpsTracker;
    String str_sourceOfPower;

    private SessionManager sessionManager;
    private AlertDialogManager alertDialogManager;

    private String userId = "";
    private String ticketId = "";//TicketId
    private String ticketName = "";//TicketId

    private String checkInLat = "0.0";
    private String checkInLong = "0.0";
    private String checkInBatteryData = "0";

    private String checkOutLat = "0.0";
    private String checkOutLong = "0.0";
    private String checkOutBatteryData = "0";

    EbSiteElectrificationTransactionData ebSiteElectrificationTransactionData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb_site_electrification_transaction);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String id = intent.getStringExtra("ticketNO");
        this.setTitle(id);
        checkInLat = intent.getStringExtra("latitude");
        checkInLong = intent.getStringExtra("longitude");
        assignViews();
        initCombo();
        checkNetworkConnection();

        alertDialogManager = new AlertDialogManager(EbSiteElectrificationTransactionActivity.this);
        sessionManager = new SessionManager(EbSiteElectrificationTransactionActivity.this);
        userId = sessionManager.getSessionUserId();
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = sessionManager.getSessionUserTicketName();

        ebSiteElectrificationTransactionData = new EbSiteElectrificationTransactionData();

        mEbSiteElectrificationTransactionButtonSubmitEbSiteElectrificationTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //submitDetails();
                hototicket_Selected_SiteType = mEbSiteElectrificationTransactionEditTextTypeOfSite.getText().toString();
                hototicket_Selected_CustomerName = mEbSiteElectrificationTransactionEditTextCustomerName.getText().toString();

                Intent intent = new Intent(EbSiteElectrificationTransactionActivity.this, HotoSectionsListActivity.class);
                intent.putExtra("ticketName", ticketName);

                startActivityForResult(intent, 1);
            }
        });
    }

    private void assignViews() {
        mEbSiteElectrificationTransactionEditTextCustomerName = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_customerName);
        mEbSiteElectrificationTransactionEditTextState = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_state);
        mEbSiteElectrificationTransactionEditTextNameOfCircle = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_nameOfCircle);
        mEbSiteElectrificationTransactionEditTextNameOfssa = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_nameOfssa);
        mEbSiteElectrificationTransactionEditTextNameOfsite = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_nameOfsite);
        mEbSiteElectrificationTransactionEditTextSiteID = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_siteID);
        mEbSiteElectrificationTransactionTextViewTypeOfTower = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_typeOfTower);
        mEbSiteElectrificationTransactionEditTextTypeOfSite = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_typeOfSite);
        mEbSiteElectrificationTransactionEditTextSiteAddress = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_siteAddress);
        mEbSiteElectrificationTransactionTextViewSourceOfPower = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_sourceOfPower);
        mEbSiteElectrificationTransactionTextViewSourceOfPowerVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_sourceOfPower_val);
        mEbSiteElectrificationTransactionButtonSubmitEbSiteElectrificationTransaction = (Button) findViewById(R.id.ebSiteElectrificationTransaction_button_submitEbSiteElectrificationTransaction);
    }

    private void initCombo() {

        mEbSiteElectrificationTransactionTextViewSourceOfPowerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationTransactionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_userHotoTrans_sourceOfPower))),
                        "Select",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_sourceOfPower = item.get(position);
                        mEbSiteElectrificationTransactionTextViewSourceOfPowerVal.setText(str_sourceOfPower);
                        hototicket_sourceOfPower=str_sourceOfPower;
                    }
                });
            }
        });
    }

    public void checkNetworkConnection() {

            Intent intent = getIntent();

            mEbSiteElectrificationTransactionEditTextCustomerName.setText(intent.getStringExtra("customerName"));
            mEbSiteElectrificationTransactionEditTextState.setText(intent.getStringExtra("stateName"));
            mEbSiteElectrificationTransactionEditTextNameOfCircle.setText(intent.getStringExtra("circleName"));
            mEbSiteElectrificationTransactionEditTextNameOfssa.setText(intent.getStringExtra("ssaName"));
            mEbSiteElectrificationTransactionEditTextNameOfsite.setText(intent.getStringExtra("siteName"));
            mEbSiteElectrificationTransactionEditTextSiteID.setText(intent.getStringExtra("siteId"));
            mEbSiteElectrificationTransactionEditTextSiteAddress.setText(intent.getStringExtra("siteAddress"));
            mEbSiteElectrificationTransactionEditTextTypeOfSite.setText(intent.getStringExtra("siteType"));

           /*if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                checkInLat = String.valueOf(gpsTracker.getLatitude());
                checkInLong = String.valueOf(gpsTracker.getLongitude());*//*

           // submitCheckIn(checkInLong, checkInLat, checkInBatteryData);
            *//*} else {
                showToast("Could not detecting location.");
            }*/

    }

    private void submitDetails() {
        try {

            checkOutBatteryData = "" + GlobalMethods.getBattery_percentage(EbSiteElectrificationTransactionActivity.this);

            ebSiteElectrificationTransactionData.setUserId(sessionManager.getSessionUserId());
            ebSiteElectrificationTransactionData.setAccessToken(sessionManager.getSessionDeviceToken());
            ebSiteElectrificationTransactionData.setTicketId(ticketId);
            ebSiteElectrificationTransactionData.setTicketNo(ticketName);

            ebSiteElectrificationTransactionData.setCheckInLatitude(checkInLat);
            ebSiteElectrificationTransactionData.setCheckInLongitude(checkInLong);
            ebSiteElectrificationTransactionData.setCheckInBatteryData(checkInBatteryData);

            ebSiteElectrificationTransactionData.setCheckOutLatitude(checkOutLat);
            ebSiteElectrificationTransactionData.setCheckOutLongitude(checkOutLong);
            ebSiteElectrificationTransactionData.setCheckOutBatteryData(checkOutBatteryData);

            ebSiteElectrificationTransactionData.setSiteId(mEbSiteElectrificationTransactionEditTextSiteID.getText().toString());

            ebSiteElectrificationTransactionData.setSiteAddress(mEbSiteElectrificationTransactionEditTextSiteAddress.getText().toString());

            ebSiteElectrificationTransactionData.setSourceOfPower(mEbSiteElectrificationTransactionTextViewSourceOfPowerVal.getText().toString());


            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(ebSiteElectrificationTransactionData);

            //offlineStorageWrapper.saveObjectToFile(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG , e.getMessage().toString());

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.eb_site_electrification_transaction_menu, menu);

        MenuItem shareItem = menu.findItem(R.id.menuSubmit);

        // show the button when some condition is true
        shareItem.setVisible(false);
        /*if (hotoTransactionData.isAtLeastOneHotoFormsSubmit()) {
            shareItem.setVisible(true);
        }*/

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.menuSubmit:
                //submitHotoTicket(); Comment by 008 on 10-11-2018
                //sessionManager.updateSessionUserTicketId(null);
                //sessionManager.updateSessionUserTicketName(null);
                //finish();
                /*LocationManager lm = (LocationManager) UserHotoTransactionActivity.this.getSystemService(Context.LOCATION_SERVICE);
                boolean gps_enabled = false;
                boolean network_enabled = false;

                try {
                    gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
                    network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
                } catch (Exception ex) {
                }

                if (!gps_enabled && !network_enabled) {
                    // notify user
                    alertDialogManager = new AlertDialogManager(UserHotoTransactionActivity.this);
                    alertDialogManager.Dialog("Information", "Location is not enabled. Do you want to enable?", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                        @Override
                        public void onPositiveClick() {
                            Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            UserHotoTransactionActivity.this.startActivity(myIntent);
                        }
                    }).show();
                } else {
                    if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                        checkOutLat = String.valueOf(gpsTracker.getLatitude());
                        checkOutLong = String.valueOf(gpsTracker.getLongitude());

                        submitDetails();
                        CheckSubmitFlagOfAllHotoForms();//24112018 by 008
                        //showSettingsAlert();

                    } else {
                        //showToast("Could not detecting location.");
                        alertDialogManager = new AlertDialogManager(UserHotoTransactionActivity.this);
                        alertDialogManager.Dialog("Information", "Could not get your location. Please try again.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                            @Override
                            public void onPositiveClick() {
                                if (gpsTracker.canGetLocation()) {
                                    //showToast("Lat : "+gpsTracker.getLatitude()+"\n Long : "+gpsTracker.getLongitude()); comment By 008 on 10-11-2018
                                    Log.e(UserHotoTransactionActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
                                }
                            }
                        }).show();
                    }
                }*/


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

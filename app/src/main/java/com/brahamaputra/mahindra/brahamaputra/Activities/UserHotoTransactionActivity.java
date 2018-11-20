package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.ACDB_DCDB_Data;
import com.brahamaputra.mahindra.brahamaputra.Data.ActiveequipmentDetailsData;
import com.brahamaputra.mahindra.brahamaputra.Data.AirConditionersData;
import com.brahamaputra.mahindra.brahamaputra.Data.BatterySetData;
import com.brahamaputra.mahindra.brahamaputra.Data.DetailsOfUnusedMaterialsData;
import com.brahamaputra.mahindra.brahamaputra.Data.EarthResistanceEquipmentData;
import com.brahamaputra.mahindra.brahamaputra.Data.EarthResistanceTowerData;
import com.brahamaputra.mahindra.brahamaputra.Data.ElectricConnectionData;
import com.brahamaputra.mahindra.brahamaputra.Data.ExternalTenantsPersonalDetailsData;
import com.brahamaputra.mahindra.brahamaputra.Data.GeneralSafetyMeasuresData;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.LandDetailsData;
import com.brahamaputra.mahindra.brahamaputra.Data.MediaData;
import com.brahamaputra.mahindra.brahamaputra.Data.PowerBackupsDGData;
import com.brahamaputra.mahindra.brahamaputra.Data.PowerManagementSystemData;
import com.brahamaputra.mahindra.brahamaputra.Data.PowerPlantDetailsData;
import com.brahamaputra.mahindra.brahamaputra.Data.ServoStabilizerData;
import com.brahamaputra.mahindra.brahamaputra.Data.ShelterData;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePhotoCaptureData;
import com.brahamaputra.mahindra.brahamaputra.Data.SolarPowerSystemData;
import com.brahamaputra.mahindra.brahamaputra.Data.TotalDCLoadofSiteData;
import com.brahamaputra.mahindra.brahamaputra.Data.TowerDetailsData;
import com.brahamaputra.mahindra.brahamaputra.Data.UserLoginResponseData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.Volley.JsonRequest;
import com.brahamaputra.mahindra.brahamaputra.Volley.SettingsMy;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import java.util.ArrayList;
import java.util.Arrays;

import com.brahamaputra.mahindra.brahamaputra.commons.GPSTracker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

public class UserHotoTransactionActivity extends BaseActivity {


    private EditText mUserHotoTransEditTextCustomerName;
    private EditText mUserHotoTransEditTextState;
    private EditText mUserHotoTransEditTextNameOfCircle;
    private EditText mUserHotoTransEditTextNameOfssa;
    private EditText mUserHotoTransEditTextNameOfsite;
    private EditText mUserHotoTransEditTextSiteAddress;
    private EditText mUserHotoTransEditTextSiteID;
    private TextView mUserHotoTransTextViewTypeOfTower;

    private EditText mUserHotoTransEditTextTypeOfSites;

    private TextView mUserHotoTransTextViewSourceOfPower;
    private TextView mUserHotoTransSpinnerSourceOfPowerVal;
    private Button mUserHotoTransButtonSubmitHotoTrans;

    public GPSTracker gpsTracker;

    String str_sourceOfPower;


    private OfflineStorageWrapper offlineStorageWrapper;
    private HotoTransactionData hotoTransactionData;

    private String userId = "";
    private String ticketId = "";//TicketId
    private String ticketName = "";//TicketId

    private String checkInLat = "0.0";
    private String checkInLong = "0.0";
    private String checkInBatteryData = "0";

    private String checkOutLat = "0.0";
    private String checkOutLong = "0.0";
    private String checkOutBatteryData = "0";

    private SessionManager sessionManager;

    private AlertDialogManager alertDialogManager;

    /////////////////////////
    public static final int RESULT_HOTO_READING = 258;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hoto_transaction);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        checkInBatteryData = "" + GlobalMethods.getBattery_percentage(UserHotoTransactionActivity.this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("ticketNO");
        this.setTitle(id);
        checkInLat = intent.getStringExtra("latitude");
        checkInLong = intent.getStringExtra("longitude");
        assignViews();
        initCombo();
        disableInput();


        alertDialogManager = new AlertDialogManager(UserHotoTransactionActivity.this);

        sessionManager = new SessionManager(UserHotoTransactionActivity.this);
        userId = sessionManager.getSessionUserId();
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = sessionManager.getSessionUserTicketName();

        hotoTransactionData = new HotoTransactionData();

        offlineStorageWrapper = OfflineStorageWrapper.getInstance(UserHotoTransactionActivity.this, userId, GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName));

        getOfflineData();

        gpsTracker = new GPSTracker(UserHotoTransactionActivity.this);
        /*Log.e(UserHotoTransactionActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
        if (gpsTracker.canGetLocation()) {
            //showToast("Lat : "+gpsTracker.getLatitude()+"\n Long : "+gpsTracker.getLongitude()); comment By Arjun on 10-11-2018
            Log.e(UserHotoTransactionActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
        } else {
            showToast("Could not detect location");
            finish();
        }*/

        mUserHotoTransButtonSubmitHotoTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                    checkInLat = String.valueOf(gpsTracker.getLatitude());
                    checkInLong = String.valueOf(gpsTracker.getLongitude());*/

                submitDetails();
                startActivityForResult(new Intent(UserHotoTransactionActivity.this, HotoSectionsListActivity.class), RESULT_HOTO_READING);

                /*} else {
                    showToast("Could not detecting location.");
                }*/

            }
        });
        checkNetworkConnection();
    }

    private void initCombo() {
        mUserHotoTransSpinnerSourceOfPowerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(UserHotoTransactionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_userHotoTrans_sourceOfPower))),
                        "Select",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_sourceOfPower = item.get(position);
                        mUserHotoTransSpinnerSourceOfPowerVal.setText(str_sourceOfPower);
                    }
                });
            }
        });
    }

    public void checkNetworkConnection() {
        if (!isNetworkConnected()) {
            mUserHotoTransEditTextCustomerName.setHint("Offline");
            mUserHotoTransEditTextState.setHint("Offline");
            mUserHotoTransEditTextNameOfCircle.setHint("Offline");
            mUserHotoTransEditTextNameOfssa.setHint("Offline");
            mUserHotoTransEditTextNameOfsite.setHint("Offline");
            mUserHotoTransEditTextSiteID.setHint("Offline");
            mUserHotoTransEditTextTypeOfSites.setHint("Offline");
        } else {
            Intent intent = getIntent();

            mUserHotoTransEditTextCustomerName.setText(intent.getStringExtra("customerName"));
            mUserHotoTransEditTextState.setText(intent.getStringExtra("stateName"));
            mUserHotoTransEditTextNameOfCircle.setText(intent.getStringExtra("circleName"));
            mUserHotoTransEditTextNameOfssa.setText(intent.getStringExtra("ssaName"));
            mUserHotoTransEditTextNameOfsite.setText(intent.getStringExtra("siteName"));
            mUserHotoTransEditTextSiteID.setText(intent.getStringExtra("siteId"));
            mUserHotoTransEditTextSiteAddress.setText(intent.getStringExtra("siteAddress"));
            mUserHotoTransEditTextTypeOfSites.setText(intent.getStringExtra("siteType"));

            /*if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                checkInLat = String.valueOf(gpsTracker.getLatitude());
                checkInLong = String.valueOf(gpsTracker.getLongitude());*/

            submitCheckIn(checkInLong, checkInLat, checkInBatteryData);
            /*} else {
                showToast("Could not detecting location.");
            }*/
        }
    }

    private void submitCheckIn(String longitude, String lattitude, String batteryLevel) {
        showBusyProgress();

        try {
            JSONObject jo = new JSONObject();
            try {
                jo.put("UserId", sessionManager.getSessionUserId());
                jo.put("AccessToken", sessionManager.getSessionDeviceToken());
                jo.put("HotoTicketId", ticketId);
                jo.put("Longitude", longitude);
                jo.put("Lattitude", lattitude);
                jo.put("BatteryLevel", batteryLevel);

            } catch (JSONException e) {
                Log.e(LoginActivity.class.getName(), e.getMessage().toString());
                return;
            }

            JsonRequest hototticketstatusclockin = new JsonRequest(Request.Method.POST, Constants.hototticketstatusclockin, jo,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(@NonNull JSONObject response) {
                            hideBusyProgress();
                            try {
                                if (response != null) {
                                    if (response.has("Success")) {
                                        int success = response.getInt("Success");
                                        if (success == 1) {
                                            showToast("Checked In");
                                        } else {
                                            showToast("Problem while check-in");
                                        }
                                    }
                                }
                            } catch (JSONException e) {
                                showToast("Exception :" + e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    hideBusyProgress();
                    showToast(SettingsMy.getErrorMessage(error));
                }
            });
            hototticketstatusclockin.setRetryPolicy(Application.getDefaultRetryPolice());
            hototticketstatusclockin.setShouldCache(false);
            Application.getInstance().addToRequestQueue(hototticketstatusclockin, "hototticketstatusclockin");

        } catch (Exception e) {
            hideBusyProgress();
            e.printStackTrace();
        }
    }

    private void disableInput() {
        mUserHotoTransEditTextCustomerName.setKeyListener(null);
        mUserHotoTransEditTextState.setKeyListener(null);
        mUserHotoTransEditTextNameOfCircle.setKeyListener(null);
        mUserHotoTransEditTextNameOfssa.setKeyListener(null);
        mUserHotoTransEditTextNameOfsite.setKeyListener(null);
        mUserHotoTransEditTextTypeOfSites.setKeyListener(null);
        mUserHotoTransEditTextSiteID.setKeyListener(null);
    }

    private void assignViews() {
        mUserHotoTransEditTextCustomerName = (EditText) findViewById(R.id.userHotoTrans_editText_customerName);
        mUserHotoTransEditTextState = (EditText) findViewById(R.id.userHotoTrans_editText_state);
        mUserHotoTransEditTextNameOfCircle = (EditText) findViewById(R.id.userHotoTrans_editText_nameOfCircle);
        mUserHotoTransEditTextNameOfssa = (EditText) findViewById(R.id.userHotoTrans_editText_nameOfssa);
        mUserHotoTransEditTextNameOfsite = (EditText) findViewById(R.id.userHotoTrans_editText_nameOfsite);
        mUserHotoTransEditTextSiteAddress = (EditText) findViewById(R.id.userHotoTrans_editText_siteAddress);
        mUserHotoTransEditTextSiteID = (EditText) findViewById(R.id.userHotoTrans_editText_siteID);
        mUserHotoTransTextViewTypeOfTower = (TextView) findViewById(R.id.userHotoTrans_textView_typeOfTower);

        mUserHotoTransEditTextTypeOfSites = (EditText) findViewById(R.id.userHotoTrans_editText_typeOfSite);

        mUserHotoTransTextViewSourceOfPower = (TextView) findViewById(R.id.userHotoTrans_textView_sourceOfPower);
        mUserHotoTransSpinnerSourceOfPowerVal = (TextView) findViewById(R.id.userHotoTrans_textView_sourceOfPower_val);
        mUserHotoTransButtonSubmitHotoTrans = (Button) findViewById(R.id.userHotoTrans_button_submitHotoTrans);

        //mUserHotoTransSpinnerSourceOfPower.setTitle("Source of Power");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.userhoto_transaction_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.menuSubmit:
                //submitHotoTicket(); Comment by Arjun on 10-11-2018
                //sessionManager.updateSessionUserTicketId(null);
                //sessionManager.updateSessionUserTicketName(null);
                //finish();
                LocationManager lm = (LocationManager) UserHotoTransactionActivity.this.getSystemService(Context.LOCATION_SERVICE);
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
                        showSettingsAlert();
                    } else {
                        //showToast("Could not detecting location.");
                        alertDialogManager = new AlertDialogManager(UserHotoTransactionActivity.this);
                        alertDialogManager.Dialog("Information", "Could not get your location. Please try again.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                            @Override
                            public void onPositiveClick() {
                                if (gpsTracker.canGetLocation()) {
                                    //showToast("Lat : "+gpsTracker.getLatitude()+"\n Long : "+gpsTracker.getLongitude()); comment By Arjun on 10-11-2018
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
    }

    ////added by arjun on 10-11-2018 Start

    private void showSettingsAlert() {

        alertDialogManager = new AlertDialogManager(UserHotoTransactionActivity.this);
        alertDialogManager.Dialog("Confirmation", "Do you want to submit this ticket?", "Yes", "No", new AlertDialogManager.onTwoButtonClickListner() {
            @Override
            public void onPositiveClick() {
                submitHotoTicket();

            }

            @Override
            public void onNegativeClick() {

            }
        }).show();

    }
////added by arjun on 10-11-2018 End

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    private void getOfflineData() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt");
                // Toast.makeText(Land_Details.this,"JsonInString :"+ jsonInString,Toast.LENGTH_SHORT).show();


                Gson gson = new Gson();
//                landDetailsData = gson.fromJson(jsonInString, LandDetailsData.class);

                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);

                if (hotoTransactionData != null) {
                    mUserHotoTransEditTextSiteID.setText(hotoTransactionData.getSiteId());
                    mUserHotoTransEditTextSiteAddress.setText(hotoTransactionData.getSiteAddress());
                    mUserHotoTransSpinnerSourceOfPowerVal.setText(hotoTransactionData.getSourceOfPower());
                }

            } else {
//                Toast.makeText(UserHotoTransactionActivity.this, "No offline data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitDetails() {
        try {
            checkOutBatteryData = "" + GlobalMethods.getBattery_percentage(UserHotoTransactionActivity.this);

            hotoTransactionData.setUserId(sessionManager.getSessionUserId());
            hotoTransactionData.setAccessToken(sessionManager.getSessionDeviceToken());
            hotoTransactionData.setTicketId(ticketId);
            hotoTransactionData.setTicketNo(ticketName);

            hotoTransactionData.setCheckInLatitude(checkInLat);
            hotoTransactionData.setCheckInLongitude(checkInLong);
            hotoTransactionData.setCheckInBatteryData(checkInBatteryData);

            hotoTransactionData.setCheckOutLatitude(checkOutLat);
            hotoTransactionData.setCheckOutLongitude(checkOutLong);
            hotoTransactionData.setCheckOutBatteryData(checkOutBatteryData);

            hotoTransactionData.setSiteId(mUserHotoTransEditTextSiteID.getText().toString());

            hotoTransactionData.setSiteAddress(mUserHotoTransEditTextSiteAddress.getText().toString());

            hotoTransactionData.setSourceOfPower(mUserHotoTransSpinnerSourceOfPowerVal.getText().toString());

//           hotoTransactionData.setLandDetailsData(new LandDetailsData());
//
//            hotoTransactionData.setTowerDetailsData(new TowerDetailsData());
//
//            hotoTransactionData.setEarthResistanceTowerData(new EarthResistanceTowerData());
//
//            hotoTransactionData.setEarthResistanceEquipmentData(new EarthResistanceEquipmentData());
//
//            hotoTransactionData.setElectricConnectionData(new ElectricConnectionData());
//
//            hotoTransactionData.setAirConditionersData(new AirConditionersData());
//
//            hotoTransactionData.setSolarPowerSystemData(new SolarPowerSystemData());
//
//            hotoTransactionData.setPowerPlantDetailsData(new PowerPlantDetailsData());
//
//            hotoTransactionData.setPowerBackupsDGData(new PowerBackupsDGData());
//
//            hotoTransactionData.setPowerManagementSystemData(new PowerManagementSystemData());
//
//            hotoTransactionData.setShelterData(new ShelterData());
//
//            hotoTransactionData.setMediaData(new MediaData());
//
//            hotoTransactionData.setBatterySetData(new BatterySetData());
//
//            hotoTransactionData.setExternalTenantsPersonalDetailsData(new ExternalTenantsPersonalDetailsData());
//
//            hotoTransactionData.setTotalDCLoadofSiteData(new TotalDCLoadofSiteData());
//
//            hotoTransactionData.setActiveequipmentDetailsData(new ActiveequipmentDetailsData());
//
//            hotoTransactionData.setGeneralSafetyMeasuresData(new GeneralSafetyMeasuresData());
//
//            hotoTransactionData.setAcdb_dcdb_data(new ACDB_DCDB_Data());
//
//            hotoTransactionData.setServoStabilizerData(new ServoStabilizerData());
//
//            hotoTransactionData.setDetailsOfUnusedMaterialsData(new DetailsOfUnusedMaterialsData());
//
//            hotoTransactionData.setSitePhotoCaptureData(new SitePhotoCaptureData());

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);
            //Toast.makeText(Land_Details.this, "Gson to json string :" + jsonString, Toast.LENGTH_SHORT).show();

            offlineStorageWrapper.saveObjectToFile(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("123", e.getMessage().toString());

        }

    }

    private void submitHotoTicket() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt")) {
                showBusyProgress();
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt");
                Log.e("123", jsonInString);

                GsonRequest<UserLoginResponseData> submitHotoTicketRequest = new GsonRequest<>(Request.Method.POST, Constants.submitHototTicket, jsonInString, UserLoginResponseData.class,
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
                submitHotoTicketRequest.setRetryPolicy(Application.getDefaultRetryPolice());
                submitHotoTicketRequest.setShouldCache(false);
                Application.getInstance().addToRequestQueue(submitHotoTicketRequest, "submitHotoTicketRequest");
            }
        } catch (Exception e) {
            hideBusyProgress();
            e.printStackTrace();
        }
    }

    private void removeOfflineCache() {
        if (offlineStorageWrapper.checkOfflineFileIsAvailable(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt")) {
            offlineStorageWrapper.removedOffLineFile(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_HOTO_READING && resultCode == RESULT_OK) {
            getOfflineData();
        }
    }

}

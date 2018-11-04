package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
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

import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.LandDetailsData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import java.util.ArrayList;
import java.util.Arrays;
import com.brahamaputra.mahindra.brahamaputra.commons.GPSTracker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    private String checkInBatteryData = "70";

    private String checkOutLat = "0.0";
    private String checkOutLong = "0.0";
    private String checkOutBatteryData = "30";

    private SessionManager sessionManager;


    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context ctxt, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            checkOutBatteryData =(String.valueOf(level) + "%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hoto_transaction);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        Intent intent = getIntent();
        String id = intent.getStringExtra("ticketNO");
        this.setTitle(id);

        assignViews();
        initCombo();
        disableInput();
        checkNetworkConnection();


        sessionManager = new SessionManager(UserHotoTransactionActivity.this);
        userId = sessionManager.getSessionUserId();
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = id;//sessionManager.getSessionUserTicketId();

        offlineStorageWrapper = OfflineStorageWrapper.getInstance(UserHotoTransactionActivity.this, userId, ticketName);

        getOfflineData();

        mUserHotoTransButtonSubmitHotoTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkInLat = String.valueOf(gpsTracker.getLatitude());
                checkInLong = String.valueOf(gpsTracker.getLongitude());

                submitDetails();
                startActivity(new Intent(UserHotoTransactionActivity.this, HotoSectionsListActivity.class));
            }
        });

        gpsTracker = new GPSTracker(UserHotoTransactionActivity.this);
        if(gpsTracker.canGetLocation()){
            showToast("Lat : "+gpsTracker.getLatitude()+"\n Long : "+gpsTracker.getLongitude());
        }else {
            checkInLong = "0.0";
            checkInLat = "0.0";

            checkOutLat = "0.0";
            checkOutLong = "0.0";
        }
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
        }else{
            Intent intent = getIntent();

            mUserHotoTransEditTextCustomerName.setText(intent.getStringExtra("customerName"));
            mUserHotoTransEditTextState.setText(intent.getStringExtra("stateName"));
            mUserHotoTransEditTextNameOfCircle.setText( intent.getStringExtra("circleName"));
            mUserHotoTransEditTextNameOfssa.setText(intent.getStringExtra("ssaName"));
            mUserHotoTransEditTextNameOfsite.setText(intent.getStringExtra("siteName"));
            mUserHotoTransEditTextSiteID.setText(intent.getStringExtra("siteId"));
            mUserHotoTransEditTextTypeOfSites.setText(intent.getStringExtra("siteType"));
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
                Object req = offlineStorageWrapper.getFileObjectByName(ticketName + ".txt");//saveObjectToFile(ticketName + ".txt", jsonString);
                Log.e(UserHotoTransactionActivity.class.getName(),"FinalJson :\n"+req);
                sessionManager.updateSessionUserTicketId(null);
                sessionManager.updateSessionUserTicketName(null);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    private void getOfflineData() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");
                // Toast.makeText(Land_Details.this,"JsonInString :"+ jsonInString,Toast.LENGTH_SHORT).show();

                Gson gson = new Gson();
//                landDetailsData = gson.fromJson(jsonInString, LandDetailsData.class);

                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);

                if(hotoTransactionData!=null){
                    mUserHotoTransEditTextSiteAddress.setText(hotoTransactionData.getSiteAddress());
                    mUserHotoTransSpinnerSourceOfPowerVal.setText(hotoTransactionData.getSourceOfTower());
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
            hotoTransactionData.setTicketId(ticketId);
            hotoTransactionData.setTicketNo(ticketName);

            hotoTransactionData.setCheckInLatitude(checkInLat);
            hotoTransactionData.setCheckInLongitude(checkInLong);
            hotoTransactionData.setCheckInBatteryData(checkInBatteryData);

            hotoTransactionData.setCheckOutLatitude(checkOutLat);
            hotoTransactionData.setCheckOutLongitude(checkOutLong);
            hotoTransactionData.setCheckOutBatteryData(checkOutBatteryData);

            hotoTransactionData.setSiteAddress(mUserHotoTransEditTextSiteAddress.getText().toString());

            hotoTransactionData.setSourceOfTower(mUserHotoTransSpinnerSourceOfPowerVal.getText().toString());

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);
            //Toast.makeText(Land_Details.this, "Gson to json string :" + jsonString, Toast.LENGTH_SHORT).show();

            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

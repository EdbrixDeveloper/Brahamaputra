package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.ShelterData;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Shelter extends BaseActivity {


    private TextView mShelterTextViewPhysicalConditionOfShelterPlatform;
    private TextView mShelterTextViewPhysicalConditionOfShelterPlatformVal;
    private TextView mShelterTextViewNumberOfBtsInsideShelter;
    private TextView mShelterTextViewNumberOfBtsInsideShelterVal;
    private TextView mShelterTextViewNumberOfBtsOutsideShelter;
    private TextView mShelterTextViewNumberOfBtsOutsideShelterVal;
    private TextView mShelterTextViewShelterLock;
    private TextView mShelterTextViewShelterLockVal;
    private TextView mShelterTextViewOutdoorShelterLock;
    private TextView mShelterTextViewOutdoorShelterLockVal;
    private TextView mShelterTextViewIgbStatus;
    private TextView mShelterTextViewIgbStatusVal;
    private TextView mShelterTextViewEgbStatus;
    private TextView mShelterTextViewEgbStatusVal;
    private TextView mShelterTextViewNoOfOdcAvailable;
    private TextView mShelterTextViewNoOfOdcAvailableVal;
    private TextView mShelterTextViewOdcLock;
    private TextView mShelterTextViewOdcLockVal;


    String str_physicalConditionOfShelterPlatform;
    String str_numberOfBtsInsideShelter;
    String str_numberOfBtsOutsideShelter;
    String str_shelterLock;
    String str_outdoorShelterLock;
    String str_igbStatus;
    String str_egbStatus;
    String str_noOfOdcAvailable;
    String str_odcLock;

    private static final String TAG = Shelter.class.getSimpleName();

    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "101";
    private String ticketId = "28131";
    private String ticketName = "28131";
    private HotoTransactionData hotoTransactionData;
    private ShelterData shelterData;

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter);
        this.setTitle("Shelter");
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(Shelter.this, userId, ticketId);
        assignViews();
        initCombo();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        hotoTransactionData = new HotoTransactionData();

        sessionManager = new SessionManager(Shelter.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = sessionManager.getSessionUserTicketId();
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(Shelter.this, userId, ticketId);

        setInputDetails();

    }

    private void initCombo() {
        mShelterTextViewPhysicalConditionOfShelterPlatformVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Shelter.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_shelter_physicalConditionOfShelterPlatform))),
                        "Physical Condition of Shelter and Platform",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_physicalConditionOfShelterPlatform = item.get(position);
                        mShelterTextViewPhysicalConditionOfShelterPlatformVal.setText(str_physicalConditionOfShelterPlatform);
                    }
                });
            }
        });

        mShelterTextViewNumberOfBtsInsideShelterVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Shelter.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_shelter_numberOfBtsInsideShelter))),
                        "Number of BTS Inside Shelter",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_numberOfBtsInsideShelter = item.get(position);
                        mShelterTextViewNumberOfBtsInsideShelterVal.setText(str_numberOfBtsInsideShelter);
                    }
                });
            }
        });

        mShelterTextViewNumberOfBtsOutsideShelterVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Shelter.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_shelter_numberOfBtsOutsideShelter))),
                        "Number of BTS Outside Shelter",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_numberOfBtsOutsideShelter = item.get(position);
                        mShelterTextViewNumberOfBtsOutsideShelterVal.setText(str_numberOfBtsOutsideShelter);
                    }
                });
            }
        });

        mShelterTextViewShelterLockVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Shelter.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_shelter_shelterLock))),
                        "Shelter Lock",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_shelterLock = item.get(position);
                        mShelterTextViewShelterLockVal.setText(str_shelterLock);
                    }
                });
            }
        });


        mShelterTextViewOutdoorShelterLockVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Shelter.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_shelter_outdoorShelterLock))),
                        "Outdoor Shelter Lock",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_outdoorShelterLock = item.get(position);
                        mShelterTextViewOutdoorShelterLockVal.setText(str_outdoorShelterLock);
                    }
                });
            }
        });

        mShelterTextViewIgbStatusVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Shelter.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_shelter_igbStatus))),
                        "IGB Status",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_igbStatus = item.get(position);
                        mShelterTextViewIgbStatusVal.setText(str_igbStatus);
                    }
                });
            }
        });

        mShelterTextViewEgbStatusVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Shelter.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_shelter_egbStatus))),
                        "EGB Status",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_egbStatus = item.get(position);
                        mShelterTextViewEgbStatusVal.setText(str_egbStatus);
                    }
                });
            }
        });

        mShelterTextViewNoOfOdcAvailableVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Shelter.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_shelter_noOfOdcAvailable))),
                        "NO OF ODC Available",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfOdcAvailable = item.get(position);
                        mShelterTextViewNoOfOdcAvailableVal.setText(str_noOfOdcAvailable);
                    }
                });
            }
        });


        mShelterTextViewOdcLockVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Shelter.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_shelter_odcLock))),
                        "ODC Lock",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_odcLock = item.get(position);
                        mShelterTextViewOdcLockVal.setText(str_odcLock);
                    }
                });
            }
        });
    }

    private void assignViews() {
        mShelterTextViewPhysicalConditionOfShelterPlatform = (TextView) findViewById(R.id.shelter_textView_physicalConditionOfShelterPlatform);
        mShelterTextViewPhysicalConditionOfShelterPlatformVal = (TextView) findViewById(R.id.shelter_textView_physicalConditionOfShelterPlatform_val);
        mShelterTextViewNumberOfBtsInsideShelter = (TextView) findViewById(R.id.shelter_textView_numberOfBtsInsideShelter);
        mShelterTextViewNumberOfBtsInsideShelterVal = (TextView) findViewById(R.id.shelter_textView_numberOfBtsInsideShelter_val);
        mShelterTextViewNumberOfBtsOutsideShelter = (TextView) findViewById(R.id.shelter_textView_numberOfBtsOutsideShelter);
        mShelterTextViewNumberOfBtsOutsideShelterVal = (TextView) findViewById(R.id.shelter_textView_numberOfBtsOutsideShelter_val);
        mShelterTextViewShelterLock = (TextView) findViewById(R.id.shelter_textView_shelterLock);
        mShelterTextViewShelterLockVal = (TextView) findViewById(R.id.shelter_textView_shelterLock_val);
        mShelterTextViewOutdoorShelterLock = (TextView) findViewById(R.id.shelter_textView_outdoorShelterLock);
        mShelterTextViewOutdoorShelterLockVal = (TextView) findViewById(R.id.shelter_textView_outdoorShelterLock_val);
        mShelterTextViewIgbStatus = (TextView) findViewById(R.id.shelter_textView_igbStatus);
        mShelterTextViewIgbStatusVal = (TextView) findViewById(R.id.shelter_textView_igbStatus_val);
        mShelterTextViewEgbStatus = (TextView) findViewById(R.id.shelter_textView_egbStatus);
        mShelterTextViewEgbStatusVal = (TextView) findViewById(R.id.shelter_textView_egbStatus_val);
        mShelterTextViewNoOfOdcAvailable = (TextView) findViewById(R.id.shelter_textView_noOfOdcAvailable);
        mShelterTextViewNoOfOdcAvailableVal = (TextView) findViewById(R.id.shelter_textView_noOfOdcAvailable_val);
        mShelterTextViewOdcLock = (TextView) findViewById(R.id.shelter_textView_odcLock);
        mShelterTextViewOdcLockVal = (TextView) findViewById(R.id.shelter_textView_odcLock_val);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    private void setInputDetails() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketId + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketId + ".txt");

                Gson gson = new Gson();

                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);
                shelterData = hotoTransactionData.getShelterData();

                mShelterTextViewPhysicalConditionOfShelterPlatformVal.setText(shelterData.getPhysicalCondition());
                mShelterTextViewNumberOfBtsInsideShelterVal.setText(shelterData.getNoOBtsInsideShelter());
                mShelterTextViewNumberOfBtsOutsideShelterVal.setText(shelterData.getNoOfBtsOutsideShelter());
                mShelterTextViewShelterLockVal.setText(shelterData.getShelterLock());
                mShelterTextViewOutdoorShelterLockVal.setText(shelterData.getOutdoorShelterLock());
                mShelterTextViewIgbStatusVal.setText(shelterData.getIgbStatus());
                mShelterTextViewEgbStatusVal.setText(shelterData.getEgbStatus());
                mShelterTextViewNoOfOdcAvailableVal.setText(shelterData.getNoOfOdcAvailable());
                mShelterTextViewOdcLockVal.setText(shelterData.getOdcLock());

            } else {
                Toast.makeText(Shelter.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitDetails() {
        try {

            hotoTransactionData.setTicketNo(ticketId);

            String physicalCondition = mShelterTextViewPhysicalConditionOfShelterPlatformVal.getText().toString().trim();
            String noOBtsInsideShelter = mShelterTextViewNumberOfBtsInsideShelterVal.getText().toString().trim();
            String noOfBtsOutsideShelter = mShelterTextViewNumberOfBtsOutsideShelterVal.getText().toString().trim();
            String shelterLock = mShelterTextViewShelterLockVal.getText().toString().trim();
            String outdoorShelterLock = mShelterTextViewOutdoorShelterLockVal.getText().toString().trim();
            String igbStatus = mShelterTextViewIgbStatusVal.getText().toString().trim();
            String egbStatus = mShelterTextViewEgbStatusVal.getText().toString().trim();
            String noOfOdcAvailable = mShelterTextViewNoOfOdcAvailableVal.getText().toString().trim();
            String odcLock = mShelterTextViewOdcLockVal.getText().toString().trim();


            shelterData = new ShelterData(physicalCondition, noOBtsInsideShelter, noOfBtsOutsideShelter, shelterLock, outdoorShelterLock, igbStatus, egbStatus, noOfOdcAvailable, odcLock);

            hotoTransactionData.setShelterData(shelterData);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);

            offlineStorageWrapper.saveObjectToFile(ticketId + ".txt", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.submit_icon_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                // startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;
            case R.id.menuSubmit:
                submitDetails();
                startActivity(new Intent(this, Media.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}


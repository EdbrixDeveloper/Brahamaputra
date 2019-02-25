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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.DieselSubmitResposeData;
import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationElectricConnectionData;
import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationSubmitResposeData;
import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.PowerPlantDetailsModulesData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
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

public class EbSiteElectrificationTransactionActivity extends BaseActivity {

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
    EbSiteElectrificationElectricConnectionData ebSiteElectrificationElectricConnectionData;

    public static final int MY_FLAG_MODULE_RESULT = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb_site_electrification_transaction);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gpsTracker = new GPSTracker(EbSiteElectrificationTransactionActivity.this);
        ebSiteElectrificationTransactionData = new EbSiteElectrificationTransactionData();
        ebSiteElectrificationElectricConnectionData = new EbSiteElectrificationElectricConnectionData();

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

        mEbSiteElectrificationTransactionButtonSubmitEbSiteElectrificationTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //submitDetails();
                hototicket_Selected_SiteType = mEbSiteElectrificationTransactionEditTextTypeOfSite.getText().toString();
                hototicket_Selected_CustomerName = mEbSiteElectrificationTransactionEditTextCustomerName.getText().toString();

                Intent intent = new Intent(EbSiteElectrificationTransactionActivity.this, EbSiteElectrificationElectricConnectionActivity.class);
                intent.putExtra("ebSiteElectrificationTransactionData", ebSiteElectrificationTransactionData);

                startActivityForResult(intent, 200);
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

        /*mEbSiteElectrificationTransactionTextViewSourceOfPowerVal.setOnClickListener(new View.OnClickListener() {
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
                        hototicket_sourceOfPower = str_sourceOfPower;
                    }
                });
            }
        });*/
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

        ebSiteElectrificationElectricConnectionData.setConsumerNumber(intent.getStringExtra("consumerNumber"));
        ebSiteElectrificationElectricConnectionData.setEbMeterSerialNumber(intent.getStringExtra("ebMeterSerialNumber"));
        ebSiteElectrificationElectricConnectionData.setNameOfTheSupplyCompany(intent.getStringExtra("nameOfTheSupplyCompany"));
        ebSiteElectrificationTransactionData.setObjEbSiteElectrificationElectricConnection(ebSiteElectrificationElectricConnectionData);

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
            //ebSiteElectrificationTransactionData.setObjEbSiteElectrificationElectricConnection(ebSiteElectrificationElectricConnectionData);


            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(ebSiteElectrificationTransactionData);
            Log.e(TAG, jsonString);

            /*GsonRequest<EbSiteElectrificationSubmitResposeData> ebSiteElectrificationTicketSubmit = new GsonRequest<>(Request.Method.POST, Constants.SubmitebSiteElectrificationTicket, jsonString.toString(), EbSiteElectrificationSubmitResposeData.class,
                    new Response.Listener<EbSiteElectrificationSubmitResposeData>() {
                        @Override
                        public void onResponse(EbSiteElectrificationSubmitResposeData response) {
                            hideBusyProgress();
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                if (response.getSuccess() == 1) {
                                    hideBusyProgress();
                                    setResult(RESULT_OK);
                                    showToast("Ticket submitted successfully.");
                                    finish();
                                } else {
                                    hideBusyProgress();
                                    showToast("Something went wrong");
                                }
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            hideBusyProgress();
                            Log.e("D100", error.toString());
                        }
                    });
            ebSiteElectrificationTicketSubmit.setRetryPolicy(Application.getDefaultRetryPolice());
            ebSiteElectrificationTicketSubmit.setShouldCache(false);
            Application.getInstance().addToRequestQueue(ebSiteElectrificationTicketSubmit, "ebSiteElectrificationTicketSubmit");*/

            //offlineStorageWrapper.saveObjectToFile(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage().toString());

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.eb_site_electrification_transaction_menu, menu);

        MenuItem shareItem = menu.findItem(R.id.menuSubmit);

        // show the button when some condition is true
        shareItem.setVisible(true);
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
                LocationManager lm = (LocationManager) EbSiteElectrificationTransactionActivity.this.getSystemService(Context.LOCATION_SERVICE);
                boolean gps_enabled = false;
                boolean network_enabled = false;

                try {
                    gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
                    network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
                } catch (Exception ex) {
                }

                if (!gps_enabled && !network_enabled) {
                    // notify user
                    alertDialogManager = new AlertDialogManager(EbSiteElectrificationTransactionActivity.this);
                    alertDialogManager.Dialog("Information", "Location is not enabled. Do you want to enable?", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                        @Override
                        public void onPositiveClick() {
                            Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            EbSiteElectrificationTransactionActivity.this.startActivity(myIntent);
                        }
                    }).show();
                } else {
                    if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                        checkOutLat = String.valueOf(gpsTracker.getLatitude());
                        checkOutLong = String.valueOf(gpsTracker.getLongitude());

                        if (validation() == true) {
                            submitDetails();
                        }

                    } else {
                        //showToast("Could not detecting location.");
                        alertDialogManager = new AlertDialogManager(EbSiteElectrificationTransactionActivity.this);
                        alertDialogManager.Dialog("Information", "Could not get your location. Please try again.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                            @Override
                            public void onPositiveClick() {
                                if (gpsTracker.canGetLocation()) {
                                    //showToast("Lat : "+gpsTracker.getLatitude()+"\n Long : "+gpsTracker.getLongitude()); comment By 008 on 10-11-2018
                                    Log.e(EbSiteElectrificationTransactionActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
                                }
                            }
                        }).show();
                    }
                }


                /*if (validation() == true) {
                    submitDetails();
                }*/
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_FLAG_MODULE_RESULT) {
            if (resultCode == RESULT_OK) {
                Bundle b = data.getExtras();
                //powerPlantDetailsModulesData = data.getBundleExtra("powerPlantDetailsModulesData");
                //powerPlantDetailsModulesData = (ArrayList<PowerPlantDetailsModulesData>)data.getExtras().getSerializable("powerPlantDetailsModulesData");
                //ebSiteElectrificationTransactionData.setObjEbSiteElectrificationElectricConnection(new EbSiteElectrificationElectricConnectionData());
                ebSiteElectrificationTransactionData = ((EbSiteElectrificationTransactionData) b.getSerializable("ebSiteElectrificationTransactionData"));
                Log.e("123", "123");
            }
        }
    }

    private boolean validation() {
        if (ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getNameOfTheSupplyCompany().isEmpty() || ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getNameOfTheSupplyCompany() == null || ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getNameOfTheSupplyCompany().equals("-")) {
            showToast("Name of the Supply Company not found in Electric Connection");
            return false;
        } else if (ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getConsumerNumber().isEmpty() || ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getConsumerNumber() == null || ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getConsumerNumber().equals("-")) {
            showToast("Consumer Number not found in Electric Connection");
            return false;
        } else if (ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getEbMeterSerialNumber().isEmpty() || ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getEbMeterSerialNumber() == null || ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getEbMeterSerialNumber().equals("-")) {
            showToast("EB Meter Serial Number not found in Electric Connection");
            return false;
        } else if (ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getTypeOfElectricConnection().isEmpty() || ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getTypeOfElectricConnection() == null) {
            showToast("Select Type of Electric Connection in Electric Connection");
            return false;
        } else if (ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getTariff().isEmpty() || ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getTariff() == null) {
            showToast("Select Tariff in Electric Connection");
            return false;
        } /*else if (sanctionedLoad.isEmpty() || sanctionedLoad == null) {
            showToast("Enter Sanctioned Load(KVA)");
            return false;
        } else if (existingLoadAtSite.isEmpty() || existingLoadAtSite == null) {
            showToast("Enter Existing load at Site(KVA)");
            return false;
        } else if (securityAmountPaidToTheCompany.isEmpty() || securityAmountPaidToTheCompany == null) {
            showToast("Enter Security Amount paid to the Company");
            return false;
        } else if (copyOfTheElectricBills.isEmpty() || copyOfTheElectricBills == null) {
            showToast("Select Copy of the Electric Bills(Last Three Months)");
            return false;
        } else if (numberOfCompoundLights.isEmpty() || numberOfCompoundLights == null) {
            showToast("Enter Number of Compound Lights");
            return false;
        }*/ else if (ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getEbMeterReadingInKWH().isEmpty() || ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getEbMeterReadingInKWH() == null) {
            showToast("Enter EB Meter Reading(KWH) in Electric Connection");
            return false;
        } /*else if (ebSupplier.isEmpty() || ebSupplier == null) {
            showToast("Select EB Supplier");
            return false;
        } else if ((ebCostPerUnitForSharedConnection.isEmpty() || ebCostPerUnitForSharedConnection == null) && (!ebSupplier.equals("Dedicated Connection"))) {
            showToast("Enter EB Cost Per Unit for Shared Connection");
            return false;
        } else if (ebStatus.isEmpty() || ebStatus == null) {
            showToast("Select EB Status");
            return false;
        } else if (transformerWorkingCondition.isEmpty() || transformerWorkingCondition == null) {
            showToast("Select Transformer Working Condition");
            return false;
        } else if (transformerCapacityInKVA.isEmpty() || transformerCapacityInKVA == null) {
            showToast("Enter Transformer Capacity(KVA)");
            return false;
        } else if (ebMeterBoxStatus.isEmpty() || ebMeterBoxStatus == null) {
            showToast("Select EB Meter Box Status");
            return false;
        } else if (sectionName.isEmpty() || sectionName == null) {
            showToast("Enter Section Name");
            return false;
        } else if (sectionNumber.isEmpty() || sectionNumber == null) {
            showToast("Enter Section Number");
            return false;
        } else if (ebMeterWorkingStatus.isEmpty() || ebMeterWorkingStatus == null) {
            showToast("Select EB Meter Working Status");
            return false;
        } else if (typeOfPayment.isEmpty() || typeOfPayment == null) {
            showToast("Select Type of Payment");
            return false;
        } else if ((ebPaymentSchedule.isEmpty() || ebPaymentSchedule == null) && (typeOfPayment.equals("Post Paid"))) {
            showToast("Select EB Payment Schedule");
            return false;
        } else if (safetyFuseUnit.isEmpty() || safetyFuseUnit == null) {
            showToast("Select Safety Fuse Unit");
            return false;
        } else if (kitkatClayFuseStatus.isEmpty() || kitkatClayFuseStatus == null) {
            showToast("Select KIT-KAT/Clay Fuse Status");
            return false;
        } else if (ebNeutralEarthing.isEmpty() || ebNeutralEarthing == null) {
            showToast("Select EB Neutral Earthing");
            return false;
        } else if (averageEbAvailabilityPerDay.equals("00:00")) {
            showToast("Select Average EB Availability Per Day");
            return false;
        } else if (scheduledPowerCutInHrs.equals("00:00")) {
            showToast("Select Scheduled Power Cut in Hrs");
            return false;
        } else if (ebBillDate.isEmpty() || ebBillDate == null) {
            showToast("Select EB Bill Date");
            return false;
        }*/ else if (ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getTypeModeOfPayment().isEmpty() || ebSiteElectrificationTransactionData.getObjEbSiteElectrificationElectricConnection().getTypeModeOfPayment() == null) {
            showToast("Select Type|Mode of Payment in Electric Connection");
            return false;
        } else return true; /*else if (bankIfscCode.isEmpty() || bankIfscCode == null) {
            showToast("Enter Bank IFSC Code");
            return false;
        } else if (bankAccountNo.isEmpty() || bankAccountNo == null) {
            showToast("Enter Bank Account No");
            return false;
        }*/
    }
}

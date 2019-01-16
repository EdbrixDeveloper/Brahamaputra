package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.abdeveloper.library.MultiSelectDialog;
import com.abdeveloper.library.MultiSelectModel;
import com.brahamaputra.mahindra.brahamaputra.Data.BatteryBankCheckPointsData;
import com.brahamaputra.mahindra.brahamaputra.Data.BatteryBankCheckPointsParentData;
import com.brahamaputra.mahindra.brahamaputra.Data.DgBatteryCheckPointsData;
import com.brahamaputra.mahindra.brahamaputra.Data.DgBatteryCheckPointsParentData;
import com.brahamaputra.mahindra.brahamaputra.Data.PreventiveMaintanceSiteTransactionDetails;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreventiveMaintenanceSiteBatteryBankCheckPointsActivity extends BaseActivity {

    private static final String TAG = PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.class.getSimpleName();

    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal;

    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBattreyBankNumber;

    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewDetailsOfBatteryBankQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView;
    private ImageView mButtonClearDetailsOfBatteryBankQRCodeScanView;

    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTest;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTestVal;
    private ImageView mPreventiveMaintenanceSiteBatteryBankCheckPointsImageViewBatteryBankDischargeTest;

    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorque;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorqueVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyApplied;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyAppliedVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatus;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatusVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatus;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatusVal;

    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal;
    private LinearLayout mPreventiveMaintenanceSiteBatteryBankCheckPointsLinearLayoutTypeOfFaultVal;


    private Button mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading;
    private LinearLayout mPreventiveMaintenanceSiteBatteryBankCheckPointsLinearLayoutTypeOfFault;

    String str_noOfBatteryBankAvailableAtSiteVal = "";
    String str_pmSiteBbcpBatteryBankDischargeTestVal = "";
    String str_pmSiteBbcpStripBoltTightnessAsPerTorque = "";
    String str_pmSiteBbcpPetroleumJellyAppliedVal = "";
    String str_pmSiteBbcpBatteryVentPlugStatusVal = "";
    String str_pmSiteBbcpBBEarthingStatusVal = "";
    String str_pmSiteBbcpRegisterFaultVal = "";
    String str_pmSiteBbcpTypeOfFaultVal = "";

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    private String base64StringDetailsOfBatteryBankQRCodeScan = "";
    //private String imageFileDetailsOfBatteryBankQRCodeScan;
    //private Uri imageFileUriDetailsOfBatteryBankQRCodeScan = null;

    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    private AlertDialogManager alertDialogManager;

    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;

    private PreventiveMaintanceSiteTransactionDetails pmSiteTransactionDetails;
    private ArrayList<BatteryBankCheckPointsData> batteryBankCheckPointsData;

    private BatteryBankCheckPointsParentData dataList;

    private int totalAcCount = 0;
    private int currentPos = 0;

    MultiSelectDialog multiSelectDialog;
    ArrayList<MultiSelectModel> listOfFaultsTypes;
    ArrayList<Integer> alreadySelectedTypeOfFaultList;
    ArrayList<String> typeOfFaultList;

    public static final int RESULT_PRIVENTIVE_MAINTENANCE_SITE_BATTERY_BANK_CHECK = 258;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_battery_bank_check_points);
        this.setTitle("Battery Bank Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sessionManager = new SessionManager(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this, userId, ticketName);

        checkCameraPermission();
        assignViews();
        initCombo();
        setListner();

        pmSiteTransactionDetails = new PreventiveMaintanceSiteTransactionDetails();

        batteryBankCheckPointsData = new ArrayList<>();
        currentPos = 0;

        listOfFaultsTypes = new ArrayList<>();
        alreadySelectedTypeOfFaultList = new ArrayList<>();

        //Code For MultiSelect Type Of Fault
        typeOfFaultList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgBatteryCheckPoints_typeOfFault)));
        int id = 1;
        for (int i = 0; i < typeOfFaultList.size(); i++) {
            listOfFaultsTypes.add(new MultiSelectModel(id, typeOfFaultList.get(i).toString()));
            id++;
        }

        setInputDetails(currentPos);
        invalidateOptionsMenu();
        setMultiSelectModel();


    }

    private void assignViews() {

        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_noOfBatteryBankAvailableAtSite);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_noOfBatteryBankAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBattreyBankNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_battreyBankNumber);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewDetailsOfBatteryBankQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_detailsOfBatteryBankQRCodeScan);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_button_detailsOfBatteryBankQRCodeScan);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_button_detailsOfBatteryBankQRCodeScanView);
        mButtonClearDetailsOfBatteryBankQRCodeScanView = (ImageView) findViewById(R.id.button_ClearDetailsOfBatteryBankQRCodeScanView);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTest = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_batteryBankDischargeTest);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTestVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_batteryBankDischargeTestVal);

        mPreventiveMaintenanceSiteBatteryBankCheckPointsImageViewBatteryBankDischargeTest = (ImageView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_imageview_batteryBankDischargeTest);

        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorque = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_stripBoltTightnessAsPerTorque);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorqueVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_stripBoltTightnessAsPerTorqueVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyApplied = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_petroleumJellyApplied);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyAppliedVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_petroleumJellyAppliedVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_batteryVentPlugStatus);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_batteryVentPlugStatusVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_bbEarthingStatus);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_bbEarthingStatusVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsLinearLayoutTypeOfFaultVal = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_linearLayout_typeOfFault);

        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_button_nextReading);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsLinearLayoutTypeOfFault = (LinearLayout)findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_linearLayout_typeOfFault);
    }

    private void initCombo() {
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteBatteryBankCheckPoints_noOfBatteryBank))),
                        "No of Battery Bank available at Site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfBatteryBankAvailableAtSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal.setText(str_noOfBatteryBankAvailableAtSiteVal);


                        //                mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal;
//                mLinearLayoutContainer;
//                mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBattreyBankNumber;
//                mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScan;
//                mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView;
//                mButtonClearDetailsOfBatteryBankQRCodeScanView;

//                mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTestVal;
//                mPreventiveMaintenanceSiteBatteryBankCheckPointsImageViewBatteryBankDischargeTest;
//
//                mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorqueVal;
//                mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyAppliedVal;
//                mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatusVal;
//                mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatusVal;
//                mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal;
//                mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal;

//                mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonPreviousReading;
//                mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading;


                        str_noOfBatteryBankAvailableAtSiteVal = item.get(position);
                        invalidateOptionsMenu();
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal.setText(str_noOfBatteryBankAvailableAtSiteVal);
                        //mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.setText("");//008

                        if (batteryBankCheckPointsData != null && batteryBankCheckPointsData.size() > 0) {
                            batteryBankCheckPointsData.clear();
                        }
                        currentPos = 0;
                        totalAcCount = 0;
                        clearFields(currentPos);

                        // Clear all field value and hide layout If Non AC or O //
                        if (str_noOfBatteryBankAvailableAtSiteVal.equals("0")) {
                            mLinearLayoutContainer.setVisibility(View.GONE);
                            //mAirConditionersLinearLayoutNumberOfACInWorkingCondition.setVisibility(View.GONE);
                        } else {
                            str_noOfBatteryBankAvailableAtSiteVal = item.get(position);
                            totalAcCount = Integer.parseInt(str_noOfBatteryBankAvailableAtSiteVal);
                            mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBattreyBankNumber.setText("Reading: #1");
                            mLinearLayoutContainer.setVisibility(View.VISIBLE);
                            //mAirConditionersLinearLayoutNumberOfACInWorkingCondition.setVisibility(View.VISIBLE);
                            mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonPreviousReading.setVisibility(View.GONE);
                            mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading.setVisibility(View.VISIBLE);
                            if (totalAcCount > 0 && totalAcCount == 1) {
                                mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading.setText("Finish");
                            } else {
                                mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading.setText("Next Reading");
                            }
                        }


                    }
                });
            }
        });

        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTestVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteBatteryBankCheckPoints_batteryBankDischargeTest))),
                        "Battery Bank Discharge Test",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteBbcpBatteryBankDischargeTestVal = item.get(position);
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTestVal.setText(str_pmSiteBbcpBatteryBankDischargeTestVal);
                        visibilityOfImageViewBatteryBankDischargeTest(str_pmSiteBbcpBatteryBankDischargeTestVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorqueVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteBatteryBankCheckPoints_stripTightnessAsPerTorque))),
                        "Strip Bolt tightness as per torquet",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteBbcpStripBoltTightnessAsPerTorque = item.get(position);
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorqueVal.setText(str_pmSiteBbcpStripBoltTightnessAsPerTorque);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyAppliedVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteBatteryBankCheckPoints_petroleumJellyApplied))),
                        "Petroleum Jelly Applied",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteBbcpPetroleumJellyAppliedVal = item.get(position);
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyAppliedVal.setText(str_pmSiteBbcpPetroleumJellyAppliedVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteBatteryBankCheckPoints_batteryVentPlugStatus))),
                        "Battery Vent plug Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteBbcpBatteryVentPlugStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatusVal.setText(str_pmSiteBbcpBatteryVentPlugStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteBatteryBankCheckPoints_bbEarthingStatus))),
                        "BB Earthing Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteBbcpBBEarthingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatusVal.setText(str_pmSiteBbcpBBEarthingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteBatteryBankCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteBbcpRegisterFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal.setText(str_pmSiteBbcpRegisterFaultVal);
                        visibilityOfTypesOfFault(str_pmSiteBbcpRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiSelectDialog.show(getSupportFragmentManager(), "multiSelectDialog");
                /*SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteBatteryBankCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteBbcpTypeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteBbcpTypeOfFaultVal);
                    }
                });*/
            }
        });

        ;
//                ;

        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonPreviousReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetMultiSelectModel();
                if (checkValidationOfArrayFields() == true) {
                    if (currentPos > 0) {
                        //Save current ac reading
                        saveDGCheckRecords(currentPos);
                        currentPos = currentPos - 1;
                        //move to Next reading
                        displayDGCheckRecords(currentPos);
                        visibilityOfTypesOfFault(mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal.getText().toString().trim());
                    }
                }
            }
        });
        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetMultiSelectModel();
                if (checkValidationOfArrayFields() == true) {
                    if (currentPos < (totalAcCount - 1)) {
                        //Save current ac reading
                        saveDGCheckRecords(currentPos);
                        currentPos = currentPos + 1;
                        //move to Next reading
                        displayDGCheckRecords(currentPos);
                        visibilityOfTypesOfFault(mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal.getText().toString().trim());

                    } else if (currentPos == (totalAcCount - 1)) {
                        saveDGCheckRecords(currentPos);
                        visibilityOfTypesOfFault(mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal.getText().toString().trim());
                        //if (checkValidationOnNoOfAcSelection() == true) {
                        if (checkValidationOnChangeNoOfDgBatteryAvailable(mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal.getText().toString().trim(), "onSubmit") == true) {
                            submitDetails();
                            startActivity(new Intent(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this, PreventiveMaintenanceSiteEarthingCheckPointsActivity.class));
                            finish();
                        }
                    }
                }
            }
        });

    }


    /////////////
    private void setInputDetails(int index) {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");

                Gson gson = new Gson();

                pmSiteTransactionDetails = gson.fromJson(jsonInString, PreventiveMaintanceSiteTransactionDetails.class);
                dataList = pmSiteTransactionDetails.getBatteryBankCheckPointsParentData();
                batteryBankCheckPointsData.addAll(dataList.getBatteryBankCheckPointsData());

                mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal.setText(dataList.getNoOfBatteryBankAvailableAtSite());
                //mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal .setText(dataList.getNumberOfEarthPitVisible());

                str_noOfBatteryBankAvailableAtSiteVal = dataList.getNoOfBatteryBankAvailableAtSite();
                invalidateOptionsMenu();

                /*mAirConditionersLinearLayoutNumberOfACInWorkingCondition.setVisibility(View.GONE);
                if (!dataList.getNumberOfEarthPitVisible().isEmpty() && dataList.getNumberOfEarthPitVisible() != null) {
                    mAirConditionersLinearLayoutNumberOfACInWorkingCondition.setVisibility(View.VISIBLE);
                }
                mAirConditionersTextViewNumberOfACInWorkingConditionVal.setText(dataList.getNumberOfEarthPitVisible());*/


                if (batteryBankCheckPointsData != null && batteryBankCheckPointsData.size() > 0) {
                    mLinearLayoutContainer.setVisibility(View.VISIBLE);
                    mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBattreyBankNumber.setText("Reading: #1");
                    totalAcCount = Integer.parseInt(dataList.getNoOfBatteryBankAvailableAtSite());

                    base64StringDetailsOfBatteryBankQRCodeScan = batteryBankCheckPointsData.get(index).getBase64StringPhotoOfBatteryBank();
                    mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView.setVisibility(View.GONE);
                    mButtonClearDetailsOfBatteryBankQRCodeScanView.setVisibility(View.GONE);

                    if (!base64StringDetailsOfBatteryBankQRCodeScan.isEmpty() && base64StringDetailsOfBatteryBankQRCodeScan != null) {
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView.setVisibility(View.VISIBLE);
                        mButtonClearDetailsOfBatteryBankQRCodeScanView.setVisibility(View.VISIBLE);
                    }

                    mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTestVal.setText(batteryBankCheckPointsData.get(index).getBatteryBankDischargeTest());
                    mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorqueVal.setText(batteryBankCheckPointsData.get(index).getStripBoltTightnessAsPerTorque());
                    mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyAppliedVal.setText(batteryBankCheckPointsData.get(index).getPetroleumJellyApplied());
                    mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatusVal.setText(batteryBankCheckPointsData.get(index).getBatteryVentPlugStatus());
                    mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatusVal.setText(batteryBankCheckPointsData.get(index).getBbEarthingStatus());
                    mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal.setText(batteryBankCheckPointsData.get(index).getRegisterFault());
                    mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal.setText(batteryBankCheckPointsData.get(index).getTypeOfFault());


                    if (batteryBankCheckPointsData.get(index).getTypeOfFault() != null && batteryBankCheckPointsData.get(index).getTypeOfFault().length() > 0 && listOfFaultsTypes.size() > 0) {
                        //setArrayValuesOfTypeOfFault(earthingCheckPointsData.get(index).getTypeOfFault());
                        setArrayValuesOfTypeOfFault(mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal.getText().toString().trim());
                    }

                    mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonPreviousReading.setVisibility(View.GONE);
                    mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading.setVisibility(View.VISIBLE);

                    //if (airConditionersData.size() > 1) {
                    if (totalAcCount > 1) {
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading.setText("Next Reading");
                    } else {
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading.setText("Finish");
                    }
                }

            } else {
                showToast("No previous saved data available");
                mLinearLayoutContainer.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void setMultiSelectModel() {
        //MultiSelectModel
        multiSelectDialog = new MultiSelectDialog()
                .title("Type of Fault") //setting title for dialog
                .titleSize(25)
                .positiveText("Done")
                .negativeText("Cancel")
                .preSelectIDsList(alreadySelectedTypeOfFaultList)
                .setMinSelectionLimit(0)
                .setMaxSelectionLimit(typeOfFaultList.size())
                //List of ids that you need to be selected
                .multiSelectList(listOfFaultsTypes) // the multi select model list with ids and name
                .onSubmit(new MultiSelectDialog.SubmitCallbackListener() {
                    @Override
                    public void onSelected(ArrayList<Integer> selectedIds, ArrayList<String> selectedNames, String dataString) {
                        //will return list of selected IDS
                        str_pmSiteBbcpTypeOfFaultVal = dataString;
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteBbcpTypeOfFaultVal);

                        /*str_pmSiteBbcpTypeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteBbcpTypeOfFaultVal);*/
                    }

                    @Override
                    public void onCancel() {
                        Log.d(TAG, "Dialog cancelled");
                    }
                });
    }

    private void resetMultiSelectModel() {
        alreadySelectedTypeOfFaultList = new ArrayList<>();
        setMultiSelectModel();
    }

    private void setArrayValuesOfTypeOfFault(String TypeOfFault) {

        if (!TypeOfFault.isEmpty() && TypeOfFault != null) {
            List<String> items = Arrays.asList(TypeOfFault.split("\\s*,\\s*"));
            for (String ss : items) {
                for (MultiSelectModel c : listOfFaultsTypes) {
                    if (ss.equals(c.getName())) {
                        alreadySelectedTypeOfFaultList.add(c.getId());
                        break;
                    }
                }
            }
        }
    }

    private void saveDGCheckRecords(int pos) {

        String detailsOfBatteryBankQRCodeScan = base64StringDetailsOfBatteryBankQRCodeScan;
        String batteryBankDischargeTest = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTestVal.getText().toString().trim();
        String stripBoltTightnessAsPerTorque = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorqueVal.getText().toString().trim();
        String petroleumJellyApplied = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyAppliedVal.getText().toString().trim();
        String batteryVentPlugStatus = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatusVal.getText().toString().trim();
        String bbEarthingStatus = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatusVal.getText().toString().trim();
        String registerFault = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal.getText().toString().trim();
        String typeOfFault = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal.getText().toString().trim();


        BatteryBankCheckPointsData batteryBankCheckPointsDataChild = new BatteryBankCheckPointsData(

                detailsOfBatteryBankQRCodeScan, batteryBankDischargeTest, stripBoltTightnessAsPerTorque,
                 petroleumJellyApplied, "", batteryVentPlugStatus,  bbEarthingStatus,
                 registerFault, typeOfFault, "",
                "", "", "", "",
                "","" , "", "",
                "", "", "","" ,
                "", "", "",
                "", "", "", "",
                "", "","" ,"" ,
                "","" ,"" ,"" ,
                "",  "",  "", "" ,
                "",  "", "" ,""  ,
                "", "" , "" , "" ,
                "",  "", "" ,
                "",  "",
                "",  "",""  ,
                "",  "", "" ,
                "", "" ,  "", "" ,
                "",  "",  "",
                "",  "",  "",
                ""

        );

        /*batteryBankCheckPointsDataChild.setDetailsOfBatteryBankQrCodeScan(detailsOfBatteryBankQRCodeScan);
        batteryBankCheckPointsDataChild.setBatteryBankDischargeTest(batteryBankDischargeTest);
        batteryBankCheckPointsDataChild.setStripBoltTightnessAsPerTorque(stripBoltTightnessAsPerTorque);
        batteryBankCheckPointsDataChild.setPetroleumJellyApplied(petroleumJellyApplied);
        batteryBankCheckPointsDataChild.setBatteryVentPlugStatus(batteryVentPlugStatus);
        batteryBankCheckPointsDataChild.setBbEarthingStatus(bbEarthingStatus);
        batteryBankCheckPointsDataChild.setRegisterFault(registerFault);
        batteryBankCheckPointsDataChild.setTypeOfFault(typeOfFault);*/

        if (batteryBankCheckPointsData.size() > 0) {
            if (pos == batteryBankCheckPointsData.size()) {
                batteryBankCheckPointsData.add(batteryBankCheckPointsDataChild);
            } else if (pos < batteryBankCheckPointsData.size()) {
                batteryBankCheckPointsData.set(pos, batteryBankCheckPointsDataChild);
            }
        } else {
            batteryBankCheckPointsData.add(batteryBankCheckPointsDataChild);
        }
    }

    private void displayDGCheckRecords(int pos) {

        if (batteryBankCheckPointsData.size() > 0 && pos < batteryBankCheckPointsData.size()) {

            mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBattreyBankNumber.setText("Reading: #" + (pos + 1));

            base64StringDetailsOfBatteryBankQRCodeScan = batteryBankCheckPointsData.get(pos).getBase64StringPhotoOfBatteryBank();
            mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView.setVisibility(View.GONE);
            mButtonClearDetailsOfBatteryBankQRCodeScanView.setVisibility(View.GONE);

            if (!base64StringDetailsOfBatteryBankQRCodeScan.isEmpty() && base64StringDetailsOfBatteryBankQRCodeScan != null) {
                mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView.setVisibility(View.VISIBLE);
                mButtonClearDetailsOfBatteryBankQRCodeScanView.setVisibility(View.VISIBLE);
            }


            mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTestVal.setText(batteryBankCheckPointsData.get(pos).getBatteryBankDischargeTest());
            mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorqueVal.setText(batteryBankCheckPointsData.get(pos).getStripBoltTightnessAsPerTorque());
            mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyAppliedVal.setText(batteryBankCheckPointsData.get(pos).getPetroleumJellyApplied());
            mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatusVal.setText(batteryBankCheckPointsData.get(pos).getBatteryVentPlugStatus());
            mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatusVal.setText(batteryBankCheckPointsData.get(pos).getBbEarthingStatus());
            mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal.setText(batteryBankCheckPointsData.get(pos).getRegisterFault());
            mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal.setText(batteryBankCheckPointsData.get(pos).getTypeOfFault());


            if (batteryBankCheckPointsData.get(pos).getTypeOfFault() != null && batteryBankCheckPointsData.get(pos).getTypeOfFault().length() > 0 && listOfFaultsTypes.size() > 0) {
                alreadySelectedTypeOfFaultList = new ArrayList<>();
                //setArrayValuesOfTypeOfFault(earthingCheckPointsData.get(pos).getTypeOfFault());
                setArrayValuesOfTypeOfFault(mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal.getText().toString().trim());
                setMultiSelectModel();
            }

            mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonPreviousReading.setVisibility(View.VISIBLE);
            mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading.setVisibility(View.VISIBLE);

        } else {
            clearFields(pos);
        }

        if (pos > 0 && pos < (totalAcCount - 1)) {
            mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonPreviousReading.setVisibility(View.VISIBLE);
            mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading.setText("Next Reading");
        } else if (pos > 0 && pos == (totalAcCount - 1)) {
            mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonPreviousReading.setVisibility(View.VISIBLE);
            mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading.setText("Finish");
        } else if (pos == 0) {
            mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonPreviousReading.setVisibility(View.GONE);
            if (pos == (totalAcCount - 1)) {
                mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading.setText("Finish");
            } else {
                mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading.setText("Next Reading");
            }
        }

    }

    private void submitDetails() {
        try {

            String noOfBatteryBankAvailableAtSiteVal = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal.getText().toString().trim();
            //String numberOfEarthPitVisible = mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.getText().toString().trim();

            dataList = new BatteryBankCheckPointsParentData(noOfBatteryBankAvailableAtSiteVal, batteryBankCheckPointsData);

            pmSiteTransactionDetails.setBatteryBankCheckPointsParentData(dataList);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(pmSiteTransactionDetails);

            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearFields(int indexPos) {

        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBattreyBankNumber.setText("Reading: #" + (indexPos + 1));


        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTestVal.setText("");

        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorqueVal.setText("");
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyAppliedVal.setText("");
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatusVal.setText("");
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatusVal.setText("");
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal.setText("");
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal.setText("");


        str_noOfBatteryBankAvailableAtSiteVal = "";

        str_pmSiteBbcpBatteryBankDischargeTestVal = "";
        str_pmSiteBbcpStripBoltTightnessAsPerTorque = "";
        str_pmSiteBbcpPetroleumJellyAppliedVal = "";
        str_pmSiteBbcpBatteryVentPlugStatusVal = "";
        str_pmSiteBbcpBBEarthingStatusVal = "";
        str_pmSiteBbcpRegisterFaultVal = "";
        str_pmSiteBbcpTypeOfFaultVal = "";

        base64StringDetailsOfBatteryBankQRCodeScan = "";

        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView.setVisibility(View.GONE);
        mButtonClearDetailsOfBatteryBankQRCodeScanView.setVisibility(View.GONE);

    }

    public boolean checkValidationOnChangeNoOfDgBatteryAvailable(String NoOfBatteryBankAvailableAtSiteVal, String methodFlag) {

        if (NoOfBatteryBankAvailableAtSiteVal.isEmpty() || NoOfBatteryBankAvailableAtSiteVal == null) {
            showToast("Select No of Battery Bank Available");
            return false;
        } else if ((batteryBankCheckPointsData.size() != Integer.valueOf(NoOfBatteryBankAvailableAtSiteVal) && methodFlag.equals("onSubmit"))) {
            showToast("Complete the all readings.");//as a mentioned AC in no of AC provided
            return false;
        } else return true;


        /*String noOfEarthPitValue, String noOfEarthPitValueVisible,
        if (noOfEarthPitValue.isEmpty() || noOfEarthPitValue == null) {
            showToast("Select No of Earth Pit");
            return false;
        } else if (Integer.valueOf(noOfEarthPitValueVisible) > 0) {
            if (noOfEarthPitValueVisible.isEmpty() || noOfEarthPitValueVisible == null) {
                showToast("Select Number of Earth Pit Visible");
                return false;
            } else if (Integer.valueOf(noOfEarthPitValueVisible) > Integer.valueOf(noOfEarthPitValue)) {
                showToast("Select Earth Pit Visible is less than or equal to Earth Pit");
                return false;
            } else if ((batteryBankCheckPointsData.size() != Integer.valueOf(noOfEarthPitValue) && methodFlag.equals("onSubmit"))) {
                showToast("Complete the all readings.");//as a mentioned AC in no of AC provided
                return false;
            } else return true;
        } else return true;*/

    }

    //////////////////


    private void visibilityOfImageViewBatteryBankDischargeTest(String str_pmSiteBbcpBatteryBankDischargeTestVal) {
        mPreventiveMaintenanceSiteBatteryBankCheckPointsImageViewBatteryBankDischargeTest.setVisibility(View.GONE);
        if (str_pmSiteBbcpBatteryBankDischargeTestVal.equals("Execute BD Test")) {
            mPreventiveMaintenanceSiteBatteryBankCheckPointsImageViewBatteryBankDischargeTest.setVisibility(View.VISIBLE);
        }
    }



    private void setListner() {

        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    DetailsOfBatteryBankQRCodeScan();
                }
            }
        });

        mButtonClearDetailsOfBatteryBankQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                base64StringDetailsOfBatteryBankQRCodeScan = "";
                mButtonClearDetailsOfBatteryBankQRCodeScanView.setVisibility(View.GONE);
                mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView.setVisibility(View.GONE);
                showToast("Cleared");
            }
        });

        mPreventiveMaintenanceSiteBatteryBankCheckPointsImageViewBatteryBankDischargeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this, PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.class);
                //intent.putExtra("ticketName", "");

                startActivityForResult(intent, RESULT_PRIVENTIVE_MAINTENANCE_SITE_BATTERY_BANK_CHECK);

            }
        });
    }

    private void DetailsOfBatteryBankQRCodeScan() {
        try {
            IntentIntegrator integrator = new IntentIntegrator(this);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
            integrator.setPrompt("Scan QRcode");
            integrator.setOrientationLocked(true);
            integrator.setRequestCode(MY_PERMISSIONS_REQUEST_CAMERA);
            integrator.initiateScan();

            //        Use this for more customization
            //        IntentIntegrator integrator = new IntentIntegrator(this);
            //        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
            //        integrator.setPrompt("Scan a barcode");
            //        integrator.setCameraId(0);  // Use a specific camera of the device
            //        integrator.setBeepEnabled(false);
            //        integrator.setBarcodeImageEnabled(true);
            //        integrator.initiateScan();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkCameraPermission() {

        if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
        } else {
            return true;
        }


        return false;
    }

    private void visibilityOfTypesOfFault(String RegisterFault) {

        mPreventiveMaintenanceSiteBatteryBankCheckPointsLinearLayoutTypeOfFaultVal.setVisibility(View.GONE);
        if (RegisterFault.equals("Yes")) {
           // mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal.setText("");
            mPreventiveMaintenanceSiteBatteryBankCheckPointsLinearLayoutTypeOfFaultVal.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA:
                IntentResult result = IntentIntegrator.parseActivityResult(resultCode, data);
                if (result != null) {
                    mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView.setVisibility(View.GONE);
                    mButtonClearDetailsOfBatteryBankQRCodeScanView.setVisibility(View.GONE);
                    if (result.getContents() == null) {
                        base64StringDetailsOfBatteryBankQRCodeScan = "";
                        showToast("Cancelled");
                    } else {
                        /*Object[] isDuplicateQRcode = isDuplicateQRcode(result.getContents());
                        boolean flagIsDuplicateQRcode = (boolean) isDuplicateQRcode[1];
                        if (!flagIsDuplicateQRcode) {*/
                        base64StringDetailsOfBatteryBankQRCodeScan = result.getContents();
                        if (!base64StringDetailsOfBatteryBankQRCodeScan.isEmpty() && base64StringDetailsOfBatteryBankQRCodeScan != null) {
                            mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView.setVisibility(View.VISIBLE);
                            mButtonClearDetailsOfBatteryBankQRCodeScanView.setVisibility(View.VISIBLE);
                        }
                        /*} else {
                            base64StringDetailsOfBatteryBankQRCodeScan = "";
                            showToast("This QR Code Already Used in " + isDuplicateQRcode[0] + " Section");
                        }*/
                    }
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.submit_icon_menu, menu);
        MenuItem shareItem = menu.findItem(R.id.menuSubmit);

        // show the button when some condition is true
        shareItem.setVisible(true);
        if (str_noOfBatteryBankAvailableAtSiteVal != null && !str_noOfBatteryBankAvailableAtSiteVal.isEmpty()) {
            if (Integer.valueOf(str_noOfBatteryBankAvailableAtSiteVal) > 0) {
                shareItem.setVisible(false);
            }
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
                //submitDetails();

                str_noOfBatteryBankAvailableAtSiteVal = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal.getText().toString();

                if (str_noOfBatteryBankAvailableAtSiteVal == null || str_noOfBatteryBankAvailableAtSiteVal.equals("")) {
                    showToast("Please select no of ac");
                } else {
                    if (checkValidationOnChangeNoOfDgBatteryAvailable(mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal.getText().toString().trim(), "onSubmit") == true) {
                        submitDetails();
                        startActivity(new Intent(this, PreventiveMaintenanceSiteEarthingCheckPointsActivity.class));
                        finish();
                    }
                }

                //startActivity(new Intent(this, PreventiveMaintenanceSiteEarthingCheckPointsActivity.class));
                //finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }

    public boolean checkValidationOfArrayFields() {
        String noOfBatteryBankAvailableAtSite = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal.getText().toString().trim();
        String qrCodeScan = base64StringDetailsOfBatteryBankQRCodeScan;
        String batteryBankDischargeTest = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTestVal.getText().toString().trim();
        String stripBoltTightnessAsPerTorque = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorqueVal.getText().toString().trim();
        String petroleumJellyApplied = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyAppliedVal.getText().toString().trim();
        String batteryVentPlugStatus = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatusVal.getText().toString().trim();
        String bbEarthingStatus = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatusVal.getText().toString().trim();
        String registerFault = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal.getText().toString().trim();
        String typeOfFault = mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal.getText().toString().trim();

        if (noOfBatteryBankAvailableAtSite.isEmpty() || noOfBatteryBankAvailableAtSite == null) {
            showToast("Select No Of Battery Bank Available At Site");
            return false;
        }else if(qrCodeScan.isEmpty() || qrCodeScan == null) {
            showToast("Scan QR Code");
            return false;
        }else if(batteryBankDischargeTest.isEmpty() || batteryBankDischargeTest == null) {
            showToast("Select Battery Bank Discharge Test");
            return false;
        }else if(stripBoltTightnessAsPerTorque.isEmpty() || stripBoltTightnessAsPerTorque == null) {
            showToast("Select Strip Bolt Tightness As Per Torque");
            return false;
        }else if(petroleumJellyApplied.isEmpty() || petroleumJellyApplied == null) {
            showToast("Select Petroleum Jelly Applied");
            return false;
        }else if(batteryVentPlugStatus.isEmpty() || batteryVentPlugStatus == null) {
            showToast("Select Battery Vent Plug Status");
            return false;
        }else if(bbEarthingStatus.isEmpty() || bbEarthingStatus == null) {
            showToast("Select BB Earthing Status");
            return false;
        }else if(registerFault.isEmpty() || registerFault == null) {
            showToast("Select Register Fault");
            return false;
        }else if((typeOfFault.isEmpty() || typeOfFault == null) && registerFault.equals("Yes")) {
            showToast("Select Types Of Fault");
            return false;
        }else return true;
    }
}

package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.BuildConfig;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class PreventiveMaintenanceSiteAcCheckPointsActivity extends BaseActivity {

    private static final String TAG = PreventiveMaintenanceSiteAcCheckPointsActivity.class.getSimpleName();

    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewNoOfAcAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewNoOfAcAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcNumber;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonQRCodeScanView;
    private ImageView mButtonClearQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcWorkingCondition;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcWorkingConditionVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAutomationOfAcController;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAutomationOfAcControllerVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcEarthingStatus;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcEarthingStatusVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcFilterStatus;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcFilterStatusVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewPhotoOfAcFiltersBeforeCleaning;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersBeforeCleaning;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersBeforeCleaningView;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewPhotoOfAcFiltersAfterCleaning;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersAfterCleaning;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersAfterCleaningView;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewCleaningOfCooling;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewCleaningOfCoolingVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAbnormalSoundOfMotor;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAbnormalSoundOfMotorVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterTemperature;
    private EditText mPreventiveMaintenanceSiteAcCheckPointsEditTextShelterTemperature;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewPhotoOfTemperature;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfTemperature;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfTemperatureView;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterDoorStatus;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterDoorStatusVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteAcCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteAcCheckPointsButtonNextReading;

    String str_pmSiteAcpNoOfAcAvailableAtSiteVal = "";
    String str_pmSiteAcpWorkingConditionOfAcVal = "";
    String str_pmSiteAcpAutomationOfAcControllerVal = "";
    String str_pmSiteAcpAcEarthingStatusVal = "";
    String str_pmSiteAcpAcFilterStatusVal = "";
    String str_pmSiteAcpCleaningOfCoolingOrCondensorCoilsVal = "";
    String str_pmSiteAcpAnyAbnormalSoundFromMotorVal = "";
    String str_pmSiteAcpShelterDoorStatusVal = "";
    String str_pmSiteAcpRegisterFaultVal = "";
    String str_pmSiteAcpTypeOfFaultVal = "";

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_TakePhotoOfAcFiltersBeforeCleaning = 101;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_TakePhotoOfAcFiltersAfterCleaning = 102;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_TakePhotoOfTemperature = 103;

    private String base64StringAcCheckPointsQRCodeScan = "";
    //private String imageFileAcCheckPointsQRCodeScan;
    //private Uri imageFileUriAcCheckPointsQRCodeScan = null;

    private String base64StringTakePhotoOfAcFiltersBeforeCleaning = "";
    private String base64StringTakePhotoOfAcFiltersAfterCleaning = "";
    private String base64StringTakePhotoOfTemperature = "";

    private String imageFileAcFiltersBeforeCleaning;
    private String imageFileAcFiltersAfterCleaning;
    private String imageFileTemperature;

    private Uri imageFileUriAcFiltersBeforeCleaning = null;
    private Uri imageFileUriAcFiltersAfterCleaning = null;
    private Uri imageFileUriTemperature = null;

    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    private AlertDialogManager alertDialogManager;

    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    /*private HotoTransactionData hotoTransactionData;
    private LandDetailsData landDetailsData;*/
    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_ac_check_points);
        this.setTitle("AC Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();
        checkCameraPermission();
        setListner();
        sessionManager = new SessionManager(PreventiveMaintenanceSiteAcCheckPointsActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteAcCheckPointsActivity.this, userId, ticketName);

    }

    private void initCombo() {
        mPreventiveMaintenanceSiteAcCheckPointsTextViewNoOfAcAvailableAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAcCheckPoints_noOfAcAvailableAtSite))),
                        "No of AC available at site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpNoOfAcAvailableAtSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteAcCheckPointsTextViewNoOfAcAvailableAtSiteVal.setText(str_pmSiteAcpNoOfAcAvailableAtSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcWorkingConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAcCheckPoints_workingConditionOfAc))),
                        "Working Condition of AC",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpWorkingConditionOfAcVal = item.get(position);
                        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcWorkingConditionVal.setText(str_pmSiteAcpWorkingConditionOfAcVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAcCheckPointsTextViewAutomationOfAcControllerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAcCheckPoints_automationOfAcController))),
                        "Automation of AC Controller",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpAutomationOfAcControllerVal = item.get(position);
                        mPreventiveMaintenanceSiteAcCheckPointsTextViewAutomationOfAcControllerVal.setText(str_pmSiteAcpAutomationOfAcControllerVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcEarthingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAcCheckPoints_acEarthingStatus))),
                        "AC Earthing Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpAcEarthingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcEarthingStatusVal.setText(str_pmSiteAcpAcEarthingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcFilterStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAcCheckPoints_acFilterStatus))),
                        "AC Filter Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpAcFilterStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcFilterStatusVal.setText(str_pmSiteAcpAcFilterStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAcCheckPointsTextViewCleaningOfCoolingVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAcCheckPoints_cleaningOfCoolingOrCondensorCoils))),
                        "Cleaning of Cooling/Condensor Coils",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpCleaningOfCoolingOrCondensorCoilsVal = item.get(position);
                        mPreventiveMaintenanceSiteAcCheckPointsTextViewCleaningOfCoolingVal.setText(str_pmSiteAcpCleaningOfCoolingOrCondensorCoilsVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAcCheckPointsTextViewAbnormalSoundOfMotorVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAcCheckPoints_anyAbnormalSoundFromMotor))),
                        "Any abnormal Sound from Motor",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpAnyAbnormalSoundFromMotorVal = item.get(position);
                        mPreventiveMaintenanceSiteAcCheckPointsTextViewAbnormalSoundOfMotorVal.setText(str_pmSiteAcpAnyAbnormalSoundFromMotorVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterDoorStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAcCheckPoints_shelterDoorStatus))),
                        "Shelter Door Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpShelterDoorStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterDoorStatusVal.setText(str_pmSiteAcpShelterDoorStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAcCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAcCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpRegisterFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteAcCheckPointsTextViewRegisterFaultVal.setText(str_pmSiteAcpRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAcCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAcCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpTypeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteAcCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteAcpTypeOfFaultVal);
                    }
                });
            }
        });
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteAcCheckPointsTextViewNoOfAcAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_noOfAcAvailableAtSite);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewNoOfAcAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_noOfAcAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acNumber);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_QRCodeScan);
        mPreventiveMaintenanceSiteAcCheckPointsButtonQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_QRCodeScan);
        mPreventiveMaintenanceSiteAcCheckPointsButtonQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_QRCodeScanView);
        mButtonClearQRCodeScanView = (ImageView) findViewById(R.id.button_ClearQRCodeScanView);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcWorkingCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acWorkingCondition);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcWorkingConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acWorkingConditionVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAutomationOfAcController = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_automationOfAcController);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAutomationOfAcControllerVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_automationOfAcControllerVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acEarthingStatus);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acEarthingStatusVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcFilterStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acFilterStatus);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcFilterStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acFilterStatusVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewPhotoOfAcFiltersBeforeCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_photoOfAcFiltersBeforeCleaning);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersBeforeCleaning = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_photoOfAcFiltersBeforeCleaning);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersBeforeCleaningView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_photoOfAcFiltersBeforeCleaningView);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewPhotoOfAcFiltersAfterCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_photoOfAcFiltersAfterCleaning);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersAfterCleaning = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_photoOfAcFiltersAfterCleaning);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersAfterCleaningView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_photoOfAcFiltersAfterCleaningView);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewCleaningOfCooling = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_cleaningOfCooling);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewCleaningOfCoolingVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_cleaningOfCoolingVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAbnormalSoundOfMotor = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_abnormalSoundOfMotor);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAbnormalSoundOfMotorVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_abnormalSoundOfMotorVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterTemperature = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_shelterTemperature);
        mPreventiveMaintenanceSiteAcCheckPointsEditTextShelterTemperature = (EditText) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_editText_shelterTemperature);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewPhotoOfTemperature = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_photoOfTemperature);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfTemperature = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_photoOfTemperature);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfTemperatureView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_photoOfTemperatureView);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterDoorStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_shelterDoorStatus);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterDoorStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_shelterDoorStatusVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteAcCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_nextReading);
    }

    private boolean checkCameraPermission() {

        if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteAcCheckPointsActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PreventiveMaintenanceSiteAcCheckPointsActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
        } else {
            return true;
        }


        return false;
    }

    private void setListner() {

        mPreventiveMaintenanceSiteAcCheckPointsButtonQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    AcCheckPointsQRCodeScan();
                }
            }
        });

        mButtonClearQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                base64StringAcCheckPointsQRCodeScan = "";
                mButtonClearQRCodeScanView.setVisibility(View.GONE);
                mPreventiveMaintenanceSiteAcCheckPointsButtonQRCodeScanView.setVisibility(View.GONE);
                showToast("Cleared");
            }
        });

        ///////////////

        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersBeforeCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    takePhotoOfAcFiltersBeforeCleaning();
                }
            }
        });

        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersAfterCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    takePhotoOfAcFiltersAfterCleaning();
                }
            }
        });

        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    takePhotoOfTemperature();
                }
            }
        });
        //////////////////////////

        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersBeforeCleaningView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriAcFiltersBeforeCleaning != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this, imageFileUriAcFiltersBeforeCleaning);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteAcCheckPointsActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersAfterCleaningView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriAcFiltersAfterCleaning != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this, imageFileUriAcFiltersAfterCleaning);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteAcCheckPointsActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfTemperatureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriTemperature != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteAcCheckPointsActivity.this, imageFileUriTemperature);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteAcCheckPointsActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void AcCheckPointsQRCodeScan() {
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

    private void takePhotoOfAcFiltersBeforeCleaning() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileAcFiltersBeforeCleaning = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_sitePremises.jpg";
            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileAcFiltersBeforeCleaning);
            imageFileUriAcFiltersBeforeCleaning = FileProvider.getUriForFile(PreventiveMaintenanceSiteAcCheckPointsActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriAcFiltersBeforeCleaning);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_TakePhotoOfAcFiltersBeforeCleaning);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void takePhotoOfAcFiltersAfterCleaning() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileAcFiltersAfterCleaning = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_sitePremises.jpg";
            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileAcFiltersAfterCleaning);
            imageFileUriAcFiltersAfterCleaning = FileProvider.getUriForFile(PreventiveMaintenanceSiteAcCheckPointsActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriAcFiltersAfterCleaning);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_TakePhotoOfAcFiltersAfterCleaning);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void takePhotoOfTemperature() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileTemperature = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_sitePremises.jpg";
            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileTemperature);
            imageFileUriTemperature = FileProvider.getUriForFile(PreventiveMaintenanceSiteAcCheckPointsActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriTemperature);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_TakePhotoOfTemperature);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA:
                IntentResult result = IntentIntegrator.parseActivityResult(resultCode, data);
                if (result != null) {
                    mPreventiveMaintenanceSiteAcCheckPointsButtonQRCodeScanView.setVisibility(View.GONE);
                    mButtonClearQRCodeScanView.setVisibility(View.GONE);
                    if (result.getContents() == null) {
                        base64StringAcCheckPointsQRCodeScan = "";
                        showToast("Cancelled");
                    } else {
                        /*Object[] isDuplicateQRcode = isDuplicateQRcode(result.getContents());
                        boolean flagIsDuplicateQRcode = (boolean) isDuplicateQRcode[1];
                        if (!flagIsDuplicateQRcode) {*/
                        base64StringAcCheckPointsQRCodeScan = result.getContents();
                        if (!base64StringAcCheckPointsQRCodeScan.isEmpty() && base64StringAcCheckPointsQRCodeScan != null) {
                            mPreventiveMaintenanceSiteAcCheckPointsButtonQRCodeScanView.setVisibility(View.VISIBLE);
                            mButtonClearQRCodeScanView.setVisibility(View.VISIBLE);
                        }
                        /*} else {
                            base64StringAcCheckPointsQRCodeScan = "";
                            showToast("This QR Code Already Used in " + isDuplicateQRcode[0] + " Section");
                        }*/
                    }
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_TakePhotoOfAcFiltersBeforeCleaning:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriAcFiltersBeforeCleaning != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriAcFiltersBeforeCleaning);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringTakePhotoOfAcFiltersBeforeCleaning = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersBeforeCleaningView.setVisibility(View.VISIBLE);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileAcFiltersBeforeCleaning = "";
                    imageFileUriAcFiltersBeforeCleaning = null;
                    mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersBeforeCleaningView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_TakePhotoOfAcFiltersAfterCleaning:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriAcFiltersAfterCleaning != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriAcFiltersAfterCleaning);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringTakePhotoOfAcFiltersAfterCleaning = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersAfterCleaningView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileAcFiltersAfterCleaning = "";
                    imageFileUriAcFiltersAfterCleaning = null;
                    mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersAfterCleaningView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_TakePhotoOfTemperature:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriTemperature != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriTemperature);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringTakePhotoOfTemperature = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfTemperatureView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileTemperature = "";
                    imageFileUriTemperature = null;
                    mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfTemperatureView.setVisibility(View.GONE);
                }
                break;
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
                onBackPressed();
                return true;

            case R.id.menuSubmit:
                //submitDetails();
                startActivity(new Intent(this, PreventiveMaintenanceSiteSmpsCheckPointsActivity.class));
                finish();
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
}

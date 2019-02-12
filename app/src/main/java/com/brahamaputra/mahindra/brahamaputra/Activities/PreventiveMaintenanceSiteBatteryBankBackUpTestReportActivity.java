package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.text.InputFilter;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.BuildConfig;
import com.brahamaputra.mahindra.brahamaputra.Data.BatteryBankCheckPointsChildData;
import com.brahamaputra.mahindra.brahamaputra.Data.BatteryBankCheckPointsParentData;
import com.brahamaputra.mahindra.brahamaputra.Data.PreventiveMaintanceSiteTransactionDetails;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.DecimalConversion;
import com.brahamaputra.mahindra.brahamaputra.Utils.DecimalDigitsInputFilter;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity extends BaseActivity {

    private static final String TAG = PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.class.getSimpleName();


    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewDetailsOfQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonDetailsOfQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonDetailsOfQRCodeScanView;
    private ImageView mButtonClearBatteryBankBackUpTestReportDetailsOfQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewTicketNo;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewTicketNoVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCustomer;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCustomerVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCircle;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCircleVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewState;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewStateVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteName;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteNameVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteId;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteIdVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSsa;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSsaVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewUserFseNameDesignation;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewUserFseNameDesignationVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryType;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryTypeVal;
    private LinearLayout mLinearLayoutBatteryTypeLiIonReadings;
    private EditText mBdTestVoltageModuleReading1EditText1;
    private EditText mBdTestCurrentModuleReading1EditText1;
    private EditText mBdTestSocModuleReadingEditText1;
    private EditText mBdTestSohModuleReadingEditText1;
    private EditText mBdTestVoltageModuleReading1EditText2;
    private EditText mBdTestCurrentModuleReading1EditText2;
    private EditText mBdTestSocModuleReadingEditText2;
    private EditText mBdTestSohModuleReadingEditText2;
    private EditText mBdTestVoltageModuleReading1EditText3;
    private EditText mBdTestCurrentModuleReading1EditText3;
    private EditText mBdTestSocModuleReadingEditText3;
    private EditText mBdTestSohModuleReadingEditText3;
    private LinearLayout mLinearLayoutBatteryTypeVRLAAndVRLAPlusReadings;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBattreyBankCellNumber;
    private EditText mBdTestCellReadingEditText1;
    private EditText mBdTestCellReadingEditText2;
    private EditText mBdTestCellReadingEditText3;
    private EditText mBdTestCellReadingEditText4;
    private EditText mBdTestCellReadingEditText5;
    private EditText mBdTestCellReadingEditText6;
    private EditText mBdTestCellReadingEditText7;
    private EditText mBdTestCellReadingEditText8;
    private EditText mBdTestCellReadingEditText9;
    private EditText mBdTestCellReadingEditText10;
    private EditText mBdTestCellReadingEditText11;
    private EditText mBdTestCellReadingEditText12;
    private EditText mBdTestCellReadingEditText13;
    private EditText mBdTestCellReadingEditText14;
    private EditText mBdTestCellReadingEditText15;
    private EditText mBdTestCellReadingEditText16;
    private EditText mBdTestCellReadingEditText17;
    private EditText mBdTestCellReadingEditText18;
    private EditText mBdTestCellReadingEditText19;
    private EditText mBdTestCellReadingEditText20;
    private EditText mBdTestCellReadingEditText21;
    private EditText mBdTestCellReadingEditText22;
    private EditText mBdTestCellReadingEditText23;
    private EditText mBdTestCellReadingEditText24;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewFloatVoltageInSmpsBusBarAfter30Min;
    private EditText mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageInSmpsBusBarAfter30Min;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewTotalLoadCurrentInAmps;
    private EditText mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextTotalLoadCurrentInAmps;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankMake;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankMakeVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankCapacity;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankCapacityVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfWorkingRectifireModule;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfWorkingRectifireModuleVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteLoadOnBatteryInAmps;
    private EditText mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSiteLoadOnBatteryInAmps;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewFloatVoltageBeforeBbTest;
    private EditText mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageBeforeBbTest;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSingleModuleRating;
    private EditText mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSingleModuleRating;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfBatteryModule;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfBatteryModuleVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewReadingTaketAt;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewReadingTaketAtVal;

    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewLastReadingTaketAt;
    private EditText mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextLastReadingTaketAtVal;

    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewPhotoOfBatteryBank;
    private ImageView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPhotoOfBatteryBank;
    private ImageView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPhotoOfBatteryBankView;
    private TextView mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewRemarks;
    private EditText mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextRemarks;

    private Button mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonNextReading;

    private String str_readingTaketAtVal = "";
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_PhotoOfBatteryBank = 101;

    private String base64StringDetailsOfBatteryBankQRCodeScan = "";

    private String base64StringPhotoOfBatteryBank = "";
    private String imageFilePhotoOfBatteryBank;
    private Uri imageFileUriPhotoOfBatteryBank = null;


    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    private AlertDialogManager alertDialogManager;

    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;

    private PreventiveMaintanceSiteTransactionDetails pmSiteTransactionDetails;
    private BatteryBankCheckPointsParentData batteryBankCheckPointsData;
    private ArrayList<BatteryBankCheckPointsChildData> batteryBankCheckPointschildData;
    private int totalAcCount = 6;
    private int currentPos = 0;

    DecimalConversion decimalConversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_battery_bank_back_up_test_report);
        this.setTitle("Battery Bank Back Up Test Report");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        decimalConversion = new DecimalConversion();
        assignViews();
        sessionManager = new SessionManager(PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.this, userId, ticketName);
        pmSiteTransactionDetails = new PreventiveMaintanceSiteTransactionDetails();
        initCombo();
        setListner();
        batteryBankCheckPointsData = new BatteryBankCheckPointsParentData();
        batteryBankCheckPointschildData = new ArrayList<>();
        setClassBatteryBankCheckPointsData();
        getInputDetails(batteryBankCheckPointsData);
        currentPos = 0;
        //setInputDetails();

        decimalEditTextListener();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewDetailsOfQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_detailsOfQRCodeScan);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonDetailsOfQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_button_detailsOfQRCodeScan);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonDetailsOfQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_button_detailsOfQRCodeScanView);
        mButtonClearBatteryBankBackUpTestReportDetailsOfQRCodeScanView = (ImageView) findViewById(R.id.button_ClearBatteryBankBackUpTestReportDetailsOfQRCodeScanView);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewTicketNo = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_ticketNo);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewTicketNoVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_ticketNoVal);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCustomer = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_customer);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCustomerVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_customerVal);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCircle = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_circle);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCircleVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_circleVal);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewState = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_state);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewStateVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_stateVal);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteName = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_siteName);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteNameVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_siteNameVal);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteId = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_siteId);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteIdVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_siteIdVal);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSsa = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_ssa);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSsaVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_ssaVal);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewUserFseNameDesignation = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_userFseNameDesignation);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewUserFseNameDesignationVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_userFseNameDesignationVal);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryType = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_batteryType);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryTypeVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_batteryTypeVal);
        mLinearLayoutBatteryTypeLiIonReadings = (LinearLayout) findViewById(R.id.LinearLayoutBatteryTypeLiIonReadings);
        mBdTestVoltageModuleReading1EditText1 = (EditText) findViewById(R.id.bdTestVoltageModuleReading1EditText1);
        mBdTestCurrentModuleReading1EditText1 = (EditText) findViewById(R.id.bdTestCurrentModuleReading1EditText1);
        mBdTestSocModuleReadingEditText1 = (EditText) findViewById(R.id.bdTestSocModuleReadingEditText1);
        mBdTestSohModuleReadingEditText1 = (EditText) findViewById(R.id.bdTestSohModuleReadingEditText1);
        mBdTestVoltageModuleReading1EditText2 = (EditText) findViewById(R.id.bdTestVoltageModuleReading1EditText2);
        mBdTestCurrentModuleReading1EditText2 = (EditText) findViewById(R.id.bdTestCurrentModuleReading1EditText2);
        mBdTestSocModuleReadingEditText2 = (EditText) findViewById(R.id.bdTestSocModuleReadingEditText2);
        mBdTestSohModuleReadingEditText2 = (EditText) findViewById(R.id.bdTestSohModuleReadingEditText2);
        mBdTestVoltageModuleReading1EditText3 = (EditText) findViewById(R.id.bdTestVoltageModuleReading1EditText3);
        mBdTestCurrentModuleReading1EditText3 = (EditText) findViewById(R.id.bdTestCurrentModuleReading1EditText3);
        mBdTestSocModuleReadingEditText3 = (EditText) findViewById(R.id.bdTestSocModuleReadingEditText3);
        mBdTestSohModuleReadingEditText3 = (EditText) findViewById(R.id.bdTestSohModuleReadingEditText3);
        mLinearLayoutBatteryTypeVRLAAndVRLAPlusReadings = (LinearLayout) findViewById(R.id.LinearLayoutBatteryTypeVRLAAndVRLAPlusReadings);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBattreyBankCellNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_battreyBankCellNumber);
        mBdTestCellReadingEditText1 = (EditText) findViewById(R.id.bdTestCellReadingEditText1);
        mBdTestCellReadingEditText2 = (EditText) findViewById(R.id.bdTestCellReadingEditText2);
        mBdTestCellReadingEditText3 = (EditText) findViewById(R.id.bdTestCellReadingEditText3);
        mBdTestCellReadingEditText4 = (EditText) findViewById(R.id.bdTestCellReadingEditText4);
        mBdTestCellReadingEditText5 = (EditText) findViewById(R.id.bdTestCellReadingEditText5);
        mBdTestCellReadingEditText6 = (EditText) findViewById(R.id.bdTestCellReadingEditText6);
        mBdTestCellReadingEditText7 = (EditText) findViewById(R.id.bdTestCellReadingEditText7);
        mBdTestCellReadingEditText8 = (EditText) findViewById(R.id.bdTestCellReadingEditText8);
        mBdTestCellReadingEditText9 = (EditText) findViewById(R.id.bdTestCellReadingEditText9);
        mBdTestCellReadingEditText10 = (EditText) findViewById(R.id.bdTestCellReadingEditText10);
        mBdTestCellReadingEditText11 = (EditText) findViewById(R.id.bdTestCellReadingEditText11);
        mBdTestCellReadingEditText12 = (EditText) findViewById(R.id.bdTestCellReadingEditText12);
        mBdTestCellReadingEditText13 = (EditText) findViewById(R.id.bdTestCellReadingEditText13);
        mBdTestCellReadingEditText14 = (EditText) findViewById(R.id.bdTestCellReadingEditText14);
        mBdTestCellReadingEditText15 = (EditText) findViewById(R.id.bdTestCellReadingEditText15);
        mBdTestCellReadingEditText16 = (EditText) findViewById(R.id.bdTestCellReadingEditText16);
        mBdTestCellReadingEditText17 = (EditText) findViewById(R.id.bdTestCellReadingEditText17);
        mBdTestCellReadingEditText18 = (EditText) findViewById(R.id.bdTestCellReadingEditText18);
        mBdTestCellReadingEditText19 = (EditText) findViewById(R.id.bdTestCellReadingEditText19);
        mBdTestCellReadingEditText20 = (EditText) findViewById(R.id.bdTestCellReadingEditText20);
        mBdTestCellReadingEditText21 = (EditText) findViewById(R.id.bdTestCellReadingEditText21);
        mBdTestCellReadingEditText22 = (EditText) findViewById(R.id.bdTestCellReadingEditText22);
        mBdTestCellReadingEditText23 = (EditText) findViewById(R.id.bdTestCellReadingEditText23);
        mBdTestCellReadingEditText24 = (EditText) findViewById(R.id.bdTestCellReadingEditText24);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewFloatVoltageInSmpsBusBarAfter30Min = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_floatVoltageInSmpsBusBarAfter30Min);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageInSmpsBusBarAfter30Min = (EditText) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_editText_floatVoltageInSmpsBusBarAfter30Min);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewTotalLoadCurrentInAmps = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_totalLoadCurrentInAmps);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextTotalLoadCurrentInAmps = (EditText) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_editText_totalLoadCurrentInAmps);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_button_previousReading);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_button_nextReading);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankMake = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_batteryBankMake);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankMakeVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_batteryBankMakeVal);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankCapacity = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_batteryBankCapacity);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankCapacityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_batteryBankCapacityVal);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfWorkingRectifireModule = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_noOfWorkingRectifireModule);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfWorkingRectifireModuleVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_noOfWorkingRectifireModuleVal);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteLoadOnBatteryInAmps = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_siteLoadOnBatteryInAmps);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSiteLoadOnBatteryInAmps = (EditText) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_editText_siteLoadOnBatteryInAmps);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewFloatVoltageBeforeBbTest = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_floatVoltageBeforeBbTest);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageBeforeBbTest = (EditText) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_editText_floatVoltageBeforeBbTest);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSingleModuleRating = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_singleModuleRating);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSingleModuleRating = (EditText) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_editText_singleModuleRating);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfBatteryModule = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_noOfBatteryModule);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfBatteryModuleVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_noOfBatteryModuleVal);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewReadingTaketAt = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_readingTaketAt);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewReadingTaketAtVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_readingTaketAtVal);

        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewLastReadingTaketAt = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_lastReadingTaketAt);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextLastReadingTaketAtVal = (EditText) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_editText_lastReadingTaketAtVal);


        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewPhotoOfBatteryBank = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_photoOfBatteryBank);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPhotoOfBatteryBank = (ImageView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_button_photoOfBatteryBank);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPhotoOfBatteryBankView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_button_photoOfBatteryBankView);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewRemarks = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_textView_remarks);
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextRemarks = (EditText) findViewById(R.id.preventiveMaintenanceSiteBatteryBankBackUpTestReport_editText_remarks);

        ////////////
        mBdTestCellReadingEditText1.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText2.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText3.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText4.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText5.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText6.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText7.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText8.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText9.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText10.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText11.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText12.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText13.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText14.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText15.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText16.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText17.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText18.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText19.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText20.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText21.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText22.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText23.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCellReadingEditText24.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        /////////////
        mBdTestVoltageModuleReading1EditText1.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCurrentModuleReading1EditText1.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestSocModuleReadingEditText1.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestSohModuleReadingEditText1.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestVoltageModuleReading1EditText2.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCurrentModuleReading1EditText2.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestSocModuleReadingEditText2.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestSohModuleReadingEditText2.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestVoltageModuleReading1EditText3.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestCurrentModuleReading1EditText3.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestSocModuleReadingEditText3.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mBdTestSohModuleReadingEditText3.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        //////////////
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageInSmpsBusBarAfter30Min.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextTotalLoadCurrentInAmps.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        /////////////
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSiteLoadOnBatteryInAmps.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 2)});
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    private void decimalEditTextListener() {
        mBdTestCellReadingEditText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText7.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText8.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText9.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText11.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText12.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText13.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText14.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText15.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText16.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText17.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText18.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText19.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText20.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText21.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText22.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText23.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCellReadingEditText24.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        /////////////
        mBdTestVoltageModuleReading1EditText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCurrentModuleReading1EditText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestSocModuleReadingEditText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestSohModuleReadingEditText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestVoltageModuleReading1EditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCurrentModuleReading1EditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestSocModuleReadingEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestSohModuleReadingEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestVoltageModuleReading1EditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestCurrentModuleReading1EditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestSocModuleReadingEditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mBdTestSohModuleReadingEditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        //////////////
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageInSmpsBusBarAfter30Min.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextTotalLoadCurrentInAmps.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        /////////////
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSiteLoadOnBatteryInAmps.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });

    }

    public void DecimalFormatConversion() {

        mBdTestCellReadingEditText1.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText1.getText().toString()));
        mBdTestCellReadingEditText2.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText2.getText().toString()));
        mBdTestCellReadingEditText3.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText3.getText().toString()));
        mBdTestCellReadingEditText4.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText4.getText().toString()));
        mBdTestCellReadingEditText5.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText5.getText().toString()));
        mBdTestCellReadingEditText6.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText6.getText().toString()));
        mBdTestCellReadingEditText7.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText7.getText().toString()));
        mBdTestCellReadingEditText8.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText8.getText().toString()));
        mBdTestCellReadingEditText9.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText9.getText().toString()));
        mBdTestCellReadingEditText10.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText10.getText().toString()));
        mBdTestCellReadingEditText11.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText11.getText().toString()));
        mBdTestCellReadingEditText12.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText12.getText().toString()));
        mBdTestCellReadingEditText13.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText13.getText().toString()));
        mBdTestCellReadingEditText14.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText14.getText().toString()));
        mBdTestCellReadingEditText15.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText15.getText().toString()));
        mBdTestCellReadingEditText16.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText16.getText().toString()));
        mBdTestCellReadingEditText17.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText17.getText().toString()));
        mBdTestCellReadingEditText18.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText18.getText().toString()));
        mBdTestCellReadingEditText19.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText19.getText().toString()));
        mBdTestCellReadingEditText20.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText20.getText().toString()));
        mBdTestCellReadingEditText21.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText21.getText().toString()));
        mBdTestCellReadingEditText22.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText22.getText().toString()));
        mBdTestCellReadingEditText23.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText23.getText().toString()));
        mBdTestCellReadingEditText24.setText(decimalConversion.convertDecimal(mBdTestCellReadingEditText24.getText().toString()));
        /////////////
        mBdTestVoltageModuleReading1EditText1.setText(decimalConversion.convertDecimal(mBdTestVoltageModuleReading1EditText1.getText().toString()));
        mBdTestCurrentModuleReading1EditText1.setText(decimalConversion.convertDecimal(mBdTestCurrentModuleReading1EditText1.getText().toString()));
        mBdTestSocModuleReadingEditText1.setText(decimalConversion.convertDecimal(mBdTestSocModuleReadingEditText1.getText().toString()));
        mBdTestSohModuleReadingEditText1.setText(decimalConversion.convertDecimal(mBdTestSohModuleReadingEditText1.getText().toString()));
        mBdTestVoltageModuleReading1EditText2.setText(decimalConversion.convertDecimal(mBdTestVoltageModuleReading1EditText2.getText().toString()));
        mBdTestCurrentModuleReading1EditText2.setText(decimalConversion.convertDecimal(mBdTestCurrentModuleReading1EditText2.getText().toString()));
        mBdTestSocModuleReadingEditText2.setText(decimalConversion.convertDecimal(mBdTestSocModuleReadingEditText2.getText().toString()));
        mBdTestSohModuleReadingEditText2.setText(decimalConversion.convertDecimal(mBdTestSohModuleReadingEditText2.getText().toString()));
        mBdTestVoltageModuleReading1EditText3.setText(decimalConversion.convertDecimal(mBdTestVoltageModuleReading1EditText3.getText().toString()));
        mBdTestCurrentModuleReading1EditText3.setText(decimalConversion.convertDecimal(mBdTestCurrentModuleReading1EditText3.getText().toString()));
        mBdTestSocModuleReadingEditText3.setText(decimalConversion.convertDecimal(mBdTestSocModuleReadingEditText3.getText().toString()));
        mBdTestSohModuleReadingEditText3.setText(decimalConversion.convertDecimal(mBdTestSohModuleReadingEditText3.getText().toString()));
        //////////////
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageInSmpsBusBarAfter30Min.setText(decimalConversion.convertDecimal(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageInSmpsBusBarAfter30Min.getText().toString()));
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextTotalLoadCurrentInAmps.setText(decimalConversion.convertDecimal(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextTotalLoadCurrentInAmps.getText().toString()));
        /////////////
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSiteLoadOnBatteryInAmps.setText(decimalConversion.convertDecimal(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSiteLoadOnBatteryInAmps.getText().toString()));
    }

    private void setInputDetails() {
        try {
            batteryBankCheckPointsData.setBdTestBatteryBankBackUpTicketNo(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewTicketNoVal.getText().toString());
            batteryBankCheckPointsData.setBdTestCustomer(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCustomerVal.getText().toString());
            batteryBankCheckPointsData.setBdTestCircle(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCircleVal.getText().toString());
            batteryBankCheckPointsData.setBdTestState(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewStateVal.getText().toString());
            batteryBankCheckPointsData.setBdTestSiteName(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteNameVal.getText().toString());
            batteryBankCheckPointsData.setBdTestSiteId(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteIdVal.getText().toString());
            batteryBankCheckPointsData.setBdTestSsa(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSsaVal.getText().toString());
            batteryBankCheckPointsData.setBdTestUserFseNameDesignation(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewUserFseNameDesignationVal.getText().toString());
            batteryBankCheckPointsData.setTypeOfBattery(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryTypeVal.getText().toString());

            if (mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryTypeVal.getText().toString().equals("Li Ion")) {
                batteryBankCheckPointsData.setBdTestVoltageModuleReading1(mBdTestVoltageModuleReading1EditText1.getText().toString());
                batteryBankCheckPointsData.setBdTestCurrentModuleReading1(mBdTestCurrentModuleReading1EditText1.getText().toString());
                batteryBankCheckPointsData.setBdTestSocModuleReading1(mBdTestSocModuleReadingEditText1.getText().toString());
                batteryBankCheckPointsData.setBdTestSohModuleReading1(mBdTestSohModuleReadingEditText1.getText().toString());
                batteryBankCheckPointsData.setBdTestVoltageModuleReading2(mBdTestVoltageModuleReading1EditText2.getText().toString());
                batteryBankCheckPointsData.setBdTestCurrentModuleReading2(mBdTestCurrentModuleReading1EditText2.getText().toString());
                batteryBankCheckPointsData.setBdTestSocModuleReading2(mBdTestSocModuleReadingEditText2.getText().toString());
                batteryBankCheckPointsData.setBdTestSohModuleReading2(mBdTestSohModuleReadingEditText2.getText().toString());
                batteryBankCheckPointsData.setBdTestVoltageModuleReading3(mBdTestVoltageModuleReading1EditText3.getText().toString());
                batteryBankCheckPointsData.setBdTestCurrentModuleReading3(mBdTestCurrentModuleReading1EditText3.getText().toString());
                batteryBankCheckPointsData.setBdTestSocModuleReading3(mBdTestSocModuleReadingEditText3.getText().toString());
                batteryBankCheckPointsData.setBdTestSohModuleReading3(mBdTestSohModuleReadingEditText3.getText().toString());
            }

            batteryBankCheckPointsData.setBdTestFloatVoltageInSmpsBusBarAfter30Min(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageInSmpsBusBarAfter30Min.getText().toString());
            batteryBankCheckPointsData.setBdTestTotalLoadCurrentInAmps(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextTotalLoadCurrentInAmps.getText().toString());
            batteryBankCheckPointsData.setBdTestBatteryBankMake(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankMakeVal.getText().toString());
            batteryBankCheckPointsData.setBdTestBatteryBankCapacity(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankCapacityVal.getText().toString());
            batteryBankCheckPointsData.setBdTestNumberOfRectifireModuleWorking(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfWorkingRectifireModuleVal.getText().toString());
            batteryBankCheckPointsData.setBdTestSiteLoadOnBatteryInAmps(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSiteLoadOnBatteryInAmps.getText().toString());
            batteryBankCheckPointsData.setBdTestFloatVoltageBeforeBBTest(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageBeforeBbTest.getText().toString());
            batteryBankCheckPointsData.setBdTestSingleModuleRating(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSingleModuleRating.getText().toString());
            batteryBankCheckPointsData.setBdTestNumberOfBatteryModule(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfBatteryModuleVal.getText().toString());
            batteryBankCheckPointsData.setBdTestReadingTakenAt(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewReadingTaketAtVal.getText().toString());
            batteryBankCheckPointsData.setBdTestLastReadingTakenAt(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextLastReadingTaketAtVal.getText().toString());
            batteryBankCheckPointsData.setBdTestRemarks(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextRemarks.getText().toString());

            batteryBankCheckPointsData.setBdTestDetailsBatteryBankBackUpOfQRCodeScan(base64StringDetailsOfBatteryBankQRCodeScan);
            batteryBankCheckPointsData.setBdTestBase64StringPhotoOfBatteryBank(base64StringPhotoOfBatteryBank);

            if (batteryBankCheckPointschildData != null) {
                batteryBankCheckPointsData.setBatteryBankCheckPointsChildData(batteryBankCheckPointschildData);
            }

            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");
                // Toast.makeText(Land_Details.this,"JsonInString :"+ jsonInString,Toast.LENGTH_SHORT).show();

                Gson gson = new Gson();
                pmSiteTransactionDetails = gson.fromJson(jsonInString, PreventiveMaintanceSiteTransactionDetails.class);

            }

            pmSiteTransactionDetails.setBatteryBankCheckPointsParentData(batteryBankCheckPointsData);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(pmSiteTransactionDetails);
            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);
            submitDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getInputDetails(BatteryBankCheckPointsParentData batteryBankCheckPointsData) {
        //try {
        if (batteryBankCheckPointsData != null) {
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewTicketNoVal.setText(batteryBankCheckPointsData.getBdTestBatteryBankBackUpTicketNo() == null ? "" : batteryBankCheckPointsData.getBdTestBatteryBankBackUpTicketNo());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCustomerVal.setText(batteryBankCheckPointsData.getBdTestCustomer() == null ? "" : batteryBankCheckPointsData.getBdTestCustomer());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCircleVal.setText(batteryBankCheckPointsData.getBdTestCircle() == null ? "" : batteryBankCheckPointsData.getBdTestCircle());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewStateVal.setText(batteryBankCheckPointsData.getBdTestState() == null ? "" : batteryBankCheckPointsData.getBdTestState());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteNameVal.setText(batteryBankCheckPointsData.getBdTestSiteName() == null ? "" : batteryBankCheckPointsData.getBdTestSiteName());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteIdVal.setText(batteryBankCheckPointsData.getBdTestSiteId() == null ? "" : batteryBankCheckPointsData.getBdTestSiteId());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSsaVal.setText(batteryBankCheckPointsData.getBdTestSsa() == null ? "" : batteryBankCheckPointsData.getBdTestSsa());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewUserFseNameDesignationVal.setText(batteryBankCheckPointsData.getBdTestUserFseNameDesignation() == null ? "" : batteryBankCheckPointsData.getBdTestUserFseNameDesignation());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryTypeVal.setText(batteryBankCheckPointsData.getTypeOfBattery() == null ? "" : batteryBankCheckPointsData.getTypeOfBattery());

            mLinearLayoutBatteryTypeVRLAAndVRLAPlusReadings.setVisibility(View.GONE);
            mLinearLayoutBatteryTypeLiIonReadings.setVisibility(View.GONE);

            if (batteryBankCheckPointsData.getTypeOfBattery().equals("VRLA") || batteryBankCheckPointsData.getTypeOfBattery().equals("VRLA+")) {
                mLinearLayoutBatteryTypeVRLAAndVRLAPlusReadings.setVisibility(View.VISIBLE);

                if (batteryBankCheckPointsData.getBatteryBankCheckPointsChildData() != null) {
                    batteryBankCheckPointschildData.addAll(batteryBankCheckPointsData.getBatteryBankCheckPointsChildData() == null ? null : batteryBankCheckPointsData.getBatteryBankCheckPointsChildData());
                    if (batteryBankCheckPointschildData != null && batteryBankCheckPointschildData.size() > 0) {

                        batteryBankCheckPointschildData.clear();
                        batteryBankCheckPointschildData.addAll(batteryBankCheckPointsData.getBatteryBankCheckPointsChildData());

                        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBattreyBankCellNumber.setText("Reading: #1");

                        mBdTestCellReadingEditText1.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading1() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading1());
                        mBdTestCellReadingEditText2.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading2() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading2());
                        mBdTestCellReadingEditText3.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading3() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading3());
                        mBdTestCellReadingEditText4.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading4() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading4());
                        mBdTestCellReadingEditText5.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading5() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading5());
                        mBdTestCellReadingEditText6.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading6() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading6());
                        mBdTestCellReadingEditText7.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading7() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading7());
                        mBdTestCellReadingEditText8.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading8() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading8());
                        mBdTestCellReadingEditText9.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading9() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading9());
                        mBdTestCellReadingEditText10.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading10() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading10());
                        mBdTestCellReadingEditText11.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading11() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading11());
                        mBdTestCellReadingEditText12.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading12() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading12());
                        mBdTestCellReadingEditText13.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading13() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading13());
                        mBdTestCellReadingEditText14.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading14() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading14());
                        mBdTestCellReadingEditText15.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading15() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading15());
                        mBdTestCellReadingEditText16.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading16() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading16());
                        mBdTestCellReadingEditText17.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading17() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading17());
                        mBdTestCellReadingEditText18.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading18() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading18());
                        mBdTestCellReadingEditText19.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading19() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading19());
                        mBdTestCellReadingEditText20.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading20() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading20());
                        mBdTestCellReadingEditText21.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading21() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading21());
                        mBdTestCellReadingEditText22.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading22() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading22());
                        mBdTestCellReadingEditText23.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading23() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading23());
                        mBdTestCellReadingEditText24.setText(batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading24() == null ? "" : batteryBankCheckPointschildData.get(currentPos).getBdTestCellReading24());

                        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPreviousReading.setVisibility(View.GONE);
                        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonNextReading.setVisibility(View.VISIBLE);

                        if (totalAcCount > 1) {
                            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonNextReading.setText("Next Reading");
                        } else {
                            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonNextReading.setText("Set");//Finish
                        }
                    }
                }
            } else if (batteryBankCheckPointsData.getTypeOfBattery().equals("Li Ion")) {
                mLinearLayoutBatteryTypeLiIonReadings.setVisibility(View.VISIBLE);

                mBdTestVoltageModuleReading1EditText1.setText(batteryBankCheckPointsData.getBdTestVoltageModuleReading1() == null ? "" : batteryBankCheckPointsData.getBdTestVoltageModuleReading1());
                mBdTestCurrentModuleReading1EditText1.setText(batteryBankCheckPointsData.getBdTestCurrentModuleReading1() == null ? "" : batteryBankCheckPointsData.getBdTestCurrentModuleReading1());
                mBdTestSocModuleReadingEditText1.setText(batteryBankCheckPointsData.getBdTestSocModuleReading1() == null ? "" : batteryBankCheckPointsData.getBdTestSocModuleReading1());
                mBdTestSohModuleReadingEditText1.setText(batteryBankCheckPointsData.getBdTestSohModuleReading1() == null ? "" : batteryBankCheckPointsData.getBdTestSohModuleReading1());
                mBdTestVoltageModuleReading1EditText2.setText(batteryBankCheckPointsData.getBdTestVoltageModuleReading2() == null ? "" : batteryBankCheckPointsData.getBdTestVoltageModuleReading2());
                mBdTestCurrentModuleReading1EditText2.setText(batteryBankCheckPointsData.getBdTestCurrentModuleReading2() == null ? "" : batteryBankCheckPointsData.getBdTestCurrentModuleReading2());
                mBdTestSocModuleReadingEditText2.setText(batteryBankCheckPointsData.getBdTestSocModuleReading2() == null ? "" : batteryBankCheckPointsData.getBdTestSocModuleReading2());
                mBdTestSohModuleReadingEditText2.setText(batteryBankCheckPointsData.getBdTestSohModuleReading2() == null ? "" : batteryBankCheckPointsData.getBdTestSohModuleReading2());
                mBdTestVoltageModuleReading1EditText3.setText(batteryBankCheckPointsData.getBdTestVoltageModuleReading3() == null ? "" : batteryBankCheckPointsData.getBdTestVoltageModuleReading3());
                mBdTestCurrentModuleReading1EditText3.setText(batteryBankCheckPointsData.getBdTestCurrentModuleReading3() == null ? "" : batteryBankCheckPointsData.getBdTestCurrentModuleReading3());
                mBdTestSocModuleReadingEditText3.setText(batteryBankCheckPointsData.getBdTestSocModuleReading3() == null ? "" : batteryBankCheckPointsData.getBdTestSocModuleReading3());
                mBdTestSohModuleReadingEditText3.setText(batteryBankCheckPointsData.getBdTestSohModuleReading3() == null ? "" : batteryBankCheckPointsData.getBdTestSohModuleReading3());
            } else {
                mLinearLayoutBatteryTypeVRLAAndVRLAPlusReadings.setVisibility(View.GONE);
                mLinearLayoutBatteryTypeLiIonReadings.setVisibility(View.GONE);
            }


            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageInSmpsBusBarAfter30Min.setText(batteryBankCheckPointsData.getBdTestFloatVoltageInSmpsBusBarAfter30Min() == null ? "" : batteryBankCheckPointsData.getBdTestFloatVoltageInSmpsBusBarAfter30Min());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextTotalLoadCurrentInAmps.setText(batteryBankCheckPointsData.getBdTestTotalLoadCurrentInAmps() == null ? "" : batteryBankCheckPointsData.getBdTestTotalLoadCurrentInAmps());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankMakeVal.setText(batteryBankCheckPointsData.getBdTestBatteryBankMake() == null ? "" : batteryBankCheckPointsData.getBdTestBatteryBankMake());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankCapacityVal.setText(batteryBankCheckPointsData.getBdTestBatteryBankCapacity() == null ? "" : batteryBankCheckPointsData.getBdTestBatteryBankCapacity());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfWorkingRectifireModuleVal.setText(batteryBankCheckPointsData.getBdTestNumberOfRectifireModuleWorking() == null ? "" : batteryBankCheckPointsData.getBdTestNumberOfRectifireModuleWorking());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSiteLoadOnBatteryInAmps.setText(batteryBankCheckPointsData.getBdTestSiteLoadOnBatteryInAmps() == null ? "" : batteryBankCheckPointsData.getBdTestSiteLoadOnBatteryInAmps());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageBeforeBbTest.setText(batteryBankCheckPointsData.getBdTestFloatVoltageBeforeBBTest() == null ? "" : batteryBankCheckPointsData.getBdTestFloatVoltageBeforeBBTest());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSingleModuleRating.setText(batteryBankCheckPointsData.getBdTestSingleModuleRating() == null ? "" : batteryBankCheckPointsData.getBdTestSingleModuleRating());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfBatteryModuleVal.setText(batteryBankCheckPointsData.getBdTestNumberOfBatteryModule() == null ? "" : batteryBankCheckPointsData.getBdTestNumberOfBatteryModule());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewReadingTaketAtVal.setText(batteryBankCheckPointsData.getBdTestReadingTakenAt() == null ? "" : batteryBankCheckPointsData.getBdTestReadingTakenAt());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextLastReadingTaketAtVal.setText(batteryBankCheckPointsData.getBdTestLastReadingTakenAt() == null ? "" : batteryBankCheckPointsData.getBdTestLastReadingTakenAt());
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextRemarks.setText(batteryBankCheckPointsData.getBdTestRemarks() == null ? "" : batteryBankCheckPointsData.getBdTestRemarks());

            base64StringDetailsOfBatteryBankQRCodeScan = batteryBankCheckPointsData.getBdTestDetailsBatteryBankBackUpOfQRCodeScan() == null ? "" : batteryBankCheckPointsData.getBdTestDetailsBatteryBankBackUpOfQRCodeScan();
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonDetailsOfQRCodeScanView.setVisibility(View.GONE);
            mButtonClearBatteryBankBackUpTestReportDetailsOfQRCodeScanView.setVisibility(View.GONE);
            if (!base64StringDetailsOfBatteryBankQRCodeScan.isEmpty() && base64StringDetailsOfBatteryBankQRCodeScan != null) {
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonDetailsOfQRCodeScanView.setVisibility(View.VISIBLE);
                mButtonClearBatteryBankBackUpTestReportDetailsOfQRCodeScanView.setVisibility(View.VISIBLE);
            }

            base64StringPhotoOfBatteryBank = batteryBankCheckPointsData.getBdTestBase64StringPhotoOfBatteryBank() == null ? "" : batteryBankCheckPointsData.getBdTestBase64StringPhotoOfBatteryBank();
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPhotoOfBatteryBankView.setVisibility(View.GONE);
            if (!base64StringPhotoOfBatteryBank.isEmpty() && base64StringPhotoOfBatteryBank != null) {
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPhotoOfBatteryBankView.setVisibility(View.VISIBLE);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                Bitmap inImage = decodeFromBase64ToBitmap(base64StringPhotoOfBatteryBank);
                inImage.compress(Bitmap.CompressFormat.JPEG, 30, bytes);
                String path = MediaStore.Images.Media.insertImage(this.getContentResolver(), inImage, "Title", null);
                imageFileUriPhotoOfBatteryBank = Uri.parse(path);
            }

        }
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private void initCombo() {
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewReadingTaketAtVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormatConversion();
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteBatteryBankBackUpTestReport_readingTakenAt))),
                        "Reading Taket At",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_readingTaketAtVal = item.get(position);
                        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewReadingTaketAtVal.setText(str_readingTaketAtVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPreviousReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidationOfArrayFields() == true) {
                    if (currentPos > 0) {
                        //Save current ac reading
                        saveDGCheckRecords(currentPos);
                        currentPos = currentPos - 1;
                        //move to Next reading
                        displayDGCheckRecords(currentPos);
                    }
                }
            }
        });
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonNextReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidationOfArrayFields() == true) {
                    if (currentPos < (totalAcCount - 1)) {
                        //Save current ac reading
                        saveDGCheckRecords(currentPos);
                        currentPos = currentPos + 1;
                        //move to Next reading
                        displayDGCheckRecords(currentPos);

                    } else if (currentPos == (totalAcCount - 1)) {
                        saveDGCheckRecords(currentPos);
                        //setInputDetails();

                        //if (checkValidationOnChangeNoOfDgBatteryAvailable(mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal.getText().toString().trim(), "onSubmit") == true) {
                        //submitDetails();
                        //startActivity(new Intent(PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.this, PreventiveMaintenanceSiteEarthingCheckPointsActivity.class));
                        //finish();
                        //}

                    }
                }
            }
        });

    }

    public boolean checkValidationOfArrayFields() {

        /*String bdTestCellReading1 = mBdTestCellReadingEditText1.getText().toString();
        String bdTestCellReading2 = mBdTestCellReadingEditText2.getText().toString();
        String bdTestCellReading3 = mBdTestCellReadingEditText3.getText().toString();
        String bdTestCellReading4 = mBdTestCellReadingEditText4.getText().toString();
        String bdTestCellReading5 = mBdTestCellReadingEditText5.getText().toString();
        String bdTestCellReading6 = mBdTestCellReadingEditText6.getText().toString();
        String bdTestCellReading7 = mBdTestCellReadingEditText7.getText().toString();
        String bdTestCellReading8 = mBdTestCellReadingEditText8.getText().toString();
        String bdTestCellReading9 = mBdTestCellReadingEditText9.getText().toString();
        String bdTestCellReading10 = mBdTestCellReadingEditText10.getText().toString();
        String bdTestCellReading11 = mBdTestCellReadingEditText11.getText().toString();
        String bdTestCellReading12 = mBdTestCellReadingEditText12.getText().toString();
        String bdTestCellReading13 = mBdTestCellReadingEditText13.getText().toString();
        String bdTestCellReading14 = mBdTestCellReadingEditText14.getText().toString();
        String bdTestCellReading15 = mBdTestCellReadingEditText15.getText().toString();
        String bdTestCellReading16 = mBdTestCellReadingEditText16.getText().toString();
        String bdTestCellReading17 = mBdTestCellReadingEditText17.getText().toString();
        String bdTestCellReading18 = mBdTestCellReadingEditText18.getText().toString();
        String bdTestCellReading19 = mBdTestCellReadingEditText19.getText().toString();
        String bdTestCellReading20 = mBdTestCellReadingEditText20.getText().toString();
        String bdTestCellReading21 = mBdTestCellReadingEditText21.getText().toString();
        String bdTestCellReading22 = mBdTestCellReadingEditText22.getText().toString();
        String bdTestCellReading23 = mBdTestCellReadingEditText23.getText().toString();
        String bdTestCellReading24 = mBdTestCellReadingEditText24.getText().toString();

        if (bdTestCellReading1.isEmpty() || bdTestCellReading1 == null) {
            showToast("Enter Cell Reading 1");
            return false;
        } else if (bdTestCellReading2.isEmpty() || bdTestCellReading2 == null) {
            showToast("Enter Cell Reading 2");
            return false;
        } else if (bdTestCellReading3.isEmpty() || bdTestCellReading3 == null) {
            showToast("Enter Cell Reading 3");
            return false;
        } else if (bdTestCellReading4.isEmpty() || bdTestCellReading4 == null) {
            showToast("Enter Cell Reading 4");
            return false;
        } else if (bdTestCellReading5.isEmpty() || bdTestCellReading5 == null) {
            showToast("Enter Cell Reading 5");
            return false;
        } else if (bdTestCellReading6.isEmpty() || bdTestCellReading6 == null) {
            showToast("Enter Cell Reading 6");
            return false;
        } else if (bdTestCellReading7.isEmpty() || bdTestCellReading7 == null) {
            showToast("Enter Cell Reading 7");
            return false;
        } else if (bdTestCellReading8.isEmpty() || bdTestCellReading8 == null) {
            showToast("Enter Cell Reading 8");
            return false;
        } else if (bdTestCellReading9.isEmpty() || bdTestCellReading9 == null) {
            showToast("Enter Cell Reading 9");
            return false;
        } else if (bdTestCellReading10.isEmpty() || bdTestCellReading10 == null) {
            showToast("Enter Cell Reading 10");
            return false;
        } else if (bdTestCellReading11.isEmpty() || bdTestCellReading11 == null) {
            showToast("Enter Cell Reading 11");
            return false;
        } else if (bdTestCellReading12.isEmpty() || bdTestCellReading12 == null) {
            showToast("Enter Cell Reading 12");
            return false;
        } else if (bdTestCellReading13.isEmpty() || bdTestCellReading13 == null) {
            showToast("Enter Cell Reading 13");
            return false;
        } else if (bdTestCellReading14.isEmpty() || bdTestCellReading14 == null) {
            showToast("Enter Cell Reading 14");
            return false;
        } else if (bdTestCellReading15.isEmpty() || bdTestCellReading15 == null) {
            showToast("Enter Cell Reading 15");
            return false;
        } else if (bdTestCellReading16.isEmpty() || bdTestCellReading16 == null) {
            showToast("Enter Cell Reading 16");
            return false;
        } else if (bdTestCellReading17.isEmpty() || bdTestCellReading17 == null) {
            showToast("Enter Cell Reading 17");
            return false;
        } else if (bdTestCellReading18.isEmpty() || bdTestCellReading18 == null) {
            showToast("Enter Cell Reading 18");
            return false;
        } else if (bdTestCellReading19.isEmpty() || bdTestCellReading19 == null) {
            showToast("Enter Cell Reading 19");
            return false;
        } else if (bdTestCellReading20.isEmpty() || bdTestCellReading20 == null) {
            showToast("Enter Cell Reading 20");
            return false;
        } else if (bdTestCellReading21.isEmpty() || bdTestCellReading21 == null) {
            showToast("Enter Cell Reading 21");
            return false;
        } else if (bdTestCellReading22.isEmpty() || bdTestCellReading22 == null) {
            showToast("Enter Cell Reading 22");
            return false;
        } else if (bdTestCellReading23.isEmpty() || bdTestCellReading23 == null) {
            showToast("Enter Cell Reading 23");
            return false;
        } else if (bdTestCellReading24.isEmpty() || bdTestCellReading24 == null) {
            showToast("Enter Cell Reading 24");
            return false;
        } else*/
        return true;
    }

    private void saveDGCheckRecords(int pos) {

        String bdTestCellReading1 = mBdTestCellReadingEditText1.getText().toString();
        String bdTestCellReading2 = mBdTestCellReadingEditText2.getText().toString();
        String bdTestCellReading3 = mBdTestCellReadingEditText3.getText().toString();
        String bdTestCellReading4 = mBdTestCellReadingEditText4.getText().toString();
        String bdTestCellReading5 = mBdTestCellReadingEditText5.getText().toString();
        String bdTestCellReading6 = mBdTestCellReadingEditText6.getText().toString();
        String bdTestCellReading7 = mBdTestCellReadingEditText7.getText().toString();
        String bdTestCellReading8 = mBdTestCellReadingEditText8.getText().toString();
        String bdTestCellReading9 = mBdTestCellReadingEditText9.getText().toString();
        String bdTestCellReading10 = mBdTestCellReadingEditText10.getText().toString();
        String bdTestCellReading11 = mBdTestCellReadingEditText11.getText().toString();
        String bdTestCellReading12 = mBdTestCellReadingEditText12.getText().toString();
        String bdTestCellReading13 = mBdTestCellReadingEditText13.getText().toString();
        String bdTestCellReading14 = mBdTestCellReadingEditText14.getText().toString();
        String bdTestCellReading15 = mBdTestCellReadingEditText15.getText().toString();
        String bdTestCellReading16 = mBdTestCellReadingEditText16.getText().toString();
        String bdTestCellReading17 = mBdTestCellReadingEditText17.getText().toString();
        String bdTestCellReading18 = mBdTestCellReadingEditText18.getText().toString();
        String bdTestCellReading19 = mBdTestCellReadingEditText19.getText().toString();
        String bdTestCellReading20 = mBdTestCellReadingEditText20.getText().toString();
        String bdTestCellReading21 = mBdTestCellReadingEditText21.getText().toString();
        String bdTestCellReading22 = mBdTestCellReadingEditText22.getText().toString();
        String bdTestCellReading23 = mBdTestCellReadingEditText23.getText().toString();
        String bdTestCellReading24 = mBdTestCellReadingEditText24.getText().toString();

        BatteryBankCheckPointsChildData batteryBankCheckPointsChildDataCls = new BatteryBankCheckPointsChildData(
                bdTestCellReading1, bdTestCellReading2, bdTestCellReading3,
                bdTestCellReading4, bdTestCellReading5, bdTestCellReading6,
                bdTestCellReading7, bdTestCellReading8, bdTestCellReading9,
                bdTestCellReading10, bdTestCellReading11, bdTestCellReading12,
                bdTestCellReading13, bdTestCellReading14, bdTestCellReading15,
                bdTestCellReading16, bdTestCellReading17, bdTestCellReading18,
                bdTestCellReading19, bdTestCellReading20, bdTestCellReading21,
                bdTestCellReading22, bdTestCellReading23, bdTestCellReading24
        );

        if (batteryBankCheckPointschildData.size() > 0) {
            if (pos == batteryBankCheckPointschildData.size()) {
                batteryBankCheckPointschildData.add(batteryBankCheckPointsChildDataCls);
            } else if (pos < batteryBankCheckPointschildData.size()) {
                batteryBankCheckPointschildData.set(pos, batteryBankCheckPointsChildDataCls);
            }
        } else {
            batteryBankCheckPointschildData.add(batteryBankCheckPointsChildDataCls);
        }

    }

    private void displayDGCheckRecords(int pos) {

        if (batteryBankCheckPointschildData.size() > 0 && pos < batteryBankCheckPointschildData.size()) {

            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBattreyBankCellNumber.setText("Reading: #" + (pos + 1));

            mBdTestCellReadingEditText1.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading1());
            mBdTestCellReadingEditText2.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading2());
            mBdTestCellReadingEditText3.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading3());
            mBdTestCellReadingEditText4.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading4());
            mBdTestCellReadingEditText5.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading5());
            mBdTestCellReadingEditText6.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading6());
            mBdTestCellReadingEditText7.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading7());
            mBdTestCellReadingEditText8.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading8());
            mBdTestCellReadingEditText9.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading9());
            mBdTestCellReadingEditText10.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading10());
            mBdTestCellReadingEditText11.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading11());
            mBdTestCellReadingEditText12.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading12());
            mBdTestCellReadingEditText13.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading13());
            mBdTestCellReadingEditText14.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading14());
            mBdTestCellReadingEditText15.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading15());
            mBdTestCellReadingEditText16.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading16());
            mBdTestCellReadingEditText17.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading17());
            mBdTestCellReadingEditText18.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading18());
            mBdTestCellReadingEditText19.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading19());
            mBdTestCellReadingEditText20.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading20());
            mBdTestCellReadingEditText21.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading21());
            mBdTestCellReadingEditText22.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading22());
            mBdTestCellReadingEditText23.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading23());
            mBdTestCellReadingEditText24.setText(batteryBankCheckPointschildData.get(pos).getBdTestCellReading24());


            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPreviousReading.setVisibility(View.VISIBLE);
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonNextReading.setVisibility(View.VISIBLE);

        } else {
            clearFields(pos);
        }

        if (pos > 0 && pos < (totalAcCount - 1)) {
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPreviousReading.setVisibility(View.VISIBLE);
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonNextReading.setText("Next Reading");
        } else if (pos > 0 && pos == (totalAcCount - 1)) {
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPreviousReading.setVisibility(View.VISIBLE);
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonNextReading.setText("Set");//Finish
        } else if (pos == 0) {
            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPreviousReading.setVisibility(View.GONE);
            if (pos == (totalAcCount - 1)) {
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonNextReading.setText("Set");//Finish
            } else {
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonNextReading.setText("Next Reading");
            }
        }
    }

    public void clearFields(int indexPos) {

        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBattreyBankCellNumber.setText("Reading: #" + (indexPos + 1));

        mBdTestCellReadingEditText1.setText("");
        mBdTestCellReadingEditText2.setText("");
        mBdTestCellReadingEditText3.setText("");
        mBdTestCellReadingEditText4.setText("");
        mBdTestCellReadingEditText5.setText("");
        mBdTestCellReadingEditText6.setText("");
        mBdTestCellReadingEditText7.setText("");
        mBdTestCellReadingEditText8.setText("");
        mBdTestCellReadingEditText9.setText("");
        mBdTestCellReadingEditText10.setText("");
        mBdTestCellReadingEditText11.setText("");
        mBdTestCellReadingEditText12.setText("");
        mBdTestCellReadingEditText13.setText("");
        mBdTestCellReadingEditText14.setText("");
        mBdTestCellReadingEditText15.setText("");
        mBdTestCellReadingEditText16.setText("");
        mBdTestCellReadingEditText17.setText("");
        mBdTestCellReadingEditText18.setText("");
        mBdTestCellReadingEditText19.setText("");
        mBdTestCellReadingEditText20.setText("");
        mBdTestCellReadingEditText21.setText("");
        mBdTestCellReadingEditText22.setText("");
        mBdTestCellReadingEditText23.setText("");
        mBdTestCellReadingEditText24.setText("");

    }

    private void setClassBatteryBankCheckPointsData() {
        /*try {*/

        Intent intent = getIntent();
        batteryBankCheckPointsData = (BatteryBankCheckPointsParentData) intent.getSerializableExtra("batteryBankCheckPointsParentData");
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private void setListner() {

        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonDetailsOfQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    DetailsOfBatteryBankBackUpQRCodeScan();
                }
            }
        });

        mButtonClearBatteryBankBackUpTestReportDetailsOfQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                base64StringDetailsOfBatteryBankQRCodeScan = "";
                mButtonClearBatteryBankBackUpTestReportDetailsOfQRCodeScanView.setVisibility(View.GONE);
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonDetailsOfQRCodeScanView.setVisibility(View.GONE);
                showToast("Cleared");
            }
        });

        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPhotoOfBatteryBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    PhotoOfBatteryBank();
                }
            }
        });

        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPhotoOfBatteryBankView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriPhotoOfBatteryBank != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.this, imageFileUriPhotoOfBatteryBank);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void PhotoOfBatteryBank() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFilePhotoOfBatteryBank = "IMG_" + ticketName + "_" + sdf.format(new Date()) + ".jpg";
            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFilePhotoOfBatteryBank);
            imageFileUriPhotoOfBatteryBank = FileProvider.getUriForFile(PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriPhotoOfBatteryBank);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_PhotoOfBatteryBank);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DetailsOfBatteryBankBackUpQRCodeScan() {
        try {
            IntentIntegrator integrator = new IntentIntegrator(this);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
            integrator.setPrompt("Scan QR Code");
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

        if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
        } else {
            return true;
        }


        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {

            case MY_PERMISSIONS_REQUEST_CAMERA_PhotoOfBatteryBank:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriPhotoOfBatteryBank != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriPhotoOfBatteryBank);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringPhotoOfBatteryBank = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPhotoOfBatteryBankView.setVisibility(View.VISIBLE);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFilePhotoOfBatteryBank = "";
                    imageFileUriPhotoOfBatteryBank = null;
                    mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonPhotoOfBatteryBankView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA:
                IntentResult result = IntentIntegrator.parseActivityResult(resultCode, data);
                if (result != null) {
                    mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonDetailsOfQRCodeScanView.setVisibility(View.GONE);
                    mButtonClearBatteryBankBackUpTestReportDetailsOfQRCodeScanView.setVisibility(View.GONE);
                    if (result.getContents() == null) {
                        base64StringDetailsOfBatteryBankQRCodeScan = "";
                        showToast("Cancelled");
                    } else {
                        /*Object[] isDuplicateQRcode = isDuplicateQRcode(result.getContents());
                        boolean flagIsDuplicateQRcode = (boolean) isDuplicateQRcode[1];
                        if (!flagIsDuplicateQRcode) {*/
                        base64StringDetailsOfBatteryBankQRCodeScan = result.getContents();
                        if (!base64StringDetailsOfBatteryBankQRCodeScan.isEmpty() && base64StringDetailsOfBatteryBankQRCodeScan != null) {
                            mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonDetailsOfQRCodeScanView.setVisibility(View.VISIBLE);
                            mButtonClearBatteryBankBackUpTestReportDetailsOfQRCodeScanView.setVisibility(View.VISIBLE);
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.menuSubmit:
                setInputDetails();
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        alertDialogManager = new AlertDialogManager(PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.this);
        alertDialogManager.Dialog("Confirmation", "Do you want to save this record?", "Yes", "No", new AlertDialogManager.onTwoButtonClickListner() {
            @Override
            public void onPositiveClick() {
                setInputDetails();
                setResult(RESULT_OK);
                finish();
            }

            @Override
            public void onNegativeClick() {

            }
        }).show();

    }

    private void submitDetails() {
        Intent data = new Intent();
        //data.putExtra("batteryBankCheckPointsParentData", batteryBankCheckPointsData);
        data.putExtra("flag", "1");

        setResult(Activity.RESULT_OK, data);
        finish();
    }

}

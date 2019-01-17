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
import com.brahamaputra.mahindra.brahamaputra.Data.AlarmCheckPoints;
import com.brahamaputra.mahindra.brahamaputra.Data.BatteryBankCheckPointsData;
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
    private BatteryBankCheckPointsData batteryBankCheckPointsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_battery_bank_back_up_test_report);
        this.setTitle("Battery Bank Back Up Test Report");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        sessionManager = new SessionManager(PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.this, userId, ticketName);
        initCombo();
        setListner();
        getInputDetails();


        //setInputDetails(batteryBankCheckPointsData);
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
    }

    private void setInputDetails(){
        batteryBankCheckPointsData.setBdTestBatteryBankBackUpTicketNo(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewTicketNoVal.getText().toString());
        batteryBankCheckPointsData.setBdTestCustomer(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCustomerVal.getText().toString());
        batteryBankCheckPointsData.setBdTestCircle(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCircleVal.getText().toString());
        batteryBankCheckPointsData.setBdTestState(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewStateVal.getText().toString());
        batteryBankCheckPointsData.setBdTestSiteName(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteNameVal.getText().toString());
        batteryBankCheckPointsData.setBdTestSiteId(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteIdVal.getText().toString());
        batteryBankCheckPointsData.setBdTestSsa(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSsaVal.getText().toString());
        batteryBankCheckPointsData.setBdTestUserFseNameDesignation(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewUserFseNameDesignationVal.getText().toString());
        batteryBankCheckPointsData.setTypeOfBattery(mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryTypeVal.getText().toString());

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

        batteryBankCheckPointsData.setBdTestCellReading1(mBdTestCellReadingEditText1.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading2(mBdTestCellReadingEditText2.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading3(mBdTestCellReadingEditText3.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading4(mBdTestCellReadingEditText4.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading5(mBdTestCellReadingEditText5.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading6(mBdTestCellReadingEditText6.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading7(mBdTestCellReadingEditText7.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading8(mBdTestCellReadingEditText8.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading9(mBdTestCellReadingEditText9.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading10(mBdTestCellReadingEditText10.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading11(mBdTestCellReadingEditText11.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading12(mBdTestCellReadingEditText12.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading13(mBdTestCellReadingEditText13.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading14(mBdTestCellReadingEditText14.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading15(mBdTestCellReadingEditText15.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading16(mBdTestCellReadingEditText16.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading17(mBdTestCellReadingEditText17.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading18(mBdTestCellReadingEditText18.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading19(mBdTestCellReadingEditText19.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading20(mBdTestCellReadingEditText20.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading21(mBdTestCellReadingEditText21.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading22(mBdTestCellReadingEditText22.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading23(mBdTestCellReadingEditText23.getText().toString());
        batteryBankCheckPointsData.setBdTestCellReading24(mBdTestCellReadingEditText24.getText().toString());

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
    }

    //private void getInputDetails(BatteryBankCheckPointsData batteryBankCheckPointsData) {
    private void getInputDetails() {
        //try {
            if (batteryBankCheckPointsData != null) {
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewTicketNoVal.setText(batteryBankCheckPointsData.getBdTestBatteryBankBackUpTicketNo());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCustomerVal.setText(batteryBankCheckPointsData.getBdTestCustomer());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewCircleVal.setText(batteryBankCheckPointsData.getBdTestCircle());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewStateVal.setText(batteryBankCheckPointsData.getBdTestState());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteNameVal.setText(batteryBankCheckPointsData.getBdTestSiteName());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSiteIdVal.setText(batteryBankCheckPointsData.getBdTestSiteId());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewSsaVal.setText(batteryBankCheckPointsData.getBdTestSsa());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewUserFseNameDesignationVal.setText(batteryBankCheckPointsData.getBdTestUserFseNameDesignation());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryTypeVal.setText(batteryBankCheckPointsData.getTypeOfBattery());

                mBdTestVoltageModuleReading1EditText1.setText(batteryBankCheckPointsData.getBdTestVoltageModuleReading1());
                mBdTestCurrentModuleReading1EditText1.setText(batteryBankCheckPointsData.getBdTestCurrentModuleReading1());
                mBdTestSocModuleReadingEditText1.setText(batteryBankCheckPointsData.getBdTestSocModuleReading1());
                mBdTestSohModuleReadingEditText1.setText(batteryBankCheckPointsData.getBdTestSohModuleReading1());
                mBdTestVoltageModuleReading1EditText2.setText(batteryBankCheckPointsData.getBdTestVoltageModuleReading2());
                mBdTestCurrentModuleReading1EditText2.setText(batteryBankCheckPointsData.getBdTestCurrentModuleReading2());
                mBdTestSocModuleReadingEditText2.setText(batteryBankCheckPointsData.getBdTestSocModuleReading2());
                mBdTestSohModuleReadingEditText2.setText(batteryBankCheckPointsData.getBdTestSohModuleReading2());
                mBdTestVoltageModuleReading1EditText3.setText(batteryBankCheckPointsData.getBdTestVoltageModuleReading3());
                mBdTestCurrentModuleReading1EditText3.setText(batteryBankCheckPointsData.getBdTestCurrentModuleReading3());
                mBdTestSocModuleReadingEditText3.setText(batteryBankCheckPointsData.getBdTestSocModuleReading3());
                mBdTestSohModuleReadingEditText3.setText(batteryBankCheckPointsData.getBdTestSohModuleReading3());


                mBdTestCellReadingEditText1.setText(batteryBankCheckPointsData.getBdTestCellReading1());
                mBdTestCellReadingEditText2.setText(batteryBankCheckPointsData.getBdTestCellReading2());
                mBdTestCellReadingEditText3.setText(batteryBankCheckPointsData.getBdTestCellReading3());
                mBdTestCellReadingEditText4.setText(batteryBankCheckPointsData.getBdTestCellReading4());
                mBdTestCellReadingEditText5.setText(batteryBankCheckPointsData.getBdTestCellReading5());
                mBdTestCellReadingEditText6.setText(batteryBankCheckPointsData.getBdTestCellReading6());
                mBdTestCellReadingEditText7.setText(batteryBankCheckPointsData.getBdTestCellReading7());
                mBdTestCellReadingEditText8.setText(batteryBankCheckPointsData.getBdTestCellReading8());
                mBdTestCellReadingEditText9.setText(batteryBankCheckPointsData.getBdTestCellReading9());
                mBdTestCellReadingEditText10.setText(batteryBankCheckPointsData.getBdTestCellReading10());
                mBdTestCellReadingEditText11.setText(batteryBankCheckPointsData.getBdTestCellReading11());
                mBdTestCellReadingEditText12.setText(batteryBankCheckPointsData.getBdTestCellReading12());
                mBdTestCellReadingEditText13.setText(batteryBankCheckPointsData.getBdTestCellReading13());
                mBdTestCellReadingEditText14.setText(batteryBankCheckPointsData.getBdTestCellReading14());
                mBdTestCellReadingEditText15.setText(batteryBankCheckPointsData.getBdTestCellReading15());
                mBdTestCellReadingEditText16.setText(batteryBankCheckPointsData.getBdTestCellReading16());
                mBdTestCellReadingEditText17.setText(batteryBankCheckPointsData.getBdTestCellReading17());
                mBdTestCellReadingEditText18.setText(batteryBankCheckPointsData.getBdTestCellReading18());
                mBdTestCellReadingEditText19.setText(batteryBankCheckPointsData.getBdTestCellReading19());
                mBdTestCellReadingEditText20.setText(batteryBankCheckPointsData.getBdTestCellReading20());
                mBdTestCellReadingEditText21.setText(batteryBankCheckPointsData.getBdTestCellReading21());
                mBdTestCellReadingEditText22.setText(batteryBankCheckPointsData.getBdTestCellReading22());
                mBdTestCellReadingEditText23.setText(batteryBankCheckPointsData.getBdTestCellReading23());
                mBdTestCellReadingEditText24.setText(batteryBankCheckPointsData.getBdTestCellReading24());

                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageInSmpsBusBarAfter30Min.setText(batteryBankCheckPointsData.getBdTestFloatVoltageInSmpsBusBarAfter30Min());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextTotalLoadCurrentInAmps.setText(batteryBankCheckPointsData.getBdTestTotalLoadCurrentInAmps());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankMakeVal.setText(batteryBankCheckPointsData.getBdTestBatteryBankMake());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewBatteryBankCapacityVal.setText(batteryBankCheckPointsData.getBdTestBatteryBankCapacity());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfWorkingRectifireModuleVal.setText(batteryBankCheckPointsData.getBdTestNumberOfRectifireModuleWorking());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSiteLoadOnBatteryInAmps.setText(batteryBankCheckPointsData.getBdTestSiteLoadOnBatteryInAmps());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextFloatVoltageBeforeBbTest.setText(batteryBankCheckPointsData.getBdTestFloatVoltageBeforeBBTest());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextSingleModuleRating.setText(batteryBankCheckPointsData.getBdTestSingleModuleRating());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewNoOfBatteryModuleVal.setText(batteryBankCheckPointsData.getBdTestNumberOfBatteryModule());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewReadingTaketAtVal.setText(batteryBankCheckPointsData.getBdTestReadingTakenAt());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextLastReadingTaketAtVal.setText(batteryBankCheckPointsData.getBdTestLastReadingTakenAt());
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportEditTextRemarks.setText(batteryBankCheckPointsData.getBdTestRemarks());

                base64StringDetailsOfBatteryBankQRCodeScan = batteryBankCheckPointsData.getBdTestDetailsBatteryBankBackUpOfQRCodeScan();
                mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonDetailsOfQRCodeScanView.setVisibility(View.GONE);
                mButtonClearBatteryBankBackUpTestReportDetailsOfQRCodeScanView.setVisibility(View.GONE);
                if (!base64StringDetailsOfBatteryBankQRCodeScan.isEmpty() && base64StringDetailsOfBatteryBankQRCodeScan != null) {
                    mPreventiveMaintenanceSiteBatteryBankBackUpTestReportButtonDetailsOfQRCodeScanView.setVisibility(View.VISIBLE);
                    mButtonClearBatteryBankBackUpTestReportDetailsOfQRCodeScanView.setVisibility(View.VISIBLE);
                }

                base64StringPhotoOfBatteryBank = batteryBankCheckPointsData.getBdTestBase64StringPhotoOfBatteryBank();
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
        setResult(RESULT_OK);
        finish();
    }

}

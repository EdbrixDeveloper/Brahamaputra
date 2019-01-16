package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

import java.util.ArrayList;
import java.util.Arrays;

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


    private String str_readingTaketAtVal = "";
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

    /*private HotoTransactionData hotoTransactionData;
    private LandDetailsData landDetailsData;*/
    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;

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

    }

    private void initCombo() {
        mPreventiveMaintenanceSiteBatteryBankBackUpTestReportTextViewReadingTaketAtVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteBatteryBankBackUpTestReportActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteBatteryBankCheckPoints_noOfBatteryBank))),
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
    }

}

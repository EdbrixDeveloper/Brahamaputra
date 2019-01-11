package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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

public class PreventiveMaintenanceSiteServoCheckPointsActivity extends BaseActivity {



    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewDetailsOfServo;
    private ImageView mPreventiveMaintenanceSiteServoCheckPointsButtonDetailsOfServoQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteServoCheckPointsButtonDetailsOfServoQRCodeScanView;
    private ImageView mButtonClearDetailsOfServoQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewServoWorkingStatus;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewServoWorkingStatusVal;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewAnyBypassInSvs;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewAnyBypassInSvsVal;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewSvsEarthingStatus;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewSvsEarthingStatusVal;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewTypeOfFaultVal;

    String str_servoWorkingStatusVal;
    String str_anyBypassInSvsVal;
    String str_svsEarthingStatusVal;
    String str_registerFaultVal;
    String str_typeOfFaultVal;

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    private String base64StringDetailsOfServoQRCodeScan = "";
    //private String imageFileDetailsOfServoQRCodeScan;
    //private Uri imageFileUriDetailsOfServoQRCodeScan = null;

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
        setContentView(R.layout.activity_preventive_maintenance_site_servo_check_points);
        this.setTitle("Servo Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sessionManager = new SessionManager(PreventiveMaintenanceSiteServoCheckPointsActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteServoCheckPointsActivity.this, userId, ticketName);
        assignViews();
        checkCameraPermission();
        initCombo();
        setListner();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteServoCheckPointsTextViewDetailsOfServo = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_detailsOfServoQRCodeScan);
        mPreventiveMaintenanceSiteServoCheckPointsButtonDetailsOfServoQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_button_detailsOfServoQRCodeScan);
        mPreventiveMaintenanceSiteServoCheckPointsButtonDetailsOfServoQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_button_detailsOfServoQRCodeScanView);
        mButtonClearDetailsOfServoQRCodeScanView = (ImageView) findViewById(R.id.button_clearDetailsOfServoQRCodeScanView);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewServoWorkingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_servoWorkingStatus);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewServoWorkingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_servoWorkingStatusVal);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewAnyBypassInSvs = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_anyBypassInSvs);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewAnyBypassInSvsVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_anyBypassInSvsVal);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewSvsEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_svsEarthingStatus);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewSvsEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_svsEarthingStatusVal);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_typeOfFaultVal);


    }

    private void initCombo() {

        mPreventiveMaintenanceSiteServoCheckPointsTextViewServoWorkingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteServoCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteServoCheckPoints_servoWorkingStatus))),
                        "Servo Working Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_servoWorkingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteServoCheckPointsTextViewServoWorkingStatusVal.setText(str_servoWorkingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteServoCheckPointsTextViewAnyBypassInSvsVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteServoCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteServoCheckPoints_anyBypassInSvs))),
                        "Any Bypass in SVS",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_anyBypassInSvsVal = item.get(position);
                        mPreventiveMaintenanceSiteServoCheckPointsTextViewAnyBypassInSvsVal.setText(str_anyBypassInSvsVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteServoCheckPointsTextViewSvsEarthingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteServoCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteServoCheckPoints_svsEarthingStatus))),
                        "SVS Earthing Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_svsEarthingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteServoCheckPointsTextViewSvsEarthingStatusVal.setText(str_svsEarthingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteServoCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteServoCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteServoCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_registerFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteServoCheckPointsTextViewRegisterFaultVal.setText(str_registerFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteServoCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteServoCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteServoCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteServoCheckPointsTextViewTypeOfFaultVal.setText(str_typeOfFaultVal);
                    }
                });
            }
        });

    }

    private void setListner() {

        mPreventiveMaintenanceSiteServoCheckPointsButtonDetailsOfServoQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    DetailsOfWrmsQRCodeScan();
                }
            }
        });

        mButtonClearDetailsOfServoQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                base64StringDetailsOfServoQRCodeScan = "";
                mButtonClearDetailsOfServoQRCodeScanView.setVisibility(View.GONE);
                mPreventiveMaintenanceSiteServoCheckPointsButtonDetailsOfServoQRCodeScanView.setVisibility(View.GONE);
                showToast("Cleared");
            }
        });

    }

    private void DetailsOfWrmsQRCodeScan() {
        try {
            IntentIntegrator integrator = new IntentIntegrator(this);
            integrator.setPrompt("Scan a barcode or QRcode");
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

        if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteServoCheckPointsActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PreventiveMaintenanceSiteServoCheckPointsActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
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
                    mPreventiveMaintenanceSiteServoCheckPointsButtonDetailsOfServoQRCodeScanView.setVisibility(View.GONE);
                    mButtonClearDetailsOfServoQRCodeScanView.setVisibility(View.GONE);
                    if (result.getContents() == null) {
                        base64StringDetailsOfServoQRCodeScan = "";
                        showToast("Cancelled");
                    } else {
                        /*Object[] isDuplicateQRcode = isDuplicateQRcode(result.getContents());
                        boolean flagIsDuplicateQRcode = (boolean) isDuplicateQRcode[1];
                        if (!flagIsDuplicateQRcode) {*/
                        base64StringDetailsOfServoQRCodeScan = result.getContents();
                        if (!base64StringDetailsOfServoQRCodeScan.isEmpty() && base64StringDetailsOfServoQRCodeScan != null) {
                            mPreventiveMaintenanceSiteServoCheckPointsButtonDetailsOfServoQRCodeScanView.setVisibility(View.VISIBLE);
                            mButtonClearDetailsOfServoQRCodeScanView.setVisibility(View.VISIBLE);
                        }
                        /*} else {
                            base64StringDetailsOfServoQRCodeScan = "";
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
                //submitDetails();
                startActivity(new Intent(this, PreventiveMaintenanceSiteShelterCheckPointsActivity.class));
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
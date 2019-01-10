package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.BuildConfig;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class PreventiveMaintenanceSiteAlarmCheckPointsActivity extends BaseActivity {

    private static final String TAG = PreventiveMaintenanceSiteAlarmCheckPointsActivity.class.getSimpleName();

    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDetailsOfWrms;
    private ImageView mPreventiveMaintenanceSiteAlarmCheckPointsButtonDetailsOfWrmsQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteAlarmCheckPointsButtonDetailsOfWrmsQRCodeScanView;
    private ImageView mButtonClearDetailsOfWrmsQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDoorOpenAlarm;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDoorOpenAlarmVal;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDgOn;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDgOnVal;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDgOutputAvailable;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDgOutputAvailableVal;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewHighRoomTemp;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewHighRoomTempVal;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewFireSmoke;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewFireSmokeVal;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewPowerPlantFailure;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewPowerPlantFailureVal;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewAlarmConfirmedByNoc;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewAlarmConfirmedByNocVal;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewRemarks;
    private EditText mPreventiveMaintenanceSiteAlarmCheckPointsTextViewRemarksVal;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteAlarmCheckPointsTextViewTypeOfFaultVal;

    String str_pmSiteAcpDoorOpenAlarmVal = "";
    String str_pmSiteAcpDgOnVal = "";
    String str_pmSiteAcpDgOutputAvailableVal = "";
    String str_pmSiteAcpHighRoomTempVal = "";
    String str_pmSiteAcpFireAndSmokeVal = "";
    String str_pmSiteAcpPowerPlantFailureVal = "";
    String str_pmSiteAcpAlarmConfirmedByNocVal = "";
    String str_pmSiteAcpRegisterFaultVal = "";
    String str_pmSiteAcpTypeOfFaultVal = "";

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    private String base64StringDetailsOfWrmsQRCodeScan = "";
    private String imageFileUploadPhotoOfSitePremises;
    private Uri imageFileUriUploadPhotoOfSitePremises = null;

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
        setContentView(R.layout.activity_preventive_maintenance_site_alarm_check_points);
        this.setTitle("Alarm Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        checkCameraPermission();
        initCombo();
        setListner();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDetailsOfWrms = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_detailsOfWrmsQRCodeScan);
        mPreventiveMaintenanceSiteAlarmCheckPointsButtonDetailsOfWrmsQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_button_detailsOfWrmsQRCodeScan);
        mPreventiveMaintenanceSiteAlarmCheckPointsButtonDetailsOfWrmsQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_button_detailsOfWrmsQRCodeScanView);
        mButtonClearDetailsOfWrmsQRCodeScanView = (ImageView) findViewById(R.id.button_clearDetailsOfWrmsQRCodeScanView);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDoorOpenAlarm = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_doorOpenAlarm);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDoorOpenAlarmVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_doorOpenAlarmVal);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDgOn = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_dgOn);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDgOnVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_dgOnVal);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDgOutputAvailable = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_dgOutputAvailable);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDgOutputAvailableVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_dgOutputAvailableVal);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewHighRoomTemp = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_highRoomTemp);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewHighRoomTempVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_highRoomTempVal);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewFireSmoke = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_fireSmoke);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewFireSmokeVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_fireSmokeVal);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewPowerPlantFailure = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_powerPlantFailure);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewPowerPlantFailureVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_powerPlantFailureVal);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewAlarmConfirmedByNoc = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_alarmConfirmedByNoc);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewAlarmConfirmedByNocVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_alarmConfirmedByNocVal);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewRemarks = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_remarks);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewRemarksVal = (EditText) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_remarksVal);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAlarmCheckPoints_textView_typeOfFaultVal);
    }

    private void initCombo() {
        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDoorOpenAlarmVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAlarmCheckPoints_doorOpenAlarm))),
                        "Door Open Alarm",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpDoorOpenAlarmVal = item.get(position);
                        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDoorOpenAlarmVal.setText(str_pmSiteAcpDoorOpenAlarmVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDgOnVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAlarmCheckPoints_dgOn))),
                        "DG ON",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpDgOnVal = item.get(position);
                        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDgOnVal.setText(str_pmSiteAcpDgOnVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDgOutputAvailableVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAlarmCheckPoints_dgOutputAvailable))),
                        "DG Output Available",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpDgOutputAvailableVal = item.get(position);
                        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewDgOutputAvailableVal.setText(str_pmSiteAcpDgOutputAvailableVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewHighRoomTempVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAlarmCheckPoints_highRoomTemp))),
                        "High Room Temp",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpHighRoomTempVal = item.get(position);
                        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewHighRoomTempVal.setText(str_pmSiteAcpHighRoomTempVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewFireSmokeVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAlarmCheckPoints_fireAndSmoke))),
                        "Fire & Smoke",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpFireAndSmokeVal = item.get(position);
                        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewFireSmokeVal.setText(str_pmSiteAcpFireAndSmokeVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewPowerPlantFailureVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAlarmCheckPoints_powerPlantFailure))),
                        "Power Plant Failure",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpPowerPlantFailureVal = item.get(position);
                        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewPowerPlantFailureVal.setText(str_pmSiteAcpPowerPlantFailureVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewAlarmConfirmedByNocVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAlarmCheckPoints_alarmConfirmedByNoc))),
                        "Alarm Confirmed by NOC",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpAlarmConfirmedByNocVal = item.get(position);
                        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewAlarmConfirmedByNocVal.setText(str_pmSiteAcpAlarmConfirmedByNocVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAlarmCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpRegisterFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewRegisterFaultVal.setText(str_pmSiteAcpRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAlarmCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteAcpTypeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteAcpTypeOfFaultVal);
                    }
                });
            }
        });
    }

    private void setListner() {

        mPreventiveMaintenanceSiteAlarmCheckPointsButtonDetailsOfWrmsQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    DetailsOfWrmsQRCodeScan();
                }
            }
        });

        mButtonClearDetailsOfWrmsQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                base64StringDetailsOfWrmsQRCodeScan = "";
                mButtonClearDetailsOfWrmsQRCodeScanView.setVisibility(View.GONE);
                mPreventiveMaintenanceSiteAlarmCheckPointsButtonDetailsOfWrmsQRCodeScanView.setVisibility(View.GONE);
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

        if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
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
                    mPreventiveMaintenanceSiteAlarmCheckPointsButtonDetailsOfWrmsQRCodeScanView.setVisibility(View.GONE);
                    mButtonClearDetailsOfWrmsQRCodeScanView.setVisibility(View.GONE);
                    if (result.getContents() == null) {
                        base64StringDetailsOfWrmsQRCodeScan = "";
                        showToast("Cancelled");
                    } else {
                        /*Object[] isDuplicateQRcode = isDuplicateQRcode(result.getContents());
                        boolean flagIsDuplicateQRcode = (boolean) isDuplicateQRcode[1];
                        if (!flagIsDuplicateQRcode) {*/
                        base64StringDetailsOfWrmsQRCodeScan = result.getContents();
                        if (!base64StringDetailsOfWrmsQRCodeScan.isEmpty() && base64StringDetailsOfWrmsQRCodeScan != null) {
                            mPreventiveMaintenanceSiteAlarmCheckPointsButtonDetailsOfWrmsQRCodeScanView.setVisibility(View.VISIBLE);
                            mButtonClearDetailsOfWrmsQRCodeScanView.setVisibility(View.VISIBLE);
                        }
                        /*} else {
                            base64StringDetailsOfWrmsQRCodeScan = "";
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
                startActivity(new Intent(this, PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.class));
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

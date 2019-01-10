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
import android.widget.Button;
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

public class PreventiveMaintenanceSiteDgBatteryCheckPointsActivity extends BaseActivity {
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewNoOfDgBatteryAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewNoOfDgBatteryAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewBatteryNumber;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDetailsOfDgBatteryQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonDetailsOfDgBatteryQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonDetailsOfDgBatteryQRCodeScanView;
    private ImageView mButtonClearDetailsOfDgBatteryQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryCondition;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryConditionVal;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryWaterAvailable;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryWaterAvailableVal;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewPetroleumJellyToDGBatteryTerminal;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewPetroleumJellyToDGBatteryTerminalVal;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryCharger;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryChargerVal;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonNextReading;

    String str_pmSiteDgbcpNoOfDGBatteryAvailableAtSiteVal = "";
    String str_pmSiteDgbcpDGBatteryConditionVal = "";
    String str_pmSiteDgbcpDGBatteryWaterAvailableVal = "";
    String str_pmSiteDgbcpPetroleumJellyToDGBatteryTerminalVal = "";
    String str_pmSiteDgbcpDGBatteryChargerVal = "";
    String str_pmSiteDgbcpRegisterFaultVal = "";
    String str_pmSiteDgbcpTypeOfFaultVal = "";

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    private String base64StringDetailsOfDgBatteryQRCodeScan = "";
    //private String imageFileDetailsOfDgBatteryQRCodeScan;
    //private Uri imageFileUriDetailsOfDgBatteryQRCodeScan = null;

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
        setContentView(R.layout.activity_preventive_maintenance_site_dg_battery_check_points);
        this.setTitle("DG Battery Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();
        setListner();

        sessionManager = new SessionManager(PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.this, userId, ticketName);
    }

    private void initCombo() {
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewNoOfDgBatteryAvailableAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgBatteryCheckPoints_noOfDgBatteryAvailableAtSite))),
                        "No of DG Battery available at site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgbcpNoOfDGBatteryAvailableAtSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewNoOfDgBatteryAvailableAtSiteVal.setText(str_pmSiteDgbcpNoOfDGBatteryAvailableAtSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgBatteryCheckPoints_dgBatteryCondition))),
                        "DG Battery Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgbcpDGBatteryConditionVal = item.get(position);
                        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryConditionVal.setText(str_pmSiteDgbcpDGBatteryConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryWaterAvailableVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgBatteryCheckPoints_dgBatteryWaterAvailable))),
                        "DG Battery Water Available",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgbcpDGBatteryWaterAvailableVal = item.get(position);
                        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryWaterAvailableVal.setText(str_pmSiteDgbcpDGBatteryWaterAvailableVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewPetroleumJellyToDGBatteryTerminalVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgBatteryCheckPoints_petroleumJellyToDgBatteryTerminal))),
                        "Petroleum Jelly to DG Battery Terminal",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgbcpPetroleumJellyToDGBatteryTerminalVal = item.get(position);
                        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewPetroleumJellyToDGBatteryTerminalVal.setText(str_pmSiteDgbcpPetroleumJellyToDGBatteryTerminalVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryChargerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgBatteryCheckPoints_dgBatteryCharger))),
                        "DG Battery Charger",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgbcpDGBatteryChargerVal = item.get(position);
                        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryChargerVal.setText(str_pmSiteDgbcpDGBatteryChargerVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgBatteryCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgbcpRegisterFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewRegisterFaultVal.setText(str_pmSiteDgbcpRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgBatteryCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgbcpTypeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteDgbcpTypeOfFaultVal);
                    }
                });
            }
        });
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewNoOfDgBatteryAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_noOfDgBatteryAvailableAtSite);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewNoOfDgBatteryAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_noOfDgBatteryAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewBatteryNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_batteryNumber);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDetailsOfDgBatteryQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_detailsOfDgBatteryQRCodeScan);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonDetailsOfDgBatteryQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_button_detailsOfDgBatteryQRCodeScan);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonDetailsOfDgBatteryQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_button_detailsOfDgBatteryQRCodeScanView);
        mButtonClearDetailsOfDgBatteryQRCodeScanView = (ImageView) findViewById(R.id.button_ClearDetailsOfDgBatteryQRCodeScanView);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_dgBatteryCondition);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_dgBatteryConditionVal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryWaterAvailable = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_dgBatteryWaterAvailable);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryWaterAvailableVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_dgBatteryWaterAvailableVal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewPetroleumJellyToDGBatteryTerminal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_petroleumJellyToDGBatteryTerminal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewPetroleumJellyToDGBatteryTerminalVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_petroleumJellyToDGBatteryTerminalVal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryCharger = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_dgBatteryCharger);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryChargerVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_dgBatteryChargerVal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_button_nextReading);
    }

    private void setListner() {

        mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonDetailsOfDgBatteryQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    DetailsOfDgBatteryQRCodeScan();
                }
            }
        });

        mButtonClearDetailsOfDgBatteryQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                base64StringDetailsOfDgBatteryQRCodeScan = "";
                mButtonClearDetailsOfDgBatteryQRCodeScanView.setVisibility(View.GONE);
                mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonDetailsOfDgBatteryQRCodeScanView.setVisibility(View.GONE);
                showToast("Cleared");
            }
        });

    }

    private void DetailsOfDgBatteryQRCodeScan() {
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

        if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
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
                    mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonDetailsOfDgBatteryQRCodeScanView.setVisibility(View.GONE);
                    mButtonClearDetailsOfDgBatteryQRCodeScanView.setVisibility(View.GONE);
                    if (result.getContents() == null) {
                        base64StringDetailsOfDgBatteryQRCodeScan = "";
                        showToast("Cancelled");
                    } else {
                        /*Object[] isDuplicateQRcode = isDuplicateQRcode(result.getContents());
                        boolean flagIsDuplicateQRcode = (boolean) isDuplicateQRcode[1];
                        if (!flagIsDuplicateQRcode) {*/
                        base64StringDetailsOfDgBatteryQRCodeScan = result.getContents();
                        if (!base64StringDetailsOfDgBatteryQRCodeScan.isEmpty() && base64StringDetailsOfDgBatteryQRCodeScan != null) {
                            mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonDetailsOfDgBatteryQRCodeScanView.setVisibility(View.VISIBLE);
                            mButtonClearDetailsOfDgBatteryQRCodeScanView.setVisibility(View.VISIBLE);
                        }
                        /*} else {
                            base64StringDetailsOfDgBatteryQRCodeScan = "";
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
                startActivity(new Intent(this, PreventiveMaintenanceSiteAcCheckPointsActivity.class));
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

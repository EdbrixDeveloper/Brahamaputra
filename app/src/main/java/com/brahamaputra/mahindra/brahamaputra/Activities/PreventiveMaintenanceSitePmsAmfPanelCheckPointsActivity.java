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

public class PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity extends BaseActivity {

    private static final String TAG = PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.class.getSimpleName();

    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSite;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmsAmfPiuNumber;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewQRCodeScan;
    private ImageView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScan;
    private ImageView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScanView;
    private ImageView mButtonClearQRCodeScanView;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManual;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManualVal;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypass;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypassVal;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatus;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatusVal;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading;

    String str_noOfPmsAmfPiuAvailableAtSiteVal;
    String str_siteInAutoManualVal;
    String str_looseConnectionBypassVal;
    String str_pmfAmfPiuEarthingStatusVal;
    String str_registerFaultVal;
    String str_typeOfFaultVal;

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    private String base64StringPmsAmfPanelCheckPointsQRCodeScan = "";
    //private String imageFileUploadPhotoOfSitePremises;
    //private Uri imageFileUriUploadPhotoOfSitePremises = null;

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
        setContentView(R.layout.activity_preventive_maintenance_site_pms_amf_panel_check_points);
        this.setTitle("PMS/AMF Panel Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sessionManager = new SessionManager(PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.this, userId, ticketName);
        assignViews();
        initCombo();
        checkCameraPermission();
        initCombo();
        setListner();

    }

    private void assignViews() {
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_noOfPmsAmfPiuAvailableAtSite);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_noOfPmsAmfPiuAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmsAmfPiuNumber = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_pmsAmfPiuNumber);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_QRCodeScan);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_button_QRCodeScan);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_button_QRCodeScanView);
        mButtonClearQRCodeScanView = (ImageView) findViewById(R.id.button_ClearQRCodeScanView);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManual = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_siteInAutoManual);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManualVal = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_siteInAutoManualVal);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypass = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_looseConnectionBypass);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypassVal = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_looseConnectionBypassVal);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_pmfAmfPiuEarthingStatus);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_pmfAmfPiuEarthingStatusVal);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_button_previousReading);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_button_nextReading);


    }

    private void initCombo() {

        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSitePmsOrAmfOrPiuAvailableAtSite_noOfPmsOrAmfOrPiuAvailableAtSite))),
                        "No of PMS/AMF/PIU available at site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfPmsAmfPiuAvailableAtSiteVal = item.get(position);
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSiteVal.setText(str_noOfPmsAmfPiuAvailableAtSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManualVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSitePmsOrAmfOrPiuAvailableAtSite_siteInAutoOrManual))),
                        "Site in Auto/Manual",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_siteInAutoManualVal = item.get(position);
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManualVal.setText(str_siteInAutoManualVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypassVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSitePmsOrAmfOrPiuAvailableAtSite_anyLooseConnectionOrBypass))),
                        "Any loose connection/Bypass",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_looseConnectionBypassVal = item.get(position);
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypassVal.setText(str_looseConnectionBypassVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSitePmsOrAmfOrPiuAvailableAtSite_pmsOrAmfOrPiuEarthingStatus))),
                        "PMS/AMF/PIU Earthing Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmfAmfPiuEarthingStatusVal = item.get(position);
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatusVal.setText(str_pmfAmfPiuEarthingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSitePmsOrAmfOrPiuAvailableAtSite_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_registerFaultVal = item.get(position);
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFaultVal.setText(str_registerFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSitePmsOrAmfOrPiuAvailableAtSite_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFaultVal.setText(str_typeOfFaultVal);
                    }
                });
            }
        });
    }


    private void setListner() {

        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    DetailsOfWrmsQRCodeScan();
                }
            }
        });

        mButtonClearQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                base64StringPmsAmfPanelCheckPointsQRCodeScan = "";
                mButtonClearQRCodeScanView.setVisibility(View.GONE);
                mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScanView.setVisibility(View.GONE);
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

        if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
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
                    mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScanView.setVisibility(View.GONE);
                    mButtonClearQRCodeScanView.setVisibility(View.GONE);
                    if (result.getContents() == null) {
                        base64StringPmsAmfPanelCheckPointsQRCodeScan = "";
                        showToast("Cancelled");
                    } else {
                        /*Object[] isDuplicateQRcode = isDuplicateQRcode(result.getContents());
                        boolean flagIsDuplicateQRcode = (boolean) isDuplicateQRcode[1];
                        if (!flagIsDuplicateQRcode) {*/
                        base64StringPmsAmfPanelCheckPointsQRCodeScan = result.getContents();
                        if (!base64StringPmsAmfPanelCheckPointsQRCodeScan.isEmpty() && base64StringPmsAmfPanelCheckPointsQRCodeScan != null) {
                            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScanView.setVisibility(View.VISIBLE);
                            mButtonClearQRCodeScanView.setVisibility(View.VISIBLE);
                        }
                        /*} else {
                            base64StringPmsAmfPanelCheckPointsQRCodeScan = "";
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
                startActivity(new Intent(this, PreventiveMaintenanceSiteServoCheckPointsActivity.class));
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

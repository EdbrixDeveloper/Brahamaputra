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
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.Data.PmsAmfPanelCheckPoints;
import com.brahamaputra.mahindra.brahamaputra.Data.PmsAmfPanelCheckPointsDatum;
import com.brahamaputra.mahindra.brahamaputra.Data.PreventiveMaintanceSiteTransactionDetails;
import com.brahamaputra.mahindra.brahamaputra.Data.ServoCheckPoints;
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

    private ArrayList<PmsAmfPanelCheckPointsDatum> pmsAmfPanelCheckPointsArrayList;

    private int totalCount = 0;
    private int currentPos = 0;

    private PmsAmfPanelCheckPoints pmsAmfPanelCheckPoints;
    private PreventiveMaintanceSiteTransactionDetails preventiveMaintanceSiteTransactionDetails;

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

        preventiveMaintanceSiteTransactionDetails = new PreventiveMaintanceSiteTransactionDetails();
        pmsAmfPanelCheckPointsArrayList = new ArrayList<>();
        currentPos = 0;
        setInputDetails(currentPos);

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
                        invalidateOptionsMenu();
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSiteVal.setText(str_noOfPmsAmfPiuAvailableAtSiteVal);

                        if(pmsAmfPanelCheckPointsArrayList != null && pmsAmfPanelCheckPointsArrayList.size()>0)
                        {
                            pmsAmfPanelCheckPointsArrayList.clear();
                        }
                        currentPos = 0;
                        totalCount = 0;
                        clearFields(currentPos);
                        totalCount = Integer.parseInt(str_noOfPmsAmfPiuAvailableAtSiteVal);

                        if (totalCount > 0) {

                            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmsAmfPiuNumber.setText("Reading: #1");
                            mLinearLayoutContainer.setVisibility(View.VISIBLE);
                            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonPreviousReading.setVisibility(View.GONE);
                            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading.setVisibility(View.VISIBLE);
                            if (totalCount > 0 && totalCount == 1) {
                                mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading.setText("Finish");
                            } else {
                                mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading.setText("Next Reading");
                            }
                        } else {
                            mLinearLayoutContainer.setVisibility(View.GONE);
                        }

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

        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonPreviousReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPos > 0) {
                    //Save current ac reading
                    saveRecords(currentPos);
                    currentPos = currentPos - 1;
                    //move to Next reading
                    displayRecords(currentPos);
                }
            }
        });

        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidtionForArrayFields()) {
                    if (currentPos < (totalCount - 1)) {
                        //Save current ac reading
                        saveRecords(currentPos);
                        currentPos = currentPos + 1;
                        //move to Next reading
                        displayRecords(currentPos);

                    } else if (currentPos == (totalCount - 1)) {
                        //Save Final current reading and submit all AC data
                        saveRecords(currentPos);
                        submitDetails();
                        startActivity(new Intent(PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.this, ServoCheckPoints.class));
                        finish();
                    }
                }
            }
        });
    }

    private void submitDetails() {
        try {
                String noOfPmsAmfPuiAvailableAtSite = mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSiteVal.getText().toString().trim();
                pmsAmfPanelCheckPoints = new PmsAmfPanelCheckPoints(noOfPmsAmfPuiAvailableAtSite,pmsAmfPanelCheckPointsArrayList);
                preventiveMaintanceSiteTransactionDetails.setPmsAmfPanelCheckPoints(pmsAmfPanelCheckPoints);

                Gson gson2 = new GsonBuilder().create();
                String jsonString = gson2.toJson(preventiveMaintanceSiteTransactionDetails);

                offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private boolean checkValidtionForArrayFields() {
       /* String typeOfAsset = mDetailsOfUnusedMaterialsTextViewTypeOfAssetVal.getText().toString().trim();
        *//* String assetMake = mDetailsOfUnusedMaterialsTextViewAssetMakeVal.getText().toString().trim();*//*
        String assetStatus = mDetailsOfUnusedMaterialsTextViewAssetStatusVal.getText().toString().trim();
        String assetDescription = mDetailsOfUnusedMaterialsEditTextDescriptionVal.getText().toString().trim();

        *//*if (typeOfAsset.isEmpty() || typeOfAsset == null) {
            showToast("Select Type of Asset ");
            return false;
        } else if (assetMake.isEmpty() || assetMake == null) {
            showToast("Select Asset Make ");
            return false;
        } else*//*
        if (typeOfAsset.equals("General Item")) {
            return true;
        } else if ((assetStatus.isEmpty() || assetStatus == null) && (!assetDescription.isEmpty() && assetDescription != null)) {
            showToast("Select Asset Status");
            return false;
        } else*//* if (assetDescription.isEmpty() || assetDescription == null) {
            showToast("Select Asset Description ");
            return false;
        } else*/
            return true;
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

    private void setInputDetails(int currentPos) {
            try {
                if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                    String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");
                    Gson gson = new Gson();

                    preventiveMaintanceSiteTransactionDetails = gson.fromJson(jsonInString, PreventiveMaintanceSiteTransactionDetails.class);
                    pmsAmfPanelCheckPoints = preventiveMaintanceSiteTransactionDetails.getPmsAmfPanelCheckPoints();
                    pmsAmfPanelCheckPointsArrayList.addAll(pmsAmfPanelCheckPoints.getPmsAmfPanelCheckPointsData());

                    totalCount = Integer.parseInt(pmsAmfPanelCheckPoints.getNoOfPmsAmfPiuAvailableAtSite());
                    mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSiteVal.setText(totalCount);

                    if (pmsAmfPanelCheckPointsArrayList != null && pmsAmfPanelCheckPointsArrayList.size() > 0) {
                        mLinearLayoutContainer.setVisibility(View.VISIBLE);

                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmsAmfPiuNumber.setText("Reading: #1");

                        base64StringPmsAmfPanelCheckPointsQRCodeScan = pmsAmfPanelCheckPointsArrayList.get(currentPos).getDetailsOfPmsAmfPiuQrCodeScan();
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScanView.setVisibility(View.GONE);
                        mButtonClearQRCodeScanView.setVisibility(View.GONE);
                        if (!base64StringPmsAmfPanelCheckPointsQRCodeScan.isEmpty() && base64StringPmsAmfPanelCheckPointsQRCodeScan != null) {
                            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScanView.setVisibility(View.VISIBLE);
                            mButtonClearQRCodeScanView.setVisibility(View.VISIBLE);
                        }

                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManualVal.setText(pmsAmfPanelCheckPointsArrayList.get(currentPos).getSiteInAutoManual());
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypassVal.setText(pmsAmfPanelCheckPointsArrayList.get(currentPos).getAnyLooseConnectionBypass());
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatusVal.setText(pmsAmfPanelCheckPointsArrayList.get(currentPos).getPmsAmfPiuEarthingStatus());
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFaultVal.setText(pmsAmfPanelCheckPointsArrayList.get(currentPos).getRegisterFault());
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFaultVal.setText(pmsAmfPanelCheckPointsArrayList.get(currentPos).getTypeOfFault());

                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonPreviousReading.setVisibility(View.GONE);
                        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading.setVisibility(View.VISIBLE);

                        if (totalCount > 1) {
                            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading.setText("Next Reading");
                        } else {
                            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading.setText("Finish");
                        }
                    }
                    else
                    {
                        Toast.makeText(PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
                    }
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
    }

    private void saveRecords(int pos) {
        String detailsOfPmsAmfQrCodeScan = base64StringPmsAmfPanelCheckPointsQRCodeScan;
        String siteInAutoManual = mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManualVal.getText().toString().trim();
        String anyLooseConnectionBypass = mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypassVal.getText().toString().trim();
        String pmsAmfPuiEarthingStatus = mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatusVal.getText().toString().trim();
        String registerFault = mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFaultVal.getText().toString().trim();
        String typeOfFault = mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFaultVal.getText().toString().trim();

        PmsAmfPanelCheckPointsDatum pmsAmfPanelCheckPointsDatum = new PmsAmfPanelCheckPointsDatum(detailsOfPmsAmfQrCodeScan,siteInAutoManual,anyLooseConnectionBypass,
                pmsAmfPuiEarthingStatus,registerFault,typeOfFault);
        if (pmsAmfPanelCheckPointsArrayList.size() > 0) {
            if (pos == pmsAmfPanelCheckPointsArrayList.size()) {
                pmsAmfPanelCheckPointsArrayList.add(pmsAmfPanelCheckPointsDatum);
            } else if (pos < pmsAmfPanelCheckPointsArrayList.size()) {
                pmsAmfPanelCheckPointsArrayList.set(pos, pmsAmfPanelCheckPointsDatum);
            }
        } else {
            pmsAmfPanelCheckPointsArrayList.add(pmsAmfPanelCheckPointsDatum);
        }
    }

    private void displayRecords(int pos) {
        if (pmsAmfPanelCheckPointsArrayList.size() > 0 && pos < pmsAmfPanelCheckPointsArrayList.size()) {
            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmsAmfPiuNumber.setText("Reading: #" + (pos + 1));

            base64StringPmsAmfPanelCheckPointsQRCodeScan = pmsAmfPanelCheckPointsArrayList.get(pos).getDetailsOfPmsAmfPiuQrCodeScan();
            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScanView.setVisibility(View.GONE);
            mButtonClearQRCodeScanView.setVisibility(View.GONE);
            if (!base64StringPmsAmfPanelCheckPointsQRCodeScan.isEmpty() && base64StringPmsAmfPanelCheckPointsQRCodeScan != null) {
                mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScanView.setVisibility(View.VISIBLE);
                mButtonClearQRCodeScanView.setVisibility(View.VISIBLE);
            }
            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManualVal.setText(pmsAmfPanelCheckPointsArrayList.get(pos).getSiteInAutoManual());
            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypassVal.setText(pmsAmfPanelCheckPointsArrayList.get(pos).getAnyLooseConnectionBypass());
            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatusVal.setText(pmsAmfPanelCheckPointsArrayList.get(pos).getPmsAmfPiuEarthingStatus());
            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFaultVal.setText(pmsAmfPanelCheckPointsArrayList.get(pos).getRegisterFault());
            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFaultVal.setText(pmsAmfPanelCheckPointsArrayList.get(pos).getTypeOfFault());
        }
        else {
            clearFields(pos);
        }

        if (pos > 0 && pos < (totalCount - 1)) {
            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonPreviousReading.setVisibility(View.VISIBLE);
            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading.setText("Next Reading");
        } else if (pos > 0 && pos == (totalCount - 1)) {
            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonPreviousReading.setVisibility(View.VISIBLE);
            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading.setText("Finish");
        } else if (pos == 0) {
            mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonPreviousReading.setVisibility(View.GONE);
            if (pos == (totalCount - 1)) {
                mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading.setText("Finish");
            } else {
                mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading.setText("Next Reading");
            }
        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }

    public void clearFields(int indexPos) {
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmsAmfPiuNumber.setText("Reading: #" + (indexPos + 1));


        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManualVal.setText("");
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypassVal.setText("");
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatusVal.setText("");
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFaultVal.setText("");
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFaultVal.setText("");

        str_noOfPmsAmfPiuAvailableAtSiteVal = "";
        str_siteInAutoManualVal = "";
        str_looseConnectionBypassVal = "";
        str_pmfAmfPiuEarthingStatusVal = "";
        str_registerFaultVal = "";
        str_typeOfFaultVal = "";
    }
}

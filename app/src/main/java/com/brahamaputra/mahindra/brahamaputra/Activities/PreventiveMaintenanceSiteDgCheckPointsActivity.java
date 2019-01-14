package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class PreventiveMaintenanceSiteDgCheckPointsActivity extends BaseActivity {

    private static final String TAG = PreventiveMaintenanceSiteDgCheckPointsActivity.class.getSimpleName();

    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewDgNumber;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScanView;
    private ImageView mButtonClearQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewDgHmrReading;
    private EditText mPreventiveMaintenanceSiteDgCheckPointsEditTextDgHmrReading;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewPhotoOfDgHmr;
    private ImageView mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmr;
    private ImageView mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmrView;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingCondition;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingConditionVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevel;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevelVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTension;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTensionVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevel;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevelVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatus;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatusVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatus;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatusVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteDgCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteDgCheckPointsButtonNextReading;

    String str_pmSiteDgcpNoOfDgAvailableAtSiteVal = "";
    String str_pmSiteDgcpDGWorkingConditionVal = "";
    String str_pmSiteDgcpCoolentLevelVal = "";
    String str_pmSiteDgcpBeltTensionVal = "";
    String str_pmSiteDgcpEngineLubeOilLevelVal = "";
    String str_pmSiteDgcpSafetyWorkingStatusVal = "";
    String str_pmSiteDgcpPowerCableConnectionStatusVal = "";
    String str_pmSiteDgcpRegisterFaultVal = "";
    String str_pmSiteDgcpTypeOfFaultVal = "";

    private AlertDialogManager alertDialogManager;

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_PhotoOfDgHmr = 101;
    //public static final int MY_PERMISSIONS_REQUEST_CAMERA_CautionSignBoard = 102;


    private String base64StringDgCheckPointsQRCodeScan = "";
    private String base64StringPhotoOfDgHmr = "";

    //private String imageFileDgCheckPointsQRCodeScan;
    private String imageFilePhotoOfDgHmr;

    //private Uri imageFileUriDgCheckPointsQRCodeScan = null;
    private Uri imageFileUriPhotoOfDgHmr = null;

    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    /*private HotoTransactionData hotoTransactionData;
    private LandDetailsData landDetailsData;*/
    private String base64StringTakePhotoOfDgHmr = "";
    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;

    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_dg_check_points);
        this.setTitle("DG Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();

        alertDialogManager = new AlertDialogManager(PreventiveMaintenanceSiteDgCheckPointsActivity.this);
        sessionManager = new SessionManager(PreventiveMaintenanceSiteDgCheckPointsActivity.this);

        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteDgCheckPointsActivity.this, userId, ticketName);
        setListner();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_noOfDgAvailableAtSite);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_noOfDgAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_dgNumber);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_QRCodeScan);
        mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_QRCodeScan);
        mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_QRCodeScanView);
        mButtonClearQRCodeScanView = (ImageView) findViewById(R.id.button_ClearQRCodeScanView);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgHmrReading = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_dgHmrReading);
        mPreventiveMaintenanceSiteDgCheckPointsEditTextDgHmrReading = (EditText) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_editText_dgHmrReading);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewPhotoOfDgHmr = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_photoOfDgHmr);
        mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmr = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_photoOfDgHmr);
        mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmrView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_photoOfDgHmrView);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_dgWorkingCondition);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_dgWorkingConditionVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevel = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_coolentLevel);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevelVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_coolentLevelVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTension = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_beltTension);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTensionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_beltTensionVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevel = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_engineLubeOilLevel);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevelVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_engineLubeOilLevelVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_safetyWorkingStatus);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_safetyWorkingStatusVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_powerCableConnectionStatus);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_powerCableConnectionStatusVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteDgCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteDgCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_nextReading);
    }

    private void initCombo() {
        mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_noOfDgAvailableAtSite))),
                        "No of DG available at site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpNoOfDgAvailableAtSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSiteVal.setText(str_pmSiteDgcpNoOfDgAvailableAtSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_dgWorkingCondition))),
                        "DG Working Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpDGWorkingConditionVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingConditionVal.setText(str_pmSiteDgcpDGWorkingConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevelVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_coolentLevel))),
                        "Coolent Level",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpCoolentLevelVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevelVal.setText(str_pmSiteDgcpCoolentLevelVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTensionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_beltTension))),
                        "Belt Tension",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpBeltTensionVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTensionVal.setText(str_pmSiteDgcpBeltTensionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevelVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_engineLubeOilLevel))),
                        "Engine Lube Oil Level",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpEngineLubeOilLevelVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevelVal.setText(str_pmSiteDgcpEngineLubeOilLevelVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_safetyWorkingStatus))),
                        "Safety Working Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpSafetyWorkingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatusVal.setText(str_pmSiteDgcpSafetyWorkingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_powerCableConnecionStatus))),
                        "Power Cable Connection Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpPowerCableConnectionStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatusVal.setText(str_pmSiteDgcpPowerCableConnectionStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpRegisterFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFaultVal.setText(str_pmSiteDgcpRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpTypeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteDgcpTypeOfFaultVal);
                    }
                });
            }
        });
    }

    private void setListner() {

        mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    PhotoOfDgHmr();
                }
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmrView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriPhotoOfDgHmr != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this, imageFileUriPhotoOfDgHmr);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteDgCheckPointsActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    DgCheckPointsQRCodeScan();
                }
            }
        });

        mButtonClearQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                base64StringDgCheckPointsQRCodeScan = "";
                mButtonClearQRCodeScanView.setVisibility(View.GONE);
                mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScanView.setVisibility(View.GONE);
                showToast("Cleared");
            }
        });

    }

    private void PhotoOfDgHmr() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFilePhotoOfDgHmr = "IMG_" + ticketName + "_" + sdf.format(new Date()) + ".jpg";
            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFilePhotoOfDgHmr);
            imageFileUriPhotoOfDgHmr = FileProvider.getUriForFile(PreventiveMaintenanceSiteDgCheckPointsActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriPhotoOfDgHmr);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_PhotoOfDgHmr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DgCheckPointsQRCodeScan() {
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

        if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteDgCheckPointsActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PreventiveMaintenanceSiteDgCheckPointsActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
        } else {
            return true;
        }
      return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA_PhotoOfDgHmr:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriPhotoOfDgHmr != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriPhotoOfDgHmr);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringPhotoOfDgHmr = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmrView.setVisibility(View.VISIBLE);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFilePhotoOfDgHmr = "";
                    imageFileUriPhotoOfDgHmr = null;
                    mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmrView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA:
                IntentResult result = IntentIntegrator.parseActivityResult(resultCode, data);
                if (result != null) {
                    mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScanView.setVisibility(View.GONE);
                    mButtonClearQRCodeScanView.setVisibility(View.GONE);
                    if (result.getContents() == null) {
                        base64StringDgCheckPointsQRCodeScan = "";
                        showToast("Cancelled");
                    } else {
                        /*Object[] isDuplicateQRcode = isDuplicateQRcode(result.getContents());
                        boolean flagIsDuplicateQRcode = (boolean) isDuplicateQRcode[1];
                        if (!flagIsDuplicateQRcode) {*/
                            base64StringDgCheckPointsQRCodeScan = result.getContents();
                            if (!base64StringDgCheckPointsQRCodeScan.isEmpty() && base64StringDgCheckPointsQRCodeScan != null) {
                                mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScanView.setVisibility(View.VISIBLE);
                                mButtonClearQRCodeScanView.setVisibility(View.VISIBLE);
                            }
                        /*} else {
                            base64StringDgCheckPointsQRCodeScan = "";
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

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuSubmit:
                startActivity(new Intent(this, PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.class));
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

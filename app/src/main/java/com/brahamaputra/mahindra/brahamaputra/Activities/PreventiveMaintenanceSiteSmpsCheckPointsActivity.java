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
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
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

public class PreventiveMaintenanceSiteSmpsCheckPointsActivity extends BaseActivity {

    private static final String TAG = PreventiveMaintenanceSiteSmpsCheckPointsActivity.class.getSimpleName();

    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsNumber;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScanView;
    private ImageView mButtonClearQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsCondition;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsConditionVal;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatus;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatusVal;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatus;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatusVal;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewDcLoadCurrent;
    private EditText mPreventiveMaintenanceSiteSmpsCheckPointsEditTextDcLoadCurrent;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewPhotoDcLoadCurrent;
    private ImageView mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrent;
    private ImageView mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrentView;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewDcLoadAmpPh;
    private EditText mPreventiveMaintenanceSiteSmpsCheckPointsEditTextDcLoadAmpPh;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteSmpsCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteSmpsCheckPointsButtonNextReading;

    String str_noOfSmpsAvailableAtSiteVal;
    String str_smpsConditionVal;
    String str_smpsControlerStatusVal;
    String str_smpsEarthingStatusVal;
    String str_segisterFaultVal;
    String str_sypeOfFaultVal;

    private AlertDialogManager alertDialogManager;

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_PhotoDcLoadCurrent = 101;
    //public static final int MY_PERMISSIONS_REQUEST_CAMERA_CautionSignBoard = 102;


    private String base64StringSmpsCheckPointsQRCodeScan = "";
    private String base64StringPhotoDcLoadCurrent = "";

    //private String imageFileSmpsCheckPointsQRCodeScan;
    private String imageFilePhotoDcLoadCurrent;

    //private Uri imageFileUriSmpsCheckPointsQRCodeScan = null;
    private Uri imageFileUriPhotoDcLoadCurrent = null;


    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    /*private HotoTransactionData hotoTransactionData;
    private LandDetailsData landDetailsData;*/
    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;

    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_smps_check_points);
        this.setTitle("SMPS Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        alertDialogManager = new AlertDialogManager(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this);
        sessionManager = new SessionManager(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this, userId, ticketName);
        assignViews();
        checkCameraPermission();
        initCombo();
        setListner();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_noOfSmpsAvailableAtSite);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_noOfSmpsAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsNumber);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_QRCodeScan);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_QRCodeScan);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_QRCodeScanView);
        mButtonClearQRCodeScanView = (ImageView) findViewById(R.id.button_ClearQRCodeScanView);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsCondition);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsConditionVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsControlerStatus);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsControlerStatusVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsEarthingStatus);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsEarthingStatusVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewDcLoadCurrent = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_dcLoadCurrent);
        mPreventiveMaintenanceSiteSmpsCheckPointsEditTextDcLoadCurrent = (EditText) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_editText_dcLoadCurrent);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewPhotoDcLoadCurrent = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_photoDcLoadCurrent);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrent = (ImageView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_photoDcLoadCurrent);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrentView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_photoDcLoadCurrentView);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewDcLoadAmpPh = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_dcLoadAmpPh);
        mPreventiveMaintenanceSiteSmpsCheckPointsEditTextDcLoadAmpPh = (EditText) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_editText_dcLoadAmpPh);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_nextReading);
    }

    private void initCombo() {

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_noOfSMPSAvailableAtSite))),
                        "No of SMPS available at site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfSmpsAvailableAtSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSiteVal.setText(str_noOfSmpsAvailableAtSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_smpsCondition))),
                        "SMPS Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_smpsConditionVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsConditionVal.setText(str_smpsConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_smpsControlerStatus))),
                        "SMPS Controler Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_smpsControlerStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatusVal.setText(str_smpsControlerStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_smpsEarthingStatus))),
                        "SMPS Earthing Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_smpsEarthingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatusVal.setText(str_smpsEarthingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_segisterFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFaultVal.setText(str_segisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_sypeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFaultVal.setText(str_sypeOfFaultVal);
                    }
                });
            }
        });


    }

    private void setListner() {

        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    PhotoDcLoadCurrent();
                }
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriPhotoDcLoadCurrent != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this, imageFileUriPhotoDcLoadCurrent);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScan.setOnClickListener(new View.OnClickListener() {
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
                base64StringSmpsCheckPointsQRCodeScan = "";
                mButtonClearQRCodeScanView.setVisibility(View.GONE);
                mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScanView.setVisibility(View.GONE);
                showToast("Cleared");
            }
        });

    }

    private void PhotoDcLoadCurrent() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFilePhotoDcLoadCurrent = "IMG_" + ticketName + "_" + sdf.format(new Date()) + ".jpg";
            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFilePhotoDcLoadCurrent);
            imageFileUriPhotoDcLoadCurrent = FileProvider.getUriForFile(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriPhotoDcLoadCurrent);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_PhotoDcLoadCurrent);
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

        if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
        } else {
            return true;
        }


        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA_PhotoDcLoadCurrent:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriPhotoDcLoadCurrent != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriPhotoDcLoadCurrent);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringPhotoDcLoadCurrent = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrentView.setVisibility(View.VISIBLE);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFilePhotoDcLoadCurrent = "";
                    imageFileUriPhotoDcLoadCurrent = null;
                    mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrentView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA:
                IntentResult result = IntentIntegrator.parseActivityResult(resultCode, data);
                if (result != null) {
                    mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScanView.setVisibility(View.GONE);
                    mButtonClearQRCodeScanView.setVisibility(View.GONE);
                    if (result.getContents() == null) {
                        base64StringSmpsCheckPointsQRCodeScan = "";
                        showToast("Cancelled");
                    } else {
                        /*Object[] isDuplicateQRcode = isDuplicateQRcode(result.getContents());
                        boolean flagIsDuplicateQRcode = (boolean) isDuplicateQRcode[1];
                        if (!flagIsDuplicateQRcode) {*/
                        base64StringSmpsCheckPointsQRCodeScan = result.getContents();
                        if (!base64StringSmpsCheckPointsQRCodeScan.isEmpty() && base64StringSmpsCheckPointsQRCodeScan != null) {
                            mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScanView.setVisibility(View.VISIBLE);
                            mButtonClearQRCodeScanView.setVisibility(View.VISIBLE);
                        }
                        /*} else {
                            base64StringSmpsCheckPointsQRCodeScan = "";
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
                startActivity(new Intent(this, PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.class));
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


package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class PreventiveMaintenanceSiteRectifierModuleCheckPointActivity extends BaseActivity {

    private static final String TAG = PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.class.getSimpleName();

    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfRectifierModuleAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfRectifierModuleAvailableAtSiteVal;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfModulesWorking;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfModulesWorkingVal;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfFaultyModulesInSite;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfFaultyModulesInSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierModuleNumber;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewDetailsOfRectifierModuleQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonDetailsOfRectifierModuleQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonDetailsOfRectifierModuleQRCodeScanView;
    private ImageView mButtonClearDetailsOfRectifierModuleQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierCleaning;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierCleaningVal;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierPhotoBeforeCleaning;
    private ImageView mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoBeforeCleaning;
    private ImageView mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoBeforeCleaningView;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierPhotoAfterCleaning;
    private ImageView mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoAfterCleaning;
    private ImageView mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoAfterCleaningView;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonNextReading;


    String str_noOfRectifierModuleAvailableAtSiteVal;
    String str_noOfModulesWorkingVal;
    String str_noOfFaultyModulesInSiteVal;
    String str_rectifierCleaningVal;
    String str_registerFaultVal;
    String str_typeOfFaultVal;

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_RectifierPhotoBeforeCleaning = 101;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_RectifierPhotoAfterCleaning = 102;

    private String base64StringRectifierPhotoBeforeCleaning = "";
    private String base64StringRectifierPhotoAfterCleaning = "";

    private String imageFileRectifierPhotoBeforeCleaning;
    private String imageFileRectifierPhotoAfterCleaning;

    private Uri imageFileUriRectifierPhotoBeforeCleaning = null;
    private Uri imageFileUriRectifierPhotoAfterCleaning = null;

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
        setContentView(R.layout.activity_preventive_maintenance_site_rectifier_module_check_point);
        this.setTitle("Rectifier Module Check Point");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();
        checkCameraPermission();
        setListner();
        sessionManager = new SessionManager(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this, userId, ticketName);
    }



    private void initCombo() {

        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfRectifierModuleAvailableAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteRectifierModuleCheckPoints_noOfRectifierModuleAvailableAtSite))),
                        "No of Rectifier Module available at site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfRectifierModuleAvailableAtSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfRectifierModuleAvailableAtSiteVal.setText(str_noOfRectifierModuleAvailableAtSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfModulesWorkingVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteRectifierModuleCheckPoints_noOfModulesWorking))),
                        "No of Modules Working",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfModulesWorkingVal = item.get(position);
                        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfModulesWorkingVal.setText(str_noOfModulesWorkingVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfFaultyModulesInSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Hiiiii");
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteRectifierModuleCheckPoints_noOfFaultyModulesInSite))),
                        "No of Faulty Modules in Site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfFaultyModulesInSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfFaultyModulesInSiteVal.setText(str_noOfFaultyModulesInSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierCleaningVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteRectifierModuleCheckPoints_rectifierCleaning))),
                        "Rectifier Cleaning",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_rectifierCleaningVal = item.get(position);
                        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierCleaningVal.setText(str_rectifierCleaningVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteRectifierModuleCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_registerFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRegisterFaultVal.setText(str_registerFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteRectifierModuleCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewTypeOfFaultVal.setText(str_typeOfFaultVal);
                    }
                });
            }
        });
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfRectifierModuleAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_noOfRectifierModuleAvailableAtSite);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfRectifierModuleAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_noOfRectifierModuleAvailableAtSiteVal);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfModulesWorking = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_noOfModulesWorking);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfModulesWorkingVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_noOfModulesWorkingVal);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfFaultyModulesInSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_noOfFaultyModulesInSite);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfFaultyModulesInSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_noOfFaultyModulesInSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierModuleNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_rectifierModuleNumber);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewDetailsOfRectifierModuleQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_detailsOfRectifierModuleQRCodeScan);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonDetailsOfRectifierModuleQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_detailsOfRectifierModuleQRCodeScan);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonDetailsOfRectifierModuleQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_detailsOfRectifierModuleQRCodeScanView);
        mButtonClearDetailsOfRectifierModuleQRCodeScanView = (ImageView) findViewById(R.id.button_ClearDetailsOfRectifierModuleQRCodeScanView);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_rectifierCleaning);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierCleaningVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_rectifierCleaningVal);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierPhotoBeforeCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_rectifierPhotoBeforeCleaning);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoBeforeCleaning = (ImageView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_rectifierPhotoBeforeCleaning);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoBeforeCleaningView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_rectifierPhotoBeforeCleaningView);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierPhotoAfterCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_rectifierPhotoAfterCleaning);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoAfterCleaning = (ImageView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_rectifierPhotoAfterCleaning);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoAfterCleaningView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_rectifierPhotoAfterCleaningView);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_registerFault);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_registerFaultVal);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_typeOfFault);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_previousReading);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_nextReading);

    }

    private boolean checkCameraPermission() {

        if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
        } else {
            return true;
        }


        return false;
    }

    private void setListner()
    {
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoBeforeCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    rectifierPhotoBeforeCleaning();
                }
            }
        });

        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoAfterCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    rectifierPhotoAfterCleaning();
                }
            }
        });

        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoBeforeCleaningView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriRectifierPhotoBeforeCleaning != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this, imageFileUriRectifierPhotoBeforeCleaning);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoAfterCleaningView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriRectifierPhotoAfterCleaning != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this, imageFileUriRectifierPhotoAfterCleaning);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void rectifierPhotoBeforeCleaning()
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileRectifierPhotoBeforeCleaning = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_sitePremises.jpg";
            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileRectifierPhotoBeforeCleaning);
            imageFileUriRectifierPhotoBeforeCleaning = FileProvider.getUriForFile(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriRectifierPhotoBeforeCleaning);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_RectifierPhotoBeforeCleaning);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void rectifierPhotoAfterCleaning()
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileRectifierPhotoAfterCleaning = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_sitePremises.jpg";
            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileRectifierPhotoAfterCleaning);
            imageFileUriRectifierPhotoAfterCleaning = FileProvider.getUriForFile(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriRectifierPhotoAfterCleaning);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_RectifierPhotoAfterCleaning);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA_RectifierPhotoBeforeCleaning:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriRectifierPhotoBeforeCleaning != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriRectifierPhotoBeforeCleaning);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringRectifierPhotoBeforeCleaning = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoBeforeCleaningView.setVisibility(View.VISIBLE);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileRectifierPhotoBeforeCleaning = "";
                    imageFileUriRectifierPhotoBeforeCleaning = null;
                    mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoBeforeCleaningView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_RectifierPhotoAfterCleaning:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriRectifierPhotoAfterCleaning != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriRectifierPhotoAfterCleaning);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringRectifierPhotoAfterCleaning = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoAfterCleaningView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileRectifierPhotoAfterCleaning = "";
                    imageFileUriRectifierPhotoAfterCleaning = null;
                    mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoAfterCleaningView.setVisibility(View.GONE);
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
                startActivity(new Intent(this, PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.class));
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

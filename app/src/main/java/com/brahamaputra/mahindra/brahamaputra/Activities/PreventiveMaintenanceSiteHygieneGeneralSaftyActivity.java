package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
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
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PreventiveMaintenanceSiteHygieneGeneralSaftyActivity extends BaseActivity {


    private static final String TAG = PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.class.getSimpleName();

    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaning;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUploadPhotoOfSitePremises;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremises;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremisesView;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaning;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaningVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTower;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTowerVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatus;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablityVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablityVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablityVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablityVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherExpiryDate;
    private EditText mPreventiveMaintenanceSiteHygieneGeneralSaftyEditTextFireExtingisherExpiryDate;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablityVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCautionSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhotoView;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewWarningSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhotoView;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDangerSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhotoView;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendar;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendarVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSite;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSiteVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFault;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal;

    String str_pmSitePremisesCleaningVal = "";
    String str_pmSiteanyEagleOrCrowOrHoneyHivesInTowerVal = "";
    String str_pmSiteCompoundWallOrFencingStatusVal = "";
    String str_pmSiteGateLockAvailablityVal = "";
    String str_pmSiteShelterLockAvailablityVal = "";
    String str_pmSiteDgLockAvailablityVal = "";
    String str_pmSiteFireExtinguisherAvilabilityVal = "";
    String str_pmSiteNoOfFireExtinguisherVal = "";
    String str_pmSiteFireBucketVal = "";
    String str_pmSiteSafetyChartsAndCalendarVal = "";
    String str_pmSiteUnusedMaterialInSiteVal = "";
    String str_pmSiteRegisterFaultVal = "";
    String str_pmSiteTypeOfFaultVal = "";

    final Calendar myCalendar = Calendar.getInstance();

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_UploadPhotoOfSitePremises = 101;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_CautionSignBoard = 102;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_WarningSignBoard = 103;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_DangerSignBoard = 104;

    private String base64StringUploadPhotoOfSitePremises = "";
    private String base64StringCautionSignBoard = "";
    private String base64StringWarningSignBoard = "";
    private String base64StringDangerSignBoard = "";

    private String imageFileUploadPhotoOfSitePremises;
    private String imageFileCautionSignBoard;
    private String imageFileWarningSignBoard;
    private String imageFileDangerSignBoard;

    private Uri imageFileUriUploadPhotoOfSitePremises = null;
    private Uri imageFileUriCautionSignBoard = null;
    private Uri imageFileUriWarningSignBoard = null;
    private Uri imageFileUriDangerSignBoard = null;

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
        setContentView(R.layout.activity_preventive_maintenance_site_hygiene_general_safty);
        setTitle("Site Hygiene-General Safety Parameters");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();
        checkCameraPermission();
        setListner();
        sessionManager = new SessionManager(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, userId, ticketName);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        mPreventiveMaintenanceSiteHygieneGeneralSaftyEditTextFireExtingisherExpiryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

    }

    private void assignViews() {
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_sitePremisesCleaning);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_sitePremisesCleaningVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUploadPhotoOfSitePremises = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_uploadPhotoOfSitePremises);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremises = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_uploadPhotoOfSitePremises);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremisesView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_uploadPhotoOfSitePremisesView);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_equipmentCleaning);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaningVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_equipmentCleaningVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTower = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_anyHivesInTower);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTowerVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_anyHivesInTowerVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_compoundWallFencingStatus);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_compoundWallFencingStatusVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_gateLockAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_gateLockAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_shelterLockAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_shelterLockAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_dgLockAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_dgLockAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireExtingisherAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireExtingisherAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_noOfFireExtingisherAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_noOfFireExtingisherAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherExpiryDate = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireExtingisherExpiryDate);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyEditTextFireExtingisherExpiryDate = (EditText) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_editText_fireExtingisherExpiryDate);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireBucketAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireBucketAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCautionSignBoardPhoto = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_cautionSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhoto = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_cautionSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_cautionSignBoardPhotoView);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewWarningSignBoardPhoto = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_warningSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhoto = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_warningSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_warningSignBoardPhotoView);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDangerSignBoardPhoto = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_dangerSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhoto = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_dangerSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_dangerSignBoardPhotoView);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendar = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_safetyChartsAndCalendar);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendarVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_safetyChartsAndCalendarVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_unusedMaterialInSite);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_unusedMaterialInSiteVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_registerFault);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_registerFaultVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_typesOfFault);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_typesOfFaultVal);
    }

    private void initCombo() {
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_sitePremisesCleaning))),
                        "Site Premises Cleaning",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSitePremisesCleaningVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal.setText(str_pmSitePremisesCleaningVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaningVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_equipmentCleaning))),
                        "Equipment Cleaning",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteanyEagleOrCrowOrHoneyHivesInTowerVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaningVal.setText(str_pmSiteanyEagleOrCrowOrHoneyHivesInTowerVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTowerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_anyEagleOrCrowOrHoneyHivesInTower))),
                        "Any Eagle/Crow/Honey Hives in Tower",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteanyEagleOrCrowOrHoneyHivesInTowerVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTowerVal.setText(str_pmSiteanyEagleOrCrowOrHoneyHivesInTowerVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_compoundWallOrFencingStatus))),
                        "Compound Wall/Fencing Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteCompoundWallOrFencingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal.setText(str_pmSiteCompoundWallOrFencingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_gateLockAvailablity))),
                        "Gate Lock Availablity",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteGateLockAvailablityVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablityVal.setText(str_pmSiteGateLockAvailablityVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_shelterLockAvailablity))),
                        "Shelter Lock Availablity",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteShelterLockAvailablityVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablityVal.setText(str_pmSiteShelterLockAvailablityVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_dgLockAvailablity))),
                        "DG Lock Availablity",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgLockAvailablityVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablityVal.setText(str_pmSiteDgLockAvailablityVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_fireExtinguisherAvailablity))),
                        "Fire Extingisher Availablity",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteFireExtinguisherAvilabilityVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal.setText(str_pmSiteFireExtinguisherAvilabilityVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_noOfFireExtinguisher))),
                        "No of Fire Extingisher",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteNoOfFireExtinguisherVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablityVal.setText(str_pmSiteNoOfFireExtinguisherVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_fireBucket))),
                        "Fire Bucket",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteFireBucketVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablityVal.setText(str_pmSiteFireBucketVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendarVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_safetyChartsAndCalender))),
                        "Safety Charts & Calender",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteSafetyChartsAndCalendarVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendarVal.setText(str_pmSiteSafetyChartsAndCalendarVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_unusedMaterialOnSite))),
                        "Un-Used Material in Site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteUnusedMaterialInSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSiteVal.setText(str_pmSiteUnusedMaterialInSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteRegisterFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal.setText(str_pmSiteRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteTypeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal.setText(str_pmSiteTypeOfFaultVal);
                    }
                });
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MMM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mPreventiveMaintenanceSiteHygieneGeneralSaftyEditTextFireExtingisherExpiryDate.setText(sdf.format(myCalendar.getTime()));
    }

    private void setListner() {
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    UploadPhotoOfSitePremises();
                }
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    CautionSignBoardPhoto();
                }
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    WarningSignBoardPhoto();
                }
            }
        });
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    DangerSignBoardPhoto();
                }
            }
        });

        //////////////////////////

        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremisesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriUploadPhotoOfSitePremises != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, imageFileUriUploadPhotoOfSitePremises);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriCautionSignBoard != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, imageFileUriCautionSignBoard);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriWarningSignBoard != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, imageFileUriWarningSignBoard);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriDangerSignBoard != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, imageFileUriDangerSignBoard);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void UploadPhotoOfSitePremises() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileUploadPhotoOfSitePremises = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_sitePremises.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileUploadPhotoOfSitePremises);
            imageFileUriUploadPhotoOfSitePremises = FileProvider.getUriForFile(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriUploadPhotoOfSitePremises);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_UploadPhotoOfSitePremises);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CautionSignBoardPhoto() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileCautionSignBoard = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_cautionBoard.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileCautionSignBoard);
            imageFileUriCautionSignBoard = FileProvider.getUriForFile(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriCautionSignBoard);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_CautionSignBoard);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void WarningSignBoardPhoto() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileWarningSignBoard = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_warningBoard.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileWarningSignBoard);
            imageFileUriWarningSignBoard = FileProvider.getUriForFile(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriWarningSignBoard);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_WarningSignBoard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DangerSignBoardPhoto() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileDangerSignBoard = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_dangerBoard.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileDangerSignBoard);
            imageFileUriDangerSignBoard = FileProvider.getUriForFile(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriDangerSignBoard);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_DangerSignBoard);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean checkCameraPermission() {

        if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
        } else {
            return true;
        }


        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA_UploadPhotoOfSitePremises:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriUploadPhotoOfSitePremises != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriUploadPhotoOfSitePremises);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringUploadPhotoOfSitePremises = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremisesView.setVisibility(View.VISIBLE);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileUploadPhotoOfSitePremises = "";
                    imageFileUriUploadPhotoOfSitePremises = null;
                    mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremisesView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_CautionSignBoard:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriCautionSignBoard != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriCautionSignBoard);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringCautionSignBoard = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhotoView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileCautionSignBoard = "";
                    imageFileUriCautionSignBoard = null;
                    mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhotoView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_WarningSignBoard:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriWarningSignBoard != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriWarningSignBoard);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringWarningSignBoard = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhotoView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileWarningSignBoard = "";
                    imageFileUriWarningSignBoard = null;
                    mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhotoView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_DangerSignBoard:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriDangerSignBoard != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriDangerSignBoard);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringDangerSignBoard = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhotoView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileDangerSignBoard = "";
                    imageFileUriDangerSignBoard = null;
                    mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhotoView.setVisibility(View.GONE);
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
                startActivity(new Intent(this, PreventiveMaintenanceSiteAlarmCheckPointsActivity.class));
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

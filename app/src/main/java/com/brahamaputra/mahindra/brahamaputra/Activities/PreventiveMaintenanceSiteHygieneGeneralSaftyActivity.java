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
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.abdeveloper.library.MultiSelectDialog;
import com.abdeveloper.library.MultiSelectModel;
import com.brahamaputra.mahindra.brahamaputra.BuildConfig;
import com.brahamaputra.mahindra.brahamaputra.Data.LandDetailsData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerMultiSelectionItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerSelectionDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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


    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutSitePremisesCleaning;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaning;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutUploadPhotoOfSitePremises;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUploadPhotoOfSitePremises;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremises;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremisesView;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutEquipmentCleaning;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaning;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaningVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutAnyHivesInTower;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTower;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTowerVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutCompoundWallFencingStatus;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatus;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutGateLockAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablityVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutShelterLockAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablityVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutDgLockAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablityVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutFireExtingisherAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutNoOfFireExtingisherAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablityVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutFireExtingisherExpiryDate;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherExpiryDate;
    private EditText mPreventiveMaintenanceSiteHygieneGeneralSaftyEditTextFireExtingisherExpiryDate;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutFireBucketAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablityVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutCautionSignBoardPhoto;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCautionSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhotoView;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutWarningSignBoardPhoto;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewWarningSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhotoView;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutDangerSignBoardPhoto;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDangerSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhotoView;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutSafetyChartsAndCalendar;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendar;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendarVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutUnusedMaterialInSite;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSite;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSiteVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutRegisterFault;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal;
    private LinearLayout mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutTypesOfFault;
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
    MultiSelectDialog multiSelectDialog;


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

        visibilityOfCompoundWallFencingStatus("");
        visibilityOfShelterLockAvailablity("");
        visibilityOfDgLockAvailablity("");

        //Code For MultiSelect Type Of Fault
        ArrayList<String> typeOfFaultList =  new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_typeOfFault)));
        ArrayList<MultiSelectModel> listOfFaultsTypes = new ArrayList<>();
        int id=1;
        for(int i=0;i<typeOfFaultList.size();i++) {
            listOfFaultsTypes.add(new MultiSelectModel(id, typeOfFaultList.get(i).toString()));
            id++;
        }
        //MultiSelectModel
        multiSelectDialog = new MultiSelectDialog()
                .title("Type of Fault") //setting title for dialog
                .titleSize(25)
                .positiveText("Done")
                .negativeText("Cancel")
                .setMinSelectionLimit(0)
                .setMaxSelectionLimit(typeOfFaultList.size())
                //List of ids that you need to be selected
                .multiSelectList(listOfFaultsTypes) // the multi select model list with ids and name
                .onSubmit(new MultiSelectDialog.SubmitCallbackListener() {
                    @Override
                    public void onSelected(ArrayList<Integer> selectedIds, ArrayList<String> selectedNames, String dataString) {
                        //will return list of selected IDS
                        str_pmSiteTypeOfFaultVal = dataString;
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal.setText(str_pmSiteTypeOfFaultVal);

                    }

                    @Override
                    public void onCancel() {
                        Log.d(TAG, "Dialog cancelled");

                    }
                });
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutSitePremisesCleaning = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_sitePremisesCleaning);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_sitePremisesCleaning);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_sitePremisesCleaningVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutUploadPhotoOfSitePremises = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_uploadPhotoOfSitePremises);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUploadPhotoOfSitePremises = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_uploadPhotoOfSitePremises);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremises = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_uploadPhotoOfSitePremises);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremisesView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_uploadPhotoOfSitePremisesView);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutEquipmentCleaning = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_equipmentCleaning);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_equipmentCleaning);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaningVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_equipmentCleaningVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutAnyHivesInTower = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_anyHivesInTower);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTower = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_anyHivesInTower);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTowerVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_anyHivesInTowerVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutCompoundWallFencingStatus = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_compoundWallFencingStatus);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_compoundWallFencingStatus);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_compoundWallFencingStatusVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutGateLockAvailablity = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_gateLockAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_gateLockAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_gateLockAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutShelterLockAvailablity = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_shelterLockAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_shelterLockAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_shelterLockAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutDgLockAvailablity = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_dgLockAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_dgLockAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_dgLockAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutFireExtingisherAvailablity = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_fireExtingisherAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireExtingisherAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireExtingisherAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutNoOfFireExtingisherAvailablity = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_noOfFireExtingisherAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_noOfFireExtingisherAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_noOfFireExtingisherAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutFireExtingisherExpiryDate = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_fireExtingisherExpiryDate);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherExpiryDate = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireExtingisherExpiryDate);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyEditTextFireExtingisherExpiryDate = (EditText) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_editText_fireExtingisherExpiryDate);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutFireBucketAvailablity = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_fireBucketAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireBucketAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireBucketAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutCautionSignBoardPhoto = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_cautionSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCautionSignBoardPhoto = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_cautionSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhoto = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_cautionSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_cautionSignBoardPhotoView);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutWarningSignBoardPhoto = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_warningSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewWarningSignBoardPhoto = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_warningSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhoto = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_warningSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_warningSignBoardPhotoView);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutDangerSignBoardPhoto = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_dangerSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDangerSignBoardPhoto = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_dangerSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhoto = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_dangerSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_dangerSignBoardPhotoView);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutSafetyChartsAndCalendar = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_safetyChartsAndCalendar);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendar = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_safetyChartsAndCalendar);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendarVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_safetyChartsAndCalendarVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutUnusedMaterialInSite = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_unusedMaterialInSite);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_unusedMaterialInSite);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_unusedMaterialInSiteVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutRegisterFault = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_registerFault);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_registerFault);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_registerFaultVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutTypesOfFault = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_linearLayout_typesOfFault);
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
                        visibilityOfFireExtingisherAvailablity(str_pmSiteFireExtinguisherAvilabilityVal);
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
                        visibilityOfTypesOfFault(str_pmSiteRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiSelectDialog.show(getSupportFragmentManager(), "multiSelectDialog");
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

    private void visibilityOfCompoundWallFencingStatus(String site) {
        //mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal.setText("");
        if (site.isEmpty() || site.equals("Outdoor")) {
            mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutCompoundWallFencingStatus.setVisibility(View.GONE);
        } else {
            mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutCompoundWallFencingStatus.setVisibility(View.VISIBLE);
        }
    }

    private void visibilityOfShelterLockAvailablity(String site) {
        //mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal.setText("");
        if (site.isEmpty() || site.equals("Outdoor")) {
            mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutShelterLockAvailablity.setVisibility(View.GONE);
        } else {
            mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutShelterLockAvailablity.setVisibility(View.VISIBLE);
        }
    }

    private void visibilityOfDgLockAvailablity(String SourceOfPower) {
        if (SourceOfPower.isEmpty() || SourceOfPower.equals("Non DG")) {
            mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutDgLockAvailablity.setVisibility(View.GONE);
        } else {
            mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutDgLockAvailablity.setVisibility(View.VISIBLE);
        }
    }

    private void visibilityOfFireExtingisherAvailablity(String FireExtingisherAvailablity) {

        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutFireExtingisherExpiryDate.setVisibility(View.VISIBLE);
        if (FireExtingisherAvailablity.equals("Not Available")) {
            mPreventiveMaintenanceSiteHygieneGeneralSaftyEditTextFireExtingisherExpiryDate.setText("");
            mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutFireExtingisherExpiryDate.setVisibility(View.GONE);
        }
    }

    private void visibilityOfTypesOfFault(String RegisterFault) {

        mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutTypesOfFault.setVisibility(View.VISIBLE);
        if (RegisterFault.equals("No")) {
            mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal.setText("");
            mPreventiveMaintenanceSiteHygieneGeneralSaftyLinearLayoutTypesOfFault.setVisibility(View.GONE);
        }
    }

    private void submitDetails() {
        try {
            /*String landType = mLandDetailsTextViewTypeOfLandVal.getText().toString().trim();
            String landArea = mLandDetailsEditTextAreaOfLand.getText().toString().trim();
            String rentLeaseValue = mLandDetailsEditTextRentLeaseInNumber.getText().toString().trim();
            String rentLeaseValueInWords = mLandDetailsTextViewRentLeaseInWords_val.getText().toString().trim().toUpperCase();
            String landOwnerName = mLandDetailsEditTextNameOfOwner.getText().toString().trim();
            String landOwnerMob = mLandDetailsEditTextMobileNoOfOwner.getText().toString().trim();
            String landLayout = base64StringLayoutOfLand;
            //String landAgreementCopy = "0";
            String landAgreementCopy = mLandDetailsTextViewCopyAgreementWithOwnerVal.getText().toString().trim();
            String landAgreementValidity = mLandDetailsEditTextDateOfvalidityOfAgreement.getText().toString();

            landDetailsData = new LandDetailsData(landType, landArea, rentLeaseValue, rentLeaseValueInWords, landOwnerName, landOwnerMob, landLayout, landAgreementCopy, landAgreementValidity, imageFileName);

            hotoTransactionData.setLandDetailsData(landDetailsData);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);
            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);*/
        } catch (Exception e) {
            e.printStackTrace();
        }

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

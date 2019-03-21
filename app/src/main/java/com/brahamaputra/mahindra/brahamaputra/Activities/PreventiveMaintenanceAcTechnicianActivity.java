package com.brahamaputra.mahindra.brahamaputra.Activities;


import android.Manifest;
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

public class PreventiveMaintenanceAcTechnicianActivity extends BaseActivity {

    private static final String TAG = PreventiveMaintenanceAcTechnicianActivity.class.getSimpleName();

    private TextView mPreventiveMaintenanceAcTechnicianTextViewCircle;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCircleVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewState;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewStateVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewSsa;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewSsaVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewSiteId;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewSiteIdVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewSiteName;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewSiteNameVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewTicketNo;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewTicketNoVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewTicketDate;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewTicketDateVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewPmPlanDate;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewPmPlanDateVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewSubmittedDate;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewSubmittedDateVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewNoOfAcAtSite;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewNoOfAcAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcNumber;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewQRCodeScan;
    private ImageView mPreventiveMaintenanceAcTechnicianButtonQRCodeScan;
    private ImageView mPreventiveMaintenanceAcTechnicianButtonQRCodeScanView;
    private ImageView mButtonClearQRCodeScanView;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcModel;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcModelVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcType;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcTypeVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcMake;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcMakeVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcCapacity;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcCapacityVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcSerialNo;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcSerialNoVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewMainMcbStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewMainMcbStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewSubMcbStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewSubMcbStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewMetalCladPlugStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewMetalCladPlugStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewMetalCladSocketStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewMetalCladSocketStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewStablizerStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewStablizerStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewStabilizerMake;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewStabilizerMakeVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewStabilizerCapacity;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewStabilizerCapacityVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewStablizerWorkingStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewStablizerWorkingStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewInputAcVoltage;
    private EditText mPreventiveMaintenanceAcTechnicianEditTextInputAcVoltage;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcEarthingStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcEarthingStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewFilterCleaned;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewFilterCleanedVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewFilterCleanedBeforePhoto;

    private ImageView mPreventiveMaintenanceAcTechnicianButtonFilterCleanedBeforePhoto;
    private ImageView mPreventiveMaintenanceAcTechnicianButtonFilterCleanedBeforePhotoView;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewFilterCleanedAfterPhoto;

    private ImageView mPreventiveMaintenanceAcTechnicianButtonFilterCleanedAfterPhoto;
    private ImageView mPreventiveMaintenanceAcTechnicianButtonFilterCleanedAfterPhotoView;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCondenserCoilCleaned;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCondenserCoilCleanedVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCondenserCoilCleanedBeforePhoto;

    private ImageView mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedBeforePhoto;
    private ImageView mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedBeforePhotoView;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCondenserCoilCleanedAfterPhoto;

    private ImageView mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedAfterPhoto;
    private ImageView mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedAfterPhotoView;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCoolingCoilCleaned;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCoolingCoilCleanedVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCoolingCoilCleanedBeforePhoto;

    private ImageView mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedBeforePhoto;
    private ImageView mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedBeforePhotoView;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCoolingCoilCleanedAfterPhoto;

    private ImageView mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedAfterPhoto;
    private ImageView mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedAfterPhotoView;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcCoolingStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcCoolingStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcStartingLoadcurrent;
    private EditText mPreventiveMaintenanceAcTechnicianEditTextAcStartingLoadcurrent;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcRunningLoadCurrent;
    private EditText mPreventiveMaintenanceAcTechnicianEditTextAcRunningLoadCurrent;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewIndoorFilterCleanedStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewIndoorFilterCleanedStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewIndoorFanMotorCondition;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewIndoorFanMotorConditionVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewBlowerWheelCondition;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewBlowerWheelConditionVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewNoiseIndoorMotor;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewNoiseIndoorMotorVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewOutdoorFanMotorCondition;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewOutdoorFanMotorConditionVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewFanLeafCondition;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewFanLeafConditionVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewNoiseOutdoorMotor;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewNoiseOutdoorMotorVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCompressorCondition;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCompressorConditionVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCompCapacitorCondition;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewCompCapacitorConditionVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewControllerCondition;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewControllerConditionVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcAlarmStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcAlarmStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcSensorCondition;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcSensorConditionVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewRoomTemperature;
    private EditText mPreventiveMaintenanceAcTechnicianEditTextRoomTemperature;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewSetTemperature;
    private EditText mPreventiveMaintenanceAcTechnicianEditTextSetTemperature;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewVibrationOfAc;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewVibrationOfAcVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewFreeCoolingUnitStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewFreeCoolingUnitStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewFreeCoolingAvailableWorkingStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewFreeCoolingAvailableWorkingStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewWaterLeakage;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewWaterLeakageVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcCabinateStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewAcCabinateStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewShelterDoorStatus;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewShelterDoorStatusVal;
    private TextView mPreventiveMaintenanceAcTechnicianTextViewRemarks;
    private EditText mPreventiveMaintenanceAcTechnicianEditTextRemarks;
    private Button mPreventiveMaintenanceAcTechnicianButtonPreviousReading;
    private Button mPreventiveMaintenanceAcTechnicianButtonNextReading;

    String str_noOfAcAtSiteVal;
    String str_mainMcbStatusVal;
    String str_subMcbStatusVal;
    String str_metalCladPlugStatusVal;
    String str_metalCladSocketStatusVal;
    String str_stablizerStatusVal;
    String str_stabilizerMakeVal;
    String str_stabilizerCapacityVal;
    String str_stablizerWorkingStatusVal;
    String str_acEarthingStatusVal;
    String str_filterCleanedVal;
    String str_condenserCoilCleanedVal;
    String str_coolingCoilCleanedVal;
    String str_acCoolingStatusVal;
    String str_indoorFilterCleanedStatusVal;
    String str_indoorFanMotorConditionVal;
    String str_blowerWheelConditionVal;
    String str_noiseIndoorMotorVal;
    String str_outdoorFanMotorConditionVal;
    String str_fanLeafConditionVal;
    String str_noiseOutdoorMotorVal;
    String str_compressorConditionVal;
    String str_compCapacitorConditionVal;
    String str_controllerConditionVal;
    String str_acAlarmStatusVal;
    String str_acSensorConditionVal;
    String str_vibrationOfAcVal;
    String str_freeCoolingUnitStatusVal;
    String str_freeCoolingAvailableWorkingStatusVal;
    String str_waterLeakageVal;
    String str_acCabinateStatusVal;
    String str_shelterDoorStatusVal;

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_FilterCleanedBeforePhoto = 101;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_FilterCleanedAfterPhoto = 102;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_CondenserCoilCleanedBeforePhoto = 103;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_CondenserCoilCleanedAfterPhoto = 104;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_CoolingCoilCleanedBeforePhoto = 105;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_CoolingCoilCleanedAfterPhoto = 106;


    private String base64StringAcTechnicianQRCodeScan = "";
    //private String imageFileAcTechnicianQRCodeScan;
    //private Uri imageFileUriAcTechnicianQRCodeScan = null;

    private String base64StringFilterCleanedBeforePhoto = "";
    private String base64StringFilterCleanedAfterPhoto = "";
    private String base64StringCondenserCoilCleanedBeforePhoto = "";
    private String base64StringCondenserCoilCleanedAfterPhoto = "";
    private String base64StringCoolingCoilCleanedBeforePhoto = "";
    private String base64StringCoolingCoilCleanedAfterPhoto = "";

    private String imageFileFilterCleanedBeforePhoto;
    private String imageFileFilterCleanedAfterPhoto;
    private String imageFileCondenserCoilCleanedBeforePhoto;
    private String imageFileCondenserCoilCleanedAfterPhoto;
    private String imageFileCoolingCoilCleanedBeforePhoto;
    private String imageFileCoolingCoilCleanedAfterPhoto;

    private Uri imageFileUriFilterCleanedBeforePhoto = null;
    private Uri imageFileUriFilterCleanedAfterPhoto = null;
    private Uri imageFileUriCondenserCoilCleanedBeforePhoto = null;
    private Uri imageFileUriCondenserCoilCleanedAfterPhoto = null;
    private Uri imageFileUriCoolingCoilCleanedBeforePhoto = null;
    private Uri imageFileUriCoolingCoilCleanedAfterPhoto = null;

    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    private AlertDialogManager alertDialogManager;

    private String userId = "1111";
    private String ticketId = "1111";
    private String ticketName = "1111";

    /*private HotoTransactionData hotoTransactionData;
    private LandDetailsData landDetailsData;*/
    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_ac_technician);
        this.setTitle("AC Preventive Maintenance Process");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        alertDialogManager = new AlertDialogManager(PreventiveMaintenanceAcTechnicianActivity.this);
        sessionManager = new SessionManager(PreventiveMaintenanceAcTechnicianActivity.this);
        //ticketId = sessionManager.getSessionUserTicketId();
        //ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceAcTechnicianActivity.this, userId, ticketName);

        assignViews();
        initCombo();
        setListner();


    }

    private void assignViews() {
        mPreventiveMaintenanceAcTechnicianTextViewCircle = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_circle);
        mPreventiveMaintenanceAcTechnicianTextViewCircleVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_circleVal);
        mPreventiveMaintenanceAcTechnicianTextViewState = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_state);
        mPreventiveMaintenanceAcTechnicianTextViewStateVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_stateVal);
        mPreventiveMaintenanceAcTechnicianTextViewSsa = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_ssa);
        mPreventiveMaintenanceAcTechnicianTextViewSsaVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_ssaVal);
        mPreventiveMaintenanceAcTechnicianTextViewSiteId = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_siteId);
        mPreventiveMaintenanceAcTechnicianTextViewSiteIdVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_siteIdVal);
        mPreventiveMaintenanceAcTechnicianTextViewSiteName = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_siteName);
        mPreventiveMaintenanceAcTechnicianTextViewSiteNameVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_siteNameVal);
        mPreventiveMaintenanceAcTechnicianTextViewTicketNo = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_ticketNo);
        mPreventiveMaintenanceAcTechnicianTextViewTicketNoVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_ticketNoVal);
        mPreventiveMaintenanceAcTechnicianTextViewTicketDate = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_ticketDate);
        mPreventiveMaintenanceAcTechnicianTextViewTicketDateVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_ticketDateVal);
        mPreventiveMaintenanceAcTechnicianTextViewPmPlanDate = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_pmPlanDate);
        mPreventiveMaintenanceAcTechnicianTextViewPmPlanDateVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_pmPlanDateVal);
        mPreventiveMaintenanceAcTechnicianTextViewSubmittedDate = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_submittedDate);
        mPreventiveMaintenanceAcTechnicianTextViewSubmittedDateVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_submittedDateVal);
        mPreventiveMaintenanceAcTechnicianTextViewNoOfAcAtSite = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_noOfAcAtSite);
        mPreventiveMaintenanceAcTechnicianTextViewNoOfAcAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_noOfAcAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceAcTechnicianTextViewAcNumber = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_AcNumber);
        mPreventiveMaintenanceAcTechnicianTextViewQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_QRCodeScan);
        mPreventiveMaintenanceAcTechnicianButtonQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_QRCodeScan);
        mPreventiveMaintenanceAcTechnicianButtonQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_QRCodeScanView);
        mButtonClearQRCodeScanView = (ImageView) findViewById(R.id.button_ClearQRCodeScanView);
        mPreventiveMaintenanceAcTechnicianTextViewAcModel = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acModel);
        mPreventiveMaintenanceAcTechnicianTextViewAcModelVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acModelVal);
        mPreventiveMaintenanceAcTechnicianTextViewAcType = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acType);
        mPreventiveMaintenanceAcTechnicianTextViewAcTypeVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acTypeVal);
        mPreventiveMaintenanceAcTechnicianTextViewAcMake = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acMake);
        mPreventiveMaintenanceAcTechnicianTextViewAcMakeVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acMakeVal);
        mPreventiveMaintenanceAcTechnicianTextViewAcCapacity = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acCapacity);
        mPreventiveMaintenanceAcTechnicianTextViewAcCapacityVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acCapacityVal);
        mPreventiveMaintenanceAcTechnicianTextViewAcSerialNo = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acSerialNo);
        mPreventiveMaintenanceAcTechnicianTextViewAcSerialNoVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acSerialNoVal);
        mPreventiveMaintenanceAcTechnicianTextViewMainMcbStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_mainMcbStatus);
        mPreventiveMaintenanceAcTechnicianTextViewMainMcbStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_mainMcbStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewSubMcbStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_subMcbStatus);
        mPreventiveMaintenanceAcTechnicianTextViewSubMcbStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_subMcbStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewMetalCladPlugStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_metalCladPlugStatus);
        mPreventiveMaintenanceAcTechnicianTextViewMetalCladPlugStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_metalCladPlugStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewMetalCladSocketStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_metalCladSocketStatus);
        mPreventiveMaintenanceAcTechnicianTextViewMetalCladSocketStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_metalCladSocketStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewStablizerStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_stablizerStatus);
        mPreventiveMaintenanceAcTechnicianTextViewStablizerStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_stablizerStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewStabilizerMake = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_stabilizerMake);
        mPreventiveMaintenanceAcTechnicianTextViewStabilizerMakeVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_stabilizerMakeVal);
        mPreventiveMaintenanceAcTechnicianTextViewStabilizerCapacity = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_stabilizerCapacity);
        mPreventiveMaintenanceAcTechnicianTextViewStabilizerCapacityVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_stabilizerCapacityVal);
        mPreventiveMaintenanceAcTechnicianTextViewStablizerWorkingStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_stablizerWorkingStatus);
        mPreventiveMaintenanceAcTechnicianTextViewStablizerWorkingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_stablizerWorkingStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewInputAcVoltage = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_inputAcVoltage);
        mPreventiveMaintenanceAcTechnicianEditTextInputAcVoltage = (EditText) findViewById(R.id.preventiveMaintenanceAcTechnician_editText_inputAcVoltage);
        mPreventiveMaintenanceAcTechnicianTextViewAcEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acEarthingStatus);
        mPreventiveMaintenanceAcTechnicianTextViewAcEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acEarthingStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewFilterCleaned = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_filterCleaned);
        mPreventiveMaintenanceAcTechnicianTextViewFilterCleanedVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_filterCleanedVal);
        mPreventiveMaintenanceAcTechnicianTextViewFilterCleanedBeforePhoto = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_filterCleanedBeforePhoto);
        mPreventiveMaintenanceAcTechnicianButtonFilterCleanedBeforePhoto = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_filterCleanedBeforePhoto);
        mPreventiveMaintenanceAcTechnicianButtonFilterCleanedBeforePhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_filterCleanedBeforePhotoView);
        mPreventiveMaintenanceAcTechnicianTextViewFilterCleanedAfterPhoto = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_filterCleanedAfterPhoto);
        mPreventiveMaintenanceAcTechnicianButtonFilterCleanedAfterPhoto = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_filterCleanedAfterPhoto);
        mPreventiveMaintenanceAcTechnicianButtonFilterCleanedAfterPhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_filterCleanedAfterPhotoView);
        mPreventiveMaintenanceAcTechnicianTextViewCondenserCoilCleaned = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_condenserCoilCleaned);
        mPreventiveMaintenanceAcTechnicianTextViewCondenserCoilCleanedVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_condenserCoilCleanedVal);
        mPreventiveMaintenanceAcTechnicianTextViewCondenserCoilCleanedBeforePhoto = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_condenserCoilCleanedBeforePhoto);
        mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedBeforePhoto = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_condenserCoilCleanedBeforePhoto);
        mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedBeforePhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_condenserCoilCleanedBeforePhotoView);
        mPreventiveMaintenanceAcTechnicianTextViewCondenserCoilCleanedAfterPhoto = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_condenserCoilCleanedAfterPhoto);
        mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedAfterPhoto = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_condenserCoilCleanedAfterPhoto);
        mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedAfterPhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_condenserCoilCleanedAfterPhotoView);
        mPreventiveMaintenanceAcTechnicianTextViewCoolingCoilCleaned = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_coolingCoilCleaned);
        mPreventiveMaintenanceAcTechnicianTextViewCoolingCoilCleanedVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_coolingCoilCleanedVal);
        mPreventiveMaintenanceAcTechnicianTextViewCoolingCoilCleanedBeforePhoto = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_coolingCoilCleanedBeforePhoto);
        mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedBeforePhoto = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_coolingCoilCleanedBeforePhoto);
        mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedBeforePhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_coolingCoilCleanedBeforePhotoView);
        mPreventiveMaintenanceAcTechnicianTextViewCoolingCoilCleanedAfterPhoto = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_coolingCoilCleanedAfterPhoto);
        mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedAfterPhoto = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_coolingCoilCleanedAfterPhoto);
        mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedAfterPhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceAcTechnician_button_coolingCoilCleanedAfterPhotoView);
        mPreventiveMaintenanceAcTechnicianTextViewAcCoolingStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acCoolingStatus);
        mPreventiveMaintenanceAcTechnicianTextViewAcCoolingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acCoolingStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewAcStartingLoadcurrent = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acStartingLoadcurrent);
        mPreventiveMaintenanceAcTechnicianEditTextAcStartingLoadcurrent = (EditText) findViewById(R.id.preventiveMaintenanceAcTechnician_editText_acStartingLoadcurrent);
        mPreventiveMaintenanceAcTechnicianTextViewAcRunningLoadCurrent = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acRunningLoadCurrent);
        mPreventiveMaintenanceAcTechnicianEditTextAcRunningLoadCurrent = (EditText) findViewById(R.id.preventiveMaintenanceAcTechnician_editText_acRunningLoadCurrent);
        mPreventiveMaintenanceAcTechnicianTextViewIndoorFilterCleanedStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_indoorFilterCleanedStatus);
        mPreventiveMaintenanceAcTechnicianTextViewIndoorFilterCleanedStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_indoorFilterCleanedStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewIndoorFanMotorCondition = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_indoorFanMotorCondition);
        mPreventiveMaintenanceAcTechnicianTextViewIndoorFanMotorConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_indoorFanMotorConditionVal);
        mPreventiveMaintenanceAcTechnicianTextViewBlowerWheelCondition = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_blowerWheelCondition);
        mPreventiveMaintenanceAcTechnicianTextViewBlowerWheelConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_blowerWheelConditionVal);
        mPreventiveMaintenanceAcTechnicianTextViewNoiseIndoorMotor = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_noiseIndoorMotor);
        mPreventiveMaintenanceAcTechnicianTextViewNoiseIndoorMotorVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_noiseIndoorMotorVal);
        mPreventiveMaintenanceAcTechnicianTextViewOutdoorFanMotorCondition = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_outdoorFanMotorCondition);
        mPreventiveMaintenanceAcTechnicianTextViewOutdoorFanMotorConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_outdoorFanMotorConditionVal);
        mPreventiveMaintenanceAcTechnicianTextViewFanLeafCondition = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_fanLeafCondition);
        mPreventiveMaintenanceAcTechnicianTextViewFanLeafConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_fanLeafConditionVal);
        mPreventiveMaintenanceAcTechnicianTextViewNoiseOutdoorMotor = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_noiseOutdoorMotor);
        mPreventiveMaintenanceAcTechnicianTextViewNoiseOutdoorMotorVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_noiseOutdoorMotorVal);
        mPreventiveMaintenanceAcTechnicianTextViewCompressorCondition = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_compressorCondition);
        mPreventiveMaintenanceAcTechnicianTextViewCompressorConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_compressorConditionVal);
        mPreventiveMaintenanceAcTechnicianTextViewCompCapacitorCondition = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_compCapacitorCondition);
        mPreventiveMaintenanceAcTechnicianTextViewCompCapacitorConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_compCapacitorConditionVal);
        mPreventiveMaintenanceAcTechnicianTextViewControllerCondition = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_controllerCondition);
        mPreventiveMaintenanceAcTechnicianTextViewControllerConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_controllerConditionVal);
        mPreventiveMaintenanceAcTechnicianTextViewAcAlarmStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acAlarmStatus);
        mPreventiveMaintenanceAcTechnicianTextViewAcAlarmStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acAlarmStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewAcSensorCondition = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acSensorCondition);
        mPreventiveMaintenanceAcTechnicianTextViewAcSensorConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acSensorConditionVal);
        mPreventiveMaintenanceAcTechnicianTextViewRoomTemperature = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_roomTemperature);
        mPreventiveMaintenanceAcTechnicianEditTextRoomTemperature = (EditText) findViewById(R.id.preventiveMaintenanceAcTechnician_editText_roomTemperature);
        mPreventiveMaintenanceAcTechnicianTextViewSetTemperature = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_setTemperature);
        mPreventiveMaintenanceAcTechnicianEditTextSetTemperature = (EditText) findViewById(R.id.preventiveMaintenanceAcTechnician_editText_setTemperature);
        mPreventiveMaintenanceAcTechnicianTextViewVibrationOfAc = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_vibrationOfAc);
        mPreventiveMaintenanceAcTechnicianTextViewVibrationOfAcVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_vibrationOfAcVal);
        mPreventiveMaintenanceAcTechnicianTextViewFreeCoolingUnitStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_freeCoolingUnitStatus);
        mPreventiveMaintenanceAcTechnicianTextViewFreeCoolingUnitStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_freeCoolingUnitStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewFreeCoolingAvailableWorkingStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_freeCoolingAvailableWorkingStatus);
        mPreventiveMaintenanceAcTechnicianTextViewFreeCoolingAvailableWorkingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_freeCoolingAvailableWorkingStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewWaterLeakage = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_waterLeakage);
        mPreventiveMaintenanceAcTechnicianTextViewWaterLeakageVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_waterLeakageVal);
        mPreventiveMaintenanceAcTechnicianTextViewAcCabinateStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acCabinateStatus);
        mPreventiveMaintenanceAcTechnicianTextViewAcCabinateStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_acCabinateStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewShelterDoorStatus = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_shelterDoorStatus);
        mPreventiveMaintenanceAcTechnicianTextViewShelterDoorStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_shelterDoorStatusVal);
        mPreventiveMaintenanceAcTechnicianTextViewRemarks = (TextView) findViewById(R.id.preventiveMaintenanceAcTechnician_textView_remarks);
        mPreventiveMaintenanceAcTechnicianEditTextRemarks = (EditText) findViewById(R.id.preventiveMaintenanceAcTechnician_EditText_remarks);
        mPreventiveMaintenanceAcTechnicianButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceAcTechnician_button_previousReading);
        mPreventiveMaintenanceAcTechnicianButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceAcTechnician_button_nextReading);
    }

    private void initCombo() {
        mPreventiveMaintenanceAcTechnicianTextViewNoOfAcAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_noOfAcAtSite))),
                        "No of AC at site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfAcAtSiteVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewNoOfAcAtSiteVal.setText(str_noOfAcAtSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewMainMcbStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_mainMcbStatus))),
                        "Main MCB Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_mainMcbStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewMainMcbStatusVal.setText(str_mainMcbStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewSubMcbStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_subMcbStatus))),
                        "Sub MCB Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_subMcbStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewSubMcbStatusVal.setText(str_subMcbStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewMetalCladPlugStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_metalCladPlugStatus))),
                        "Metal Clad Plug Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_metalCladPlugStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewMetalCladPlugStatusVal.setText(str_metalCladPlugStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewMetalCladSocketStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_metalCladSocketStatus))),
                        "Metal Clad Socket Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_metalCladSocketStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewMetalCladSocketStatusVal.setText(str_metalCladSocketStatusVal);
                    }
                });
            }
        });


        mPreventiveMaintenanceAcTechnicianTextViewStablizerStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_stablizerStatus))),
                        "Stablizer Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_stablizerStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewStablizerStatusVal.setText(str_stablizerStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewStabilizerMakeVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_StabilizerMake))),
                        "Stabilizer Make",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_stabilizerMakeVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewStabilizerMakeVal.setText(str_stabilizerMakeVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewStabilizerCapacityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_stabilizerCapacity))),
                        "Stabilizer Capacity",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_stabilizerCapacityVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewStabilizerCapacityVal.setText(str_stabilizerCapacityVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewStablizerWorkingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_stablizerWorkingStatus))),
                        "Stablizer Working Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_stablizerWorkingStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewStablizerWorkingStatusVal.setText(str_stablizerWorkingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewAcEarthingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_acEarthingStatus))),
                        "AC Earthing Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_acEarthingStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewAcEarthingStatusVal.setText(str_acEarthingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewFilterCleanedVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_filterCleaned))),
                        "Filter Cleaned",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_filterCleanedVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewFilterCleanedVal.setText(str_filterCleanedVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewCondenserCoilCleanedVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_condenserCoilCleaned))),
                        "Condenser Coil Cleaned",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_condenserCoilCleanedVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewCondenserCoilCleanedVal.setText(str_condenserCoilCleanedVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewCoolingCoilCleanedVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_coolingCoilCleaned))),
                        "Cooling Coil Cleaned",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_coolingCoilCleanedVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewCoolingCoilCleanedVal.setText(str_coolingCoilCleanedVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewAcCoolingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_acCoolingStatus))),
                        "AC Cooling Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_acCoolingStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewAcCoolingStatusVal.setText(str_acCoolingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewIndoorFilterCleanedStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_indoorFilterCleanedStatus))),
                        "Indoor filter Cleaned Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_indoorFilterCleanedStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewIndoorFilterCleanedStatusVal.setText(str_indoorFilterCleanedStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewIndoorFanMotorConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_indoorFanMotorCondition))),
                        "Indoor Fan motor condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_indoorFanMotorConditionVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewIndoorFanMotorConditionVal.setText(str_indoorFanMotorConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewBlowerWheelConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_blowerWheelCondition))),
                        "Blower Wheel condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_blowerWheelConditionVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewBlowerWheelConditionVal.setText(str_blowerWheelConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewNoiseIndoorMotorVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_noiseIndoorMotor))),
                        "If any noise Indoor Motor",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noiseIndoorMotorVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewNoiseIndoorMotorVal.setText(str_noiseIndoorMotorVal);
                    }
                });
            }
        });


        mPreventiveMaintenanceAcTechnicianTextViewOutdoorFanMotorConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_outdoorFanMotorCondition))),
                        "Outdoor Fan motor condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_outdoorFanMotorConditionVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewOutdoorFanMotorConditionVal.setText(str_outdoorFanMotorConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewFanLeafConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_fanLeafCondition))),
                        "Fan Leaf Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_fanLeafConditionVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewFanLeafConditionVal.setText(str_fanLeafConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewNoiseOutdoorMotorVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_noiseOutdoorMotor))),
                        "If any noise Outdoor Motor",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noiseOutdoorMotorVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewNoiseOutdoorMotorVal.setText(str_noiseOutdoorMotorVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewCompressorConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_compressorCondition))),
                        "Compressor condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_compressorConditionVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewCompressorConditionVal.setText(str_compressorConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewCompCapacitorConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_compCapacitorCondition))),
                        "Comp - Capacitor condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_compCapacitorConditionVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewCompCapacitorConditionVal.setText(str_compCapacitorConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewControllerConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_controllerCondition))),
                        "Controller condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_controllerConditionVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewControllerConditionVal.setText(str_controllerConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewAcAlarmStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_acAlarmStatus))),
                        "AC Alarm Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_acAlarmStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewAcAlarmStatusVal.setText(str_acAlarmStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewAcSensorConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_acSensorCondition))),
                        "AC Sensor condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_acSensorConditionVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewAcSensorConditionVal.setText(str_acSensorConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewVibrationOfAcVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_vibrationOfAc))),
                        "If any Vibration of AC",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_vibrationOfAcVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewVibrationOfAcVal.setText(str_vibrationOfAcVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewFreeCoolingUnitStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_freeCoolingUnitStatus))),
                        "Free Cooling Unit Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_freeCoolingUnitStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewFreeCoolingUnitStatusVal.setText(str_freeCoolingUnitStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewFreeCoolingAvailableWorkingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_freeCoolingAvailableWorkingStatus))),
                        "If Free Cooling Available, Working Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_freeCoolingAvailableWorkingStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewFreeCoolingAvailableWorkingStatusVal.setText(str_freeCoolingAvailableWorkingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewWaterLeakageVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_waterLeakage))),
                        "Water Leakage if Any",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_waterLeakageVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewWaterLeakageVal.setText(str_waterLeakageVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewAcCabinateStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_acCabinateStatus))),
                        "AC Cabinate Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_acCabinateStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewAcCabinateStatusVal.setText(str_acCabinateStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcTechnicianTextViewShelterDoorStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcTechnicianActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcTechnician_shelterDoorStatus))),
                        "Shelter Door Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_shelterDoorStatusVal = item.get(position);
                        mPreventiveMaintenanceAcTechnicianTextViewShelterDoorStatusVal.setText(str_shelterDoorStatusVal);
                    }
                });
            }
        });

    }


    private void setListner() {

        mPreventiveMaintenanceAcTechnicianButtonQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    AcTechnicianQRCodeScan();
                }
            }
        });

        mButtonClearQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                base64StringAcTechnicianQRCodeScan = "";
                mButtonClearQRCodeScanView.setVisibility(View.GONE);
                mPreventiveMaintenanceAcTechnicianButtonQRCodeScanView.setVisibility(View.GONE);
                showToast("Cleared");
            }
        });

        //////////////

        mPreventiveMaintenanceAcTechnicianButtonFilterCleanedBeforePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    FilterCleanedBeforePhoto();
                }
            }
        });

        mPreventiveMaintenanceAcTechnicianButtonFilterCleanedAfterPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    FilterCleanedAfterPhoto();
                }
            }
        });

        mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedBeforePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    CondenserCoilCleanedBeforePhoto();
                }
            }
        });
        mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedAfterPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    CondenserCoilCleanedAfterPhoto();
                }
            }
        });

        mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedBeforePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    CoolingCoilCleanedBeforePhoto();
                }
            }
        });
        mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedAfterPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    CoolingCoilCleanedAfterPhoto();
                }
            }
        });

        //////////////////////////

        mPreventiveMaintenanceAcTechnicianButtonFilterCleanedBeforePhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriFilterCleanedBeforePhoto != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceAcTechnicianActivity.this, imageFileUriFilterCleanedBeforePhoto);
                } else {
                    Toast.makeText(PreventiveMaintenanceAcTechnicianActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
        mPreventiveMaintenanceAcTechnicianButtonFilterCleanedAfterPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriFilterCleanedAfterPhoto != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceAcTechnicianActivity.this, imageFileUriFilterCleanedAfterPhoto);
                } else {
                    Toast.makeText(PreventiveMaintenanceAcTechnicianActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
        mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedBeforePhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriCondenserCoilCleanedBeforePhoto != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceAcTechnicianActivity.this, imageFileUriCondenserCoilCleanedBeforePhoto);
                } else {
                    Toast.makeText(PreventiveMaintenanceAcTechnicianActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
        mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedAfterPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriCondenserCoilCleanedAfterPhoto != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceAcTechnicianActivity.this, imageFileUriCondenserCoilCleanedAfterPhoto);
                } else {
                    Toast.makeText(PreventiveMaintenanceAcTechnicianActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });

        mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedBeforePhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriCoolingCoilCleanedBeforePhoto != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceAcTechnicianActivity.this, imageFileUriCoolingCoilCleanedBeforePhoto);
                } else {
                    Toast.makeText(PreventiveMaintenanceAcTechnicianActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
        mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedAfterPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriCoolingCoilCleanedAfterPhoto != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceAcTechnicianActivity.this, imageFileUriCoolingCoilCleanedAfterPhoto);
                } else {
                    Toast.makeText(PreventiveMaintenanceAcTechnicianActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void AcTechnicianQRCodeScan() {
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

    private void FilterCleanedBeforePhoto() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileFilterCleanedBeforePhoto = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_sitePremises.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileFilterCleanedBeforePhoto);
            imageFileUriFilterCleanedBeforePhoto = FileProvider.getUriForFile(PreventiveMaintenanceAcTechnicianActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriFilterCleanedBeforePhoto);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_FilterCleanedBeforePhoto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void FilterCleanedAfterPhoto() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileFilterCleanedAfterPhoto = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_cautionBoard.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileFilterCleanedAfterPhoto);
            imageFileUriFilterCleanedAfterPhoto = FileProvider.getUriForFile(PreventiveMaintenanceAcTechnicianActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriFilterCleanedAfterPhoto);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_FilterCleanedAfterPhoto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void CondenserCoilCleanedBeforePhoto() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileCondenserCoilCleanedBeforePhoto = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_warningBoard.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileCondenserCoilCleanedBeforePhoto);
            imageFileUriCondenserCoilCleanedBeforePhoto = FileProvider.getUriForFile(PreventiveMaintenanceAcTechnicianActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriCondenserCoilCleanedBeforePhoto);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_CondenserCoilCleanedBeforePhoto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CondenserCoilCleanedAfterPhoto() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileCondenserCoilCleanedAfterPhoto = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_dangerBoard.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileCondenserCoilCleanedAfterPhoto);
            imageFileUriCondenserCoilCleanedAfterPhoto = FileProvider.getUriForFile(PreventiveMaintenanceAcTechnicianActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriCondenserCoilCleanedAfterPhoto);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_CondenserCoilCleanedAfterPhoto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void CoolingCoilCleanedBeforePhoto() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileCoolingCoilCleanedBeforePhoto = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_warningBoard.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileCoolingCoilCleanedBeforePhoto);
            imageFileUriCoolingCoilCleanedBeforePhoto = FileProvider.getUriForFile(PreventiveMaintenanceAcTechnicianActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriCoolingCoilCleanedBeforePhoto);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_CoolingCoilCleanedBeforePhoto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CoolingCoilCleanedAfterPhoto() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileCoolingCoilCleanedAfterPhoto = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_dangerBoard.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileCoolingCoilCleanedAfterPhoto);
            imageFileUriCoolingCoilCleanedAfterPhoto = FileProvider.getUriForFile(PreventiveMaintenanceAcTechnicianActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriCoolingCoilCleanedAfterPhoto);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_CoolingCoilCleanedAfterPhoto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private boolean checkCameraPermission() {

        if (ContextCompat.checkSelfPermission(PreventiveMaintenanceAcTechnicianActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PreventiveMaintenanceAcTechnicianActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
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
                    mPreventiveMaintenanceAcTechnicianButtonQRCodeScanView.setVisibility(View.GONE);
                    mButtonClearQRCodeScanView.setVisibility(View.GONE);
                    if (result.getContents() == null) {
                        base64StringAcTechnicianQRCodeScan = "";
                        showToast("Cancelled");
                    } else {
                        /*Object[] isDuplicateQRcode = isDuplicateQRcode(result.getContents());
                        boolean flagIsDuplicateQRcode = (boolean) isDuplicateQRcode[1];
                        if (!flagIsDuplicateQRcode) {*/
                        base64StringAcTechnicianQRCodeScan = result.getContents();
                        if (!base64StringAcTechnicianQRCodeScan.isEmpty() && base64StringAcTechnicianQRCodeScan != null) {
                            mPreventiveMaintenanceAcTechnicianButtonQRCodeScanView.setVisibility(View.VISIBLE);
                            mButtonClearQRCodeScanView.setVisibility(View.VISIBLE);
                        }
                        /*} else {
                            base64StringAcTechnicianQRCodeScan = "";
                            showToast("This QR Code Already Used in " + isDuplicateQRcode[0] + " Section");
                        }*/
                    }
                }
                break;


            case MY_PERMISSIONS_REQUEST_CAMERA_FilterCleanedBeforePhoto:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriFilterCleanedBeforePhoto != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriFilterCleanedBeforePhoto);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringFilterCleanedBeforePhoto = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceAcTechnicianButtonFilterCleanedBeforePhotoView.setVisibility(View.VISIBLE);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileFilterCleanedBeforePhoto = "";
                    imageFileUriFilterCleanedBeforePhoto = null;
                    mPreventiveMaintenanceAcTechnicianButtonFilterCleanedBeforePhotoView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_FilterCleanedAfterPhoto:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriFilterCleanedAfterPhoto != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriFilterCleanedAfterPhoto);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringFilterCleanedAfterPhoto = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceAcTechnicianButtonFilterCleanedAfterPhotoView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileFilterCleanedAfterPhoto = "";
                    imageFileUriFilterCleanedAfterPhoto = null;
                    mPreventiveMaintenanceAcTechnicianButtonFilterCleanedAfterPhotoView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_CondenserCoilCleanedBeforePhoto:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriCondenserCoilCleanedBeforePhoto != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriCondenserCoilCleanedBeforePhoto);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringCondenserCoilCleanedBeforePhoto = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedBeforePhotoView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileCondenserCoilCleanedBeforePhoto = "";
                    imageFileUriCondenserCoilCleanedBeforePhoto = null;
                    mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedBeforePhotoView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_CondenserCoilCleanedAfterPhoto:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriCondenserCoilCleanedAfterPhoto != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriCondenserCoilCleanedAfterPhoto);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringCondenserCoilCleanedAfterPhoto = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedAfterPhotoView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileCondenserCoilCleanedAfterPhoto = "";
                    imageFileUriCondenserCoilCleanedAfterPhoto = null;
                    mPreventiveMaintenanceAcTechnicianButtonCondenserCoilCleanedAfterPhotoView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_CoolingCoilCleanedBeforePhoto:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriCoolingCoilCleanedBeforePhoto != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriCoolingCoilCleanedBeforePhoto);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringCoolingCoilCleanedBeforePhoto = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedBeforePhotoView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileCoolingCoilCleanedBeforePhoto = "";
                    imageFileUriCoolingCoilCleanedBeforePhoto = null;
                    mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedBeforePhotoView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_CoolingCoilCleanedAfterPhoto:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriCoolingCoilCleanedAfterPhoto != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriCoolingCoilCleanedAfterPhoto);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringCoolingCoilCleanedAfterPhoto = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedAfterPhotoView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileCoolingCoilCleanedAfterPhoto = "";
                    imageFileUriCoolingCoilCleanedAfterPhoto = null;
                    mPreventiveMaintenanceAcTechnicianButtonCoolingCoilCleanedAfterPhotoView.setVisibility(View.GONE);
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
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }


}

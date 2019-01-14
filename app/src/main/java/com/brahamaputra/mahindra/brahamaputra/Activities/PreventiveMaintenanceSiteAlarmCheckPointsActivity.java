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
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.abdeveloper.library.MultiSelectDialog;
import com.abdeveloper.library.MultiSelectModel;
import com.brahamaputra.mahindra.brahamaputra.BuildConfig;
import com.brahamaputra.mahindra.brahamaputra.Data.AlarmCheckPoints;
import com.brahamaputra.mahindra.brahamaputra.Data.PreventiveMaintanceSiteTransactionDetails;
import com.brahamaputra.mahindra.brahamaputra.Data.SiteHygenieneGenralSeftyParameter;
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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    //private String imageFileUploadPhotoOfSitePremises;
    //private Uri imageFileUriUploadPhotoOfSitePremises = null;

    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    private AlertDialogManager alertDialogManager;

    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;

    private PreventiveMaintanceSiteTransactionDetails pmSiteTransactionDetails;
    private AlarmCheckPoints alarmCheckPoints;

    MultiSelectDialog multiSelectDialog;
    ArrayList<MultiSelectModel> listOfFaultsTypes;
    ArrayList<Integer> alreadySelectedTypeOfFaultList;
    ArrayList<String> typeOfFaultList;

     /*String detailsOfWrmsQrCodeScan;
     String doorOpenAlarm;
     String dgOn;
     String dgOutputAvailable;
     String highRoomTemp;
     String fireSmoke;
     String powerPlantFailure;
     String alarmConfirmedByNoc;
     String remarks;
     String registerFault;
     String typeOfFault;*/

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
        sessionManager = new SessionManager(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this, userId, ticketName);


        pmSiteTransactionDetails = new PreventiveMaintanceSiteTransactionDetails();
        listOfFaultsTypes = new ArrayList<>();
        alreadySelectedTypeOfFaultList = new ArrayList<>();

        //Code For MultiSelect Type Of Fault
        typeOfFaultList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteAlarmCheckPoints_typeOfFault)));
        int id = 1;
        for (int i = 0; i < typeOfFaultList.size(); i++) {
            listOfFaultsTypes.add(new MultiSelectModel(id, typeOfFaultList.get(i).toString()));
            id++;
        }
        setInputDetails();
        setMultiSelectModel();

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


    public void setMultiSelectModel() {
        //MultiSelectModel
        multiSelectDialog = new MultiSelectDialog()
                .title("Type of Fault") //setting title for dialog
                .titleSize(25)
                .positiveText("Done")
                .negativeText("Cancel")
                .preSelectIDsList(alreadySelectedTypeOfFaultList)
                .setMinSelectionLimit(0)
                .setMaxSelectionLimit(typeOfFaultList.size())
                //List of ids that you need to be selected
                .multiSelectList(listOfFaultsTypes) // the multi select model list with ids and name
                .onSubmit(new MultiSelectDialog.SubmitCallbackListener() {
                    @Override
                    public void onSelected(ArrayList<Integer> selectedIds, ArrayList<String> selectedNames, String dataString) {
                        //will return list of selected IDS
                        str_pmSiteAcpTypeOfFaultVal = dataString;
                        mPreventiveMaintenanceSiteAlarmCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteAcpTypeOfFaultVal);

                    }

                    @Override
                    public void onCancel() {
                        Log.d(TAG, "Dialog cancelled");

                    }
                });
    }

    private void setInputDetails() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");
                // Toast.makeText(Land_Details.this,"JsonInString :"+ jsonInString,Toast.LENGTH_SHORT).show();

                Gson gson = new Gson();
//                landDetailsData = gson.fromJson(jsonInString, LandDetailsData.class);

                pmSiteTransactionDetails = gson.fromJson(jsonInString, PreventiveMaintanceSiteTransactionDetails.class);

                if (pmSiteTransactionDetails != null) {

                    alarmCheckPoints = pmSiteTransactionDetails.getAlarmCheckPoints();

                    if (alarmCheckPoints != null) {


                        /*mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal.setText(alarmCheckPoints.getSitePremisesCleaning());
                        this.base64StringUploadPhotoOfSitePremises = alarmCheckPoints.getBase64StringUploadPhotoOfSitePremises();
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaningVal.setText(alarmCheckPoints.getEquipmentCleaning());
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTowerVal.setText(alarmCheckPoints.getAnyEagleCrowHoneyHivesInTower());
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal.setText(alarmCheckPoints.getCompoundWallFencingStatus());
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablityVal.setText(alarmCheckPoints.getGateLockAvailablity());
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablityVal.setText(alarmCheckPoints.getShelterLockAvailablity());
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablityVal.setText(alarmCheckPoints.getDgLockAvailablity());
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal.setText(alarmCheckPoints.getFireExtinguisherAvilability());
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablityVal.setText(alarmCheckPoints.getNoOfFireExtinguisher());
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyEditTextFireExtingisherExpiryDate.setText(alarmCheckPoints.getFireExtinguisherExpiryDate());
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablityVal.setText(alarmCheckPoints.getFireBucket());
                        this.base64StringCautionSignBoard = alarmCheckPoints.getBase64StringCautionSignBoardPhoto();
                        this.base64StringWarningSignBoard = alarmCheckPoints.getBase64StringWarningSignBoardPhoto();
                        this.base64StringDangerSignBoard = alarmCheckPoints.getBase64StringDangerSignBoardPhoto();
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendarVal.setText(alarmCheckPoints.getSafetyChartsCalendar());
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSiteVal.setText(alarmCheckPoints.getUnusedMaterialInSite());
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal.setText(alarmCheckPoints.getRegisterFault());
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal.setText(alarmCheckPoints.getTypeOfFault());

                        visibilityOfFireExtingisherAvailablity(mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal.getText().toString());
                        visibilityOfTypesOfFault(mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal.getText().toString());

                        // New added for image #ImageSet

                        imageFileUploadPhotoOfSitePremises = alarmCheckPoints.getImageFileUploadPhotoOfSitePremises();
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremisesView.setVisibility(View.GONE);
                        if (imageFileUploadPhotoOfSitePremises != null && imageFileUploadPhotoOfSitePremises.length() > 0) {
                            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileUploadPhotoOfSitePremises);
                            imageFileUriUploadPhotoOfSitePremises = FileProvider.getUriForFile(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
                            if (imageFileUriUploadPhotoOfSitePremises != null) {
                                mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremisesView.setVisibility(View.VISIBLE);
                            }
                        }

                        imageFileCautionSignBoard = alarmCheckPoints.getImageFileCautionSignBoard();
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhotoView.setVisibility(View.GONE);
                        if (imageFileCautionSignBoard != null && imageFileCautionSignBoard.length() > 0) {
                            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileCautionSignBoard);
                            imageFileUriCautionSignBoard = FileProvider.getUriForFile(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
                            if (imageFileUriCautionSignBoard != null) {
                                mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhotoView.setVisibility(View.VISIBLE);
                            }
                        }

                        imageFileWarningSignBoard = alarmCheckPoints.getImageFileWarningSignBoard();
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhotoView.setVisibility(View.GONE);
                        if (imageFileWarningSignBoard != null && imageFileWarningSignBoard.length() > 0) {
                            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileWarningSignBoard);
                            imageFileUriWarningSignBoard = FileProvider.getUriForFile(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
                            if (imageFileUriWarningSignBoard != null) {
                                mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhotoView.setVisibility(View.VISIBLE);
                            }
                        }

                        imageFileDangerSignBoard = alarmCheckPoints.getImageFileDangerSignBoard();
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhotoView.setVisibility(View.GONE);
                        if (imageFileDangerSignBoard != null && imageFileDangerSignBoard.length() > 0) {
                            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileDangerSignBoard);
                            imageFileUriDangerSignBoard = FileProvider.getUriForFile(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
                            if (imageFileUriDangerSignBoard != null) {
                                mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhotoView.setVisibility(View.VISIBLE);
                            }
                        }*/

                        if (alarmCheckPoints.getTypeOfFault() != null && alarmCheckPoints.getTypeOfFault().length() > 0 && listOfFaultsTypes.size() > 0) {

                            setArrayValuesOfTypeOfFault(alarmCheckPoints.getTypeOfFault());
                        }
                    }
                }
            } else {
                Toast.makeText(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitDetails() {
        try {



            /*String sitePremisesCleaning = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal.getText().toString().trim();
            String base64StringUploadPhotoOfSitePremises = this.base64StringUploadPhotoOfSitePremises;
            String equipmentCleaning = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaningVal.getText().toString().trim();
            String anyEagleCrowHoneyHivesInTower = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTowerVal.getText().toString().trim();
            String compoundWallFencingStatus = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal.getText().toString().trim();
            String gateLockAvailablity = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablityVal.getText().toString().trim();
            String shelterLockAvailablity = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablityVal.getText().toString().trim();
            String dgLockAvailablity = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablityVal.getText().toString().trim();
            String fireExtinguisherAvilability = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal.getText().toString().trim();
            String noOfFireExtinguisher = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablityVal.getText().toString().trim();
            String fireExtinguisherExpiryDate = mPreventiveMaintenanceSiteHygieneGeneralSaftyEditTextFireExtingisherExpiryDate.getText().toString().trim();
            String fireBucket = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablityVal.getText().toString().trim();
            String base64StringCautionSignBoardPhoto = this.base64StringCautionSignBoard;
            String base64StringWarningSignBoardPhoto = this.base64StringWarningSignBoard;
            String base64StringDangerSignBoardPhoto = this.base64StringDangerSignBoard;
            String safetyChartsCalendar = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendarVal.getText().toString().trim();
            String unusedMaterialInSite = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSiteVal.getText().toString().trim();
            String registerFault = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal.getText().toString().trim();
            String typeOfFault = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal.getText().toString().trim();
            //int isSubmited = mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal.getText().toString().trim();


            alarmCheckPoints = new AlarmCheckPoints(sitePremisesCleaning, base64StringUploadPhotoOfSitePremises, equipmentCleaning,
                    anyEagleCrowHoneyHivesInTower, compoundWallFencingStatus, gateLockAvailablity, shelterLockAvailablity, dgLockAvailablity,
                    fireExtinguisherAvilability, noOfFireExtinguisher, fireExtinguisherExpiryDate, fireBucket, base64StringCautionSignBoardPhoto,
                    base64StringWarningSignBoardPhoto, base64StringDangerSignBoardPhoto, safetyChartsCalendar,
                    unusedMaterialInSite, registerFault, typeOfFault,
                    imageFileUploadPhotoOfSitePremises, imageFileCautionSignBoard,
                    imageFileWarningSignBoard, imageFileDangerSignBoard);

            pmSiteTransactionDetails.setAlarmCheckPoints(alarmCheckPoints);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(pmSiteTransactionDetails);
            Log.d(TAG, "jsonString: " + jsonString);
            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setArrayValuesOfTypeOfFault(String TypeOfFault) {

        if (!TypeOfFault.isEmpty() && TypeOfFault != null) {
            List<String> items = Arrays.asList(TypeOfFault.split("\\s*,\\s*"));
            for (String ss : items) {
                for (MultiSelectModel c : listOfFaultsTypes) {
                    if (ss.equals(c.getName())) {
                        alreadySelectedTypeOfFaultList.add(c.getId());
                        break;
                    }
                }
            }
        }
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

                multiSelectDialog.show(getSupportFragmentManager(), "multiSelectDialog");
                /*SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteAlarmCheckPointsActivity.this,
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
                });*/
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

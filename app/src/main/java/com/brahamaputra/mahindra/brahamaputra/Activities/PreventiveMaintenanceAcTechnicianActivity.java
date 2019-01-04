package com.brahamaputra.mahindra.brahamaputra.Activities;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_ac_technician);
        this.setTitle("Preventive Maintenance AC");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
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
                finish();
                return true;
            case R.id.menuSubmit:
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

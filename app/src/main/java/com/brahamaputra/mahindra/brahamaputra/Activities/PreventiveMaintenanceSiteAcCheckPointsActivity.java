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

public class PreventiveMaintenanceSiteAcCheckPointsActivity extends BaseActivity {

    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewNoOfAcAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewNoOfAcAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcNumber;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonQRCodeScanView;
    private ImageView mButtonClearQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcWorkingCondition;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcWorkingConditionVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAutomationOfAcController;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAutomationOfAcControllerVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcEarthingStatus;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcEarthingStatusVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcFilterStatus;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAcFilterStatusVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewPhotoOfAcFiltersBeforeCleaning;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersBeforeCleaning;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersBeforeCleaningView;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewPhotoOfAcFiltersAfterCleaning;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersAfterCleaning;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersAfterCleaningView;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewCleaningOfCooling;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewCleaningOfCoolingVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAbnormalSoundOfMotor;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewAbnormalSoundOfMotorVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterTemperature;
    private EditText mPreventiveMaintenanceSiteAcCheckPointsEditTextShelterTemperature;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewPhotoOfTemperature;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfTemperature;
    private ImageView mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfTemperatureView;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterDoorStatus;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterDoorStatusVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteAcCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteAcCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteAcCheckPointsButtonNextReading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_ac_check_points);
        assignViews();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteAcCheckPointsTextViewNoOfAcAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_noOfAcAvailableAtSite);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewNoOfAcAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_noOfAcAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acNumber);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_QRCodeScan);
        mPreventiveMaintenanceSiteAcCheckPointsButtonQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_QRCodeScan);
        mPreventiveMaintenanceSiteAcCheckPointsButtonQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_QRCodeScanView);
        mButtonClearQRCodeScanView = (ImageView) findViewById(R.id.button_ClearQRCodeScanView);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcWorkingCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acWorkingCondition);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcWorkingConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acWorkingConditionVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAutomationOfAcController = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_automationOfAcController);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAutomationOfAcControllerVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_automationOfAcControllerVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acEarthingStatus);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acEarthingStatusVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcFilterStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acFilterStatus);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAcFilterStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_acFilterStatusVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewPhotoOfAcFiltersBeforeCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_photoOfAcFiltersBeforeCleaning);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersBeforeCleaning = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_photoOfAcFiltersBeforeCleaning);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersBeforeCleaningView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_photoOfAcFiltersBeforeCleaningView);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewPhotoOfAcFiltersAfterCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_photoOfAcFiltersAfterCleaning);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersAfterCleaning = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_photoOfAcFiltersAfterCleaning);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfAcFiltersAfterCleaningView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_photoOfAcFiltersAfterCleaningView);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewCleaningOfCooling = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_cleaningOfCooling);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewCleaningOfCoolingVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_cleaningOfCoolingVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAbnormalSoundOfMotor = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_abnormalSoundOfMotor);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewAbnormalSoundOfMotorVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_abnormalSoundOfMotorVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterTemperature = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_shelterTemperature);
        mPreventiveMaintenanceSiteAcCheckPointsEditTextShelterTemperature = (EditText) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_editText_shelterTemperature);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewPhotoOfTemperature = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_photoOfTemperature);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfTemperature = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_photoOfTemperature);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPhotoOfTemperatureView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_photoOfTemperatureView);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterDoorStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_shelterDoorStatus);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewShelterDoorStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_shelterDoorStatusVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteAcCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteAcCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteAcCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteAcCheckPoints_button_nextReading);
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
                //startActivity(new Intent(this, Tower_Detail.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

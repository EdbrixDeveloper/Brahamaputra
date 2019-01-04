package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;

public class PreventiveMaintenanceSiteBatteryBankCheckPointsActivity extends AppCompatActivity {
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBattreyBankNumber;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewDetailsOfBatteryBankQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView;
    private ImageView mButtonClearDetailsOfBatteryBankQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTest;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTestVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorque;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorqueVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyApplied;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyAppliedVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatus;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatusVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatus;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatusVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_battery_bank_check_points);
        assignViews();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_noOfBatteryBankAvailableAtSite);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewNoOfBatteryBankAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_noOfBatteryBankAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBattreyBankNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_battreyBankNumber);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewDetailsOfBatteryBankQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_detailsOfBatteryBankQRCodeScan);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_button_detailsOfBatteryBankQRCodeScan);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonDetailsOfBatteryBankQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_button_detailsOfBatteryBankQRCodeScanView);
        mButtonClearDetailsOfBatteryBankQRCodeScanView = (ImageView) findViewById(R.id.button_ClearDetailsOfBatteryBankQRCodeScanView);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTest = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_batteryBankDischargeTest);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryBankDischargeTestVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_batteryBankDischargeTestVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorque = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_stripBoltTightnessAsPerTorque);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewStripBoltTightnessAsPerTorqueVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_stripBoltTightnessAsPerTorqueVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyApplied = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_petroleumJellyApplied);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewPetroleumJellyAppliedVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_petroleumJellyAppliedVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_batteryVentPlugStatus);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBatteryVentPlugStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_batteryVentPlugStatusVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_bbEarthingStatus);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewBbEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_bbEarthingStatusVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteBatteryBankCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteBatteryBankCheckPoints_button_nextReading);
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

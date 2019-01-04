package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
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
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;

public class PreventiveMaintenanceSiteDgBatteryCheckPointsActivity extends BaseActivity {
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewNoOfDgBatteryAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewNoOfDgBatteryAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewBatteryNumber;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDetailsOfDgBatteryQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonDetailsOfDgBatteryQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonDetailsOfDgBatteryQRCodeScanView;
    private ImageView mButtonClearDetailsOfDgBatteryQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryCondition;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryConditionVal;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryWaterAvailable;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryWaterAvailableVal;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewPetroleumJellyToDGBatteryTerminal;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewPetroleumJellyToDGBatteryTerminalVal;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryCharger;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryChargerVal;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonNextReading;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_dg_battery_check_points);
        this.setTitle("Dg Battery Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
    }
    private void assignViews() {
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewNoOfDgBatteryAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_noOfDgBatteryAvailableAtSite);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewNoOfDgBatteryAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_noOfDgBatteryAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewBatteryNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_batteryNumber);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDetailsOfDgBatteryQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_detailsOfDgBatteryQRCodeScan);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonDetailsOfDgBatteryQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_button_detailsOfDgBatteryQRCodeScan);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonDetailsOfDgBatteryQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_button_detailsOfDgBatteryQRCodeScanView);
        mButtonClearDetailsOfDgBatteryQRCodeScanView = (ImageView) findViewById(R.id.button_ClearDetailsOfDgBatteryQRCodeScanView);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_dgBatteryCondition);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_dgBatteryConditionVal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryWaterAvailable = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_dgBatteryWaterAvailable);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryWaterAvailableVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_dgBatteryWaterAvailableVal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewPetroleumJellyToDGBatteryTerminal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_petroleumJellyToDGBatteryTerminal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewPetroleumJellyToDGBatteryTerminalVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_petroleumJellyToDGBatteryTerminalVal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryCharger = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_dgBatteryCharger);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewDgBatteryChargerVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_dgBatteryChargerVal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteDgBatteryCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteDgBatteryCheckPoints_button_nextReading);
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
                startActivity(new Intent(this, PreventiveMaintenanceSiteAcCheckPointsActivity.class));
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

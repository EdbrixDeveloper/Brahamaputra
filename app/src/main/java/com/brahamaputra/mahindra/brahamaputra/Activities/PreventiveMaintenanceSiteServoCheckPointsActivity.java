package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;

public class PreventiveMaintenanceSiteServoCheckPointsActivity extends BaseActivity {
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewDetailsOfServo;
    private ImageView mPreventiveMaintenanceSiteServoCheckPointsButtonDetailsOfServoQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteServoCheckPointsButtonDetailsOfServoQRCodeScanView;
    private ImageView mButtonClearDetailsOfServoQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewServoWorkingStatus;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewServoWorkingStatusVal;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewAnyBypassInSvs;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewAnyBypassInSvsVal;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewSvsEarthingStatus;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewSvsEarthingStatusVal;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteServoCheckPointsTextViewTypeOfFaultVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_servo_check_points);
        this.setTitle("Servo Check Points");
        assignViews();
    }
    private void assignViews() {
        mPreventiveMaintenanceSiteServoCheckPointsTextViewDetailsOfServo = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_detailsOfServo);
        mPreventiveMaintenanceSiteServoCheckPointsButtonDetailsOfServoQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_button_detailsOfServoQRCodeScan);
        mPreventiveMaintenanceSiteServoCheckPointsButtonDetailsOfServoQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_button_detailsOfServoQRCodeScanView);
        mButtonClearDetailsOfServoQRCodeScanView = (ImageView) findViewById(R.id.button_clearDetailsOfServoQRCodeScanView);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewServoWorkingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_servoWorkingStatus);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewServoWorkingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_servoWorkingStatusVal);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewAnyBypassInSvs = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_anyBypassInSvs);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewAnyBypassInSvsVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_anyBypassInSvsVal);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewSvsEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_svsEarthingStatus);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewSvsEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_svsEarthingStatusVal);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteServoCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteServoCheckPoints_textView_typeOfFaultVal);
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

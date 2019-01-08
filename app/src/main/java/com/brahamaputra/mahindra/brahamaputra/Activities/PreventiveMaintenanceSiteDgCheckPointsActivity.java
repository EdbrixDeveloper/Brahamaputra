package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

public class PreventiveMaintenanceSiteDgCheckPointsActivity extends BaseActivity {
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewDgNumber;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScanView;
    private ImageView mButtonClearQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewDgHmrReading;
    private EditText mPreventiveMaintenanceSiteDgCheckPointsEditTextDgHmrReading;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewPhotoOfDgHmr;
    private ImageView mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmr;
    private ImageView mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmrView;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingCondition;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingConditionVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevel;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevelVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTension;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTensionVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevel;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevelVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatus;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatusVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatus;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatusVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteDgCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteDgCheckPointsButtonNextReading;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_dg_check_points);
        this.setTitle("DG Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_noOfDgAvailableAtSite);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_noOfDgAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_dgNumber);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_QRCodeScan);
        mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_QRCodeScan);
        mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_QRCodeScanView);
        mButtonClearQRCodeScanView = (ImageView) findViewById(R.id.button_ClearQRCodeScanView);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgHmrReading = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_dgHmrReading);
        mPreventiveMaintenanceSiteDgCheckPointsEditTextDgHmrReading = (EditText) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_editText_dgHmrReading);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewPhotoOfDgHmr = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_photoOfDgHmr);
        mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmr = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_photoOfDgHmr);
        mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmrView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_photoOfDgHmrView);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_dgWorkingCondition);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_dgWorkingConditionVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevel = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_coolentLevel);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevelVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_coolentLevelVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTension = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_beltTension);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTensionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_beltTensionVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevel = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_engineLubeOilLevel);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevelVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_engineLubeOilLevelVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_safetyWorkingStatus);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_safetyWorkingStatusVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_powerCableConnectionStatus);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_powerCableConnectionStatusVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteDgCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteDgCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_nextReading);
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
                onBackPressed();
                return true;
            case R.id.menuSubmit:
                startActivity(new Intent(this, PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.class));
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

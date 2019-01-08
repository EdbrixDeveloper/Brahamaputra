package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
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

public class PreventiveMaintenanceSiteSmpsCheckPointsActivity extends BaseActivity {

    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsNumber;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScanView;
    private ImageView mButtonClearQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsCondition;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsConditionVal;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatus;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatusVal;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatus;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatusVal;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewDcLoadCurrent;
    private EditText mPreventiveMaintenanceSiteSmpsCheckPointsEditTextDcLoadCurrent;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewPhotoDcLoadCurrent;
    private ImageView mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrent;
    private ImageView mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrentView;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewDcLoadAmpPh;
    private EditText mPreventiveMaintenanceSiteSmpsCheckPointsEditTextDcLoadAmpPh;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteSmpsCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteSmpsCheckPointsButtonNextReading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_smps_check_points);
        this.setTitle("SMPS Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_noOfSmpsAvailableAtSite);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_noOfSmpsAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsNumber);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_QRCodeScan);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_QRCodeScan);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_QRCodeScanView);
        mButtonClearQRCodeScanView = (ImageView) findViewById(R.id.button_ClearQRCodeScanView);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsCondition);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsConditionVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsControlerStatus);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsControlerStatusVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsEarthingStatus);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsEarthingStatusVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewDcLoadCurrent = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_dcLoadCurrent);
        mPreventiveMaintenanceSiteSmpsCheckPointsEditTextDcLoadCurrent = (EditText) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_editText_dcLoadCurrent);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewPhotoDcLoadCurrent = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_photoDcLoadCurrent);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrent = (ImageView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_photoDcLoadCurrent);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrentView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_photoDcLoadCurrentView);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewDcLoadAmpPh = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_dcLoadAmpPh);
        mPreventiveMaintenanceSiteSmpsCheckPointsEditTextDcLoadAmpPh = (EditText) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_editText_dcLoadAmpPh);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_nextReading);
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
                startActivity(new Intent(this, PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.class));
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

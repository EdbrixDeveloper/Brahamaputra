package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
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

public class PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity extends BaseActivity {

    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSite;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmsAmfPiuNumber;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewQRCodeScan;
    private ImageView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScan;
    private ImageView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScanView;
    private ImageView mButtonClearQRCodeScanView;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManual;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManualVal;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypass;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypassVal;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatus;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatusVal;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_pms_amf_panel_check_points);
        this.setTitle("Pms/Amf Panel Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
    }

    private void assignViews() {
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_noOfPmsAmfPiuAvailableAtSite);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewNoOfPmsAmfPiuAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_noOfPmsAmfPiuAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmsAmfPiuNumber = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_pmsAmfPiuNumber);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_QRCodeScan);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_button_QRCodeScan);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_button_QRCodeScanView);
        mButtonClearQRCodeScanView = (ImageView) findViewById(R.id.button_ClearQRCodeScanView);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManual = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_siteInAutoManual);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewSiteInAutoManualVal = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_siteInAutoManualVal);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypass = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_looseConnectionBypass);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewLooseConnectionBypassVal = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_looseConnectionBypassVal);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_pmfAmfPiuEarthingStatus);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewPmfAmfPiuEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_pmfAmfPiuEarthingStatusVal);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_button_previousReading);
        mPreventiveMaintenanceSitePmsAmfPanelCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSitePmsAmfPanelCheckPoints_button_nextReading);
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
                startActivity(new Intent(this, PreventiveMaintenanceSiteServoCheckPointsActivity.class));
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

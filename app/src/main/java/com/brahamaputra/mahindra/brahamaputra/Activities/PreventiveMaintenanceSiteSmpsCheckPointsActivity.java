package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import java.util.ArrayList;
import java.util.Arrays;

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

    String str_noOfSmpsAvailableAtSiteVal;
    String str_smpsConditionVal;
    String str_smpsControlerStatusVal;
    String str_smpsEarthingStatusVal;
    String str_segisterFaultVal;
    String str_sypeOfFaultVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_smps_check_points);
        this.setTitle("SMPS Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();
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

    private void initCombo() {

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_noOfSMPSAvailableAtSite))),
                        "No of SMPS available at site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfSmpsAvailableAtSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSiteVal.setText(str_noOfSmpsAvailableAtSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_smpsCondition))),
                        "SMPS Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_smpsConditionVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsConditionVal.setText(str_smpsConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_smpsControlerStatus))),
                        "SMPS Controler Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_smpsControlerStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatusVal.setText(str_smpsControlerStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_smpsEarthingStatus))),
                        "SMPS Earthing Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_smpsEarthingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatusVal.setText(str_smpsEarthingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_segisterFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFaultVal.setText(str_segisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_sypeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFaultVal.setText(str_sypeOfFaultVal);
                    }
                });
            }
        });


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

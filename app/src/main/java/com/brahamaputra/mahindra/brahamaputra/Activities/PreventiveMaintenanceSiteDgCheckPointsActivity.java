package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

    String str_pmSiteDgcpNoOfDgAvailableAtSiteVal = "";
    String str_pmSiteDgcpDGWorkingConditionVal = "";
    String str_pmSiteDgcpCoolentLevelVal = "";
    String str_pmSiteDgcpBeltTensionVal = "";
    String str_pmSiteDgcpEngineLubeOilLevelVal = "";
    String str_pmSiteDgcpSafetyWorkingStatusVal = "";
    String str_pmSiteDgcpPowerCableConnectionStatusVal = "";
    String str_pmSiteDgcpRegisterFaultVal = "";
    String str_pmSiteDgcpTypeOfFaultVal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_dg_check_points);
        this.setTitle("DG Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();

    }

    private void initCombo() {
        mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_noOfDgAvailableAtSite))),
                        "No of DG available at site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpNoOfDgAvailableAtSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSiteVal.setText(str_pmSiteDgcpNoOfDgAvailableAtSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_dgWorkingCondition))),
                        "DG Working Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpDGWorkingConditionVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingConditionVal.setText(str_pmSiteDgcpDGWorkingConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevelVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_coolentLevel))),
                        "Coolent Level",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpCoolentLevelVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevelVal.setText(str_pmSiteDgcpCoolentLevelVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTensionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_beltTension))),
                        "Belt Tension",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpBeltTensionVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTensionVal.setText(str_pmSiteDgcpBeltTensionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevelVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_engineLubeOilLevel))),
                        "Engine Lube Oil Level",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpEngineLubeOilLevelVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevelVal.setText(str_pmSiteDgcpEngineLubeOilLevelVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_safetyWorkingStatus))),
                        "Safety Working Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpSafetyWorkingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatusVal.setText(str_pmSiteDgcpSafetyWorkingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_powerCableConnecionStatus))),
                        "Power Cable Connection Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpPowerCableConnectionStatusVal= item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatusVal.setText(str_pmSiteDgcpPowerCableConnectionStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpRegisterFaultVal= item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFaultVal.setText(str_pmSiteDgcpRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_typeOfFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpRegisterFaultVal= item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteDgcpRegisterFaultVal);
                    }
                });
            }
        });
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

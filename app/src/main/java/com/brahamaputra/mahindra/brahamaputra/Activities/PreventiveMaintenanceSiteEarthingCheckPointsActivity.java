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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import java.util.ArrayList;
import java.util.Arrays;

public class PreventiveMaintenanceSiteEarthingCheckPointsActivity extends AppCompatActivity {
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntact;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntactVal;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatus;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatusVal;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatus;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatusVal;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPit;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisible;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewEarthingPitNumber;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewEarthPitValue;
    private EditText mPreventiveMaintenanceSiteEarthingCheckPointsEditTextEarthPitValue;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteEarthingCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading;

    String str_pmSiteEcpAllNutOrBoltsAreIntactVal = "";
    String str_pmSiteEcpIgbOrOgbStatusVal = "";
    String str_pmSiteEcpLightningArresterStatusVal = "";
    String str_pmSiteEcpNumberOfEarthPitVal = "";
    String str_pmSiteEcpNumberOfEarthPitVisibleVal = "";
    String str_pmSiteEcpRegisterFaultVal = "";
    String str_pmSiteEcpTypeOfFaultVal = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_earthing_check_points);
        this.setTitle("Earthing Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();
    }

    private void initCombo() {
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntactVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_allNutOrBoltsAreIntact))),
                        "All Nut/Bolts are Intact",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpAllNutOrBoltsAreIntactVal = item.get(position);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntactVal.setText(str_pmSiteEcpAllNutOrBoltsAreIntactVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_igbOrOgbStatus))),
                        "IGB/OGB Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpIgbOrOgbStatusVal= item.get(position);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatusVal.setText(str_pmSiteEcpIgbOrOgbStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_lightningArresterStatus))),
                        "Lightning Arrester Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpLightningArresterStatusVal= item.get(position);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatusVal.setText(str_pmSiteEcpLightningArresterStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_noOfEarthPit))),
                        "Number of Earth PIT",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpNumberOfEarthPitVal= item.get(position);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal.setText(str_pmSiteEcpNumberOfEarthPitVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_noOfEarthPitVisible))),
                        "Number of Earth PIT Visible",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpNumberOfEarthPitVisibleVal= item.get(position);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.setText(str_pmSiteEcpNumberOfEarthPitVisibleVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpRegisterFaultVal= item.get(position);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.setText(str_pmSiteEcpRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpTypeOfFaultVal= item.get(position);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteEcpTypeOfFaultVal);
                    }
                });
            }
        });
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntact = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_allNutOrBoltsAreIntact);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntactVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_allNutOrBoltsAreIntactVal);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_igbOrOgbStatus);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_igbOrOgbStatusVal);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_lightningArresterStatus);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_lightningArresterStatusVal);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPit = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_numberOfEarthPit);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_numberOfEarthPitVal);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisible = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_numberOfEarthPitVisible);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_numberOfEarthPitVisibleVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewEarthingPitNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_earthingPitNumber);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewEarthPitValue = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_earthPitValue);
        mPreventiveMaintenanceSiteEarthingCheckPointsEditTextEarthPitValue = (EditText) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_editText_earthPitValue);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteEarthingCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_button_nextReading);
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
                startActivity(new Intent(this, PreventiveMaintenanceSiteEbMeterBoxActivity.class));
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

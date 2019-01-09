package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import java.util.ArrayList;
import java.util.Arrays;

public class PreventiveMaintenanceSiteShelterCheckPointsActivity extends BaseActivity {
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterCleaning;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterCleaningVal;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterLeakage;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterLeakageVal;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewHatchPlateEntrySealed;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewHatchPlateEntrySealedVal;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterFloorStatus;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterFloorStatusVal;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterEarthingStatus;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterEarthingStatusVal;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteShelterCheckPointsTextViewTypeOfFaultVal;

    String str_shelterCleaningVal;
    String str_shelterLeakageVal;
    String str_hatchPlateEntrySealedVal;
    String str_shelterFloorStatusVal;
    String str_shelterEarthingStatusVal;
    String str_registerFaultVal;
    String str_typeOfFaultVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_shelter_check_points);
        this.setTitle("Shelter Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_shelterCleaning);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterCleaningVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_shelterCleaningVal);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterLeakage = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_shelterLeakage);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterLeakageVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_shelterLeakageVal);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewHatchPlateEntrySealed = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_hatchPlateEntrySealed);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewHatchPlateEntrySealedVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_hatchPlateEntrySealedVal);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterFloorStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_shelterFloorStatus);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterFloorStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_shelterFloorStatusVal);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_shelterEarthingStatus);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_shelterEarthingStatusVal);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteShelterCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteShelterCheckPoints_textView_typeOfFaultVal);


    }

    private void initCombo() {

        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterCleaningVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteShelterCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteShelterCheckPoints_shelterCleaning))),
                        "Shelter Cleaning",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_shelterCleaningVal = item.get(position);
                        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterCleaningVal.setText(str_shelterCleaningVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterLeakageVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteShelterCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteShelterCheckPoints_shelterLeakage))),
                        "Shelter Leakage",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_shelterLeakageVal = item.get(position);
                        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterLeakageVal.setText(str_shelterLeakageVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteShelterCheckPointsTextViewHatchPlateEntrySealedVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteShelterCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteShelterCheckPoints_hatchPlateEntrySealed))),
                        "Hatch Plate Entry sealed",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_hatchPlateEntrySealedVal = item.get(position);
                        mPreventiveMaintenanceSiteShelterCheckPointsTextViewHatchPlateEntrySealedVal.setText(str_hatchPlateEntrySealedVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterFloorStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteShelterCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteShelterCheckPoints_shelterFloorStatus))),
                        "Shleter Floor Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_shelterFloorStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterFloorStatusVal.setText(str_shelterFloorStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterEarthingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteShelterCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteShelterCheckPoints_shelterEarthingStatus))),
                        "Shelter Earthing Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_shelterEarthingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteShelterCheckPointsTextViewShelterEarthingStatusVal.setText(str_shelterEarthingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteShelterCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteShelterCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteShelterCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_registerFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteShelterCheckPointsTextViewRegisterFaultVal.setText(str_registerFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteShelterCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteShelterCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteShelterCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteShelterCheckPointsTextViewTypeOfFaultVal.setText(str_typeOfFaultVal);
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
                startActivity(new Intent(this, PreventiveMaintenanceSiteOtherElectricalCheckPointsActivity.class));
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

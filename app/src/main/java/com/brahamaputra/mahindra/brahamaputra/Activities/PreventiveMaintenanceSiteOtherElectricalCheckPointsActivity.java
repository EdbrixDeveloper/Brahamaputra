package com.brahamaputra.mahindra.brahamaputra.Activities;

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

public class PreventiveMaintenanceSiteOtherElectricalCheckPointsActivity extends BaseActivity {
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewDcEnergyMeterStatus;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewDcEnergyMeterStatusVal;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewAviationLamp;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewAviationLampVal;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInsideTheShelter;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInsideTheShelterVal;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInSitePremisesOrBulkHead;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInSitePremisesOrBulkHeadVal;

    String str_dcEnergyMeterStatusVal;
    String str_aviationLampVal;
    String str_lightsInsideTheShelterVal;
    String str_lightsInSitePremisesOrBulkHeadVal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_other_electrical_check_points);
        this.setTitle("Other Electrical Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewDcEnergyMeterStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteOtherElectricalCheckPoints_textView_dcEnergyMeterStatus);
        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewDcEnergyMeterStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteOtherElectricalCheckPoints_textView_dcEnergyMeterStatusVal);
        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewAviationLamp = (TextView) findViewById(R.id.preventiveMaintenanceSiteOtherElectricalCheckPoints_textView_aviationLamp);
        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewAviationLampVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteOtherElectricalCheckPoints_textView_aviationLampVal);
        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInsideTheShelter = (TextView) findViewById(R.id.preventiveMaintenanceSiteOtherElectricalCheckPoints_textView_lightsInsideTheShelter);
        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInsideTheShelterVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteOtherElectricalCheckPoints_textView_lightsInsideTheShelterVal);
        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInSitePremisesOrBulkHead = (TextView) findViewById(R.id.preventiveMaintenanceSiteOtherElectricalCheckPoints_textView_lightsInSitePremisesOrBulkHead);
        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInSitePremisesOrBulkHeadVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteOtherElectricalCheckPoints_textView_lightsInSitePremisesOrBulkHeadVal);
    }

    private void initCombo() {

        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewDcEnergyMeterStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteOtherElectricalCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteOtherElectricalCheckPoints_dcEnergyMeterStatus))),
                        "DC Energy Meter status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_dcEnergyMeterStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewDcEnergyMeterStatusVal.setText(str_dcEnergyMeterStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewAviationLampVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteOtherElectricalCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteOtherElectricalCheckPoints_aviationLamp))),
                        "Aviation Lamp",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_aviationLampVal = item.get(position);
                        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewAviationLampVal.setText(str_aviationLampVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInsideTheShelterVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteOtherElectricalCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteOtherElectricalCheckPoints_lightsInsideTheShelter))),
                        "Lights Inside the Shelter",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_lightsInsideTheShelterVal = item.get(position);
                        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInsideTheShelterVal.setText(str_lightsInsideTheShelterVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInSitePremisesOrBulkHeadVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteOtherElectricalCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteOtherElectricalCheckPoints_lightsInSitePremisesOrBulkHead))),
                        "Lights in Site Premises/Bulk head",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_lightsInSitePremisesOrBulkHeadVal = item.get(position);
                        mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInSitePremisesOrBulkHeadVal.setText(str_lightsInSitePremisesOrBulkHeadVal);
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
                //startActivity(new Intent(this, Tower_Detail.class));
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

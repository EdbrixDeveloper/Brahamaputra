package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_shelter_check_points);
        this.setTitle("Shelter Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
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

package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;

public class PreventiveMaintenanceSiteOtherElectricalCheckPointsActivity extends BaseActivity {
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewDcEnergyMeterStatus;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewDcEnergyMeterStatusVal;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewAviationLamp;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewAviationLampVal;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInsideTheShelter;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInsideTheShelterVal;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInSitePremisesOrBulkHead;
    private TextView mPreventiveMaintenanceSiteOtherElectricalCheckPointsTextViewLightsInSitePremisesOrBulkHeadVal;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_other_electrical_check_points);
        this.setTitle("Other Electrical Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
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

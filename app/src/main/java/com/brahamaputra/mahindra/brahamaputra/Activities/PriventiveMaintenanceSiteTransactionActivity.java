package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.brahamaputra.mahindra.brahamaputra.R;

public class PriventiveMaintenanceSiteTransactionActivity extends AppCompatActivity {
    private EditText mPriventiveMaintenanceSiteTransEditTextCustomerName;
    private EditText mPriventiveMaintenanceSiteTransEditTextCircle;
    private EditText mPriventiveMaintenanceSiteTransEditTextState;
    private EditText mPriventiveMaintenanceSiteTransEditTextSsa;
    private EditText mPriventiveMaintenanceSiteTransEditTextNameOfSite;
    private EditText mPriventiveMaintenanceSiteTransEditTextSiteID;
    private EditText mPriventiveMaintenanceSiteTransEditTextSheduledDateOfPm;
    private EditText mPriventiveMaintenanceSiteTransEditTextActualPmExicutionDate;
    private Button mPriventiveMaintenanceSiteTransButtonSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priventive_maintenance_site_transaction);
    }
    private void assignViews() {
        mPriventiveMaintenanceSiteTransEditTextCustomerName = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_customerName);
        mPriventiveMaintenanceSiteTransEditTextCircle = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_circle);
        mPriventiveMaintenanceSiteTransEditTextState = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_state);
        mPriventiveMaintenanceSiteTransEditTextSsa = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_ssa);
        mPriventiveMaintenanceSiteTransEditTextNameOfSite = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_nameOfSite);
        mPriventiveMaintenanceSiteTransEditTextSiteID = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_siteID);
        mPriventiveMaintenanceSiteTransEditTextSheduledDateOfPm = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_sheduledDateOfPm);
        mPriventiveMaintenanceSiteTransEditTextActualPmExicutionDate = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_actualPmExicutionDate);
        mPriventiveMaintenanceSiteTransButtonSubmit = (Button) findViewById(R.id.priventiveMaintenanceSiteTrans_button_submit);
    }
}

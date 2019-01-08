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

import com.brahamaputra.mahindra.brahamaputra.R;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_Selected_CustomerName;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_Selected_SiteType;

public class PriventiveMaintenanceSiteTransactionActivity extends AppCompatActivity {
    private EditText mPriventiveMaintenanceSiteTransEditTextCustomerName;
    private EditText mPriventiveMaintenanceSiteTransEditTextCircle;
    private EditText mPriventiveMaintenanceSiteTransEditTextState;
    private EditText mPriventiveMaintenanceSiteTransEditTextSsa;
    private EditText mPriventiveMaintenanceSiteTransEditTextNameOfSite;
    private EditText mPriventiveMaintenanceSiteTransEditTextSiteID;
    private EditText mPriventiveMaintenanceSiteTransEditTextSheduledDateOfPm;
    private EditText mPriventiveMaintenanceSiteTransEditTextActualPmExecutionDate;
    private Button mPriventiveMaintenanceSiteTransButtonSubmit;
    public static final int RESULT_PRIVENTIVE_MAINTENANCE_SITE_READING = 258;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priventive_maintenance_site_transaction);
        assignViews();
        this.setTitle("Priventive Maintenance Site Transaction");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPriventiveMaintenanceSiteTransButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PriventiveMaintenanceSiteTransactionActivity.this, SitePreventiveMaintenanceSectionsListActivity.class);
                //intent.putExtra("ticketName", "");

                startActivityForResult(intent, RESULT_PRIVENTIVE_MAINTENANCE_SITE_READING);

            }
        });

    }

    private void assignViews() {
        mPriventiveMaintenanceSiteTransEditTextCustomerName = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_customerName);
        mPriventiveMaintenanceSiteTransEditTextCircle = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_circle);
        mPriventiveMaintenanceSiteTransEditTextState = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_state);
        mPriventiveMaintenanceSiteTransEditTextSsa = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_ssa);
        mPriventiveMaintenanceSiteTransEditTextNameOfSite = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_nameOfSite);
        mPriventiveMaintenanceSiteTransEditTextSiteID = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_siteID);
        mPriventiveMaintenanceSiteTransEditTextSheduledDateOfPm = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_sheduledDateOfPm);
        mPriventiveMaintenanceSiteTransEditTextActualPmExecutionDate = (EditText) findViewById(R.id.priventiveMaintenanceSiteTrans_editText_actualPmExecutionDate);
        mPriventiveMaintenanceSiteTransButtonSubmit = (Button) findViewById(R.id.priventiveMaintenanceSiteTrans_button_submit);
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
                onBackPressed();
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

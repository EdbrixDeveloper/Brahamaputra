package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;

public class PreventiveMaintanceAcFieldEngineerActivity extends AppCompatActivity {
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewCustomer;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewCustomerVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewCircle;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewCircleVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewState;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewStateVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewSsa;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewSsaVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewSiteName;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewSiteNameVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewSiteID;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewSiteIDVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewPmSheduledDateOfAc;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewPmSheduledDateOfAcVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewModeOfOpration;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewModeOfOprationVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewTicketNo;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewTicketNoVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewVendorName;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewVendorNameVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianName;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianNameVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianMobNo;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianMobNoVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewTicketStatusToWip;
    private CheckBox mPreventiveMaintanceAcFieldEngineerCheckBoxTicketStatusToWipVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewStatusSubmittedByTechnician;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewStatusSubmittedByTechnicianVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewDateSubmittedByTechnician;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewDateSubmittedByTechnicianVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewFeedBack;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewFeedBackVal;
    private TextView mPreventiveMaintanceAcFieldEngineerTextViewRemark;
    private EditText mPreventiveMaintanceAcFieldEngineerEditTextRemark;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintance_ac_field_engineer);
        assignViews();
    }
    private void assignViews() {
        mPreventiveMaintanceAcFieldEngineerTextViewCustomer = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_customer);
        mPreventiveMaintanceAcFieldEngineerTextViewCustomerVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_customerVal);
        mPreventiveMaintanceAcFieldEngineerTextViewCircle = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_circle);
        mPreventiveMaintanceAcFieldEngineerTextViewCircleVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_circleVal);
        mPreventiveMaintanceAcFieldEngineerTextViewState = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_state);
        mPreventiveMaintanceAcFieldEngineerTextViewStateVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_stateVal);
        mPreventiveMaintanceAcFieldEngineerTextViewSsa = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_ssa);
        mPreventiveMaintanceAcFieldEngineerTextViewSsaVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_ssaVal);
        mPreventiveMaintanceAcFieldEngineerTextViewSiteName = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_siteName);
        mPreventiveMaintanceAcFieldEngineerTextViewSiteNameVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_siteNameVal);
        mPreventiveMaintanceAcFieldEngineerTextViewSiteID = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_siteID);
        mPreventiveMaintanceAcFieldEngineerTextViewSiteIDVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_siteIDVal);
        mPreventiveMaintanceAcFieldEngineerTextViewPmSheduledDateOfAc = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_pmSheduledDateOfAc);
        mPreventiveMaintanceAcFieldEngineerTextViewPmSheduledDateOfAcVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_pmSheduledDateOfAcVal);
        mPreventiveMaintanceAcFieldEngineerTextViewModeOfOpration = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_modeOfOpration);
        mPreventiveMaintanceAcFieldEngineerTextViewModeOfOprationVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_modeOfOprationVal);
        mPreventiveMaintanceAcFieldEngineerTextViewTicketNo = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_ticketNo);
        mPreventiveMaintanceAcFieldEngineerTextViewTicketNoVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_ticketNoVal);
        mPreventiveMaintanceAcFieldEngineerTextViewVendorName = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_vendorName);
        mPreventiveMaintanceAcFieldEngineerTextViewVendorNameVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_vendorNameVal);
        mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianName = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_acTechnicianName);
        mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianNameVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_acTechnicianNameVal);
        mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianMobNo = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_acTechnicianMobNo);
        mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianMobNoVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_acTechnicianMobNoVal);
        mPreventiveMaintanceAcFieldEngineerTextViewTicketStatusToWip = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_ticketStatusToWip);
        mPreventiveMaintanceAcFieldEngineerCheckBoxTicketStatusToWipVal = (CheckBox) findViewById(R.id.preventiveMaintanceAcFieldEngineer_checkBox_ticketStatusToWipVal);
        mPreventiveMaintanceAcFieldEngineerTextViewStatusSubmittedByTechnician = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_statusSubmittedByTechnician);
        mPreventiveMaintanceAcFieldEngineerTextViewStatusSubmittedByTechnicianVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_statusSubmittedByTechnicianVal);
        mPreventiveMaintanceAcFieldEngineerTextViewDateSubmittedByTechnician = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_dateSubmittedByTechnician);
        mPreventiveMaintanceAcFieldEngineerTextViewDateSubmittedByTechnicianVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_dateSubmittedByTechnicianVal);
        mPreventiveMaintanceAcFieldEngineerTextViewFeedBack = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_feedBack);
        mPreventiveMaintanceAcFieldEngineerTextViewFeedBackVal = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_feedBackVal);
        mPreventiveMaintanceAcFieldEngineerTextViewRemark = (TextView) findViewById(R.id.preventiveMaintanceAcFieldEngineer_textView_remark);
        mPreventiveMaintanceAcFieldEngineerEditTextRemark = (EditText) findViewById(R.id.preventiveMaintanceAcFieldEngineer_editText_remark);
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
}

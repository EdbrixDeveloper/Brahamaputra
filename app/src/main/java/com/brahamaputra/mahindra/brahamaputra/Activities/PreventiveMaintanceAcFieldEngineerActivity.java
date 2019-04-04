package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.AcPreventiveMaintanceProcessParentDatum;
import com.brahamaputra.mahindra.brahamaputra.Data.TicktetSubmissionFromFieldEngineerDatum;
import com.brahamaputra.mahindra.brahamaputra.Data.UserLoginResponseData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.Volley.SettingsMy;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class PreventiveMaintanceAcFieldEngineerActivity extends BaseActivity {
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
    private LinearLayout mLinearLayoutParent;

    private String userId = "1112";
    private String ticketId = "1112";
    private String ticketName = "1112";

    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;
    String flag = "";

    String str_feedBackVal;
    TicktetSubmissionFromFieldEngineerDatum ticktetSubmissionFromFieldEngineerDatum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintance_ac_field_engineer);
        setTitle("Ticket Submission from Field Engineer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        flag = intent.getStringExtra("status");

        sessionManager = new SessionManager(PreventiveMaintanceAcFieldEngineerActivity.this);
        //ticketId = sessionManager.getSessionUserTicketId();
        //ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintanceAcFieldEngineerActivity.this, userId, ticketName);

        ticktetSubmissionFromFieldEngineerDatum = new TicktetSubmissionFromFieldEngineerDatum();
        assignViews();
        initCombo();
        setInputDetails();

        setDataToFields(intent);
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
        mLinearLayoutParent = (LinearLayout) findViewById(R.id.LinearLayoutParent);

        if (flag.equals("Submitted by Technician")) {
            mLinearLayoutParent.setVisibility(View.VISIBLE);
        }

    }

    private void initCombo() {
        mPreventiveMaintanceAcFieldEngineerTextViewFeedBackVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintanceAcFieldEngineerActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmAcFieldEngineer_feedBack))),
                        "Feed Back",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_feedBackVal = item.get(position);
                        mPreventiveMaintanceAcFieldEngineerTextViewFeedBackVal.setText(str_feedBackVal);
                    }
                });
            }
        });

        mPreventiveMaintanceAcFieldEngineerCheckBoxTicketStatusToWipVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(PreventiveMaintanceAcFieldEngineerActivity.this,AcPreventiveMaintenanceDashboardActivity.class);
                    intent.putExtra("returnValue","WIP");
                    startActivity(intent);
                    finish();
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
                submitDetails();
                //startActivity(new Intent(this, Tower_Detail.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        /*Intent i = new Intent();
        i.putExtra("returnValue","WIP");*/
        setResult(RESULT_OK);
        finish();
    }

    public boolean checkValidationOfArrayFields() {

        String feedBack = mPreventiveMaintanceAcFieldEngineerTextViewFeedBackVal.getText().toString().trim();
        String remark = mPreventiveMaintanceAcFieldEngineerEditTextRemark.getText().toString().trim();

        if (feedBack.isEmpty() || feedBack == null) {
            showToast("Select Feedback");
            return false;
        } else if (remark.isEmpty() || remark == null) {
            showToast("Enter remark For Technician");
            return false;
        } else return true;
    }

    private void setInputDetails() {

        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");

                Gson gson = new Gson();
                ticktetSubmissionFromFieldEngineerDatum = gson.fromJson(jsonInString, TicktetSubmissionFromFieldEngineerDatum.class);

                mPreventiveMaintanceAcFieldEngineerTextViewCustomerVal.setText(ticktetSubmissionFromFieldEngineerDatum.getCustomer());
                mPreventiveMaintanceAcFieldEngineerTextViewCircleVal.setText(ticktetSubmissionFromFieldEngineerDatum.getCircle());
                mPreventiveMaintanceAcFieldEngineerTextViewStateVal.setText(ticktetSubmissionFromFieldEngineerDatum.getState());
                mPreventiveMaintanceAcFieldEngineerTextViewSsaVal.setText(ticktetSubmissionFromFieldEngineerDatum.getSsa());
                mPreventiveMaintanceAcFieldEngineerTextViewSiteIDVal.setText(ticktetSubmissionFromFieldEngineerDatum.getSiteId());
                mPreventiveMaintanceAcFieldEngineerTextViewSiteNameVal.setText(ticktetSubmissionFromFieldEngineerDatum.getSiteName());
                mPreventiveMaintanceAcFieldEngineerTextViewPmSheduledDateOfAcVal.setText(ticktetSubmissionFromFieldEngineerDatum.getSheduledDateOfAcPm());
                mPreventiveMaintanceAcFieldEngineerTextViewModeOfOprationVal.setText(ticktetSubmissionFromFieldEngineerDatum.getModeOfOpration());
                mPreventiveMaintanceAcFieldEngineerTextViewTicketNoVal.setText(ticktetSubmissionFromFieldEngineerDatum.getTicketNo());
                mPreventiveMaintanceAcFieldEngineerTextViewVendorNameVal.setText(ticktetSubmissionFromFieldEngineerDatum.getVendorName());
                mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianNameVal.setText(ticktetSubmissionFromFieldEngineerDatum.getAcTechnicianName());
                mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianMobNoVal.setText(ticktetSubmissionFromFieldEngineerDatum.getAcTechnicianMobileNo());

                if (ticktetSubmissionFromFieldEngineerDatum.getTicketStatusToWip().equals("true")) {
                    mPreventiveMaintanceAcFieldEngineerCheckBoxTicketStatusToWipVal.setChecked(true);
                } else {
                    mPreventiveMaintanceAcFieldEngineerCheckBoxTicketStatusToWipVal.setChecked(false);
                }
                mPreventiveMaintanceAcFieldEngineerTextViewStatusSubmittedByTechnicianVal.setText(ticktetSubmissionFromFieldEngineerDatum.getStatus());
                mPreventiveMaintanceAcFieldEngineerTextViewDateSubmittedByTechnicianVal.setText(ticktetSubmissionFromFieldEngineerDatum.getSubmittedDate());
                mPreventiveMaintanceAcFieldEngineerTextViewFeedBackVal.setText(ticktetSubmissionFromFieldEngineerDatum.getFeedBack());
                mPreventiveMaintanceAcFieldEngineerEditTextRemark.setText(ticktetSubmissionFromFieldEngineerDatum.getRemark());


            }
        } catch (Exception e) {

        }

    }

    public void setDataToFields(Intent intent) {
        mPreventiveMaintanceAcFieldEngineerTextViewCustomerVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewCircleVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewStateVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewSsaVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewSiteNameVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewSiteIDVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewPmSheduledDateOfAcVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewModeOfOprationVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewTicketNoVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewVendorNameVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianNameVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianMobNoVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewStatusSubmittedByTechnicianVal.setText(intent.getStringExtra(""));
        mPreventiveMaintanceAcFieldEngineerTextViewDateSubmittedByTechnicianVal.setText(intent.getStringExtra(""));
    }

    private void submitDetails() {

        try {
            String customer = mPreventiveMaintanceAcFieldEngineerTextViewCustomerVal.getText().toString().trim();
            String circle = mPreventiveMaintanceAcFieldEngineerTextViewCircleVal.getText().toString().trim();
            String state = mPreventiveMaintanceAcFieldEngineerTextViewStateVal.getText().toString().trim();
            String ssa = mPreventiveMaintanceAcFieldEngineerTextViewSsaVal.getText().toString().trim();
            String siteId = mPreventiveMaintanceAcFieldEngineerTextViewSiteIDVal.getText().toString().trim();
            String siteName = mPreventiveMaintanceAcFieldEngineerTextViewSiteNameVal.getText().toString().trim();
            String sheduledDateOfAcPm = mPreventiveMaintanceAcFieldEngineerTextViewPmSheduledDateOfAcVal.getText().toString().trim();
            String modeOfOpration = mPreventiveMaintanceAcFieldEngineerTextViewModeOfOprationVal.getText().toString().trim();
            String ticketNo = mPreventiveMaintanceAcFieldEngineerTextViewTicketNoVal.getText().toString().trim();
            String vendorName = mPreventiveMaintanceAcFieldEngineerTextViewVendorNameVal.getText().toString().trim();
            String technicianName = mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianNameVal.getText().toString().trim();
            String technicianMobileNo = mPreventiveMaintanceAcFieldEngineerTextViewAcTechnicianMobNoVal.getText().toString().trim();
            String ticketStatusToWip = "";
            if (mPreventiveMaintanceAcFieldEngineerCheckBoxTicketStatusToWipVal.isChecked()) {
                ticketStatusToWip = "true";
            } else {
                ticketStatusToWip = "false";
            }
            String status = mPreventiveMaintanceAcFieldEngineerTextViewStatusSubmittedByTechnicianVal.getText().toString().trim();
            String submittedDate = mPreventiveMaintanceAcFieldEngineerTextViewDateSubmittedByTechnicianVal.getText().toString().trim();
            String feedback = mPreventiveMaintanceAcFieldEngineerTextViewFeedBackVal.getText().toString().trim();
            String remark = mPreventiveMaintanceAcFieldEngineerEditTextRemark.getText().toString().trim();

            ticktetSubmissionFromFieldEngineerDatum = new TicktetSubmissionFromFieldEngineerDatum(customer, circle, state, ssa, siteId, siteName,
                    sheduledDateOfAcPm, modeOfOpration, ticketNo, vendorName, technicianName, technicianMobileNo, ticketStatusToWip, status, submittedDate,
                    feedback, remark);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(ticktetSubmissionFromFieldEngineerDatum);
            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        mPreventiveMaintanceAcFieldEngineerTextViewFeedBackVal.setText("");
        mPreventiveMaintanceAcFieldEngineerEditTextRemark.setText("");
        mPreventiveMaintanceAcFieldEngineerCheckBoxTicketStatusToWipVal.setChecked(false);
    }

    public void submitFieldEngineerAcPmSiteTicket() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt")) {

                showBusyProgress();
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt");
                Log.e("123", jsonInString);

                GsonRequest<TicktetSubmissionFromFieldEngineerDatum> submitSitePmAcTicketRequest = new GsonRequest<>(Request.Method.POST, Constants.submitSitePMTicket, jsonInString, TicktetSubmissionFromFieldEngineerDatum.class,
                        new Response.Listener<TicktetSubmissionFromFieldEngineerDatum>() {
                            @Override
                            public void onResponse(@NonNull TicktetSubmissionFromFieldEngineerDatum response) {
                                hideBusyProgress();
                                if (response.getError() != null) {
                                    showToast(response.getError().getErrorMessage());
                                } else {
                                    if (response.getSuccess() == 1) {
                                        showToast("Ticket submitted successfully.");
                                        sessionManager.updateSessionUserTicketId(null);
                                        sessionManager.updateSessionUserTicketName(null);
                                        setResult(RESULT_OK);
                                        removeOfflineCache();
                                        finish();
                                    }
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        hideBusyProgress();
                        showToast(SettingsMy.getErrorMessage(error));
                    }
                });

                submitSitePmAcTicketRequest.setRetryPolicy(Application.getDefaultRetryPolice());
                submitSitePmAcTicketRequest.setShouldCache(false);
                Application.getInstance().addToRequestQueue(submitSitePmAcTicketRequest, "submitSitePmTicketRequest");
            }
        } catch (Exception e) {

        }
    }

    private void removeOfflineCache() {
        if (offlineStorageWrapper.checkOfflineFileIsAvailable(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt")) {
            offlineStorageWrapper.removedOffLineFile(GlobalMethods.replaceAllSpecialCharAtUnderscore(ticketName) + ".txt");
        }
    }

}

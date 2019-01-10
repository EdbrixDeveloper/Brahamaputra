package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import java.util.ArrayList;
import java.util.Arrays;

public class PreventiveMaintenanceSiteRectifierModuleCheckPointActivity extends BaseActivity {
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfRectifierModuleAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfRectifierModuleAvailableAtSiteVal;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfModulesWorking;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfModulesWorkingVal;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfFaultyModulesInSite;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfFaultyModulesInSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierModuleNumber;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewDetailsOfRectifierModuleQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonDetailsOfRectifierModuleQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonDetailsOfRectifierModuleQRCodeScanView;
    private ImageView mButtonClearDetailsOfRectifierModuleQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierCleaning;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierCleaningVal;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierPhotoBeforeCleaning;
    private ImageView mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoBeforeCleaning;
    private ImageView mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoBeforeCleaningView;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierPhotoAfterCleaning;
    private ImageView mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoAfterCleaning;
    private ImageView mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoAfterCleaningView;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonNextReading;


    String str_noOfRectifierModuleAvailableAtSiteVal;
    String str_noOfModulesWorkingVal;
    String str_noOfFaultyModulesInSiteVal;
    String str_rectifierCleaningVal;
    String str_registerFaultVal;
    String str_typeOfFaultVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_rectifier_module_check_point);
        this.setTitle("Rectifier Module Check Point");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();
    }

    private void initCombo() {

        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfRectifierModuleAvailableAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteRectifierModuleCheckPoints_noOfRectifierModuleAvailableAtSite))),
                        "No of Rectifier Module available at site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfRectifierModuleAvailableAtSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfRectifierModuleAvailableAtSiteVal.setText(str_noOfRectifierModuleAvailableAtSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfModulesWorkingVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteRectifierModuleCheckPoints_noOfModulesWorking))),
                        "No of Modules Working",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfModulesWorkingVal = item.get(position);
                        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfModulesWorkingVal.setText(str_noOfModulesWorkingVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfFaultyModulesInSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Hiiiii");
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteRectifierModuleCheckPoints_noOfFaultyModulesInSite))),
                        "No of Faulty Modules in Site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfFaultyModulesInSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfFaultyModulesInSiteVal.setText(str_noOfFaultyModulesInSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierCleaningVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteRectifierModuleCheckPoints_rectifierCleaning))),
                        "Rectifier Cleaning",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_rectifierCleaningVal = item.get(position);
                        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierCleaningVal.setText(str_rectifierCleaningVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteRectifierModuleCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_registerFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRegisterFaultVal.setText(str_registerFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteRectifierModuleCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewTypeOfFaultVal.setText(str_typeOfFaultVal);
                    }
                });
            }
        });
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfRectifierModuleAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_noOfRectifierModuleAvailableAtSite);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfRectifierModuleAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_noOfRectifierModuleAvailableAtSiteVal);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfModulesWorking = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_noOfModulesWorking);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfModulesWorkingVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_noOfModulesWorkingVal);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfFaultyModulesInSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_noOfFaultyModulesInSite);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewNoOfFaultyModulesInSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_noOfFaultyModulesInSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierModuleNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_rectifierModuleNumber);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewDetailsOfRectifierModuleQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_detailsOfRectifierModuleQRCodeScan);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonDetailsOfRectifierModuleQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_detailsOfRectifierModuleQRCodeScan);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonDetailsOfRectifierModuleQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_detailsOfRectifierModuleQRCodeScanView);
        mButtonClearDetailsOfRectifierModuleQRCodeScanView = (ImageView) findViewById(R.id.button_ClearDetailsOfRectifierModuleQRCodeScanView);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_rectifierCleaning);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierCleaningVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_rectifierCleaningVal);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierPhotoBeforeCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_rectifierPhotoBeforeCleaning);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoBeforeCleaning = (ImageView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_rectifierPhotoBeforeCleaning);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoBeforeCleaningView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_rectifierPhotoBeforeCleaningView);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRectifierPhotoAfterCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_rectifierPhotoAfterCleaning);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoAfterCleaning = (ImageView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_rectifierPhotoAfterCleaning);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonRectifierPhotoAfterCleaningView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_rectifierPhotoAfterCleaningView);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_registerFault);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_registerFaultVal);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_typeOfFault);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_previousReading);
        mPreventiveMaintenanceSiteRectifierModuleCheckPointButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteRectifierModuleCheckPoint_button_nextReading);

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
                startActivity(new Intent(this, PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.class));
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

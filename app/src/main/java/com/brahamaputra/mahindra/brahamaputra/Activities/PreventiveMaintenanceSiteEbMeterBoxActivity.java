package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import java.util.ArrayList;
import java.util.Arrays;

public class PreventiveMaintenanceSiteEbMeterBoxActivity extends BaseActivity {

    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterBoxCondition;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterBoxConditionVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterWorkingStatus;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterWorkingStatusVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewKitKatClayFuseStatus;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewKitKatClayFuseStatusVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewSfuMccbStatus;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewSfuMccbStatusVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewHrcFuseStatus;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewHrcFuseStatusVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewAcLoadAmpPh;
    private EditText mPreventiveMaintenanceSiteEbMeterBoxEditTextAcLoadAmpPhRPhase;
    private EditText mPreventiveMaintenanceSiteEbMeterBoxEditTextAcLoadAmpPhYPhase;
    private EditText mPreventiveMaintenanceSiteEbMeterBoxEditTextAcLoadAmpPhBPhase;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterReadingKwh;
    private EditText mPreventiveMaintenanceSiteEbMeterBoxEditTextEbMeterReadingKwh;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbServiceWireCondition;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbServiceWireConditionVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewTypeOfFaultVal;

    String str_pmSiteEbmbEBMeterBoxConditionVal = "";
    String str_pmSiteEbmbEBMeterWorkingStatusVal = "";
    String str_pmSiteEbmbKitkatOrClayFuseStatusVal = "";
    String str_pmSiteEbmbSfuOrMccbStatusVal = "";
    String str_pmSiteEbmbHRCFuseStatusVal = "";
    String str_pmSiteEbmbEBServiceWireConditionVal = "";
    String str_pmSiteEbmbRegisterFaultVal = "";
    String str_pmSiteEbmbTypeOfFaultVal = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_eb_meter_box);
        setTitle("EB Meter Box");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();
    }

    private void initCombo() {
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterBoxConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEbMeterBoxActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEbMeterBox_ebMeterBoxCondition))),
                        "EB Meter Box Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEbmbEBMeterBoxConditionVal = item.get(position);
                        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterBoxConditionVal.setText(str_pmSiteEbmbEBMeterBoxConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterWorkingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEbMeterBoxActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEbMeterBox_ebMeterBoxWorkingStatus))),
                        "EB Meter Working Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEbmbEBMeterWorkingStatusVal= item.get(position);
                        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterWorkingStatusVal.setText(str_pmSiteEbmbEBMeterWorkingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEbMeterBoxTextViewKitKatClayFuseStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEbMeterBoxActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEbMeterBox_kitkatOrClayFuseStatus))),
                        "KITKAT/Clay Fuse Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEbmbKitkatOrClayFuseStatusVal= item.get(position);
                        mPreventiveMaintenanceSiteEbMeterBoxTextViewKitKatClayFuseStatusVal.setText(str_pmSiteEbmbKitkatOrClayFuseStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEbMeterBoxTextViewSfuMccbStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEbMeterBoxActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEbMeterBox_sfuOrMccbStatus))),
                        "SFU/MCCB Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEbmbSfuOrMccbStatusVal= item.get(position);
                        mPreventiveMaintenanceSiteEbMeterBoxTextViewSfuMccbStatusVal.setText(str_pmSiteEbmbSfuOrMccbStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEbMeterBoxTextViewHrcFuseStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEbMeterBoxActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEbMeterBox_hrcFuseStatus))),
                        "HRC Fuse Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEbmbHRCFuseStatusVal= item.get(position);
                        mPreventiveMaintenanceSiteEbMeterBoxTextViewHrcFuseStatusVal.setText(str_pmSiteEbmbHRCFuseStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbServiceWireConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEbMeterBoxActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEbMeterBox_ebServiceWireCondition))),
                        "EB Service Wire Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEbmbEBServiceWireConditionVal= item.get(position);
                        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbServiceWireConditionVal.setText(str_pmSiteEbmbEBServiceWireConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEbMeterBoxTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEbMeterBoxActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEbMeterBox_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEbmbRegisterFaultVal= item.get(position);
                        mPreventiveMaintenanceSiteEbMeterBoxTextViewRegisterFaultVal.setText(str_pmSiteEbmbRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEbMeterBoxTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEbMeterBoxActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEbMeterBox_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEbmbTypeOfFaultVal= item.get(position);
                        mPreventiveMaintenanceSiteEbMeterBoxTextViewTypeOfFaultVal.setText(str_pmSiteEbmbTypeOfFaultVal);
                    }
                });
            }
        });
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterBoxCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebMeterBoxCondition);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterBoxConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebMeterBoxConditionVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterWorkingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebMeterWorkingStatus);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterWorkingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebMeterWorkingStatusVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewKitKatClayFuseStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_KitKatClayFuseStatus);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewKitKatClayFuseStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_KitKatClayFuseStatusVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewSfuMccbStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_SfuMccbStatus);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewSfuMccbStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_SfuMccbStatusVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewHrcFuseStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_HrcFuseStatus);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewHrcFuseStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_HrcFuseStatusVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewAcLoadAmpPh = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_acLoadAmpPh);
        mPreventiveMaintenanceSiteEbMeterBoxEditTextAcLoadAmpPhRPhase = (EditText) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_editText_acLoadAmpPh_rPhase);
        mPreventiveMaintenanceSiteEbMeterBoxEditTextAcLoadAmpPhYPhase = (EditText) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_editText_acLoadAmpPh_yPhase);
        mPreventiveMaintenanceSiteEbMeterBoxEditTextAcLoadAmpPhBPhase = (EditText) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_editText_acLoadAmpPh_bPhase);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterReadingKwh = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebMeterReadingKwh);
        mPreventiveMaintenanceSiteEbMeterBoxEditTextEbMeterReadingKwh = (EditText) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_editText_ebMeterReadingKwh);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbServiceWireCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebServiceWireCondition);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbServiceWireConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebServiceWireConditionVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_registerFault);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_registerFaultVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_typeOfFault);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_typeOfFaultVal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.submit_icon_menu, menu);

        MenuItem shareItem = menu.findItem(R.id.menuSubmit);

        // show the button when some condition is true
        shareItem.setVisible(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuSubmit:
                startActivity(new Intent(this, PreventiveMaintenanceSiteDgCheckPointsActivity.class));
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

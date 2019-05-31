package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.app.progresviews.ProgressWheel;
import com.brahamaputra.mahindra.brahamaputra.Adapters.PmAcReportExpListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.AcPMReportListData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.GPSTracker;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmReportType;

public class PreventiveMaintenanceAcReportDashboardActivity extends BaseActivity {

    private LinearLayout mPreventiveMaintenanceAcReportLinearLayoutFiltersMonthYear;
    private TextView mPreventiveMaintenanceAcReportTextViewFiltersMonth;
    private TextView mPreventiveMaintenanceAcReportTextViewFiltersYear;
    private Button mPreventiveMaintenanceAcReportButtonFiltersMonthYear;
    private LinearLayout mLinearLayoutStatus;
    private ProgressWheel mWheelprogress;
    private LinearLayout mLinearLayoutContainer1;
    private TextView mAcPreventiveMaintenanceSectionTextViewDoneSites;
    private TextView mAcPreventiveMaintenanceSectionTextViewNo;
    private LinearLayout mLinearLayoutContainer2;
    private TextView mAcPreventiveMaintenanceSectionTextViewPendingSites;
    private TextView mAcPreventiveMaintenanceSectionTextViewNo2;
    private LinearLayout mLinearLayoutContainer3;
    private TextView mPreventiveMaintenanceAcReportTextViewTotalSitePm1;
    private TextView mPreventiveMaintenanceAcReportTextViewTotalSitePm2;
    private LinearLayout mLinearLayoutTitleNames;
    private TextView mTextViewAcPmReportTitle;
    private ExpandableListView mPmAcListListViewSiteList;
    private TextView mTxtNoTicketFound;
    private LinearLayout mPmSiteDashboardLinearLayoutTicket1;
    private TextView mTextViewHotoName;
    private TextView mTextViewReportSiteId;
    private TextView mTextViewReportSiteSSA;
    private TextView mTextViewReportLastTicketNo;
    private TextView mTextViewReportLastDoneDate;
    private TextView mTextViewReportNextDueDate;
    private LinearLayout mPmSiteDashboardLinearLayoutTicket2;
    private TextView mTextViewHotoName1;
    private TextView mTextViewReportSiteId1;
    private TextView mTextViewReportSiteSSA1;
    private TextView mTextViewReportLastTicketNo1;
    private TextView mTextViewReportLastDoneDate1;
    private TextView mTextViewReportNextDueDate1;

    private ArrayList<String> monthNames;
    private AcPMReportListData acPMReportListData;

    String str_pmAcMonthVal = "";
    String str_pmAcYearVal = "";

    private SessionManager sessionManager;
    public GPSTracker gpsTracker;

    PmAcReportExpListAdapter pmAcReportExpListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_ac_report_dashboard);
        this.setTitle("AC PM Report");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        monthNames = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteReportDashboard_monthName)));

        assignViews();
        initCombo();

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        mPreventiveMaintenanceAcReportTextViewFiltersMonth.setText(monthNames.get(month));
        mPreventiveMaintenanceAcReportTextViewFiltersYear.setText(String.valueOf(year));


        acPMReportListData = new AcPMReportListData();
        mWheelprogress = (ProgressWheel) findViewById(R.id.wheelprogress);
        mPmAcListListViewSiteList = (ExpandableListView) findViewById(R.id.pmAcList_listView_siteList);
        mAcPreventiveMaintenanceSectionTextViewDoneSites = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_doneSites);
        mAcPreventiveMaintenanceSectionTextViewPendingSites = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_pendingSites);
        mPreventiveMaintenanceAcReportTextViewTotalSitePm1 = (TextView) findViewById(R.id.preventiveMaintenanceAcReport_textView_totalSitePm1);
        mTxtNoTicketFound = (TextView) findViewById(R.id.txtNoTicketFound);
        mTxtNoTicketFound.setVisibility(View.GONE);
        mLinearLayoutTitleNames = (LinearLayout) findViewById(R.id.linearLayout_titleNames);
        mTextViewAcPmReportTitle = (TextView) findViewById(R.id.textView_acPmReportTitle);

        sessionManager = new SessionManager(PreventiveMaintenanceAcReportDashboardActivity.this);
        gpsTracker = new GPSTracker(PreventiveMaintenanceAcReportDashboardActivity.this);
        if (gpsTracker.canGetLocation()) {
            Log.e(PreventiveMaintenanceSiteReportDashboard.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
        }

        prepareSitePmReportListData();

        //default calling first time
        mLinearLayoutTitleNames.setVisibility(View.VISIBLE);
        mTextViewAcPmReportTitle.setText("Current Month Plan");
        prepareListDataOnChangedAndSelection("4");

        mPreventiveMaintenanceAcReportButtonFiltersMonthYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mLinearLayoutTitleNames.setVisibility(View.GONE);
                mTextViewAcPmReportTitle.setText("Title");
                prepareSitePmReportListData();

                ///////////////
                mLinearLayoutTitleNames.setVisibility(View.VISIBLE);
                mTextViewAcPmReportTitle.setText("Current Month Plan");
                prepareListDataOnChangedAndSelection("4");
            }
        });

        mWheelprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayoutTitleNames.setVisibility(View.VISIBLE);
                mTextViewAcPmReportTitle.setText("Total Sites");
                sitePmReportType = "1";
                prepareListDataOnChangedAndSelection("1");
            }
        });

        mLinearLayoutContainer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayoutTitleNames.setVisibility(View.VISIBLE);
                mTextViewAcPmReportTitle.setText("Done");
                sitePmReportType = "2";
                prepareListDataOnChangedAndSelection("2");
            }
        });

        mLinearLayoutContainer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayoutTitleNames.setVisibility(View.VISIBLE);
                mTextViewAcPmReportTitle.setText("Pending");
                sitePmReportType = "3";
                prepareListDataOnChangedAndSelection("3");
            }
        });

        mLinearLayoutContainer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayoutTitleNames.setVisibility(View.VISIBLE);
                mTextViewAcPmReportTitle.setText("Current Month Plan");
                sitePmReportType = "4";
                prepareListDataOnChangedAndSelection("4");
            }
        });

        mPmAcListListViewSiteList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                mPmAcListListViewSiteList.expandGroup(groupPosition);
                return true;
            }
        });

        /*mPmAcListListViewSiteList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, final int childPosition, long id) {

                return false;
            }
        });*/
    }

    private void initCombo() {

        mPreventiveMaintenanceAcReportTextViewFiltersMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcReportDashboardActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteReportDashboard_monthName))),
                        "Select Month",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmAcMonthVal = item.get(position);
                        mPreventiveMaintenanceAcReportTextViewFiltersMonth.setText(str_pmAcMonthVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceAcReportTextViewFiltersYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceAcReportDashboardActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteReportDashboard_yearName))),
                        "Select Year",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmAcYearVal = item.get(position);
                        mPreventiveMaintenanceAcReportTextViewFiltersYear.setText(str_pmAcYearVal);
                    }
                });
            }
        });
    }

    private void assignViews() {
        mPreventiveMaintenanceAcReportLinearLayoutFiltersMonthYear = (LinearLayout) findViewById(R.id.preventiveMaintenanceAcReport_linearLayout_filtersMonthYear);
        mPreventiveMaintenanceAcReportTextViewFiltersMonth = (TextView) findViewById(R.id.preventiveMaintenanceAcReport_textView_filtersMonth);
        mPreventiveMaintenanceAcReportTextViewFiltersYear = (TextView) findViewById(R.id.preventiveMaintenanceAcReport_textView_filtersYear);
        mPreventiveMaintenanceAcReportButtonFiltersMonthYear = (Button) findViewById(R.id.preventiveMaintenanceAcReport_Button_filtersMonthYear);
        mLinearLayoutStatus = (LinearLayout) findViewById(R.id.linearLayout_Status);
        mLinearLayoutContainer1 = (LinearLayout) findViewById(R.id.linearLayout_container1);
        mAcPreventiveMaintenanceSectionTextViewNo = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_no);
        mLinearLayoutContainer2 = (LinearLayout) findViewById(R.id.linearLayout_container2);
        mAcPreventiveMaintenanceSectionTextViewNo2 = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_no2);
        mLinearLayoutContainer3 = (LinearLayout) findViewById(R.id.linearLayout_container3);
        mPreventiveMaintenanceAcReportTextViewTotalSitePm2 = (TextView) findViewById(R.id.preventiveMaintenanceAcReport_textView_totalSitePm2);
        mPmSiteDashboardLinearLayoutTicket1 = (LinearLayout) findViewById(R.id.pmSiteDashboard_linearLayout_ticket1);
        mTextViewHotoName = (TextView) findViewById(R.id.textView_HotoName);
        mTextViewReportSiteId = (TextView) findViewById(R.id.textView_reportSiteId);
        mTextViewReportSiteSSA = (TextView) findViewById(R.id.textView_reportSiteSSA);
        mTextViewReportLastTicketNo = (TextView) findViewById(R.id.textView_reportLastTicketNo);
        mTextViewReportLastDoneDate = (TextView) findViewById(R.id.textView_reportLastDoneDate);
        mTextViewReportNextDueDate = (TextView) findViewById(R.id.textView_reportNextDueDate);
        mPmSiteDashboardLinearLayoutTicket2 = (LinearLayout) findViewById(R.id.pmSiteDashboard_linearLayout_ticket2);
        mTextViewHotoName1 = (TextView) findViewById(R.id.textView_HotoName1);
        mTextViewReportSiteId1 = (TextView) findViewById(R.id.textView_reportSiteId1);
        mTextViewReportSiteSSA1 = (TextView) findViewById(R.id.textView_reportSiteSSA1);
        mTextViewReportLastTicketNo1 = (TextView) findViewById(R.id.textView_reportLastTicketNo1);
        mTextViewReportLastDoneDate1 = (TextView) findViewById(R.id.textView_reportLastDoneDate1);
        mTextViewReportNextDueDate1 = (TextView) findViewById(R.id.textView_reportNextDueDate1);
        mTxtNoTicketFound = (TextView) findViewById(R.id.txtNoTicketFound);
    }

    private void prepareSitePmReportListData() {

        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();

            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("UserTypeId", sessionManager.getSessionUserTypeId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());
            int i = monthNames.indexOf(mPreventiveMaintenanceAcReportTextViewFiltersMonth.getText().toString().trim()) + 1;
            jo.put("Month", String.valueOf(i));
            jo.put("Year", mPreventiveMaintenanceAcReportTextViewFiltersYear.getText().toString().trim());

            Log.i(PreventiveMaintenanceSiteReportDashboard.class.getName(), Constants.acPmReportAcList + "\n\n" + jo.toString());

            GsonRequest<AcPMReportListData> getAcPMReportListData = new GsonRequest<>(Request.Method.POST, Constants.acPmReportAcList, jo.toString(), AcPMReportListData.class,
                    new Response.Listener<AcPMReportListData>() {
                        @Override
                        public void onResponse(@NonNull AcPMReportListData response) {
                            hideBusyProgress();
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                if (response.getSuccess() == 1) {
                                    acPMReportListData = response;
                                    if (acPMReportListData.getAcPMReportSummary() != null) {

                                        mAcPreventiveMaintenanceSectionTextViewDoneSites.setText(acPMReportListData.getAcPMReportSummary().getDoneSites() == null || acPMReportListData.getAcPMReportSummary().getDoneSites().isEmpty() ? "0" : acPMReportListData.getAcPMReportSummary().getDoneSites().toString());
                                        mAcPreventiveMaintenanceSectionTextViewPendingSites.setText(acPMReportListData.getAcPMReportSummary().getPendingSites() == null || acPMReportListData.getAcPMReportSummary().getPendingSites().isEmpty() ? "0" : acPMReportListData.getAcPMReportSummary().getPendingSites().toString());
                                        mPreventiveMaintenanceAcReportTextViewTotalSitePm1.setText(acPMReportListData.getAcPMReportSummary().getTotalSitePm() == null || acPMReportListData.getAcPMReportSummary().getTotalSitePm().isEmpty() ? "0" : acPMReportListData.getAcPMReportSummary().getTotalSitePm().toString());
                                        mWheelprogress.setPercentage(360);
                                        mWheelprogress.setStepCountText(String.valueOf(acPMReportListData.getAcPMReportSummary().getTotalSites()));//per
                                    } else {
                                        mAcPreventiveMaintenanceSectionTextViewDoneSites.setText("0");
                                        mAcPreventiveMaintenanceSectionTextViewPendingSites.setText("0");
                                        mPreventiveMaintenanceAcReportTextViewTotalSitePm1.setText("0");
                                        mWheelprogress.setPercentage(0);
                                        mWheelprogress.setStepCountText("0");//per
                                        mPmAcListListViewSiteList.setVisibility(View.GONE);
                                        mTxtNoTicketFound.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        }
                    }, new Response.ErrorListener()

            {
                @Override
                public void onErrorResponse(VolleyError error) {
                    hideBusyProgress();

                }
            });
            getAcPMReportListData.setRetryPolicy(Application.getDefaultRetryPolice());
            getAcPMReportListData.setShouldCache(false);
            Application.getInstance().

                    addToRequestQueue(getAcPMReportListData, "AcPMReportListData");

        } catch (JSONException e) {
            hideBusyProgress();
            showToast("Something went wrong. Please try again later.");
        }
    }

    private void prepareListDataOnChangedAndSelection(String type) {
        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();

            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("UserTypeId", sessionManager.getSessionUserTypeId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());

            int i = monthNames.indexOf(mPreventiveMaintenanceAcReportTextViewFiltersMonth.getText().toString().trim()) + 1;
            jo.put("Month", String.valueOf(i));
            jo.put("Year", mPreventiveMaintenanceAcReportTextViewFiltersYear.getText().toString().trim());
            jo.put("Type", type);

            Log.i(PreventiveMaintenanceSiteReportDashboard.class.getName(), Constants.acPmReportDashboardData + "\n\n" + jo.toString());

            GsonRequest<AcPMReportListData> getAcPMReportListData = new GsonRequest<>(Request.Method.POST, Constants.acPmReportDashboardData, jo.toString(), AcPMReportListData.class,
                    new Response.Listener<AcPMReportListData>() {
                        @Override
                        public void onResponse(@NonNull AcPMReportListData response) {
                            hideBusyProgress();
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                if (response.getSuccess() == 1) {
                                    acPMReportListData = response;

                                    if (acPMReportListData.getAcPMReportTicketsDates() != null && acPMReportListData.getAcPMReportTicketsDates().size() > 0) {
                                        mTxtNoTicketFound.setVisibility(View.GONE);
                                        mPmAcListListViewSiteList.setVisibility(View.VISIBLE);
                                        pmAcReportExpListAdapter = new PmAcReportExpListAdapter(PreventiveMaintenanceAcReportDashboardActivity.this, acPMReportListData);
                                        mPmAcListListViewSiteList.setAdapter(pmAcReportExpListAdapter);
                                        for (int i = 0; i < acPMReportListData.getAcPMReportTicketsDates().size(); i++) {
                                            mPmAcListListViewSiteList.expandGroup(i);
                                        }
                                    } else {
                                        mPmAcListListViewSiteList.setVisibility(View.GONE);
                                        mTxtNoTicketFound.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        }
                    }, new Response.ErrorListener()

            {
                @Override
                public void onErrorResponse(VolleyError error) {
                    hideBusyProgress();

                }
            });
            getAcPMReportListData.setRetryPolicy(Application.getDefaultRetryPolice());
            getAcPMReportListData.setShouldCache(false);
            Application.getInstance().

                    addToRequestQueue(getAcPMReportListData, "SitePMReportListData");

        } catch (JSONException e) {
            hideBusyProgress();
            showToast("Something went wrong. Please try again later.");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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
import com.brahamaputra.mahindra.brahamaputra.Adapters.PmSiteReportExpListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.AcPMReportListData;
import com.brahamaputra.mahindra.brahamaputra.Data.BatteryType;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMReportListData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
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

    private AlertDialogManager alertDialogManager;
    private SessionManager sessionManager;
    public GPSTracker gpsTracker;
    public static final int RESULT_PM_SITE_SUBMIT = 257;

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

        alertDialogManager = new AlertDialogManager(PreventiveMaintenanceAcReportDashboardActivity.this);
        sessionManager = new SessionManager(PreventiveMaintenanceAcReportDashboardActivity.this);
        gpsTracker = new GPSTracker(PreventiveMaintenanceAcReportDashboardActivity.this);
        if (gpsTracker.canGetLocation()) {
            Log.e(PreventiveMaintenanceSiteReportDashboard.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
        }

        //prepareListData();
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

                //showToast("Selected Month: \"" + mPreventiveMaintenanceSiteReportTextViewFiltersMonth.getText().toString().trim() + "\"; Selected Year: \"" + mPreventiveMaintenanceSiteReportTextViewFiltersYear.getText().toString().trim() + "\"");


            }
        });

        mWheelprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayoutTitleNames.setVisibility(View.VISIBLE);
                mTextViewAcPmReportTitle.setText("Total Sites");
                sitePmReportType = "1";
                prepareListDataOnChangedAndSelection("1");
                //showToast("Clicked on total site filter");
            }
        });

        mLinearLayoutContainer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayoutTitleNames.setVisibility(View.VISIBLE);
                mTextViewAcPmReportTitle.setText("Done");
                sitePmReportType = "2";
                prepareListDataOnChangedAndSelection("2");

                //showToast("Clicked on done site filter");
            }
        });

        mLinearLayoutContainer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayoutTitleNames.setVisibility(View.VISIBLE);
                mTextViewAcPmReportTitle.setText("Pending");
                sitePmReportType = "3";
                prepareListDataOnChangedAndSelection("3");
                //showToast("Clicked on pending site filter");
            }
        });

        mLinearLayoutContainer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayoutTitleNames.setVisibility(View.VISIBLE);
                mTextViewAcPmReportTitle.setText("Current Month Plan");
                sitePmReportType = "4";
                prepareListDataOnChangedAndSelection("4");

                //showToast("Clicked on total site pm filter");
            }
        });

        mPmAcListListViewSiteList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                mPmAcListListViewSiteList.expandGroup(groupPosition);
                return true;
            }
        });

        mPmAcListListViewSiteList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, final int childPosition, long id) {
                // notify user

                /*LocationManager lm = (LocationManager) PreventiveMaintenanceSiteReportDashboard.this.getSystemService(Context.LOCATION_SERVICE);
                boolean gps_enabled = false;
                boolean network_enabled = false;

                try {
                    gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
                    network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
                } catch (Exception ex) {
                }

                if (!gps_enabled && !network_enabled) {
                    // notify user
                    alertDialogManager.Dialog("Conformation", "Location is not enabled. Do you want to enable?", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                        @Override
                        public void onPositiveClick() {
                            Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            PreventiveMaintenanceSiteReportDashboard.this.startActivity(myIntent);
                        }
                    }).show();
                } else {
                    if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                        if (sitePMReportListData != null) {
                            String myFormat = "dd/MMM/yyyy";
                            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                            String currentDateTimeString = sdf.format(new Date());

                            final String sitePMTicketId = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getId().toString();
                            final String sitePMTicketNo = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getSitePMTicketNo().toString();

                            final String sitePMTicketDate = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getSitePMTicketDate().toString();
                            final String siteId = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getSiteId().toString();
                            final String siteName = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getSiteName().toString();
                            final String siteAddress = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getSiteAddress().toString();
                            final String status = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getStatus().toString();
                            final String siteType = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getSiteType().toString();
                            final String stateName = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getStateName().toString();
                            final String customerName = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getCustomerName().toString();
                            final String circleName = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getCircleName().toString();
                            final String ssaName = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getSSAName().toString();
                            final String sourceOfPower = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getSourceOfPower().toString();
                            final String sitePmScheduledDate = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getSitePMScheduledDate().toString();
                            final String SiteBoundaryStatus = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getSiteBoundaryStatus().toString();
                            final String NoOfACprovided = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getNoOfACprovided().toString();
                            final String ServoStabilizerStatus = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getServoStabilizerWorkingStatus().toString();


                            if (getDaysRemainingForSheduledDate(currentDateTimeString, sitePmScheduledDate)) {

                                if (sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getBatteryTypes() != null) {
                                    batteryType = new ArrayList<BatteryType>();
                                    batteryType.addAll(sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getBatteryTypes());
                                }

                                hototicket_Selected_SiteType = siteType;
                                hototicket_sourceOfPower = sourceOfPower;
                                sitePm_siteBoundaryStatus = SiteBoundaryStatus;
                                sitePmNoOfAcAvailableAtSite = NoOfACprovided;
                                sitePmServoStabilizerWorkingStatus = ServoStabilizerStatus;

                                sitePmCustomerName = customerName;
                                sitePmCircleName = circleName;
                                sitePmStateName = stateName;
                                sitePmSiteName = siteName;
                                sitePmSiteId = siteId;
                                sitePmSsaName = ssaName;

                                String sitePMTickStatus = sitePMReportListData.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getStatus().toString();

                                if (sitePMTickStatus.equals("Open") || sitePMTickStatus.equals("WIP") || sitePMTickStatus.equals("Reassigned")) {
                                    if (sitePMTickStatus.equals("Open")) {

                                        alertDialogManager.Dialog("Conformation", "Do you want to proceed doing Site PM?", "Yes", "No", new AlertDialogManager.onTwoButtonClickListner() {
                                            @Override
                                            public void onPositiveClick() {
                                                checkSystemLocation(sitePMTicketNo, sitePMTicketId, sitePMTicketDate, siteId, siteName, siteAddress, status, siteType,
                                                        stateName, customerName, circleName, ssaName, sitePmScheduledDate, batteryType);
                                            }

                                            @Override
                                            public void onNegativeClick() {

                                            }
                                        }).show();

                                    } else {
                                        checkSystemLocation(sitePMTicketNo, sitePMTicketId, sitePMTicketDate, siteId, siteName, siteAddress, status, siteType,
                                                stateName, customerName, circleName, ssaName, sitePmScheduledDate, batteryType);
                                    }

                                }
                            }
                        }

                    } else {
                        alertDialogManager.Dialog("Conformation", "Could not get your location. Please try again.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                            @Override
                            public void onPositiveClick() {
                                if (gpsTracker.canGetLocation()) {
                                    Log.e(PriventiveMaintenanceSiteTransactionActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
                                }
                            }
                        }).show();
                    }
                }*/


                return false;
            }
        });
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

            /*jo.put("TotalSites", TotalSites);
            jo.put("DoneSites", DoneSites);
            jo.put("PendingSites", PendingSites);
            jo.put("TotalSitePm", TotalSitePm);
            jo.put("Month", mPreventiveMaintenanceSiteReportTextViewFiltersMonth.getText().toString().trim());
            jo.put("Year", mPreventiveMaintenanceSiteReportTextViewFiltersYear.getText().toString().trim());*/


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
                                    }
                                    /*if (sitePMReportListData.getSitePMReportTicketsDates() != null && sitePMReportListData.getSitePMReportTicketsDates().size() > 0) {
                                        mTxtNoTicketFound.setVisibility(View.GONE);
                                        mPmSiteListListViewSiteList.setVisibility(View.VISIBLE);
                                        pmSiteReportExpListAdapter = new PmSiteReportExpListAdapter(PreventiveMaintenanceSiteReportDashboard.this, sitePMReportListData);
                                        mPmSiteListListViewSiteList.setAdapter(pmSiteReportExpListAdapter);
                                        for (int i = 0; i < sitePMReportListData.getSitePMReportTicketsDates().size(); i++) {
                                            mPmSiteListListViewSiteList.expandGroup(i);
                                        }
                                    }*/
                                    else {
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
            /*jo.put("DoneSites", DoneSites);
            jo.put("PendingSites", PendingSites);
            jo.put("TotalSitePm", TotalSitePm);
            jo.put("Month", mPreventiveMaintenanceSiteReportTextViewFiltersMonth.getText().toString().trim());
            jo.put("Year", mPreventiveMaintenanceSiteReportTextViewFiltersYear.getText().toString().trim());*/


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
                                    /*if (sitePMReportListData.getSitePMReportSummary() != null) {

                                        mAcPreventiveMaintenanceSectionTextViewDoneSites.setText(sitePMReportListData.getSitePMReportSummary().getDoneSites() == null || sitePMReportListData.getSitePMReportSummary().getDoneSites().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getDoneSites().toString());
                                        mAcPreventiveMaintenanceSectionTextViewPendingSites.setText(sitePMReportListData.getSitePMReportSummary().getPendingSites() == null || sitePMReportListData.getSitePMReportSummary().getPendingSites().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getPendingSites().toString());
                                        mPreventiveMaintenanceSiteReportTextViewTotalSitePm1.setText(sitePMReportListData.getSitePMReportSummary().getTotalSitePm() == null || sitePMReportListData.getSitePMReportSummary().getTotalSitePm().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getTotalSitePm().toString());
                                        mWheelprogress.setPercentage(360);
                                        mWheelprogress.setStepCountText(String.valueOf(sitePMReportListData.getSitePMReportSummary().getTotalSites()));//per

                                    }*/
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

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.refresh_icon_menu, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            /*case R.id.menuRefresh:
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // added by tiger on 17092019 for date validation
    public boolean getDaysRemainingForSheduledDate(String currentDateTimeString, String sitePmScheduledDate) {

        /*long requiredDaysForStartWork = 3;
        long lastDayForStartWork = 0;
        String newCurrentDate, newSheduledDate;
        Date newFormatedCurrentDate;
        Date newFormatedSheduledDate;

        SimpleDateFormat simpleDateFormatForCurrentDate = new SimpleDateFormat("dd/MMM/yyyy");
        SimpleDateFormat simpleDateFormatForSheduleDate = new SimpleDateFormat("dd/MMM/yyyy");

        SimpleDateFormat newSimpleDateFormatForDaysCalculate = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        try {

            Date currentDate = simpleDateFormatForCurrentDate.parse(currentDateTimeString);
            Date sheduledDate = simpleDateFormatForSheduleDate.parse(sitePmScheduledDate);

            newCurrentDate = newSimpleDateFormatForDaysCalculate.format(currentDate);
            newSheduledDate = newSimpleDateFormatForDaysCalculate.format(sheduledDate);

            newFormatedCurrentDate = newSimpleDateFormatForDaysCalculate.parse(newCurrentDate);
            newFormatedSheduledDate = newSimpleDateFormatForDaysCalculate.parse(newSheduledDate);

            long different = newFormatedSheduledDate.getTime() - newFormatedCurrentDate.getTime();

            long secondsInMilli = 1000;
            long minutesInMilli = secondsInMilli * 60;
            long hoursInMilli = minutesInMilli * 60;
            long daysInMilli = hoursInMilli * 24;

            long elapsedDays = different / daysInMilli;
            different = different % daysInMilli;

            if (elapsedDays <= requiredDaysForStartWork) {//&& elapsedDays >= lastDayForStartWork
                return true;
            } else if (elapsedDays > requiredDaysForStartWork) {
                showToast("You can open this ticket only 3 days before Scheduled Date:" + sitePmScheduledDate);
            }

        } catch (ParseException e) {
            Log.d("ParseException", e.getMessage());
        } catch (java.text.ParseException e) {
            Log.d("ParseException", e.getMessage());
        }*/

        return false;
    }

    public void checkSystemLocation(final String sitePMTicketNo,
                                    final String sitePMTicketId, String sitePMTicketDate, String siteId,
                                    String siteName, String siteAddress, String status, String siteType,
                                    String stateName, String customerName, String circleName, String ssaName,
                                    String sitePmScheduledDate, ArrayList<BatteryType> batteryType) {

        /*LocationManager lm = (LocationManager) PreventiveMaintenanceSiteReportDashboard.this.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }

        if (!gps_enabled && !network_enabled) {
            // notify user
            alertDialogManager.Dialog("Information", "Location is not enabled. Do you want to enable?", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                @Override
                public void onPositiveClick() {
                    Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    PreventiveMaintenanceSiteReportDashboard.this.startActivity(myIntent);
                }
            }).show();
        } else {
            if (Conditions.isNetworkConnected(PreventiveMaintenanceSiteReportDashboard.this)) {
                //if (gpsTracker.getLongitude()>0 && gpsTracker.getLongitude()>0){

                Intent intent = new Intent(PreventiveMaintenanceSiteReportDashboard.this, PriventiveMaintenanceSiteTransactionActivity.class);
                intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(PreventiveMaintenanceSiteReportDashboard.this));
                intent.putExtra("Id", sitePMTicketId);

                intent.putExtra("ticketNO", sitePMTicketNo);

                intent.putExtra("sitePMTicketDate", sitePMTicketDate);
                intent.putExtra("sitePmScheduledDate", sitePmScheduledDate);
                intent.putExtra("siteId", siteId);
                intent.putExtra("siteName", siteName);
                intent.putExtra("siteAddress", siteAddress);
                intent.putExtra("status", status);
                intent.putExtra("siteType", siteType);
                intent.putExtra("stateName", stateName);
                intent.putExtra("customerName", customerName);
                intent.putExtra("circleName", circleName);
                intent.putExtra("ssaName", ssaName);
                intent.putExtra("latitude", String.valueOf(gpsTracker.getLatitude()));
                intent.putExtra("longitude", String.valueOf(gpsTracker.getLongitude()));

                //String[] array = new String[]{"Item1", "Item2", "item3", "Item4", "item5"};
                //Bundle bundle = new Bundle();
                intent.putExtra("batteryType", batteryType);

                sessionManager.updateSessionUserTicketId(sitePMTicketId);
                sessionManager.updateSessionUserTicketName(sitePMTicketNo);
                startActivityForResult(intent, RESULT_PM_SITE_SUBMIT);

                //}else{
                //    showToast("Sorry could not detect location");
                //    finish();
                //}

            } else {
                alertDialogManager.Dialog("Information", "Device has no internet connection. Do you want to use offline mode?", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                    @Override
                    public void onPositiveClick() {
                        Intent intent = new Intent(PreventiveMaintenanceSiteReportDashboard.this, PriventiveMaintenanceSiteTransactionActivity.class);
                        intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(PreventiveMaintenanceSiteReportDashboard.this));
                        intent.putExtra("ticketNO", sitePMTicketNo);
                        sessionManager.updateSessionUserTicketId(sitePMTicketId);
                        sessionManager.updateSessionUserTicketName(sitePMTicketNo);
                        startActivityForResult(intent, RESULT_PM_SITE_SUBMIT);
                    }
                }).show();
            }
        }*/
    }
}

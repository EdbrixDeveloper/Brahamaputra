package com.brahamaputra.mahindra.brahamaputra.Activities;


import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.brahamaputra.mahindra.brahamaputra.Adapters.PmSiteReportExpListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMReportListData;
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

public class PreventiveMaintenanceSiteReportDashboard extends BaseActivity {

    private LinearLayout mPreventiveMaintenanceSiteReportLinearLayoutFiltersMonthYear;
    private TextView mPreventiveMaintenanceSiteReportTextViewFiltersMonth;
    private TextView mPreventiveMaintenanceSiteReportTextViewFiltersYear;
    private Button mPreventiveMaintenanceSiteReportButtonFiltersMonthYear;
    private LinearLayout mLinearLayoutStatus;
    private ProgressWheel mWheelprogress;
    private LinearLayout mLinearLayoutContainer1;
    private TextView mAcPreventiveMaintenanceSectionTextViewDoneSites;
    private TextView mAcPreventiveMaintenanceSectionTextViewNo;
    private LinearLayout mLinearLayoutContainer2;
    private TextView mAcPreventiveMaintenanceSectionTextViewPendingSites;
    private TextView mAcPreventiveMaintenanceSectionTextViewNo2;
    private LinearLayout mLinearLayoutContainer3;
    private TextView mPreventiveMaintenanceSiteReportTextViewTotalSitePm1;
    private TextView mPreventiveMaintenanceSiteReportTextViewTotalSitePm2;
    private ExpandableListView mPmSiteListListViewSiteList;
    private TextView mTxtNoTicketFound;
    LinearLayout LinearLayoutTitleNames;
    TextView TextViewSitePmReportTitle;

    String str_pmSiteMonthVal = "";
    String str_pmSiteYearVal = "";
    private ArrayList<String> monthNames;
    private SitePMReportListData sitePMReportListData;
    private PmSiteReportExpListAdapter pmSiteReportExpListAdapter;

    public ExpandableListView pmSiteList_listView_siteList;
    private SessionManager sessionManager;

    public GPSTracker gpsTracker;
    public static final int RESULT_PM_SITE_SUBMIT = 257;
    private TextView txtNoTicketFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_report_dashboard);
        this.setTitle("Site PM Report");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        monthNames = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteReportDashboard_monthName)));

        assignViews();
        initCombo();

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        mPreventiveMaintenanceSiteReportTextViewFiltersMonth.setText(monthNames.get(month));
        mPreventiveMaintenanceSiteReportTextViewFiltersYear.setText(String.valueOf(year));

        ////////////////////////////

        sitePMReportListData = new SitePMReportListData();
        mWheelprogress = (ProgressWheel) findViewById(R.id.wheelprogress);
        mPmSiteListListViewSiteList = (ExpandableListView) findViewById(R.id.pmSiteList_listView_siteList);

        mAcPreventiveMaintenanceSectionTextViewDoneSites = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_doneSites);
        mAcPreventiveMaintenanceSectionTextViewPendingSites = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_pendingSites);
        mPreventiveMaintenanceSiteReportTextViewTotalSitePm1 = (TextView) findViewById(R.id.preventiveMaintenanceSiteReport_textView_totalSitePm1);
        txtNoTicketFound = (TextView) findViewById(R.id.txtNoTicketFound);
        txtNoTicketFound.setVisibility(View.GONE);
        LinearLayoutTitleNames = (LinearLayout) findViewById(R.id.linearLayout_titleNames);
        TextViewSitePmReportTitle = (TextView) findViewById(R.id.textView_sitePmReportTitle);

        sessionManager = new SessionManager(PreventiveMaintenanceSiteReportDashboard.this);
        gpsTracker = new GPSTracker(PreventiveMaintenanceSiteReportDashboard.this);
        if (gpsTracker.canGetLocation()) {
            Log.e(PreventiveMaintenanceSiteReportDashboard.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
        }

        //prepareListData();
        prepareSitePmReportListData();

        //default calling first time
        LinearLayoutTitleNames.setVisibility(View.VISIBLE);
        TextViewSitePmReportTitle.setText("Current Month Plan");
        prepareListDataOnChangedAndSelection("4");

        mPreventiveMaintenanceSiteReportButtonFiltersMonthYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayoutTitleNames.setVisibility(View.GONE);
                TextViewSitePmReportTitle.setText("Title");
                prepareSitePmReportListData();

                ///////////////
                LinearLayoutTitleNames.setVisibility(View.VISIBLE);
                TextViewSitePmReportTitle.setText("Current Month Plan");
                prepareListDataOnChangedAndSelection("4");
                //showToast("Selected Month: \"" + mPreventiveMaintenanceSiteReportTextViewFiltersMonth.getText().toString().trim() + "\"; Selected Year: \"" + mPreventiveMaintenanceSiteReportTextViewFiltersYear.getText().toString().trim() + "\"");
            }
        });

        mWheelprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutTitleNames.setVisibility(View.VISIBLE);
                TextViewSitePmReportTitle.setText("Total Sites");
                sitePmReportType = "1";
                prepareListDataOnChangedAndSelection("1");
                //showToast("Clicked on total site filter");
            }
        });

        mLinearLayoutContainer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutTitleNames.setVisibility(View.VISIBLE);
                TextViewSitePmReportTitle.setText("Done");
                sitePmReportType = "2";
                prepareListDataOnChangedAndSelection("2");

                //showToast("Clicked on done site filter");
            }
        });

        mLinearLayoutContainer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutTitleNames.setVisibility(View.VISIBLE);
                TextViewSitePmReportTitle.setText("Pending");
                sitePmReportType = "3";
                prepareListDataOnChangedAndSelection("3");
                //showToast("Clicked on pending site filter");
            }
        });

        mLinearLayoutContainer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutTitleNames.setVisibility(View.VISIBLE);
                TextViewSitePmReportTitle.setText("Current Month Plan");
                sitePmReportType = "4";
                prepareListDataOnChangedAndSelection("4");
                //showToast("Clicked on total site pm filter");
            }
        });

       /* mPmSiteListListViewSiteList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                mPmSiteListListViewSiteList.expandGroup(groupPosition);
                return true;
            }
        });*/
       /* mPmSiteListListViewSiteList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, final int childPosition, long id) {
                // notify user

                LocationManager lm = (LocationManager) PreventiveMaintenanceSiteReportDashboard.this.getSystemService(Context.LOCATION_SERVICE);
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
                }


                return false;
            }
        });*/

    }

    private void assignViews() {
        mPreventiveMaintenanceSiteReportLinearLayoutFiltersMonthYear = (LinearLayout) findViewById(R.id.preventiveMaintenanceSiteReport_linearLayout_filtersMonthYear);
        mPreventiveMaintenanceSiteReportTextViewFiltersMonth = (TextView) findViewById(R.id.preventiveMaintenanceSiteReport_textView_filtersMonth);
        mPreventiveMaintenanceSiteReportTextViewFiltersYear = (TextView) findViewById(R.id.preventiveMaintenanceSiteReport_textView_filtersYear);
        mPreventiveMaintenanceSiteReportButtonFiltersMonthYear = (Button) findViewById(R.id.preventiveMaintenanceSiteReport_Button_filtersMonthYear);
        mLinearLayoutStatus = (LinearLayout) findViewById(R.id.linearLayout_Status);
        mWheelprogress = (ProgressWheel) findViewById(R.id.wheelprogress);
        mLinearLayoutContainer1 = (LinearLayout) findViewById(R.id.linearLayout_container1);
        mAcPreventiveMaintenanceSectionTextViewDoneSites = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_doneSites);
        mAcPreventiveMaintenanceSectionTextViewNo = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_no);
        mLinearLayoutContainer2 = (LinearLayout) findViewById(R.id.linearLayout_container2);
        mAcPreventiveMaintenanceSectionTextViewPendingSites = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_pendingSites);
        mAcPreventiveMaintenanceSectionTextViewNo2 = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_no2);
        mLinearLayoutContainer3 = (LinearLayout) findViewById(R.id.linearLayout_container3);
        mPreventiveMaintenanceSiteReportTextViewTotalSitePm1 = (TextView) findViewById(R.id.preventiveMaintenanceSiteReport_textView_totalSitePm1);
        mPreventiveMaintenanceSiteReportTextViewTotalSitePm2 = (TextView) findViewById(R.id.preventiveMaintenanceSiteReport_textView_totalSitePm2);
        mPmSiteListListViewSiteList = (ExpandableListView) findViewById(R.id.pmSiteList_listView_siteList);
        mTxtNoTicketFound = (TextView) findViewById(R.id.txtNoTicketFound);
    }

    private void initCombo() {
        mPreventiveMaintenanceSiteReportTextViewFiltersMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteReportDashboard.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteReportDashboard_monthName))),
                        "Select Month",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteMonthVal = item.get(position);
                        mPreventiveMaintenanceSiteReportTextViewFiltersMonth.setText(str_pmSiteMonthVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteReportTextViewFiltersYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteReportDashboard.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteReportDashboard_yearName))),
                        "Select Year",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteYearVal = item.get(position);
                        mPreventiveMaintenanceSiteReportTextViewFiltersYear.setText(str_pmSiteYearVal);
                    }
                });
            }
        });
    }


    private void prepareListData() {
        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();

            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());

            Log.i(PreventiveMaintenanceSiteReportDashboard.class.getName(), Constants.sitePmTicketList + "\n\n" + jo.toString());

            GsonRequest<SitePMReportListData> getSitePMReportListData = new GsonRequest<>(Request.Method.POST, Constants.sitePmTicketList, jo.toString(), SitePMReportListData.class,
                    new Response.Listener<SitePMReportListData>() {
                        @Override
                        public void onResponse(@NonNull SitePMReportListData response) {
                            hideBusyProgress();
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                if (response.getSuccess() == 1) {
                                    sitePMReportListData = response;
                                    if (sitePMReportListData.getSitePMReportSummary() != null) {

                                        mAcPreventiveMaintenanceSectionTextViewDoneSites.setText(sitePMReportListData.getSitePMReportSummary().getDoneSites() == null || sitePMReportListData.getSitePMReportSummary().getDoneSites().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getDoneSites().toString());
                                        mAcPreventiveMaintenanceSectionTextViewPendingSites.setText(sitePMReportListData.getSitePMReportSummary().getPendingSites() == null || sitePMReportListData.getSitePMReportSummary().getPendingSites().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getPendingSites().toString());
                                        mPreventiveMaintenanceSiteReportTextViewTotalSitePm1.setText(sitePMReportListData.getSitePMReportSummary().getTotalSitePm() == null || sitePMReportListData.getSitePMReportSummary().getTotalSitePm().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getTotalSitePm().toString());


                                        /*double per = 0.0;
                                        double circlePer = 0.0;
                                        int roundPer = 0;
                                        per = sitePMReportListData.getSitePMTicketSummary().getPercentage();
                                        circlePer = (3.6) * Double.valueOf(per);
                                        roundPer = (int) Math.round(circlePer);

                                        DecimalFormat df = new DecimalFormat("###.##");
                                        df.setRoundingMode(RoundingMode.FLOOR);
                                        per = new Double(df.format(per));*/


                                        mWheelprogress.setPercentage(360);//roundPer
                                        mWheelprogress.setStepCountText(String.valueOf(sitePMReportListData.getSitePMReportSummary().getTotalSites()));//per


                                    }
                                    if (sitePMReportListData.getSitePMReportTicketsDates() != null && sitePMReportListData.getSitePMReportTicketsDates().size() > 0) {
                                        txtNoTicketFound.setVisibility(View.GONE);
                                        mPmSiteListListViewSiteList.setVisibility(View.VISIBLE);
                                        pmSiteReportExpListAdapter = new PmSiteReportExpListAdapter(PreventiveMaintenanceSiteReportDashboard.this, sitePMReportListData);
                                        mPmSiteListListViewSiteList.setAdapter(pmSiteReportExpListAdapter);
                                        for (int i = 0; i < sitePMReportListData.getSitePMReportTicketsDates().size(); i++) {
                                            mPmSiteListListViewSiteList.expandGroup(i);
                                        }
                                    } else {
                                        mPmSiteListListViewSiteList.setVisibility(View.GONE);
                                        txtNoTicketFound.setVisibility(View.VISIBLE);
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
            getSitePMReportListData.setRetryPolicy(Application.getDefaultRetryPolice());
            getSitePMReportListData.setShouldCache(false);
            Application.getInstance().

                    addToRequestQueue(getSitePMReportListData, "SitePMReportListData");

        } catch (JSONException e) {
            hideBusyProgress();
            showToast("Something went wrong. Please try again later.");
        }

    }

    private void prepareSitePmReportListData() {
        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();

            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());
            int i = monthNames.indexOf(mPreventiveMaintenanceSiteReportTextViewFiltersMonth.getText().toString().trim()) + 1;
            jo.put("Month", String.valueOf(i));
            jo.put("Year", mPreventiveMaintenanceSiteReportTextViewFiltersYear.getText().toString().trim());

            Log.i(PreventiveMaintenanceSiteReportDashboard.class.getName(), Constants.sitePmReportSiteList + "\n\n" + jo.toString());

            GsonRequest<SitePMReportListData> getSitePMReportListData = new GsonRequest<>(Request.Method.POST, Constants.sitePmReportSiteList, jo.toString(), SitePMReportListData.class,
                    new Response.Listener<SitePMReportListData>() {
                        @Override
                        public void onResponse(@NonNull SitePMReportListData response) {
                            hideBusyProgress();
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                if (response.getSuccess() == 1) {
                                    sitePMReportListData = response;
                                    if (sitePMReportListData.getSitePMReportSummary() != null) {

                                        mAcPreventiveMaintenanceSectionTextViewDoneSites.setText(sitePMReportListData.getSitePMReportSummary().getDoneSites() == null || sitePMReportListData.getSitePMReportSummary().getDoneSites().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getDoneSites().toString());
                                        mAcPreventiveMaintenanceSectionTextViewPendingSites.setText(sitePMReportListData.getSitePMReportSummary().getPendingSites() == null || sitePMReportListData.getSitePMReportSummary().getPendingSites().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getPendingSites().toString());
                                        mPreventiveMaintenanceSiteReportTextViewTotalSitePm1.setText(sitePMReportListData.getSitePMReportSummary().getTotalSitePm() == null || sitePMReportListData.getSitePMReportSummary().getTotalSitePm().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getTotalSitePm().toString());
                                        mWheelprogress.setPercentage(360);
                                        mWheelprogress.setStepCountText(String.valueOf(sitePMReportListData.getSitePMReportSummary().getTotalSites()));//per
                                    }
                                    /*if (sitePMReportListData.getSitePMReportTicketsDates() != null && sitePMReportListData.getSitePMReportTicketsDates().size() > 0) {
                                        txtNoTicketFound.setVisibility(View.GONE);
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
                                        mPreventiveMaintenanceSiteReportTextViewTotalSitePm1.setText("0");
                                        mWheelprogress.setPercentage(0);
                                        mWheelprogress.setStepCountText("0");//per
                                        mPmSiteListListViewSiteList.setVisibility(View.GONE);
                                        txtNoTicketFound.setVisibility(View.VISIBLE);
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
            getSitePMReportListData.setRetryPolicy(Application.getDefaultRetryPolice());
            getSitePMReportListData.setShouldCache(false);
            Application.getInstance().

                    addToRequestQueue(getSitePMReportListData, "SitePMReportListData");

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
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());

            int i = monthNames.indexOf(mPreventiveMaintenanceSiteReportTextViewFiltersMonth.getText().toString().trim()) + 1;
            jo.put("Month", String.valueOf(i));
            jo.put("Year", mPreventiveMaintenanceSiteReportTextViewFiltersYear.getText().toString().trim());
            jo.put("Type", type);

            Log.i(PreventiveMaintenanceSiteReportDashboard.class.getName(), Constants.sitePmReportDashboardData + "\n\n" + jo.toString());

            GsonRequest<SitePMReportListData> getSitePMReportListData = new GsonRequest<>(Request.Method.POST, Constants.sitePmReportDashboardData, jo.toString(), SitePMReportListData.class,
                    new Response.Listener<SitePMReportListData>() {
                        @Override
                        public void onResponse(@NonNull SitePMReportListData response) {
                            hideBusyProgress();
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                if (response.getSuccess() == 1) {
                                    sitePMReportListData = response;
                                    /*if (sitePMReportListData.getSitePMReportSummary() != null) {

                                        mAcPreventiveMaintenanceSectionTextViewDoneSites.setText(sitePMReportListData.getSitePMReportSummary().getDoneSites() == null || sitePMReportListData.getSitePMReportSummary().getDoneSites().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getDoneSites().toString());
                                        mAcPreventiveMaintenanceSectionTextViewPendingSites.setText(sitePMReportListData.getSitePMReportSummary().getPendingSites() == null || sitePMReportListData.getSitePMReportSummary().getPendingSites().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getPendingSites().toString());
                                        mPreventiveMaintenanceSiteReportTextViewTotalSitePm1.setText(sitePMReportListData.getSitePMReportSummary().getTotalSitePm() == null || sitePMReportListData.getSitePMReportSummary().getTotalSitePm().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getTotalSitePm().toString());
                                        mWheelprogress.setPercentage(360);
                                        mWheelprogress.setStepCountText(String.valueOf(sitePMReportListData.getSitePMReportSummary().getTotalSites()));//per

                                    }*/
                                    if (sitePMReportListData.getSitePMReportTicketsDates() != null && sitePMReportListData.getSitePMReportTicketsDates().size() > 0) {
                                        txtNoTicketFound.setVisibility(View.GONE);
                                        mPmSiteListListViewSiteList.setVisibility(View.VISIBLE);
                                        pmSiteReportExpListAdapter = new PmSiteReportExpListAdapter(PreventiveMaintenanceSiteReportDashboard.this, sitePMReportListData);
                                        mPmSiteListListViewSiteList.setAdapter(pmSiteReportExpListAdapter);
                                        for (int i = 0; i < sitePMReportListData.getSitePMReportTicketsDates().size(); i++) {
                                            mPmSiteListListViewSiteList.expandGroup(i);
                                        }
                                    } else {
                                        mPmSiteListListViewSiteList.setVisibility(View.GONE);
                                        txtNoTicketFound.setVisibility(View.VISIBLE);
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
            getSitePMReportListData.setRetryPolicy(Application.getDefaultRetryPolice());
            getSitePMReportListData.setShouldCache(false);
            Application.getInstance().

                    addToRequestQueue(getSitePMReportListData, "SitePMReportListData");

        } catch (JSONException e) {
            hideBusyProgress();
            showToast("Something went wrong. Please try again later.");
        }

    }

    private void prepareListDataOnSelectionTotalSites() {
        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();

            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());
            jo.put("TotalSitesFlag", sessionManager.getSessionDeviceToken());
            jo.put("DoneSitesFlag", sessionManager.getSessionDeviceToken());
            jo.put("PendingSitesFlag", sessionManager.getSessionDeviceToken());
            jo.put("TotalSitePmFlag", sessionManager.getSessionDeviceToken());
            jo.put("Month", mPreventiveMaintenanceSiteReportTextViewFiltersMonth.getText().toString().trim());
            jo.put("Year", mPreventiveMaintenanceSiteReportTextViewFiltersYear.getText().toString().trim());


            Log.i(PreventiveMaintenanceSiteReportDashboard.class.getName(), Constants.sitePmTicketList + "\n\n" + jo.toString());

            GsonRequest<SitePMReportListData> getSitePMReportListData = new GsonRequest<>(Request.Method.POST, Constants.sitePmTicketList, jo.toString(), SitePMReportListData.class,
                    new Response.Listener<SitePMReportListData>() {
                        @Override
                        public void onResponse(@NonNull SitePMReportListData response) {
                            hideBusyProgress();
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                if (response.getSuccess() == 1) {
                                    sitePMReportListData = response;
                                    if (sitePMReportListData.getSitePMReportSummary() != null) {

                                        mAcPreventiveMaintenanceSectionTextViewDoneSites.setText(sitePMReportListData.getSitePMReportSummary().getDoneSites() == null || sitePMReportListData.getSitePMReportSummary().getDoneSites().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getDoneSites().toString());
                                        mAcPreventiveMaintenanceSectionTextViewPendingSites.setText(sitePMReportListData.getSitePMReportSummary().getPendingSites() == null || sitePMReportListData.getSitePMReportSummary().getPendingSites().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getPendingSites().toString());
                                        mPreventiveMaintenanceSiteReportTextViewTotalSitePm1.setText(sitePMReportListData.getSitePMReportSummary().getTotalSitePm() == null || sitePMReportListData.getSitePMReportSummary().getTotalSitePm().isEmpty() ? "0" : sitePMReportListData.getSitePMReportSummary().getTotalSitePm().toString());


                                        /*double per = 0.0;
                                        double circlePer = 0.0;
                                        int roundPer = 0;
                                        per = sitePMReportListData.getSitePMTicketSummary().getPercentage();
                                        circlePer = (3.6) * Double.valueOf(per);
                                        roundPer = (int) Math.round(circlePer);

                                        DecimalFormat df = new DecimalFormat("###.##");
                                        df.setRoundingMode(RoundingMode.FLOOR);
                                        per = new Double(df.format(per));*/


                                        mWheelprogress.setPercentage(360);//roundPer
                                        mWheelprogress.setStepCountText(String.valueOf(sitePMReportListData.getSitePMReportSummary().getTotalSites()));//per


                                    }
                                    if (sitePMReportListData.getSitePMReportTicketsDates() != null && sitePMReportListData.getSitePMReportTicketsDates().size() > 0) {
                                        txtNoTicketFound.setVisibility(View.GONE);
                                        mPmSiteListListViewSiteList.setVisibility(View.VISIBLE);
                                        pmSiteReportExpListAdapter = new PmSiteReportExpListAdapter(PreventiveMaintenanceSiteReportDashboard.this, sitePMReportListData);
                                        mPmSiteListListViewSiteList.setAdapter(pmSiteReportExpListAdapter);
                                        for (int i = 0; i < sitePMReportListData.getSitePMReportTicketsDates().size(); i++) {
                                            mPmSiteListListViewSiteList.expandGroup(i);
                                        }
                                    } else {
                                        mPmSiteListListViewSiteList.setVisibility(View.GONE);
                                        txtNoTicketFound.setVisibility(View.VISIBLE);
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
            getSitePMReportListData.setRetryPolicy(Application.getDefaultRetryPolice());
            getSitePMReportListData.setShouldCache(false);
            Application.getInstance().

                    addToRequestQueue(getSitePMReportListData, "SitePMReportListData");

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

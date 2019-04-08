package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.app.progresviews.ProgressWheel;
import com.brahamaputra.mahindra.brahamaputra.Adapters.PmSiteExpListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.BatteryType;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMTicketsList;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePmAcTicketList;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GPSTracker;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_Selected_SiteType;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_sourceOfPower;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmCircleName;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmCustomerName;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmNoOfAcAvailableAtSite;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmServoStabilizerWorkingStatus;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmSiteId;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmSiteName;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmSsaName;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmStateName;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePm_siteBoundaryStatus;

public class AcPreventiveMaintenanceDashboardActivity extends BaseActivity {

    private LinearLayout mLinearLayoutStatus;
    private ProgressWheel mWheelprogress;
    private LinearLayout mLinearLayoutContainer1;
    private TextView mAcPreventiveMaintenanceSectionTextViewName;
    private TextView mAcPreventiveMaintenanceSectionTextViewNo;
    private LinearLayout mLinearLayoutContainer2;
    private TextView mAcPreventiveMaintenanceSectionTextViewName2;
    private TextView mAcPreventiveMaintenanceSectionTextViewNo2;
    private LinearLayout mPmSiteDashboardLinearLayoutTicket1;
    private TextView mTextViewHotoName;
    private TextView mTextViewSiteID;
    private TextView mTextViewSiteName;
    private TextView mTextViewSiteSSA;
    private TextView mTextViewSiteAddress;
    private LinearLayout mPmSiteDashboardLinearLayoutTicket2;
    private TextView mTextViewHotoName1;
    private TextView mTextViewSiteID1;
    private TextView mTextViewSiteName1;
    private TextView mTextViewSiteSSA1;
    private TextView mTextViewSiteAddress1;
    private LinearLayout mPriventiveMaintenanceSiteLinearLayoutTicket1;
    private LinearLayout mPriventiveMaintenanceSiteLinearLayoutTicket2;
    public ExpandableListView pmSiteList_listView_siteacList;


    public GPSTracker gpsTracker;
    private AlertDialogManager alertDialogManager;
    private SessionManager sessionManager;
    public static final int RESULT_PM_SITE_SUBMIT = 257;
    private TextView txtNoTicketFound;
    public ExpandableListView acSiteList_listView_siteList;

    private SitePmAcTicketList sitePmAcTicketList;

    String returnValueFromFieldEngineerForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_preventive_maintenance_dashboard);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("AC PM");

        sitePmAcTicketList = new SitePmAcTicketList();
        alertDialogManager = new AlertDialogManager(AcPreventiveMaintenanceDashboardActivity.this);
        gpsTracker = new GPSTracker(AcPreventiveMaintenanceDashboardActivity.this);

        assignViews();
        sessionManager = new SessionManager(AcPreventiveMaintenanceDashboardActivity.this);
        setListner();
        //prepareListData();

        acSiteList_listView_siteList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                acSiteList_listView_siteList.expandGroup(groupPosition);
                return true;
            }
        });

        acSiteList_listView_siteList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, final int childPosition, long id) {
                // notify user

                LocationManager lm = (LocationManager) AcPreventiveMaintenanceDashboardActivity.this.getSystemService(Context.LOCATION_SERVICE);
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
                            AcPreventiveMaintenanceDashboardActivity.this.startActivity(myIntent);
                        }
                    }).show();
                } else {
                    if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                        if (sitePmAcTicketList != null) {
                            //final String sitePMAcTicketId = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMTickets().get(childPosition).getId().toString();
                            final String sitePMAcTicketId = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getId().toString();
                            final String sitePMAcTicketNo = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getSitePMAcTicketNo().toString();
                            final String sitePMAcTicketDate = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getSitePMAcTicketDate().toString();
                            final String pmPlanDate = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getPmPlanDate().toString();
                            final String submittedDate = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getSubmittedDate().toString();
                            final String sheduledDateOfAcPm = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getSheduledDateOfAcPm().toString();
                            final String modeOfOpration = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getModeOfOpration().toString();
                            final String vendorName = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getVendorName().toString();
                            final String acTechnicianName = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getAcTechnicianName().toString();
                            final String acTechnicianMobileNo = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getAcTechnicianMobileNo().toString();
                            final String siteId = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getSiteId().toString();
                            final String siteName = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getSiteName().toString();

                            final String status = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getStatus().toString();
                            final String numberOfAc = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getNumberOfAc().toString();
                            final String acTechnicianStatus = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getAcTechnicianStatus().toString();
                            final String stateName = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getSiteName().toString();
                            final String customerName = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getCustomerName().toString();
                            final String circleName = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getCircleName().toString();
                            final String ssaName = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getSSAName().toString();

                            //only below fields are added as static variable in constant class used to attach these field statically in listed form
                            sitePmNoOfAcAvailableAtSite = numberOfAc;
                            sitePmCustomerName = customerName;
                            sitePmCircleName = circleName;
                            sitePmStateName = stateName;
                            sitePmSiteName = siteName;
                            sitePmSiteId = siteId;
                            sitePmSsaName = ssaName;
                            //remaining ------------------------------------------
                            // For ticket submission from field engg.
                            /* sheduled date of ad pm
                               mode of opration
                               ticket no
                               vendor name
                               ac technician name
                               ac technician moblie no
                               status
                               submitted date comes from web service when ac tech submit his ticket
                            */
                            // For ac preventive maintenance process
                            /*  ticket no
                                ticket date
                                pm plan date
                                submitted date
                            * */
                            //------------------------------------------------

                            String acSitePMTickStatus = sitePmAcTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getStatus().toString();

                            // comment for not added checkSystemLocation
                            /*if (acSitePMTickStatus.equals("Open") || acSitePMTickStatus.equals("WIP") || acSitePMTickStatus.equals("Reassigned")) {
                                if (acSitePMTickStatus.equals("Open")) {

                                    alertDialogManager.Dialog("Conformation", "Do you want to proceed.", "Yes", "No", new AlertDialogManager.onTwoButtonClickListner() {
                                        @Override
                                        public void onPositiveClick() {
                                            checkSystemLocation(sitePMAcTicketNo, sitePMTicketId, sitePMTicketDate, siteId, siteName, siteAddress, status, siteType,
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

                            }*/
                        }

                    } else {
                        alertDialogManager.Dialog("Conformation", "Could not get your location. Please try again.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                            @Override
                            public void onPositiveClick() {
                                if (gpsTracker.canGetLocation()) {
                                    //showToast("Lat : "+gpsTracker.getLatitude()+"\n Long : "+gpsTracker.getLongitude()); comment By 008 on 10-11-2018
                                    Log.e(PriventiveMaintenanceSiteTransactionActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
                                }
                            }
                        }).show();
                    }
                }


                return false;
            }
        });
    }

    private void assignViews() {
        mLinearLayoutStatus = (LinearLayout) findViewById(R.id.linearLayout_Status);
        mWheelprogress = (ProgressWheel) findViewById(R.id.wheelprogress);
        mLinearLayoutContainer1 = (LinearLayout) findViewById(R.id.linearLayout_container1);
        mAcPreventiveMaintenanceSectionTextViewName = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_name);
        mAcPreventiveMaintenanceSectionTextViewNo = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_no);
        mPriventiveMaintenanceSiteLinearLayoutTicket1 = (LinearLayout) findViewById(R.id.pmSiteDashboard_linearLayout_ticket1);
        mPriventiveMaintenanceSiteLinearLayoutTicket2 = (LinearLayout) findViewById(R.id.pmSiteDashboard_linearLayout_ticket2);
        mLinearLayoutContainer2 = (LinearLayout) findViewById(R.id.linearLayout_container2);
        mAcPreventiveMaintenanceSectionTextViewName2 = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_name2);
        mAcPreventiveMaintenanceSectionTextViewNo2 = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_no2);
        mPmSiteDashboardLinearLayoutTicket1 = (LinearLayout) findViewById(R.id.pmSiteDashboard_linearLayout_ticket1);
        mTextViewHotoName = (TextView) findViewById(R.id.textView_HotoName);
        mTextViewSiteID = (TextView) findViewById(R.id.textView_SiteID);
        mTextViewSiteName = (TextView) findViewById(R.id.textView_SiteName);
        mTextViewSiteSSA = (TextView) findViewById(R.id.textView_SiteSSA);
        mTextViewSiteAddress = (TextView) findViewById(R.id.textView_SiteAddress);
        mPmSiteDashboardLinearLayoutTicket2 = (LinearLayout) findViewById(R.id.pmSiteDashboard_linearLayout_ticket2);
        mTextViewHotoName1 = (TextView) findViewById(R.id.textView_HotoName1);
        mTextViewSiteID1 = (TextView) findViewById(R.id.textView_SiteID1);
        mTextViewSiteName1 = (TextView) findViewById(R.id.textView_SiteName1);
        mTextViewSiteSSA1 = (TextView) findViewById(R.id.textView_SiteSSA1);
        mTextViewSiteAddress1 = (TextView) findViewById(R.id.textView_SiteAddress1);
        pmSiteList_listView_siteacList = (ExpandableListView) findViewById(R.id.acPmSiteList_listView_siteAcList);

        txtNoTicketFound = (TextView) findViewById(R.id.txtNoTicketFound);
        txtNoTicketFound.setVisibility(View.GONE);
    }

    private void setListner() {

        mPriventiveMaintenanceSiteLinearLayoutTicket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //alertDialogManager = new AlertDialogManager(UserHotoTransactionActivity.this);
                alertDialogManager.Dialog("Information", "Do you want to proceed doing AC PM?", "Yes", "No", new AlertDialogManager.onTwoButtonClickListner() {
                    @Override
                    public void onPositiveClick() {
                        openTicket1();
                    }

                    @Override
                    public void onNegativeClick() {

                    }
                }).show();
                /*alertDialogManager.Dialog("Information", "Do you want to proceed doing AC PM?", "Ok", "No", new AlertDialogManager.onSingleButtonClickListner() {
                    @Override
                    public void onPositiveClick() {
                        openTicket1();
                    }
                }).show();*/

            }
        });

        mPriventiveMaintenanceSiteLinearLayoutTicket2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialogManager.Dialog("Information", "Do you want to proceed doing AC PM?", "Yes", "No", new AlertDialogManager.onTwoButtonClickListner() {
                    @Override
                    public void onPositiveClick() {
                        openTicket2();
                    }

                    @Override
                    public void onNegativeClick() {

                    }
                }).show();

                /*alertDialogManager.Dialog("Information", "Do you want to proceed doing AC PM?", "Ok", "No", new AlertDialogManager.onSingleButtonClickListner() {
                    @Override
                    public void onPositiveClick() {
                        openTicket2();
                    }
                }).show();*/
            }
        });
    }

    private void openTicket2() {
        if (Conditions.isNetworkConnected(AcPreventiveMaintenanceDashboardActivity.this)) {
            if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                Intent intent = new Intent(AcPreventiveMaintenanceDashboardActivity.this, AcPreventiveMaintenanceSectionsListActivity.class);
                intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(AcPreventiveMaintenanceDashboardActivity.this));
                intent.putExtra("ticketNO", "SIKL19019999");
                intent.putExtra("status", "Submitted");
                sessionManager.updateSessionUserTicketId("SIKL19019999");
                sessionManager.updateSessionUserTicketName("SIKL19019999");
                startActivityForResult(intent, RESULT_PM_SITE_SUBMIT);
            } else {
                //showToast("Could not detecting location. Please try again later.");
                alertDialogManager.Dialog("Information", "Could not get your location. Please try again.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                    @Override
                    public void onPositiveClick() {
                        if (gpsTracker.canGetLocation()) {
                            //showToast("Lat : "+gpsTracker.getLatitude()+"\n Long : "+gpsTracker.getLongitude()); comment By Arjun on 10-11-2018
                            Log.e(MyPreventiveListActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
                        }
                    }
                }).show();
            }
        } else {
            alertDialogManager.Dialog("Information", "Device has no internet connection. Turn on internet", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                @Override
                public void onPositiveClick() {
                    finish();
                }
            }).show();
        }
    }

    private void openTicket1() {
        if (Conditions.isNetworkConnected(AcPreventiveMaintenanceDashboardActivity.this)) {
            if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                Intent intent = new Intent(AcPreventiveMaintenanceDashboardActivity.this, AcPreventiveMaintenanceSectionsListActivity.class);
                intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(AcPreventiveMaintenanceDashboardActivity.this));
                intent.putExtra("ticketNO", "SIKL19012222");
                intent.putExtra("status", "Submitted by Technician");
                sessionManager.updateSessionUserTicketId("SIKL19012222");
                sessionManager.updateSessionUserTicketName("SIKL19012222");
                startActivityForResult(intent, RESULT_PM_SITE_SUBMIT);
            } else {
                alertDialogManager.Dialog("Information", "Could not get your location. Please try again.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                    @Override
                    public void onPositiveClick() {
                        if (gpsTracker.canGetLocation()) {
                            Log.e(MyPreventiveListActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
                        }
                    }
                }).show();
            }
        } else {
            alertDialogManager.Dialog("Information", "Device has no internet connection. Turn on internet", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                @Override
                public void onPositiveClick() {
                    finish();
                }
            }).show();
        }
    }

//    private void prepareListData() {
//        try {
//            showBusyProgress();
//            JSONObject jo = new JSONObject();
//
//
//            jo.put("UserId", sessionManager.getSessionUserId());
//            jo.put("AccessToken", sessionManager.getSessionDeviceToken());
//
//            Log.i(PreventiveMaintenanceDashboard.class.getName(), Constants.hototTicketList + "\n\n" + jo.toString());
//
//            GsonRequest<SitePMTicketsList> getAssignAvailabilityLearnersListRequest = new GsonRequest<>(Request.Method.POST, Constants.sitePmTicketList, jo.toString(), SitePMTicketsList.class,
//                    new Response.Listener<SitePMTicketsList>() {
//                        @Override
//                        public void onResponse(@NonNull SitePMTicketsList response) {
//                            hideBusyProgress();
//                            if (response.getError() != null) {
//                                showToast(response.getError().getErrorMessage());
//                            } else {
//                                if (response.getSuccess() == 1) {
//                                    sitePMTicketsList = response;
//                                    if (sitePMTicketsList.getSitePMTicketSummary() != null) {
//                                        mAcPreventiveMaintenanceSectionTextViewName.setText(sitePMTicketsList.getSitePMTicketSummary().getOpenTickets() == null || sitePMTicketsList.getSitePMTicketSummary().getOpenTickets().isEmpty() ? "0" : sitePMTicketsList.getSitePMTicketSummary().getOpenTickets().toString());
//                                        mAcPreventiveMaintenanceSectionTextViewName2.setText(sitePMTicketsList.getSitePMTicketSummary().getTotalTickets() == null || sitePMTicketsList.getSitePMTicketSummary().getTotalTickets().isEmpty() ? "0" : sitePMTicketsList.getSitePMTicketSummary().getTotalTickets().toString());
//
//                                        *//*int per = 0;
//                                        double p = 0.0;
//                                        per = sitePMTicketsList.getSitePMTicketSummary().getPercentage() == null ? 0 : sitePMTicketsList.getSitePMTicketSummary().getPercentage();
//                                        p = (3.6) * Double.valueOf(per);
//                                        per = (int) Math.round(p);
//
//                                        wheelprogress.setPercentage(per);
//                                        wheelprogress.setStepCountText(sitePMTicketsList.getSitePMTicketSummary().getPercentage().toString() == null ? "0" : sitePMTicketsList.getSitePMTicketSummary().getPercentage().toString());*//*
//
//                                        double per = 0.0;
//                                        double circlePer = 0.0;
//                                        int roundPer = 0;
//                                        per = sitePMTicketsList.getSitePMTicketSummary().getPercentage();//hotoTicketList.getHotoTicketSummary().getPercentage() == null ? 0.0 :
//                                        circlePer = (3.6) * Double.valueOf(per);
//                                        roundPer = (int) Math.round(circlePer);
//
//                                        DecimalFormat df = new DecimalFormat("###.##");
//                                        df.setRoundingMode(RoundingMode.FLOOR);
//                                        per = new Double(df.format(per));
//
//
//                                        mWheelprogress.setPercentage(roundPer);
//                                        mWheelprogress.setStepCountText(String.valueOf(per));
//
//
//                                    }
//                                    if (sitePMTicketsList.getSitePMTicketsDates() != null && sitePMTicketsList.getSitePMTicketsDates().size() > 0) {
//                                        txtNoTicketFound.setVisibility(View.GONE);
//                                        pmSiteList_listView_siteacList.setVisibility(View.VISIBLE);
//                                        pmSiteExpListAdapter = new PmSiteExpListAdapter(AcPreventiveMaintenanceDashboardActivity.this, sitePMTicketsList);
//                                        pmSiteList_listView_siteacList.setAdapter(pmSiteExpListAdapter);
//                                        for (int i = 0; i < sitePMTicketsList.getSitePMTicketsDates().size(); i++) {
//                                            pmSiteList_listView_siteacList.expandGroup(i);
//                                        }
//                                    } else {
//                                        pmSiteList_listView_siteacList.setVisibility(View.GONE);
//                                        txtNoTicketFound.setVisibility(View.VISIBLE);
//                                    }
//                                }
//                            }
//                        }
//                    }, new Response.ErrorListener()
//
//            {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    hideBusyProgress();
//
//                }
//            });
//            getAssignAvailabilityLearnersListRequest.setRetryPolicy(Application.getDefaultRetryPolice());
//            getAssignAvailabilityLearnersListRequest.setShouldCache(false);
//            Application.getInstance().
//
//                    addToRequestQueue(getAssignAvailabilityLearnersListRequest, "assignavailabilitylearnerslist");
//
//        } catch (JSONException e) {
//            hideBusyProgress();
//            showToast("Something went wrong. Please try again later.");
//        }
//
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_PM_SITE_SUBMIT && resultCode == RESULT_OK) {
            // prepareListData();
            //onBackPressed();
            //returnValueFromFieldEngineerForm = data.getStringExtra("returnValue");
            /*if(returnValueFromFieldEngineerForm.equals("WIP")){
                mPriventiveMaintenanceSiteLinearLayoutTicket2.setEnabled(false);
                mPriventiveMaintenanceSiteLinearLayoutTicket2.setBackgroundColor(ContextCompat.getColor(mContext,R.color.yellow));
            }*/

        }
    }



}

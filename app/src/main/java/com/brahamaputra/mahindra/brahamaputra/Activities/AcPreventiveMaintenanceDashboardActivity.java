package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.progresviews.ProgressWheel;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GPSTracker;

public class AcPreventiveMaintenanceDashboardActivity extends AppCompatActivity {
    private LinearLayout mLinearLayoutStatus;
    private ProgressWheel mWheelprogress;
    private LinearLayout mLinearLayoutContainer1;
    private LinearLayout mPriventiveMaintenanceSiteLinearLayoutTicket1;
    private LinearLayout mPriventiveMaintenanceSiteLinearLayoutTicket2;
    private TextView mAcPreventiveMaintenanceSectionTextViewName;
    private TextView mAcPreventiveMaintenanceSectionTextViewNo;
    private ImageView mAcPreventiveMaintenanceSectionImageViewStatus;
    private LinearLayout mLinearLayoutContainer2;
    private TextView mAcPreventiveMaintenanceSectionTextViewName2;
    private TextView mAcPreventiveMaintenanceSectionTextViewNo2;
    private ImageView mAcPreventiveMaintenanceSectionImageViewStatus2;
    private TextView mTextViewHotoName;
    private TextView mTextViewSiteID;
    private TextView mTextViewSiteName;
    private TextView mTextViewSiteSSA;
    private TextView mTextViewSiteAddress;
    private TextView mTextViewHotoName1;
    private TextView mTextViewSiteID1;
    private TextView mTextViewSiteName1;
    private TextView mTextViewSiteSSA1;
    private TextView mTextViewSiteAddress1;

    public GPSTracker gpsTracker;
    private AlertDialogManager alertDialogManager;
    private SessionManager sessionManager;
    public static final int RESULT_PM_SITE_SUBMIT = 257;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_preventive_maintenance_dashboard);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("AC Preventive Maintenance");
        assignViews();
        sessionManager = new SessionManager(AcPreventiveMaintenanceDashboardActivity.this);
        setListner();
    }

    private void assignViews() {
        mLinearLayoutStatus = (LinearLayout) findViewById(R.id.linearLayout_Status);
        mWheelprogress = (ProgressWheel) findViewById(R.id.wheelprogress);
        mLinearLayoutContainer1 = (LinearLayout) findViewById(R.id.linearLayout_container1);
        mAcPreventiveMaintenanceSectionTextViewName = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_name);
        mAcPreventiveMaintenanceSectionTextViewNo = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_no);
        //mAcPreventiveMaintenanceSectionImageViewStatus = (ImageView) findViewById(R.id.acPreventiveMaintenanceSection_imageView_status);
        mLinearLayoutContainer2 = (LinearLayout) findViewById(R.id.linearLayout_container2);
        mPriventiveMaintenanceSiteLinearLayoutTicket1 = (LinearLayout) findViewById(R.id.pmSiteDashboard_linearLayout_ticket1);
        mPriventiveMaintenanceSiteLinearLayoutTicket2 = (LinearLayout) findViewById(R.id.pmSiteDashboard_linearLayout_ticket2);
        mAcPreventiveMaintenanceSectionTextViewName2 = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_name2);
        mAcPreventiveMaintenanceSectionTextViewNo2 = (TextView) findViewById(R.id.acPreventiveMaintenanceSection_textView_no2);
        //mAcPreventiveMaintenanceSectionImageViewStatus2 = (ImageView) findViewById(R.id.acPreventiveMaintenanceSection_imageView_status2);
        mTextViewHotoName = (TextView) findViewById(R.id.textView_HotoName);
        mTextViewSiteID = (TextView) findViewById(R.id.textView_SiteID);
        mTextViewSiteName = (TextView) findViewById(R.id.textView_SiteName);
        mTextViewSiteSSA = (TextView) findViewById(R.id.textView_SiteSSA);
        mTextViewSiteAddress = (TextView) findViewById(R.id.textView_SiteAddress);
        mTextViewHotoName1 = (TextView) findViewById(R.id.textView_HotoName1);
        mTextViewSiteID1 = (TextView) findViewById(R.id.textView_SiteID1);
        mTextViewSiteName1 = (TextView) findViewById(R.id.textView_SiteName1);
        mTextViewSiteSSA1 = (TextView) findViewById(R.id.textView_SiteSSA1);
        mTextViewSiteAddress1 = (TextView) findViewById(R.id.textView_SiteAddress1);

        gpsTracker = new GPSTracker(AcPreventiveMaintenanceDashboardActivity.this);
        alertDialogManager = new AlertDialogManager(AcPreventiveMaintenanceDashboardActivity.this);
    }

    private void setListner() {

        mPriventiveMaintenanceSiteLinearLayoutTicket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialogManager.Dialog("Information", "Do you want to proceed doing AC PM?", "Ok", "No", new AlertDialogManager.onSingleButtonClickListner() {
                    @Override
                    public void onPositiveClick() {
                        openTicket1();
                    }
                }).show();

            }
        });

        mPriventiveMaintenanceSiteLinearLayoutTicket2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialogManager.Dialog("Information", "Do you want to proceed doing AC PM?", "Ok", "No", new AlertDialogManager.onSingleButtonClickListner() {
                    @Override
                    public void onPositiveClick() {
                        openTicket2();
                    }
                }).show();
            }
        });
    }
    private void openTicket2(){
        if (Conditions.isNetworkConnected(AcPreventiveMaintenanceDashboardActivity.this)) {
            if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                Intent intent = new Intent(AcPreventiveMaintenanceDashboardActivity.this, AcPreventiveMaintenanceSectionsListActivity.class);
                intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(AcPreventiveMaintenanceDashboardActivity.this));
                intent.putExtra("ticketNO", "SIKL19019999");
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

    private void openTicket1(){
        if (Conditions.isNetworkConnected(AcPreventiveMaintenanceDashboardActivity.this)) {
            if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                Intent intent = new Intent(AcPreventiveMaintenanceDashboardActivity.this, AcPreventiveMaintenanceSectionsListActivity.class);
                intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(AcPreventiveMaintenanceDashboardActivity.this));
                intent.putExtra("ticketNO", "SIKL19012222");
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
}

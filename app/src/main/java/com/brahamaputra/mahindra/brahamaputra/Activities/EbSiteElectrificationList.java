package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Adapters.EbSiteElectrificationExpListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationTicketList;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GPSTracker;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_Selected_SiteType;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_nameOfSupplyCompany;

import org.json.JSONException;
import org.json.JSONObject;

public class EbSiteElectrificationList extends BaseActivity {

    private EbSiteElectrificationExpListAdapter ebSiteElectrificationExpListAdapter;
    public ExpandableListView ebSiteElectrificationList_listView_ebList;
    private AlertDialogManager alertDialogManager;
    private SessionManager sessionManager;
    private EbSiteElectrificationTicketList ebSiteElectrificationTicketList;
    public GPSTracker gpsTracker;

    /////////////////////////
    public static final int RESULT_EbSiteElectrification_SUBMIT = 257;
    private TextView txtNoTicketFound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb_site_electrification_list);
        this.setTitle("Site Electrification");
        ebSiteElectrificationTicketList = new EbSiteElectrificationTicketList();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ebSiteElectrificationList_listView_ebList = (ExpandableListView) findViewById(R.id.listViewEbSiteElectrification);
        txtNoTicketFound = (TextView) findViewById(R.id.txtNoTicketFound);
        txtNoTicketFound.setVisibility(View.GONE);

        alertDialogManager = new AlertDialogManager(EbSiteElectrificationList.this);
        sessionManager = new SessionManager(EbSiteElectrificationList.this);
        gpsTracker = new GPSTracker(EbSiteElectrificationList.this);
        if (gpsTracker.canGetLocation()) {
            Log.e(UserHotoTransactionActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
        }

        prepareListData();


        ebSiteElectrificationList_listView_ebList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                ebSiteElectrificationList_listView_ebList.expandGroup(groupPosition);
                return true;
            }
        });
        ebSiteElectrificationList_listView_ebList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, final int childPosition, long id) {
                // notify user

                LocationManager lm = (LocationManager) EbSiteElectrificationList.this.getSystemService(Context.LOCATION_SERVICE);
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
                            EbSiteElectrificationList.this.startActivity(myIntent);
                        }
                    }).show();
                } else {
                    if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                        if (ebSiteElectrificationTicketList != null) {
                            final String hotoTicketId = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getId().toString();
                            final String hotoTicketNo = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getEbSiteElectrificationTicketNo().toString();

                            final String hotoTicketDate = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getEbSiteElectrificationTicketNo().toString();
                            final String siteId = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getSiteId().toString();
                            final String siteName = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getSiteName().toString();
                            final String siteAddress = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getSiteAddress().toString();
                            final String status = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getStatus().toString();
                            final String siteType = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getSiteType().toString();
                            final String stateName = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getStateName().toString();
                            final String customerName = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getCustomerName().toString();
                            final String circleName = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getCircleName().toString();
                            final String ssaName = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getSsaName().toString();
                            hototicket_Selected_SiteType = siteType;

                            String hotoTickStatus = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getStatus().toString();
                            hototicket_nameOfSupplyCompany = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getNameOfSupplyCompany().toString();

                            if (hotoTickStatus.equals("Open") || hotoTickStatus.equals("WIP") || hotoTickStatus.equals("Reassigned")) {
                                if (hotoTickStatus.equals("Open")) {

                                    alertDialogManager.Dialog("Information", "Do you want to proceed.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                                        @Override
                                        public void onPositiveClick() {
                                            checkSystemLocation(hotoTicketNo, hotoTicketId, hotoTicketDate, siteId, siteName, siteAddress, status, siteType,
                                                    stateName, customerName, circleName, ssaName);
                                        }
                                    }).show();
                                } else {
                                    checkSystemLocation(hotoTicketNo, hotoTicketId, hotoTicketDate, siteId, siteName, siteAddress, status, siteType,
                                            stateName, customerName, circleName, ssaName);
                                }

                            }
                        }

                    } else {
                        //showToast("Could not detecting location. Please try again later.");
                        alertDialogManager.Dialog("Information", "Could not get your location. Please try again.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                            @Override
                            public void onPositiveClick() {
                                if (gpsTracker.canGetLocation()) {
                                    //showToast("Lat : "+gpsTracker.getLatitude()+"\n Long : "+gpsTracker.getLongitude()); comment By 008 on 10-11-2018
                                    Log.e(UserHotoTransactionActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
                                }
                            }
                        }).show();
                    }
                }
                return false;
            }
        });
    }

    /**
     * Load ticket list. Can use for refresh list as same.
     */
    private void prepareListData() {
        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();


            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());

            Log.i(EbSiteElectrificationList.class.getName(), "EbSiteElectrificationTicketList json: \n\n" + jo.toString());

            GsonRequest<EbSiteElectrificationTicketList> getAssignAvailabilityLearnersListRequest = new GsonRequest<>(Request.Method.POST, Constants.hototTicketList, jo.toString(), EbSiteElectrificationTicketList.class,
                    new Response.Listener<EbSiteElectrificationTicketList>() {
                        @Override
                        public void onResponse(@NonNull EbSiteElectrificationTicketList response) {
                            hideBusyProgress();
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                if (response.getSuccess() == 1) {
                                    ebSiteElectrificationTicketList = response;
                                    if (ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction() != null && ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().size() > 0) {
                                        txtNoTicketFound.setVisibility(View.GONE);
                                        ebSiteElectrificationList_listView_ebList.setVisibility(View.VISIBLE);
                                        ebSiteElectrificationExpListAdapter = new EbSiteElectrificationExpListAdapter(EbSiteElectrificationList.this, ebSiteElectrificationTicketList);
                                        ebSiteElectrificationList_listView_ebList.setAdapter(ebSiteElectrificationExpListAdapter);
                                        for (int i = 0; i < ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().size(); i++) {
                                            ebSiteElectrificationList_listView_ebList.expandGroup(i);
                                        }
                                    } else {
                                        ebSiteElectrificationList_listView_ebList.setVisibility(View.GONE);
                                        txtNoTicketFound.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    hideBusyProgress();

                }
            });
            getAssignAvailabilityLearnersListRequest.setRetryPolicy(Application.getDefaultRetryPolice());
            getAssignAvailabilityLearnersListRequest.setShouldCache(false);
            Application.getInstance().addToRequestQueue(getAssignAvailabilityLearnersListRequest, "assignavailabilitylearnerslist");

        } catch (JSONException e) {
            hideBusyProgress();
            showToast("Something went wrong. Please try again later.");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.refresh_icon_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menuRefresh:
                prepareListData();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_EbSiteElectrification_SUBMIT && resultCode == RESULT_OK) {
            prepareListData();
        }
    }

    public void checkSystemLocation(final String hotoTickitNo, final String hotoTicketId, String hotoTicketDate, String siteId,
                                    String siteName, String siteAddress, String status, String siteType, String stateName,
                                    String customerName, String circleName, String ssaName) {

        LocationManager lm = (LocationManager) EbSiteElectrificationList.this.getSystemService(Context.LOCATION_SERVICE);
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
                    EbSiteElectrificationList.this.startActivity(myIntent);
                }
            }).show();
        } else {
            if (Conditions.isNetworkConnected(EbSiteElectrificationList.this)) {
                //if (gpsTracker.getLongitude()>0 && gpsTracker.getLongitude()>0){

                Intent intent = new Intent(EbSiteElectrificationList.this, UserHotoTransactionActivity.class);////////////
                intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(EbSiteElectrificationList.this));
                intent.putExtra("Id", hotoTicketId);

                intent.putExtra("ticketNO", hotoTickitNo);

                intent.putExtra("hotoTicketDate", hotoTicketDate);
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

                //sessionManager.updateSessionUserTicketId(hotoTicketId);
                //sessionManager.updateSessionUserTicketName(hotoTickitNo);
                startActivityForResult(intent, RESULT_EbSiteElectrification_SUBMIT);

                //}else{
                //    showToast("Sorry could not detect location");
                //    finish();
                //}

            } else {
                alertDialogManager.Dialog("Information", "Device has no internet connection. Do you want to use offline mode?", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                    @Override
                    public void onPositiveClick() {
                        Intent intent = new Intent(EbSiteElectrificationList.this, UserHotoTransactionActivity.class);//////
                        intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(EbSiteElectrificationList.this));
                        intent.putExtra("ticketNO", hotoTickitNo);
                        //sessionManager.updateSessionUserTicketId(hotoTicketId);
                        //sessionManager.updateSessionUserTicketName(hotoTickitNo);
                        startActivityForResult(intent, RESULT_EbSiteElectrification_SUBMIT);
                    }
                }).show();
            }
        }
    }
}


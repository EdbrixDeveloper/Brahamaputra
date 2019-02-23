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
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Adapters.DieselFillingFundRequestListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Adapters.EbSiteElectrificationExpListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Adapters.EbSiteElectrificationTicketListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.DieselFillingFundRequestTransaction;
import com.brahamaputra.mahindra.brahamaputra.Data.DiselRequestTransactionList;
import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationTicketList;
import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationTransaction;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.EndlessScrollListener;
import com.brahamaputra.mahindra.brahamaputra.commons.GPSTracker;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_Selected_SiteType;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_nameOfSupplyCompany;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.ebSiteElectrificationConsumerNumber;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.ebSiteElectrificationEbMeterSerialNumber;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EbSiteElectrificationList extends BaseActivity {
    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "";
    private String ticketName = "";
    private String ticketId = "";

    private EbSiteElectrificationTicketList ebSiteElectrificationTicketList;
    private EbSiteElectrificationTransaction ebSiteElectrificationTransaction;
    private EbSiteElectrificationTicketListAdapter ebSiteElectrificationTicketListAdapter;

    private ListView ebSiteElectrificationList_listView_ebList;
    private TextView mTxtNoTicketFound;


    /////////

    private AlertDialogManager alertDialogManager;
    private SessionManager sessionManager;
    public GPSTracker gpsTracker;
    public static final int RESULT_EbSiteElectrification_SUBMIT = 257;
    private LinearLayout TempForTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb_site_electrification_list);
        this.setTitle("Site Electrification");
        ebSiteElectrificationTicketList = new EbSiteElectrificationTicketList();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        alertDialogManager = new AlertDialogManager(EbSiteElectrificationList.this);
        sessionManager = new SessionManager(EbSiteElectrificationList.this);
        gpsTracker = new GPSTracker(EbSiteElectrificationList.this);

        assignViews();
        mTxtNoTicketFound.setVisibility(View.GONE);
        TempForTest = (LinearLayout) findViewById(R.id.linearLayout_Temp_EbSiteElectrificationTicket);

        if (gpsTracker.canGetLocation()) {
            Log.e(EbSiteElectrificationTransactionActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
        }

        //prepareListData();
        TempForTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gpsTracker.canGetLocation()) {
                    Intent intent = new Intent(EbSiteElectrificationList.this, EbSiteElectrificationTransactionActivity.class);////////////
                    intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(EbSiteElectrificationList.this));
                    intent.putExtra("Id", "52");

                    intent.putExtra("ticketNO", "EBSE1100096");
                    intent.putExtra("ebSiteElectrificationTicketDate", "");
                    intent.putExtra("siteId", "site 2992");
                    intent.putExtra("siteName", "SM Site 2992");
                    intent.putExtra("siteAddress", "Plot No.213, Whites Road, Royapettah, Jammu, Jammu Kashmir, 600014");
                    intent.putExtra("status", "WIP");
                    intent.putExtra("siteType", "Outdoor");
                    intent.putExtra("stateName", "JAMMU & KASHMIR");
                    intent.putExtra("customerName", "BSNL");
                    intent.putExtra("circleName", "JAMMU & KASHMIR");
                    intent.putExtra("ssaName", "Jammu");
                    intent.putExtra("latitude", String.valueOf(gpsTracker.getLatitude()));
                    intent.putExtra("longitude", String.valueOf(gpsTracker.getLongitude()));

                    sessionManager.updateSessionUserTicketId("52");
                    sessionManager.updateSessionUserTicketName("EBSE1100096");
                    startActivityForResult(intent, RESULT_EbSiteElectrification_SUBMIT);

                }
            }
        });


        ebSiteElectrificationList_listView_ebList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int groupPosition, long id) {

///////
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
                            final String ebSiteElectrificationTicketId = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getId().toString();
                            final String ebSiteElectrificationTicketNo = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationTicketNo().toString();

                            final String ebSiteElectrificationTicketDate = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationTicketNo().toString();
                            final String siteId = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getSiteId().toString();
                            final String siteName = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getSiteName().toString();
                            final String siteAddress = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getSiteAddress().toString();
                            final String status = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getStatus().toString();
                            final String siteType = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getSiteType().toString();
                            final String stateName = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getStateName().toString();
                            final String customerName = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getCustomerName().toString();
                            final String circleName = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getCircleName().toString();
                            final String ssaName = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getSsaName().toString();
                            hototicket_Selected_SiteType = siteType;

                            String ebSiteElectrificationTickStatus = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getStatus().toString();
                            hototicket_nameOfSupplyCompany = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getNameOfSupplyCompany().toString();

                            String consumerNumber = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getConsumerNumber().toString();
                            ebSiteElectrificationConsumerNumber = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getConsumerNumber().toString();

                            String ebMeterSerialNumber = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getStatus().toString();
                            ebSiteElectrificationEbMeterSerialNumber = ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getNameOfSupplyCompany().toString();

                            if (ebSiteElectrificationTickStatus.equals("Open") || ebSiteElectrificationTickStatus.equals("WIP") || ebSiteElectrificationTickStatus.equals("Reassigned")) {
                                if (ebSiteElectrificationTickStatus.equals("Open")) {

                                    alertDialogManager.Dialog("Information", "Do you want to proceed.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                                        @Override
                                        public void onPositiveClick() {
                                            checkSystemLocation(ebSiteElectrificationTicketNo, ebSiteElectrificationTicketId, ebSiteElectrificationTicketDate, siteId, siteName, siteAddress, status, siteType,
                                                    stateName, customerName, circleName, ssaName);
                                        }
                                    }).show();
                                } else {
                                    checkSystemLocation(ebSiteElectrificationTicketNo, ebSiteElectrificationTicketId, ebSiteElectrificationTicketDate, siteId, siteName, siteAddress, status, siteType,
                                            stateName, customerName, circleName, ssaName);
                                }

                            }
                        }

                    } else {
                        alertDialogManager.Dialog("Information", "Could not get your location. Please try again.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                            @Override
                            public void onPositiveClick() {
                                if (gpsTracker.canGetLocation()) {
                                    Log.e(EbSiteElectrificationTransactionActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
                                }
                            }
                        }).show();
                    }
                }


///////

            }
        });


    }

    private void assignViews() {
        ebSiteElectrificationList_listView_ebList = (ListView) findViewById(R.id.listViewEbSiteElectrification);
        mTxtNoTicketFound = (TextView) findViewById(R.id.txtNoTicketFound);
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

    private void prepareListData() {
        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();

            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());

            GsonRequest<EbSiteElectrificationTicketList> ebSiteElectrificationTicketListRequest = new GsonRequest<>(Request.Method.POST, Constants.getuserdieselrequestticketlist, jo.toString(), EbSiteElectrificationTicketList.class,
                    new Response.Listener<EbSiteElectrificationTicketList>() {
                        @Override
                        public void onResponse(@NonNull EbSiteElectrificationTicketList response) {
                            hideBusyProgress();
                            //showToast(""+response.getSuccess().toString());
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                if (response.getSuccess() == 1) {
                                    ebSiteElectrificationTicketList = response;
                                    if (ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction() != null && ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().size() > 0) {
                                        mTxtNoTicketFound.setVisibility(View.GONE);
                                        ebSiteElectrificationList_listView_ebList.setVisibility(View.VISIBLE);
                                        ArrayList<EbSiteElectrificationTransaction> dd = new ArrayList<EbSiteElectrificationTransaction>(ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().size());
                                        dd.addAll(ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction());
                                        ebSiteElectrificationTicketListAdapter = new EbSiteElectrificationTicketListAdapter(dd, EbSiteElectrificationList.this);
                                        ebSiteElectrificationList_listView_ebList.setAdapter(ebSiteElectrificationTicketListAdapter);

                                    } else {
                                        ebSiteElectrificationList_listView_ebList.setVisibility(View.GONE);
                                        mTxtNoTicketFound.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error.getMessage().contains("java.net.UnknownHostException")) {
                        showToast("No Internet Connection.");
                    }
                    hideBusyProgress();

                }
            });
            ebSiteElectrificationTicketListRequest.setRetryPolicy(Application.getDefaultRetryPolice());
            ebSiteElectrificationTicketListRequest.setShouldCache(false);
            Application.getInstance().addToRequestQueue(ebSiteElectrificationTicketListRequest, "ebSiteElectrificationTicketListRequest");

        } catch (JSONException e) {
            hideBusyProgress();
            showToast("Something went wrong. Please try again later.");
        }
    }


    public void checkSystemLocation(final String ebSiteElectrificationTickitNo, final String ebSiteElectrificationTicketId, String ebSiteElectrificationTicketDate, String siteId,
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

                Intent intent = new Intent(EbSiteElectrificationList.this, EbSiteElectrificationTransactionActivity.class);////////////
                intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(EbSiteElectrificationList.this));
                intent.putExtra("Id", ebSiteElectrificationTicketId);
                intent.putExtra("ticketNO", ebSiteElectrificationTickitNo);
                intent.putExtra("ebSiteElectrificationTicketDate", ebSiteElectrificationTicketDate);
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

                sessionManager.updateSessionUserTicketId(ebSiteElectrificationTicketId);
                sessionManager.updateSessionUserTicketName(ebSiteElectrificationTickitNo);
                startActivityForResult(intent, RESULT_EbSiteElectrification_SUBMIT);

                //}else{
                //    showToast("Sorry could not detect location");
                //    finish();
                //}

            } else {
                alertDialogManager.Dialog("Information", "Device has no internet connection. Turn on internet", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                    @Override
                    public void onPositiveClick() {
                        finish();
                    }
                }).show();
            }
        }
    }

}

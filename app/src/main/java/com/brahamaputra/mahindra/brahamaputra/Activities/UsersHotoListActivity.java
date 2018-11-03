package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ExpandableListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Adapters.UserHotoExpListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Adapters.UserHotoListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTicketsDate;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTicket;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTicketList;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsersHotoListActivity extends BaseActivity {

    private UserHotoListAdapter mAdapter;
    private UserHotoExpListAdapter userHotoExpListAdapter;
    public ExpandableListView userHotoList_listView_hotoList;
    private List<HotoTicketsDate> HotoTicketsDates;
    private HashMap<Object, List<HotoTicket>> HotoTicketMap;
    private AlertDialogManager alertDialogManager;

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_hoto_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        userHotoList_listView_hotoList = (ExpandableListView) findViewById(R.id.userHotoList_listView_hotoList);

        alertDialogManager = new AlertDialogManager(UsersHotoListActivity.this);
        sessionManager = new SessionManager(UsersHotoListActivity.this);

        prepareListData();


        userHotoList_listView_hotoList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                userHotoList_listView_hotoList.expandGroup(groupPosition);
                return true;
            }
        });
        userHotoList_listView_hotoList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, final int childPosition, long id) {
                // notify user

                String hotoTickitNo = HotoTicketMap.get(HotoTicketsDates.get(groupPosition)).get(childPosition).getHotoTicketNo().toString();
                String hotoTicketId = HotoTicketMap.get(HotoTicketsDates.get(groupPosition)).get(childPosition).getId().toString();

                String hotoTickStatus = HotoTicketMap.get(HotoTicketsDates.get(groupPosition)).get(childPosition).getStatus().toString();
                if(hotoTickStatus.equals("Open")){
                    checkSystemLocation(hotoTickitNo,hotoTicketId);
                }
                return false;
            }
        });
    }


    private void prepareListData() {
        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();

            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());

            Log.i (UsersHotoListActivity.class.getName(),Constants.hototTicketList+"\n\n"+jo.toString());

            GsonRequest<HotoTicketList> getAssignAvailabilityLearnersListRequest = new GsonRequest<>(Request.Method.POST, Constants.hototTicketList, jo.toString(), HotoTicketList.class,
                    new Response.Listener<HotoTicketList>() {
                        @Override
                        public void onResponse(@NonNull HotoTicketList response) {
                            hideBusyProgress();
                            //showToast(""+response.getSuccess().toString());
                            if(response.getSuccess() == 1){

                                HotoTicketsDates = new ArrayList<>();
                                HotoTicketMap = new HashMap<Object, List<HotoTicket>>();
                                //showToast(""+response.getHotoTicketsDates().size());
                                for(int i=0;i<response.getHotoTicketsDates().size();i++) {

                                    List<HotoTicket> header = new ArrayList<HotoTicket>();
                                    for(int j =0;j<response.getHotoTicketsDates().get(i).getHotoTickets().size();j++) {
                                        header.add(new HotoTicket(response.getHotoTicketsDates().get(i).getHotoTickets().get(i).getId(),
                                                response.getHotoTicketsDates().get(i).getHotoTickets().get(i).getHotoTicketNo(),
                                                response.getHotoTicketsDates().get(i).getHotoTickets().get(i).getHotoTicketDate(),
                                                response.getHotoTicketsDates().get(i).getHotoTickets().get(i).getSiteId(),
                                                response.getHotoTicketsDates().get(i).getHotoTickets().get(i).getSiteName(),
                                                response.getHotoTicketsDates().get(i).getHotoTickets().get(i).getSiteAddress(),
                                                response.getHotoTicketsDates().get(i).getHotoTickets().get(i).getStatus()));
                                    }
                                    //HotoTicketsDates.add(new HotoTicketsDate("26 Oct 2018", ""+header.size()));

                                    HotoTicketsDates.add(new HotoTicketsDate(response.getHotoTicketsDates().get(i).getDate(),
                                            Integer.parseInt(response.getHotoTicketsDates().get(i).getHotoTicketCount().toString()),
                                            response.getHotoTicketsDates().get(i).getHotoTickets() ));

                                    HotoTicketMap.put(HotoTicketsDates.get(i), header);
                                }
                                userHotoExpListAdapter = new UserHotoExpListAdapter(UsersHotoListActivity.this,HotoTicketsDates,HotoTicketMap);
                                userHotoList_listView_hotoList.setAdapter(userHotoExpListAdapter);

                                for(int i=0; i<HotoTicketsDates.size();i++){
                                    userHotoList_listView_hotoList.expandGroup(i);
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


       /* HotoTicketsDates = new ArrayList<>();
        HotoTicketMap = new HashMap<Object, List<HotoTicket>>();

        // Adding child data
        List<HotoTicket> header1  = new ArrayList<HotoTicket>();
        header1.add(new HotoTicket("TKT_26_121","Closed"));
        header1.add(new HotoTicket("TKT_26_122","Closed"));
        header1.add(new HotoTicket("TKT_26_123","Open"));
        HotoTicketsDates.add(new HotoTicketsDate("26 Oct 2018", ""+header1.size()));

        List<HotoTicket> header2  = new ArrayList<HotoTicket>();
        header2.add(new HotoTicket("TKT_27_131","Closed"));
        header2.add(new HotoTicket("TKT_27_132","Closed"));
        header2.add(new HotoTicket("TKT_27_133","Closed"));
        header2.add(new HotoTicket("TKT_27_134","Closed"));
        header2.add(new HotoTicket("TKT_27_135","Closed"));
        HotoTicketsDates.add(new HotoTicketsDate("27 Oct 2018", ""+header2.size()));

        List<HotoTicket> header3  = new ArrayList<HotoTicket>();
        header3.add(new HotoTicket("TKT_28_121","Closed"));
        header3.add(new HotoTicket("TKT_28_122","Closed"));
        header3.add(new HotoTicket("TKT_28_123","Closed"));
        HotoTicketsDates.add(new HotoTicketsDate("28 Oct 2018", ""+header3.size()));

        List<HotoTicket> header4  = new ArrayList<HotoTicket>();
        header4.add(new HotoTicket("TKT_29_121","Closed"));
        header4.add(new HotoTicket("TKT_29_122","Closed"));
        header4.add(new HotoTicket("TKT_29_123","Closed"));
        header4.add(new HotoTicket("TKT_29_124","Closed"));
        HotoTicketsDates.add(new HotoTicketsDate("29 Oct 2018", ""+header4.size()));

        HotoTicketMap.put(HotoTicketsDates.get(0), header1); // Header, Child data
        HotoTicketMap.put(HotoTicketsDates.get(1), header2);
        HotoTicketMap.put(HotoTicketsDates.get(2), header3);
        HotoTicketMap.put(HotoTicketsDates.get(3), header4);

        userHotoExpListAdapter = new UserHotoExpListAdapter(UsersHotoListActivity.this,HotoTicketsDates,HotoTicketMap);

        userHotoList_listView_hotoList.setAdapter(userHotoExpListAdapter);

        for(int i=0; i<HotoTicketsDates.size();i++){
            userHotoList_listView_hotoList.expandGroup(i);
        }*/
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

    public void checkSystemLocation(final String hotoTickitNo, final String hotoTicketId){
        LocationManager lm = (LocationManager)UsersHotoListActivity.this.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch(Exception ex) {}

        if(!gps_enabled && !network_enabled) {
            // notify user
            alertDialogManager.Dialog("Information", "Location is not enabled. Do you want to enable?", "ok", "cancel",new AlertDialogManager.onSingleButtonClickListner() {
                @Override
                public void onPositiveClick() {
                    Intent myIntent = new Intent( Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    UsersHotoListActivity.this.startActivity(myIntent);
                }
            }).show();
        }
        else{
            if(Conditions.isNetworkConnected(UsersHotoListActivity.this)){
                Intent intent = new Intent(UsersHotoListActivity.this, UserHotoTransactionActivity.class);
                intent.putExtra("ticketID",hotoTickitNo);
                intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(UsersHotoListActivity.this));
                intent.putExtra("ticketID",hotoTickitNo);
                sessionManager.updateSessionUserTicketId(hotoTicketId);
                startActivity(intent);
            }else{
                alertDialogManager.Dialog("Information", "Device has no internet connection. Do you want to use offline mode?", "ok", "cancel",  new AlertDialogManager.onSingleButtonClickListner() {
                    @Override
                    public void onPositiveClick() {
                        Intent intent = new Intent(UsersHotoListActivity.this, UserHotoTransactionActivity.class);
                        intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(UsersHotoListActivity.this));
                        intent.putExtra("ticketID",hotoTickitNo);
                        sessionManager.updateSessionUserTicketId(hotoTicketId);
                        startActivity(intent);
                    }
                }).show();
            }
        }
    }
}

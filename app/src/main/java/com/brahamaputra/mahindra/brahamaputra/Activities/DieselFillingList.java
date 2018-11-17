package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Adapters.DieselTrasactionAdapter;
import com.brahamaputra.mahindra.brahamaputra.Adapters.UserHotoExpListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.ACDB_DCDB_Data;
import com.brahamaputra.mahindra.brahamaputra.Data.DieselFillingtransaction;
import com.brahamaputra.mahindra.brahamaputra.Data.DiselFillingTransactionList;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTicketList;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class DieselFillingList extends BaseActivity {


    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "";
    private String ticketName = "";
    private String ticketId = "";
    private DieselFillingtransaction dieselFillingtransaction;
    private SessionManager sessionManager;

    private ListView mDieselFillingListListViewTickets;
    private TextView mTxtNoTicketFound;
    private AlertDialogManager alertDialogManager;
    private DieselTrasactionAdapter dieselTrasactionAdapter;
    public static final int RESULT_TRAN_SUBMIT = 259;
    private void assignViews() {
        mDieselFillingListListViewTickets = (ListView) findViewById(R.id.listViewDiesel);
        mTxtNoTicketFound = (TextView) findViewById(R.id.txtNoTicketFound);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diesel_filling_list);
        this.setTitle("Diesel Filling Tickets");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        alertDialogManager = new AlertDialogManager(DieselFillingList.this);
        sessionManager = new SessionManager(DieselFillingList.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(DieselFillingList.this, userId, ticketName);
        dieselFillingtransaction=new DieselFillingtransaction();
        assignViews();
        prepareListData();


    }

    private void prepareListData() {
        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();

            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());


            GsonRequest<DieselFillingtransaction> dieselFillingtransactionRequest = new GsonRequest<>(Request.Method.POST, Constants.Getdieseltransactionticketlist, jo.toString(), DieselFillingtransaction.class,
                    new Response.Listener<DieselFillingtransaction>() {
                        @Override
                        public void onResponse(@NonNull DieselFillingtransaction response) {
                            hideBusyProgress();
                            //showToast(""+response.getSuccess().toString());
                            if (response.getSuccess() == 1) {
                                dieselFillingtransaction = response;
                                if (dieselFillingtransaction.getDiselFillingTransactionList() != null && dieselFillingtransaction.getDiselFillingTransactionList().size() > 0) {
                                    mTxtNoTicketFound.setVisibility(View.GONE);
                                    mDieselFillingListListViewTickets.setVisibility(View.VISIBLE);
                                    ArrayList<DiselFillingTransactionList> dd=new ArrayList<DiselFillingTransactionList>(dieselFillingtransaction.getDiselFillingTransactionList().size());
                                    dd.addAll(dieselFillingtransaction.getDiselFillingTransactionList());
                                    dieselTrasactionAdapter = new DieselTrasactionAdapter( dd,DieselFillingList.this);


                                    mDieselFillingListListViewTickets.setAdapter(dieselTrasactionAdapter);
                                   /* for (int i = 0; i < dieselFillingtransaction.getDiselFillingTransactionList().size(); i++) {
                                        mDieselFillingListListViewTickets.expandGroup(i);
                                    }*/
                                } else {
                                    mDieselFillingListListViewTickets.setVisibility(View.GONE);
                                    mTxtNoTicketFound.setVisibility(View.VISIBLE);
                                }


                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    hideBusyProgress();

                }
            });
            dieselFillingtransactionRequest.setRetryPolicy(Application.getDefaultRetryPolice());
            dieselFillingtransactionRequest.setShouldCache(false);
            Application.getInstance().addToRequestQueue(dieselFillingtransactionRequest, "dieselFillingtransactionRequest");

        } catch (JSONException e) {
            hideBusyProgress();
            showToast("Something went wrong. Please try again later.");
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_item_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuAdd:
                /*Intent intent = new Intent(DieselFillingList.this, DieselFilling.class);
                startActivity(intent);*/
                Intent intent = new Intent(DieselFillingList.this, DieselFilling.class);
                startActivityForResult(intent,RESULT_TRAN_SUBMIT);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }

    public void checkNetworkAndLocation() {
        LocationManager lm = (LocationManager) DieselFillingList.this.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;
        boolean internet = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            internet = Conditions.isNetworkConnected(DieselFillingList.this);

            Log.e("ddd:", "" + gps_enabled + "," + network_enabled + "," + internet);
        } catch (Exception ex) {

        }


      /*  if (!gps_enabled && !network_enabled) {
            // notify user
            alertDialogManager.Dialog("Information", "Location is not enabled. Do you want to enable ?", "ok", "cancel and continue", new AlertDialogManager.onTwoButtonClickListner() {
                @Override
                public void onPositiveClick() {
                    Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    DieselFillingList.this.startActivity(myIntent);
                }

                @Override
                public void onNegativeClick() {

                }
            }).show();
        } else {
            if (Conditions.isNetworkConnected(DieselFillingList.this)) {
                Intent intent = new Intent(DieselFillingList.this, DieselFilling.class);
                intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(DieselFillingList.this));
                startActivity(intent);
            } else {

                alertDialogManager.Dialog("Information", "Internet not found,Please enable and try again", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                    @Override
                    public void onPositiveClick() {

                    }
                }).show();

            }

        }*/
    }

   /* public void check1() {
        if (Conditions.isNetworkConnected(DieselFillingList.this)) {
            Intent intent = new Intent(DieselFillingList.this, DieselFilling.class);
            intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(DieselFillingList.this));
            startActivity(intent);
        } else {

            alertDialogManager.Dialog("Information", "Internet not found,Please enable and try again", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                @Override
                public void onPositiveClick() {

                }
            }).show();

        }
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( resultCode == RESULT_OK){
            prepareListData();
        }
    }

}

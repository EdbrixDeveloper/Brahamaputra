package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Adapters.DieselTrasactionAdapter;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.DieselFillingtransaction;
import com.brahamaputra.mahindra.brahamaputra.Data.DiselFillingTransactionList;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ElectricBillProcessList extends BaseActivity {


    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "";
    private String ticketName = "";
    private String ticketId = "";

    private SessionManager sessionManager;


    private TextView mTxtNoTicketFound;
    private AlertDialogManager alertDialogManager;

    public static final int RESULT_TRAN_SUBMIT = 259;

    private void assignViews() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diesel_filling_list);
        this.setTitle("Electric Bill Process Tickets");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        alertDialogManager = new AlertDialogManager(ElectricBillProcessList.this);
        sessionManager = new SessionManager(ElectricBillProcessList.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();


        assignViews();
        prepareListData();


    }

    private void prepareListData() {
       /* try {
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
                                    dieselTrasactionAdapter = new DieselTrasactionAdapter( dd,ElectricBillProcessList.this);


                                    mDieselFillingListListViewTickets.setAdapter(dieselTrasactionAdapter);
                                   *//* for (int i = 0; i < dieselFillingtransaction.getDiselFillingTransactionList().size(); i++) {
                                        mDieselFillingListListViewTickets.expandGroup(i);
                                    }*//*
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
*/

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
                Intent intent = new Intent(ElectricBillProcessList.this, ElectricBillProcess.class);
                startActivityForResult(intent, RESULT_TRAN_SUBMIT);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            prepareListData();
        }
    }

}

package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Adapters.DieselFillingFundRequestListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Adapters.DieselTrasactionAdapter;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.DieselFillingFundRequestTransaction;
import com.brahamaputra.mahindra.brahamaputra.Data.DieselFillingtransaction;
import com.brahamaputra.mahindra.brahamaputra.Data.DiselFillingTransactionList;
import com.brahamaputra.mahindra.brahamaputra.Data.DiselRequestTransactionList;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DieselFillingFundReqestList extends BaseActivity {

    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "";
    private String ticketName = "";
    private String ticketId = "";

    private DieselFillingFundRequestTransaction dieselFillingFundRequestTransaction;
    private SessionManager sessionManager;

    private ListView mDieselFillingReqListListViewTickets;
    private TextView mTxtNoTicketFound;
    private AlertDialogManager alertDialogManager;
    private DieselFillingFundRequestListAdapter dieselFillingFundRequestListAdapter;
    public static final int RESULT_TRAN_SUBMIT = 300;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diesel_filling_fund_reqest_list);
        this.setTitle("Diesel Filling Fund Req Tickets");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        alertDialogManager = new AlertDialogManager(DieselFillingFundReqestList.this);
        sessionManager = new SessionManager(DieselFillingFundReqestList.this);
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(DieselFillingFundReqestList.this, userId, ticketName);
        dieselFillingFundRequestTransaction = new DieselFillingFundRequestTransaction();
        assignViews();
        prepareListData();
    }

    private void assignViews() {
        mDieselFillingReqListListViewTickets = (ListView) findViewById(R.id.listViewDieselReq);
        mTxtNoTicketFound = (TextView) findViewById(R.id.txtNoTicketFound);
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
                /*Intent intent = new Intent(DieselFillingFundReqestList.this, DieselFilling.class);
                startActivity(intent);*/
                Intent intent = new Intent(DieselFillingFundReqestList.this, DieselFillingFundRequest.class);
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

    private void prepareListData() {
        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();

            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());


            GsonRequest<DieselFillingFundRequestTransaction> dieselFillingFundRequestTransactionRequest = new GsonRequest<>(Request.Method.POST, Constants.getuserdieselrequestticketlist, jo.toString(), DieselFillingFundRequestTransaction.class,
                    new Response.Listener<DieselFillingFundRequestTransaction>() {
                        @Override
                        public void onResponse(@NonNull DieselFillingFundRequestTransaction response) {
                            hideBusyProgress();
                            //showToast(""+response.getSuccess().toString());
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                if (response.getSuccess() == 1) {
                                    dieselFillingFundRequestTransaction = response;
                                    if (dieselFillingFundRequestTransaction.getDiselRequestTransactionList() != null && dieselFillingFundRequestTransaction.getDiselRequestTransactionList().size() > 0) {
                                        mTxtNoTicketFound.setVisibility(View.GONE);
                                        mDieselFillingReqListListViewTickets.setVisibility(View.VISIBLE);
                                        ArrayList<DiselRequestTransactionList> dd = new ArrayList<DiselRequestTransactionList>(dieselFillingFundRequestTransaction.getDiselRequestTransactionList().size());
                                        dd.addAll(dieselFillingFundRequestTransaction.getDiselRequestTransactionList());
                                        dieselFillingFundRequestListAdapter = new DieselFillingFundRequestListAdapter(dd, DieselFillingFundReqestList.this);
                                        mDieselFillingReqListListViewTickets.setAdapter(dieselFillingFundRequestListAdapter);

                                    } else {
                                        mDieselFillingReqListListViewTickets.setVisibility(View.GONE);
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
            dieselFillingFundRequestTransactionRequest.setRetryPolicy(Application.getDefaultRetryPolice());
            dieselFillingFundRequestTransactionRequest.setShouldCache(false);
            Application.getInstance().addToRequestQueue(dieselFillingFundRequestTransactionRequest, "dieselFillingFundRequestTransactionRequest");

        } catch (JSONException e) {
            hideBusyProgress();
            showToast("Something went wrong. Please try again later.");
        }


    }
}

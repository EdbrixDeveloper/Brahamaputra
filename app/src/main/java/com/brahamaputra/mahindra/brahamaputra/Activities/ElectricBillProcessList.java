package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Adapters.DieselTrasactionAdapter;
import com.brahamaputra.mahindra.brahamaputra.Adapters.EbProcessTrasactionAdapter;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.DieselFillingtransaction;
import com.brahamaputra.mahindra.brahamaputra.Data.DiselFillingTransactionList;
import com.brahamaputra.mahindra.brahamaputra.Data.EbPaymentRequest;
import com.brahamaputra.mahindra.brahamaputra.Data.EbPaymentRequestList;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
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
    private SessionManager sessionManager;
    private AlertDialogManager alertDialogManager;
    public static final int RESULT_TRAN_SUBMIT = 259;
    private EbPaymentRequest ebPaymentRequest;
    private EbProcessTrasactionAdapter ebProcessTrasactionAdapter;

    private ListView listViewElectricBill;
    private TextView txtNoTicketFound;

    public static final int RESULT_EB_REC_SUBMIT = 259;

    private void assignViews() {
        listViewElectricBill = (ListView) findViewById(R.id.listViewElectricBill);
        txtNoTicketFound = (TextView) findViewById(R.id.txtNoTicketFound);
       /* listViewElectricBill.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //showToast(ebPaymentRequest.getEbPaymentRequestList().get(position).getRequestTicketeNo());
               // Object itemObject = parent.getAdapter().getItem(position);
                if(ebPaymentRequest.getEbPaymentRequestList().get(position).getStatusId().equals("1")) {
                    Intent intent = new Intent(ElectricBillProcessList.this, UploadEBReceiptActivity.class);
                    intent.putExtra("request_id", ebPaymentRequest.getEbPaymentRequestList().get(position).getId());
                    intent.putExtra("ticket_no", ebPaymentRequest.getEbPaymentRequestList().get(position).getRequestTicketeNo());
                    intent.putExtra("site_id", ebPaymentRequest.getEbPaymentRequestList().get(position).getSiteId());
                    intent.putExtra("site_name", ebPaymentRequest.getEbPaymentRequestList().get(position).getSiteName());

                    startActivityForResult(intent, RESULT_EB_REC_SUBMIT);
                }


            }
        });*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_bill_process_list);
        this.setTitle("Electric Bill Process Tickets");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        alertDialogManager = new AlertDialogManager(ElectricBillProcessList.this);
        sessionManager = new SessionManager(ElectricBillProcessList.this);
        userId = sessionManager.getSessionUserId();
        assignViews();
        prepareListData();
    }


    private void prepareListData() {
        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();

            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());


            GsonRequest<EbPaymentRequest> ebPaymentRequestGsonRequest = new GsonRequest<>(Request.Method.POST, Constants.GetElectriBillTransactionslist, jo.toString(), EbPaymentRequest.class,
                    new Response.Listener<EbPaymentRequest>() {
                        @Override
                        public void onResponse(@NonNull EbPaymentRequest response) {
                            hideBusyProgress();
                            //showToast(""+response.getSuccess().toString());
                            if (response.getSuccess() == 1) {
                                ebPaymentRequest = response;
                                if (ebPaymentRequest.getEbPaymentRequestList() != null && ebPaymentRequest.getEbPaymentRequestList().size() > 0) {
                                    txtNoTicketFound.setVisibility(View.GONE);
                                    listViewElectricBill.setVisibility(View.VISIBLE);
                                    ArrayList<EbPaymentRequestList> dd = new ArrayList<EbPaymentRequestList>(ebPaymentRequest.getEbPaymentRequestList().size());
                                    dd.addAll(ebPaymentRequest.getEbPaymentRequestList());
                                    ebProcessTrasactionAdapter = new EbProcessTrasactionAdapter(dd, ElectricBillProcessList.this);

                                    listViewElectricBill.setAdapter(ebProcessTrasactionAdapter);


                                } else {
                                    listViewElectricBill.setVisibility(View.GONE);
                                    txtNoTicketFound.setVisibility(View.VISIBLE);
                                }


                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error.getMessage().contains("java.net.UnknownHostException")){
                        showToast("No Internet Connection.");
                    }
                    hideBusyProgress();

                }
            });
            ebPaymentRequestGsonRequest.setRetryPolicy(Application.getDefaultRetryPolice());
            ebPaymentRequestGsonRequest.setShouldCache(false);
            Application.getInstance().addToRequestQueue(ebPaymentRequestGsonRequest, "ebPaymentRequestGsonRequest");

        } catch (JSONException e) {
            hideBusyProgress();
            showToast("Something went wrong. Please try again later.");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.eb_add_item_menu, menu);
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
            case R.id.menuRefresh:
                prepareListData();
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
     /*   if (resultCode == RESULT_OK) {
            prepareListData();
        }*/
        if (requestCode == RESULT_EB_REC_SUBMIT && resultCode == RESULT_OK) {
            prepareListData();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

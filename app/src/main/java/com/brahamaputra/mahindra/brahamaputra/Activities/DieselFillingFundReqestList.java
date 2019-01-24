package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;

public class DieselFillingFundReqestList extends AppCompatActivity {

    private ListView mDieselFillingReqListListViewTickets;
    private TextView mTxtNoTicketFound;
    public static final int RESULT_TRAN_SUBMIT = 300;

    private SessionManager sessionManager;
    private String userId = "";
    private AlertDialogManager alertDialogManager;

    private void assignViews() {
        mDieselFillingReqListListViewTickets = (ListView) findViewById(R.id.listViewDieselReq);
        mTxtNoTicketFound = (TextView) findViewById(R.id.txtNoTicketFound);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diesel_filling_fund_reqest_list);
        this.setTitle("Diesel Filling Fund Req Tickets");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        alertDialogManager = new AlertDialogManager(DieselFillingFundReqestList.this);
        sessionManager = new SessionManager(DieselFillingFundReqestList.this);
        userId = sessionManager.getSessionUserId();
        assignViews();
        prepareListData();
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
    }
}

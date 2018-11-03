package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.LandDetailsData;
import com.brahamaputra.mahindra.brahamaputra.Data.TotalDCLoadofSiteData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Total_DC_Load_site extends BaseActivity {

    private TextView mTotalDCLoadsiteTextViewTotalDcLoadOfSite;
    private EditText mTotalDCLoadsiteEditTextTotalDcLoadOfSite;

    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "101";
    private String ticketId = "28131";
    private String ticketName = "28131";
    private HotoTransactionData hotoTransactionData;
    private TotalDCLoadofSiteData totalDCLoadofSiteData;
    private String base64StringLayoutOfLand = "eji39jjj";
    private SessionManager sessionManager;

    private void assignViews() {
        mTotalDCLoadsiteTextViewTotalDcLoadOfSite = (TextView) findViewById(R.id.totalDCLoadsite_textView_totalDcLoadOfSite);
        mTotalDCLoadsiteEditTextTotalDcLoadOfSite = (EditText) findViewById(R.id.totalDCLoadsite_editText_totalDcLoadOfSite);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }


    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_dc_load_of_the_site);
        this.setTitle("Total DC load of the site");
        sessionManager = new SessionManager(Total_DC_Load_site.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = sessionManager.getSessionUserTicketId();
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(Total_DC_Load_site.this, userId, ticketId);
        assignViews();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        hotoTransactionData = new HotoTransactionData();
        setInputDetails();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dropdown_details_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                finish();
                return true;
            case R.id.menuDone:
                finish();
                submitDetails();
                startActivity(new Intent(this, ActiveequipmentDetails.class));
                finish();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    private void setInputDetails() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketId + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketId + ".txt");
                // Toast.makeText(Land_Details.this,"JsonInString :"+ jsonInString,Toast.LENGTH_SHORT).show();

                Gson gson = new Gson();
//                landDetailsData = gson.fromJson(jsonInString, LandDetailsData.class);

                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);
                totalDCLoadofSiteData = hotoTransactionData.getTotalDCLoadofSiteData();

                mTotalDCLoadsiteEditTextTotalDcLoadOfSite.setText(totalDCLoadofSiteData.getTotalDcLoadOfSite());

            } else {
                Toast.makeText(Total_DC_Load_site.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitDetails() {
        try {
            hotoTransactionData.setTicketNo(ticketId);

            String totalDcLoadOfSite = mTotalDCLoadsiteEditTextTotalDcLoadOfSite.getText().toString().trim();

            totalDCLoadofSiteData = new TotalDCLoadofSiteData(totalDcLoadOfSite);

            hotoTransactionData.setTotalDCLoadofSiteData(totalDCLoadofSiteData);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);


            offlineStorageWrapper.saveObjectToFile(ticketId + ".txt", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

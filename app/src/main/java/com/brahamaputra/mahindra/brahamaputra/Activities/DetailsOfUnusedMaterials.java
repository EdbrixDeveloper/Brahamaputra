package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.Data.DetailsOfUnusedMaterialsData;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePhotoCaptureData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailsOfUnusedMaterials extends BaseActivity {


    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";
    private HotoTransactionData hotoTransactionData;
    private DetailsOfUnusedMaterialsData detailsOfUnusedMaterialsData;
    private SessionManager sessionManager;

    private TextView mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSite;
    private TextView mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSiteVal;
    private TextView mDetailsOfUnusedMaterialsTextViewAssetMake;
    private TextView mDetailsOfUnusedMaterialsTextViewAssetMakeVal;
    private TextView mDetailsOfUnusedMaterialsTextViewAssetStatus;
    private TextView mDetailsOfUnusedMaterialsTextViewAssetStatusVal;

  /*  mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSiteVal;
    mDetailsOfUnusedMaterialsTextViewAssetMakeVal;
    mDetailsOfUnusedMaterialsTextViewAssetStatusVal;
*/

    String str_numberofUnusedAssetinSite;
    String str_assetMake;
    String str_assetStatus;

    private void assignViews() {
        mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSite = (TextView) findViewById(R.id.detailsOfUnusedMaterials_textView_NumberofUnusedAssetinSite);
        mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSiteVal = (TextView) findViewById(R.id.detailsOfUnusedMaterials_textView_NumberofUnusedAssetinSite_val);
        mDetailsOfUnusedMaterialsTextViewAssetMake = (TextView) findViewById(R.id.detailsOfUnusedMaterials_textView_AssetMake);
        mDetailsOfUnusedMaterialsTextViewAssetMakeVal = (TextView) findViewById(R.id.detailsOfUnusedMaterials_textView_AssetMake_val);
        mDetailsOfUnusedMaterialsTextViewAssetStatus = (TextView) findViewById(R.id.detailsOfUnusedMaterials_textView_AssetStatus);
        mDetailsOfUnusedMaterialsTextViewAssetStatusVal = (TextView) findViewById(R.id.detailsOfUnusedMaterials_textView_AssetStatus_val);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );


    }

    private void initCombo() {
        mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(DetailsOfUnusedMaterials.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_detailsOfUnusedMaterials_NumberofUnusedAssetinSite))),
                        "Number of Unused Asset in Site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_numberofUnusedAssetinSite = item.get(position);
                        mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSiteVal.setText(str_numberofUnusedAssetinSite);
                    }
                });

            }
        });
        mDetailsOfUnusedMaterialsTextViewAssetMakeVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(DetailsOfUnusedMaterials.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_detailsOfUnusedMaterials_AssetMake))),
                        "Asset Make",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_assetMake = item.get(position);
                        mDetailsOfUnusedMaterialsTextViewAssetMakeVal.setText(str_assetMake);
                    }
                });

            }
        });
        mDetailsOfUnusedMaterialsTextViewAssetStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(DetailsOfUnusedMaterials.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_detailsOfUnusedMaterials_AssetStatus))),
                        "Asset Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_assetStatus = item.get(position);
                        mDetailsOfUnusedMaterialsTextViewAssetStatusVal.setText(str_assetStatus);
                    }
                });

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_unused_materials);
        this.setTitle("Details Of Unused Materials");

        sessionManager = new SessionManager(DetailsOfUnusedMaterials.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(DetailsOfUnusedMaterials.this, userId, ticketName);

        assignViews();
        initCombo();
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
                return true;
            case R.id.menuDone:
                submitDetails();
                startActivity(new Intent(DetailsOfUnusedMaterials.this, PhotoCaptureActivity.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setInputDetails() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");

                Gson gson = new Gson();

                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);
                detailsOfUnusedMaterialsData = hotoTransactionData.getDetailsOfUnusedMaterialsData();

                mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSiteVal.setText(detailsOfUnusedMaterialsData.getNumberofUnusedAssetinSite());
                mDetailsOfUnusedMaterialsTextViewAssetMakeVal.setText(detailsOfUnusedMaterialsData.getAssetMake());
                mDetailsOfUnusedMaterialsTextViewAssetStatusVal.setText(detailsOfUnusedMaterialsData.getAssetStatus());

            } else {
                Toast.makeText(DetailsOfUnusedMaterials.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitDetails() {
        try {
            // hotoTransactionData.setTicketNo(ticketId);

            String numberofUnusedAssetinSite = mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSiteVal.getText().toString().trim();
            String assetMake = mDetailsOfUnusedMaterialsTextViewAssetMakeVal.getText().toString().trim();
            String assetStatus = mDetailsOfUnusedMaterialsTextViewAssetStatusVal.getText().toString().trim();

            detailsOfUnusedMaterialsData = new DetailsOfUnusedMaterialsData(numberofUnusedAssetinSite, assetMake, assetStatus);
            hotoTransactionData.setDetailsOfUnusedMaterialsData(detailsOfUnusedMaterialsData);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);

            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

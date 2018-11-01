package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailsOfUnusedMaterials extends BaseActivity {


    private TextView mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSite;
    private TextView mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSiteVal;
    private TextView mDetailsOfUnusedMaterialsTextViewAssetMake;
    private TextView mDetailsOfUnusedMaterialsTextViewAssetMakeVal;
    private TextView mDetailsOfUnusedMaterialsTextViewAssetStatus;
    private TextView mDetailsOfUnusedMaterialsTextViewAssetStatusVal;


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

    private void initCombo()
    {
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
        assignViews();
        initCombo();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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
                // startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;
            case R.id.menuDone:
                finish();
                //startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}

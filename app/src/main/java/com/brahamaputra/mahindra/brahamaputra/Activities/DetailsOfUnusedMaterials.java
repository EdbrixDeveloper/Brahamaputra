package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

public class DetailsOfUnusedMaterials extends AppCompatActivity {


    private TextView mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSite;
    private SearchableSpinner mDetailsOfUnusedMaterialsSpinnerNumberofUnusedAssetinSite;
    private TextView mDetailsOfUnusedMaterialsTextViewAssetMake;
    private SearchableSpinner mDetailsOfUnusedMaterialsSpinnerAssetMake;
    private TextView mDetailsOfUnusedMaterialsTextViewAssetStatus;
    private SearchableSpinner mDetailsOfUnusedMaterialsSpinnerAssetStatus;

    private void assignViews() {
        mDetailsOfUnusedMaterialsTextViewNumberofUnusedAssetinSite = (TextView) findViewById(R.id.detailsOfUnusedMaterials_textView_NumberofUnusedAssetinSite);
        mDetailsOfUnusedMaterialsSpinnerNumberofUnusedAssetinSite = (SearchableSpinner) findViewById(R.id.detailsOfUnusedMaterials_spinner_NumberofUnusedAssetinSite);
        mDetailsOfUnusedMaterialsTextViewAssetMake = (TextView) findViewById(R.id.detailsOfUnusedMaterials_textView_AssetMake);
        mDetailsOfUnusedMaterialsSpinnerAssetMake = (SearchableSpinner) findViewById(R.id.detailsOfUnusedMaterials_spinner_AssetMake);
        mDetailsOfUnusedMaterialsTextViewAssetStatus = (TextView) findViewById(R.id.detailsOfUnusedMaterials_textView_AssetStatus);
        mDetailsOfUnusedMaterialsSpinnerAssetStatus = (SearchableSpinner) findViewById(R.id.detailsOfUnusedMaterials_spinner_AssetStatus);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_unused_materials);
        this.setTitle("Details Of Unused Materials");
       // assignViews();

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
                startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;
            case R.id.menuDone:
                startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}

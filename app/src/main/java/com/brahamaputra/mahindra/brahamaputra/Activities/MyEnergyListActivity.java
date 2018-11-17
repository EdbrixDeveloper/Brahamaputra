package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.brahamaputra.mahindra.brahamaputra.Adapters.HotoSectionListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoSection;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MyEnergyListActivity extends AppCompatActivity {

    private RelativeLayout mMyEnegyListRelativeLayoutDieselFilling;
    private ImageView mImgDieselFilling;
    private RelativeLayout mMyEnegyListRelativeLayoutEbProcess;
    private ImageView mImgEbProcess;

    private void assignViews() {
        mMyEnegyListRelativeLayoutDieselFilling = (RelativeLayout) findViewById(R.id.myEnegyList_relativeLayout_dieselFilling);
        mImgDieselFilling = (ImageView) findViewById(R.id.img_dieselFilling);
        mMyEnegyListRelativeLayoutEbProcess = (RelativeLayout) findViewById(R.id.myEnegyList_relativeLayout_ebProcess);
        mImgEbProcess = (ImageView) findViewById(R.id.img_ebProcess);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_energy_list);
        this.setTitle("My Energy Process");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        assignViews();
        mMyEnegyListRelativeLayoutDieselFilling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyEnergyListActivity.this, DieselFillingList.class));
            }
        });

        mMyEnegyListRelativeLayoutEbProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_no_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuSubmit:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }


}

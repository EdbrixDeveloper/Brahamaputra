package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.support.v7.widget.Toolbar;

import com.brahamaputra.mahindra.brahamaputra.R;

public class DashboardActivity extends AppCompatActivity {

    private RelativeLayout mDashboardRelativeLayoutMyHoto;
    private RelativeLayout mDashboardRelativeLayoutMyAsset;
    private RelativeLayout mDashboardRelativeLayoutMyMaster;
    private RelativeLayout mDashboardRelativeLayoutMyEnergy;
    private RelativeLayout mDashboardRelativeLayoutMyPrevitive;
    private RelativeLayout mDashboardRelativeLayoutMyIncident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        assignViews();
        setListner();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setting the title
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);

    }

    private void setListner() {

        mDashboardRelativeLayoutMyHoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,UsersHotoListActivity.class));
            }
        });

        mDashboardRelativeLayoutMyAsset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,Tower_Detail.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dashboard_menu, menu);
        return true;
    }


    private void assignViews() {
        mDashboardRelativeLayoutMyHoto = (RelativeLayout) findViewById(R.id.dashboard_relativeLayout_myHoto);
        mDashboardRelativeLayoutMyAsset = (RelativeLayout) findViewById(R.id.dashboard_relativeLayout_myAsset);
        mDashboardRelativeLayoutMyMaster = (RelativeLayout) findViewById(R.id.dashboard_relativeLayout_myMaster);
        mDashboardRelativeLayoutMyEnergy = (RelativeLayout) findViewById(R.id.dashboard_relativeLayout_myEnergy);
        mDashboardRelativeLayoutMyPrevitive = (RelativeLayout) findViewById(R.id.dashboard_relativeLayout_myPrevitive);
        mDashboardRelativeLayoutMyIncident = (RelativeLayout) findViewById(R.id.dashboard_relativeLayout_myIncident);
    }

}

package com.brahamaputra.mahindra.brahamaputra.Activities;

/*
 * Copyright 2013 Csaba Szugyiczki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.szugyi.circlemenu.view.CircleImageView;
import com.szugyi.circlemenu.view.CircleLayout;
import com.szugyi.circlemenu.view.CircleLayout.OnCenterClickListener;
import com.szugyi.circlemenu.view.CircleLayout.OnItemClickListener;
import com.szugyi.circlemenu.view.CircleLayout.OnItemSelectedListener;
import com.szugyi.circlemenu.view.CircleLayout.OnRotationFinishedListener;

public class DashboardCircularActivity extends BaseActivity implements OnItemSelectedListener,
        OnItemClickListener, OnRotationFinishedListener, OnCenterClickListener{
    public static final String ARG_LAYOUT = "layout";

    protected CircleLayout circleLayout;
    protected TextView selectedTextView;
    protected ImageView mDashboard_myMaster;

    final public int CHECK_PERMISSIONS = 123;
    private AlertDialogManager alertDialogManager;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.circular_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        sessionManager = new SessionManager(DashboardCircularActivity.this);
        //setting the title
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);
        // Set listeners
        circleLayout = (CircleLayout) findViewById(R.id.circle_layout);
        circleLayout.setOnItemSelectedListener(this);
        circleLayout.setOnItemClickListener(this);
        circleLayout.setOnRotationFinishedListener(this);
        circleLayout.setOnCenterClickListener(this);

        selectedTextView = (TextView) findViewById(R.id.selected_textView);

        String name = null;
        View view = circleLayout.getSelectedItem();
        if (view instanceof CircleImageView) {
            name = ((CircleImageView) view).getName();
        }
        //selectedTextView.setText(name);

        selectedTextView.setText("Brahamputra");


        mDashboard_myMaster=(ImageView)findViewById(R.id.dashboard_myMaster);
        mDashboard_myMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dashboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menuSubmit:
                finish();
                startActivity(new Intent(DashboardCircularActivity.this, UserProfileActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(View view) {
        final String name;
        if (view instanceof CircleImageView) {
            name = ((CircleImageView) view).getName();
        } else {
            name = null;
        }

       // selectedTextView.setText(name);

        /*switch (view.getId()) {
            case R.id.main_calendar_image:
                // Handle calendar selection
                break;
            case R.id.main_cloud_image:
                // Handle cloud selection
                break;
            case R.id.main_key_image:
                // Handle key selection
                break;
            *//*case R.id.main_mail_image:
                // Handle mail selection
                break;*//*
            case R.id.main_profile_image:
                // Handle profile selection
                break;
            case R.id.main_tap_image:
                // Handle tap selection
                break;
        }*/
    }

    @Override
    public void onItemClick(View view) {
        String name = null;
        if (view instanceof CircleImageView) {
            name = ((CircleImageView) view).getName();
        }

       /* String text = getResources().getString(R.string.start_app, name);
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();*/

        switch (view.getId()) {
            case R.id.dashboard_myHoto:
                // Handle calendar click
                checkSystemLocation();
                break;
            case R.id.dashboard_myAsset:
                // Handle cloud click
                break;
            case R.id.dashboard_myEnergy:
                // Handle key click
                Intent intent = new Intent(DashboardCircularActivity.this, MyEnergyListActivity.class);
                startActivity(intent);
                break;
            /*case R.id.main_mail_image:
                // Handle mail click
                break;*/
            case R.id.dashboard_myPrevitive:
                // Handle profile click
                break;
            case R.id.dashboard_myIncident:
                // Handle tap click
                break;
        }
    }

    @Override
    public void onRotationFinished(View view) {
        Animation animation = new RotateAnimation(0, 360, view.getWidth() / 2, view.getHeight() / 2);
        animation.setDuration(250);
        view.startAnimation(animation);
    }

    @Override
    public void onCenterClick() {
       // Toast.makeText(getApplicationContext(), R.string.center_click, Toast.LENGTH_SHORT).show();
    }

    public void onAddClick(View view) {
      /*  CircleImageView newMenu = new CircleImageView(this);
        newMenu.setBackgroundResource(R.drawable.circle);
        newMenu.setImageResource(R.drawable.ic_voice);
        newMenu.setName(getString(R.string.voice_search));
        circleLayout.addView(newMenu);*/
    }

    public void onRemoveClick(View view) {
        if (circleLayout.getChildCount() > 0) {
            circleLayout.removeViewAt(circleLayout.getChildCount() - 1);
        }
    }

    public void checkSystemLocation() {
        LocationManager lm = (LocationManager) DashboardCircularActivity.this.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }

        if (!gps_enabled && !network_enabled) {
            // notify user
            alertDialogManager.Dialog("Information", "Location is not enabled. Do you want to enable?", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                @Override
                public void onPositiveClick() {
                    Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    DashboardCircularActivity.this.startActivity(myIntent);
                }
            }).show();
        } else {
            if (Conditions.isNetworkConnected(DashboardCircularActivity.this)) {
                Intent intent = new Intent(DashboardCircularActivity.this, UsersHotoListActivity.class);
                intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(DashboardCircularActivity.this));
                startActivity(intent);
            } else {
                alertDialogManager.Dialog("Information", "Device has no internet connection. Do you want to use offline mode?", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                    @Override
                    public void onPositiveClick() {

                        final EditText taskEditText = new EditText(DashboardCircularActivity.this);
                        AlertDialog dialog = new AlertDialog.Builder(DashboardCircularActivity.this)
                                .setTitle("Information")
                                .setMessage("Enter Ticket ID")
                                .setView(taskEditText)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //TicketID = String.valueOf(taskEditText.getText());
                                        Intent intent = new Intent(DashboardCircularActivity.this, UserHotoTransactionActivity.class);
                                        intent.putExtra("isNetworkConnected", Conditions.isNetworkConnected(DashboardCircularActivity.this));
                                        intent.putExtra("ticketNO", String.valueOf(taskEditText.getText()));
                                        sessionManager.updateSessionUserTicketId(String.valueOf(taskEditText.getText()));
                                        startActivity(intent);
                                    }
                                })
                                .setNegativeButton("cancel", null)
                                .create();
                        dialog.show();
                    }
                }).show();
            }
        }
    }
}

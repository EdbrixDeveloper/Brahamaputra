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
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.ImageView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.ToastMessage;
import com.brahamaputra.mahindra.brahamaputra.commons.CircleImageView;
import com.brahamaputra.mahindra.brahamaputra.commons.CircleLayout;
import com.brahamaputra.mahindra.brahamaputra.commons.CircleLayout.OnCenterClickListener;
import com.brahamaputra.mahindra.brahamaputra.commons.CircleLayout.OnItemClickListener;
import com.brahamaputra.mahindra.brahamaputra.commons.CircleLayout.OnItemSelectedListener;
import com.brahamaputra.mahindra.brahamaputra.commons.CircleLayout.OnRotationFinishedListener;
import com.bumptech.glide.Glide;

public class DashboardCircularActivity extends BaseActivity implements OnItemSelectedListener,
        OnItemClickListener, OnRotationFinishedListener, OnCenterClickListener {
    public static final String ARG_LAYOUT = "layout";

    protected CircleLayout circleLayout;
    // protected TextView selectedTextView;
    protected ImageView mDashboard_myMaster;

    final public int CHECK_PERMISSIONS = 123;
    private AlertDialogManager alertDialogManager;
    private SessionManager sessionManager;
    ToastMessage toastMessage;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.circular_menu);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        sessionManager = new SessionManager(DashboardCircularActivity.this);
        ImageView imageViewProfilePhoto = (ImageView) findViewById(R.id.imageView2);
        //CircleImageView imageViewProfilePhoto = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.imageView2);
        alertDialogManager = new AlertDialogManager(DashboardCircularActivity.this);

        // Set listeners
        circleLayout = (CircleLayout) findViewById(R.id.circle_layout);
        circleLayout.setOnItemSelectedListener(this);
        circleLayout.setOnItemClickListener(this);
        circleLayout.setOnRotationFinishedListener(this);
        circleLayout.setOnCenterClickListener(this);

        //selectedTextView = (TextView) findViewById(R.id.selected_textView);
        toastMessage = new ToastMessage(DashboardCircularActivity.this);

        mDashboard_myMaster = (ImageView) findViewById(R.id.dashboard_myMaster);
        mDashboard_myMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        String imageUri = sessionManager.getSessionProfileImageUrl().toString();
        Glide.with(getApplicationContext())
                .load(imageUri)
                .into(imageViewProfilePhoto);

        imageViewProfilePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(DashboardCircularActivity.this, UserProfileActivity.class));
            }
        });

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
            case R.id.dashboard_myHoto_layout:
                // Handle calendar click
                checkSystemLocation();
                break;
            case R.id.dashboard_myAsset_layout:
                // Handle cloud click
                break;
            case R.id.dashboard_myEnergy_layout:
                // Handle key click
                Intent intent = new Intent(DashboardCircularActivity.this, MyEnergyListActivity.class);
                startActivity(intent);
                break;
            /*case R.id.main_mail_image:
                // Handle mail click
                break;*/
            case R.id.dashboard_myPrevitive_layout:
                // Handle profile click
                intent = new Intent(DashboardCircularActivity.this, MyPreventiveListActivity.class);
                startActivity(intent);
                break;
            case R.id.dashboard_myIncident_layout:
                // Handle tap click
                break;
        }

        //Rotation_Animation(view);
    }


    @Override
    public void onRotationFinished(View view) {
        Animation animation = new RotateAnimation(0, 360, view.getWidth() / 2, view.getHeight() / 2);
        animation.setDuration(250);
        view.startAnimation(animation);
        String name = null;

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
                startActivity(new Intent(DashboardCircularActivity.this, UsersOfflineHotoListActivity.class));
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        showToast("Click back again to exit.");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
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

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dashboard_menu, menu);
        return true;
    }*/

    public void onRemoveClick(View view) {
        if (circleLayout.getChildCount() > 0) {
            circleLayout.removeViewAt(circleLayout.getChildCount() - 1);
        }
    }

    /* public void Rotate(View view) {
        Animation animation = new RotateAnimation(0, 360, view.getWidth() / 2, view.getHeight() / 2);
        animation.setDuration(250);
        view.startAnimation(animation);
        view_pass = view;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                menu_selected(view_pass);
            }
        }, 100);
    }
    */

}
package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;

public class UserProfileActivity extends AppCompatActivity {

    private ImageView mImageView2;
    private TextView mTextView;
    private TextView mTextView2;
    private ImageView mUserProfileImageViewEmail;
    private TextView mUserProfileTextViewEmail;
    private TextView mUserProfileTextViewEmailText;
    private ImageView mUserProfileImageViewMobile;
    private TextView mUserProfileTextViewMobile;
    private TextView mUserProfileTextViewMobileText;
    private TextView mUserProfileTextViewuserName;
    private TextView mUserProfileTextViewuserEmail;

    private SessionManager sessionManager;
    private AlertDialogManager alertDialogManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Profile");
        assignViews();
        alertDialogManager = new AlertDialogManager(UserProfileActivity.this);
        setValues();
    }

    private void setValues() {
        sessionManager = new SessionManager(UserProfileActivity.this);
        if (!sessionManager.getSessionUsername().equals("") && !sessionManager.getSessionUserId().equals("")) {
            mUserProfileTextViewuserName.setText(sessionManager.getSessionUserFirstName().toString() + " " + sessionManager.getSessionUserFirstLast().toString());
            mUserProfileTextViewuserEmail.setText(sessionManager.getSessionUsername().toString());
            mUserProfileTextViewEmailText.setText(sessionManager.getSessionUsername().toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                startActivity(new Intent(UserProfileActivity.this, DashboardActivity.class));
                return true;

            case R.id.menuLogout:
                /*sessionManager.clearSessionCredentials();
                finish();
                //moveTaskToBack(true);
                startActivity(new Intent(UserProfileActivity.this,LoginActivity.class)); Commented by Arjun on 10-11-2018*/
                showSettingsAlert();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    ////added by arjun on 10-11-2018 Start


    private void showSettingsAlert() {

        alertDialogManager.Dialog("Logout", "Are you sure you want to Logout ?", "Yes", "No", new AlertDialogManager.onTwoButtonClickListner() {
            @Override
            public void onPositiveClick() {
                sessionManager.clearSessionCredentials();
                finish();
                startActivity(new Intent(UserProfileActivity.this, LoginActivity.class));
            }

            @Override
            public void onNegativeClick() {

            }
        }).show();

    }
////added by arjun on 10-11-2018 End

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(UserProfileActivity.this, DashboardActivity.class));
    }

    private void assignViews() {
        mImageView2 = (ImageView) findViewById(R.id.imageView2);
        //mTextView = (TextView) findViewById(R.id.textView);
        //mTextView2 = (TextView) findViewById(R.id.textView2);
        mUserProfileImageViewEmail = (ImageView) findViewById(R.id.userProfile_imageView_email);
        mUserProfileTextViewEmail = (TextView) findViewById(R.id.userProfile_textView_email);
        mUserProfileTextViewEmailText = (TextView) findViewById(R.id.userProfile_textView_emailText);
        mUserProfileImageViewMobile = (ImageView) findViewById(R.id.userProfile_imageView_mobile);
        mUserProfileTextViewMobile = (TextView) findViewById(R.id.userProfile_textView_mobile);
        mUserProfileTextViewMobileText = (TextView) findViewById(R.id.userProfile_textView_mobileText);
        mUserProfileTextViewuserName = (TextView) findViewById(R.id.textView_userProfile_name);
        mUserProfileTextViewuserEmail = (TextView) findViewById(R.id.textView_userProfile_userName);
    }


}

package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfileActivity extends AppCompatActivity {

    //private ImageView mImageView2;
    CircleImageView mImageView2;
    private TextView mTextView;
    private TextView mTextView2;
    private ImageView mUserProfileImageViewEmail;
    private TextView mUserProfileTextViewEmail;
    private TextView mUserProfileTextViewEmailText;
    private ImageView mUserProfileImageViewMobileNo;
    private TextView mUserProfileTextViewMobileNo;
    private TextView mUserProfileTextViewMobileNoText;
    private TextView mUserProfileTextViewuserName;
    private TextView mUserProfileTextViewuserEmail;

    private ImageView mUserProfileImageViewCircle;
    private TextView mUserProfileTextViewCircle;
    private TextView mUserProfileTextViewCircleText;

    ImageView mUserProfileImageViewDesignation;
    TextView mUserProfileTextViewDesignation;
    TextView mUserProfileTextViewDesignationText;

    ImageView mUserProfileImageViewUserName;
    TextView mUserProfileTextViewUserName;
    TextView mUserProfileTextViewUserNameText;

    private SessionManager sessionManager;
    private AlertDialogManager alertDialogManager;

    public static final int RESULT_UPDATE_PROFILE = 328;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Profile");
        assignViews();
        alertDialogManager = new AlertDialogManager(UserProfileActivity.this);
        sessionManager = new SessionManager(UserProfileActivity.this);
        setValues();
    }

    private void setValues() {

        if (!sessionManager.getSessionUsername().equals("") && !sessionManager.getSessionUserId().equals("")) {
            mUserProfileTextViewuserName.setText(sessionManager.getSessionUserFirstName().toString() + " " + sessionManager.getSessionUserFirstLast().toString());
            mUserProfileTextViewuserEmail.setText(sessionManager.getSessionUsername().toString());
            mUserProfileTextViewUserNameText.setText(sessionManager.getSessionUsername().toString());
            mUserProfileTextViewEmailText.setText(sessionManager.getSessionUserEmail().toString());
            mUserProfileTextViewMobileNoText.setText(sessionManager.getSessionMobileNo().toString());
            mUserProfileTextViewDesignationText.setText(sessionManager.getSessionDesignation().toString());
            mUserProfileTextViewCircleText.setText(sessionManager.getSessionCircle().toString());
            //mImageView2.setImageBitmap(getBitmapFromURL(sessionManager.getSessionProfileImageUrl().toString()));

            String imageUri = sessionManager.getSessionProfileImageUrl().toString();
            Glide.with(getApplicationContext())
                    .load(imageUri)
                    .into(mImageView2);

           /* GlideApp.with(context)
                    .load("http://via.placeholder.com/300.png")
                    .into(ivImg);*/
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
                startActivity(new Intent(UserProfileActivity.this, DashboardCircularActivity.class));
                return true;

            case R.id.menuLogout:
                /*sessionManager.clearSessionCredentials();
                finish();
                //moveTaskToBack(true);
                startActivity(new Intent(UserProfileActivity.this,LoginActivity.class)); Commented by Arjun on 10-11-2018*/
                showSettingsAlert();
                return true;

            case R.id.menuEditProf:
                startActivityForResult(new Intent(UserProfileActivity.this, UserEditProfileActivity.class), RESULT_UPDATE_PROFILE);
                return true;

            case R.id.menuChangePassword:
                startActivity(new Intent(UserProfileActivity.this, UserChangePasswordActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    ////added by arjun on 10-11-2018 Start


    private void showSettingsAlert() {

        alertDialogManager.Dialog("Confirmation", "Are you sure you want to logout?", "Yes", "No", new AlertDialogManager.onTwoButtonClickListner() {
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
        startActivity(new Intent(UserProfileActivity.this, DashboardCircularActivity.class));
    }

    private void assignViews() {
        mImageView2 = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.imageView2);

        //mImageView2 = (ImageView) findViewById(R.id.imageView2);
        //mTextView = (TextView) findViewById(R.id.textView);
        //mTextView2 = (TextView) findViewById(R.id.textView2);
        mUserProfileImageViewEmail = (ImageView) findViewById(R.id.userProfile_imageView_email);
        mUserProfileTextViewEmail = (TextView) findViewById(R.id.userProfile_textView_email);
        mUserProfileTextViewEmailText = (TextView) findViewById(R.id.userProfile_textView_emailText);

        mUserProfileImageViewMobileNo = (ImageView) findViewById(R.id.userProfile_imageView_mobileNo);
        mUserProfileTextViewMobileNo = (TextView) findViewById(R.id.userProfile_textView_mobileNo);
        mUserProfileTextViewMobileNoText = (TextView) findViewById(R.id.userProfile_textView_mobileNoText);

        mUserProfileTextViewuserName = (TextView) findViewById(R.id.textView_userProfile_name);
        mUserProfileTextViewuserEmail = (TextView) findViewById(R.id.textView_userProfile_userName);

        mUserProfileImageViewCircle = (ImageView) findViewById(R.id.userProfile_imageView_circle);
        mUserProfileTextViewCircle = (TextView) findViewById(R.id.userProfile_textView_circle);
        mUserProfileTextViewCircleText = (TextView) findViewById(R.id.userProfile_textView_circleText);

        mUserProfileImageViewUserName = (ImageView) findViewById(R.id.userProfile_imageView_userName);
        mUserProfileTextViewUserName = (TextView) findViewById(R.id.userProfile_textView_userName);
        mUserProfileTextViewUserNameText = (TextView) findViewById(R.id.userProfile_textView_userNameText);

        mUserProfileImageViewDesignation = (ImageView) findViewById(R.id.userProfile_imageView_designation);
        mUserProfileTextViewDesignation = (TextView) findViewById(R.id.userProfile_textView_designation);
        mUserProfileTextViewDesignationText = (TextView) findViewById(R.id.userProfile_textView_designationText);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_UPDATE_PROFILE && resultCode == RESULT_OK) {
            setValues();
        }
    }

}

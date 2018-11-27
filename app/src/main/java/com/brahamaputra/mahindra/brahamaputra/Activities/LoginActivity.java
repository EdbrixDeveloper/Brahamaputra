package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.Data.UserLoginResponseData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.Volley.SettingsMy;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity {

    private ImageView mImageView;
    private EditText mLoginEditTextUsername;
    private EditText mLoginEditTextPassword;
    private Button mLoginButtonLogin;
    private TextView loginTextViewForgotPassword;
    final public int CHECK_PERMISSIONS = 123;
    private SessionManager sessionManager;

    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (validateUser()) {
            finish();
            startActivity(new Intent(LoginActivity.this, DashboardCircularActivity.class));
            //startActivity(new Intent(LoginActivity.this,DashboardCircularActivity.class));
        } else {
            setContentView(R.layout.activity_login);
            assignViews();
            setListener();
            hideKeyboard();
        }
        checkPermission();
        sessionManager = new SessionManager(LoginActivity.this);
    }

    private void assignViews() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        mLoginEditTextUsername = (EditText) findViewById(R.id.login_editText_username);
        mLoginEditTextPassword = (EditText) findViewById(R.id.login_editText_password);
        mLoginEditTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // hide virtual keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mLoginEditTextPassword.getWindowToken(), 0);
                    checkValidations();
                    return true;
                }
                return false;
            }
        });

        mLoginButtonLogin = (Button) findViewById(R.id.login_button_login);
        loginTextViewForgotPassword = (TextView) findViewById(R.id.login_textView_forgotPassword);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    private void setListener() {
        mLoginButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidations();

            }
        });

        loginTextViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mLoginEditTextUsername.getWindowToken(), 0);
    }

    private boolean validateUser() {
        sessionManager = new SessionManager(LoginActivity.this);
        if (sessionManager.getSessionUsername().equals("") && sessionManager.getSessionUserId().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private void doLogin(String email, String password) {
        showBusyProgress();
        JSONObject jo = new JSONObject();
        try {
            jo.put("APIKEY", Constants.APP_KEY__);
            jo.put("SECRETKEY", Constants.APP_SECRET__);
            jo.put("Username", email);
            jo.put("Password", password);
            jo.put("DeviceToken", sessionManager.getSessionFCMToken());
            jo.put("Type", "A");

        } catch (JSONException e) {
            Log.e(LoginActivity.class.getName(), e.getMessage().toString());
            return;
        }

        GsonRequest<UserLoginResponseData> userLoginEmailRequest = new GsonRequest<>(Request.Method.POST, Constants.userLogin, jo.toString(), UserLoginResponseData.class,
                new Response.Listener<UserLoginResponseData>() {
                    @Override
                    public void onResponse(@NonNull UserLoginResponseData response) {
                        hideBusyProgress();
                        if (response.getError() != null) {
                            showToast(response.getError().getErrorMessage());
                        } else {

                            if (response.getSuccess() == 1) {
                                sessionManager.updateSessionUsername(response.getUser().getUsername());
                                sessionManager.updateSessionUserID(response.getUser().getId());
                                sessionManager.updateSessionUserFirstName(response.getUser().getFirstName());
                                sessionManager.updateSessionUserLastName(response.getUser().getLastName());
                                sessionManager.updateSessionUserEmail(response.getUser().getEmail());
                                sessionManager.updateSessionMobileNo(response.getUser().getMobileNo());
                                sessionManager.updateSessionDesignation(response.getUser().getDesignation());
                                sessionManager.updateSessionCircle(response.getUser().getCircle());
                                sessionManager.updateSessionProfileImageUrl(response.getUser().getProfileImageUrl());
                                sessionManager.updateSessionDeviceToken(response.getAccessToken());
                                finish();

                                startActivity(new Intent(LoginActivity.this, DashboardCircularActivity.class));
                                //startActivity(new Intent(LoginActivity.this,DashboardCircularActivity.class));
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideBusyProgress();
                showToast(SettingsMy.getErrorMessage(error));
            }
        });
        userLoginEmailRequest.setRetryPolicy(Application.getDefaultRetryPolice());
        userLoginEmailRequest.setShouldCache(false);
        Application.getInstance().addToRequestQueue(userLoginEmailRequest, "login_requests");
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.CAMERA) +
                ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) +
                ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) +
                ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) +
                ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(LoginActivity.this,
                    new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,},
                    CHECK_PERMISSIONS);
        } else {
            //Toast.makeText(LoginActivity.this,"Already Granted",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CHECK_PERMISSIONS: {
                boolean isPerpermissionForAllGranted = false;
                if (grantResults.length > 0) {
                    boolean CAMERA = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean READ_EXTERNAL_STORAGE = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean WRITE_EXTERNAL_STORAGE = grantResults[2] == PackageManager.PERMISSION_GRANTED;
                    boolean ACCESS_FINE_LOCATION = grantResults[3] == PackageManager.PERMISSION_GRANTED;
                    boolean ACCESS_COARSE_LOCATION = grantResults[4] == PackageManager.PERMISSION_GRANTED;

                    if (CAMERA && READ_EXTERNAL_STORAGE && WRITE_EXTERNAL_STORAGE && ACCESS_FINE_LOCATION && ACCESS_COARSE_LOCATION) {
                        //Toast.makeText(LoginActivity.this,"all permission granted",Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "some permission not granted", Toast.LENGTH_LONG).show();
                        if (!ACCESS_COARSE_LOCATION || !ACCESS_COARSE_LOCATION) {
                            startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
                        }
                        return;
                    }
                }
                break;

                //DEFAULT CODE BY ANDROID
                // If request is cancelled, the result arrays are empty.
                /*if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;*/
            }
        }
    }

    private void checkValidations() {
        //doLogin
        String username = mLoginEditTextUsername.getText().toString();
        String password = mLoginEditTextPassword.getText().toString();

        Conditions.hideKeyboard(LoginActivity.this);

        if (username.isEmpty()) {
            mLoginEditTextUsername.setError("Field can not be empty");
        } else /*if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _login_edit_text_email.setError(getString(R.string.error_email_not_valid));
        } else */if (password.isEmpty()) {
            mLoginEditTextUsername.setError(null);
            mLoginEditTextPassword.setError("Field can not be empty");
        } else {
            mLoginEditTextPassword.setError(null);

            if (Conditions.isNetworkConnected(LoginActivity.this)) {
                doLogin(username, password);
                // ((MainActivity) getActivity()).onMeetingListSelected();
            } else {
                Toast.makeText(LoginActivity.this, "Network Eror", Toast.LENGTH_SHORT).show();
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
        //Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        showToast("Click back again to exit.");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}

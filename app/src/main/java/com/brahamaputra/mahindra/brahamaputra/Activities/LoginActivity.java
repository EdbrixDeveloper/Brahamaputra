package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
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

import com.brahamaputra.mahindra.brahamaputra.R;

public class LoginActivity extends AppCompatActivity {

    private ImageView mImageView;
    private EditText mLoginEditTextUsername;
    private EditText mLoginEditTextPassword;
    private Button mLoginButtonLogin;
    private TextView loginTextViewForgotPassword;
    final public int CHECK_PERMISSIONS = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        assignViews();
        checkPermission();
        setListener();
        hideKeyboard();
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
                    //doLogin
                    doLogin();
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

    private void setListener(){
        mLoginButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

        loginTextViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mLoginEditTextUsername.getWindowToken(), 0);
    }

    private void doLogin(){
        startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(LoginActivity.this,Manifest.permission.CAMERA) +
            ContextCompat.checkSelfPermission(LoginActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE) +
            ContextCompat.checkSelfPermission(LoginActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) +
            ContextCompat.checkSelfPermission(LoginActivity.this,Manifest.permission.ACCESS_FINE_LOCATION) +
            ContextCompat.checkSelfPermission(LoginActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions(LoginActivity.this,
                    new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION,},
                    CHECK_PERMISSIONS);
        } else {
            //Toast.makeText(LoginActivity.this,"Already Granted",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CHECK_PERMISSIONS: {
                boolean isPerpermissionForAllGranted = false;
                if (grantResults.length > 0){
                    boolean CAMERA = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean READ_EXTERNAL_STORAGE = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean WRITE_EXTERNAL_STORAGE = grantResults[2] == PackageManager.PERMISSION_GRANTED;
                    boolean ACCESS_FINE_LOCATION = grantResults[3] == PackageManager.PERMISSION_GRANTED;
                    boolean ACCESS_COARSE_LOCATION = grantResults[4] == PackageManager.PERMISSION_GRANTED;

                    if(CAMERA && READ_EXTERNAL_STORAGE && WRITE_EXTERNAL_STORAGE && ACCESS_FINE_LOCATION && ACCESS_COARSE_LOCATION){
                        //Toast.makeText(LoginActivity.this,"all permission granted",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(LoginActivity.this,"some permission not granted",Toast.LENGTH_LONG).show();
                        if(!ACCESS_COARSE_LOCATION || !ACCESS_COARSE_LOCATION){
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
}

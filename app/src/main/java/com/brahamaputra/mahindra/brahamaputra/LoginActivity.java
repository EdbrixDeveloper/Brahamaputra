package com.brahamaputra.mahindra.brahamaputra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    private ImageView mImageView;
    private EditText mLoginEditTextUsername;
    private EditText mLoginEditTextPassword;
    private Button mLoginButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        assignViews();
        setListner();
    }
    private void setListner(){
        mLoginButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
            }
        });
    }



    private void assignViews() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        mLoginEditTextUsername = (EditText) findViewById(R.id.login_editText_username);
        mLoginEditTextPassword = (EditText) findViewById(R.id.login_editText_password);
        mLoginButtonLogin = (Button) findViewById(R.id.login_button_login);

    }



}

package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText mForgotPasswordEditTextMobileNumber;
    private Button mForgotPasswordButtonSubmit;
    private GlobalMethods globalMethods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        this.setTitle("Forgot Password");
        assignViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        globalMethods = new GlobalMethods();

        mForgotPasswordButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidations();
            }
        });


    }

    private void checkValidations() {

        String mobile = mForgotPasswordEditTextMobileNumber.getText().toString();
        Conditions.hideKeyboard(ForgotPasswordActivity.this);
        if (mobile.isEmpty()) {
            mForgotPasswordEditTextMobileNumber.setError("Field can not be empty");
        } else if (globalMethods.validatePhoneNumber(mobile) == false) {
            mForgotPasswordEditTextMobileNumber.setError("Please validate mobile number");
        }else {
            doForgot(mobile);
        }

    }

    private void doForgot(String mobile) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void assignViews() {
        mForgotPasswordEditTextMobileNumber = (EditText) findViewById(R.id.forgotPassword_editText_mobileNumber);
        mForgotPasswordButtonSubmit = (Button) findViewById(R.id.forgotPassword_button_submit);
    }



}

package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;

public class UserHotoTransactionActivity extends AppCompatActivity {


    private EditText mUserHotoTransEditTextCustomerName;
    private EditText mUserHotoTransEditTextState;
    private EditText mUserHotoTransEditTextNameOfCircle;
    private EditText mUserHotoTransEditTextNameOfssa;
    private EditText mUserHotoTransEditTextNameOfsite;
    private EditText mUserHotoTransEditTextSiteAddress;
    private EditText mUserHotoTransEditTextSiteID;
    private TextView mUserHotoTransTextViewTypeOfTower;
    private Spinner mUserHotoTransSpinnerTypeOfSites;
    private TextView mUserHotoTransTextViewSourceOfPower;
    private Spinner mUserHotoTransSpinnerSourceOfPower;
    private Button mUserHotoTransButtonSubmitHotoTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hoto_transaction);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        assignViews();
        disableInput();

        mUserHotoTransButtonSubmitHotoTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHotoTransactionActivity.this,HotoSectionsListActivity.class));
            }
        });
    }

    private void disableInput() {
        mUserHotoTransEditTextCustomerName.setKeyListener(null);
        mUserHotoTransEditTextState.setKeyListener(null);
        mUserHotoTransEditTextNameOfCircle.setKeyListener(null);
        mUserHotoTransEditTextNameOfssa.setKeyListener(null);
        mUserHotoTransEditTextNameOfsite.setKeyListener(null);
        //mUserHotoTransEditTextSiteAddress.setKeyListener(null);
        mUserHotoTransEditTextSiteID.setKeyListener(null);
    }

    private void assignViews() {
        mUserHotoTransEditTextCustomerName = (EditText) findViewById(R.id.userHotoTrans_editText_customerName);
        mUserHotoTransEditTextState = (EditText) findViewById(R.id.userHotoTrans_editText_state);
        mUserHotoTransEditTextNameOfCircle = (EditText) findViewById(R.id.userHotoTrans_editText_nameOfCircle);
        mUserHotoTransEditTextNameOfssa = (EditText) findViewById(R.id.userHotoTrans_editText_nameOfssa);
        mUserHotoTransEditTextNameOfsite = (EditText) findViewById(R.id.userHotoTrans_editText_nameOfsite);
        mUserHotoTransEditTextSiteAddress = (EditText) findViewById(R.id.userHotoTrans_editText_siteAddress);
        mUserHotoTransEditTextSiteID = (EditText) findViewById(R.id.userHotoTrans_editText_siteID);
        mUserHotoTransTextViewTypeOfTower = (TextView) findViewById(R.id.userHotoTrans_textView_typeOfTower);
        mUserHotoTransSpinnerTypeOfSites = (Spinner) findViewById(R.id.userHotoTrans_spinner_typeOfSites);
        mUserHotoTransTextViewSourceOfPower = (TextView) findViewById(R.id.userHotoTrans_textView_sourceOfPower);
        mUserHotoTransSpinnerSourceOfPower = (Spinner) findViewById(R.id.userHotoTrans_spinner_sourceOfPower);
        mUserHotoTransButtonSubmitHotoTrans = (Button)findViewById(R.id.userHotoTrans_button_submitHotoTrans);
    }




}

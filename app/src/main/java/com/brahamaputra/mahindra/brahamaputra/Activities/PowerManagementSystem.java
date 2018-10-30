package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PowerManagementSystem extends AppCompatActivity {

    private TextView mPowerManagementSystemTextViewQRCodeScan;
    private ImageView mPowerManagementSystemButtonQRCodeScan;
    private TextView mPowerManagementSystemTextViewAssetOwner;
    private SearchableSpinner mPowerManagementSystemSpinnerAssetOwner;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemType;
    private SearchableSpinner mPowerManagementSystemSpinnerPowerManagementSystemType;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemMake;
    private SearchableSpinner mPowerManagementSystemSpinnerPowerManagementSystemMake;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemPosition;
    private SearchableSpinner mPowerManagementSystemSpinnerPowerManagementSystemPosition;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemStaus;
    private SearchableSpinner mPowerManagementSystemSpinnerPowerManagementSystemStaus;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemSerialNumber;
    private EditText mPowerManagementSystemEditTextPowerManagementSystemSerialNumber;
    private TextView mPowerManagementSystemTextViewWorkingCondition;
    private SearchableSpinner mPowerManagementSystemSpinnerWorkingCondition;
    private TextView mPowerManagementSystemTextViewNatureofProblem;
    private EditText mPowerManagementSystemEditTextNatureofProblem;

    private void assignViews() {
        mPowerManagementSystemTextViewQRCodeScan = (TextView) findViewById(R.id.powerManagementSystem_textView_QRCodeScan);
        mPowerManagementSystemButtonQRCodeScan = (ImageView) findViewById(R.id.powerManagementSystem_button_QRCodeScan);
        mPowerManagementSystemTextViewAssetOwner = (TextView) findViewById(R.id.powerManagementSystem_textView_AssetOwner);
        mPowerManagementSystemSpinnerAssetOwner = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_AssetOwner);
        mPowerManagementSystemTextViewPowerManagementSystemType = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemType);
        mPowerManagementSystemSpinnerPowerManagementSystemType = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_PowerManagementSystemType);
        mPowerManagementSystemTextViewPowerManagementSystemMake = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemMake);
        mPowerManagementSystemSpinnerPowerManagementSystemMake = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_PowerManagementSystemMake);
        mPowerManagementSystemTextViewPowerManagementSystemPosition = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemPosition);
        mPowerManagementSystemSpinnerPowerManagementSystemPosition = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_PowerManagementSystemPosition);
        mPowerManagementSystemTextViewPowerManagementSystemStaus = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemStaus);
        mPowerManagementSystemSpinnerPowerManagementSystemStaus = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_PowerManagementSystemStaus);
        mPowerManagementSystemTextViewPowerManagementSystemSerialNumber = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemSerialNumber);
        mPowerManagementSystemEditTextPowerManagementSystemSerialNumber = (EditText) findViewById(R.id.powerManagementSystem_editText_PowerManagementSystemSerialNumber);
        mPowerManagementSystemTextViewWorkingCondition = (TextView) findViewById(R.id.powerManagementSystem_textView_WorkingCondition);
        mPowerManagementSystemSpinnerWorkingCondition = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_WorkingCondition);
        mPowerManagementSystemTextViewNatureofProblem = (TextView) findViewById(R.id.powerManagementSystem_textView_NatureofProblem);
        mPowerManagementSystemEditTextNatureofProblem = (EditText) findViewById(R.id.powerManagementSystem_editText_NatureofProblem);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_management_system);
        this.setTitle("Power Management System");
        assignViews();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dropdown_details_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:finish();
               // startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;
            case R.id.menuDone:finish();
                startActivity(new Intent(this, GeneralAndSafetyMeasures.class));
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}

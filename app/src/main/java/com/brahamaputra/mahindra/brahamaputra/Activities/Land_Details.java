package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import android.view.View;

import android.widget.DatePicker;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Land_Details extends AppCompatActivity {

    private TextView mLandDetailsTextViewTypeOfLand;
    private SearchableSpinner mLandDetailsSpinnerTypeOfLand;
    private TextView mLandDetailsTextViewAreaOfLand;
    private EditText mLandDetailsEditTextAreaOfLand;
    private TextView mLandDetailsTextViewRentLeaseInNumber;
    private EditText mLandDetailsEditTextRentLeaseInNumber;
    private TextView mLandDetailsTextViewRentLeaseInWords;
    private EditText mLandDetailsEditTextRentLeaseInWords;
    private TextView mLandDetailsTextViewNameOfOwner;
    private EditText mLandDetailsEditTextNameOfOwner;
    private TextView mLandDetailsTextViewMobileNoOfOwner;
    private EditText mLandDetailsEditTextMobileNoOfOwner;
    private TextView mLandDetailsTextViewLayoutOfLand;
    private ImageView mLandDetailsButtonLayoutOfLand;
    private TextView mLandDetailsTextViewCopyAgreementWithOwner;
    private SearchableSpinner mLandDetailsSpinnerCopyAgreementWithOwner;
    private TextView mLandDetailsTextViewValidityOfAgreement;
    private EditText mLandDetailsEditTextDateOfvalidityOfAgreement;

    private void assignViews() {
        mLandDetailsTextViewTypeOfLand = (TextView) findViewById(R.id.landDetails_textView_typeOfLand);
        mLandDetailsSpinnerTypeOfLand = (SearchableSpinner) findViewById(R.id.landDetails_Spinner_typeOfLand);
        mLandDetailsTextViewAreaOfLand = (TextView) findViewById(R.id.landDetails_textView_areaOfLand);
        mLandDetailsEditTextAreaOfLand = (EditText) findViewById(R.id.landDetails_editText_areaOfLand);
        mLandDetailsTextViewRentLeaseInNumber = (TextView) findViewById(R.id.landDetails_textView_rentLeaseInNumber);
        mLandDetailsEditTextRentLeaseInNumber = (EditText) findViewById(R.id.landDetails_editText_rentLeaseInNumber);
        mLandDetailsTextViewRentLeaseInWords = (TextView) findViewById(R.id.landDetails_textView_rentLeaseInWords);
        mLandDetailsEditTextRentLeaseInWords = (EditText) findViewById(R.id.landDetails_editText_rentLeaseInWords);
        mLandDetailsTextViewNameOfOwner = (TextView) findViewById(R.id.landDetails_textView_nameOfOwner);
        mLandDetailsEditTextNameOfOwner = (EditText) findViewById(R.id.landDetails_editText_nameOfOwner);
        mLandDetailsTextViewMobileNoOfOwner = (TextView) findViewById(R.id.landDetails_textView_mobileNoOfOwner);
        mLandDetailsEditTextMobileNoOfOwner = (EditText) findViewById(R.id.landDetails_editText_mobileNoOfOwner);
        mLandDetailsTextViewLayoutOfLand = (TextView) findViewById(R.id.landDetails_textView_layoutOfLand);
        mLandDetailsButtonLayoutOfLand = (ImageView) findViewById(R.id.landDetails_button_layoutOfLand);
        mLandDetailsTextViewCopyAgreementWithOwner = (TextView) findViewById(R.id.landDetails_textView_copyAgreementWithOwner);
        mLandDetailsSpinnerCopyAgreementWithOwner = (SearchableSpinner) findViewById(R.id.landDetails_Spinner_copyAgreementWithOwner);
        mLandDetailsTextViewValidityOfAgreement = (TextView) findViewById(R.id.landDetails_textView_validityOfAgreement);
        mLandDetailsEditTextDateOfvalidityOfAgreement = (EditText) findViewById(R.id.landDetails_editText_dateOfvalidityOfAgreement);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        mLandDetailsSpinnerTypeOfLand.setTitle("Type of Land");
        mLandDetailsSpinnerCopyAgreementWithOwner.setTitle("Copy of the agreement with the landlord/owner");

    }


    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_details);
        this.setTitle("Land Detail");
        assignViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        mLandDetailsEditTextDateOfvalidityOfAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Land_Details.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mLandDetailsEditTextDateOfvalidityOfAgreement.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.submit_icon_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.menuSubmit:
                this.finish();
                startActivity(new Intent(this, Tower_Detail.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}



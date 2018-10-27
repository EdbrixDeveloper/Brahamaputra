package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import android.view.View;

import android.widget.DatePicker;

import com.brahamaputra.mahindra.brahamaputra.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Land_Details extends AppCompatActivity {

    private TextView mLandDetailsTextViewTypeOfLand;
    private Spinner mLandDetailsSpinnerTypeOfLand;
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
    private EditText mLandDetailsEditTextLayoutOfLand;
    private TextView mLandDetailsTextViewCopyAgreementWithOwner;
    private Spinner mLandDetailsSpinnerCopyAgreementWithOwner;
    private TextView mLandDetailsTextViewValidityOfLand;
    private EditText mLandDetailsEditTextDateOfvalidityOfLand;

    private void assignViews() {
        mLandDetailsTextViewTypeOfLand = (TextView) findViewById(R.id.landDetails_textView_typeOfLand);
        mLandDetailsSpinnerTypeOfLand = (Spinner) findViewById(R.id.landDetails_Spinner_typeOfLand);
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
        mLandDetailsEditTextLayoutOfLand = (EditText) findViewById(R.id.landDetails_editText_layoutOfLand);
        mLandDetailsTextViewCopyAgreementWithOwner = (TextView) findViewById(R.id.landDetails_textView_copyAgreementWithOwner);
        mLandDetailsSpinnerCopyAgreementWithOwner = (Spinner) findViewById(R.id.landDetails_Spinner_copyAgreementWithOwner);
        mLandDetailsTextViewValidityOfLand = (TextView) findViewById(R.id.landDetails_textView_validityOfLand);
        mLandDetailsEditTextDateOfvalidityOfLand = (EditText) findViewById(R.id.landDetails_editText_dateOfvalidityOfLand);
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

        mLandDetailsEditTextDateOfvalidityOfLand.setOnClickListener(new View.OnClickListener() {
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

        mLandDetailsEditTextDateOfvalidityOfLand.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            /*case android.R.id.home:
                finish();
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}



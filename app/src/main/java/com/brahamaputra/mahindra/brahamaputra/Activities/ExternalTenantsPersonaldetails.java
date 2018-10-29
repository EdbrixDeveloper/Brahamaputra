package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.DatePickerDialog;
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

public class ExternalTenantsPersonaldetails extends AppCompatActivity {


    private TextView mExternalTenantsPersonaldetailsTextViewTotalNumberofTanents;
    private SearchableSpinner mExternalTenantsPersonaldetailsSpinnerTotalNumberofTanents;
    private TextView mExternalTenantsPersonaldetailsTextViewNameoftheTenant;
    private SearchableSpinner mExternalTenantsPersonaldetailsSpinnerNameoftheTenant;
    private TextView mExternalTenantsPersonaldetailsTextViewTypeofTenant;
    private SearchableSpinner mExternalTenantsPersonaldetailsSpinnerTypeofTenant;
    private TextView mExternalTenantsPersonaldetailsTextViewPositionattheTower;
    private EditText mExternalTenantsPersonaldetailsEditTextPositionattheTower;
    private TextView mExternalTenantsPersonaldetailsTextViewDateofthestartofTenancy;
    private EditText mExternalTenantsPersonaldetailsEditTextDateofthestartofTenancy;
    private TextView mExternalTenantsPersonaldetailsTextViewDateofthestartofRadiation;
    private EditText mExternalTenantsPersonaldetailsEditTextDateofthestartofRadiation;
    private TextView mExternalTenantsPersonaldetailsTextViewNameoftheContactPerson;
    private EditText mExternalTenantsPersonaldetailsEditTextNameoftheContactPerson;
    private TextView mExternalTenantsPersonaldetailsTextViewAddressoftheContactPerson;
    private EditText mExternalTenantsPersonaldetailsEditTextAddressoftheContactPerson;
    private TextView mExternalTenantsPersonaldetailsTextViewTelephoneNoofContactPersonMobile;
    private EditText mExternalTenantsPersonaldetailsEditTextTelephoneNoofContactPersonMobile;
    private TextView mExternalTenantsPersonaldetailsTextViewTelephoneNoofContactPersonLandline;
    private EditText mExternalTenantsPersonaldetailseditTextTelephoneNoofContactPersonLandline;

    private void assignViews() {
        mExternalTenantsPersonaldetailsTextViewTotalNumberofTanents = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_TotalNumberofTanents);
        mExternalTenantsPersonaldetailsSpinnerTotalNumberofTanents = (SearchableSpinner) findViewById(R.id.externalTenantsPersonaldetails_spinner_TotalNumberofTanents);
        mExternalTenantsPersonaldetailsTextViewNameoftheTenant = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_NameoftheTenant);
        mExternalTenantsPersonaldetailsSpinnerNameoftheTenant = (SearchableSpinner) findViewById(R.id.externalTenantsPersonaldetails_spinner_NameoftheTenant);
        mExternalTenantsPersonaldetailsTextViewTypeofTenant = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_TypeofTenant);
        mExternalTenantsPersonaldetailsSpinnerTypeofTenant = (SearchableSpinner) findViewById(R.id.externalTenantsPersonaldetails_spinner_TypeofTenant);
        mExternalTenantsPersonaldetailsTextViewPositionattheTower = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_PositionattheTower);
        mExternalTenantsPersonaldetailsEditTextPositionattheTower = (EditText) findViewById(R.id.externalTenantsPersonaldetails_editText_PositionattheTower);
        mExternalTenantsPersonaldetailsTextViewDateofthestartofTenancy = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_DateofthestartofTenancy);
        mExternalTenantsPersonaldetailsEditTextDateofthestartofTenancy = (EditText) findViewById(R.id.externalTenantsPersonaldetails_editText_DateofthestartofTenancy);
        mExternalTenantsPersonaldetailsTextViewDateofthestartofRadiation = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_DateofthestartofRadiation);
        mExternalTenantsPersonaldetailsEditTextDateofthestartofRadiation = (EditText) findViewById(R.id.externalTenantsPersonaldetails_editText_DateofthestartofRadiation);
        mExternalTenantsPersonaldetailsTextViewNameoftheContactPerson = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_NameoftheContactPerson);
        mExternalTenantsPersonaldetailsEditTextNameoftheContactPerson = (EditText) findViewById(R.id.externalTenantsPersonaldetails_editText_NameoftheContactPerson);
        mExternalTenantsPersonaldetailsTextViewAddressoftheContactPerson = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_AddressoftheContactPerson);
        mExternalTenantsPersonaldetailsEditTextAddressoftheContactPerson = (EditText) findViewById(R.id.externalTenantsPersonaldetails_editText_AddressoftheContactPerson);
        mExternalTenantsPersonaldetailsTextViewTelephoneNoofContactPersonMobile = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_TelephoneNoofContactPersonMobile);
        mExternalTenantsPersonaldetailsEditTextTelephoneNoofContactPersonMobile = (EditText) findViewById(R.id.externalTenantsPersonaldetails_editText_TelephoneNoofContactPersonMobile);
        mExternalTenantsPersonaldetailsTextViewTelephoneNoofContactPersonLandline = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_TelephoneNoofContactPersonLandline);
        mExternalTenantsPersonaldetailseditTextTelephoneNoofContactPersonLandline = (EditText) findViewById(R.id.externalTenantsPersonaldetailseditTextTelephoneNoofContactPersonLandline);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_tenants_personal_details);
        this.setTitle("External Tenants Personal details");
        assignViews();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel_DateofthestartofTenancy();
            }

        };

        final DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel_DateofthestartofRadiation();
            }

        };

        mExternalTenantsPersonaldetailsEditTextDateofthestartofTenancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ExternalTenantsPersonaldetails.this, date1, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        mExternalTenantsPersonaldetailsEditTextDateofthestartofRadiation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ExternalTenantsPersonaldetails.this, date2, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dropdown_details_menu, menu);
        return true;
    }

    private void updateLabel_DateofthestartofTenancy() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mExternalTenantsPersonaldetailsEditTextDateofthestartofTenancy.setText(sdf.format(myCalendar.getTime()));

    }

    private void updateLabel_DateofthestartofRadiation() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);


        mExternalTenantsPersonaldetailsEditTextDateofthestartofRadiation.setText(sdf.format(myCalendar.getTime()));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menuDone:
                finish();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}

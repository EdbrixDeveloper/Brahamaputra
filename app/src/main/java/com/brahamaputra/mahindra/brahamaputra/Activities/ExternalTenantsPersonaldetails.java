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
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class ExternalTenantsPersonaldetails extends BaseActivity {



    final Calendar myCalendar = Calendar.getInstance();


    String str_totalNumberofTanents;
    String str_nameoftheTenant;
    String str_typeofTenant;

    private TextView mExternalTenantsPersonaldetailsTextViewTotalNumberofTanents;
    private TextView mExternalTenantsPersonaldetailsTextViewTotalNumberofTanentsVal;
    private TextView mExternalTenantsPersonaldetailsTextViewNameoftheTenant;
    private TextView mExternalTenantsPersonaldetailsTextViewNameoftheTenantVal;
    private TextView mExternalTenantsPersonaldetailsTextViewTypeofTenant;
    private TextView mExternalTenantsPersonaldetailsTextViewTypeofTenantVal;
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
        mExternalTenantsPersonaldetailsTextViewTotalNumberofTanentsVal = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_TotalNumberofTanents_val);
        mExternalTenantsPersonaldetailsTextViewNameoftheTenant = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_NameoftheTenant);
        mExternalTenantsPersonaldetailsTextViewNameoftheTenantVal = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_NameoftheTenant_val);
        mExternalTenantsPersonaldetailsTextViewTypeofTenant = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_TypeofTenant);
        mExternalTenantsPersonaldetailsTextViewTypeofTenantVal = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_TypeofTenant_val);
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

    private void initCombo()
    {
        mExternalTenantsPersonaldetailsTextViewTotalNumberofTanentsVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(ExternalTenantsPersonaldetails.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_externalTenantsPersonaldetails_TotalNumberofTanents))),
                        "Total Number of Tanents",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_totalNumberofTanents = item.get(position);
                        mExternalTenantsPersonaldetailsTextViewTotalNumberofTanentsVal.setText(str_totalNumberofTanents);
                    }
                });

            }
        });
        mExternalTenantsPersonaldetailsTextViewNameoftheTenantVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(ExternalTenantsPersonaldetails.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_externalTenantsPersonaldetails_NameoftheTenant))),
                        "Name of the Tenant",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_nameoftheTenant = item.get(position);
                        mExternalTenantsPersonaldetailsTextViewNameoftheTenantVal.setText(str_nameoftheTenant);
                    }
                });

            }
        });
        mExternalTenantsPersonaldetailsTextViewTypeofTenantVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(ExternalTenantsPersonaldetails.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_externalTenantsPersonaldetails_TypeofTenant))),
                        "Type of Tenant",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeofTenant = item.get(position);
                        mExternalTenantsPersonaldetailsTextViewTypeofTenantVal.setText(str_typeofTenant);
                    }
                });

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_tenants_personal_details);
        this.setTitle("External Tenants Personal details");
        assignViews();
        initCombo();
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
                //startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;
            case R.id.menuDone:
                finish();
                startActivity(new Intent(this, Total_DC_Load_site.class));
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}

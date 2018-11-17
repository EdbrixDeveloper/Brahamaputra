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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.Data.ExternalTenantsPersonalDetailsData;
import com.brahamaputra.mahindra.brahamaputra.Data.ExternalTenantsPersonalDetailsParentData;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.LandDetailsData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";
    private HotoTransactionData hotoTransactionData;
    private ExternalTenantsPersonalDetailsParentData externalTenantsPersonalDetailsParentData;
    private ArrayList<ExternalTenantsPersonalDetailsData> externalTenantsPersonalDetailsDataList;
    private String base64StringLayoutOfLand = "eji39jjj";
    private SessionManager sessionManager;
    private int totalTenantCount = 0;
    private int currentPos = 0;

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
    private Button btnPrevReadingExtTenants;
    private Button btnNextReadingExtTenants;
    private LinearLayout lnrTentantDetails;

    private TextView mexternalTenantsPersonaldetails_textView_TentantCount;

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
        mexternalTenantsPersonaldetails_textView_TentantCount = (TextView) findViewById(R.id.externalTenantsPersonaldetails_textView_TentantCount);
        lnrTentantDetails = (LinearLayout) findViewById(R.id.lnrTentantDetails);
        lnrTentantDetails.setVisibility(View.GONE);
        btnPrevReadingExtTenants = (Button) findViewById(R.id.btnPrevReadingExtTenants);
        btnNextReadingExtTenants = (Button) findViewById(R.id.btnNextReadingExtTenants);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );


    }

    private void initCombo() {
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

                        currentPos = 0;
                        totalTenantCount = Integer.parseInt(str_totalNumberofTanents);
                        clearFields(currentPos);
                        //clear TenantData collection empty by select / changing value of No of Tenant selected
                        if (externalTenantsPersonalDetailsDataList != null && externalTenantsPersonalDetailsDataList.size() > 0) {
                            externalTenantsPersonalDetailsDataList.clear();
                        }
                        if(totalTenantCount>0){
                            mexternalTenantsPersonaldetails_textView_TentantCount.setText("Tenant: #1");
                            lnrTentantDetails.setVisibility(View.VISIBLE);
                            btnPrevReadingExtTenants.setVisibility(View.GONE);
                            btnNextReadingExtTenants.setVisibility(View.VISIBLE);
                            if (totalTenantCount > 0 && totalTenantCount == 1) {
                                btnNextReadingExtTenants.setText("Finish");
                            } else {
                                btnNextReadingExtTenants.setText("Next Reading");
                            }
                        }else{
                            lnrTentantDetails.setVisibility(View.GONE);
                        }


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
        sessionManager = new SessionManager(ExternalTenantsPersonaldetails.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(ExternalTenantsPersonaldetails.this, userId, ticketName);
        assignViews();
        initCombo();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        hotoTransactionData = new HotoTransactionData();
        externalTenantsPersonalDetailsDataList = new ArrayList<>();
        setInputDetails(0);


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

        btnPrevReadingExtTenants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPos > 0) {
                    //Save current reading
                    saveTenantRecords(currentPos);
                    currentPos = currentPos - 1;
                    //move to Next reading
                    displayTenantRecords(currentPos);
                }
            }
        });

        btnNextReadingExtTenants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPos < (totalTenantCount - 1)) {
                    //Save current  reading
                    saveTenantRecords(currentPos);
                    currentPos = currentPos + 1;
                    //move to Next reading
                    displayTenantRecords(currentPos);

                } else if (currentPos == (totalTenantCount - 1)) {
                    //Save Final current reading and submit all  data
                    saveTenantRecords(currentPos);
                    submitDetails();
                    startActivity(new Intent(ExternalTenantsPersonaldetails.this, Total_DC_Load_site.class));
                    finish();
                }
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
                submitDetails();
                finish();
                startActivity(new Intent(this, Total_DC_Load_site.class));
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    private void setInputDetails(int index) {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");

                Gson gson = new Gson();

                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);
                externalTenantsPersonalDetailsParentData = hotoTransactionData.getExternalTenantsPersonalDetailsParentData();
                externalTenantsPersonalDetailsDataList.addAll(externalTenantsPersonalDetailsParentData.getExternalTenantsPersonalDetailsData());

                if (externalTenantsPersonalDetailsDataList != null && externalTenantsPersonalDetailsDataList.size() > 0) {
                    totalTenantCount = externalTenantsPersonalDetailsDataList.size();
                    mExternalTenantsPersonaldetailsTextViewTotalNumberofTanentsVal.setText(externalTenantsPersonalDetailsParentData.getTotalNumberofTanents());
                    lnrTentantDetails.setVisibility(View.VISIBLE);
                    ExternalTenantsPersonalDetailsData externalTenantsPersonalDetailsData = externalTenantsPersonalDetailsDataList.get(index);
                    mExternalTenantsPersonaldetailsTextViewNameoftheTenantVal.setText(externalTenantsPersonalDetailsData.getNameofTenant());
                    mExternalTenantsPersonaldetailsTextViewTypeofTenantVal.setText(externalTenantsPersonalDetailsData.getTypeofTenant());
                    mExternalTenantsPersonaldetailsEditTextPositionattheTower.setText(externalTenantsPersonalDetailsData.getPositionattheTower());
                    mExternalTenantsPersonaldetailsEditTextDateofthestartofTenancy.setText(externalTenantsPersonalDetailsData.getDateofstartofTenancy());
                    mExternalTenantsPersonaldetailsEditTextDateofthestartofRadiation.setText(externalTenantsPersonalDetailsData.getDateofstartofRadiation());
                    mExternalTenantsPersonaldetailsEditTextNameoftheContactPerson.setText(externalTenantsPersonalDetailsData.getNameofContactPerson());
                    mExternalTenantsPersonaldetailsEditTextAddressoftheContactPerson.setText(externalTenantsPersonalDetailsData.getAddressofContactPerson());
                    mExternalTenantsPersonaldetailsEditTextTelephoneNoofContactPersonMobile.setText(externalTenantsPersonalDetailsData.getContactPersonMobile());
                    mExternalTenantsPersonaldetailseditTextTelephoneNoofContactPersonLandline.setText(externalTenantsPersonalDetailsData.getContactPersonLandline());
                }


            } else {
                Toast.makeText(ExternalTenantsPersonaldetails.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayTenantRecords(int pos) {

        if (externalTenantsPersonalDetailsDataList.size() > 0 && pos < externalTenantsPersonalDetailsDataList.size()) {

            mexternalTenantsPersonaldetails_textView_TentantCount.setText("Tentant: #" + (pos + 1));

            ExternalTenantsPersonalDetailsData externalTenantsPersonalDetailsData = externalTenantsPersonalDetailsDataList.get(pos);
            mExternalTenantsPersonaldetailsTextViewNameoftheTenantVal.setText(externalTenantsPersonalDetailsData.getNameofTenant());
            mExternalTenantsPersonaldetailsTextViewTypeofTenantVal.setText(externalTenantsPersonalDetailsData.getTypeofTenant());
            mExternalTenantsPersonaldetailsEditTextPositionattheTower.setText(externalTenantsPersonalDetailsData.getPositionattheTower());
            mExternalTenantsPersonaldetailsEditTextDateofthestartofTenancy.setText(externalTenantsPersonalDetailsData.getDateofstartofTenancy());
            mExternalTenantsPersonaldetailsEditTextDateofthestartofRadiation.setText(externalTenantsPersonalDetailsData.getDateofstartofRadiation());
            mExternalTenantsPersonaldetailsEditTextNameoftheContactPerson.setText(externalTenantsPersonalDetailsData.getNameofContactPerson());
            mExternalTenantsPersonaldetailsEditTextAddressoftheContactPerson.setText(externalTenantsPersonalDetailsData.getAddressofContactPerson());
            mExternalTenantsPersonaldetailsEditTextTelephoneNoofContactPersonMobile.setText(externalTenantsPersonalDetailsData.getContactPersonMobile());
            mExternalTenantsPersonaldetailseditTextTelephoneNoofContactPersonLandline.setText(externalTenantsPersonalDetailsData.getContactPersonLandline());

            btnPrevReadingExtTenants.setVisibility(View.VISIBLE);
            btnNextReadingExtTenants.setVisibility(View.VISIBLE);

        } else {
            clearFields(pos);
        }

        if (pos > 0 && pos < (totalTenantCount - 1)) {
            btnPrevReadingExtTenants.setVisibility(View.VISIBLE);
            btnNextReadingExtTenants.setText("Next Reading");
        } else if (pos > 0 && pos == (totalTenantCount - 1)) {
            btnPrevReadingExtTenants.setVisibility(View.VISIBLE);
            btnNextReadingExtTenants.setText("Finish");
        } else if (pos == 0) {
            btnPrevReadingExtTenants.setVisibility(View.GONE);
            if (pos == (totalTenantCount - 1)) {
                btnNextReadingExtTenants.setText("Finish");
            } else {
                btnNextReadingExtTenants.setText("Next Reading");
            }
        }
    }

        private void saveTenantRecords ( int pos){
            String nameofTenant = mExternalTenantsPersonaldetailsTextViewNameoftheTenantVal.getText().toString().trim();
            String typeofTenant = mExternalTenantsPersonaldetailsTextViewTypeofTenantVal.getText().toString().trim();
            String positionattheTower = mExternalTenantsPersonaldetailsEditTextPositionattheTower.getText().toString().trim();
            String dateofstartofTenancy = mExternalTenantsPersonaldetailsEditTextDateofthestartofTenancy.getText().toString().trim();
            String dateofstartofRadiation = mExternalTenantsPersonaldetailsEditTextDateofthestartofRadiation.getText().toString().trim();
            String nameofContactPerson = mExternalTenantsPersonaldetailsEditTextNameoftheContactPerson.getText().toString().trim();
            String addressofContactPerson = mExternalTenantsPersonaldetailsEditTextAddressoftheContactPerson.getText().toString().trim();
            String contactPersonMobile = mExternalTenantsPersonaldetailsEditTextTelephoneNoofContactPersonMobile.getText().toString().trim();
            String contactPersonLandline = mExternalTenantsPersonaldetailseditTextTelephoneNoofContactPersonLandline.getText().toString().trim();
            ExternalTenantsPersonalDetailsData externalTenantsPersonalDetailsData = new ExternalTenantsPersonalDetailsData(nameofTenant, typeofTenant, positionattheTower, dateofstartofTenancy, dateofstartofRadiation, nameofContactPerson, addressofContactPerson, contactPersonMobile, contactPersonLandline);


            if (externalTenantsPersonalDetailsDataList.size() > 0) {
                if (pos == externalTenantsPersonalDetailsDataList.size()) {
                    externalTenantsPersonalDetailsDataList.add(externalTenantsPersonalDetailsData);
                } else if (pos < externalTenantsPersonalDetailsDataList.size()) {
                    externalTenantsPersonalDetailsDataList.set(pos, externalTenantsPersonalDetailsData);
                }
            } else {
                externalTenantsPersonalDetailsDataList.add(externalTenantsPersonalDetailsData);
            }
        }

        private void submitDetails() {
            try {
                // hotoTransactionData.setTicketNo(ticketId);
                String totalNumberofTanents = mExternalTenantsPersonaldetailsTextViewTotalNumberofTanentsVal.getText().toString().trim();

                externalTenantsPersonalDetailsParentData.setSubmited(true);
                externalTenantsPersonalDetailsParentData.setTotalNumberofTanents(totalNumberofTanents);
                externalTenantsPersonalDetailsParentData.setExternalTenantsPersonalDetailsData(externalTenantsPersonalDetailsDataList);

                hotoTransactionData.setExternalTenantsPersonalDetailsParentData(externalTenantsPersonalDetailsParentData);

                Gson gson2 = new GsonBuilder().create();
                String jsonString = gson2.toJson(hotoTransactionData);
                //Toast.makeText(Land_Details.this, "Gson to json string :" + jsonString, Toast.LENGTH_SHORT).show();

                offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void clearFields(int indexPos) {

        mexternalTenantsPersonaldetails_textView_TentantCount.setText("Tentant: #"+ (indexPos + 1));

        mExternalTenantsPersonaldetailsTextViewNameoftheTenantVal.setText("");
        mExternalTenantsPersonaldetailsTextViewTypeofTenantVal.setText("");
        mExternalTenantsPersonaldetailsEditTextPositionattheTower.setText("");
        mExternalTenantsPersonaldetailsEditTextDateofthestartofTenancy.setText("");
        mExternalTenantsPersonaldetailsEditTextDateofthestartofRadiation.setText("");
        mExternalTenantsPersonaldetailsEditTextNameoftheContactPerson.setText("");
        mExternalTenantsPersonaldetailsEditTextAddressoftheContactPerson.setText("");
        mExternalTenantsPersonaldetailsEditTextTelephoneNoofContactPersonMobile.setText("");
        mExternalTenantsPersonaldetailseditTextTelephoneNoofContactPersonLandline.setText("");
    }


    }

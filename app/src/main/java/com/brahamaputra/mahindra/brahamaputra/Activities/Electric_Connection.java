package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import android.widget.TextView;
import android.widget.TimePicker;

import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

//import ir.samanjafari.easycountdowntimer.CountDownInterface;
//import ir.samanjafari.easycountdowntimer.EasyCountDownTextview;

public class Electric_Connection extends BaseActivity {


    private TextView mElectricConnectionTextViewTypeOfElectricConnection;
    private TextView mElectricConnectionTextViewTypeOfElectricConnectionVal;
    private TextView mElectricConnectionTextViewTariff;
    private TextView mElectricConnectionTextViewTariffVal;
    private TextView mElectricConnectionTextViewSanctionedLoadKVA;
    private EditText mElectricConnectionEditTextSanctionedLoadKVA;
    private TextView mElectricConnectionTextViewExistingLoadAtSiteKVA;
    private EditText mElectricConnectionEditTextExistingLoadAtSiteKVA;
    private TextView mElectricConnectionTextViewNameOfSupplyCompany;
    private EditText mElectricConnectionEditTextNameOfSupplyCompany;
    private TextView mElectricConnectionTextViewCopyOfElectricBills;
    private TextView mElectricConnectionTextViewCopyOfElectricBillsVal;
    private TextView mElectricConnectionTextViewNumberOfCompoundLights;
    private EditText mElectricConnectionEditTextNumberOfCompoundLights;
    private TextView mElectricConnectionTextViewEbMeterReadingInKWh;
    private EditText mElectricConnectionEditTextEbMeterReadingInKWh;
    private TextView mElectricConnectionTextViewEbSupplier;
    private TextView mElectricConnectionTextViewEbSupplierVal;
    private TextView mElectricConnectionTextViewEbCostPerUnitForSharedConnection;
    private EditText mElectricConnectionEditTextEbCostPerUnitForSharedConnection;
    private TextView mElectricConnectionTextViewEbStatus;
    private TextView mElectricConnectionTextViewEbStatusVal;
    private TextView mElectricConnectionTextViewTransformerWorkingCondition;
    private TextView mElectricConnectionTextViewTransformerWorkingConditionVal;
    private TextView mElectricConnectionTextViewTransformerCapacityInKva;
    private EditText mElectricConnectionEditTextTransformerCapacityInKva;
    private TextView mElectricConnectionTextViewEbMeterBoxStatus;
    private TextView mElectricConnectionTextViewEbMeterBoxStatusVal;
    private TextView mElectricConnectionTextViewSectionName;
    private EditText mElectricConnectionEditTextSectionName;
    private TextView mElectricConnectionTextViewSectionNumber;
    private EditText mElectricConnectionEditTextSectionNumber;
    private TextView mElectricConnectionTextViewConsumerNumber;
    private EditText mElectricConnectionEditTextConsumerNumber;
    private TextView mElectricConnectionTextViewEbMeterWorkingStatus;
    private TextView mElectricConnectionTextViewEbMeterWorkingStatusVal;
    private TextView mElectricConnectionTextViewEbMeterSerialNumber;
    private EditText mElectricConnectionEditTextEbMeterSerialNumber;
    private TextView mElectricConnectionTextViewTypeOfPayment;
    private TextView mElectricConnectionTextViewTypeOfPaymentVal;
    private TextView mElectricConnectionTextViewEbPaymentSchedule;
    private TextView mElectricConnectionTextViewEbPaymentScheduleVal;
    private TextView mElectricConnectionTextViewSafetyFuseUnit;
    private TextView mElectricConnectionTextViewSafetyFuseUnitVal;
    private TextView mElectricConnectionTextViewKitKatClayFuseStatus;
    private TextView mElectricConnectionTextViewKitKatClayFuseStatusVal;
    private TextView mElectricConnectionTextViewEbNeutralEarthing;
    private TextView mElectricConnectionTextViewEbNeutralEarthingVal;
    private TextView mElectricConnectionTextViewAverageEbAvailabilityPerDay;
    private EditText mElectricConnectionEditTextAverageEbAvailabilityPerDay;
    private TextView mElectricConnectionTextViewScheduledPowerCutInHrs;
    private EditText mElectricConnectionEditTextScheduledPowerCutInHrs;
    private TextView mElectricConnectionTextViewEbBillDate;
    private EditText mElectricConnectionEditTextEbBillDate;


    String selectedHour = "HH", selectedMinute = "MM";

    String str_typeOfElectricConnection;
    String str_tariff;
    String str_copyOfElectricBills;
    String str_ebSupplier;
    String str_ebStatus;
    String str_transformerWorkingCondition;
    String str_ebMeterBoxStatus;
    String str_ebMeterWorkingStatus;
    String str_typeOfPayment;
    String str_ebPaymentSchedule;
    String str_safetyFuseUnit;
    String str_kitKatClayFuseStatus;
    String str_ebNeutralEarthing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_connection);
        this.setTitle("Electric Connection");
        assignViews();
        initCombo();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mElectricConnectionEditTextAverageEbAvailabilityPerDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Electric_Connection.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        mElectricConnectionEditTextAverageEbAvailabilityPerDay.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time For Average Eb Availability");
                mTimePicker.show();

            }
        });

        mElectricConnectionEditTextScheduledPowerCutInHrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Electric_Connection.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        mElectricConnectionEditTextScheduledPowerCutInHrs.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time For Scheduled Power Cut");
                mTimePicker.show();

            }
        });


    }

    private void assignViews() {
        mElectricConnectionTextViewTypeOfElectricConnection = (TextView) findViewById(R.id.electricConnection_textView_typeOfElectricConnection);
        mElectricConnectionTextViewTypeOfElectricConnectionVal = (TextView) findViewById(R.id.electricConnection_textView_typeOfElectricConnection_val);
        mElectricConnectionTextViewTariff = (TextView) findViewById(R.id.electricConnection_textView_tariff);
        mElectricConnectionTextViewTariffVal = (TextView) findViewById(R.id.electricConnection_textView_tariff_val);
        mElectricConnectionTextViewSanctionedLoadKVA = (TextView) findViewById(R.id.electricConnection_textView_sanctionedLoadKVA);
        mElectricConnectionEditTextSanctionedLoadKVA = (EditText) findViewById(R.id.electricConnection_editText_sanctionedLoadKVA);
        mElectricConnectionTextViewExistingLoadAtSiteKVA = (TextView) findViewById(R.id.electricConnection_textView_existingLoadAtSiteKVA);
        mElectricConnectionEditTextExistingLoadAtSiteKVA = (EditText) findViewById(R.id.electricConnection_editText_existingLoadAtSiteKVA);
        mElectricConnectionTextViewNameOfSupplyCompany = (TextView) findViewById(R.id.electricConnection_textView_nameOfSupplyCompany);
        mElectricConnectionEditTextNameOfSupplyCompany = (EditText) findViewById(R.id.electricConnection_editText_nameOfSupplyCompany);
        mElectricConnectionTextViewCopyOfElectricBills = (TextView) findViewById(R.id.electricConnection_textView_copyOfElectricBills);
        mElectricConnectionTextViewCopyOfElectricBillsVal = (TextView) findViewById(R.id.electricConnection_textView_copyOfElectricBills_val);
        mElectricConnectionTextViewNumberOfCompoundLights = (TextView) findViewById(R.id.electricConnection_textView_numberOfCompoundLights);
        mElectricConnectionEditTextNumberOfCompoundLights = (EditText) findViewById(R.id.electricConnection_editText_numberOfCompoundLights);
        mElectricConnectionTextViewEbMeterReadingInKWh = (TextView) findViewById(R.id.electricConnection_textView_ebMeterReadingInKWh);
        mElectricConnectionEditTextEbMeterReadingInKWh = (EditText) findViewById(R.id.electricConnection_editText_ebMeterReadingInKWh);
        mElectricConnectionTextViewEbSupplier = (TextView) findViewById(R.id.electricConnection_textView_ebSupplier);
        mElectricConnectionTextViewEbSupplierVal = (TextView) findViewById(R.id.electricConnection_textView_ebSupplier_val);
        mElectricConnectionTextViewEbCostPerUnitForSharedConnection = (TextView) findViewById(R.id.electricConnection_textView_ebCostPerUnitForSharedConnection);
        mElectricConnectionEditTextEbCostPerUnitForSharedConnection = (EditText) findViewById(R.id.electricConnection_editText_ebCostPerUnitForSharedConnection);
        mElectricConnectionTextViewEbStatus = (TextView) findViewById(R.id.electricConnection_textView_ebStatus);
        mElectricConnectionTextViewEbStatusVal = (TextView) findViewById(R.id.electricConnection_textView_ebStatus_val);
        mElectricConnectionTextViewTransformerWorkingCondition = (TextView) findViewById(R.id.electricConnection_textView_transformerWorkingCondition);
        mElectricConnectionTextViewTransformerWorkingConditionVal = (TextView) findViewById(R.id.electricConnection_textView_transformerWorkingCondition_val);
        mElectricConnectionTextViewTransformerCapacityInKva = (TextView) findViewById(R.id.electricConnection_textView_transformerCapacityInKva);
        mElectricConnectionEditTextTransformerCapacityInKva = (EditText) findViewById(R.id.electricConnection_editText_transformerCapacityInKva);
        mElectricConnectionTextViewEbMeterBoxStatus = (TextView) findViewById(R.id.electricConnection_textView_ebMeterBoxStatus);
        mElectricConnectionTextViewEbMeterBoxStatusVal = (TextView) findViewById(R.id.electricConnection_textView_ebMeterBoxStatus_val);
        mElectricConnectionTextViewSectionName = (TextView) findViewById(R.id.electricConnection_textView_sectionName);
        mElectricConnectionEditTextSectionName = (EditText) findViewById(R.id.electricConnection_editText_sectionName);
        mElectricConnectionTextViewSectionNumber = (TextView) findViewById(R.id.electricConnection_textView_sectionNumber);
        mElectricConnectionEditTextSectionNumber = (EditText) findViewById(R.id.electricConnection_editText_sectionNumber);
        mElectricConnectionTextViewConsumerNumber = (TextView) findViewById(R.id.electricConnection_textView_consumerNumber);
        mElectricConnectionEditTextConsumerNumber = (EditText) findViewById(R.id.electricConnection_editText_consumerNumber);
        mElectricConnectionTextViewEbMeterWorkingStatus = (TextView) findViewById(R.id.electricConnection_textView_ebMeterWorkingStatus);
        mElectricConnectionTextViewEbMeterWorkingStatusVal = (TextView) findViewById(R.id.electricConnection_textView_ebMeterWorkingStatus_val);
        mElectricConnectionTextViewEbMeterSerialNumber = (TextView) findViewById(R.id.electricConnection_textView_ebMeterSerialNumber);
        mElectricConnectionEditTextEbMeterSerialNumber = (EditText) findViewById(R.id.electricConnection_editText_ebMeterSerialNumber);
        mElectricConnectionTextViewTypeOfPayment = (TextView) findViewById(R.id.electricConnection_textView_typeOfPayment);
        mElectricConnectionTextViewTypeOfPaymentVal = (TextView) findViewById(R.id.electricConnection_textView_typeOfPayment_val);
        mElectricConnectionTextViewEbPaymentSchedule = (TextView) findViewById(R.id.electricConnection_textView_ebPaymentSchedule);
        mElectricConnectionTextViewEbPaymentScheduleVal = (TextView) findViewById(R.id.electricConnection_textView_ebPaymentSchedule_val);
        mElectricConnectionTextViewSafetyFuseUnit = (TextView) findViewById(R.id.electricConnection_textView_safetyFuseUnit);
        mElectricConnectionTextViewSafetyFuseUnitVal = (TextView) findViewById(R.id.electricConnection_textView_safetyFuseUnit_val);
        mElectricConnectionTextViewKitKatClayFuseStatus = (TextView) findViewById(R.id.electricConnection_textView_kitKatClayFuseStatus);
        mElectricConnectionTextViewKitKatClayFuseStatusVal = (TextView) findViewById(R.id.electricConnection_textView_kitKatClayFuseStatus_val);
        mElectricConnectionTextViewEbNeutralEarthing = (TextView) findViewById(R.id.electricConnection_textView_ebNeutralEarthing);
        mElectricConnectionTextViewEbNeutralEarthingVal = (TextView) findViewById(R.id.electricConnection_textView_ebNeutralEarthing_val);
        mElectricConnectionTextViewAverageEbAvailabilityPerDay = (TextView) findViewById(R.id.electricConnection_textView_averageEbAvailabilityPerDay);
        mElectricConnectionEditTextAverageEbAvailabilityPerDay = (EditText) findViewById(R.id.electricConnection_editText_averageEbAvailabilityPerDay);
        mElectricConnectionTextViewScheduledPowerCutInHrs = (TextView) findViewById(R.id.electricConnection_textView_scheduledPowerCutInHrs);
        mElectricConnectionEditTextScheduledPowerCutInHrs = (EditText) findViewById(R.id.electricConnection_editText_scheduledPowerCutInHrs);
        mElectricConnectionTextViewEbBillDate = (TextView) findViewById(R.id.electricConnection_textView_ebBillDate);
        mElectricConnectionEditTextEbBillDate = (EditText) findViewById(R.id.electricConnection_editText_ebBillDate);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );


    }

    private void initCombo() {
        mElectricConnectionTextViewTypeOfElectricConnectionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_typrOfElectricConnection))),
                        "Type of Electric Connection",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeOfElectricConnection = item.get(position);
                        mElectricConnectionTextViewTypeOfElectricConnectionVal.setText(str_typeOfElectricConnection);
                    }
                });
            }
        });

        mElectricConnectionTextViewTariffVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_tariff))),
                        "Tariff",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_tariff = item.get(position);
                        mElectricConnectionTextViewTariffVal.setText(str_tariff);
                    }
                });
            }
        });

        mElectricConnectionTextViewCopyOfElectricBillsVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_copyOfElectricBills))),
                        "Copy of the electric bills",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_copyOfElectricBills = item.get(position);
                        mElectricConnectionTextViewCopyOfElectricBillsVal.setText(str_copyOfElectricBills);
                    }
                });
            }
        });

        mElectricConnectionTextViewEbSupplierVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebSupplier))),
                        "EB Supplier",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebSupplier = item.get(position);
                        mElectricConnectionTextViewEbSupplierVal.setText(str_ebSupplier);
                    }
                });
            }
        });

        mElectricConnectionTextViewEbStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebStatus))),
                        "EB Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebStatus = item.get(position);
                        mElectricConnectionTextViewEbStatusVal.setText(str_ebStatus);
                    }
                });
            }
        });

        mElectricConnectionTextViewTransformerWorkingConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_transformerWorkingCondition))),
                        "Transformer Working Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_transformerWorkingCondition = item.get(position);
                        mElectricConnectionTextViewTransformerWorkingConditionVal.setText(str_transformerWorkingCondition);
                    }
                });
            }
        });

        mElectricConnectionTextViewEbMeterBoxStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebMeterBoxStatus))),
                        "EB Meter Box Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebMeterBoxStatus = item.get(position);
                        mElectricConnectionTextViewEbMeterBoxStatusVal.setText(str_ebMeterBoxStatus);
                    }
                });
            }
        });

        mElectricConnectionTextViewEbMeterWorkingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebMeterWorkingStatus))),
                        "EB Meter Working Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebMeterWorkingStatus = item.get(position);
                        mElectricConnectionTextViewEbMeterWorkingStatusVal.setText(str_ebMeterWorkingStatus);
                    }
                });
            }
        });

        mElectricConnectionTextViewTypeOfPaymentVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_typeOfPayment))),
                        "Type Of Payment",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeOfPayment = item.get(position);
                        mElectricConnectionTextViewTypeOfPaymentVal.setText(str_typeOfPayment);
                    }
                });
            }
        });

        mElectricConnectionTextViewEbPaymentScheduleVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebPaymentSchedule))),
                        "EB Payment Schedule",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebPaymentSchedule = item.get(position);
                        mElectricConnectionTextViewEbPaymentScheduleVal.setText(str_ebPaymentSchedule);
                    }
                });
            }
        });

        mElectricConnectionTextViewSafetyFuseUnitVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_safetyFuseUnit))),
                        "Safety Fuse Unit (SFU)",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_safetyFuseUnit = item.get(position);
                        mElectricConnectionTextViewSafetyFuseUnitVal.setText(str_safetyFuseUnit);
                    }
                });
            }
        });

        mElectricConnectionTextViewKitKatClayFuseStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_kitKatClayFuseStatus))),
                        "KIT-KAT/Clay Fuse Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_kitKatClayFuseStatus = item.get(position);
                        mElectricConnectionTextViewKitKatClayFuseStatusVal.setText(str_kitKatClayFuseStatus);
                    }
                });
            }
        });


        mElectricConnectionTextViewEbNeutralEarthingVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Electric_Connection.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebNeutralEarthing))),
                        "EB Neutral Earthing",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebNeutralEarthing = item.get(position);
                        mElectricConnectionTextViewEbNeutralEarthingVal.setText(str_ebNeutralEarthing);
                    }
                });
            }
        });
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
                //startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;

            case R.id.menuSubmit:
                finish();
                startActivity(new Intent(this, Air_Conditioners.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**/


}

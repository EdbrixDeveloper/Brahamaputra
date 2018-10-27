package com.brahamaputra.mahindra.brahamaputra;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import ir.samanjafari.easycountdowntimer.CountDownInterface;
import ir.samanjafari.easycountdowntimer.EasyCountDownTextview;

public class Electric_Connection extends AppCompatActivity {

    private TextView mElectricConnectionTextViewTypeOfElectricConnection;
    private Spinner mElectricConnectionSpinnerTypeOfElectricConnection;
    private TextView mElectricConnectionTextViewTariff;
    private Spinner mElectricConnectionSpinnerTariff;
    private TextView mElectricConnectionTextViewSanctionedLoadKVA;
    private EditText mElectricConnectionEditTextSanctionedLoadKVA;
    private TextView mElectricConnectionTextViewExistingLoadAtSiteKVA;
    private EditText mElectricConnectionEditTextExistingLoadAtSiteKVA;
    private TextView mElectricConnectionTextViewNameOfSupplyCompany;
    private EditText mElectricConnectionEditTextNameOfSupplyCompany;
    private TextView mElectricConnectionTextViewCopyOfElectricBills;
    private Spinner mElectricConnectionSpinnerCopyOfElectricBills;
    private TextView mElectricConnectionTextViewNumberOfCompoundLights;
    private EditText mElectricConnectionEditTextNumberOfCompoundLights;
    private TextView mElectricConnectionTextViewEbMeterReadingInKWh;
    private EditText mElectricConnectionEditTextEbMeterReadingInKWh;
    private TextView mElectricConnectionTextViewEbSupplier;
    private Spinner mElectricConnectionSpinnerEbSupplier;
    private TextView mElectricConnectionTextViewEbCostPerUnitForSharedConnection;
    private EditText mElectricConnectionEditTextEbCostPerUnitForSharedConnection;
    private TextView mElectricConnectionTextViewEbStatus;
    private Spinner mElectricConnectionSpinnerEbStatus;
    private TextView mElectricConnectionTextViewTransformerWorkingCondition;
    private Spinner mElectricConnectionSpinnerTransformerWorkingCondition;
    private TextView mElectricConnectionTextViewTransformerCapacityInKva;
    private EditText mElectricConnectionEditTextTransformerCapacityInKva;
    private TextView mElectricConnectionTextViewEbMeterBoxStatus;
    private Spinner mElectricConnectionSpinnerEbMeterBoxStatus;
    private TextView mElectricConnectionTextViewSectionName;
    private EditText mElectricConnectionEditTextSectionName;
    private TextView mElectricConnectionTextViewSectionNumber;
    private EditText mElectricConnectionEditTextSectionNumber;
    private TextView mElectricConnectionTextViewConsumerNumber;
    private EditText mElectricConnectionEditTextConsumerNumber;
    private TextView mElectricConnectionTextViewEbMeterWorkingStatus;
    private Spinner mElectricConnectionSpinnerEbMeterWorkingStatus;
    private TextView mElectricConnectionTextViewEbMeterSerialNumber;
    private EditText mElectricConnectionEditTextEbMeterSerialNumber;
    private TextView mElectricConnectionTextViewTypeOfPayment;
    private Spinner mElectricConnectionSpinnerTypeOfPayment;
    private TextView mElectricConnectionTextViewEbPaymentSchedule;
    private Spinner mElectricConnectionSpinnerEbPaymentSchedule;
    private TextView mElectricConnectionTextViewSafetyFuseUnit;
    private Spinner mElectricConnectionSpinnerSafetyFuseUnit;
    private TextView mElectricConnectionTextViewKitKatClayFuseStatus;
    private Spinner mElectricConnectionSpinnerKitKatClayFuseStatus;
    private TextView mElectricConnectionTextViewEbNeutralEarthing;
    private Spinner mElectricConnectionSpinnerEbNeutralEarthing;
    private TextView mElectricConnectionTextViewAverageEbAvailabilityPerDay;
    private EditText mElectricConnectionEditTextAverageEbAvailabilityPerDay;
    private TextView mElectricConnectionTextViewScheduledPowerCutInHrs;
    private EditText mElectricConnectionEditTextScheduledPowerCutInHrs;
    private TextView mElectricConnectionTextViewEbBillDate;
    private EditText mElectricConnectionEditTextEbBillDate;
    EasyCountDownTextview countDownTextview;

    String selectedHour = "HH", selectedMinute = "MM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_connection);
        this.setTitle("Electric Connection");
        assignViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mElectricConnectionEditTextAverageEbAvailabilityPerDay.setText("" + selectedHour + ":" + selectedMinute);

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
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });

        countDownTextview = (EasyCountDownTextview) findViewById(R.id.easyCountDownTextview);
        countDownTextview.setOnTick(new CountDownInterface() {
            @Override
            public void onTick(long time) {
                Log.i("main activty", "onTick");
            }

            @Override
            public void onFinish() {
                //Log.i("main activity", "onFinish");
                //Toast.makeText(getApplicationContext(),"Finish",).show();
            }
        });


/* mElectricConnectionEditTextAverageEbAvailabilityPerDay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(AddReminder.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        eReminderTime.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });*/

    }


    private void assignViews() {
        mElectricConnectionTextViewTypeOfElectricConnection = (TextView) findViewById(R.id.electricConnection_textView_typeOfElectricConnection);
        mElectricConnectionSpinnerTypeOfElectricConnection = (Spinner) findViewById(R.id.electricConnection_Spinner_typeOfElectricConnection);
        mElectricConnectionTextViewTariff = (TextView) findViewById(R.id.electricConnection_textView_tariff);
        mElectricConnectionSpinnerTariff = (Spinner) findViewById(R.id.electricConnection_Spinner_tariff);
        mElectricConnectionTextViewSanctionedLoadKVA = (TextView) findViewById(R.id.electricConnection_textView_sanctionedLoadKVA);
        mElectricConnectionEditTextSanctionedLoadKVA = (EditText) findViewById(R.id.electricConnection_editText_sanctionedLoadKVA);
        mElectricConnectionTextViewExistingLoadAtSiteKVA = (TextView) findViewById(R.id.electricConnection_textView_existingLoadAtSiteKVA);
        mElectricConnectionEditTextExistingLoadAtSiteKVA = (EditText) findViewById(R.id.electricConnection_editText_existingLoadAtSiteKVA);
        mElectricConnectionTextViewNameOfSupplyCompany = (TextView) findViewById(R.id.electricConnection_textView_nameOfSupplyCompany);
        mElectricConnectionEditTextNameOfSupplyCompany = (EditText) findViewById(R.id.electricConnection_editText_nameOfSupplyCompany);
        mElectricConnectionTextViewCopyOfElectricBills = (TextView) findViewById(R.id.electricConnection_textView_copyOfElectricBills);
        mElectricConnectionSpinnerCopyOfElectricBills = (Spinner) findViewById(R.id.electricConnection_Spinner_copyOfElectricBills);
        mElectricConnectionTextViewNumberOfCompoundLights = (TextView) findViewById(R.id.electricConnection_textView_numberOfCompoundLights);
        mElectricConnectionEditTextNumberOfCompoundLights = (EditText) findViewById(R.id.electricConnection_editText_numberOfCompoundLights);
        mElectricConnectionTextViewEbMeterReadingInKWh = (TextView) findViewById(R.id.electricConnection_textView_ebMeterReadingInKWh);
        mElectricConnectionEditTextEbMeterReadingInKWh = (EditText) findViewById(R.id.electricConnection_editText_ebMeterReadingInKWh);
        mElectricConnectionTextViewEbSupplier = (TextView) findViewById(R.id.electricConnection_textView_ebSupplier);
        mElectricConnectionSpinnerEbSupplier = (Spinner) findViewById(R.id.electricConnection_Spinner_ebSupplier);
        mElectricConnectionTextViewEbCostPerUnitForSharedConnection = (TextView) findViewById(R.id.electricConnection_textView_ebCostPerUnitForSharedConnection);
        mElectricConnectionEditTextEbCostPerUnitForSharedConnection = (EditText) findViewById(R.id.electricConnection_editText_ebCostPerUnitForSharedConnection);
        mElectricConnectionTextViewEbStatus = (TextView) findViewById(R.id.electricConnection_textView_ebStatus);
        mElectricConnectionSpinnerEbStatus = (Spinner) findViewById(R.id.electricConnection_Spinner_ebStatus);
        mElectricConnectionTextViewTransformerWorkingCondition = (TextView) findViewById(R.id.electricConnection_textView_transformerWorkingCondition);
        mElectricConnectionSpinnerTransformerWorkingCondition = (Spinner) findViewById(R.id.electricConnection_Spinner_transformerWorkingCondition);
        mElectricConnectionTextViewTransformerCapacityInKva = (TextView) findViewById(R.id.electricConnection_textView_transformerCapacityInKva);
        mElectricConnectionEditTextTransformerCapacityInKva = (EditText) findViewById(R.id.electricConnection_editText_transformerCapacityInKva);
        mElectricConnectionTextViewEbMeterBoxStatus = (TextView) findViewById(R.id.electricConnection_textView_ebMeterBoxStatus);
        mElectricConnectionSpinnerEbMeterBoxStatus = (Spinner) findViewById(R.id.electricConnection_Spinner_ebMeterBoxStatus);
        mElectricConnectionTextViewSectionName = (TextView) findViewById(R.id.electricConnection_textView_sectionName);
        mElectricConnectionEditTextSectionName = (EditText) findViewById(R.id.electricConnection_editText_sectionName);
        mElectricConnectionTextViewSectionNumber = (TextView) findViewById(R.id.electricConnection_textView_sectionNumber);
        mElectricConnectionEditTextSectionNumber = (EditText) findViewById(R.id.electricConnection_editText_sectionNumber);
        mElectricConnectionTextViewConsumerNumber = (TextView) findViewById(R.id.electricConnection_textView_consumerNumber);
        mElectricConnectionEditTextConsumerNumber = (EditText) findViewById(R.id.electricConnection_editText_consumerNumber);
        mElectricConnectionTextViewEbMeterWorkingStatus = (TextView) findViewById(R.id.electricConnection_textView_ebMeterWorkingStatus);
        mElectricConnectionSpinnerEbMeterWorkingStatus = (Spinner) findViewById(R.id.electricConnection_Spinner_ebMeterWorkingStatus);
        mElectricConnectionTextViewEbMeterSerialNumber = (TextView) findViewById(R.id.electricConnection_textView_ebMeterSerialNumber);
        mElectricConnectionEditTextEbMeterSerialNumber = (EditText) findViewById(R.id.electricConnection_editText_ebMeterSerialNumber);
        mElectricConnectionTextViewTypeOfPayment = (TextView) findViewById(R.id.electricConnection_textView_typeOfPayment);
        mElectricConnectionSpinnerTypeOfPayment = (Spinner) findViewById(R.id.electricConnection_Spinner_typeOfPayment);
        mElectricConnectionTextViewEbPaymentSchedule = (TextView) findViewById(R.id.electricConnection_textView_ebPaymentSchedule);
        mElectricConnectionSpinnerEbPaymentSchedule = (Spinner) findViewById(R.id.electricConnection_Spinner_ebPaymentSchedule);
        mElectricConnectionTextViewSafetyFuseUnit = (TextView) findViewById(R.id.electricConnection_textView_safetyFuseUnit);
        mElectricConnectionSpinnerSafetyFuseUnit = (Spinner) findViewById(R.id.electricConnection_Spinner_safetyFuseUnit);
        mElectricConnectionTextViewKitKatClayFuseStatus = (TextView) findViewById(R.id.electricConnection_textView_kitKatClayFuseStatus);
        mElectricConnectionSpinnerKitKatClayFuseStatus = (Spinner) findViewById(R.id.electricConnection_Spinner_kitKatClayFuseStatus);
        mElectricConnectionTextViewEbNeutralEarthing = (TextView) findViewById(R.id.electricConnection_textView_ebNeutralEarthing);
        mElectricConnectionSpinnerEbNeutralEarthing = (Spinner) findViewById(R.id.electricConnection_Spinner_ebNeutralEarthing);
        mElectricConnectionTextViewAverageEbAvailabilityPerDay = (TextView) findViewById(R.id.electricConnection_textView_averageEbAvailabilityPerDay);
        mElectricConnectionEditTextAverageEbAvailabilityPerDay = (EditText) findViewById(R.id.electricConnection_editText_averageEbAvailabilityPerDay);
        mElectricConnectionTextViewScheduledPowerCutInHrs = (TextView) findViewById(R.id.electricConnection_textView_scheduledPowerCutInHrs);
        mElectricConnectionEditTextScheduledPowerCutInHrs = (EditText) findViewById(R.id.electricConnection_editText_scheduledPowerCutInHrs);
        mElectricConnectionTextViewEbBillDate = (TextView) findViewById(R.id.electricConnection_textView_ebBillDate);
        mElectricConnectionEditTextEbBillDate = (EditText) findViewById(R.id.electricConnection_editText_ebBillDate);

        EasyCountDownTextview countDownTextview = (EasyCountDownTextview) findViewById(R.id.easyCountDownTextview);
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

    /**/

}

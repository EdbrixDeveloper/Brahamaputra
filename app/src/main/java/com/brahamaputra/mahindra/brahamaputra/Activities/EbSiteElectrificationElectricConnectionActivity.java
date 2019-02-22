package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationElectricConnectionData;
import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationTransactionData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.DecimalConversion;
import com.brahamaputra.mahindra.brahamaputra.Utils.DecimalDigitsInputFilter;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Calendar;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_nameOfSupplyCompany;

public class EbSiteElectrificationElectricConnectionActivity extends AppCompatActivity {

    private static final String TAG = EbSiteElectrificationElectricConnectionActivity.class.getSimpleName();

    private TextView mEbSiteElectrificationElectricConnectionTextViewNameOfSupplyCompany;
    private EditText mEbSiteElectrificationElectricConnectionTextViewNameOfSupplyCompanyVal;
    private LinearLayout mEbSiteElectrificationElectricConnectionLinearLayoutConsumerNumber;
    private TextView mEbSiteElectrificationElectricConnectionTextViewConsumerNumber;
    private EditText mEbSiteElectrificationElectricConnectionEditTextConsumerNumber;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutEbMeterSerialNumber;
    private TextView mEbSiteElectrificationTransactionTextViewEbMeterSerialNumber;
    private EditText mEbSiteElectrificationTransactionEditTextEbMeterSerialNumber;
    private TextView mEbSiteElectrificationTransactionTextViewTypeOfElectricConnection;
    private TextView mEbSiteElectrificationTransactionTextViewTypeOfElectricConnectionVal;
    private TextView mEbSiteElectrificationTransactionTextViewTariff;
    private TextView mEbSiteElectrificationTransactionTextViewTariffVal;
    private TextView mEbSiteElectrificationTransactionTextViewSanctionedLoadKVA;
    private EditText mEbSiteElectrificationTransactionEditTextSanctionedLoadKVA;
    private TextView mEbSiteElectrificationTransactionTextViewExistingLoadAtSiteKVA;
    private EditText mEbSiteElectrificationTransactionEditTextExistingLoadAtSiteKVA;
    private EditText mEbSiteElectrificationTransactionEditTextSecurityAmountPaidToTheCompany;
    private TextView mEbSiteElectrificationTransactionTextViewCopyOfElectricBills;
    private TextView mEbSiteElectrificationTransactionTextViewCopyOfElectricBillsVal;
    private TextView mEbSiteElectrificationTransactionTextViewNumberOfCompoundLights;
    private EditText mEbSiteElectrificationTransactionEditTextNumberOfCompoundLights;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutEbMeterReadingInKWh;
    private TextView mEbSiteElectrificationTransactionTextViewEbMeterReadingInKWh;
    private EditText mEbSiteElectrificationTransactionEditTextEbMeterReadingInKWh;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutEbSupplier;
    private TextView mEbSiteElectrificationTransactionTextViewEbSupplier;
    private TextView mEbSiteElectrificationTransactionTextViewEbSupplierVal;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutEbCostPerUnitForSharedConnection;
    private TextView mEbSiteElectrificationTransactionTextViewEbCostPerUnitForSharedConnection;
    private EditText mEbSiteElectrificationTransactionEditTextEbCostPerUnitForSharedConnection;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutEbStatus;
    private TextView mEbSiteElectrificationTransactionTextViewEbStatus;
    private TextView mEbSiteElectrificationTransactionTextViewEbStatusVal;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutTransformerWorkingCondition;
    private TextView mEbSiteElectrificationTransactionTextViewTransformerWorkingCondition;
    private TextView mEbSiteElectrificationTransactionTextViewTransformerWorkingConditionVal;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutTransformerCapacityInKva;
    private TextView mEbSiteElectrificationTransactionTextViewTransformerCapacityInKva;
    private EditText mEbSiteElectrificationTransactionEditTextTransformerCapacityInKva;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutEbMeterBoxStatus;
    private TextView mEbSiteElectrificationTransactionTextViewEbMeterBoxStatus;
    private TextView mEbSiteElectrificationTransactionTextViewEbMeterBoxStatusVal;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutSectionName;
    private TextView mEbSiteElectrificationTransactionTextViewSectionName;
    private EditText mEbSiteElectrificationTransactionEditTextSectionName;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutSectionNumber;
    private TextView mEbSiteElectrificationTransactionTextViewSectionNumber;
    private EditText mEbSiteElectrificationTransactionEditTextSectionNumber;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutEbMeterWorkingStatus;
    private TextView mEbSiteElectrificationTransactionTextViewEbMeterWorkingStatus;
    private TextView mEbSiteElectrificationTransactionTextViewEbMeterWorkingStatusVal;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutTypeOfPayment;
    private TextView mEbSiteElectrificationTransactionTextViewTypeOfPayment;
    private TextView mEbSiteElectrificationTransactionTextViewTypeOfPaymentVal;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutEbPaymentSchedule;
    private TextView mEbSiteElectrificationTransactionTextViewEbPaymentSchedule;
    private TextView mEbSiteElectrificationTransactionTextViewEbPaymentScheduleVal;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutSafetyFuseUnit;
    private TextView mEbSiteElectrificationTransactionTextViewSafetyFuseUnit;
    private TextView mEbSiteElectrificationTransactionTextViewSafetyFuseUnitVal;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutKitKatClayFuseStatus;
    private TextView mEbSiteElectrificationTransactionTextViewKitKatClayFuseStatus;
    private TextView mEbSiteElectrificationTransactionTextViewKitKatClayFuseStatusVal;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutEbNeutralEarthing;
    private TextView mEbSiteElectrificationTransactionTextViewEbNeutralEarthing;
    private TextView mEbSiteElectrificationTransactionTextViewEbNeutralEarthingVal;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutAverageEbAvailabilityPerDay;
    private TextView mEbSiteElectrificationTransactionTextViewAverageEbAvailabilityPerDay;
    private EditText mEbSiteElectrificationTransactionEditTextAverageEbAvailabilityPerDay;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutScheduledPowerCutInHrs;
    private TextView mEbSiteElectrificationTransactionTextViewScheduledPowerCutInHrs;
    private EditText mEbSiteElectrificationTransactionEditTextScheduledPowerCutInHrs;
    private LinearLayout mEbSiteElectrificationTransactionLinearLayoutEbBillDate;
    private TextView mEbSiteElectrificationTransactionTextViewEbBillDate;
    private TextView mEbSiteElectrificationTransactionTextViewEbBillDateVal;
    private TextView mEbSiteElectrificationTransactionTextViewSapVendorCode;
    private EditText mEbSiteElectrificationTransactionEditTextSapVendorCode;
    private TextView mEbSiteElectrificationTransactionTextViewTypeModeOfPayment;
    private TextView mEbSiteElectrificationTransactionTextViewTypeModeOfPaymentVal;
    private TextView mEbSiteElectrificationTransactionTextViewBankIfscCode;
    private EditText mEbSiteElectrificationTransactionEditTextBankIfscCode;
    private TextView mEbSiteElectrificationTransactionTextViewBankAccountNo;
    private EditText mEbSiteElectrificationTransactionEditTextBankAccountNo;

    DecimalConversion decimalConversion;
    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";
    private EbSiteElectrificationTransactionData ebSiteElectrificationTransactionData;
    private EbSiteElectrificationElectricConnectionData ebSiteElectrificationElectricConnectionData;
    private SessionManager sessionManager;

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
    String str_ebBillDate;
    String str_typeModeOfPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb_site_electrification_electric_connection);
        this.setTitle("Electric Connection");//EB Site Electrification
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        decimalConversion = new DecimalConversion();
        assignViews();
        initCombo();

        mEbSiteElectrificationTransactionEditTextAverageEbAvailabilityPerDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(EbSiteElectrificationElectricConnectionActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String selectedHour1 = (selectedHour >= 10) ? Integer.toString(selectedHour) : String.format("0%s", Integer.toString(selectedHour));
                        String selectedMinute1 = (selectedMinute >= 10) ? Integer.toString(selectedMinute) : String.format("0%s", Integer.toString(selectedMinute));
                        mEbSiteElectrificationTransactionEditTextAverageEbAvailabilityPerDay.setText(selectedHour1 + ":" + selectedMinute1);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time For Average Eb Availability");
                mTimePicker.show();

            }
        });

        mEbSiteElectrificationTransactionEditTextScheduledPowerCutInHrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(EbSiteElectrificationElectricConnectionActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String selectedHour1 = (selectedHour >= 10) ? Integer.toString(selectedHour) : String.format("0%s", Integer.toString(selectedHour));
                        String selectedMinute1 = (selectedMinute >= 10) ? Integer.toString(selectedMinute) : String.format("0%s", Integer.toString(selectedMinute));
                        mEbSiteElectrificationTransactionEditTextScheduledPowerCutInHrs.setText(selectedHour1 + ":" + selectedMinute1);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time For Scheduled Power Cut");
                mTimePicker.show();

            }
        });

        mEbSiteElectrificationTransactionEditTextSanctionedLoadKVA.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mEbSiteElectrificationTransactionEditTextExistingLoadAtSiteKVA.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mEbSiteElectrificationTransactionEditTextEbMeterReadingInKWh.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mEbSiteElectrificationTransactionEditTextEbCostPerUnitForSharedConnection.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        mEbSiteElectrificationTransactionEditTextTransformerCapacityInKva.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });

        if (hototicket_nameOfSupplyCompany.isEmpty() || hototicket_nameOfSupplyCompany.length() < 0) {
            //
        } else {
            mEbSiteElectrificationElectricConnectionTextViewNameOfSupplyCompanyVal.setText(hototicket_nameOfSupplyCompany);
            mEbSiteElectrificationElectricConnectionTextViewNameOfSupplyCompanyVal.setKeyListener(null);
        }


    }

    private void assignViews() {
        mEbSiteElectrificationElectricConnectionTextViewNameOfSupplyCompany = (TextView) findViewById(R.id.ebSiteElectrificationElectricConnection_textView_nameOfSupplyCompany);
        mEbSiteElectrificationElectricConnectionTextViewNameOfSupplyCompanyVal = (EditText) findViewById(R.id.ebSiteElectrificationElectricConnection_textView_nameOfSupplyCompany_val);
        mEbSiteElectrificationElectricConnectionLinearLayoutConsumerNumber = (LinearLayout) findViewById(R.id.ebSiteElectrificationElectricConnection_linearLayout_consumerNumber);
        mEbSiteElectrificationElectricConnectionTextViewConsumerNumber = (TextView) findViewById(R.id.ebSiteElectrificationElectricConnection_textView_consumerNumber);
        mEbSiteElectrificationElectricConnectionEditTextConsumerNumber = (EditText) findViewById(R.id.ebSiteElectrificationElectricConnection_editText_consumerNumber);
        mEbSiteElectrificationTransactionLinearLayoutEbMeterSerialNumber = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_ebMeterSerialNumber);
        mEbSiteElectrificationTransactionTextViewEbMeterSerialNumber = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebMeterSerialNumber);
        mEbSiteElectrificationTransactionEditTextEbMeterSerialNumber = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_ebMeterSerialNumber);
        mEbSiteElectrificationTransactionTextViewTypeOfElectricConnection = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_typeOfElectricConnection);
        mEbSiteElectrificationTransactionTextViewTypeOfElectricConnectionVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_typeOfElectricConnection_val);
        mEbSiteElectrificationTransactionTextViewTariff = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_tariff);
        mEbSiteElectrificationTransactionTextViewTariffVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_tariff_val);
        mEbSiteElectrificationTransactionTextViewSanctionedLoadKVA = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_sanctionedLoadKVA);
        mEbSiteElectrificationTransactionEditTextSanctionedLoadKVA = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_sanctionedLoadKVA);
        mEbSiteElectrificationTransactionTextViewExistingLoadAtSiteKVA = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_existingLoadAtSiteKVA);
        mEbSiteElectrificationTransactionEditTextExistingLoadAtSiteKVA = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_existingLoadAtSiteKVA);
        mEbSiteElectrificationTransactionEditTextSecurityAmountPaidToTheCompany = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_SecurityAmountPaidToTheCompany);
        mEbSiteElectrificationTransactionTextViewCopyOfElectricBills = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_copyOfElectricBills);
        mEbSiteElectrificationTransactionTextViewCopyOfElectricBillsVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_copyOfElectricBills_val);
        mEbSiteElectrificationTransactionTextViewNumberOfCompoundLights = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_numberOfCompoundLights);
        mEbSiteElectrificationTransactionEditTextNumberOfCompoundLights = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_numberOfCompoundLights);
        mEbSiteElectrificationTransactionLinearLayoutEbMeterReadingInKWh = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_ebMeterReadingInKWh);
        mEbSiteElectrificationTransactionTextViewEbMeterReadingInKWh = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebMeterReadingInKWh);
        mEbSiteElectrificationTransactionEditTextEbMeterReadingInKWh = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_ebMeterReadingInKWh);
        mEbSiteElectrificationTransactionLinearLayoutEbSupplier = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_ebSupplier);
        mEbSiteElectrificationTransactionTextViewEbSupplier = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebSupplier);
        mEbSiteElectrificationTransactionTextViewEbSupplierVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebSupplier_val);
        mEbSiteElectrificationTransactionLinearLayoutEbCostPerUnitForSharedConnection = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_ebCostPerUnitForSharedConnection);
        mEbSiteElectrificationTransactionTextViewEbCostPerUnitForSharedConnection = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebCostPerUnitForSharedConnection);
        mEbSiteElectrificationTransactionEditTextEbCostPerUnitForSharedConnection = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_ebCostPerUnitForSharedConnection);
        mEbSiteElectrificationTransactionLinearLayoutEbStatus = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_ebStatus);
        mEbSiteElectrificationTransactionTextViewEbStatus = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebStatus);
        mEbSiteElectrificationTransactionTextViewEbStatusVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebStatus_val);
        mEbSiteElectrificationTransactionLinearLayoutTransformerWorkingCondition = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_transformerWorkingCondition);
        mEbSiteElectrificationTransactionTextViewTransformerWorkingCondition = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_transformerWorkingCondition);
        mEbSiteElectrificationTransactionTextViewTransformerWorkingConditionVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_transformerWorkingCondition_val);
        mEbSiteElectrificationTransactionLinearLayoutTransformerCapacityInKva = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_transformerCapacityInKva);
        mEbSiteElectrificationTransactionTextViewTransformerCapacityInKva = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_transformerCapacityInKva);
        mEbSiteElectrificationTransactionEditTextTransformerCapacityInKva = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_transformerCapacityInKva);
        mEbSiteElectrificationTransactionLinearLayoutEbMeterBoxStatus = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_ebMeterBoxStatus);
        mEbSiteElectrificationTransactionTextViewEbMeterBoxStatus = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebMeterBoxStatus);
        mEbSiteElectrificationTransactionTextViewEbMeterBoxStatusVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebMeterBoxStatus_val);
        mEbSiteElectrificationTransactionLinearLayoutSectionName = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_sectionName);
        mEbSiteElectrificationTransactionTextViewSectionName = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_sectionName);
        mEbSiteElectrificationTransactionEditTextSectionName = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_sectionName);
        mEbSiteElectrificationTransactionLinearLayoutSectionNumber = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_sectionNumber);
        mEbSiteElectrificationTransactionTextViewSectionNumber = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_sectionNumber);
        mEbSiteElectrificationTransactionEditTextSectionNumber = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_sectionNumber);
        mEbSiteElectrificationTransactionLinearLayoutEbMeterWorkingStatus = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_ebMeterWorkingStatus);
        mEbSiteElectrificationTransactionTextViewEbMeterWorkingStatus = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebMeterWorkingStatus);
        mEbSiteElectrificationTransactionTextViewEbMeterWorkingStatusVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebMeterWorkingStatus_val);
        mEbSiteElectrificationTransactionLinearLayoutTypeOfPayment = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_typeOfPayment);
        mEbSiteElectrificationTransactionTextViewTypeOfPayment = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_typeOfPayment);
        mEbSiteElectrificationTransactionTextViewTypeOfPaymentVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_typeOfPayment_val);
        mEbSiteElectrificationTransactionLinearLayoutEbPaymentSchedule = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_ebPaymentSchedule);
        mEbSiteElectrificationTransactionTextViewEbPaymentSchedule = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebPaymentSchedule);
        mEbSiteElectrificationTransactionTextViewEbPaymentScheduleVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebPaymentSchedule_val);
        mEbSiteElectrificationTransactionLinearLayoutSafetyFuseUnit = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_safetyFuseUnit);
        mEbSiteElectrificationTransactionTextViewSafetyFuseUnit = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_safetyFuseUnit);
        mEbSiteElectrificationTransactionTextViewSafetyFuseUnitVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_safetyFuseUnit_val);
        mEbSiteElectrificationTransactionLinearLayoutKitKatClayFuseStatus = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_kitKatClayFuseStatus);
        mEbSiteElectrificationTransactionTextViewKitKatClayFuseStatus = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_kitKatClayFuseStatus);
        mEbSiteElectrificationTransactionTextViewKitKatClayFuseStatusVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_kitKatClayFuseStatus_val);
        mEbSiteElectrificationTransactionLinearLayoutEbNeutralEarthing = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_ebNeutralEarthing);
        mEbSiteElectrificationTransactionTextViewEbNeutralEarthing = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebNeutralEarthing);
        mEbSiteElectrificationTransactionTextViewEbNeutralEarthingVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebNeutralEarthing_val);
        mEbSiteElectrificationTransactionLinearLayoutAverageEbAvailabilityPerDay = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_averageEbAvailabilityPerDay);
        mEbSiteElectrificationTransactionTextViewAverageEbAvailabilityPerDay = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_averageEbAvailabilityPerDay);
        mEbSiteElectrificationTransactionEditTextAverageEbAvailabilityPerDay = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_averageEbAvailabilityPerDay);
        mEbSiteElectrificationTransactionLinearLayoutScheduledPowerCutInHrs = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_scheduledPowerCutInHrs);
        mEbSiteElectrificationTransactionTextViewScheduledPowerCutInHrs = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_scheduledPowerCutInHrs);
        mEbSiteElectrificationTransactionEditTextScheduledPowerCutInHrs = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_scheduledPowerCutInHrs);
        mEbSiteElectrificationTransactionLinearLayoutEbBillDate = (LinearLayout) findViewById(R.id.ebSiteElectrificationTransaction_linearLayout_ebBillDate);
        mEbSiteElectrificationTransactionTextViewEbBillDate = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebBillDate);
        mEbSiteElectrificationTransactionTextViewEbBillDateVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_ebBillDate_Val);
        mEbSiteElectrificationTransactionTextViewSapVendorCode = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_sapVendorCode);
        mEbSiteElectrificationTransactionEditTextSapVendorCode = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_sapVendorCode);
        mEbSiteElectrificationTransactionTextViewTypeModeOfPayment = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_typeModeOfPayment);
        mEbSiteElectrificationTransactionTextViewTypeModeOfPaymentVal = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_typeModeOfPayment_Val);
        mEbSiteElectrificationTransactionTextViewBankIfscCode = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_bankIfscCode);
        mEbSiteElectrificationTransactionEditTextBankIfscCode = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_bankIfscCode);
        mEbSiteElectrificationTransactionTextViewBankAccountNo = (TextView) findViewById(R.id.ebSiteElectrificationTransaction_textView_bankAccountNo);
        mEbSiteElectrificationTransactionEditTextBankAccountNo = (EditText) findViewById(R.id.ebSiteElectrificationTransaction_editText_bankAccountNo);


        mEbSiteElectrificationTransactionEditTextSanctionedLoadKVA.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(8, 2)});
        mEbSiteElectrificationTransactionEditTextExistingLoadAtSiteKVA.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(8, 2)});
        mEbSiteElectrificationTransactionEditTextEbMeterReadingInKWh.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(8, 2)});
        mEbSiteElectrificationTransactionEditTextEbCostPerUnitForSharedConnection.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(8, 2)});
        mEbSiteElectrificationTransactionEditTextTransformerCapacityInKva.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(8, 2)});

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

    }

    public void DecimalFormatConversion() {
        mEbSiteElectrificationTransactionEditTextSanctionedLoadKVA.setText(decimalConversion.convertDecimal(mEbSiteElectrificationTransactionEditTextSanctionedLoadKVA.getText().toString()));
        mEbSiteElectrificationTransactionEditTextExistingLoadAtSiteKVA.setText(decimalConversion.convertDecimal(mEbSiteElectrificationTransactionEditTextExistingLoadAtSiteKVA.getText().toString()));
        mEbSiteElectrificationTransactionEditTextEbMeterReadingInKWh.setText(decimalConversion.convertDecimal(mEbSiteElectrificationTransactionEditTextEbMeterReadingInKWh.getText().toString()));
        mEbSiteElectrificationTransactionEditTextEbCostPerUnitForSharedConnection.setText(decimalConversion.convertDecimal(mEbSiteElectrificationTransactionEditTextEbCostPerUnitForSharedConnection.getText().toString()));
        mEbSiteElectrificationTransactionEditTextTransformerCapacityInKva.setText(decimalConversion.convertDecimal(mEbSiteElectrificationTransactionEditTextTransformerCapacityInKva.getText().toString()));
    }

    private void initCombo() {

        mEbSiteElectrificationTransactionTextViewTypeOfElectricConnectionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_typrOfElectricConnection))),
                        "Type of Electric Connection",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeOfElectricConnection = item.get(position);
                        mEbSiteElectrificationTransactionTextViewTypeOfElectricConnectionVal.setText(str_typeOfElectricConnection);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewTariffVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_tariff))),
                        "Tariff",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_tariff = item.get(position);
                        mEbSiteElectrificationTransactionTextViewTariffVal.setText(str_tariff);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewCopyOfElectricBillsVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_copyOfElectricBills))),
                        "Copy of the electric bills",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_copyOfElectricBills = item.get(position);
                        mEbSiteElectrificationTransactionTextViewCopyOfElectricBillsVal.setText(str_copyOfElectricBills);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewEbSupplierVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebSupplier))),
                        "EB Supplier",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebSupplier = item.get(position);
                        mEbSiteElectrificationTransactionTextViewEbSupplierVal.setText(str_ebSupplier);
                        visibilityOfEbCostPerUnitOnEbSupplierSelection(str_ebSupplier);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewEbStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebStatus))),
                        "EB Status",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebStatus = item.get(position);
                        mEbSiteElectrificationTransactionTextViewEbStatusVal.setText(str_ebStatus);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewTransformerWorkingConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_transformerWorkingCondition))),
                        "Transformer Working Condition",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_transformerWorkingCondition = item.get(position);
                        mEbSiteElectrificationTransactionTextViewTransformerWorkingConditionVal.setText(str_transformerWorkingCondition);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewEbMeterBoxStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebMeterBoxStatus))),
                        "EB Meter Box Status",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebMeterBoxStatus = item.get(position);
                        mEbSiteElectrificationTransactionTextViewEbMeterBoxStatusVal.setText(str_ebMeterBoxStatus);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewEbMeterWorkingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebMeterWorkingStatus))),
                        "EB Meter Working Status",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebMeterWorkingStatus = item.get(position);
                        mEbSiteElectrificationTransactionTextViewEbMeterWorkingStatusVal.setText(str_ebMeterWorkingStatus);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewTypeOfPaymentVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_typeOfPayment))),
                        "Type Of Payment",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeOfPayment = item.get(position);
                        mEbSiteElectrificationTransactionTextViewTypeOfPaymentVal.setText(str_typeOfPayment);
                        visibilityOfPaymentScheduleOnTypeOfPaymentSelection(str_typeOfPayment);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewEbPaymentScheduleVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebPaymentSchedule))),
                        "EB Payment Schedule",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebPaymentSchedule = item.get(position);
                        mEbSiteElectrificationTransactionTextViewEbPaymentScheduleVal.setText(str_ebPaymentSchedule);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewSafetyFuseUnitVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_safetyFuseUnit))),
                        "Safety Fuse Unit (SFU)",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_safetyFuseUnit = item.get(position);
                        mEbSiteElectrificationTransactionTextViewSafetyFuseUnitVal.setText(str_safetyFuseUnit);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewKitKatClayFuseStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_kitKatClayFuseStatus))),
                        "KIT-KAT/Clay Fuse Status",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_kitKatClayFuseStatus = item.get(position);
                        mEbSiteElectrificationTransactionTextViewKitKatClayFuseStatusVal.setText(str_kitKatClayFuseStatus);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewEbNeutralEarthingVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebNeutralEarthing))),
                        "EB Neutral Earthing",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebNeutralEarthing = item.get(position);
                        mEbSiteElectrificationTransactionTextViewEbNeutralEarthingVal.setText(str_ebNeutralEarthing);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewEbBillDateVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_ebBillDate))),
                        "EB Bill Date",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ebBillDate = item.get(position);
                        mEbSiteElectrificationTransactionTextViewEbBillDateVal.setText(str_ebBillDate);
                    }
                });
            }
        });

        mEbSiteElectrificationTransactionTextViewTypeModeOfPaymentVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(EbSiteElectrificationElectricConnectionActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_electricConnection_typeModeOfPayment))),
                        "Type|Mode Of Payment",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeModeOfPayment = item.get(position);
                        mEbSiteElectrificationTransactionTextViewTypeModeOfPaymentVal.setText(str_typeModeOfPayment);
                    }
                });
            }
        });
    }

    private void visibilityOfPaymentScheduleOnTypeOfPaymentSelection(String str_typeOfPayment) {
        if (str_typeOfPayment.equals("Pre Paid")) {
            mEbSiteElectrificationTransactionLinearLayoutEbPaymentSchedule.setVisibility(View.GONE);
            mEbSiteElectrificationTransactionTextViewEbPaymentScheduleVal.setText("");
        } else {
            mEbSiteElectrificationTransactionLinearLayoutEbPaymentSchedule.setVisibility(View.VISIBLE);
        }
    }

    private void visibilityOfEbCostPerUnitOnEbSupplierSelection(String ebSupplier) {
        if (ebSupplier.equals("Dedicated Connection")) {
            mEbSiteElectrificationTransactionLinearLayoutEbCostPerUnitForSharedConnection.setVisibility(View.GONE);
            mEbSiteElectrificationTransactionEditTextEbCostPerUnitForSharedConnection.setText("");
        } else {
            mEbSiteElectrificationTransactionLinearLayoutEbCostPerUnitForSharedConnection.setVisibility(View.VISIBLE);
        }
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
                //DecimalFormatConversion();
                //submitDetails();
                //startActivity(new Intent(this, EbSiteElectrificationTransactionActivity.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

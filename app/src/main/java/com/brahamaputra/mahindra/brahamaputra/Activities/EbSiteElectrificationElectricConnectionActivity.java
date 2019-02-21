package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.DecimalConversion;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;

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

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb_site_electrification_electric_connection);
        this.setTitle("Electric Connection");//EB Site Electrification
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();


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

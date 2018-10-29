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
import android.widget.Spinner;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Battery_Set extends AppCompatActivity {

    private TextView mBatterySetTextViewNoofBatterySetProvided;
    private SearchableSpinner mBatterySetSpinnerNoofBatterySetProvided;
    private TextView mBatterySetTextViewNumberofBatteryBankWorking;
    private SearchableSpinner mBatterySetSpinnerNumberofBatteryBankWorking;
    private TextView mBatterySetTextViewQRCodeScan;
    private ImageView mBatterySetButtonQRCodeScan;
    private TextView mBatterySetTextViewAssetOwner;
    private SearchableSpinner mBatterySetSpinnerAssetOwner;
    private TextView mBatterySetTextViewManufacturerMakeModel;
    private SearchableSpinner mBatterySetSpinnerManufacturerMakeModel;
    private TextView mBatterySetTextViewCapacityinAH;
    private SearchableSpinner mBatterySetSpinnerCapacityinAH;
    private TextView mBatterySetTextViewTypeofBattery;
    private SearchableSpinner mBatterySetSpinnerTypeofBattery;
    private TextView mBatterySetTextViewDateofInstallation;
    private EditText mBatterySetEditTextDateofInstallation;
    private TextView mBatterySetTextViewBackupduration;
    private EditText mBatterySetEditTextBackupduration;
    private TextView mBatterySetTextViewPositionofBatteryBank;
    private SearchableSpinner mBatterySetSpinnerPositionofBatteryBank;
    private TextView mBatterySetTextViewBatteryBankCableSizeinSQMM;
    private SearchableSpinner mBatterySetSpinnerBatteryBankCableSizeinSQMM;
    private TextView mBatterySetTextViewBatteryBankEarthingStatus;
    private SearchableSpinner mBatterySetSpinnerBatteryBankEarthingStatus;
    private TextView mBatterySetTextViewBACKUPCondition;
    private SearchableSpinner mBatterySetSpinnerBACKUPCondition;
    private TextView mBatterySetTextViewNatureofProblem;
    private EditText mBatterySetEditTextNatureofProblem;

    private void assignViews() {
        mBatterySetTextViewNoofBatterySetProvided = (TextView) findViewById(R.id.batterySet_textView_NoofBatterySetProvided);
        mBatterySetSpinnerNoofBatterySetProvided = (SearchableSpinner) findViewById(R.id.batterySet_spinner_NoofBatterySetProvided);
        mBatterySetTextViewNumberofBatteryBankWorking = (TextView) findViewById(R.id.batterySet_textView_NumberofBatteryBankWorking);
        mBatterySetSpinnerNumberofBatteryBankWorking = (SearchableSpinner) findViewById(R.id.batterySet_spinner_NumberofBatteryBankWorking);
        mBatterySetTextViewQRCodeScan = (TextView) findViewById(R.id.batterySet_textView_QRCodeScan);
        mBatterySetButtonQRCodeScan = (ImageView) findViewById(R.id.batterySet_button_QRCodeScan);
        mBatterySetTextViewAssetOwner = (TextView) findViewById(R.id.batterySet_textView_AssetOwner);
        mBatterySetSpinnerAssetOwner = (SearchableSpinner) findViewById(R.id.batterySet_spinner_AssetOwner);
        mBatterySetTextViewManufacturerMakeModel = (TextView) findViewById(R.id.batterySet_textView_ManufacturerMakeModel);
        mBatterySetSpinnerManufacturerMakeModel = (SearchableSpinner) findViewById(R.id.batterySet_spinner_ManufacturerMakeModel);
        mBatterySetTextViewCapacityinAH = (TextView) findViewById(R.id.batterySet_textView_CapacityinAH);
        mBatterySetSpinnerCapacityinAH = (SearchableSpinner) findViewById(R.id.batterySet_spinner_CapacityinAH);
        mBatterySetTextViewTypeofBattery = (TextView) findViewById(R.id.batterySet_textView_TypeofBattery);
        mBatterySetSpinnerTypeofBattery = (SearchableSpinner) findViewById(R.id.batterySet_spinner_TypeofBattery);
        mBatterySetTextViewDateofInstallation = (TextView) findViewById(R.id.batterySet_textView_DateofInstallation);
        mBatterySetEditTextDateofInstallation = (EditText) findViewById(R.id.batterySet_editText_DateofInstallation);
        mBatterySetTextViewBackupduration = (TextView) findViewById(R.id.batterySet_textView_Backupduration);
        mBatterySetEditTextBackupduration = (EditText) findViewById(R.id.batterySet_editText_Backupduration);
        mBatterySetTextViewPositionofBatteryBank = (TextView) findViewById(R.id.batterySet_textView_PositionofBatteryBank);
        mBatterySetSpinnerPositionofBatteryBank = (SearchableSpinner) findViewById(R.id.batterySet_spinner_PositionofBatteryBank);
        mBatterySetTextViewBatteryBankCableSizeinSQMM = (TextView) findViewById(R.id.batterySet_textView_BatteryBankCableSizeinSQMM);
        mBatterySetSpinnerBatteryBankCableSizeinSQMM = (SearchableSpinner) findViewById(R.id.batterySet_spinner_BatteryBankCableSizeinSQMM);
        mBatterySetTextViewBatteryBankEarthingStatus = (TextView) findViewById(R.id.batterySet_textView_BatteryBankEarthingStatus);
        mBatterySetSpinnerBatteryBankEarthingStatus = (SearchableSpinner) findViewById(R.id.batterySet_spinner_BatteryBankEarthingStatus);
        mBatterySetTextViewBACKUPCondition = (TextView) findViewById(R.id.batterySet_textView_BACKUPCondition);
        mBatterySetSpinnerBACKUPCondition = (SearchableSpinner) findViewById(R.id.batterySet_spinner_BACKUPCondition);
        mBatterySetTextViewNatureofProblem = (TextView) findViewById(R.id.batterySet_textView_NatureofProblem);
        mBatterySetEditTextNatureofProblem = (EditText) findViewById(R.id.batterySet_editText_NatureofProblem);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }


    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_set);
        this.setTitle("Battery Set");
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

        mBatterySetEditTextDateofInstallation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Battery_Set.this, date, myCalendar
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

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mBatterySetEditTextDateofInstallation.setText(sdf.format(myCalendar.getTime()));
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

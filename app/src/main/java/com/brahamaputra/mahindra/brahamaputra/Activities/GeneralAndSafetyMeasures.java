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
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class GeneralAndSafetyMeasures extends AppCompatActivity {



    private TextView mGeneralAndSafetyMeasuresTextViewPrevailingSLA;
    private EditText mGeneralAndSafetyMeasuresEditTextPrevailingSLA;
    private TextView mPowerManagementSystemTextViewSiteBoundaryStatus;
    private SearchableSpinner mPowerManagementSystemSpinnerSiteBoundaryStatus;
    private TextView mPowerManagementSystemTextViewSiteHygieneVegitationStatus;
    private SearchableSpinner mPowerManagementSystemSpinnerSiteHygieneVegitationStatus;
    private TextView mPowerManagementSystemTextViewGateLock;
    private SearchableSpinner mPowerManagementSystemSpinnerGateLock;
    private TextView mPowerManagementSystemTextViewDGRoomLock;
    private SearchableSpinner mPowerManagementSystemSpinnerDGRoomLock;
    private TextView mPowerManagementSystemTextViewFireExtuinguisher;
    private SearchableSpinner mPowerManagementSystemSpinnerFireExtuinguisher;
    private TextView mPowerManagementSystemTextViewFireExtuinguisherType;
    private SearchableSpinner mPowerManagementSystemSpinnerFireExtuinguisherType;
    private TextView mPowerManagementSystemTextViewFireExtuinguisherExpiryDate;
    private EditText mPowerManagementSystemEditTextFireExtuinguisherExpiryDate;
    private TextView mPowerManagementSystemTextViewFireBucket;
    private SearchableSpinner mPowerManagementSystemSpinnerFireBucket;
    private TextView mPowerManagementSystemTextViewSecurityStatus24x7;
    private SearchableSpinner mPowerManagementSystemSpinnerSecurityStatus24x7;
    private TextView mPowerManagementSystemTextViewNoofSecurityPerson;
    private SearchableSpinner mPowerManagementSystemSpinnerNoofSecurityPerson;
    private TextView mPowerManagementSystemTextViewMobileNumberofSecurity;
    private EditText mPowerManagementSystemEditTextMobileNumberofSecurity;
    private TextView mPowerManagementSystemTextViewCaretakerStatusUpOnEmergency;
    private SearchableSpinner mPowerManagementSystemSpinnerCaretakerStatusUpOnEmergency;
    private TextView mPowerManagementSystemTextViewMobileNumberofCaretaker;
    private EditText mPowerManagementSystemEditTextMobileNumberofCaretaker;
    private TextView mPowerManagementSystemTextViewIsSecurityCaretakeristheOwnerofSite;
    private SearchableSpinner mPowerManagementSystemSpinnerIsSecurityCaretakeristheOwnerofSitey;
    private TextView mPowerManagementSystemTextViewSalaryofSecurityCaretaker;
    private EditText mPowerManagementSystemEditTextSalaryofSecurityCaretaker;
    private TextView mPowerManagementSystemTextViewCaretakerSecuritySalaryPaidBy;
    private SearchableSpinner mPowerManagementSystemSpinnerCaretakerSecuritySalaryPaidBy;
    private TextView mPowerManagementSystemTextViewCaretakerSecurityStayinginSite;
    private SearchableSpinner mPowerManagementSystemSpinnerCaretakerSecurityStayinginSite;
    private TextView mPowerManagementSystemTextViewNumberofEarthPit;
    private SearchableSpinner mPowerManagementSystemSpinnerNumberofEarthPit;
    private TextView mPowerManagementSystemTextViewLightningArresterStatus;
    private SearchableSpinner mPowerManagementSystemSpinnerLightningArresterStatus;
    private TextView mPowerManagementSystemTextViewFencingCompoundWallCondition;
    private SearchableSpinner mPowerManagementSystemSpinnerFencingCompoundWallCondition;
    private TextView mPowerManagementSystemTextViewNumberoffreeODPaltformAvailable;
    private SearchableSpinner mPowerManagementSystemSpinnerNumberoffreeODPaltformAvailable;
    private TextView mPowerManagementSystemTextViewAlarmMultipluxerStatus;
    private SearchableSpinner mPowerManagementSystemSpinnerAlarmMultipluxerStatus;
    private TextView mPowerManagementSystemTextViewDoorOpenSensor;
    private SearchableSpinner mPowerManagementSystemSpinnerDoorOpenSensor;
    private TextView mPowerManagementSystemTextViewFuelSensor;
    private SearchableSpinner mPowerManagementSystemSpinnerFuelSensor;
    private TextView mPowerManagementSystemTextViewFireSmokeSensor;
    private SearchableSpinner mPowerManagementSystemSpinnerFireSmokeSensor;

    private void assignViews() {
        mGeneralAndSafetyMeasuresTextViewPrevailingSLA = (TextView) findViewById(R.id.generalAndSafetyMeasures_textView_PrevailingSLA);
        mGeneralAndSafetyMeasuresEditTextPrevailingSLA = (EditText) findViewById(R.id.generalAndSafetyMeasures_editText_PrevailingSLA);
        mPowerManagementSystemTextViewSiteBoundaryStatus = (TextView) findViewById(R.id.powerManagementSystem_textView_SiteBoundaryStatus);
        mPowerManagementSystemSpinnerSiteBoundaryStatus = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_SiteBoundaryStatus);
        mPowerManagementSystemTextViewSiteHygieneVegitationStatus = (TextView) findViewById(R.id.powerManagementSystem_textView_SiteHygieneVegitationStatus);
        mPowerManagementSystemSpinnerSiteHygieneVegitationStatus = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_SiteHygieneVegitationStatus);
        mPowerManagementSystemTextViewGateLock = (TextView) findViewById(R.id.powerManagementSystem_textView_GateLock);
        mPowerManagementSystemSpinnerGateLock = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_GateLock);
        mPowerManagementSystemTextViewDGRoomLock = (TextView) findViewById(R.id.powerManagementSystem_textView_DGRoomLock);
        mPowerManagementSystemSpinnerDGRoomLock = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_DGRoomLock);
        mPowerManagementSystemTextViewFireExtuinguisher = (TextView) findViewById(R.id.powerManagementSystem_textView_FireExtuinguisher);
        mPowerManagementSystemSpinnerFireExtuinguisher = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_FireExtuinguisher);
        mPowerManagementSystemTextViewFireExtuinguisherType = (TextView) findViewById(R.id.powerManagementSystem_textView_FireExtuinguisherType);
        mPowerManagementSystemSpinnerFireExtuinguisherType = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_FireExtuinguisherType);
        mPowerManagementSystemTextViewFireExtuinguisherExpiryDate = (TextView) findViewById(R.id.powerManagementSystem_textView_FireExtuinguisherExpiryDate);
        mPowerManagementSystemEditTextFireExtuinguisherExpiryDate = (EditText) findViewById(R.id.powerManagementSystem_editText_FireExtuinguisherExpiryDate);
        mPowerManagementSystemTextViewFireBucket = (TextView) findViewById(R.id.powerManagementSystem_textView_FireBucket);
        mPowerManagementSystemSpinnerFireBucket = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_FireBucket);
        mPowerManagementSystemTextViewSecurityStatus24x7 = (TextView) findViewById(R.id.powerManagementSystem_textView_SecurityStatus24x7);
        mPowerManagementSystemSpinnerSecurityStatus24x7 = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_SecurityStatus24x7);
        mPowerManagementSystemTextViewNoofSecurityPerson = (TextView) findViewById(R.id.powerManagementSystem_textView_NoofSecurityPerson);
        mPowerManagementSystemSpinnerNoofSecurityPerson = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_NoofSecurityPerson);
        mPowerManagementSystemTextViewMobileNumberofSecurity = (TextView) findViewById(R.id.powerManagementSystem_textView_MobileNumberofSecurity);
        mPowerManagementSystemEditTextMobileNumberofSecurity = (EditText) findViewById(R.id.powerManagementSystem_editText_MobileNumberofSecurity);
        mPowerManagementSystemTextViewCaretakerStatusUpOnEmergency = (TextView) findViewById(R.id.powerManagementSystem_textView_CaretakerStatusUpOnEmergency);
        mPowerManagementSystemSpinnerCaretakerStatusUpOnEmergency = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_CaretakerStatusUpOnEmergency);
        mPowerManagementSystemTextViewMobileNumberofCaretaker = (TextView) findViewById(R.id.powerManagementSystem_textView_MobileNumberofCaretaker);
        mPowerManagementSystemEditTextMobileNumberofCaretaker = (EditText) findViewById(R.id.powerManagementSystem_editText_MobileNumberofCaretaker);
        mPowerManagementSystemTextViewIsSecurityCaretakeristheOwnerofSite = (TextView) findViewById(R.id.powerManagementSystem_textView_IsSecurityCaretakeristheOwnerofSite);
        mPowerManagementSystemSpinnerIsSecurityCaretakeristheOwnerofSitey = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_IsSecurityCaretakeristheOwnerofSitey);
        mPowerManagementSystemTextViewSalaryofSecurityCaretaker = (TextView) findViewById(R.id.powerManagementSystem_textView_SalaryofSecurityCaretaker);
        mPowerManagementSystemEditTextSalaryofSecurityCaretaker = (EditText) findViewById(R.id.powerManagementSystem_editText_SalaryofSecurityCaretaker);
        mPowerManagementSystemTextViewCaretakerSecuritySalaryPaidBy = (TextView) findViewById(R.id.powerManagementSystem_textView_CaretakerSecuritySalaryPaidBy);
        mPowerManagementSystemSpinnerCaretakerSecuritySalaryPaidBy = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_CaretakerSecuritySalaryPaidBy);
        mPowerManagementSystemTextViewCaretakerSecurityStayinginSite = (TextView) findViewById(R.id.powerManagementSystem_textView_CaretakerSecurityStayinginSite);
        mPowerManagementSystemSpinnerCaretakerSecurityStayinginSite = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_CaretakerSecurityStayinginSite);
        mPowerManagementSystemTextViewNumberofEarthPit = (TextView) findViewById(R.id.powerManagementSystem_textView_NumberofEarthPit);
        mPowerManagementSystemSpinnerNumberofEarthPit = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_NumberofEarthPit);
        mPowerManagementSystemTextViewLightningArresterStatus = (TextView) findViewById(R.id.powerManagementSystem_textView_LightningArresterStatus);
        mPowerManagementSystemSpinnerLightningArresterStatus = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_LightningArresterStatus);
        mPowerManagementSystemTextViewFencingCompoundWallCondition = (TextView) findViewById(R.id.powerManagementSystem_textView_FencingCompoundWallCondition);
        mPowerManagementSystemSpinnerFencingCompoundWallCondition = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_FencingCompoundWallCondition);
        mPowerManagementSystemTextViewNumberoffreeODPaltformAvailable = (TextView) findViewById(R.id.powerManagementSystem_textView_NumberoffreeODPaltformAvailable);
        mPowerManagementSystemSpinnerNumberoffreeODPaltformAvailable = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_NumberoffreeODPaltformAvailable);
        mPowerManagementSystemTextViewAlarmMultipluxerStatus = (TextView) findViewById(R.id.powerManagementSystem_textView_AlarmMultipluxerStatus);
        mPowerManagementSystemSpinnerAlarmMultipluxerStatus = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_AlarmMultipluxerStatus);
        mPowerManagementSystemTextViewDoorOpenSensor = (TextView) findViewById(R.id.powerManagementSystem_textView_DoorOpenSensor);
        mPowerManagementSystemSpinnerDoorOpenSensor = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_DoorOpenSensor);
        mPowerManagementSystemTextViewFuelSensor = (TextView) findViewById(R.id.powerManagementSystem_textView_FuelSensor);
        mPowerManagementSystemSpinnerFuelSensor = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_FuelSensor);
        mPowerManagementSystemTextViewFireSmokeSensor = (TextView) findViewById(R.id.powerManagementSystem_textView_FireSmokeSensor);
        mPowerManagementSystemSpinnerFireSmokeSensor = (SearchableSpinner) findViewById(R.id.powerManagementSystem_spinner_FireSmokeSensor);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_and_safety_measures);
        this.setTitle("GENERAL & SAFETY MEASURES");
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

        mPowerManagementSystemEditTextFireExtuinguisherExpiryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(GeneralAndSafetyMeasures.this, date, myCalendar
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

       mPowerManagementSystemEditTextFireExtuinguisherExpiryDate.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:finish();
               // startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;
            case R.id.menuDone:finish();
                startActivity(new Intent(this, ACDB_DCDB.class));
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}

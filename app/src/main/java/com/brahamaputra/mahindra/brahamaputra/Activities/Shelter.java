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
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import android.widget.TextView;
import android.widget.TimePicker;

import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.Calendar;

public class Shelter extends BaseActivity {


    private TextView mShelterTextViewPhysicalConditionOfShelterPlatform;
    private SearchableSpinner mShelterSpinnerPhysicalConditionOfShelterPlatform;
    private TextView mShelterTextViewNumberOfBtsInsideShelter;
    private SearchableSpinner mShelterSpinnerNumberOfBtsInsideShelter;
    private TextView mShelterTextViewNumberOfBtsOutsideShelter;
    private SearchableSpinner mShelterSpinnerNumberOfBtsOutsideShelter;
    private TextView mShelterTextViewShelterLock;
    private SearchableSpinner mShelterSpinnerShelterLock;
    private TextView mShelterTextViewOutdoorShelterLock;
    private SearchableSpinner mShelterSpinnerOutdoorShelterLock;
    private TextView mShelterTextViewIgbStatus;
    private SearchableSpinner mShelterSpinnerIgbStatus;
    private TextView mShelterTextViewEgbStatus;
    private SearchableSpinner mShelterSpinnerEgbStatus;
    private TextView mShelterTextViewNoOfOdcAvailable;
    private SearchableSpinner mShelterSpinnerNoOfOdcAvailable;
    private TextView mShelterTextViewOdcLock;
    private SearchableSpinner mShelterSpinnerOdcLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter);
        this.setTitle("Shelter");
        assignViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void assignViews() {
        mShelterTextViewPhysicalConditionOfShelterPlatform = (TextView) findViewById(R.id.shelter_textView_physicalConditionOfShelterPlatform);
        mShelterSpinnerPhysicalConditionOfShelterPlatform = (SearchableSpinner) findViewById(R.id.shelter_spinner_physicalConditionOfShelterPlatform);
        mShelterTextViewNumberOfBtsInsideShelter = (TextView) findViewById(R.id.shelter_textView_numberOfBtsInsideShelter);
        mShelterSpinnerNumberOfBtsInsideShelter = (SearchableSpinner) findViewById(R.id.shelter_spinner_numberOfBtsInsideShelter);
        mShelterTextViewNumberOfBtsOutsideShelter = (TextView) findViewById(R.id.shelter_textView_numberOfBtsOutsideShelter);
        mShelterSpinnerNumberOfBtsOutsideShelter = (SearchableSpinner) findViewById(R.id.shelter_Spinner_numberOfBtsOutsideShelter);
        mShelterTextViewShelterLock = (TextView) findViewById(R.id.shelter_textView_shelterLock);
        mShelterSpinnerShelterLock = (SearchableSpinner) findViewById(R.id.shelter_Spinner_shelterLock);
        mShelterTextViewOutdoorShelterLock = (TextView) findViewById(R.id.shelter_textView_outdoorShelterLock);
        mShelterSpinnerOutdoorShelterLock = (SearchableSpinner) findViewById(R.id.shelter_Spinner_outdoorShelterLock);
        mShelterTextViewIgbStatus = (TextView) findViewById(R.id.shelter_textView_igbStatus);
        mShelterSpinnerIgbStatus = (SearchableSpinner) findViewById(R.id.shelter_Spinner_igbStatus);
        mShelterTextViewEgbStatus = (TextView) findViewById(R.id.shelter_textView_egbStatus);
        mShelterSpinnerEgbStatus = (SearchableSpinner) findViewById(R.id.shelter_Spinner_egbStatus);
        mShelterTextViewNoOfOdcAvailable = (TextView) findViewById(R.id.shelter_textView_noOfOdcAvailable);
        mShelterSpinnerNoOfOdcAvailable = (SearchableSpinner) findViewById(R.id.shelter_Spinner_noOfOdcAvailable);
        mShelterTextViewOdcLock = (TextView) findViewById(R.id.shelter_textView_odcLock);
        mShelterSpinnerOdcLock = (SearchableSpinner) findViewById(R.id.shelter_Spinner_odcLock);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        mShelterSpinnerPhysicalConditionOfShelterPlatform.setTitle("Physical Condition of Shelter and Platform");
        mShelterSpinnerNumberOfBtsInsideShelter.setTitle("Number of BTS Inside Shelter");
        mShelterSpinnerNumberOfBtsOutsideShelter.setTitle("Number of BTS Outside Shelter");
        mShelterSpinnerShelterLock.setTitle("Shelter Lock");
        mShelterSpinnerOutdoorShelterLock.setTitle("Outdoor Shelter Lock");
        mShelterSpinnerIgbStatus.setTitle("IGB Status");
        mShelterSpinnerEgbStatus.setTitle("EGB Status");
        mShelterSpinnerNoOfOdcAvailable.setTitle("NO OF ODC Available");
        mShelterSpinnerOdcLock.setTitle("ODC Lock");
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
                // startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;
            case R.id.menuSubmit:
                finish();
                startActivity(new Intent(this, Media.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


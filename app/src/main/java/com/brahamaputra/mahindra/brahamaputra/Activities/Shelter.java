package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.Calendar;

public class Shelter extends AppCompatActivity {


    private TextView mShelterTextViewPhysicalConditionOfShelterPlatform;
    private Spinner mShelterSpinnerPhysicalConditionOfShelterPlatform;
    private TextView mShelterTextViewNumberOfBtsInsideShelter;
    private Spinner mShelterSpinnerNumberOfBtsInsideShelter;
    private TextView mShelterTextViewNumberOfBtsOutsideShelter;
    private Spinner mShelterSpinnerNumberOfBtsOutsideShelter;
    private TextView mShelterTextViewShelterLock;
    private Spinner mShelterSpinnerShelterLock;
    private TextView mShelterTextViewOutdoorShelterLock;
    private Spinner mShelterSpinnerOutdoorShelterLock;
    private TextView mShelterTextViewIgbStatus;
    private Spinner mShelterSpinnerIgbStatus;
    private TextView mShelterTextViewEgbStatus;
    private Spinner mShelterSpinnerEgbStatus;
    private TextView mShelterTextViewNoOfOdcAvailable;
    private Spinner mShelterSpinnerNoOfOdcAvailable;
    private TextView mShelterTextViewOdcLock;
    private Spinner mShelterSpinnerOdcLock;

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
        mShelterSpinnerPhysicalConditionOfShelterPlatform = (Spinner) findViewById(R.id.shelter_spinner_physicalConditionOfShelterPlatform);
        mShelterTextViewNumberOfBtsInsideShelter = (TextView) findViewById(R.id.shelter_textView_numberOfBtsInsideShelter);
        mShelterSpinnerNumberOfBtsInsideShelter = (Spinner) findViewById(R.id.shelter_spinner_numberOfBtsInsideShelter);
        mShelterTextViewNumberOfBtsOutsideShelter = (TextView) findViewById(R.id.shelter_textView_numberOfBtsOutsideShelter);
        mShelterSpinnerNumberOfBtsOutsideShelter = (Spinner) findViewById(R.id.shelter_Spinner_numberOfBtsOutsideShelter);
        mShelterTextViewShelterLock = (TextView) findViewById(R.id.shelter_textView_shelterLock);
        mShelterSpinnerShelterLock = (Spinner) findViewById(R.id.shelter_Spinner_shelterLock);
        mShelterTextViewOutdoorShelterLock = (TextView) findViewById(R.id.shelter_textView_outdoorShelterLock);
        mShelterSpinnerOutdoorShelterLock = (Spinner) findViewById(R.id.shelter_Spinner_outdoorShelterLock);
        mShelterTextViewIgbStatus = (TextView) findViewById(R.id.shelter_textView_igbStatus);
        mShelterSpinnerIgbStatus = (Spinner) findViewById(R.id.shelter_Spinner_igbStatus);
        mShelterTextViewEgbStatus = (TextView) findViewById(R.id.shelter_textView_egbStatus);
        mShelterSpinnerEgbStatus = (Spinner) findViewById(R.id.shelter_Spinner_egbStatus);
        mShelterTextViewNoOfOdcAvailable = (TextView) findViewById(R.id.shelter_textView_noOfOdcAvailable);
        mShelterSpinnerNoOfOdcAvailable = (Spinner) findViewById(R.id.shelter_Spinner_noOfOdcAvailable);
        mShelterTextViewOdcLock = (TextView) findViewById(R.id.shelter_textView_odcLock);
        mShelterSpinnerOdcLock = (Spinner) findViewById(R.id.shelter_Spinner_odcLock);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
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
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

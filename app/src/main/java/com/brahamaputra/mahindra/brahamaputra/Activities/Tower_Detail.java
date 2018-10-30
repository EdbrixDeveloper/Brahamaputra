package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Tower_Detail extends AppCompatActivity {
    private TextView mTowerDetailTextViewTower;
    private SearchableSpinner mTowerDetailSpinnerTower;
    private TextView mTowerDetailTextViewTypeOfTower;
    private SearchableSpinner mTowerDetailSpinnerTypeOfTower;
    private TextView mTowerDetailTextViewHeightOfTower;
    private EditText mTowerDetailEditTextHeightOfTower;
    private TextView mTowerDetailTextViewDateOfPaintingOfTheTower;
    private EditText mTowerDetailEditTextDateOfPaintingOfTheTower;
    private TextView mTowerDetailTextViewSignboard;
    private SearchableSpinner mTowerDetailSpinnerSignboard;
    private TextView mTowerDetailTextViewDangerSignageboard;
    private SearchableSpinner mTowerDetailSpinnerDangerSignageboard;
    private TextView mTowerDetailTextViewCautionSignageboard;
    private SearchableSpinner mTowerDetailSpinnerCautionSignageboard;
    private TextView mTowerDetailTextViewWarningSignageboard;
    private SearchableSpinner mTowerDetailSpinnerWarningSignageboard;

    private void assignViews() {
        mTowerDetailTextViewTower = (TextView) findViewById(R.id.towerDetail_textView_tower);
        mTowerDetailSpinnerTower = (SearchableSpinner) findViewById(R.id.towerDetail_spinner_tower);
        mTowerDetailTextViewTypeOfTower = (TextView) findViewById(R.id.towerDetail_textView_typeOfTower);
        mTowerDetailSpinnerTypeOfTower = (SearchableSpinner) findViewById(R.id.towerDetail_spinner_typeOfTower);
        mTowerDetailTextViewHeightOfTower = (TextView) findViewById(R.id.towerDetail_textView_HeightOfTower);
        mTowerDetailEditTextHeightOfTower = (EditText) findViewById(R.id.towerDetail_editText_heightOfTower);
        mTowerDetailTextViewDateOfPaintingOfTheTower = (TextView) findViewById(R.id.towerDetail_textView_dateOfPaintingOfTheTower);
        mTowerDetailEditTextDateOfPaintingOfTheTower = (EditText) findViewById(R.id.towerDetail_editText_dateOfPaintingOfTheTower);
        mTowerDetailTextViewSignboard = (TextView) findViewById(R.id.towerDetail_textView_signboard);
        mTowerDetailSpinnerSignboard = (SearchableSpinner) findViewById(R.id.towerDetail_spinner_signboard);
        mTowerDetailTextViewDangerSignageboard = (TextView) findViewById(R.id.towerDetail_textView_dangerSignageboard);
        mTowerDetailSpinnerDangerSignageboard = (SearchableSpinner) findViewById(R.id.towerDetail_spinner_dangerSignageboard);
        mTowerDetailTextViewCautionSignageboard = (TextView) findViewById(R.id.towerDetail_textView_cautionSignageboard);
        mTowerDetailSpinnerCautionSignageboard = (SearchableSpinner) findViewById(R.id.towerDetail_spinner_cautionSignageboard);
        mTowerDetailTextViewWarningSignageboard = (TextView) findViewById(R.id.towerDetail_textView_warningSignageboard);
        mTowerDetailSpinnerWarningSignageboard = (SearchableSpinner) findViewById(R.id.towerDetail_spinner_warningSignageboard);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        mTowerDetailSpinnerTower.setTitle("Tower");
        mTowerDetailSpinnerTypeOfTower.setTitle("Type of tower");
        mTowerDetailSpinnerSignboard.setTitle("Sign Board");
        mTowerDetailSpinnerDangerSignageboard.setTitle("DANGER Signage Board");
        mTowerDetailSpinnerCautionSignageboard.setTitle("CAUTION Signage Board");
        mTowerDetailSpinnerWarningSignageboard.setTitle("WARNING Signage Board");

    }


    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tower__detail);
        this.setTitle("Tower Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();


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

        mTowerDetailEditTextDateOfPaintingOfTheTower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Tower_Detail.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mTowerDetailEditTextDateOfPaintingOfTheTower.setText(sdf.format(myCalendar.getTime()));
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
                startActivity(new Intent(this, Earth_Resistance_Tower.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

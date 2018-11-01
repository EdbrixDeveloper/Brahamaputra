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

import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class Tower_Detail extends AppCompatActivity {

    private TextView mTowerDetailTextViewTower;
    private TextView mTowerDetailTextViewTowerVal;
    private TextView mTowerDetailTextViewTypeOfTower;
    private TextView mTowerDetailTextViewTypeOfTowerVal;
    private TextView mTowerDetailTextViewHeightOfTower;
    private EditText mTowerDetailEditTextHeightOfTower;
    private TextView mTowerDetailTextViewDateOfPaintingOfTheTower;
    private EditText mTowerDetailEditTextDateOfPaintingOfTheTower;
    private TextView mTowerDetailTextViewSignboard;
    private TextView mTowerDetailTextViewSignboardVal;
    private TextView mTowerDetailTextViewDangerSignageboard;
    private TextView mTowerDetailSpinnerDangerSignageboardVal;
    private TextView mTowerDetailTextViewCautionSignageboard;
    private TextView mTowerDetailTextViewCautionSignageboardVal;
    private TextView mTowerDetailTextViewWarningSignageboard;
    private TextView mTowerDetailTextViewWarningSignageboardVal;

    final Calendar myCalendar = Calendar.getInstance();

    String str_tower;
    String str_typeOfTower;
    String str_signboard;
    String str_dangerSignageboard;
    String str_cautionSignageboard;
    String str_warningSignageboardVal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tower__detail);
        this.setTitle("Tower Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();

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

    private void assignViews() {
        mTowerDetailTextViewTower = (TextView) findViewById(R.id.towerDetail_textView_tower);
        mTowerDetailTextViewTowerVal = (TextView) findViewById(R.id.towerDetail_textView_tower_val);
        mTowerDetailTextViewTypeOfTower = (TextView) findViewById(R.id.towerDetail_textView_typeOfTower);
        mTowerDetailTextViewTypeOfTowerVal = (TextView) findViewById(R.id.towerDetail_textView_typeOfTower_val);
        mTowerDetailTextViewHeightOfTower = (TextView) findViewById(R.id.towerDetail_textView_HeightOfTower);
        mTowerDetailEditTextHeightOfTower = (EditText) findViewById(R.id.towerDetail_editText_heightOfTower);
        mTowerDetailTextViewDateOfPaintingOfTheTower = (TextView) findViewById(R.id.towerDetail_textView_dateOfPaintingOfTheTower);
        mTowerDetailEditTextDateOfPaintingOfTheTower = (EditText) findViewById(R.id.towerDetail_editText_dateOfPaintingOfTheTower);
        mTowerDetailTextViewSignboard = (TextView) findViewById(R.id.towerDetail_textView_signboard);
        mTowerDetailTextViewSignboardVal = (TextView) findViewById(R.id.towerDetail_textView_signboard_val);
        mTowerDetailTextViewDangerSignageboard = (TextView) findViewById(R.id.towerDetail_textView_dangerSignageboard);
        mTowerDetailSpinnerDangerSignageboardVal = (TextView) findViewById(R.id.towerDetail_spinner_dangerSignageboard_val);
        mTowerDetailTextViewCautionSignageboard = (TextView) findViewById(R.id.towerDetail_textView_cautionSignageboard);
        mTowerDetailTextViewCautionSignageboardVal = (TextView) findViewById(R.id.towerDetail_textView_cautionSignageboard_val);
        mTowerDetailTextViewWarningSignageboard = (TextView) findViewById(R.id.towerDetail_textView_warningSignageboard);
        mTowerDetailTextViewWarningSignageboardVal = (TextView) findViewById(R.id.towerDetail_textView_warningSignageboard_val);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    private void initCombo() {
        mTowerDetailTextViewTowerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Tower_Detail.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_towerDetail_tower))),
                        "Tower",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_tower = item.get(position);
                        mTowerDetailTextViewTowerVal.setText(str_tower);
                    }
                });
            }
        });


        mTowerDetailTextViewTypeOfTowerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Tower_Detail.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_towerDetail_typeOfTower))),
                        "Type of tower",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeOfTower = item.get(position);
                        mTowerDetailTextViewTypeOfTowerVal.setText(str_typeOfTower);
                    }
                });
            }
        });

        mTowerDetailTextViewSignboardVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Tower_Detail.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_towerDetail_signboard))),
                        "Sign Board",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_signboard = item.get(position);
                        mTowerDetailTextViewSignboardVal.setText(str_signboard);
                    }
                });
            }
        });

        mTowerDetailSpinnerDangerSignageboardVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Tower_Detail.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_towerDetail_dangerSignageboard))),
                        "DANGER Signage Board",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_dangerSignageboard = item.get(position);
                        mTowerDetailSpinnerDangerSignageboardVal.setText(str_dangerSignageboard);
                    }
                });
            }
        });

        mTowerDetailTextViewCautionSignageboardVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Tower_Detail.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_towerDetail_cautionSignageboard))),
                        "CAUTION Signage Board",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_cautionSignageboard = item.get(position);
                        mTowerDetailTextViewCautionSignageboardVal.setText(str_cautionSignageboard);
                    }
                });
            }
        });

        mTowerDetailTextViewWarningSignageboardVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Tower_Detail.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_towerDetail_warningSignageboard))),
                        "WARNING Signage Board",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_warningSignageboardVal = item.get(position);
                        mTowerDetailTextViewWarningSignageboardVal.setText(str_warningSignageboardVal);
                    }
                });
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

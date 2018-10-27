package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Earth_Resistance_Equipment extends AppCompatActivity {

    private TextView mEarthResistanceEquipmentTextViewTypeOfEarth;
    private Spinner mEarthResistanceEquipmentSpinnerTypeOfEarth;
    private TextView mEarthResistanceEquipmentTextViewEarthResistance;
    private EditText mEarthResistanceEquipmentEditTextEarthResistance;
    private TextView mEarthResistanceEquipmentTextViewDateOfearthResistanceMeasured;
    private EditText mEarthResistanceEquipmentEditTextDateOfearthResistanceMeasured;

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_resistance_equipment);
        assignViews();
        this.setTitle("Earth Resistance (Equipment)");
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

        mEarthResistanceEquipmentEditTextDateOfearthResistanceMeasured.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Earth_Resistance_Equipment.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }


    private void assignViews() {
        mEarthResistanceEquipmentTextViewTypeOfEarth = (TextView) findViewById(R.id.earthResistanceEquipment_textView_typeOfEarth);
        mEarthResistanceEquipmentSpinnerTypeOfEarth = (Spinner) findViewById(R.id.earthResistanceEquipment_Spinner_typeOfEarth);
        mEarthResistanceEquipmentTextViewEarthResistance = (TextView) findViewById(R.id.earthResistanceEquipment_textView_earthResistance);
        mEarthResistanceEquipmentEditTextEarthResistance = (EditText) findViewById(R.id.earthResistanceEquipment_editText_earthResistance);
        mEarthResistanceEquipmentTextViewDateOfearthResistanceMeasured = (TextView) findViewById(R.id.earthResistanceEquipment_textView_dateOfearthResistanceMeasured);
        mEarthResistanceEquipmentEditTextDateOfearthResistanceMeasured = (EditText) findViewById(R.id.earthResistanceEquipment_editText_dateOfearthResistanceMeasured);
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mEarthResistanceEquipmentEditTextDateOfearthResistanceMeasured.setText(sdf.format(myCalendar.getTime()));
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

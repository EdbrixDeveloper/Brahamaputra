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
import android.widget.ImageView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ACDB_DCDB extends AppCompatActivity {


    private TextView mAcdbDcdbTextViewNumberofACDB;
    private SearchableSpinner mAcdbDcdbSpinnerNumberofACDB;
    private TextView mAcdbDcdbTextViewACDBRatingAMP;
    private EditText mAcdbDcdbEditTextACDBRatingAMP;
    private TextView mAcdbDcdbTextViewNumberofDCDB;
    private SearchableSpinner mAcdbDcdbSpinnerNumberofDCDB;
    private TextView mAcdbDcdbTextViewFreeCoolingDeviseStausFCU;
    private SearchableSpinner mAcdbDcdbSpinnerFreeCoolingDeviseStausFCU;

    private void assignViews() {
        mAcdbDcdbTextViewNumberofACDB = (TextView) findViewById(R.id.acdb_dcdb_textView_NumberofACDB);
        mAcdbDcdbSpinnerNumberofACDB = (SearchableSpinner) findViewById(R.id.acdb_dcdb_spinner_NumberofACDB);
        mAcdbDcdbTextViewACDBRatingAMP = (TextView) findViewById(R.id.acdb_dcdb_textView_ACDBRatingAMP);
        mAcdbDcdbEditTextACDBRatingAMP = (EditText) findViewById(R.id.acdb_dcdb_editText_ACDBRatingAMP);
        mAcdbDcdbTextViewNumberofDCDB = (TextView) findViewById(R.id.acdb_dcdb_textView_NumberofDCDB);
        mAcdbDcdbSpinnerNumberofDCDB = (SearchableSpinner) findViewById(R.id.acdb_dcdb_spinner_NumberofDCDB);
        mAcdbDcdbTextViewFreeCoolingDeviseStausFCU = (TextView) findViewById(R.id.acdb_dcdb_textView_FreeCoolingDeviseStausFCU);
        mAcdbDcdbSpinnerFreeCoolingDeviseStausFCU = (SearchableSpinner) findViewById(R.id.acdb_dcdb_spinner_FreeCoolingDeviseStausFCU);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acdb_dcdb);
        this.setTitle("ACDB/DCDB");
        assignViews();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dropdown_details_menu, menu);
        return true;
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

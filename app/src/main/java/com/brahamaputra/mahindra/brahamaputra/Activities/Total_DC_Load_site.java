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
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Total_DC_Load_site extends AppCompatActivity {

    private TextView mTotalDCLoadsiteTextViewTotalDcLoadOfSite;
    private EditText mTotalDCLoadsiteEditTextTotalDcLoadOfSite;

    private void assignViews() {
        mTotalDCLoadsiteTextViewTotalDcLoadOfSite = (TextView) findViewById(R.id.totalDCLoadsite_textView_totalDcLoadOfSite);
        mTotalDCLoadsiteEditTextTotalDcLoadOfSite = (EditText) findViewById(R.id.totalDCLoadsite_editText_totalDcLoadOfSite);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }





    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_dc_load_of_the_site);
        this.setTitle("Total DC load of the site");
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

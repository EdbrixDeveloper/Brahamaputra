package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

public class ServoStabilizer extends AppCompatActivity {

    private TextView mBatterySetTextViewQRCodeScan;
    private ImageView mBatterySetButtonQRCodeScan;
    private TextView mServoStabilizerTextViewServoStabilizerWorkingStatus;
    private SearchableSpinner mServoStabilizerSpinnerServoStabilizerWorkingStatus;
    private TextView mServoStabilizerTextViewMakeofServo;
    private SearchableSpinner mServoStabilizerSpinnerMakeofServo;
    private TextView mServoStabilizerTextViewRatingofServo;
    private SearchableSpinner mServoStabilizerSpinnerRatingofServo;
    private TextView mServoStabilizerTextViewWorkingCondition;
    private SearchableSpinner mServoStabilizerSpinnerWorkingCondition;
    private TextView mServoStabilizerTextViewNatureofProblem;
    private EditText mServoStabilizerEditTextNatureofProblem;

    private void assignViews() {
        mBatterySetTextViewQRCodeScan = (TextView) findViewById(R.id.batterySet_textView_QRCodeScan);
        mBatterySetButtonQRCodeScan = (ImageView) findViewById(R.id.batterySet_button_QRCodeScan);
        mServoStabilizerTextViewServoStabilizerWorkingStatus = (TextView) findViewById(R.id.ServoStabilizer_textView_ServoStabilizerWorkingStatus);
        mServoStabilizerSpinnerServoStabilizerWorkingStatus = (SearchableSpinner) findViewById(R.id.ServoStabilizer_spinner_ServoStabilizerWorkingStatus);
        mServoStabilizerTextViewMakeofServo = (TextView) findViewById(R.id.ServoStabilizer_textView_MakeofServo);
        mServoStabilizerSpinnerMakeofServo = (SearchableSpinner) findViewById(R.id.ServoStabilizer_spinner_MakeofServo);
        mServoStabilizerTextViewRatingofServo = (TextView) findViewById(R.id.ServoStabilizer_textView_RatingofServo);
        mServoStabilizerSpinnerRatingofServo = (SearchableSpinner) findViewById(R.id.ServoStabilizer_spinner_RatingofServo);
        mServoStabilizerTextViewWorkingCondition = (TextView) findViewById(R.id.ServoStabilizer_textView_WorkingCondition);
        mServoStabilizerSpinnerWorkingCondition = (SearchableSpinner) findViewById(R.id.ServoStabilizer_spinner_WorkingCondition);
        mServoStabilizerTextViewNatureofProblem = (TextView) findViewById(R.id.ServoStabilizer_textView_NatureofProblem);
        mServoStabilizerEditTextNatureofProblem = (EditText) findViewById(R.id.ServoStabilizer_editText_NatureofProblem);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servo_stabilizer);
        this.setTitle("SERVO STABILIZER");
       // assignViews();

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
            case android.R.id.home:finish();
               // startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;
            case R.id.menuDone:finish();
                startActivity(new Intent(this, DetailsOfUnusedMaterials.class));
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}

package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;

public class PreventiveMaintenanceSiteEbMeterBoxActivity extends BaseActivity {

    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterBoxCondition;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterBoxConditionVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterWorkingStatus;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterWorkingStatusVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewKitKatClayFuseStatus;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewKitKatClayFuseStatusVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewSfuMccbStatus;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewSfuMccbStatusVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewHrcFuseStatus;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewHrcFuseStatusVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewAcLoadAmpPh;
    private EditText mPreventiveMaintenanceSiteEbMeterBoxEditTextAcLoadAmpPhRPhase;
    private EditText mPreventiveMaintenanceSiteEbMeterBoxEditTextAcLoadAmpPhYPhase;
    private EditText mPreventiveMaintenanceSiteEbMeterBoxEditTextAcLoadAmpPhBPhase;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterReadingKwh;
    private EditText mPreventiveMaintenanceSiteEbMeterBoxEditTextEbMeterReadingKwh;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbServiceWireCondition;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewEbServiceWireConditionVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteEbMeterBoxTextViewTypeOfFaultVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_eb_meter_box);
        setTitle("EB METER BOX");
        assignViews();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterBoxCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebMeterBoxCondition);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterBoxConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebMeterBoxConditionVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterWorkingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebMeterWorkingStatus);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterWorkingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebMeterWorkingStatusVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewKitKatClayFuseStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_KitKatClayFuseStatus);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewKitKatClayFuseStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_KitKatClayFuseStatusVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewSfuMccbStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_SfuMccbStatus);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewSfuMccbStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_SfuMccbStatusVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewHrcFuseStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_HrcFuseStatus);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewHrcFuseStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_HrcFuseStatusVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewAcLoadAmpPh = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_acLoadAmpPh);
        mPreventiveMaintenanceSiteEbMeterBoxEditTextAcLoadAmpPhRPhase = (EditText) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_editText_acLoadAmpPh_rPhase);
        mPreventiveMaintenanceSiteEbMeterBoxEditTextAcLoadAmpPhYPhase = (EditText) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_editText_acLoadAmpPh_yPhase);
        mPreventiveMaintenanceSiteEbMeterBoxEditTextAcLoadAmpPhBPhase = (EditText) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_editText_acLoadAmpPh_bPhase);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbMeterReadingKwh = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebMeterReadingKwh);
        mPreventiveMaintenanceSiteEbMeterBoxEditTextEbMeterReadingKwh = (EditText) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_editText_ebMeterReadingKwh);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbServiceWireCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebServiceWireCondition);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewEbServiceWireConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_ebServiceWireConditionVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_registerFault);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_registerFaultVal);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_typeOfFault);
        mPreventiveMaintenanceSiteEbMeterBoxTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEbMeterBox_textView_typeOfFaultVal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.submit_icon_menu, menu);

        MenuItem shareItem = menu.findItem(R.id.menuSubmit);

        // show the button when some condition is true
        shareItem.setVisible(true);

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

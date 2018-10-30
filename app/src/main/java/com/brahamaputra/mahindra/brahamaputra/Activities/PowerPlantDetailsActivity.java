package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import android.widget.TextView;
import android.widget.TimePicker;

import com.brahamaputra.mahindra.brahamaputra.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PowerPlantDetailsActivity extends AppCompatActivity {

    private TextView mPowerPlantDetailsTextViewQRCodeScan;
    private ImageView mPowerPlantDetailsButtonQRCodeScan;
    private TextView mPowerPlantDetailsTextViewAssetOwner;
    private SearchableSpinner mPowerPlantDetailsSpinnerAssetOwner;
    private TextView mPowerPlantDetailsTextViewNumberOfPowerPlant;
    private SearchableSpinner mPowerPlantDetailsSpinnerNumberOfPowerPlant;
    private TextView mPowerPlantDetailsTextViewManufacturerMakeModel;
    private SearchableSpinner mPowerPlantDetailsSpinnerManufacturerMakeModel;
    private TextView mPowerPlantDetailsTextViewPowerPlantModel;
    private EditText mPowerPlantDetailsEditTextPowerPlantModel;
    private TextView mPowerPlantDetailsTextViewNumberModuleSlots;
    private SearchableSpinner mPowerPlantDetailsSpinnerNumberModuleSlots;
    private TextView mPowerPlantDetailsTextViewPowerPlantEarthingStatus;
    private SearchableSpinner mPowerPlantDetailsSpinnerPowerPlantEarthingStatus;
    private TextView mPowerPlantDetailsTextViewDcLoadInDisplayAmp;
    private EditText mPowerPlantDetailsEditTextDcLoadInDisplayAmp;
    private TextView mPowerPlantDetailsTextViewPowerPlantSerialNumber;
    private EditText mPowerPlantDetailsEditTextPowerPlantSerialNumber;
    private TextView mPowerPlantDetailsTextViewTypeOfPowerPlantCommercialSmps;
    private SearchableSpinner mPowerPlantDetailsSpinnerTypeOfPowerPlantCommercialSmps;
    private TextView mPowerPlantDetailsTextViewCapacityInAmp;
    private EditText mPowerPlantDetailsEditTextCapacityInAmp;
    private TextView mPowerPlantDetailsTextViewNumberOfModules;
    private SearchableSpinner powerPlantDetails_Spinner_numberOfModules;
    private TextView mPowerPlantDetailsTextViewNoOfFaultyModulese;
    private SearchableSpinner mPowerPlantDetailsSpinnerNoOfFaultyModules;
    private TextView mPowerPlantDetailsTextViewSmpsExpandableUpToKW;
    private EditText mPowerPlantDetailsEditTextSmpsExpandableUpToKW;
    private TextView mPowerPlantDetailsTextViewSmpsUltimateCapacity;
    private EditText mPowerPlantDetailsEditTextSmpsUltimateCapacity;
    private TextView mPowerPlantDetailsTextViewSpdStatus;
    private SearchableSpinner mPowerPlantDetailsSpinnerSpdStatus;
    private TextView mPowerPlantDetailsTextViewWorkingCondition;
    private SearchableSpinner mPowerPlantDetailsSpinnerWorkingCondition;
    private TextView mPowerPlantDetailsTextViewNatureOfProblem;
    private EditText mPowerPlantDetailsEditTextNatureOfProblem;

    //
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";
    public String date_flag = "no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_plant_details);
        this.setTitle("Power Plant Details");
        assignViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPowerPlantDetailsButtonQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(PowerPlantDetailsActivity.this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (getFromPref(PowerPlantDetailsActivity.this, ALLOW_KEY)) {

                        showSettingsAlert();

                    } else if (ContextCompat.checkSelfPermission(PowerPlantDetailsActivity.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(PowerPlantDetailsActivity.this,
                                Manifest.permission.CAMERA)) {
                            showAlert();
                        } else {
                            // No explanation needed, we can request the permission.
                            ActivityCompat.requestPermissions(PowerPlantDetailsActivity.this,
                                    new String[]{Manifest.permission.CAMERA},
                                    MY_PERMISSIONS_REQUEST_CAMERA);
                        }
                    }
                } else {
                    openCamera();
                }

            }
        });

    }


    private void assignViews() {
        mPowerPlantDetailsTextViewQRCodeScan = (TextView) findViewById(R.id.powerPlantDetails_textView_QRCodeScan);
        mPowerPlantDetailsButtonQRCodeScan = (ImageView) findViewById(R.id.powerPlantDetails_button_QRCodeScan);
        mPowerPlantDetailsTextViewAssetOwner = (TextView) findViewById(R.id.powerPlantDetails_textView_assetOwner);
        mPowerPlantDetailsSpinnerAssetOwner = (SearchableSpinner) findViewById(R.id.powerPlantDetails_Spinner_assetOwner);
        mPowerPlantDetailsTextViewNumberOfPowerPlant = (TextView) findViewById(R.id.powerPlantDetails_textView_numberOfPowerPlant);
        mPowerPlantDetailsSpinnerNumberOfPowerPlant = (SearchableSpinner) findViewById(R.id.powerPlantDetails_Spinner_numberOfPowerPlant);
        mPowerPlantDetailsTextViewManufacturerMakeModel = (TextView) findViewById(R.id.powerPlantDetails_textView_manufacturerMakeModel);
        mPowerPlantDetailsSpinnerManufacturerMakeModel = (SearchableSpinner) findViewById(R.id.powerPlantDetails_Spinner_manufacturerMakeModel);
        mPowerPlantDetailsTextViewPowerPlantModel = (TextView) findViewById(R.id.powerPlantDetails_textView_powerPlantModel);
        mPowerPlantDetailsEditTextPowerPlantModel = (EditText) findViewById(R.id.powerPlantDetails_editText_powerPlantModel);
        mPowerPlantDetailsTextViewNumberModuleSlots = (TextView) findViewById(R.id.powerPlantDetails_textView_numberModuleSlots);
        mPowerPlantDetailsSpinnerNumberModuleSlots = (SearchableSpinner) findViewById(R.id.powerPlantDetails_Spinner_numberModuleSlots);
        mPowerPlantDetailsTextViewPowerPlantEarthingStatus = (TextView) findViewById(R.id.powerPlantDetails_textView_powerPlantEarthingStatus);
        mPowerPlantDetailsSpinnerPowerPlantEarthingStatus = (SearchableSpinner) findViewById(R.id.powerPlantDetails_Spinner_powerPlantEarthingStatus);
        mPowerPlantDetailsTextViewDcLoadInDisplayAmp = (TextView) findViewById(R.id.powerPlantDetails_textView_dcLoadInDisplayAmp);
        mPowerPlantDetailsEditTextDcLoadInDisplayAmp = (EditText) findViewById(R.id.powerPlantDetails_editText_dcLoadInDisplayAmp);
        mPowerPlantDetailsTextViewPowerPlantSerialNumber = (TextView) findViewById(R.id.powerPlantDetails_textView_powerPlantSerialNumber);
        mPowerPlantDetailsEditTextPowerPlantSerialNumber = (EditText) findViewById(R.id.powerPlantDetails_editText_powerPlantSerialNumber);
        mPowerPlantDetailsTextViewTypeOfPowerPlantCommercialSmps = (TextView) findViewById(R.id.powerPlantDetails_textView_typeOfPowerPlantCommercialSmps);
        mPowerPlantDetailsSpinnerTypeOfPowerPlantCommercialSmps = (SearchableSpinner) findViewById(R.id.powerPlantDetails_Spinner_typeOfPowerPlantCommercialSmps);
        mPowerPlantDetailsTextViewCapacityInAmp = (TextView) findViewById(R.id.powerPlantDetails_textView_capacityInAmp);
        mPowerPlantDetailsEditTextCapacityInAmp = (EditText) findViewById(R.id.powerPlantDetails_editText_capacityInAmp);
        mPowerPlantDetailsTextViewNumberOfModules = (TextView) findViewById(R.id.powerPlantDetails_textView_numberOfModules);
        powerPlantDetails_Spinner_numberOfModules = (SearchableSpinner) findViewById(R.id.powerPlantDetails_Spinner_numberOfModules);
        mPowerPlantDetailsTextViewNoOfFaultyModulese = (TextView) findViewById(R.id.powerPlantDetails_textView_noOfFaultyModulese);
        mPowerPlantDetailsSpinnerNoOfFaultyModules = (SearchableSpinner) findViewById(R.id.powerPlantDetails_Spinner_noOfFaultyModules);
        mPowerPlantDetailsTextViewSmpsExpandableUpToKW = (TextView) findViewById(R.id.powerPlantDetails_textView_smpsExpandableUpToKW);
        mPowerPlantDetailsEditTextSmpsExpandableUpToKW = (EditText) findViewById(R.id.powerPlantDetails_editText_smpsExpandableUpToKW);
        mPowerPlantDetailsTextViewSmpsUltimateCapacity = (TextView) findViewById(R.id.powerPlantDetails_textView_smpsUltimateCapacity);
        mPowerPlantDetailsEditTextSmpsUltimateCapacity = (EditText) findViewById(R.id.powerPlantDetails_editText_smpsUltimateCapacity);
        mPowerPlantDetailsTextViewSpdStatus = (TextView) findViewById(R.id.powerPlantDetails_textView_spdStatus);
        mPowerPlantDetailsSpinnerSpdStatus = (SearchableSpinner) findViewById(R.id.powerPlantDetails_Spinner_spdStatus);
        mPowerPlantDetailsTextViewWorkingCondition = (TextView) findViewById(R.id.powerPlantDetails_textView_workingCondition);
        mPowerPlantDetailsSpinnerWorkingCondition = (SearchableSpinner) findViewById(R.id.powerPlantDetails_Spinner_workingCondition);
        mPowerPlantDetailsTextViewNatureOfProblem = (TextView) findViewById(R.id.powerPlantDetails_textView_natureOfProblem);
        mPowerPlantDetailsEditTextNatureOfProblem = (EditText) findViewById(R.id.powerPlantDetails_editText_natureOfProblem);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        mPowerPlantDetailsSpinnerAssetOwner.setTitle("Asset Owner");
        mPowerPlantDetailsSpinnerNumberOfPowerPlant.setTitle("Number of Power Plant");
        mPowerPlantDetailsSpinnerManufacturerMakeModel.setTitle("Manufacturer/Make");
        mPowerPlantDetailsSpinnerNumberModuleSlots.setTitle("Number Module Slots");
        mPowerPlantDetailsSpinnerPowerPlantEarthingStatus.setTitle("Power Plant Earthing Status");
        mPowerPlantDetailsSpinnerTypeOfPowerPlantCommercialSmps.setTitle("Type of the Power Plant [Commercial/SMPs]");
        powerPlantDetails_Spinner_numberOfModules.setTitle("Number of Modules");
        mPowerPlantDetailsSpinnerNoOfFaultyModules.setTitle("No. of Faulty Modules");
        mPowerPlantDetailsSpinnerSpdStatus.setTitle("SPD Status");
        mPowerPlantDetailsSpinnerWorkingCondition.setTitle("Working Condition");
    }


    public static Boolean getFromPref(Context context, String key) {
        SharedPreferences myPrefs = context.getSharedPreferences
                (CAMERA_PREF, Context.MODE_PRIVATE);
        return (myPrefs.getBoolean(key, false));
    }

    private void showSettingsAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("App needs to access the Camera.");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //finish();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startInstalledAppDetailsActivity(PowerPlantDetailsActivity.this);

                    }
                });
        alertDialog.show();
    }

    public static void startInstalledAppDetailsActivity(final Activity context) {
        if (context == null) {
            return;
        }
        final Intent i = new Intent();
        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.setData(Uri.parse("package:" + context.getPackageName()));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(i);
    }

    private void showAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("App needs to access the Camera.");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ALLOW",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ActivityCompat.requestPermissions(PowerPlantDetailsActivity.this,
                                new String[]{Manifest.permission.CAMERA},
                                MY_PERMISSIONS_REQUEST_CAMERA);

                    }
                });
        alertDialog.show();
    }

    private void openCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult
            (int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                for (int i = 0, len = permissions.length; i < len; i++) {
                    String permission = permissions[i];
                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                        boolean showRationale =
                                ActivityCompat.shouldShowRequestPermissionRationale
                                        (this, permission);
                        if (showRationale) {
                            showAlert();
                        } else if (!showRationale) {
                            // user denied flagging NEVER ASK AGAIN
                            // you can either enable some fall back,
                            // disable features of your app
                            // or open another dialog explaining
                            // again the permission and directing to
                            // the app setting
                            saveToPreferences(PowerPlantDetailsActivity.this, ALLOW_KEY, true);
                        }
                    }
                }
            }


        }
    }

    public static void saveToPreferences(Context context, String key,
                                         Boolean allowed) {
        SharedPreferences myPrefs = context.getSharedPreferences
                (CAMERA_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putBoolean(key, allowed);
        prefsEditor.commit();
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
                startActivity(new Intent(this, Power_Backups_DG.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

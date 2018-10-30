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

public class Power_Backups_DG extends AppCompatActivity {

    private TextView mPowerBackupsDgTextViewNoOfEngineAlternatorSetsprovided;
    private SearchableSpinner mPowerBackupsDgSpinnerNoOfEngineAlternatorSetsprovided;
    private TextView mPowerBackupsDgTextViewNumberOfWorkingDg;
    private SearchableSpinner mPowerBackupsDgSpinnerNumberOfWorkingDg;
    private TextView mPowerBackupsDgTextViewQRCodeScan;
    private ImageView mPowerBackupsDgButtonQRCodeScan;
    private TextView mPowerBackupsDgTextViewAssetOwner;
    private SearchableSpinner mPowerBackupsDgSpinnerAssetOwner;
    private TextView mPowerBackupsDgTextViewDividerDesign;
    private TextView mPowerBackupsDgTextViewManufacturerMakeModel;
    private SearchableSpinner mPowerBackupsDgSpinnerManufacturerMakeModel;
    private TextView mPowerBackupsDgTextViewCapacityInKva;
    private SearchableSpinner mPowerBackupsDgSpinnerCapacityInKva;
    private TextView mPowerBackupsDgTextViewAutoManual;
    private SearchableSpinner mPowerBackupsDgSpinnerAutoManual;
    private TextView mPowerBackupsDgTextViewDieselTankCapacity;
    private EditText mPowerBackupsDgEditTextDieselTankCapacity;
    private TextView mPowerBackupsDgTextViewDateOfInstallation;
    private EditText mPowerBackupsDgEditTextDateOfInstallation;
    private TextView mPowerBackupsDgTextViewAverageDieselConsumption;
    private EditText mPowerBackupsDgEditTextAverageDieselConsumption;
    private TextView mPowerBackupsDgTextViewAmc;
    private SearchableSpinner mPowerBackupsDgSpinnerAmc;
    private TextView mPowerBackupsDgTextViewValidityOfAmc;
    private EditText mPowerBackupsDgEditTextDateOfvalidityOfAmc;
    private TextView mPowerBackupsDgTextViewDgWorkingType;
    private SearchableSpinner mPowerBackupsDgSpinnerDgWorkingType;
    private TextView mPowerBackupsDgTextViewDgHmrReading;
    private EditText mPowerBackupsDgEditTextDgHmrReading;
    private TextView mPowerBackupsDgTextViewDgEngineSerialNumber;
    private EditText mPowerBackupsDgEditTextDgEngineSerialNumber;
    private TextView mPowerBackupsDgTextViewDgMainAlternatorType;
    private SearchableSpinner mPowerBackupsDgSpinnerDgMainAlternatorType;
    private TextView mPowerBackupsDgTextViewDgMainAlternatorMake;
    private SearchableSpinner mPowerBackupsDgSpinnerDgMainAlternatorMake;
    private TextView mPowerBackupsDgTextViewDgMainAlternatorSerialNumber;
    private EditText mPowerBackupsDgEditTextDgMainAlternatorSerialNumber;
    private TextView mPowerBackupsDgTextViewDgCanopyStatus;
    private SearchableSpinner mPowerBackupsDgSpinnerDgCanopyStatus;
    private TextView mPowerBackupsDgTextViewDgStartingBatteryStatus;
    private SearchableSpinner mPowerBackupsDgSpinnerDgStartingBatteryStatus;
    private TextView mPowerBackupsDgTextViewChargingAlternator;
    private SearchableSpinner mPowerBackupsDgSpinnerChargingAlternator;
    private TextView mPowerBackupsDgTextViewBatteryCharger;
    private SearchableSpinner mPowerBackupsDgSpinnerBatteryCharger;
    private TextView mPowerBackupsDgTextViewPresentDieselStock;
    private EditText mPowerBackupsDgEditTextPresentDieselStock;
    private TextView mPowerBackupsDgTextViewGcuRunHrs;
    private EditText mPowerBackupsDgEditTextGcuRunHrs;
    private TextView mPowerBackupsDgTextViewGcuKwh;
    private EditText mPowerBackupsDgEditTextGcuKwh;
    private TextView mPowerBackupsDgTextViewDgAvrWorkingStatus;
    private SearchableSpinner mPowerBackupsDgSpinnerDgAvrWorkingStatus;
    private TextView mPowerBackupsDgTextViewFuelTankPosition;
    private SearchableSpinner mPowerBackupsDgSpinnerFuelTankPosition;
    private TextView mPowerBackupsDgTextViewWorkingCondition;
    private SearchableSpinner mPowerBackupsDgSpinnerWorkingCondition;
    private TextView mPowerBackupsDgTextViewNatureOfProblem;
    private EditText mPowerBackupsDgEditTextNatureOfProblem;


    final Calendar myCalendar = Calendar.getInstance();

    /////////////////////////
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";
    public String date_flag = "no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_backups_dg);
        this.setTitle("Power Backups (DG)");
        assignViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        mPowerBackupsDgButtonQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Power_Backups_DG.this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (getFromPref(Power_Backups_DG.this, ALLOW_KEY)) {

                        showSettingsAlert();

                    } else if (ContextCompat.checkSelfPermission(Power_Backups_DG.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(Power_Backups_DG.this,
                                Manifest.permission.CAMERA)) {
                            showAlert();
                        } else {
                            // No explanation needed, we can request the permission.
                            ActivityCompat.requestPermissions(Power_Backups_DG.this,
                                    new String[]{Manifest.permission.CAMERA},
                                    MY_PERMISSIONS_REQUEST_CAMERA);
                        }
                    }
                } else {
                    openCamera();
                }

            }
        });


        mPowerBackupsDgEditTextDateOfInstallation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_flag = "install";
                new DatePickerDialog(Power_Backups_DG.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        mPowerBackupsDgEditTextDateOfvalidityOfAmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_flag = "valid";
                new DatePickerDialog(Power_Backups_DG.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void assignViews() {
        mPowerBackupsDgTextViewNoOfEngineAlternatorSetsprovided = (TextView) findViewById(R.id.powerBackupsDg_textView_noOfEngineAlternatorSetsprovided);
        mPowerBackupsDgSpinnerNoOfEngineAlternatorSetsprovided = (SearchableSpinner) findViewById(R.id.powerBackupsDg_spinner_noOfEngineAlternatorSetsprovided);
        mPowerBackupsDgTextViewNumberOfWorkingDg = (TextView) findViewById(R.id.powerBackupsDg_textView_numberOfWorkingDg);
        mPowerBackupsDgSpinnerNumberOfWorkingDg = (SearchableSpinner) findViewById(R.id.powerBackupsDg_spinner_numberOfWorkingDg);
        mPowerBackupsDgTextViewQRCodeScan = (TextView) findViewById(R.id.powerBackupsDg_textView_QRCodeScan);
        mPowerBackupsDgButtonQRCodeScan = (ImageView) findViewById(R.id.powerBackupsDg_button_QRCodeScan);
        mPowerBackupsDgTextViewAssetOwner = (TextView) findViewById(R.id.powerBackupsDg_textView_assetOwner);
        mPowerBackupsDgSpinnerAssetOwner = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_assetOwner);
        mPowerBackupsDgTextViewDividerDesign = (TextView) findViewById(R.id.powerBackupsDg_textView_dividerDesign);
        mPowerBackupsDgTextViewManufacturerMakeModel = (TextView) findViewById(R.id.powerBackupsDg_textView_manufacturerMakeModel);
        mPowerBackupsDgSpinnerManufacturerMakeModel = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_manufacturerMakeModel);
        mPowerBackupsDgTextViewCapacityInKva = (TextView) findViewById(R.id.powerBackupsDg_textView_capacityInKva);
        mPowerBackupsDgSpinnerCapacityInKva = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_capacityInKva);
        mPowerBackupsDgTextViewAutoManual = (TextView) findViewById(R.id.powerBackupsDg_textView_autoManual);
        mPowerBackupsDgSpinnerAutoManual = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_autoManual);
        mPowerBackupsDgTextViewDieselTankCapacity = (TextView) findViewById(R.id.powerBackupsDg_textView_dieselTankCapacity);
        mPowerBackupsDgEditTextDieselTankCapacity = (EditText) findViewById(R.id.powerBackupsDg_editText_dieselTankCapacity);
        mPowerBackupsDgTextViewDateOfInstallation = (TextView) findViewById(R.id.powerBackupsDg_textView_dateOfInstallation);
        mPowerBackupsDgEditTextDateOfInstallation = (EditText) findViewById(R.id.powerBackupsDg_editText_dateOfInstallation);
        mPowerBackupsDgTextViewAverageDieselConsumption = (TextView) findViewById(R.id.powerBackupsDg_textView_averageDieselConsumption);
        mPowerBackupsDgEditTextAverageDieselConsumption = (EditText) findViewById(R.id.powerBackupsDg_editText_averageDieselConsumption);
        mPowerBackupsDgTextViewAmc = (TextView) findViewById(R.id.powerBackupsDg_textView_amc);
        mPowerBackupsDgSpinnerAmc = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_amc);
        mPowerBackupsDgTextViewValidityOfAmc = (TextView) findViewById(R.id.powerBackupsDg_textView_validityOfAmc);
        mPowerBackupsDgEditTextDateOfvalidityOfAmc = (EditText) findViewById(R.id.powerBackupsDg_editText_dateOfvalidityOfAmc);
        mPowerBackupsDgTextViewDgWorkingType = (TextView) findViewById(R.id.powerBackupsDg_textView_dgWorkingType);
        mPowerBackupsDgSpinnerDgWorkingType = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_dgWorkingType);
        mPowerBackupsDgTextViewDgHmrReading = (TextView) findViewById(R.id.powerBackupsDg_textView_dgHmrReading);
        mPowerBackupsDgEditTextDgHmrReading = (EditText) findViewById(R.id.powerBackupsDg_editText_dgHmrReading);
        mPowerBackupsDgTextViewDgEngineSerialNumber = (TextView) findViewById(R.id.powerBackupsDg_textView_dgEngineSerialNumber);
        mPowerBackupsDgEditTextDgEngineSerialNumber = (EditText) findViewById(R.id.powerBackupsDg_editText_dgEngineSerialNumber);
        mPowerBackupsDgTextViewDgMainAlternatorType = (TextView) findViewById(R.id.powerBackupsDg_textView_dgMainAlternatorType);
        mPowerBackupsDgSpinnerDgMainAlternatorType = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_dgMainAlternatorType);
        mPowerBackupsDgTextViewDgMainAlternatorMake = (TextView) findViewById(R.id.powerBackupsDg_textView_dgMainAlternatorMake);
        mPowerBackupsDgSpinnerDgMainAlternatorMake = (SearchableSpinner) findViewById(R.id.powerBackupsDg_spinner_dgMainAlternatorMake);
        mPowerBackupsDgTextViewDgMainAlternatorSerialNumber = (TextView) findViewById(R.id.powerBackupsDg_textView_dgMainAlternatorSerialNumber);
        mPowerBackupsDgEditTextDgMainAlternatorSerialNumber = (EditText) findViewById(R.id.powerBackupsDg_editText_dgMainAlternatorSerialNumber);
        mPowerBackupsDgTextViewDgCanopyStatus = (TextView) findViewById(R.id.powerBackupsDg_textView_dgCanopyStatus);
        mPowerBackupsDgSpinnerDgCanopyStatus = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_dgCanopyStatus);
        mPowerBackupsDgTextViewDgStartingBatteryStatus = (TextView) findViewById(R.id.powerBackupsDg_textView_dgStartingBatteryStatus);
        mPowerBackupsDgSpinnerDgStartingBatteryStatus = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_dgStartingBatteryStatus);
        mPowerBackupsDgTextViewChargingAlternator = (TextView) findViewById(R.id.powerBackupsDg_textView_chargingAlternator);
        mPowerBackupsDgSpinnerChargingAlternator = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_chargingAlternator);
        mPowerBackupsDgTextViewBatteryCharger = (TextView) findViewById(R.id.powerBackupsDg_textView_batteryCharger);
        mPowerBackupsDgSpinnerBatteryCharger = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_batteryCharger);
        mPowerBackupsDgTextViewPresentDieselStock = (TextView) findViewById(R.id.powerBackupsDg_textView_presentDieselStock);
        mPowerBackupsDgEditTextPresentDieselStock = (EditText) findViewById(R.id.powerBackupsDg_editText_presentDieselStock);
        mPowerBackupsDgTextViewGcuRunHrs = (TextView) findViewById(R.id.powerBackupsDg_textView_gcuRunHrs);
        mPowerBackupsDgEditTextGcuRunHrs = (EditText) findViewById(R.id.powerBackupsDg_editText_gcuRunHrs);
        mPowerBackupsDgTextViewGcuKwh = (TextView) findViewById(R.id.powerBackupsDg_textView_gcuKwh);
        mPowerBackupsDgEditTextGcuKwh = (EditText) findViewById(R.id.powerBackupsDg_editText_gcuKwh);
        mPowerBackupsDgTextViewDgAvrWorkingStatus = (TextView) findViewById(R.id.powerBackupsDg_textView_dgAvrWorkingStatus);
        mPowerBackupsDgSpinnerDgAvrWorkingStatus = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_dgAvrWorkingStatus);
        mPowerBackupsDgTextViewFuelTankPosition = (TextView) findViewById(R.id.powerBackupsDg_textView_fuelTankPosition);
        mPowerBackupsDgSpinnerFuelTankPosition = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_fuelTankPosition);
        mPowerBackupsDgTextViewWorkingCondition = (TextView) findViewById(R.id.powerBackupsDg_textView_workingCondition);
        mPowerBackupsDgSpinnerWorkingCondition = (SearchableSpinner) findViewById(R.id.powerBackupsDg_Spinner_workingCondition);
        mPowerBackupsDgTextViewNatureOfProblem = (TextView) findViewById(R.id.powerBackupsDg_textView_natureOfProblem);
        mPowerBackupsDgEditTextNatureOfProblem = (EditText) findViewById(R.id.powerBackupsDg_editText_natureOfProblem);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        mPowerBackupsDgSpinnerNoOfEngineAlternatorSetsprovided.setTitle("No.of Engine Alternator Sets provided");
        mPowerBackupsDgSpinnerNumberOfWorkingDg.setTitle("Number of Working DG");
        mPowerBackupsDgSpinnerAssetOwner.setTitle("Asset Owner");
        mPowerBackupsDgSpinnerManufacturerMakeModel.setTitle("Manufacturer/Make/Model");
        mPowerBackupsDgSpinnerCapacityInKva.setTitle("Capacity in KVA");
        mPowerBackupsDgSpinnerAutoManual.setTitle("Auto/ Manual");
        mPowerBackupsDgSpinnerAmc.setTitle("AMC(Yes/No)");
        mPowerBackupsDgSpinnerDgWorkingType.setTitle("DG Working Type");
        mPowerBackupsDgSpinnerDgMainAlternatorType.setTitle("DG Main Alternator Type");
        mPowerBackupsDgSpinnerDgMainAlternatorMake.setTitle("DG Main Alternator Make");
        mPowerBackupsDgSpinnerDgCanopyStatus.setTitle("DG Canopy Status");
        mPowerBackupsDgSpinnerDgStartingBatteryStatus.setTitle("DG Starting Battery Status");
        mPowerBackupsDgSpinnerChargingAlternator.setTitle("Charging Alternator");
        mPowerBackupsDgSpinnerBatteryCharger.setTitle("Battery Charger");
        mPowerBackupsDgSpinnerDgAvrWorkingStatus.setTitle("DG AVR working Status");
        mPowerBackupsDgSpinnerFuelTankPosition.setTitle("Fuel Tank Position");
        mPowerBackupsDgSpinnerWorkingCondition.setTitle("Working Condition");

    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        if (date_flag.equals("install")) {
            mPowerBackupsDgEditTextDateOfInstallation.setText(sdf.format(myCalendar.getTime()));
        } else if (date_flag.equals("valid")) {
            mPowerBackupsDgEditTextDateOfvalidityOfAmc.setText(sdf.format(myCalendar.getTime()));
        } else {

        }
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
                        startInstalledAppDetailsActivity(Power_Backups_DG.this);

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
                        ActivityCompat.requestPermissions(Power_Backups_DG.this,
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
                            saveToPreferences(Power_Backups_DG.this, ALLOW_KEY, true);
                        }
                    }
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request

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
                startActivity(new Intent(this, Shelter.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

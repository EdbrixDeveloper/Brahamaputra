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

import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import android.widget.TextView;
import android.widget.TimePicker;

import com.brahamaputra.mahindra.brahamaputra.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class Power_Backups_DG extends BaseActivity {

    private TextView mPowerBackupsDgTextViewNoOfEngineAlternatorSetsprovided;
    private TextView mPowerBackupsDgTextViewNoOfEngineAlternatorSetsprovidedVal;
    private TextView mPowerBackupsDgTextViewNumberOfWorkingDg;
    private TextView mPowerBackupsDgTextViewNumberOfWorkingDgVal;
    private TextView mPowerBackupsDgTextViewQRCodeScan;
    private ImageView mPowerBackupsDgButtonQRCodeScan;
    private TextView mPowerBackupsDgTextViewAssetOwner;
    private TextView mPowerBackupsDgTextViewAssetOwnerVal;
    private TextView mPowerBackupsDgTextViewDividerDesign;
    private TextView mPowerBackupsDgTextViewManufacturerMakeModel;
    private TextView mPowerBackupsDgTextViewManufacturerMakeModelVal;
    private TextView mPowerBackupsDgTextViewCapacityInKva;
    private TextView mPowerBackupsDgTextViewCapacityInKvaVal;
    private TextView mPowerBackupsDgTextViewAutoManual;
    private TextView mPowerBackupsDgTextViewAutoManualVal;
    private TextView mPowerBackupsDgTextViewDieselTankCapacity;
    private EditText mPowerBackupsDgEditTextDieselTankCapacity;
    private TextView mPowerBackupsDgTextViewDateOfInstallation;
    private EditText mPowerBackupsDgEditTextDateOfInstallation;
    private TextView mPowerBackupsDgTextViewAverageDieselConsumption;
    private EditText mPowerBackupsDgEditTextAverageDieselConsumption;
    private TextView mPowerBackupsDgTextViewAmc;
    private TextView mPowerBackupsDgTextViewAmcVal;
    private TextView mPowerBackupsDgTextViewValidityOfAmc;
    private EditText mPowerBackupsDgEditTextDateOfvalidityOfAmc;
    private TextView mPowerBackupsDgTextViewDgWorkingType;
    private TextView mPowerBackupsDgTextViewDgWorkingTypeVal;
    private TextView mPowerBackupsDgTextViewDgHmrReading;
    private EditText mPowerBackupsDgEditTextDgHmrReading;
    private TextView mPowerBackupsDgTextViewDgEngineSerialNumber;
    private EditText mPowerBackupsDgEditTextDgEngineSerialNumber;
    private TextView mPowerBackupsDgTextViewDgMainAlternatorType;
    private TextView mPowerBackupsDgTextViewDgMainAlternatorTypeVal;
    private TextView mPowerBackupsDgTextViewDgMainAlternatorMake;
    private TextView mPowerBackupsDgTextViewDgMainAlternatorMakeVal;
    private TextView mPowerBackupsDgTextViewDgMainAlternatorSerialNumber;
    private EditText mPowerBackupsDgEditTextDgMainAlternatorSerialNumber;
    private TextView mPowerBackupsDgTextViewDgCanopyStatus;
    private TextView mPowerBackupsDgTextViewDgCanopyStatusVal;
    private TextView mPowerBackupsDgTextViewDgStartingBatteryStatus;
    private TextView mPowerBackupsDgTextViewDgStartingBatteryStatusVal;
    private TextView mPowerBackupsDgTextViewChargingAlternator;
    private TextView mPowerBackupsDgTextViewChargingAlternatorVal;
    private TextView mPowerBackupsDgTextViewBatteryCharger;
    private TextView mPowerBackupsDgTextViewBatteryChargerVal;
    private TextView mPowerBackupsDgTextViewPresentDieselStock;
    private EditText mPowerBackupsDgEditTextPresentDieselStock;
    private TextView mPowerBackupsDgTextViewGcuRunHrs;
    private EditText mPowerBackupsDgEditTextGcuRunHrs;
    private TextView mPowerBackupsDgTextViewGcuKwh;
    private EditText mPowerBackupsDgEditTextGcuKwh;
    private TextView mPowerBackupsDgTextViewDgAvrWorkingStatus;
    private TextView mPowerBackupsDgTextViewDgAvrWorkingStatusVal;
    private TextView mPowerBackupsDgTextViewFuelTankPosition;
    private TextView mPowerBackupsDgTextViewFuelTankPositionVal;
    private TextView mPowerBackupsDgTextViewWorkingCondition;
    private TextView mPowerBackupsDgTextViewWorkingConditionVal;
    private TextView mPowerBackupsDgTextViewNatureOfProblem;
    private EditText mPowerBackupsDgEditTextNatureOfProblem;


    String str_noOfEngineAlternatorSetsprovided;
    String str_numberOfWorkingDg;
    String str_assetOwner;
    String str_manufacturerMakeModel;
    String str_capacityInKva;
    String str_autoManual;
    String str_amc;
    String str_dgWorkingType;
    String str_dgMainAlternatorType;
    String str_dgMainAlternatorMake;
    String str_DgCanopyStatus;
    String str_dgStartingBatteryStatus;
    String str_chargingAlternator;
    String str_batteryCharger;
    String str_dgAvrWorkingStatus;
    String str_fuelTankPosition;
    String str_workingCondition;


    final Calendar myCalendar = Calendar.getInstance();

    /////////////////////////
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";
    public String date_flag = "no";

    private AlertDialogManager alertDialogManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_backups_dg);
        this.setTitle("Power Backups (DG)");
        alertDialogManager = new AlertDialogManager(Power_Backups_DG.this);
        assignViews();
        initCombo();
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
        mPowerBackupsDgTextViewNoOfEngineAlternatorSetsprovidedVal = (TextView) findViewById(R.id.powerBackupsDg_textView_noOfEngineAlternatorSetsprovided_val);
        mPowerBackupsDgTextViewNumberOfWorkingDg = (TextView) findViewById(R.id.powerBackupsDg_textView_numberOfWorkingDg);
        mPowerBackupsDgTextViewNumberOfWorkingDgVal = (TextView) findViewById(R.id.powerBackupsDg_textView_numberOfWorkingDg_val);
        mPowerBackupsDgTextViewQRCodeScan = (TextView) findViewById(R.id.powerBackupsDg_textView_QRCodeScan);
        mPowerBackupsDgButtonQRCodeScan = (ImageView) findViewById(R.id.powerBackupsDg_button_QRCodeScan);
        mPowerBackupsDgTextViewAssetOwner = (TextView) findViewById(R.id.powerBackupsDg_textView_assetOwner);
        mPowerBackupsDgTextViewAssetOwnerVal = (TextView) findViewById(R.id.powerBackupsDg_textView_assetOwner_val);
        mPowerBackupsDgTextViewDividerDesign = (TextView) findViewById(R.id.powerBackupsDg_textView_dividerDesign);
        mPowerBackupsDgTextViewManufacturerMakeModel = (TextView) findViewById(R.id.powerBackupsDg_textView_manufacturerMakeModel);
        mPowerBackupsDgTextViewManufacturerMakeModelVal = (TextView) findViewById(R.id.powerBackupsDg_textView_manufacturerMakeModel_val);
        mPowerBackupsDgTextViewCapacityInKva = (TextView) findViewById(R.id.powerBackupsDg_textView_capacityInKva);
        mPowerBackupsDgTextViewCapacityInKvaVal = (TextView) findViewById(R.id.powerBackupsDg_textView_capacityInKva_val);
        mPowerBackupsDgTextViewAutoManual = (TextView) findViewById(R.id.powerBackupsDg_textView_autoManual);
        mPowerBackupsDgTextViewAutoManualVal = (TextView) findViewById(R.id.powerBackupsDg_textView_autoManual_val);
        mPowerBackupsDgTextViewDieselTankCapacity = (TextView) findViewById(R.id.powerBackupsDg_textView_dieselTankCapacity);
        mPowerBackupsDgEditTextDieselTankCapacity = (EditText) findViewById(R.id.powerBackupsDg_editText_dieselTankCapacity);
        mPowerBackupsDgTextViewDateOfInstallation = (TextView) findViewById(R.id.powerBackupsDg_textView_dateOfInstallation);
        mPowerBackupsDgEditTextDateOfInstallation = (EditText) findViewById(R.id.powerBackupsDg_editText_dateOfInstallation);
        mPowerBackupsDgTextViewAverageDieselConsumption = (TextView) findViewById(R.id.powerBackupsDg_textView_averageDieselConsumption);
        mPowerBackupsDgEditTextAverageDieselConsumption = (EditText) findViewById(R.id.powerBackupsDg_editText_averageDieselConsumption);
        mPowerBackupsDgTextViewAmc = (TextView) findViewById(R.id.powerBackupsDg_textView_amc);
        mPowerBackupsDgTextViewAmcVal = (TextView) findViewById(R.id.powerBackupsDg_textView_amc_val);
        mPowerBackupsDgTextViewValidityOfAmc = (TextView) findViewById(R.id.powerBackupsDg_textView_validityOfAmc);
        mPowerBackupsDgEditTextDateOfvalidityOfAmc = (EditText) findViewById(R.id.powerBackupsDg_editText_dateOfvalidityOfAmc);
        mPowerBackupsDgTextViewDgWorkingType = (TextView) findViewById(R.id.powerBackupsDg_textView_dgWorkingType);
        mPowerBackupsDgTextViewDgWorkingTypeVal = (TextView) findViewById(R.id.powerBackupsDg_textView_dgWorkingType_val);
        mPowerBackupsDgTextViewDgHmrReading = (TextView) findViewById(R.id.powerBackupsDg_textView_dgHmrReading);
        mPowerBackupsDgEditTextDgHmrReading = (EditText) findViewById(R.id.powerBackupsDg_editText_dgHmrReading);
        mPowerBackupsDgTextViewDgEngineSerialNumber = (TextView) findViewById(R.id.powerBackupsDg_textView_dgEngineSerialNumber);
        mPowerBackupsDgEditTextDgEngineSerialNumber = (EditText) findViewById(R.id.powerBackupsDg_editText_dgEngineSerialNumber);
        mPowerBackupsDgTextViewDgMainAlternatorType = (TextView) findViewById(R.id.powerBackupsDg_textView_dgMainAlternatorType);
        mPowerBackupsDgTextViewDgMainAlternatorTypeVal = (TextView) findViewById(R.id.powerBackupsDg_textView_dgMainAlternatorType_val);
        mPowerBackupsDgTextViewDgMainAlternatorMake = (TextView) findViewById(R.id.powerBackupsDg_textView_dgMainAlternatorMake);
        mPowerBackupsDgTextViewDgMainAlternatorMakeVal = (TextView) findViewById(R.id.powerBackupsDg_textView_dgMainAlternatorMake_val);
        mPowerBackupsDgTextViewDgMainAlternatorSerialNumber = (TextView) findViewById(R.id.powerBackupsDg_textView_dgMainAlternatorSerialNumber);
        mPowerBackupsDgEditTextDgMainAlternatorSerialNumber = (EditText) findViewById(R.id.powerBackupsDg_editText_dgMainAlternatorSerialNumber);
        mPowerBackupsDgTextViewDgCanopyStatus = (TextView) findViewById(R.id.powerBackupsDg_textView_dgCanopyStatus);
        mPowerBackupsDgTextViewDgCanopyStatusVal = (TextView) findViewById(R.id.powerBackupsDg_textView_dgCanopyStatus_val);
        mPowerBackupsDgTextViewDgStartingBatteryStatus = (TextView) findViewById(R.id.powerBackupsDg_textView_dgStartingBatteryStatus);
        mPowerBackupsDgTextViewDgStartingBatteryStatusVal = (TextView) findViewById(R.id.powerBackupsDg_textView_dgStartingBatteryStatus_val);
        mPowerBackupsDgTextViewChargingAlternator = (TextView) findViewById(R.id.powerBackupsDg_textView_chargingAlternator);
        mPowerBackupsDgTextViewChargingAlternatorVal = (TextView) findViewById(R.id.powerBackupsDg_textView_chargingAlternator_val);
        mPowerBackupsDgTextViewBatteryCharger = (TextView) findViewById(R.id.powerBackupsDg_textView_batteryCharger);
        mPowerBackupsDgTextViewBatteryChargerVal = (TextView) findViewById(R.id.powerBackupsDg_textView_batteryCharger_val);
        mPowerBackupsDgTextViewPresentDieselStock = (TextView) findViewById(R.id.powerBackupsDg_textView_presentDieselStock);
        mPowerBackupsDgEditTextPresentDieselStock = (EditText) findViewById(R.id.powerBackupsDg_editText_presentDieselStock);
        mPowerBackupsDgTextViewGcuRunHrs = (TextView) findViewById(R.id.powerBackupsDg_textView_gcuRunHrs);
        mPowerBackupsDgEditTextGcuRunHrs = (EditText) findViewById(R.id.powerBackupsDg_editText_gcuRunHrs);
        mPowerBackupsDgTextViewGcuKwh = (TextView) findViewById(R.id.powerBackupsDg_textView_gcuKwh);
        mPowerBackupsDgEditTextGcuKwh = (EditText) findViewById(R.id.powerBackupsDg_editText_gcuKwh);
        mPowerBackupsDgTextViewDgAvrWorkingStatus = (TextView) findViewById(R.id.powerBackupsDg_textView_dgAvrWorkingStatus);
        mPowerBackupsDgTextViewDgAvrWorkingStatusVal = (TextView) findViewById(R.id.powerBackupsDg_textView_dgAvrWorkingStatus_val);
        mPowerBackupsDgTextViewFuelTankPosition = (TextView) findViewById(R.id.powerBackupsDg_textView_fuelTankPosition);
        mPowerBackupsDgTextViewFuelTankPositionVal = (TextView) findViewById(R.id.powerBackupsDg_textView_fuelTankPosition_val);
        mPowerBackupsDgTextViewWorkingCondition = (TextView) findViewById(R.id.powerBackupsDg_textView_workingCondition);
        mPowerBackupsDgTextViewWorkingConditionVal = (TextView) findViewById(R.id.powerBackupsDg_textView_workingCondition_val);
        mPowerBackupsDgTextViewNatureOfProblem = (TextView) findViewById(R.id.powerBackupsDg_textView_natureOfProblem);
        mPowerBackupsDgEditTextNatureOfProblem = (EditText) findViewById(R.id.powerBackupsDg_editText_natureOfProblem);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    private void initCombo() {
        mPowerBackupsDgTextViewNoOfEngineAlternatorSetsprovidedVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_noOfEngineAlternatorSetsprovided))),
                        "No.of Engine Alternator Sets provided",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfEngineAlternatorSetsprovided = item.get(position);
                        mPowerBackupsDgTextViewNoOfEngineAlternatorSetsprovidedVal.setText(str_noOfEngineAlternatorSetsprovided);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewNumberOfWorkingDgVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_numberOfWorkingDg))),
                        "Number of Working DG",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_numberOfWorkingDg = item.get(position);
                        mPowerBackupsDgTextViewNumberOfWorkingDgVal.setText(str_numberOfWorkingDg);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewAssetOwnerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_assetOwner))),
                        "Asset Owner",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_assetOwner = item.get(position);
                        mPowerBackupsDgTextViewAssetOwnerVal.setText(str_assetOwner);
                    }
                });
            }
        });


        mPowerBackupsDgTextViewManufacturerMakeModelVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_manufacturerMakeModel))),
                        "Manufacturer/Make/Model",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_manufacturerMakeModel = item.get(position);
                        mPowerBackupsDgTextViewManufacturerMakeModelVal.setText(str_manufacturerMakeModel);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewCapacityInKvaVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_capacityInKva))),
                        "Capacity in KVA",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_capacityInKva = item.get(position);
                        mPowerBackupsDgTextViewCapacityInKvaVal.setText(str_capacityInKva);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewAutoManualVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_autoManual))),
                        "Auto/Manual",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_autoManual = item.get(position);
                        mPowerBackupsDgTextViewAutoManualVal.setText(str_autoManual);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewAmcVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_amc))),
                        "AMC(Yes/No)",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_amc = item.get(position);
                        mPowerBackupsDgTextViewAmcVal.setText(str_amc);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewDgWorkingTypeVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_dgWorkingType))),
                        "DG Working Type",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_dgWorkingType = item.get(position);
                        mPowerBackupsDgTextViewDgWorkingTypeVal.setText(str_dgWorkingType);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewDgMainAlternatorTypeVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_dgMainAlternatorType))),
                        "DG Main Alternator Type",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_dgMainAlternatorType = item.get(position);
                        mPowerBackupsDgTextViewDgMainAlternatorTypeVal.setText(str_dgMainAlternatorType);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewDgMainAlternatorMakeVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_dgMainAlternatorMake))),
                        "DG Main Alternator Make",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_dgMainAlternatorMake = item.get(position);
                        mPowerBackupsDgTextViewDgMainAlternatorMakeVal.setText(str_dgMainAlternatorMake);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewDgCanopyStatusVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_dgCanopyStatus))),
                        "DG Canopy Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_DgCanopyStatus = item.get(position);
                        mPowerBackupsDgTextViewDgCanopyStatusVal.setText(str_DgCanopyStatus);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewDgStartingBatteryStatusVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_dgStartingBatteryStatus))),
                        "DG Starting Battery Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_dgStartingBatteryStatus = item.get(position);
                        mPowerBackupsDgTextViewDgStartingBatteryStatusVal.setText(str_dgStartingBatteryStatus);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewChargingAlternatorVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_chargingAlternator))),
                        "Charging Alternator",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_chargingAlternator = item.get(position);
                        mPowerBackupsDgTextViewChargingAlternatorVal.setText(str_chargingAlternator);
                    }
                });
            }
        });


        mPowerBackupsDgTextViewBatteryChargerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_batteryCharger))),
                        "Battery Charger",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_batteryCharger = item.get(position);
                        mPowerBackupsDgTextViewBatteryChargerVal.setText(str_batteryCharger);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewDgAvrWorkingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_dgAvrWorkingStatus))),
                        "DG AVR working Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_dgAvrWorkingStatus = item.get(position);
                        mPowerBackupsDgTextViewDgAvrWorkingStatusVal.setText(str_dgAvrWorkingStatus);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewFuelTankPositionVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_fuelTankPosition))),
                        "Fuel Tank Position",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_fuelTankPosition = item.get(position);
                        mPowerBackupsDgTextViewFuelTankPositionVal.setText(str_fuelTankPosition);
                    }
                });
            }
        });

        mPowerBackupsDgTextViewWorkingConditionVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Power_Backups_DG.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerBackupsDg_workingCondition))),
                        "Working Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_workingCondition = item.get(position);
                        mPowerBackupsDgTextViewWorkingConditionVal.setText(str_workingCondition);
                    }
                });
            }
        });
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

        alertDialogManager.Dialog("Permission", "App needs to access the Camera.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
            @Override
            public void onPositiveClick() {

                final EditText taskEditText = new EditText(Power_Backups_DG.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(Power_Backups_DG.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("SETTINGS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startInstalledAppDetailsActivity(Power_Backups_DG.this);
                            }
                        })
                        .setNegativeButton("DONT ALLOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create();
                dialog.show();
            }
        }).show();

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
        alertDialogManager.Dialog("Permission", "App needs to access the Camera.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
            @Override
            public void onPositiveClick() {

                final EditText taskEditText = new EditText(Power_Backups_DG.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(Power_Backups_DG.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("ALLOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(Power_Backups_DG.this,
                                        new String[]{Manifest.permission.CAMERA},
                                        MY_PERMISSIONS_REQUEST_CAMERA);
                            }
                        })
                        .setNegativeButton("DONT ALLOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                finish();
                            }
                        })
                        .create();
                dialog.show();
            }
        }).show();


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

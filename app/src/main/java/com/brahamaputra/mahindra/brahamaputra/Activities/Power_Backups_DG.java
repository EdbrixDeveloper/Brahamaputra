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
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.brahamaputra.mahindra.brahamaputra.BuildConfig;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.PowerBackupsDGData;
import com.brahamaputra.mahindra.brahamaputra.Data.PowerPlantDetailsData;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Power_Backups_DG extends BaseActivity {

    private TextView mPowerBackupsDgTextViewNoOfEngineAlternatorSetsprovided;
    private TextView mPowerBackupsDgTextViewNoOfEngineAlternatorSetsprovidedVal;
    private TextView mPowerBackupsDgTextViewNumberOfWorkingDg;
    private TextView mPowerBackupsDgTextViewNumberOfWorkingDgVal;
    private TextView mPowerBackupsDgTextViewQRCodeScan;
    private ImageView mPowerBackupsDgButtonQRCodeScan;

    private ImageView mPowerBackupsDgButtonQRCodeScanView;

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

    private static final String TAG = Power_Backups_DG.class.getSimpleName();

    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "101";
    private String ticketId = "28131";
    private String ticketName = "28131";
    private HotoTransactionData hotoTransactionData;
    private PowerBackupsDGData powerBackupsDGData;
    private String base64StringQRCodeScan = "eji39jjj";

    private SessionManager sessionManager;
    private Uri imageFileUri;
    private String imageFileName;

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
        hotoTransactionData = new HotoTransactionData();

        sessionManager = new SessionManager(Power_Backups_DG.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(Power_Backups_DG.this, userId, ticketName);
        setInputDetails();


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
                    //openCamera();
                    openCameraIntent();
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

        mPowerBackupsDgButtonQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUri != null) {
                    GlobalMethods.showImageDialog(Power_Backups_DG.this, imageFileUri);
                } else {
                    Toast.makeText(Power_Backups_DG.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
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

        mPowerBackupsDgButtonQRCodeScanView = (ImageView) findViewById(R.id.powerBackupsDg_button_QRCodeScanView);

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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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


    private void setInputDetails() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");

                Gson gson = new Gson();
                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);
                powerBackupsDGData = hotoTransactionData.getPowerBackupsDGData();

                mPowerBackupsDgTextViewNoOfEngineAlternatorSetsprovidedVal.setText(powerBackupsDGData.getNoOfEngineAlternator());
                mPowerBackupsDgTextViewNumberOfWorkingDgVal.setText(powerBackupsDGData.getNumberOfWorkingDg());
                //mPowerBackupsDgButtonQRCodeScan.setText(powerBackupsDGData.getAvailable());

                base64StringQRCodeScan = powerBackupsDGData.getqRCodeScan();
                // New added for image #ImageSet
                imageFileName = powerBackupsDGData.getQrCodeImageFileName();
                mPowerBackupsDgButtonQRCodeScanView.setVisibility(View.GONE);
                if (imageFileName != null && imageFileName.length() > 0) {
                    File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileName);
//                             imageFileUri = Uri.fromFile(file);
                    imageFileUri = FileProvider.getUriForFile(Power_Backups_DG.this, BuildConfig.APPLICATION_ID + ".provider", file);
                    if (imageFileUri != null) {
                        mPowerBackupsDgButtonQRCodeScanView.setVisibility(View.VISIBLE);
                    }
                }

                mPowerBackupsDgTextViewAssetOwnerVal.setText(powerBackupsDGData.getAssetOwner());
                mPowerBackupsDgTextViewManufacturerMakeModelVal.setText(powerBackupsDGData.getManufacturerMakeModel());
                mPowerBackupsDgTextViewCapacityInKvaVal.setText(powerBackupsDGData.getCapacityInKva());
                mPowerBackupsDgTextViewAutoManualVal.setText(powerBackupsDGData.getAutoManual());
                mPowerBackupsDgEditTextDieselTankCapacity.setText(powerBackupsDGData.getDieselTankCapacity());
                mPowerBackupsDgEditTextDateOfInstallation.setText(powerBackupsDGData.getDateOfInstallation());
                mPowerBackupsDgEditTextAverageDieselConsumption.setText(powerBackupsDGData.getAverageDieselConsumption());
                mPowerBackupsDgTextViewAmcVal.setText(powerBackupsDGData.getAmc());
                mPowerBackupsDgEditTextDateOfvalidityOfAmc.setText(powerBackupsDGData.getDateOfvalidityOfAmc());
                mPowerBackupsDgTextViewDgWorkingTypeVal.setText(powerBackupsDGData.getDgWorkingType());
                mPowerBackupsDgEditTextDgHmrReading.setText(powerBackupsDGData.getDgHmrReading());
                mPowerBackupsDgEditTextDgEngineSerialNumber.setText(powerBackupsDGData.getDgEngineSerialNo());
                mPowerBackupsDgTextViewDgMainAlternatorTypeVal.setText(powerBackupsDGData.getDgMainAltType());
                mPowerBackupsDgTextViewDgMainAlternatorMakeVal.setText(powerBackupsDGData.getDgMainAltMake());
                mPowerBackupsDgEditTextDgMainAlternatorSerialNumber.setText(powerBackupsDGData.getDgMainAltSerialNo());
                mPowerBackupsDgTextViewDgCanopyStatusVal.setText(powerBackupsDGData.getDgCanopyStatus());
                mPowerBackupsDgTextViewDgStartingBatteryStatusVal.setText(powerBackupsDGData.getDgStartingBatteryStatus());
                mPowerBackupsDgTextViewChargingAlternatorVal.setText(powerBackupsDGData.getChargingAlternator());
                mPowerBackupsDgTextViewBatteryChargerVal.setText(powerBackupsDGData.getBatteryCharger());
                mPowerBackupsDgEditTextPresentDieselStock.setText(powerBackupsDGData.getPresentDieselStock());
                mPowerBackupsDgEditTextGcuRunHrs.setText(powerBackupsDGData.getGcuRunHrs());
                mPowerBackupsDgEditTextGcuKwh.setText(powerBackupsDGData.getGcuKwh());
                mPowerBackupsDgTextViewDgAvrWorkingStatusVal.setText(powerBackupsDGData.getDgAvrWorkingStatus());
                mPowerBackupsDgTextViewFuelTankPositionVal.setText(powerBackupsDGData.getFuelTankPosition());
                mPowerBackupsDgTextViewWorkingConditionVal.setText(powerBackupsDGData.getWorkingCondition());
                mPowerBackupsDgEditTextNatureOfProblem.setText(powerBackupsDGData.getNatureOfProblem());

            } else {
                Toast.makeText(Power_Backups_DG.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void submitDetails() {
        try {
            //hotoTransactionData.setTicketNo(ticketName);


            String noOfEngineAlternator = mPowerBackupsDgTextViewNoOfEngineAlternatorSetsprovidedVal.getText().toString().trim();
            String numberOfWorkingDg = mPowerBackupsDgTextViewNumberOfWorkingDgVal.getText().toString().trim();
            String qRCodeScan = base64StringQRCodeScan;
            //private ImageView mPowerBackupsDgButtonQRCodeScan.getText().toString().trim();
            String assetOwner = mPowerBackupsDgTextViewAssetOwnerVal.getText().toString().trim();
            String manufacturerMakeModel = mPowerBackupsDgTextViewManufacturerMakeModelVal.getText().toString().trim();
            String capacityInKva = mPowerBackupsDgTextViewCapacityInKvaVal.getText().toString().trim();
            String autoManual = mPowerBackupsDgTextViewAutoManualVal.getText().toString().trim();
            String dieselTankCapacity = mPowerBackupsDgEditTextDieselTankCapacity.getText().toString().trim();
            String dateOfInstallation = mPowerBackupsDgEditTextDateOfInstallation.getText().toString().trim();
            String averageDieselConsumption = mPowerBackupsDgEditTextAverageDieselConsumption.getText().toString().trim();
            String amc = mPowerBackupsDgTextViewAmcVal.getText().toString().trim();
            String dateOfvalidityOfAmc = mPowerBackupsDgEditTextDateOfvalidityOfAmc.getText().toString().trim();
            String dgWorkingType = mPowerBackupsDgTextViewDgWorkingTypeVal.getText().toString().trim();
            String dgHmrReading = mPowerBackupsDgEditTextDgHmrReading.getText().toString().trim();
            String dgEngineSerialNo = mPowerBackupsDgEditTextDgEngineSerialNumber.getText().toString().trim();
            String dgMainAltType = mPowerBackupsDgTextViewDgMainAlternatorTypeVal.getText().toString().trim();
            String dgMainAltMake = mPowerBackupsDgTextViewDgMainAlternatorMakeVal.getText().toString().trim();
            String dgMainAltSerialNo = mPowerBackupsDgEditTextDgMainAlternatorSerialNumber.getText().toString().trim();
            String dgCanopyStatus = mPowerBackupsDgTextViewDgCanopyStatusVal.getText().toString().trim();
            String dgStartingBatteryStatus = mPowerBackupsDgTextViewDgStartingBatteryStatusVal.getText().toString().trim();
            String chargingAlternator = mPowerBackupsDgTextViewChargingAlternatorVal.getText().toString().trim();
            String batteryCharger = mPowerBackupsDgTextViewBatteryChargerVal.getText().toString().trim();
            String presentDieselStock = mPowerBackupsDgEditTextPresentDieselStock.getText().toString().trim();
            String gcuRunHrs = mPowerBackupsDgEditTextGcuRunHrs.getText().toString().trim();
            String gcuKwh = mPowerBackupsDgEditTextGcuKwh.getText().toString().trim();
            String dgAvrWorkingStatus = mPowerBackupsDgTextViewDgAvrWorkingStatusVal.getText().toString().trim();
            String fuelTankPosition = mPowerBackupsDgTextViewFuelTankPositionVal.getText().toString().trim();
            String workingCondition = mPowerBackupsDgTextViewWorkingConditionVal.getText().toString().trim();
            String natureOfProblem = mPowerBackupsDgEditTextNatureOfProblem.getText().toString().trim();

            powerBackupsDGData = new PowerBackupsDGData(noOfEngineAlternator, numberOfWorkingDg, qRCodeScan, assetOwner, manufacturerMakeModel, capacityInKva, autoManual, dieselTankCapacity, dateOfInstallation, averageDieselConsumption, amc, dateOfvalidityOfAmc, dgWorkingType, dgHmrReading, dgEngineSerialNo, dgMainAltType, dgMainAltMake, dgMainAltSerialNo, dgCanopyStatus, dgStartingBatteryStatus, chargingAlternator, batteryCharger, presentDieselStock, gcuRunHrs, gcuKwh, dgAvrWorkingStatus, fuelTankPosition, workingCondition, natureOfProblem, imageFileName);
            hotoTransactionData.setPowerBackupsDGData(powerBackupsDGData);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);
            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);

        } catch (Exception e) {
            e.printStackTrace();
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

    //////////////////////
    //Camera//

    public void openCameraIntent() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileName = "IMG_" + ticketName + "_" + sdf.format(new Date()) + ".jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileName);
//            imageFileUri = Uri.fromFile(file);

            imageFileUri = FileProvider.getUriForFile(Power_Backups_DG.this, BuildConfig.APPLICATION_ID + ".provider", file);

            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_PERMISSIONS_REQUEST_CAMERA &&
                resultCode == RESULT_OK) {
            if (imageFileUri != null) {
                try {
                    Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUri);
//                            (Bitmap) data.getExtras().get("data");
//                mImageView.setImageBitmap(imageBitmap);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    imageBitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                    byte[] bitmapDataArray = stream.toByteArray();
                    base64StringQRCodeScan = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                    mPowerBackupsDgButtonQRCodeScanView.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                imageFileName = "";
                imageFileUri = null;
                mPowerBackupsDgButtonQRCodeScanView.setVisibility(View.GONE);
            }
        }
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
                submitDetails();
                startActivity(new Intent(this, Shelter.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

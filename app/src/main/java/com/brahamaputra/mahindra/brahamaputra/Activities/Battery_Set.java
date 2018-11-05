package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import android.Manifest;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.Data.BatterySetData;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.LandDetailsData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
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

public class Battery_Set extends BaseActivity {

    private static final String TAG = Battery_Set.class.getSimpleName();
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    private Uri imageFileUri = null;
    private String imageFileName ="";

    private AlertDialogManager alertDialogManager;



    final Calendar myCalendar = Calendar.getInstance();
    String str_noofBatterySetProvided;
    String str_numberofBatteryBankWorking;
    String str_assetOwner;
    String str_manufacturerMakeModel;
    String str_capacityinAH;
    String str_typeofBattery;
    String str_positionofBatteryBank;
    String str_batteryBankCableSizeinSQMM;
    String str_batteryBankEarthingStatus;
    String str_backupCondition;


    private TextView mBatterySetTextViewNoofBatterySetProvided;
    private TextView mBatterySetTextViewNoofBatterySetProvidedVal;
    private TextView mBatterySetTextViewNumberofBatteryBankWorking;
    private TextView mBatterySetTextViewNumberofBatteryBankWorkingVal;
    private TextView mBatterySetTextViewQRCodeScan;
    private ImageView mBatterySetButtonQRCodeScan;
    private TextView mBatterySetTextViewAssetOwner;
    private TextView mBatterySetTextViewAssetOwnerVal;
    private TextView mPowerBackupsDgTextViewDividerDesign;
    private TextView mBatterySetTextViewManufacturerMakeModel;
    private TextView mBatterySetTextViewManufacturerMakeModelVal;
    private TextView mBatterySetTextViewCapacityinAH;
    private TextView mBatterySetTextViewCapacityinAHVal;
    private TextView mBatterySetTextViewTypeofBattery;
    private TextView mBatterySetTextViewTypeofBatteryVal;
    private TextView mBatterySetTextViewDateofInstallation;
    private EditText mBatterySetEditTextDateofInstallation;
    private TextView mBatterySetTextViewBackupduration;
    private EditText mBatterySetEditTextBackupduration;
    private TextView mBatterySetTextViewPositionofBatteryBank;
    private TextView mBatterySetTextViewPositionofBatteryBankVal;
    private TextView mBatterySetTextViewBatteryBankCableSizeinSQMM;
    private TextView mBatterySetTextViewBatteryBankCableSizeinSQMMVal;
    private TextView mBatterySetTextViewBatteryBankEarthingStatus;
    private TextView mBatterySetTextViewBatteryBankEarthingStatusVal;
    private TextView mBatterySetTextViewBACKUPCondition;
    private TextView mBatterySetTextViewBACKUPConditionVal;
    private TextView mBatterySetTextViewNatureofProblem;
    private EditText mBatterySetEditTextNatureofProblem;

    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";
    private HotoTransactionData hotoTransactionData;
    private BatterySetData batterySetData;
    private String base64StringBatterySet = "eji39jjj";

    private SessionManager sessionManager;

    private void assignViews() {
        mBatterySetTextViewNoofBatterySetProvided = (TextView) findViewById(R.id.batterySet_textView_NoofBatterySetProvided);
        mBatterySetTextViewNoofBatterySetProvidedVal = (TextView) findViewById(R.id.batterySet_textView_NoofBatterySetProvided_val);
        mBatterySetTextViewNumberofBatteryBankWorking = (TextView) findViewById(R.id.batterySet_textView_NumberofBatteryBankWorking);
        mBatterySetTextViewNumberofBatteryBankWorkingVal = (TextView) findViewById(R.id.batterySet_textView_NumberofBatteryBankWorking_val);
        mBatterySetTextViewQRCodeScan = (TextView) findViewById(R.id.batterySet_textView_QRCodeScan);
        mBatterySetButtonQRCodeScan = (ImageView) findViewById(R.id.batterySet_button_QRCodeScan);
        mBatterySetTextViewAssetOwner = (TextView) findViewById(R.id.batterySet_textView_assetOwner);
        mBatterySetTextViewAssetOwnerVal = (TextView) findViewById(R.id.batterySet_textView_assetOwner_val);
        mPowerBackupsDgTextViewDividerDesign = (TextView) findViewById(R.id.powerBackupsDg_textView_dividerDesign);
        mBatterySetTextViewManufacturerMakeModel = (TextView) findViewById(R.id.batterySet_textView_ManufacturerMakeModel);
        mBatterySetTextViewManufacturerMakeModelVal = (TextView) findViewById(R.id.batterySet_textView_ManufacturerMakeModel_val);
        mBatterySetTextViewCapacityinAH = (TextView) findViewById(R.id.batterySet_textView_CapacityinAH);
        mBatterySetTextViewCapacityinAHVal = (TextView) findViewById(R.id.batterySet_textView_CapacityinAH_val);
        mBatterySetTextViewTypeofBattery = (TextView) findViewById(R.id.batterySet_textView_TypeofBattery);
        mBatterySetTextViewTypeofBatteryVal = (TextView) findViewById(R.id.batterySet_textView_TypeofBattery_val);
        mBatterySetTextViewDateofInstallation = (TextView) findViewById(R.id.batterySet_textView_DateofInstallation);
        mBatterySetEditTextDateofInstallation = (EditText) findViewById(R.id.batterySet_editText_DateofInstallation);
        mBatterySetTextViewBackupduration = (TextView) findViewById(R.id.batterySet_textView_Backupduration);
        mBatterySetEditTextBackupduration = (EditText) findViewById(R.id.batterySet_editText_Backupduration);
        mBatterySetTextViewPositionofBatteryBank = (TextView) findViewById(R.id.batterySet_textView_PositionofBatteryBank);
        mBatterySetTextViewPositionofBatteryBankVal = (TextView) findViewById(R.id.batterySet_textView_PositionofBatteryBank_val);
        mBatterySetTextViewBatteryBankCableSizeinSQMM = (TextView) findViewById(R.id.batterySet_textView_BatteryBankCableSizeinSQMM);
        mBatterySetTextViewBatteryBankCableSizeinSQMMVal = (TextView) findViewById(R.id.batterySet_textView_BatteryBankCableSizeinSQMM_val);
        mBatterySetTextViewBatteryBankEarthingStatus = (TextView) findViewById(R.id.batterySet_textView_BatteryBankEarthingStatus);
        mBatterySetTextViewBatteryBankEarthingStatusVal = (TextView) findViewById(R.id.batterySet_textView_BatteryBankEarthingStatus_val);
        mBatterySetTextViewBACKUPCondition = (TextView) findViewById(R.id.batterySet_textView_BACKUPCondition);
        mBatterySetTextViewBACKUPConditionVal = (TextView) findViewById(R.id.batterySet_textView_BACKUPCondition_val);
        mBatterySetTextViewNatureofProblem = (TextView) findViewById(R.id.batterySet_textView_NatureofProblem);
        mBatterySetEditTextNatureofProblem = (EditText) findViewById(R.id.batterySet_editText_NatureofProblem);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        hotoTransactionData = new HotoTransactionData();
        setInputDetails();


    }


    private void initCombo() {

        mBatterySetTextViewNoofBatterySetProvidedVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Battery_Set.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_batterySet_NoofBatterySetProvided))),
                        "No of Battery Set Provided",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_numberofBatteryBankWorking = item.get(position);
                        mBatterySetTextViewNoofBatterySetProvidedVal.setText(str_numberofBatteryBankWorking);
                    }
                });
            }
        });
        mBatterySetTextViewNumberofBatteryBankWorkingVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Battery_Set.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_batterySet_NumberofBatteryBankWorking))),
                        "Number of Battery Bank Working",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noofBatterySetProvided = item.get(position);
                        mBatterySetTextViewNumberofBatteryBankWorkingVal.setText(str_noofBatterySetProvided);
                    }
                });
            }
        });

        mBatterySetTextViewAssetOwnerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Battery_Set.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_batterySet_AssetOwner))),
                        "Asset Owner",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_assetOwner = item.get(position);
                        mBatterySetTextViewAssetOwnerVal.setText(str_assetOwner);
                    }
                });
            }
        });
        mBatterySetTextViewManufacturerMakeModelVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Battery_Set.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_batterySet_ManufacturerMakeModel))),
                        "Manufacturer Make Model",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_manufacturerMakeModel = item.get(position);
                        mBatterySetTextViewManufacturerMakeModelVal.setText(str_manufacturerMakeModel);
                    }
                });

            }
        });


        mBatterySetTextViewCapacityinAHVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Battery_Set.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_batterySet_CapacityinAH))),
                        "Capacity in AH",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_capacityinAH = item.get(position);
                        mBatterySetTextViewCapacityinAHVal.setText(str_capacityinAH);
                    }
                });

            }
        });

        mBatterySetTextViewTypeofBatteryVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Battery_Set.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_batterySet_TypeofBattery))),
                        "Type of Battery",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeofBattery = item.get(position);
                        mBatterySetTextViewTypeofBatteryVal.setText(str_typeofBattery);
                    }
                });

            }
        });

        mBatterySetTextViewPositionofBatteryBankVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Battery_Set.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_batterySet_PositionofBatteryBank))),
                        "Position of Battery Bank",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_positionofBatteryBank = item.get(position);
                        mBatterySetTextViewPositionofBatteryBankVal.setText(str_positionofBatteryBank);
                    }
                });

            }
        });

        mBatterySetTextViewBatteryBankCableSizeinSQMMVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Battery_Set.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_batterySet_BatteryBankCableSizeinSQMM))),
                        "Battery Bank Cable Size in SQMM",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_batteryBankCableSizeinSQMM = item.get(position);
                        mBatterySetTextViewBatteryBankCableSizeinSQMMVal.setText(str_batteryBankCableSizeinSQMM);
                    }
                });

            }
        });

        mBatterySetTextViewBatteryBankEarthingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Battery_Set.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_batterySet_BatteryBankEarthingStatus))),
                        "Battery Bank Earthing Status",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_batteryBankEarthingStatus = item.get(position);
                        mBatterySetTextViewBatteryBankEarthingStatusVal.setText(str_batteryBankEarthingStatus);
                    }
                });

            }
        });

        mBatterySetTextViewBACKUPConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Battery_Set.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_batterySet_BACKUPCondition))),
                        "Backup Condition",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_backupCondition = item.get(position);
                        mBatterySetTextViewBACKUPConditionVal.setText(str_backupCondition);
                    }
                });

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_set);
        this.setTitle("Battery Set");

        sessionManager = new SessionManager(Battery_Set.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = sessionManager.getSessionUserTicketName();
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(Battery_Set.this, userId, ticketName);
        alertDialogManager = new AlertDialogManager(this);
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

        mBatterySetEditTextDateofInstallation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Battery_Set.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        mBatterySetButtonQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Battery_Set.this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (getFromPref(Battery_Set.this, ALLOW_KEY)) {

                        showSettingsAlert();

                    } else if (ContextCompat.checkSelfPermission(Battery_Set.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(Battery_Set.this,
                                Manifest.permission.CAMERA)) {
                            showAlert();
                        } else {
                            // No explanation needed, we can request the permission.
                            ActivityCompat.requestPermissions(Battery_Set.this,
                                    new String[]{Manifest.permission.CAMERA},
                                    MY_PERMISSIONS_REQUEST_CAMERA);
                        }
                    }
                } else {
                    openCameraIntent();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dropdown_details_menu, menu);
        return true;
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mBatterySetEditTextDateofInstallation.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                // startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;
            case R.id.menuDone:
                submitDetails();
                finish();
                startActivity(new Intent(this, ExternalTenantsPersonaldetails.class));
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    private void setInputDetails() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");
                // Toast.makeText(Land_Details.this,"JsonInString :"+ jsonInString,Toast.LENGTH_SHORT).show();

                Gson gson = new Gson();
//                landDetailsData = gson.fromJson(jsonInString, LandDetailsData.class);

                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);
                batterySetData = hotoTransactionData.getBatterySetData();

                mBatterySetTextViewNoofBatterySetProvidedVal.setText(batterySetData.getNoOfBatterySet());
                mBatterySetTextViewNumberofBatteryBankWorkingVal.setText(batterySetData.getNoOfBatteryBankWorking());
                base64StringBatterySet = (batterySetData.getBatterySet_Qr());
                mBatterySetTextViewAssetOwnerVal.setText(batterySetData.getAssetOwner());
                mBatterySetTextViewManufacturerMakeModelVal.setText(batterySetData.getManufactureMakeModel());
                mBatterySetTextViewCapacityinAHVal.setText(batterySetData.getCapacityInAH());
                mBatterySetTextViewTypeofBatteryVal.setText(batterySetData.getTypeOfBattery());
                mBatterySetEditTextDateofInstallation.setText(batterySetData.getDateOfInstallation());
                mBatterySetEditTextBackupduration.setText(batterySetData.getBackupDuaration());
                mBatterySetTextViewPositionofBatteryBankVal.setText(batterySetData.getPositionOfBatteryBank());
                mBatterySetTextViewBatteryBankCableSizeinSQMMVal.setText(batterySetData.getBatteryBankCableSize());
                mBatterySetTextViewBatteryBankEarthingStatusVal.setText(batterySetData.getBatteryBankEarthingStatus());
                mBatterySetTextViewBACKUPConditionVal.setText(batterySetData.getBackupCondition());
                mBatterySetEditTextNatureofProblem.setText(batterySetData.getNatureOfProblem());


            } else {
                Toast.makeText(Battery_Set.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitDetails() {
        try {
            //hotoTransactionData.setTicketNo(ticketId);

            String noOfBatterySet = mBatterySetTextViewNoofBatterySetProvidedVal.getText().toString().trim();
            String noOfBatteryBankWorking = mBatterySetTextViewNumberofBatteryBankWorkingVal.getText().toString().trim();
            String batterySet_Qr = base64StringBatterySet;
            String assetOwner = mBatterySetTextViewAssetOwnerVal.getText().toString().trim();
            String manufactureMakeModel = mBatterySetTextViewManufacturerMakeModelVal.getText().toString().trim();
            String capacityInAH = mBatterySetTextViewCapacityinAHVal.getText().toString().trim();
            String typeOfBattery = mBatterySetTextViewTypeofBatteryVal.getText().toString().trim();
            String dateOfInstallation = mBatterySetEditTextDateofInstallation.getText().toString().trim();
            String backupDuaration = mBatterySetEditTextBackupduration.getText().toString().trim();
            String positionOfBatteryBank = mBatterySetTextViewPositionofBatteryBankVal.getText().toString().trim();
            String batteryBankCableSize = mBatterySetTextViewBatteryBankCableSizeinSQMMVal.getText().toString().trim();
            String batteryBankEarthingStatus = mBatterySetTextViewBatteryBankEarthingStatusVal.getText().toString().trim();
            String backupCondition = mBatterySetTextViewBACKUPConditionVal.getText().toString().trim();
            String natureOfProblem = mBatterySetEditTextNatureofProblem.getText().toString().trim();


            batterySetData = new BatterySetData(noOfBatterySet, noOfBatteryBankWorking, batterySet_Qr, assetOwner, manufactureMakeModel,capacityInAH, typeOfBattery, dateOfInstallation, backupDuaration, positionOfBatteryBank,batteryBankCableSize, batteryBankEarthingStatus, backupCondition, natureOfProblem,imageFileName);

            hotoTransactionData.setBatterySetData(batterySetData);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);
            //Toast.makeText(Land_Details.this, "Gson to json string :" + jsonString, Toast.LENGTH_SHORT).show();

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

                final EditText taskEditText = new EditText(Battery_Set.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(Battery_Set.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("SETTINGS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startInstalledAppDetailsActivity(Battery_Set.this);
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

                final EditText taskEditText = new EditText(Battery_Set.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(Battery_Set.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("ALLOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(Battery_Set.this,
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


    public void openCameraIntent() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileName = "IMG_" + ticketName + "_" + sdf.format(new Date()) + ".jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileName);
            imageFileUri = Uri.fromFile(file);

            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA);
        }catch(Exception e){
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
                    base64StringBatterySet ="qwer";// Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                }catch (Exception e){
                    e.printStackTrace();
                }
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
                            saveToPreferences(Battery_Set.this, ALLOW_KEY, true);
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
}

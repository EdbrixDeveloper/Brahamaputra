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

public class PowerPlantDetailsActivity extends BaseActivity {

    private TextView mPowerPlantDetailsTextViewQRCodeScan;
    private ImageView mPowerPlantDetailsButtonQRCodeScan;
    private TextView mPowerPlantDetailsTextViewAssetOwner;
    private TextView mPowerPlantDetailsTextViewAssetOwnerVal;
    private TextView mPowerPlantDetailsTextViewNumberOfPowerPlant;
    private TextView mPowerPlantDetailsTextViewNumberOfPowerPlantVal;
    private TextView mPowerPlantDetailsTextViewManufacturerMakeModel;
    private TextView mPowerPlantDetailsTextViewManufacturerMakeModelVal;
    private TextView mPowerPlantDetailsTextViewPowerPlantModel;
    private EditText mPowerPlantDetailsEditTextPowerPlantModel;
    private TextView mPowerPlantDetailsTextViewNumberModuleSlots;
    private TextView mPowerPlantDetailsTextViewNumberModuleSlotsVal;
    private TextView mPowerPlantDetailsTextViewPowerPlantEarthingStatus;
    private TextView mPowerPlantDetailsTextViewPowerPlantEarthingStatusVal;
    private TextView mPowerPlantDetailsTextViewDcLoadInDisplayAmp;
    private EditText mPowerPlantDetailsEditTextDcLoadInDisplayAmp;
    private TextView mPowerPlantDetailsTextViewPowerPlantSerialNumber;
    private EditText mPowerPlantDetailsEditTextPowerPlantSerialNumber;
    private TextView mPowerPlantDetailsTextViewTypeOfPowerPlantCommercialSmps;
    private TextView mPowerPlantDetailsTextViewTypeOfPowerPlantCommercialSmpsVal;
    private TextView mPowerPlantDetailsTextViewCapacityInAmp;
    private EditText mPowerPlantDetailsEditTextCapacityInAmp;
    private TextView mPowerPlantDetailsTextViewNumberOfModules;
    private TextView mPowerPlantDetailsTextViewNumberOfModulesVal;
    private TextView mPowerPlantDetailsTextViewNoOfFaultyModulese;
    private TextView mPowerPlantDetailsTextViewNoOfFaultyModuleseVal;
    private TextView mPowerPlantDetailsTextViewSmpsExpandableUpToKW;
    private EditText mPowerPlantDetailsEditTextSmpsExpandableUpToKW;
    private TextView mPowerPlantDetailsTextViewSmpsUltimateCapacity;
    private EditText mPowerPlantDetailsEditTextSmpsUltimateCapacity;
    private TextView mPowerPlantDetailsTextViewSpdStatus;
    private TextView mPowerPlantDetailsTextViewSpdStatusVal;
    private TextView mPowerPlantDetailsTextViewWorkingCondition;
    private TextView mPowerPlantDetailsTextViewWorkingConditionVal;
    private TextView mPowerPlantDetailsTextViewNatureOfProblem;
    private EditText mPowerPlantDetailsEditTextNatureOfProblem;


    String str_assetOwner;
    String str_numberOfPowerPlant;
    String str_manufacturerMakeModel;
    String str_numberModuleSlots;
    String str_powerPlantEarthingStatus;
    String str_typeOfPowerPlantCommercialSmps;
    String str_numberOfModules;
    String str_noOfFaultyModulese;
    String str_spdStatus;
    String str_workingCondition;

    //

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";
    public String date_flag = "no";

    private AlertDialogManager alertDialogManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_plant_details);
        this.setTitle("Power Plant Details");
        alertDialogManager = new AlertDialogManager(PowerPlantDetailsActivity.this);
        assignViews();
        initCombo();
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
        mPowerPlantDetailsTextViewAssetOwnerVal = (TextView) findViewById(R.id.powerPlantDetails_textView_assetOwner_val);
        mPowerPlantDetailsTextViewNumberOfPowerPlant = (TextView) findViewById(R.id.powerPlantDetails_textView_numberOfPowerPlant);
        mPowerPlantDetailsTextViewNumberOfPowerPlantVal = (TextView) findViewById(R.id.powerPlantDetails_textView_numberOfPowerPlant_val);
        mPowerPlantDetailsTextViewManufacturerMakeModel = (TextView) findViewById(R.id.powerPlantDetails_textView_manufacturerMakeModel);
        mPowerPlantDetailsTextViewManufacturerMakeModelVal = (TextView) findViewById(R.id.powerPlantDetails_textView_manufacturerMakeModel_val);
        mPowerPlantDetailsTextViewPowerPlantModel = (TextView) findViewById(R.id.powerPlantDetails_textView_powerPlantModel);
        mPowerPlantDetailsEditTextPowerPlantModel = (EditText) findViewById(R.id.powerPlantDetails_editText_powerPlantModel);
        mPowerPlantDetailsTextViewNumberModuleSlots = (TextView) findViewById(R.id.powerPlantDetails_textView_numberModuleSlots);
        mPowerPlantDetailsTextViewNumberModuleSlotsVal = (TextView) findViewById(R.id.powerPlantDetails_textView_numberModuleSlots_val);
        mPowerPlantDetailsTextViewPowerPlantEarthingStatus = (TextView) findViewById(R.id.powerPlantDetails_textView_powerPlantEarthingStatus);
        mPowerPlantDetailsTextViewPowerPlantEarthingStatusVal = (TextView) findViewById(R.id.powerPlantDetails_textView_powerPlantEarthingStatus_val);
        mPowerPlantDetailsTextViewDcLoadInDisplayAmp = (TextView) findViewById(R.id.powerPlantDetails_textView_dcLoadInDisplayAmp);
        mPowerPlantDetailsEditTextDcLoadInDisplayAmp = (EditText) findViewById(R.id.powerPlantDetails_editText_dcLoadInDisplayAmp);
        mPowerPlantDetailsTextViewPowerPlantSerialNumber = (TextView) findViewById(R.id.powerPlantDetails_textView_powerPlantSerialNumber);
        mPowerPlantDetailsEditTextPowerPlantSerialNumber = (EditText) findViewById(R.id.powerPlantDetails_editText_powerPlantSerialNumber);
        mPowerPlantDetailsTextViewTypeOfPowerPlantCommercialSmps = (TextView) findViewById(R.id.powerPlantDetails_textView_typeOfPowerPlantCommercialSmps);
        mPowerPlantDetailsTextViewTypeOfPowerPlantCommercialSmpsVal = (TextView) findViewById(R.id.powerPlantDetails_textView_typeOfPowerPlantCommercialSmps_val);
        mPowerPlantDetailsTextViewCapacityInAmp = (TextView) findViewById(R.id.powerPlantDetails_textView_capacityInAmp);
        mPowerPlantDetailsEditTextCapacityInAmp = (EditText) findViewById(R.id.powerPlantDetails_editText_capacityInAmp);
        mPowerPlantDetailsTextViewNumberOfModules = (TextView) findViewById(R.id.powerPlantDetails_textView_numberOfModules);
        mPowerPlantDetailsTextViewNumberOfModulesVal = (TextView) findViewById(R.id.powerPlantDetails_textView_numberOfModules_val);
        mPowerPlantDetailsTextViewNoOfFaultyModulese = (TextView) findViewById(R.id.powerPlantDetails_textView_noOfFaultyModulese);
        mPowerPlantDetailsTextViewNoOfFaultyModuleseVal = (TextView) findViewById(R.id.powerPlantDetails_textView_noOfFaultyModulese_val);
        mPowerPlantDetailsTextViewSmpsExpandableUpToKW = (TextView) findViewById(R.id.powerPlantDetails_textView_smpsExpandableUpToKW);
        mPowerPlantDetailsEditTextSmpsExpandableUpToKW = (EditText) findViewById(R.id.powerPlantDetails_editText_smpsExpandableUpToKW);
        mPowerPlantDetailsTextViewSmpsUltimateCapacity = (TextView) findViewById(R.id.powerPlantDetails_textView_smpsUltimateCapacity);
        mPowerPlantDetailsEditTextSmpsUltimateCapacity = (EditText) findViewById(R.id.powerPlantDetails_editText_smpsUltimateCapacity);
        mPowerPlantDetailsTextViewSpdStatus = (TextView) findViewById(R.id.powerPlantDetails_textView_spdStatus);
        mPowerPlantDetailsTextViewSpdStatusVal = (TextView) findViewById(R.id.powerPlantDetails_textView_spdStatus_val);
        mPowerPlantDetailsTextViewWorkingCondition = (TextView) findViewById(R.id.powerPlantDetails_textView_workingCondition);
        mPowerPlantDetailsTextViewWorkingConditionVal = (TextView) findViewById(R.id.powerPlantDetails_textView_workingCondition_val);
        mPowerPlantDetailsTextViewNatureOfProblem = (TextView) findViewById(R.id.powerPlantDetails_textView_natureOfProblem);
        mPowerPlantDetailsEditTextNatureOfProblem = (EditText) findViewById(R.id.powerPlantDetails_editText_natureOfProblem);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    private void initCombo() {
        mPowerPlantDetailsTextViewAssetOwnerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerPlantDetailsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerPlantDetails_assetOwner))),
                        "Asset Owner",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_assetOwner = item.get(position);
                        mPowerPlantDetailsTextViewAssetOwnerVal.setText(str_assetOwner);
                    }
                });
            }
        });

        mPowerPlantDetailsTextViewNumberOfPowerPlantVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerPlantDetailsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerPlantDetails_numberOfPowerPlant))),
                        "Number of Power Plant",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_numberOfPowerPlant = item.get(position);
                        mPowerPlantDetailsTextViewNumberOfPowerPlantVal.setText(str_numberOfPowerPlant);
                    }
                });
            }
        });

        mPowerPlantDetailsTextViewManufacturerMakeModelVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerPlantDetailsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerPlantDetails_manufacturerMakeModel))),
                        "Manufacturer/Make",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_manufacturerMakeModel = item.get(position);
                        mPowerPlantDetailsTextViewManufacturerMakeModelVal.setText(str_manufacturerMakeModel);
                    }
                });
            }
        });

        mPowerPlantDetailsTextViewNumberModuleSlotsVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerPlantDetailsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerPlantDetails_numberModuleSlots))),
                        "Number Module Slots",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_numberModuleSlots = item.get(position);
                        mPowerPlantDetailsTextViewNumberModuleSlotsVal.setText(str_numberModuleSlots);
                    }
                });
            }
        });

        mPowerPlantDetailsTextViewPowerPlantEarthingStatusVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerPlantDetailsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerPlantDetails_powerPlantEarthingStatus))),
                        "Power Plant Earthing Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_powerPlantEarthingStatus = item.get(position);
                        mPowerPlantDetailsTextViewPowerPlantEarthingStatusVal.setText(str_powerPlantEarthingStatus);
                    }
                });
            }
        });

        mPowerPlantDetailsTextViewTypeOfPowerPlantCommercialSmpsVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerPlantDetailsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerPlantDetails_typeOfPowerPlantCommercialSmps))),
                        "Type of the Power Plant [Commercial/SMPs]",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeOfPowerPlantCommercialSmps = item.get(position);
                        mPowerPlantDetailsTextViewTypeOfPowerPlantCommercialSmpsVal.setText(str_typeOfPowerPlantCommercialSmps);
                    }
                });
            }
        });

        mPowerPlantDetailsTextViewNumberOfModulesVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerPlantDetailsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerPlantDetails_numberOfModules))),
                        "Number of Modules",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_numberOfModules = item.get(position);
                        mPowerPlantDetailsTextViewNumberOfModulesVal.setText(str_numberOfModules);
                    }
                });
            }
        });

        mPowerPlantDetailsTextViewNoOfFaultyModuleseVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerPlantDetailsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerPlantDetails_noOfFaultyModules))),
                        "No. of Faulty Modules",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfFaultyModulese = item.get(position);
                        mPowerPlantDetailsTextViewNoOfFaultyModuleseVal.setText(str_noOfFaultyModulese);
                    }
                });
            }
        });

        mPowerPlantDetailsTextViewSpdStatusVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerPlantDetailsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerPlantDetails_spdStatus))),
                        "SPD Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_spdStatus = item.get(position);
                        mPowerPlantDetailsTextViewSpdStatusVal.setText(str_spdStatus);
                    }
                });
            }
        });

        mPowerPlantDetailsTextViewWorkingConditionVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerPlantDetailsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerPlantDetails_workingCondition))),
                        "Working Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_workingCondition = item.get(position);
                        mPowerPlantDetailsTextViewWorkingConditionVal.setText(str_workingCondition);
                    }
                });
            }
        });
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

                final EditText taskEditText = new EditText(PowerPlantDetailsActivity.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(PowerPlantDetailsActivity.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("SETTINGS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startInstalledAppDetailsActivity(PowerPlantDetailsActivity.this);
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

                final EditText taskEditText = new EditText(PowerPlantDetailsActivity.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(PowerPlantDetailsActivity.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("ALLOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(PowerPlantDetailsActivity.this,
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

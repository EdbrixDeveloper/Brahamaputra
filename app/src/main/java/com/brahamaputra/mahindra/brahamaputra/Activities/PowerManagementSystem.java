package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import android.Manifest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class PowerManagementSystem extends BaseActivity {


    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    String str_assetOwner;
    String str_powerManagementSystemType;
    String str_powerManagementSystemMake;
    String str_powerManagementSystemPosition;
    String str_powerManagementSystemStaus;
    String str_workingCondition;

    private AlertDialogManager alertDialogManager;

    private TextView mPowerManagementSystemTextViewQRCodeScan;
    private ImageView mPowerManagementSystemButtonQRCodeScan;
    private TextView mPowerManagementSystemTextViewAssetOwner;
    private TextView mPowerManagementSystemTextViewAssetOwnerVal;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemType;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemTypeVal;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemMake;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemMakeVal;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemPosition;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemPositionVal;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemStaus;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemStausVal;
    private TextView mPowerManagementSystemTextViewPowerManagementSystemSerialNumber;
    private EditText mPowerManagementSystemEditTextPowerManagementSystemSerialNumber;
    private TextView mPowerManagementSystemTextViewWorkingCondition;
    private TextView mPowerManagementSystemTextViewWorkingConditionVal;
    private TextView mPowerManagementSystemTextViewNatureofProblem;
    private EditText mPowerManagementSystemEditTextNatureofProblem;

    private void assignViews() {
        mPowerManagementSystemTextViewQRCodeScan = (TextView) findViewById(R.id.powerManagementSystem_textView_QRCodeScan);
        mPowerManagementSystemButtonQRCodeScan = (ImageView) findViewById(R.id.powerManagementSystem_button_QRCodeScan);
        mPowerManagementSystemTextViewAssetOwner = (TextView) findViewById(R.id.powerManagementSystem_textView_AssetOwner);
        mPowerManagementSystemTextViewAssetOwnerVal = (TextView) findViewById(R.id.powerManagementSystem_textView_AssetOwner_val);
        mPowerManagementSystemTextViewPowerManagementSystemType = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemType);
        mPowerManagementSystemTextViewPowerManagementSystemTypeVal = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemType_val);
        mPowerManagementSystemTextViewPowerManagementSystemMake = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemMake);
        mPowerManagementSystemTextViewPowerManagementSystemMakeVal = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemMake_val);
        mPowerManagementSystemTextViewPowerManagementSystemPosition = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemPosition);
        mPowerManagementSystemTextViewPowerManagementSystemPositionVal = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemPosition_val);
        mPowerManagementSystemTextViewPowerManagementSystemStaus = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemStaus);
        mPowerManagementSystemTextViewPowerManagementSystemStausVal = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemStaus_val);
        mPowerManagementSystemTextViewPowerManagementSystemSerialNumber = (TextView) findViewById(R.id.powerManagementSystem_textView_PowerManagementSystemSerialNumber);
        mPowerManagementSystemEditTextPowerManagementSystemSerialNumber = (EditText) findViewById(R.id.powerManagementSystem_editText_PowerManagementSystemSerialNumber);
        mPowerManagementSystemTextViewWorkingCondition = (TextView) findViewById(R.id.powerManagementSystem_textView_WorkingCondition);
        mPowerManagementSystemTextViewWorkingConditionVal = (TextView) findViewById(R.id.powerManagementSystem_textView_WorkingCondition_val);
        mPowerManagementSystemTextViewNatureofProblem = (TextView) findViewById(R.id.powerManagementSystem_textView_NatureofProblem);
        mPowerManagementSystemEditTextNatureofProblem = (EditText) findViewById(R.id.powerManagementSystem_editText_NatureofProblem);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );


    }

    private void initCombo()
    {
        mPowerManagementSystemTextViewAssetOwnerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerManagementSystem.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerManagementSystem_AssetOwner))),
                        "Asset Owner",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_assetOwner = item.get(position);
                        mPowerManagementSystemTextViewAssetOwnerVal.setText(str_assetOwner);
                    }
                });

            }
        });
        mPowerManagementSystemTextViewPowerManagementSystemTypeVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerManagementSystem.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerManagementSystem_PowerManagementSystemType))),
                        "Power Management System Type",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_powerManagementSystemType = item.get(position);
                        mPowerManagementSystemTextViewPowerManagementSystemTypeVal.setText(str_powerManagementSystemType);
                    }
                });

            }
        });
        mPowerManagementSystemTextViewPowerManagementSystemMakeVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerManagementSystem.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerManagementSystem_PowerManagementSystemMake))),
                        "Power Management System Make",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_powerManagementSystemMake = item.get(position);
                        mPowerManagementSystemTextViewPowerManagementSystemMakeVal.setText(str_powerManagementSystemMake);
                    }
                });

            }
        });

        mPowerManagementSystemTextViewPowerManagementSystemPositionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerManagementSystem.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerManagementSystem_PowerManagementSystemPosition))),
                        "Power Management System Position",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_powerManagementSystemPosition = item.get(position);
                        mPowerManagementSystemTextViewPowerManagementSystemPositionVal.setText(str_powerManagementSystemPosition);
                    }
                });

            }
        });
        mPowerManagementSystemTextViewPowerManagementSystemStausVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerManagementSystem.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerManagementSystem_PowerManagementSystemStaus))),
                        "Power Management System Staus",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_powerManagementSystemStaus = item.get(position);
                        mPowerManagementSystemTextViewPowerManagementSystemStausVal.setText(str_powerManagementSystemStaus);
                    }
                });

            }
        });
        mPowerManagementSystemTextViewWorkingConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PowerManagementSystem.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_powerManagementSystem_WorkingCondition))),
                        "Working Condition",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_workingCondition = item.get(position);
                        mPowerManagementSystemTextViewWorkingConditionVal.setText(str_workingCondition);
                    }
                });

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_management_system);
        this.setTitle("Power Management System");
        assignViews();
        initCombo();
                alertDialogManager = new AlertDialogManager(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPowerManagementSystemButtonQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(PowerManagementSystem.this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (getFromPref(PowerManagementSystem.this, ALLOW_KEY)) {

                        showSettingsAlert();

                    } else if (ContextCompat.checkSelfPermission(PowerManagementSystem.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(PowerManagementSystem.this,
                                Manifest.permission.CAMERA)) {
                            showAlert();
                        } else {
                            // No explanation needed, we can request the permission.
                            ActivityCompat.requestPermissions(PowerManagementSystem.this,
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
                // startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;
            case R.id.menuDone:
                finish();
                startActivity(new Intent(this, GeneralAndSafetyMeasures.class));
                return true;


        }
        return super.onOptionsItemSelected(item);
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

                final EditText taskEditText = new EditText(PowerManagementSystem.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(PowerManagementSystem.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("SETTINGS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startInstalledAppDetailsActivity(PowerManagementSystem.this);
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

                final EditText taskEditText = new EditText(PowerManagementSystem.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(PowerManagementSystem.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("ALLOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(PowerManagementSystem.this,
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
                            saveToPreferences(PowerManagementSystem.this, ALLOW_KEY, true);
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

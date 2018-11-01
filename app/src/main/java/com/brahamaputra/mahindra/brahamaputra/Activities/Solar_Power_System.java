package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
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

import com.brahamaputra.mahindra.brahamaputra.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class Solar_Power_System extends BaseActivity {

    private TextView mSolarPowerSystemTextViewQRCodeScan;
    private ImageView mSolarPowerSystemButtonQRCodeScan;
    private TextView mSolarPowerSystemTextViewAvailable;
    private TextView mSolarPowerSystemTextViewAvailableVal;
    private TextView mSolarPowerSystemTextViewAssetOwner;
    private TextView mSolarPowerSystemTextViewAssetOwnerVal;
    private TextView mSolarPowerSystemTextViewManufacturerMakeModel;
    private EditText mSolarPowerSystemEditTextManufacturerMakeModel;
    private TextView mSolarPowerSystemTextViewCellPanel;
    private TextView mSolarPowerSystemTextViewCellPanelVal;
    private TextView mSolarPowerSystemTextViewCapacityKW;
    private EditText mSolarPowerSystemEditTextCapacityKW;
    private TextView mSolarPowerSystemTextViewAmcYesNo;
    private TextView mSolarPowerSystemTextViewAmcYesNoVal;
    private TextView mSolarPowerSystemTextViewValidityOfAmc;
    private EditText mSolarPowerSystemEditTextDateOfvalidityOfAmc;

    String str_available;
    String str_assetOwner;
    String str_cellPanel;
    String str_amcYesNoVal;


    final Calendar myCalendar = Calendar.getInstance();

    /////////////////////////
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    private AlertDialogManager alertDialogManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_power_system);

        this.setTitle("Solar Power System");
        alertDialogManager = new AlertDialogManager(Solar_Power_System.this);
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

        mSolarPowerSystemButtonQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Solar_Power_System.this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (getFromPref(Solar_Power_System.this, ALLOW_KEY)) {

                        showSettingsAlert();

                    } else if (ContextCompat.checkSelfPermission(Solar_Power_System.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(Solar_Power_System.this,
                                Manifest.permission.CAMERA)) {
                            showAlert();
                        } else {
                            // No explanation needed, we can request the permission.
                            ActivityCompat.requestPermissions(Solar_Power_System.this,
                                    new String[]{Manifest.permission.CAMERA},
                                    MY_PERMISSIONS_REQUEST_CAMERA);
                        }
                    }
                } else {
                    openCamera();
                }

            }
        });


        mSolarPowerSystemEditTextDateOfvalidityOfAmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Solar_Power_System.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void assignViews() {
        mSolarPowerSystemTextViewQRCodeScan = (TextView) findViewById(R.id.solarPowerSystem_textView_QRCodeScan);
        mSolarPowerSystemButtonQRCodeScan = (ImageView) findViewById(R.id.solarPowerSystem_button_QRCodeScan);
        mSolarPowerSystemTextViewAvailable = (TextView) findViewById(R.id.solarPowerSystem_textView_available);
        mSolarPowerSystemTextViewAvailableVal = (TextView) findViewById(R.id.solarPowerSystem_textView_available_val);
        mSolarPowerSystemTextViewAssetOwner = (TextView) findViewById(R.id.solarPowerSystem_textView_assetOwner);
        mSolarPowerSystemTextViewAssetOwnerVal = (TextView) findViewById(R.id.solarPowerSystem_textView_assetOwner_val);
        mSolarPowerSystemTextViewManufacturerMakeModel = (TextView) findViewById(R.id.solarPowerSystem_textView_manufacturerMakeModel);
        mSolarPowerSystemEditTextManufacturerMakeModel = (EditText) findViewById(R.id.solarPowerSystem_editText_manufacturerMakeModel);
        mSolarPowerSystemTextViewCellPanel = (TextView) findViewById(R.id.solarPowerSystem_textView_cellPanel);
        mSolarPowerSystemTextViewCellPanelVal = (TextView) findViewById(R.id.solarPowerSystem_textView_cellPanel_val);
        mSolarPowerSystemTextViewCapacityKW = (TextView) findViewById(R.id.solarPowerSystem_textView_capacityKW);
        mSolarPowerSystemEditTextCapacityKW = (EditText) findViewById(R.id.solarPowerSystem_editText_capacityKW);
        mSolarPowerSystemTextViewAmcYesNo = (TextView) findViewById(R.id.solarPowerSystem_textView_amcYesNo);
        mSolarPowerSystemTextViewAmcYesNoVal = (TextView) findViewById(R.id.solarPowerSystem_textView_amcYesNo_val);
        mSolarPowerSystemTextViewValidityOfAmc = (TextView) findViewById(R.id.solarPowerSystem_textView_validityOfAmc);
        mSolarPowerSystemEditTextDateOfvalidityOfAmc = (EditText) findViewById(R.id.solarPowerSystem_editText_dateOfvalidityOfAmc);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    private void initCombo() {
        mSolarPowerSystemTextViewAvailableVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Solar_Power_System.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_solarPowerSystem_available))),
                        "Available",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_available = item.get(position);
                        mSolarPowerSystemTextViewAvailableVal.setText(str_available);
                    }
                });
            }
        });

        mSolarPowerSystemTextViewAssetOwnerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Solar_Power_System.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_solarPowerSystem_assetOwner))),
                        "Asset Owner",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_assetOwner = item.get(position);
                        mSolarPowerSystemTextViewAssetOwnerVal.setText(str_assetOwner);
                    }
                });
            }
        });

        mSolarPowerSystemTextViewCellPanelVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Solar_Power_System.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_solarPowerSystem_cellPanel))),
                        "Cell / Panel",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_cellPanel = item.get(position);
                        mSolarPowerSystemTextViewCellPanelVal.setText(str_cellPanel);
                    }
                });
            }
        });


        mSolarPowerSystemTextViewAmcYesNoVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Solar_Power_System.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_solarPowerSystem_amc))),
                        "AMC (Yes / No)",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_amcYesNoVal = item.get(position);
                        mSolarPowerSystemTextViewAmcYesNoVal.setText(str_amcYesNoVal);
                    }
                });
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mSolarPowerSystemEditTextDateOfvalidityOfAmc.setText(sdf.format(myCalendar.getTime()));
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
                startActivity(new Intent(this, PowerPlantDetailsActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //////////////////////
    //Camera//

    public static Boolean getFromPref(Context context, String key) {
        SharedPreferences myPrefs = context.getSharedPreferences
                (CAMERA_PREF, Context.MODE_PRIVATE);
        return (myPrefs.getBoolean(key, false));
    }

    private void showSettingsAlert() {

        alertDialogManager.Dialog("Permission", "App needs to access the Camera.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
            @Override
            public void onPositiveClick() {

                final EditText taskEditText = new EditText(Solar_Power_System.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(Solar_Power_System.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("SETTINGS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startInstalledAppDetailsActivity(Solar_Power_System.this);
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

                final EditText taskEditText = new EditText(Solar_Power_System.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(Solar_Power_System.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("ALLOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(Solar_Power_System.this,
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
                            saveToPreferences(Solar_Power_System.this, ALLOW_KEY, true);
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

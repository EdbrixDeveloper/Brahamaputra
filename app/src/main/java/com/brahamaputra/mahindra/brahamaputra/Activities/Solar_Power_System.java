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
import android.widget.Spinner;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Solar_Power_System extends AppCompatActivity {

    private TextView mSolarPowerSystemTextViewQRCodeScan;
    private ImageView mSolarPowerSystemEditTextQRCodeScan;
    private TextView mSolarPowerSystemTextViewAvailable;
    private Spinner mSolarPowerSystemSpinnerAvailable;
    private TextView mSolarPowerSystemTextViewAssetOwner;
    private Spinner mSolarPowerSystemSpinnerAssetOwner;
    private TextView mSolarPowerSystemTextViewManufacturerMakeModel;
    private EditText mSolarPowerSystemEditTextManufacturerMakeModel;
    private TextView mSolarPowerSystemTextViewCellPanel;
    private Spinner mSolarPowerSystemSpinnerCellPanel;
    private TextView mSolarPowerSystemTextViewCapacityKW;
    private EditText mSolarPowerSystemEditTextCapacityKW;
    private TextView mSolarPowerSystemTextViewAmcYesNo;
    private Spinner mSolarPowerSystemSpinnerAmcYesNo;
    private TextView mSolarPowerSystemTextViewValidityOfAmc;
    private EditText mSolarPowerSystemEditTextDateOfvalidityOfAmc;


    final Calendar myCalendar = Calendar.getInstance();

    /////////////////////////
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_power_system);

        this.setTitle("Solar Power System");
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

        mSolarPowerSystemEditTextQRCodeScan.setOnClickListener(new View.OnClickListener() {
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
        mSolarPowerSystemEditTextQRCodeScan = (ImageView) findViewById(R.id.solarPowerSystem_button_QRCodeScan);
        mSolarPowerSystemTextViewAvailable = (TextView) findViewById(R.id.solarPowerSystem_textView_available);
        mSolarPowerSystemSpinnerAvailable = (Spinner) findViewById(R.id.solarPowerSystem_Spinner_available);
        mSolarPowerSystemTextViewAssetOwner = (TextView) findViewById(R.id.solarPowerSystem_textView_assetOwner);
        mSolarPowerSystemSpinnerAssetOwner = (Spinner) findViewById(R.id.solarPowerSystem_Spinner_assetOwner);
        mSolarPowerSystemTextViewManufacturerMakeModel = (TextView) findViewById(R.id.solarPowerSystem_textView_manufacturerMakeModel);
        mSolarPowerSystemEditTextManufacturerMakeModel = (EditText) findViewById(R.id.solarPowerSystem_editText_manufacturerMakeModel);
        mSolarPowerSystemTextViewCellPanel = (TextView) findViewById(R.id.solarPowerSystem_textView_cellPanel);
        mSolarPowerSystemSpinnerCellPanel = (Spinner) findViewById(R.id.solarPowerSystem_Spinner_cellPanel);
        mSolarPowerSystemTextViewCapacityKW = (TextView) findViewById(R.id.solarPowerSystem_textView_capacityKW);
        mSolarPowerSystemEditTextCapacityKW = (EditText) findViewById(R.id.solarPowerSystem_editText_capacityKW);
        mSolarPowerSystemTextViewAmcYesNo = (TextView) findViewById(R.id.solarPowerSystem_textView_amcYesNo);
        mSolarPowerSystemSpinnerAmcYesNo = (Spinner) findViewById(R.id.solarPowerSystem_Spinner_amcYesNo);
        mSolarPowerSystemTextViewValidityOfAmc = (TextView) findViewById(R.id.solarPowerSystem_textView_validityOfAmc);
        mSolarPowerSystemEditTextDateOfvalidityOfAmc = (EditText) findViewById(R.id.solarPowerSystem_editText_dateOfvalidityOfAmc);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
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
                startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;

            case R.id.menuSubmit:
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
                        startInstalledAppDetailsActivity(Solar_Power_System.this);

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
                        ActivityCompat.requestPermissions(Solar_Power_System.this,
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

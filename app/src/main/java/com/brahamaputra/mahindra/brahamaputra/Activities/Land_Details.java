package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.app.Activity;
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
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import android.view.View;

import android.widget.DatePicker;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Land_Details extends AppCompatActivity {

    private TextView mLandDetailsTextViewTypeOfLand;
    private SearchableSpinner mLandDetailsSpinnerTypeOfLand;
    private TextView mLandDetailsTextViewAreaOfLand;
    private EditText mLandDetailsEditTextAreaOfLand;
    private TextView mLandDetailsTextViewRentLeaseInNumber;
    private EditText mLandDetailsEditTextRentLeaseInNumber;
    private TextView mLandDetailsTextViewRentLeaseInWords;
    private EditText mLandDetailsEditTextRentLeaseInWords;
    private TextView mLandDetailsTextViewNameOfOwner;
    private EditText mLandDetailsEditTextNameOfOwner;
    private TextView mLandDetailsTextViewMobileNoOfOwner;
    private EditText mLandDetailsEditTextMobileNoOfOwner;
    private TextView mLandDetailsTextViewLayoutOfLand;
    private ImageView mLandDetailsButtonLayoutOfLand;
    private TextView mLandDetailsTextViewCopyAgreementWithOwner;
    private SearchableSpinner mLandDetailsSpinnerCopyAgreementWithOwner;
    private TextView mLandDetailsTextViewValidityOfAgreement;
    private EditText mLandDetailsEditTextDateOfvalidityOfAgreement;

    private void assignViews() {
        mLandDetailsTextViewTypeOfLand = (TextView) findViewById(R.id.landDetails_textView_typeOfLand);
        mLandDetailsSpinnerTypeOfLand = (SearchableSpinner) findViewById(R.id.landDetails_Spinner_typeOfLand);
        mLandDetailsTextViewAreaOfLand = (TextView) findViewById(R.id.landDetails_textView_areaOfLand);
        mLandDetailsEditTextAreaOfLand = (EditText) findViewById(R.id.landDetails_editText_areaOfLand);
        mLandDetailsTextViewRentLeaseInNumber = (TextView) findViewById(R.id.landDetails_textView_rentLeaseInNumber);
        mLandDetailsEditTextRentLeaseInNumber = (EditText) findViewById(R.id.landDetails_editText_rentLeaseInNumber);
        mLandDetailsTextViewRentLeaseInWords = (TextView) findViewById(R.id.landDetails_textView_rentLeaseInWords);
        mLandDetailsEditTextRentLeaseInWords = (EditText) findViewById(R.id.landDetails_editText_rentLeaseInWords);
        mLandDetailsTextViewNameOfOwner = (TextView) findViewById(R.id.landDetails_textView_nameOfOwner);
        mLandDetailsEditTextNameOfOwner = (EditText) findViewById(R.id.landDetails_editText_nameOfOwner);
        mLandDetailsTextViewMobileNoOfOwner = (TextView) findViewById(R.id.landDetails_textView_mobileNoOfOwner);
        mLandDetailsEditTextMobileNoOfOwner = (EditText) findViewById(R.id.landDetails_editText_mobileNoOfOwner);
        mLandDetailsTextViewLayoutOfLand = (TextView) findViewById(R.id.landDetails_textView_layoutOfLand);
        mLandDetailsButtonLayoutOfLand = (ImageView) findViewById(R.id.landDetails_button_layoutOfLand);
        mLandDetailsTextViewCopyAgreementWithOwner = (TextView) findViewById(R.id.landDetails_textView_copyAgreementWithOwner);
        mLandDetailsSpinnerCopyAgreementWithOwner = (SearchableSpinner) findViewById(R.id.landDetails_Spinner_copyAgreementWithOwner);
        mLandDetailsTextViewValidityOfAgreement = (TextView) findViewById(R.id.landDetails_textView_validityOfAgreement);
        mLandDetailsEditTextDateOfvalidityOfAgreement = (EditText) findViewById(R.id.landDetails_editText_dateOfvalidityOfAgreement);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        mLandDetailsSpinnerTypeOfLand.setTitle("Type of Land");
        mLandDetailsSpinnerCopyAgreementWithOwner.setTitle("Copy of the agreement with the landlord/owner");

    }


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
        setContentView(R.layout.activity_land_details);
        this.setTitle("Land Detail");
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

        mLandDetailsEditTextDateOfvalidityOfAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Land_Details.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        mLandDetailsButtonLayoutOfLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Land_Details.this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (getFromPref(Land_Details.this, ALLOW_KEY)) {

                        showSettingsAlert();

                    } else if (ContextCompat.checkSelfPermission(Land_Details.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(Land_Details.this,
                                Manifest.permission.CAMERA)) {
                            showAlert();
                        } else {
                            // No explanation needed, we can request the permission.
                            ActivityCompat.requestPermissions(Land_Details.this,
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

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mLandDetailsEditTextDateOfvalidityOfAgreement.setText(sdf.format(myCalendar.getTime()));
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
                return true;

            case R.id.menuSubmit:
                this.finish();
                startActivity(new Intent(this, Tower_Detail.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


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

                final EditText taskEditText = new EditText(Land_Details.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(Land_Details.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("SETTINGS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startInstalledAppDetailsActivity(Land_Details.this);
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

                final EditText taskEditText = new EditText(Land_Details.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(Land_Details.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("ALLOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(Land_Details.this,
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
                            saveToPreferences(Land_Details.this, ALLOW_KEY, true);
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



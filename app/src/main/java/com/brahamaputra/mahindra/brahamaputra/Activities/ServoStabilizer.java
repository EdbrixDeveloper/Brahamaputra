package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.Activity;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import android.Manifest;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.LandDetailsData;
import com.brahamaputra.mahindra.brahamaputra.Data.ServoStabilizerData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class ServoStabilizer extends BaseActivity {


    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "101";
    private String ticketId = "28131";
    private String ticketName = "28131";
    private HotoTransactionData hotoTransactionData;
    private ServoStabilizerData servoStabilizerData;
    private String base64StringLayoutOfLand = "eji39jjj";
    private SessionManager sessionManager;

    private TextView mBatterySetTextViewQRCodeScan;
    private ImageView mBatterySetButtonQRCodeScan;
    private TextView mServoStabilizerTextViewServoStabilizerWorkingStatus;
    private TextView mServoStabilizerTextViewServoStabilizerWorkingStatusVal;
    private TextView mServoStabilizerTextViewMakeofServo;
    private TextView mServoStabilizerTextViewMakeofServoVal;
    private TextView mServoStabilizerTextViewRatingofServo;
    private TextView mServoStabilizerTextViewRatingofServoVal;
    private TextView mServoStabilizerTextViewWorkingCondition;
    private TextView mServoStabilizerTextViewWorkingConditionVal;
    private TextView mServoStabilizerTextViewNatureofProblem;
    private EditText mServoStabilizerEditTextNatureofProblem;


  /*  mBatterySetButtonQRCodeScan;
    mServoStabilizerTextViewServoStabilizerWorkingStatusVal;
    mServoStabilizerTextViewMakeofServoVal;
    mServoStabilizerTextViewRatingofServoVal;
    mServoStabilizerTextViewWorkingConditionVal;
    mServoStabilizerEditTextNatureofProblem;*/

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    private AlertDialogManager alertDialogManager;

    String str_ServoStabilizerWorkingStatus;
    String str_makeofServo;
    String str_ratingofServo;
    String str_workingCondition;

    private void assignViews() {
        mBatterySetTextViewQRCodeScan = (TextView) findViewById(R.id.batterySet_textView_QRCodeScan);
        mBatterySetButtonQRCodeScan = (ImageView) findViewById(R.id.batterySet_button_QRCodeScan);
        mServoStabilizerTextViewServoStabilizerWorkingStatus = (TextView) findViewById(R.id.ServoStabilizer_textView_ServoStabilizerWorkingStatus);
        mServoStabilizerTextViewServoStabilizerWorkingStatusVal = (TextView) findViewById(R.id.ServoStabilizer_textView_ServoStabilizerWorkingStatus_val);
        mServoStabilizerTextViewMakeofServo = (TextView) findViewById(R.id.ServoStabilizer_textView_MakeofServo);
        mServoStabilizerTextViewMakeofServoVal = (TextView) findViewById(R.id.ServoStabilizer_textView_MakeofServo_val);
        mServoStabilizerTextViewRatingofServo = (TextView) findViewById(R.id.ServoStabilizer_textView_RatingofServo);
        mServoStabilizerTextViewRatingofServoVal = (TextView) findViewById(R.id.ServoStabilizer_textView_RatingofServo_val);
        mServoStabilizerTextViewWorkingCondition = (TextView) findViewById(R.id.ServoStabilizer_textView_WorkingCondition);
        mServoStabilizerTextViewWorkingConditionVal = (TextView) findViewById(R.id.ServoStabilizer_textView_WorkingCondition_val);
        mServoStabilizerTextViewNatureofProblem = (TextView) findViewById(R.id.ServoStabilizer_textView_NatureofProblem);
        mServoStabilizerEditTextNatureofProblem = (EditText) findViewById(R.id.ServoStabilizer_editText_NatureofProblem);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );


    }

    private void initCombo() {


        mServoStabilizerTextViewServoStabilizerWorkingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(ServoStabilizer.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_ServoStabilizer_ServoStabilizerWorkingStatus))),
                        "Servo Stabilizer Working Status",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ServoStabilizerWorkingStatus = item.get(position);
                        mServoStabilizerTextViewServoStabilizerWorkingStatusVal.setText(str_ServoStabilizerWorkingStatus);
                    }
                });

            }
        });
        mServoStabilizerTextViewMakeofServoVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(ServoStabilizer.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_ServoStabilizer_MakeofServo))),
                        "Make of Servo",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_makeofServo = item.get(position);
                        mServoStabilizerTextViewMakeofServoVal.setText(str_makeofServo);
                    }
                });

            }
        });
        mServoStabilizerTextViewRatingofServoVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(ServoStabilizer.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_ServoStabilizer_RatingofServo))),
                        "Rating of Servo",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_ratingofServo = item.get(position);
                        mServoStabilizerTextViewRatingofServoVal.setText(str_ratingofServo);
                    }
                });

            }
        });
        mServoStabilizerTextViewWorkingConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(ServoStabilizer.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_ServoStabilizer_WorkingCondition))),
                        "Working Condition",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_workingCondition = item.get(position);
                        mServoStabilizerTextViewWorkingConditionVal.setText(str_workingCondition);
                    }
                });

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servo_stabilizer);
        this.setTitle("SERVO STABILIZER");
        sessionManager = new SessionManager(ServoStabilizer.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = sessionManager.getSessionUserTicketId();
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(ServoStabilizer.this, userId, ticketId);
        assignViews();
        initCombo();
        alertDialogManager = new AlertDialogManager(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        hotoTransactionData = new HotoTransactionData();
        setInputDetails();


        mBatterySetButtonQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ServoStabilizer.this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (getFromPref(ServoStabilizer.this, ALLOW_KEY)) {

                        showSettingsAlert();

                    } else if (ContextCompat.checkSelfPermission(ServoStabilizer.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(ServoStabilizer.this,
                                Manifest.permission.CAMERA)) {
                            showAlert();
                        } else {
                            // No explanation needed, we can request the permission.
                            ActivityCompat.requestPermissions(ServoStabilizer.this,
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
                return true;
            case R.id.menuDone:
                submitDetails();
                finish();
                startActivity(new Intent(this, DetailsOfUnusedMaterials.class));
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    private void setInputDetails() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketId + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketId + ".txt");

                Gson gson = new Gson();

                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);
                servoStabilizerData = hotoTransactionData.getServoStabilizerData();

                base64StringLayoutOfLand = servoStabilizerData.getServoStabilizer_Qr();
                mServoStabilizerTextViewServoStabilizerWorkingStatusVal.setText(servoStabilizerData.getServoStabilizerWorkingStatus());
                mServoStabilizerTextViewMakeofServoVal.setText(servoStabilizerData.getMakeofServo());
                mServoStabilizerTextViewRatingofServoVal.setText(servoStabilizerData.getRatingofServo());
                mServoStabilizerTextViewWorkingConditionVal.setText(servoStabilizerData.getWorkingCondition());
                mServoStabilizerEditTextNatureofProblem.setText(servoStabilizerData.getNatureofProblem());

            } else {
                Toast.makeText(ServoStabilizer.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitDetails() {
        try {
            hotoTransactionData.setTicketNo(ticketId);

            String servoStabilizer_Qr = base64StringLayoutOfLand;
            String servoStabilizerWorkingStatus = mServoStabilizerTextViewServoStabilizerWorkingStatusVal.getText().toString().trim();
            String makeofServo = mServoStabilizerTextViewMakeofServoVal.getText().toString().trim();
            String ratingofServo = mServoStabilizerTextViewRatingofServoVal.getText().toString().trim();
            String workingCondition = mServoStabilizerTextViewWorkingConditionVal.getText().toString().trim();
            String natureofProblem = mServoStabilizerEditTextNatureofProblem.getText().toString().trim();


            servoStabilizerData = new ServoStabilizerData(servoStabilizer_Qr, servoStabilizerWorkingStatus, makeofServo, ratingofServo, workingCondition, natureofProblem);
            hotoTransactionData.setServoStabilizerData(servoStabilizerData);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);
            //Toast.makeText(Land_Details.this, "Gson to json string :" + jsonString, Toast.LENGTH_SHORT).show();

            offlineStorageWrapper.saveObjectToFile(ticketId + ".txt", jsonString);
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

                final EditText taskEditText = new EditText(ServoStabilizer.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(ServoStabilizer.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("SETTINGS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startInstalledAppDetailsActivity(ServoStabilizer.this);
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

                final EditText taskEditText = new EditText(ServoStabilizer.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(ServoStabilizer.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("ALLOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(ServoStabilizer.this,
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
                            saveToPreferences(ServoStabilizer.this, ALLOW_KEY, true);
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

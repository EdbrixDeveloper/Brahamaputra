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
import android.support.v4.content.FileProvider;
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
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.BuildConfig;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.LandDetailsData;
import com.brahamaputra.mahindra.brahamaputra.Data.PowerManagementSystemData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.Manifest;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PowerManagementSystem extends BaseActivity {

    private static final String TAG = PowerManagementSystem.class.getSimpleName();
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    private Uri imageFileUri = null;
    private String imageFileName ="";

    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";
    private HotoTransactionData hotoTransactionData;
    private PowerManagementSystemData powerManagementSystemData;
    private String base64StringPowerManagementSystem = "eji39jjj";
    private SessionManager sessionManager;

    String str_assetOwner;
    String str_powerManagementSystemType;
    String str_powerManagementSystemMake;
    String str_powerManagementSystemPosition;
    String str_powerManagementSystemStaus;
    String str_workingCondition;

    private AlertDialogManager alertDialogManager;

    private TextView mPowerManagementSystemTextViewQRCodeScan;
    private ImageView mPowerManagementSystemButtonQRCodeScan;
    private ImageView mPowerManagementSystemButtonQRCodeScanView;
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
        mPowerManagementSystemButtonQRCodeScanView = (ImageView) findViewById(R.id.powerManagementSystem_button_QRCodeScanView);
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

    private void initCombo() {
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

        mPowerManagementSystemButtonQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUri != null) {
                    GlobalMethods.showImageDialog(PowerManagementSystem.this, imageFileUri);
                } else {
                    Toast.makeText(PowerManagementSystem.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_management_system);
        this.setTitle("Power Management System");
        sessionManager = new SessionManager(PowerManagementSystem.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PowerManagementSystem.this, userId, ticketName);
        assignViews();
        initCombo();
        alertDialogManager = new AlertDialogManager(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hotoTransactionData = new HotoTransactionData();
        setInputDetails();

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
                startActivity(new Intent(this, GeneralAndSafetyMeasures.class));
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    private void setInputDetails() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");

                Gson gson = new Gson();

                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);
                powerManagementSystemData = hotoTransactionData.getPowerManagementSystemData();

                base64StringPowerManagementSystem = powerManagementSystemData.getPowerManagementSystemQR();
                mPowerManagementSystemTextViewAssetOwnerVal.setText(powerManagementSystemData.getAssetOwner());
                mPowerManagementSystemTextViewPowerManagementSystemTypeVal.setText(powerManagementSystemData.getPowerManagementSystemType());
                mPowerManagementSystemTextViewPowerManagementSystemMakeVal.setText(powerManagementSystemData.getPowerManagementSystemMake());
                mPowerManagementSystemTextViewPowerManagementSystemPositionVal.setText(powerManagementSystemData.getPowerManagementSystemPosition());
                mPowerManagementSystemTextViewPowerManagementSystemStausVal.setText(powerManagementSystemData.getPowerManagementSystemStaus());
                mPowerManagementSystemEditTextPowerManagementSystemSerialNumber.setText(powerManagementSystemData.getSerialNumber());
                mPowerManagementSystemTextViewWorkingConditionVal.setText(powerManagementSystemData.getWorkingCondition());
                mPowerManagementSystemEditTextNatureofProblem.setText(powerManagementSystemData.getNatureofProblem());

                // New added for image #ImageSet
                imageFileName = powerManagementSystemData.getQrCodeImageFileName();
                File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileName);
                imageFileUri = FileProvider.getUriForFile(PowerManagementSystem.this, BuildConfig.APPLICATION_ID + ".provider", file);

                // New added for image #ImageSet
                mPowerManagementSystemButtonQRCodeScanView.setVisibility(View.GONE);
                if (imageFileUri != null) {
                    mPowerManagementSystemButtonQRCodeScanView.setVisibility(View.VISIBLE);
                }

            } else {
                Toast.makeText(PowerManagementSystem.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitDetails() {
        try {
            //hotoTransactionData.setTicketNo(ticketId);

            String powerManagementSystemQR= base64StringPowerManagementSystem;
            String assetOwner= mPowerManagementSystemTextViewAssetOwnerVal.getText().toString().trim();
            String powerManagementSystemType= mPowerManagementSystemTextViewPowerManagementSystemTypeVal .getText().toString().trim();
            String powerManagementSystemMake= mPowerManagementSystemTextViewPowerManagementSystemMakeVal.getText().toString().trim();
            String powerManagementSystemPosition= mPowerManagementSystemTextViewPowerManagementSystemPositionVal.getText().toString().trim();
            String powerManagementSystemStaus= mPowerManagementSystemTextViewPowerManagementSystemStausVal.getText().toString().trim();
            String serialNumber= mPowerManagementSystemEditTextPowerManagementSystemSerialNumber.getText().toString().trim();
            String workingCondition= mPowerManagementSystemTextViewWorkingConditionVal.getText().toString().trim();
            String natureofProblem= mPowerManagementSystemEditTextNatureofProblem.getText().toString().trim();

            powerManagementSystemData = new PowerManagementSystemData(powerManagementSystemQR,assetOwner, powerManagementSystemType, powerManagementSystemMake, powerManagementSystemPosition, powerManagementSystemStaus, serialNumber, workingCondition, natureofProblem,imageFileName);

            hotoTransactionData.setPowerManagementSystemData(powerManagementSystemData);

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

    public void openCameraIntent() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileName = "IMG_" + ticketName + "_" + sdf.format(new Date()) + ".jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileName);
            //imageFileUri = Uri.fromFile(file);
            imageFileUri = FileProvider.getUriForFile(PowerManagementSystem.this, BuildConfig.APPLICATION_ID + ".provider", file);

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
                    base64StringPowerManagementSystem = "qwer";//Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                    mPowerManagementSystemButtonQRCodeScanView.setVisibility(View.VISIBLE);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } else {
            imageFileName = "";
            imageFileUri = null;
            mPowerManagementSystemButtonQRCodeScanView.setVisibility(View.GONE);
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

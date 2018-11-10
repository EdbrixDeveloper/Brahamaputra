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
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.BuildConfig;
import com.brahamaputra.mahindra.brahamaputra.Data.AirConditionersData;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.LandDetailsData;
import com.brahamaputra.mahindra.brahamaputra.Data.ShelterData;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Air_Conditioners extends BaseActivity {

    private TextView mAirConditionersTextViewNoOfAirConditionersACprovided;
    private TextView mAirConditionersTextViewNoOfAirConditionersACprovidedVal;
    private TextView mAirConditionersTextViewNumberOfACInWorkingCondition;
    private TextView mAirConditionersTextViewNumberOfACInWorkingConditionVal;
    private TextView mAirConditionersTextViewQRCodeScan;
    private ImageView mAirConditionersButtonQRCodeScan;

    private ImageView mAirConditionersButtonQRCodeScanView;

    private TextView mAirConditionersTextViewAssetOwner;
    private TextView mAirConditionersTextViewAssetOwnerVal;
    private TextView mAirConditionersTextViewTypeOfAcSpliWindow;
    private TextView mAirConditionersTextViewTypeOfAcSpliWindowVal;
    private TextView mAirConditionersTextViewManufacturerMakeModel;
    private EditText mAirConditionersEditTextManufacturerMakeModel;
    private TextView mAirConditionersTextViewAcSerialNumber;
    private EditText mAirConditionersEditTextAcSerialNumber;
    private TextView mAirConditionersTextViewCapacityTr;
    private EditText mAirConditionersEditTextCapacityTr;
    private TextView mAirConditionersTextViewDateOfInstallation;
    private EditText mAirConditionersEditTextDateOfInstallation;
    private TextView mAirConditionersTextViewAmcYesNo;
    private TextView mAirConditionersTextViewAmcYesNoVal;
    private TextView mAirConditionersTextViewAlidityOfAmc;
    private EditText mAirConditionersEditTextDateOfvalidityOfAmc;
    private TextView mAirConditionersTextViewWorkingCondition;
    private TextView mAirConditionersTextViewWorkingConditionVal;
    private TextView mAirConditionersTextViewNatureOfProblem;
    private EditText mAirConditionersEditTextNatureOfProblem;


    String str_noOfAirConditionersACprovided;
    String str_numberOfACInWorkingCondition;
    String str_sssetOwner;
    String str_typeOfAcSpliWindow;
    String str_amcYesNo;
    String str_workingCondition;

    private static final String TAG = Air_Conditioners.class.getSimpleName();

    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "101";
    private String ticketId = "28131";
    private String ticketName = "28131";
    private HotoTransactionData hotoTransactionData;
    private AirConditionersData airConditionersData;
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
        setContentView(R.layout.activity_air_conditioners);

        this.setTitle("Air Conditioners");
        alertDialogManager = new AlertDialogManager(Air_Conditioners.this);

        assignViews();
        initCombo();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        hotoTransactionData = new HotoTransactionData();

        sessionManager = new SessionManager(Air_Conditioners.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(Air_Conditioners.this, userId, ticketName);

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

        mAirConditionersButtonQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Air_Conditioners.this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (getFromPref(Air_Conditioners.this, ALLOW_KEY)) {

                        showSettingsAlert();

                    } else if (ContextCompat.checkSelfPermission(Air_Conditioners.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(Air_Conditioners.this,
                                Manifest.permission.CAMERA)) {
                            showAlert();
                        } else {
                            // No explanation needed, we can request the permission.
                            ActivityCompat.requestPermissions(Air_Conditioners.this,
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


        mAirConditionersEditTextDateOfInstallation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_flag = "install";
                new DatePickerDialog(Air_Conditioners.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        mAirConditionersEditTextDateOfvalidityOfAmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_flag = "valid";
                new DatePickerDialog(Air_Conditioners.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        mAirConditionersButtonQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUri != null) {
                    GlobalMethods.showImageDialog(Air_Conditioners.this, imageFileUri);
                } else {
                    Toast.makeText(Air_Conditioners.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    private void assignViews() {
        mAirConditionersTextViewNoOfAirConditionersACprovided = (TextView) findViewById(R.id.airConditioners_textView_noOfAirConditionersACprovided);
        mAirConditionersTextViewNoOfAirConditionersACprovidedVal = (TextView) findViewById(R.id.airConditioners_textView_noOfAirConditionersACprovided_val);
        mAirConditionersTextViewNumberOfACInWorkingCondition = (TextView) findViewById(R.id.airConditioners_textView_numberOfACInWorkingCondition);
        mAirConditionersTextViewNumberOfACInWorkingConditionVal = (TextView) findViewById(R.id.airConditioners_textView_numberOfACInWorkingCondition_val);
        mAirConditionersTextViewQRCodeScan = (TextView) findViewById(R.id.airConditioners_textView_QRCodeScan);
        mAirConditionersButtonQRCodeScan = (ImageView) findViewById(R.id.airConditioners_button_QRCodeScan);

        mAirConditionersButtonQRCodeScanView = (ImageView) findViewById(R.id.airConditioners_button_QRCodeScanView);

        mAirConditionersTextViewAssetOwner = (TextView) findViewById(R.id.airConditioners_textView_assetOwner);
        mAirConditionersTextViewAssetOwnerVal = (TextView) findViewById(R.id.airConditioners_textView_assetOwner_val);
        mAirConditionersTextViewTypeOfAcSpliWindow = (TextView) findViewById(R.id.airConditioners_textView_typeOfAcSpliWindow);
        mAirConditionersTextViewTypeOfAcSpliWindowVal = (TextView) findViewById(R.id.airConditioners_textView_typeOfAcSpliWindow_val);
        mAirConditionersTextViewManufacturerMakeModel = (TextView) findViewById(R.id.airConditioners_textView_manufacturerMakeModel);
        mAirConditionersEditTextManufacturerMakeModel = (EditText) findViewById(R.id.airConditioners_editText_manufacturerMakeModel);
        mAirConditionersTextViewAcSerialNumber = (TextView) findViewById(R.id.airConditioners_textView_acSerialNumber);
        mAirConditionersEditTextAcSerialNumber = (EditText) findViewById(R.id.airConditioners_editText_acSerialNumber);
        mAirConditionersTextViewCapacityTr = (TextView) findViewById(R.id.airConditioners_textView_capacityTr);
        mAirConditionersEditTextCapacityTr = (EditText) findViewById(R.id.airConditioners_editText_capacityTr);
        mAirConditionersTextViewDateOfInstallation = (TextView) findViewById(R.id.airConditioners_textView_dateOfInstallation);
        mAirConditionersEditTextDateOfInstallation = (EditText) findViewById(R.id.airConditioners_editText_dateOfInstallation);
        mAirConditionersTextViewAmcYesNo = (TextView) findViewById(R.id.airConditioners_textView_amcYesNo);
        mAirConditionersTextViewAmcYesNoVal = (TextView) findViewById(R.id.airConditioners_textView_amcYesNo_val);
        mAirConditionersTextViewAlidityOfAmc = (TextView) findViewById(R.id.airConditioners_textView_alidityOfAmc);
        mAirConditionersEditTextDateOfvalidityOfAmc = (EditText) findViewById(R.id.airConditioners_editText_dateOfvalidityOfAmc);
        mAirConditionersTextViewWorkingCondition = (TextView) findViewById(R.id.airConditioners_textView_workingCondition);
        mAirConditionersTextViewWorkingConditionVal = (TextView) findViewById(R.id.airConditioners_textView_workingCondition_val);
        mAirConditionersTextViewNatureOfProblem = (TextView) findViewById(R.id.airConditioners_textView_natureOfProblem);
        mAirConditionersEditTextNatureOfProblem = (EditText) findViewById(R.id.airConditioners_editText_natureOfProblem);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    private void initCombo() {
        mAirConditionersTextViewNoOfAirConditionersACprovidedVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Air_Conditioners.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_airConditioners_noOfAirConditionersACprovided))),
                        "No.of Air Conditioners (AC) provided",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfAirConditionersACprovided = item.get(position);
                        mAirConditionersTextViewNoOfAirConditionersACprovidedVal.setText(str_noOfAirConditionersACprovided);
                    }
                });
            }
        });

        mAirConditionersTextViewNumberOfACInWorkingConditionVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Air_Conditioners.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_airConditioners_numberofACInWorkingCondition))),
                        "Number of AC in Working Condition",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_numberOfACInWorkingCondition = item.get(position);
                        mAirConditionersTextViewNumberOfACInWorkingConditionVal.setText(str_numberOfACInWorkingCondition);
                    }
                });
            }
        });

        mAirConditionersTextViewAssetOwnerVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Air_Conditioners.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_airConditioners_assetOwner))),
                        "Asset Owner",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_sssetOwner = item.get(position);
                        mAirConditionersTextViewAssetOwnerVal.setText(str_sssetOwner);
                    }
                });
            }
        });

        mAirConditionersTextViewTypeOfAcSpliWindowVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Air_Conditioners.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_airConditioners_typeOfAcSpliWindow))),
                        "Type of AC (Split/Window)",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_typeOfAcSpliWindow = item.get(position);
                        mAirConditionersTextViewTypeOfAcSpliWindowVal.setText(str_typeOfAcSpliWindow);
                    }
                });
            }
        });

        mAirConditionersTextViewAmcYesNoVal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Air_Conditioners.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_airConditioners_amc))),
                        "AMC (Yes / No)",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_amcYesNo = item.get(position);
                        mAirConditionersTextViewAmcYesNoVal.setText(str_amcYesNo);
                    }
                });
            }
        });


        mAirConditionersTextViewWorkingConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Air_Conditioners.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_airConditioners_workingCondition))),
                        "Working Condition",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_workingCondition = item.get(position);
                        mAirConditionersTextViewWorkingConditionVal.setText(str_workingCondition);
                    }
                });
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        if (date_flag.equals("install")) {
            mAirConditionersEditTextDateOfInstallation.setText(sdf.format(myCalendar.getTime()));
        } else if (date_flag.equals("valid")) {
            mAirConditionersEditTextDateOfvalidityOfAmc.setText(sdf.format(myCalendar.getTime()));
        } else {

        }
    }

    private void setInputDetails() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");

                Gson gson = new Gson();

                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);
                airConditionersData = hotoTransactionData.getAirConditionersData();


                mAirConditionersTextViewNoOfAirConditionersACprovidedVal.setText(airConditionersData.getNoOfACprovided());
                mAirConditionersTextViewNumberOfACInWorkingConditionVal.setText(airConditionersData.getNumberOfACInWorkingCondition());
                //mAirConditionersButtonQRCodeScan;
                base64StringQRCodeScan = airConditionersData.getqRCodeScan();

                // New added for image #ImageSet
                imageFileName = airConditionersData.getQrCodeImageFileName();
                File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileName);
                imageFileUri = FileProvider.getUriForFile(Air_Conditioners.this, BuildConfig.APPLICATION_ID + ".provider", file);

                // New added for image #ImageSet
                mAirConditionersButtonQRCodeScanView.setVisibility(View.GONE);
                if (imageFileUri != null) {
                    mAirConditionersButtonQRCodeScanView.setVisibility(View.VISIBLE);
                }


                mAirConditionersTextViewAssetOwnerVal.setText(airConditionersData.getAssetOwner());
                mAirConditionersTextViewTypeOfAcSpliWindowVal.setText(airConditionersData.getTypeOfAcSplitWindow());
                mAirConditionersEditTextManufacturerMakeModel.setText(airConditionersData.getManufacturerMakeModel());
                mAirConditionersEditTextAcSerialNumber.setText(airConditionersData.getAcSerialNumber());
                mAirConditionersEditTextCapacityTr.setText(airConditionersData.getCapacityTr());
                mAirConditionersEditTextDateOfInstallation.setText(airConditionersData.getDateOfInstallation());
                mAirConditionersTextViewAmcYesNoVal.setText(airConditionersData.getAmcYesNo());
                mAirConditionersEditTextDateOfvalidityOfAmc.setText(airConditionersData.getDateOfvalidityOfAmc());
                mAirConditionersTextViewWorkingConditionVal.setText(airConditionersData.getWorkingCondition());
                mAirConditionersEditTextNatureOfProblem.setText(airConditionersData.getNatureOfProblem());

            } else {
                Toast.makeText(Air_Conditioners.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void submitDetails() {
        try {
            //hotoTransactionData.setTicketNo(ticketName);

            String noOfACprovided = mAirConditionersTextViewNoOfAirConditionersACprovidedVal.getText().toString().trim();
            String numberOfACInWorkingCondition = mAirConditionersTextViewNumberOfACInWorkingConditionVal.getText().toString().trim();
            String qRCodeScan = base64StringQRCodeScan;//mAirConditionersButtonQRCodeScan.getText().toString().trim();
            String assetOwner = mAirConditionersTextViewAssetOwnerVal.getText().toString().trim();
            String typeOfAcSplitWindow = mAirConditionersTextViewTypeOfAcSpliWindowVal.getText().toString().trim();
            String manufacturerMakeModel = mAirConditionersEditTextManufacturerMakeModel.getText().toString().trim();
            String acSerialNumber = mAirConditionersEditTextAcSerialNumber.getText().toString().trim();
            String capacityTr = mAirConditionersEditTextCapacityTr.getText().toString().trim();
            String dateOfInstallation = mAirConditionersEditTextDateOfInstallation.getText().toString().trim();
            String amcYesNo = mAirConditionersTextViewAmcYesNoVal.getText().toString().trim();
            String dateOfvalidityOfAmc = mAirConditionersEditTextDateOfvalidityOfAmc.getText().toString().trim();
            String workingCondition = mAirConditionersTextViewWorkingConditionVal.getText().toString().trim();
            String natureOfProblem = mAirConditionersEditTextNatureOfProblem.getText().toString().trim();


            airConditionersData = new AirConditionersData(noOfACprovided, numberOfACInWorkingCondition, qRCodeScan, assetOwner, typeOfAcSplitWindow, manufacturerMakeModel, acSerialNumber, capacityTr, dateOfInstallation, amcYesNo, dateOfvalidityOfAmc, workingCondition, natureOfProblem, imageFileName);

            hotoTransactionData.setAirConditionersData(airConditionersData);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);

            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
                //  startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;
            case R.id.menuSubmit:
                submitDetails();
                startActivity(new Intent(this, Solar_Power_System.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //////////////////////
    //Camera//

    public void openCameraIntent() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileName = "IMG_" + ticketName + "_" + sdf.format(new Date()) + ".jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileName);
            //imageFileUri = Uri.fromFile(file);

            imageFileUri = FileProvider.getUriForFile(Air_Conditioners.this, BuildConfig.APPLICATION_ID + ".provider", file);

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
                    base64StringQRCodeScan = "qwer";//Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                    mAirConditionersButtonQRCodeScanView.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                imageFileName = "";
                imageFileUri = null;
                mAirConditionersButtonQRCodeScanView.setVisibility(View.GONE);
            }
        }
    }

    private void openCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
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

                final EditText taskEditText = new EditText(Air_Conditioners.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(Air_Conditioners.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("SETTINGS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startInstalledAppDetailsActivity(Air_Conditioners.this);
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

                final EditText taskEditText = new EditText(Air_Conditioners.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(Air_Conditioners.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("ALLOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(Air_Conditioners.this,
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
                            saveToPreferences(Air_Conditioners.this, ALLOW_KEY, true);
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

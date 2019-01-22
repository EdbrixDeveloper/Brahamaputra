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
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.os.Bundle;
import android.text.InputFilter;
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
import com.brahamaputra.mahindra.brahamaputra.Data.SolarPowerSystemData;
import com.brahamaputra.mahindra.brahamaputra.Utils.DecimalConversion;
import com.brahamaputra.mahindra.brahamaputra.Utils.DecimalDigitsInputFilter;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Solar_Power_System extends BaseActivity {

    private TextView mSolarPowerSystemTextViewQRCodeScan;
    private ImageView mSolarPowerSystemButtonQRCodeScan;

    private ImageView mSolarPowerSystemButtonQRCodeScanView;

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
    private EditText mSolarPowerSystemEditTextBookValue;
    private TextView mSolarPowerSystemTextViewAmcYesNo;
    private TextView mSolarPowerSystemTextViewAmcYesNoVal;
    private TextView mSolarPowerSystemTextViewValidityOfAmc;
    private EditText mSolarPowerSystemEditTextDateOfvalidityOfAmc;
    private ImageView button_ClearQRCodeScanView;
    private TextView mSolarPowerSystemTextViewBatterySupplierSameAsSolarSupplier;

    LinearLayout mSolarPowerSystemLinearLayoutQRCodeScan;
    LinearLayout mSolarPowerSystemLinearLayoutAssetOwner;
    LinearLayout mSolarPowerSystemLinearLayoutManufacturerMakeModel;
    LinearLayout mSolarPowerSystemLinearLayoutCellPanel;
    LinearLayout mSolarPowerSystemLinearLayoutCapacityKW;
    LinearLayout mSolarPowerSystemLinearLayoutAmcYesNo;
    LinearLayout mSolarPowerSystemLinearLayoutValidityOfAmc;
    LinearLayout mSolarPowerSystemLinearLayoutBatterySupplierSameAsSolarSupplier;
    LinearLayout mSolarPowerSystemLinearLayoutBatterySupplierBookValue;


    String str_available;
    String str_supplier_same_as_Solar_Supplier;
    String str_assetOwner;
    String str_cellPanel;
    String str_amcYesNoVal;

    private static final String TAG = Solar_Power_System.class.getSimpleName();
    DecimalConversion decimalConversion;
    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "101";
    private String ticketId = "28131";
    private String ticketName = "28131";
    private HotoTransactionData hotoTransactionData;
    private SolarPowerSystemData solarPowerSystemData;
    private String base64StringQRCodeScan = "";
    private SessionManager sessionManager;
    private Uri imageFileUri;
    private String imageFileName = "";



    final Calendar myCalendar = Calendar.getInstance();

    ///////////////////////////////
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    private AlertDialogManager alertDialogManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_power_system);

        this.setTitle("Solar Power System");
        decimalConversion = new DecimalConversion();
        alertDialogManager = new AlertDialogManager(Solar_Power_System.this);
        assignViews();
        initCombo();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        hotoTransactionData = new HotoTransactionData();

        sessionManager = new SessionManager(Solar_Power_System.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(Solar_Power_System.this, userId, ticketName);

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
                    //openCamera();
                    //openCameraIntent();This Commented By 008 on 14-11-2018 For QR Code Purpose
                    onClicked(v);
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

        mSolarPowerSystemEditTextCapacityKW.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    DecimalFormatConversion();
                }
            }
        });
        button_ClearQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                base64StringQRCodeScan = "";
                button_ClearQRCodeScanView.setVisibility(View.GONE);
                mSolarPowerSystemButtonQRCodeScanView.setVisibility(View.GONE);
                showToast("Cleared");
            }
        });


        /*This Commented By 008 on 14-11-2018 For QR Code Purpose
        mSolarPowerSystemButtonQRCodeScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUri != null) {
                    GlobalMethods.showImageDialog(Solar_Power_System.this, imageFileUri);
                } else {
                    Toast.makeText(Solar_Power_System.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });*/
    }

    public void onClicked(View v) {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("Scan a QRcode");
        integrator.setOrientationLocked(true);
        integrator.initiateScan();

//        Use this for more customization
//        IntentIntegrator integrator = new IntentIntegrator(this);
//        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
//        integrator.setPrompt("Scan a barcode");
//        integrator.setCameraId(0);  // Use a specific camera of the device
//        integrator.setBeepEnabled(false);
//        integrator.setBarcodeImageEnabled(true);
//        integrator.initiateScan();

    }

    private void assignViews() {
        mSolarPowerSystemTextViewQRCodeScan = (TextView) findViewById(R.id.solarPowerSystem_textView_QRCodeScan);
        mSolarPowerSystemButtonQRCodeScan = (ImageView) findViewById(R.id.solarPowerSystem_button_QRCodeScan);

        mSolarPowerSystemButtonQRCodeScanView = (ImageView) findViewById(R.id.solarPowerSystem_button_QRCodeScanView);

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
        mSolarPowerSystemEditTextBookValue = (EditText) findViewById(R.id.solarPowerSystem_editText_bookValue);
        mSolarPowerSystemTextViewAmcYesNo = (TextView) findViewById(R.id.solarPowerSystem_textView_amcYesNo);
        mSolarPowerSystemTextViewAmcYesNoVal = (TextView) findViewById(R.id.solarPowerSystem_textView_amcYesNo_val);
        mSolarPowerSystemTextViewValidityOfAmc = (TextView) findViewById(R.id.solarPowerSystem_textView_validityOfAmc);
        mSolarPowerSystemEditTextDateOfvalidityOfAmc = (EditText) findViewById(R.id.solarPowerSystem_editText_dateOfvalidityOfAmc);

        mSolarPowerSystemLinearLayoutQRCodeScan = (LinearLayout) findViewById(R.id.solarPowerSystem_linearLayout_QRCodeScan);
        mSolarPowerSystemLinearLayoutAssetOwner = (LinearLayout) findViewById(R.id.solarPowerSystem_linearLayout_assetOwner);
        mSolarPowerSystemLinearLayoutManufacturerMakeModel = (LinearLayout) findViewById(R.id.solarPowerSystem_linearLayout_manufacturerMakeModel);
        mSolarPowerSystemLinearLayoutCellPanel = (LinearLayout) findViewById(R.id.solarPowerSystem_linearLayout_cellPanel);
        mSolarPowerSystemLinearLayoutCapacityKW = (LinearLayout) findViewById(R.id.solarPowerSystem_linearLayout_capacityKW);
        mSolarPowerSystemLinearLayoutAmcYesNo = (LinearLayout) findViewById(R.id.solarPowerSystem_linearLayout_amcYesNo);
        mSolarPowerSystemLinearLayoutValidityOfAmc = (LinearLayout) findViewById(R.id.solarPowerSystem_linearLayout_validityOfAmc);
        button_ClearQRCodeScanView = (ImageView) findViewById(R.id.button_ClearQRCodeScanView);

        mSolarPowerSystemTextViewBatterySupplierSameAsSolarSupplier = (TextView)findViewById(R.id.solarPowerSystem_textView_batterySupplierSameAsSolarSupplier_val);
        mSolarPowerSystemLinearLayoutBatterySupplierSameAsSolarSupplier = (LinearLayout) findViewById(R.id.solarPowerSystem_linearLayout_batterySupplierSameAsSolarSupplier);
        mSolarPowerSystemLinearLayoutBatterySupplierBookValue  = (LinearLayout) findViewById(R.id.solarPowerSystem_linearLayout_bookValue);

        mSolarPowerSystemEditTextCapacityKW.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(8, 2)});

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    public void DecimalFormatConversion() {
        mSolarPowerSystemEditTextCapacityKW.setText(decimalConversion.convertDecimal(mSolarPowerSystemEditTextCapacityKW.getText().toString()));
    }

    private void initCombo() {
        mSolarPowerSystemTextViewAvailableVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Solar_Power_System.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_solarPowerSystem_available))),
                        "Available",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_available = item.get(position);
                        mSolarPowerSystemTextViewAvailableVal.setText(str_available);
                        changeVisibilityOfFields(str_available);
                    }
                });
            }
        });

        mSolarPowerSystemTextViewBatterySupplierSameAsSolarSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(Solar_Power_System.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_solarPowerSystem_supplierAsSamesupplier))),
                        "Battery supplier same as Solar Supplier",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_supplier_same_as_Solar_Supplier = item.get(position);
                        mSolarPowerSystemTextViewBatterySupplierSameAsSolarSupplier.setText(str_supplier_same_as_Solar_Supplier);
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
                        "Close", "#000000");
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
                        "Close", "#000000");
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
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_amcYesNoVal = item.get(position);
                        mSolarPowerSystemTextViewAmcYesNoVal.setText(str_amcYesNoVal);
                        visibilityOfValidityOfTheAMC(str_amcYesNoVal);
                    }
                });
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MMM/yyyy"; //In which you need put here
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
                DecimalFormatConversion();
                if (checkValidation() == true) {
                    submitDetails();
                    finish();
                    startActivity(new Intent(this, PowerPlantDetailsActivity.class));
                    return true;
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setInputDetails() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");

                Gson gson = new Gson();
                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);
                solarPowerSystemData = hotoTransactionData.getSolarPowerSystemData();

                //private ImageView mSolarPowerSystemButtonQRCodeScan.setText(landDetailsData.getQRCodeScan());

                base64StringQRCodeScan = solarPowerSystemData.getqRCodeScan();

                mSolarPowerSystemButtonQRCodeScanView.setVisibility(View.GONE);
                button_ClearQRCodeScanView.setVisibility(View.GONE);
                if (!base64StringQRCodeScan.isEmpty() && base64StringQRCodeScan != null) {
                    mSolarPowerSystemButtonQRCodeScanView.setVisibility(View.VISIBLE);
                    button_ClearQRCodeScanView.setVisibility(View.VISIBLE);
                }
                // New added for image #ImageSet
               /* This Commented By 008 on 14-11-2018 For QR Code Purpose
               imageFileName = solarPowerSystemData.getQrCodeImageFileName();
                mSolarPowerSystemButtonQRCodeScanView.setVisibility(View.GONE);
                if (imageFileName != null && imageFileName.length() > 0) {
                    File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileName);
//                             imageFileUri = Uri.fromFile(file);
                    imageFileUri = FileProvider.getUriForFile(Solar_Power_System.this, BuildConfig.APPLICATION_ID + ".provider", file);
                    if (imageFileUri != null) {
                        mSolarPowerSystemButtonQRCodeScanView.setVisibility(View.VISIBLE);
                    }
                }*/

                mSolarPowerSystemTextViewAvailableVal.setText(solarPowerSystemData.getAvailable());
                mSolarPowerSystemTextViewAssetOwnerVal.setText(solarPowerSystemData.getAssetOwner());
                mSolarPowerSystemEditTextManufacturerMakeModel.setText(solarPowerSystemData.getManufacturerMakeModel());
                mSolarPowerSystemTextViewCellPanelVal.setText(solarPowerSystemData.getCellPanel());
                mSolarPowerSystemEditTextCapacityKW.setText(solarPowerSystemData.getCapacityKW());
                mSolarPowerSystemEditTextBookValue.setText(solarPowerSystemData.getBookValue());
                mSolarPowerSystemTextViewAmcYesNoVal.setText(solarPowerSystemData.getAmcYesNo());
                mSolarPowerSystemEditTextDateOfvalidityOfAmc.setText(solarPowerSystemData.getDateOfvalidityOfAmc());
                mSolarPowerSystemTextViewBatterySupplierSameAsSolarSupplier.setText(solarPowerSystemData.getBattery_supplier_same_as_Solar_Supplier());

                changeVisibilityOfFields(solarPowerSystemData.getAvailable());
            } else {
                showToast("No previous saved data available");
                //Toast.makeText(Solar_Power_System.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitDetails() {

            //hotoTransactionData.setTicketNo(ticketName);

            String qRCodeScan = base64StringQRCodeScan;
            String available = mSolarPowerSystemTextViewAvailableVal.getText().toString().trim();
            String assetOwner = mSolarPowerSystemTextViewAssetOwnerVal.getText().toString().trim();
            String manufacturerMakeModel = mSolarPowerSystemEditTextManufacturerMakeModel.getText().toString().trim();
            String cellPanel = mSolarPowerSystemTextViewCellPanelVal.getText().toString().trim();
            String bookValue = mSolarPowerSystemEditTextBookValue.getText().toString().trim();
            String capacityKW = mSolarPowerSystemEditTextCapacityKW.getText().toString().trim();
            String amcYesNo = mSolarPowerSystemTextViewAmcYesNoVal.getText().toString().trim();
            String dateOfvalidityOfAmc = mSolarPowerSystemEditTextDateOfvalidityOfAmc.getText().toString().trim();

            String battery_supplier_same_as_Solar_Supplier = mSolarPowerSystemTextViewBatterySupplierSameAsSolarSupplier.getText().toString().trim();

            if(str_supplier_same_as_Solar_Supplier.equals("Yes")){//both

                String battery_manufacturerMakeModel = mSolarPowerSystemEditTextManufacturerMakeModel.getText().toString().trim();
                String battery_bookValue = mSolarPowerSystemEditTextBookValue.getText().toString().trim();
                String battery_capacityKW = mSolarPowerSystemEditTextCapacityKW.getText().toString().trim();
                String battery_amcYesNo = mSolarPowerSystemTextViewAmcYesNoVal.getText().toString().trim();
                String battery_dateOfvalidityOfAmc = mSolarPowerSystemEditTextDateOfvalidityOfAmc.getText().toString().trim();

                solarPowerSystemData = new SolarPowerSystemData(qRCodeScan,bookValue ,available, assetOwner, manufacturerMakeModel, cellPanel,
                        capacityKW, amcYesNo, dateOfvalidityOfAmc, imageFileName,battery_manufacturerMakeModel,battery_capacityKW,battery_bookValue,battery_amcYesNo
                        ,battery_dateOfvalidityOfAmc,battery_supplier_same_as_Solar_Supplier);

            }else {//single
                solarPowerSystemData = new SolarPowerSystemData(qRCodeScan,bookValue ,available, assetOwner, manufacturerMakeModel, cellPanel,
                        capacityKW, amcYesNo, dateOfvalidityOfAmc, imageFileName,"","","","","",battery_supplier_same_as_Solar_Supplier);
            }

            hotoTransactionData.setSolarPowerSystemData(solarPowerSystemData);
        try {
            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);
            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeVisibilityOfFields(String str_available) {
        try {
            mSolarPowerSystemLinearLayoutQRCodeScan.setVisibility(View.VISIBLE);
            mSolarPowerSystemLinearLayoutAssetOwner.setVisibility(View.VISIBLE);
            mSolarPowerSystemLinearLayoutManufacturerMakeModel.setVisibility(View.VISIBLE);
            mSolarPowerSystemLinearLayoutCellPanel.setVisibility(View.VISIBLE);
            mSolarPowerSystemLinearLayoutCapacityKW.setVisibility(View.VISIBLE);
            mSolarPowerSystemLinearLayoutAmcYesNo.setVisibility(View.VISIBLE);
            mSolarPowerSystemLinearLayoutValidityOfAmc.setVisibility(View.VISIBLE);
            mSolarPowerSystemLinearLayoutBatterySupplierSameAsSolarSupplier.setVisibility(View.VISIBLE);
            mSolarPowerSystemLinearLayoutBatterySupplierBookValue.setVisibility(View.VISIBLE);
            if (str_available.equals("No")) {
                mSolarPowerSystemLinearLayoutQRCodeScan.setVisibility(View.GONE);
                mSolarPowerSystemLinearLayoutAssetOwner.setVisibility(View.GONE);
                mSolarPowerSystemLinearLayoutManufacturerMakeModel.setVisibility(View.GONE);
                mSolarPowerSystemLinearLayoutCellPanel.setVisibility(View.GONE);
                mSolarPowerSystemLinearLayoutCapacityKW.setVisibility(View.GONE);
                mSolarPowerSystemLinearLayoutAmcYesNo.setVisibility(View.GONE);
                mSolarPowerSystemLinearLayoutValidityOfAmc.setVisibility(View.GONE);
                mSolarPowerSystemLinearLayoutBatterySupplierSameAsSolarSupplier.setVisibility(View.GONE);
                mSolarPowerSystemLinearLayoutBatterySupplierBookValue.setVisibility(View.GONE);

                base64StringQRCodeScan = "";
                mSolarPowerSystemButtonQRCodeScanView.setVisibility(View.GONE);
                button_ClearQRCodeScanView.setVisibility(View.GONE);
                //mSolarPowerSystemTextViewAvailableVal.setText("");
                mSolarPowerSystemTextViewAssetOwnerVal.setText("");
                mSolarPowerSystemEditTextManufacturerMakeModel.setText("");
                mSolarPowerSystemTextViewCellPanelVal.setText("");
                mSolarPowerSystemEditTextCapacityKW.setText("");
                mSolarPowerSystemEditTextBookValue.setText("");
                mSolarPowerSystemTextViewAmcYesNoVal.setText("");
                mSolarPowerSystemEditTextDateOfvalidityOfAmc.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*008 29112018*/
    public boolean checkValidation() {
        String qRCodeScan = base64StringQRCodeScan;
        String available = mSolarPowerSystemTextViewAvailableVal.getText().toString().trim();
        if (available.equals("Yes") && (qRCodeScan.isEmpty() || qRCodeScan == null)) {
            showToast("Please Scan QR Code");
            return false;
        } else return true;

    }

    /*008 21112018*/
    private boolean validityOfValidityOfTheAMC(String amcYesNo) {
        String dateOfvalidityOfAmc = mSolarPowerSystemEditTextDateOfvalidityOfAmc.getText().toString().trim();
        if (amcYesNo.equals("Yes")) {
            if (!dateOfvalidityOfAmc.isEmpty() && dateOfvalidityOfAmc != null) {
                return true;
            }
            {
                showToast("Select Validity of the AMC");
                return false;
            }
        } else {
            return true;

        }
    }

    /*008 21112018*/
    private void visibilityOfValidityOfTheAMC(String amcYesNo) {
        if (amcYesNo.equals("Yes")) {
            mSolarPowerSystemLinearLayoutValidityOfAmc.setVisibility(View.VISIBLE);
        } else {
            mSolarPowerSystemLinearLayoutValidityOfAmc.setVisibility(View.GONE);
            mSolarPowerSystemEditTextDateOfvalidityOfAmc.setText("");
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

            imageFileUri = FileProvider.getUriForFile(Solar_Power_System.this, BuildConfig.APPLICATION_ID + ".provider", file);

            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            mSolarPowerSystemButtonQRCodeScanView.setVisibility(View.GONE);
            button_ClearQRCodeScanView.setVisibility(View.GONE);
            if (result.getContents() == null) {
                base64StringQRCodeScan = "";
                showToast("Cancelled");
            } else {
                Object[] isDuplicateQRcode = isDuplicateQRcode(result.getContents());
                boolean flagIsDuplicateQRcode = (boolean) isDuplicateQRcode[1];
                if (!flagIsDuplicateQRcode) {
                    base64StringQRCodeScan = result.getContents();
                    if (!base64StringQRCodeScan.isEmpty() && base64StringQRCodeScan != null) {
                        mSolarPowerSystemButtonQRCodeScanView.setVisibility(View.VISIBLE);
                        button_ClearQRCodeScanView.setVisibility(View.VISIBLE);
                    }
                } else {
                    base64StringQRCodeScan = "";
                    showToast("This QR Code Already Used in "+isDuplicateQRcode[0]+" Section");
                }
                //showToast(base64StringQRCodeScan);
            }
        } /*else {
            //base64StringQRCodeScan ="";

        }*/

        /*This Commented By 008 on 14-11-2018 For QR Code Purpose
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
                    mSolarPowerSystemButtonQRCodeScanView.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                imageFileName = "";
                imageFileUri = null;
                mSolarPowerSystemButtonQRCodeScanView.setVisibility(View.GONE);
            }
        }*/
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

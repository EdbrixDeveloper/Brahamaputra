package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
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
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.BuildConfig;
import com.brahamaputra.mahindra.brahamaputra.Data.DgIdQrCode;
import com.brahamaputra.mahindra.brahamaputra.Data.DgIdQrCodeList;
import com.brahamaputra.mahindra.brahamaputra.Data.DieselFillingData;
import com.brahamaputra.mahindra.brahamaputra.Data.DieselFillingFundRequestData;
import com.brahamaputra.mahindra.brahamaputra.Data.DieselSubmitResposeData;
import com.brahamaputra.mahindra.brahamaputra.Data.Site;
import com.brahamaputra.mahindra.brahamaputra.Data.SiteList;
import com.brahamaputra.mahindra.brahamaputra.Data.UserDetailsParent;
import com.brahamaputra.mahindra.brahamaputra.Data.UserSites;
import com.brahamaputra.mahindra.brahamaputra.Data.UserSitesList;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.DecimalConversion;
import com.brahamaputra.mahindra.brahamaputra.Utils.DecimalDigitsInputFilter;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GPSTracker;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DieselFillingFundRequest extends BaseActivity {

    private static final String TAG = DieselFillingFundRequest.class.getSimpleName();

    private TextView mDieselFillingFundRequestTextViewCustomer;
    private TextView mDieselFillingFundRequestTextViewCustomerVal;
    private TextView mDieselFillingFundRequestTextViewCircle;
    private TextView mDieselFillingFundRequestTextViewCircleVal;
    private TextView mDieselFillingFundRequestTextViewState;
    private TextView mDieselFillingFundRequestTextViewStateVal;
    private TextView mDieselFillingFundRequestTextViewSsa;
    private TextView mDieselFillingFundRequestTextViewSsaVal;
    private TextView mDieselFillingFundRequestTextViewSiteName;
    private TextView mDieselFillingFundRequestTextViewSiteNameVal;
    private TextView mDieselFillingFundRequestTextViewSiteId;
    private TextView mDieselFillingFundRequestTextViewSiteIdVal;
    private TextView mDieselFillingFundRequestTextViewSourceOfPower;
    private TextView mDieselFillingFundRequestTextViewSourceOfPowerVal;
    private TextView mDieselFillingFundRequestTextViewCardSupplier;
    private TextView mDieselFillingFundRequestTextViewCardSupplierVal;
    private TextView mDieselFillingFundRequestTextViewChildCardNumber;
    private TextView mDieselFillingFundRequestTextViewChildCardNumberVal;
    private TextView mDieselFillingFundRequestTextViewLastDieselFillingDate;
    private TextView mDieselFillingFundRequestTextViewLastDieselFillingDateVal;
    private TextView mDieselFillingFundRequestTextViewLastDieselStock;
    private TextView mDieselFillingFundRequestTextViewLastDieselStockVal;
    private TextView mDieselFillingFundRequestTextViewLastDgHmr;
    private TextView mDieselFillingFundRequestTextViewLastDgHmrVal;
    private TextView mDieselFillingFundRequestTextViewLastEbReading;
    private TextView mDieselFillingFundRequestTextViewLastEbReadingVal;
    private TextView mDieselFillingFundRequestTextViewPresentDgHmr;
    private EditText mDieselFillingFundRequestEditTextPresentDgHmr;
    private TextView mDieselFillingFundRequestTextViewHmrPhotoUpload;
    private ImageView mDieselFillingFundRequestButtonHmrPhotoUpload;
    private ImageView mDieselFillingFundRequestButtonHmrPhotoUploadView;
    private TextView mDieselFillingFundRequestTextViewPresentDieselStock;
    private EditText mDieselFillingFundRequestEditTextPresentDieselStock;
    private TextView mDieselFillingFundRequestTextViewPresentEbReading;
    private EditText mDieselFillingFundRequestEditTextPresentEbReading;
    private TextView mDieselFillingFundRequestTextViewPresentEbReadingKwhPhoto;
    private ImageView mDieselFillingFundRequestButtonPresentEbReadingKwhPhoto;
    private ImageView mDieselFillingFundRequestButtonPresentEbReadingKwhPhotoView;
    private TextView mDieselFillingFundRequestTextViewPresentDateTime;
    private EditText mDieselFillingFundRequestEditTextPresentDateTime;
    private TextView mDieselFillingFundRequestTextViewDieselQuantityRequired;
    private EditText mDieselFillingFundRequestEditTextDieselQuantityRequired;


    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "";
    private String ticketName = "";
    private String ticketId = "";
    private SessionManager sessionManager;
    private DieselFillingFundRequestData dieselFillingFundRequestData;
    final Calendar myCalendar = Calendar.getInstance();

    private UserSitesList userSitesList;
    private DgIdQrCodeList dgIdQrCodeList;

    private Uri HmrPhoto_imageFileUri = null;
    private Uri EbReadingKwh_imageFileUri = null;

    private String HmrPhoto_imageFileName = "";
    private String EbReadingKwh_imageFileName = "";

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_HmrPhotoUpload = 101;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_PresentEbReadingKwhPhoto = 102;

    private String base64StringHmrPhotoUpload = "";
    private String base64StringPresentEbReadingKwhPhoto = "";

    private String imageFileHmrPhotoUpload;
    private String imageFilePresentEbReadingKwhPhoto;

    private Uri imageFileUriHmrPhotoUpload = null;
    private Uri imageFileUriPresentEbReadingKwhPhoto = null;

    //////////


    public GPSTracker gpsTracker;

    //private ToastMessage toastMessage;
    private AlertDialogManager alertDialogManager;

    DecimalConversion decimalConversion;

    private ArrayList<String> DgIdList;

    public int site_id = 0;
    public double siteLongitude = 0;
    public double siteLatitude = 0;

    String str_customerName = "";
    String str_circleName = "";
    String str_stateName;
    String str_ssa = "";
    String str_siteName;

    int customerId = 0;
    int circleId = 0;
    int StateId = 0;
    int ssaID = 0;
    int siteID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diesel_filling_fund_request);
        this.setTitle("Diesel Filling Fund Request");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gpsTracker = new GPSTracker(DieselFillingFundRequest.this);

        decimalConversion = new DecimalConversion();
        sessionManager = new SessionManager(DieselFillingFundRequest.this);
        alertDialogManager = new AlertDialogManager(DieselFillingFundRequest.this);
        userSitesList = new UserSitesList();
        dgIdQrCodeList = new DgIdQrCodeList();
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(DieselFillingFundRequest.this, userId, "DieselFundRequest");

        assignViews();
        initCombo();
        set_listener();
        prepareUserPersonalData();

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

        mDieselFillingFundRequestEditTextPresentDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*new DatePickerDialog(DieselFillingFundRequest.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();*/

                DatePickerDialog dialog = new DatePickerDialog(DieselFillingFundRequest.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));

                dialog.getDatePicker().setMaxDate(new Date().getTime());
                dialog.show();

            }
        });


    }

    private void assignViews() {
        mDieselFillingFundRequestTextViewCustomer = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_customer);
        mDieselFillingFundRequestTextViewCustomerVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_customerVal);
        mDieselFillingFundRequestTextViewCircle = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_circle);
        mDieselFillingFundRequestTextViewCircleVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_circleVal);
        mDieselFillingFundRequestTextViewState = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_state);
        mDieselFillingFundRequestTextViewStateVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_stateVal);
        mDieselFillingFundRequestTextViewSsa = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_ssa);
        mDieselFillingFundRequestTextViewSsaVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_ssaVal);
        mDieselFillingFundRequestTextViewSiteName = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_siteName);
        mDieselFillingFundRequestTextViewSiteNameVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_siteNameVal);
        mDieselFillingFundRequestTextViewSiteId = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_siteId);
        mDieselFillingFundRequestTextViewSiteIdVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_siteIdVal);
        mDieselFillingFundRequestTextViewSourceOfPower = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_sourceOfPower);
        mDieselFillingFundRequestTextViewSourceOfPowerVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_sourceOfPowerVal);
        mDieselFillingFundRequestTextViewCardSupplier = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_cardSupplier);
        mDieselFillingFundRequestTextViewCardSupplierVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_cardSupplierVal);
        mDieselFillingFundRequestTextViewChildCardNumber = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_childCardNumber);
        mDieselFillingFundRequestTextViewChildCardNumberVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_childCardNumberVal);
        mDieselFillingFundRequestTextViewLastDieselFillingDate = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_lastDieselFillingDate);
        mDieselFillingFundRequestTextViewLastDieselFillingDateVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_lastDieselFillingDateVal);
        mDieselFillingFundRequestTextViewLastDieselStock = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_lastDieselStock);
        mDieselFillingFundRequestTextViewLastDieselStockVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_lastDieselStockVal);
        mDieselFillingFundRequestTextViewLastDgHmr = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_lastDgHmr);
        mDieselFillingFundRequestTextViewLastDgHmrVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_lastDgHmrVal);
        mDieselFillingFundRequestTextViewLastEbReading = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_lastEbReading);
        mDieselFillingFundRequestTextViewLastEbReadingVal = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_lastEbReadingVal);
        mDieselFillingFundRequestTextViewPresentDgHmr = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_presentDgHmr);
        mDieselFillingFundRequestEditTextPresentDgHmr = (EditText) findViewById(R.id.dieselFillingFundRequest_editText_presentDgHmr);
        mDieselFillingFundRequestTextViewHmrPhotoUpload = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_hmrPhotoUpload);
        mDieselFillingFundRequestButtonHmrPhotoUpload = (ImageView) findViewById(R.id.dieselFillingFundRequest_button_hmrPhotoUpload);
        mDieselFillingFundRequestButtonHmrPhotoUploadView = (ImageView) findViewById(R.id.dieselFillingFundRequest_button_hmrPhotoUploadView);
        mDieselFillingFundRequestTextViewPresentDieselStock = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_presentDieselStock);
        mDieselFillingFundRequestEditTextPresentDieselStock = (EditText) findViewById(R.id.dieselFillingFundRequest_editText_presentDieselStock);
        mDieselFillingFundRequestTextViewPresentEbReading = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_presentEbReading);
        mDieselFillingFundRequestEditTextPresentEbReading = (EditText) findViewById(R.id.dieselFillingFundRequest_editText_presentEbReading);
        mDieselFillingFundRequestTextViewPresentEbReadingKwhPhoto = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_presentEbReadingKwhPhoto);
        mDieselFillingFundRequestButtonPresentEbReadingKwhPhoto = (ImageView) findViewById(R.id.dieselFillingFundRequest_button_presentEbReadingKwhPhoto);
        mDieselFillingFundRequestButtonPresentEbReadingKwhPhotoView = (ImageView) findViewById(R.id.dieselFillingFundRequest_button_presentEbReadingKwhPhotoView);
        mDieselFillingFundRequestTextViewPresentDateTime = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_presentDateTime);
        mDieselFillingFundRequestEditTextPresentDateTime = (EditText) findViewById(R.id.dieselFillingFundRequest_editText_presentDateTime);
        mDieselFillingFundRequestTextViewDieselQuantityRequired = (TextView) findViewById(R.id.dieselFillingFundRequest_textView_dieselQuantityRequired);
        mDieselFillingFundRequestEditTextDieselQuantityRequired = (EditText) findViewById(R.id.dieselFillingFundRequest_editText_dieselQuantityRequired);

        /*mDieselFillingEditTextTankBalanceBeforeFilling.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(8, 2)});
        mDieselFillingEditTextFillingQty.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(15, 2)});
        mDieselFillingEditTextDieselPrice.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(15, 2)});

        mDieselFillingTextViewSiteIDVal.setAllCaps(true);
        mDieselFillingTextViewSiteDetailsVal.setAllCaps(true);
        mDieselFillingTextViewFinalDieselStockVal.setAllCaps(true);*/

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    private void initCombo() {
    }

    private void updateLabel() {
        String myFormat = "dd/MMM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mDieselFillingFundRequestEditTextPresentDateTime.setText(sdf.format(myCalendar.getTime()));
    }

    public void set_listener() {

        mDieselFillingFundRequestTextViewSiteNameVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mDieselFillingFundRequestTextViewSsaVal.getText().toString().trim().isEmpty()) {


                    /*SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(DieselFillingFundRequest.this,
                            siteArray,
                            "Select Site",
                            "Close", "#000000");
                    searchableSpinnerDialog.showSearchableSpinnerDialog();

                    searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                        @Override
                        public void onClick(ArrayList<String> item, int position) {

                            ConsumerNoList = null;
                            PaymentTypeList = null;
                            ElectricConnectionTypeList = null;
                            ConnectionTariffList = null;
                            mEbProcessTextViewEbConsumerNumberVal.setText("");
                            mEbProcessTextViewTypeModeOfPayementVal.setText("");
                            mEbProcessTextViewTypeOfElectricConnectionVal.setText("");
                            mEbProcessTextViewTariffVal.setText("");
                            mEbProcessTextViewSiteIDVal.setText("");
                            mEbProcessTextViewSiteDetailsVal.setText("");
                            mEbProcessTextViewEbServiceProviderVal.setText("");

                            str_siteName = item.get(position);
                            mDieselFillingFundRequestTextViewSiteNameVal.setText(str_siteName);
                            siteID = Integer.valueOf(site.getSiteList().get(position).getId());
                            mEbProcessTextViewSiteIDVal.setText(site.getSiteList().get(position).getSiteId());
                            String siteAddress = String.valueOf(site.getSiteList().get(position).getSiteAddress());
                            if (!siteAddress.isEmpty()) {
                                mEbProcessTextViewSiteDetailsVal.setText(String.valueOf(site.getSiteList().get(position).getSiteAddress()));
                            }
                            mEbProcessTextViewEbServiceProviderVal.setText(String.valueOf(site.getSiteList().get(position).getEbOfficeName()));
                            prepareEbSiteConnectedData();
                        }
                    });*/


                } else {
                    showToast("Please Select SSA");
                }

            }
        });

        /////////////
        mDieselFillingFundRequestButtonHmrPhotoUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    HmrPhotoUpload();
                }
            }
        });

        mDieselFillingFundRequestButtonPresentEbReadingKwhPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    PresentEbReadingKwhPhotoPhoto();
                }
            }
        });
        mDieselFillingFundRequestButtonHmrPhotoUploadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriHmrPhotoUpload != null) {
                    GlobalMethods.showImageDialog(DieselFillingFundRequest.this, imageFileUriHmrPhotoUpload);
                } else {
                    Toast.makeText(DieselFillingFundRequest.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
        mDieselFillingFundRequestButtonPresentEbReadingKwhPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUriPresentEbReadingKwhPhoto != null) {
                    GlobalMethods.showImageDialog(DieselFillingFundRequest.this, imageFileUriPresentEbReadingKwhPhoto);
                } else {
                    Toast.makeText(DieselFillingFundRequest.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void HmrPhotoUpload() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileHmrPhotoUpload = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_dieselFundReqHMR.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileHmrPhotoUpload);
            imageFileUriHmrPhotoUpload = FileProvider.getUriForFile(DieselFillingFundRequest.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriHmrPhotoUpload);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_HmrPhotoUpload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void PresentEbReadingKwhPhotoPhoto() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFilePresentEbReadingKwhPhoto = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_dieselFundReqEB.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFilePresentEbReadingKwhPhoto);
            imageFileUriPresentEbReadingKwhPhoto = FileProvider.getUriForFile(DieselFillingFundRequest.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUriPresentEbReadingKwhPhoto);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_PresentEbReadingKwhPhoto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean checkCameraPermission() {

        if (ContextCompat.checkSelfPermission(DieselFillingFundRequest.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(DieselFillingFundRequest.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
        } else {
            return true;
        }


        return false;
    }

    public void DecimalFormatConversion() {
        /*mDieselFillingEditTextFillingQty.setText(decimalConversion.convertDecimal(mDieselFillingEditTextFillingQty.getText().toString()));
        mDieselFillingEditTextTankBalanceBeforeFilling.setText(decimalConversion.convertDecimal(mDieselFillingEditTextTankBalanceBeforeFilling.getText().toString()));
        mDieselFillingTextViewFinalDieselStockVal.setText(decimalConversion.convertDecimal(mDieselFillingTextViewFinalDieselStockVal.getText().toString()));
        mDieselFillingEditTextDieselPrice.setText(decimalConversion.convertDecimal(mDieselFillingEditTextDieselPrice.getText().toString()));*/
    }

    private void prepareUserPersonalData() {
        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();

            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());


            GsonRequest<UserDetailsParent> userProfileRequestGsonRequest = new GsonRequest<>(Request.Method.POST, Constants.GetUserDetails, jo.toString(), UserDetailsParent.class,
                    new Response.Listener<UserDetailsParent>() {
                        @Override
                        public void onResponse(@NonNull UserDetailsParent response) {

                            if (response.getSuccess() == 1) {

                                str_customerName = response.getUserDetails().getUserAdditionalDetails().getCustomerName();
                                mDieselFillingFundRequestTextViewCustomerVal.setText(str_customerName);
                                customerId = Integer.valueOf(response.getUserDetails().getUserAdditionalDetails().getCustomerId());

                                str_circleName = response.getUserDetails().getUserAdditionalDetails().getCircleName();
                                mDieselFillingFundRequestTextViewCircleVal.setText(str_circleName);
                                circleId = Integer.valueOf(response.getUserDetails().getUserAdditionalDetails().getCircleId());

                                str_stateName = response.getUserDetails().getUserAdditionalDetails().getStateName();
                                mDieselFillingFundRequestTextViewStateVal.setText(str_stateName);
                                StateId = Integer.valueOf(response.getUserDetails().getUserAdditionalDetails().getStateId());

                                str_ssa = response.getUserDetails().getUserAdditionalDetails().getSsaName();
                                mDieselFillingFundRequestTextViewSsaVal.setText(str_ssa);
                                ssaID = Integer.valueOf(response.getUserDetails().getUserAdditionalDetails().getSsaId());
                                /*
                                prepareSite();*/
                                hideBusyProgress();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error.getMessage().contains("java.net.UnknownHostException")) {
                        showToast("No Internet Connection.");
                    }
                    hideBusyProgress();

                }
            });
            userProfileRequestGsonRequest.setRetryPolicy(Application.getDefaultRetryPolice());
            userProfileRequestGsonRequest.setShouldCache(false);
            Application.getInstance().addToRequestQueue(userProfileRequestGsonRequest, "ebPaymentRequestGsonRequest");

        } catch (JSONException e) {
            hideBusyProgress();
            showToast("Something went wrong. Please try again later.");
        }

    }

    private void prepareSite() {
        try {
            showBusyProgress();
            JSONObject jo = new JSONObject();
            jo.put("UserId", sessionManager.getSessionUserId());
            jo.put("AccessToken", sessionManager.getSessionDeviceToken());
            //jo.put("SSAId", ssaID); user for after remove error in fund request


            GsonRequest<Site> getSiteRequest = new GsonRequest<>(Request.Method.POST, Constants.GetSite, jo.toString(), Site.class,
                    new Response.Listener<Site>() {
                        @Override
                        public void onResponse(Site response) {
                            hideBusyProgress();
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                /*if (response.getSuccess() == 1) {
                                    site = response;

                                    if (site.getSiteList().size() > 0) {
                                        siteArray = new ArrayList<String>();
                                        for (SiteList siteList : site.getSiteList()) {
                                            siteArray.add(siteList.getSiteName());
                                        }

                                    } else {
                                        mEbProcessTextViewSiteIDVal.setText("No Site Found");
                                        //No sites found
                                    }
                                }*/
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            hideBusyProgress();
                            Log.e("D100", error.toString());
                        }
                    });
            getSiteRequest.setRetryPolicy(Application.getDefaultRetryPolice());
            getSiteRequest.setShouldCache(false);
            Application.getInstance().addToRequestQueue(getSiteRequest, "getSiteRequest");


        } catch (JSONException e) {
            hideBusyProgress();
            showToast("Something went wrong. Please try again later.");
        }


    }

    private void showSettingsAlert() {

        alertDialogManager.Dialog("Confirmation", "Do you want to submit this ticket?", "Yes", "No", new AlertDialogManager.onTwoButtonClickListner() {
            @Override
            public void onPositiveClick() {
                submitDetails();
            }

            @Override
            public void onNegativeClick() {

            }
        }).show();
    }

    private void submitDetails() {
        try {
            showBusyProgress();
            String userId = sessionManager.getSessionUserId();
            String accessToken = sessionManager.getSessionDeviceToken();
            String latitude = String.valueOf(gpsTracker.getLatitude());
            String longitude = String.valueOf(gpsTracker.getLongitude());

            //String siteName = mDieselFillingTextViewSiteNameVal.getText().toString().trim();

            String customer = mDieselFillingFundRequestTextViewCustomerVal.getText().toString().trim();
            String circle = mDieselFillingFundRequestTextViewCircleVal.getText().toString().trim();
            String state = mDieselFillingFundRequestTextViewStateVal.getText().toString().trim();
            String ssa = mDieselFillingFundRequestTextViewSsaVal.getText().toString().trim();
            String siteName = mDieselFillingFundRequestTextViewSiteNameVal.getText().toString().trim();
            String siteId = mDieselFillingFundRequestTextViewSiteIdVal.getText().toString().trim();
            String sourceOfPower = mDieselFillingFundRequestTextViewSourceOfPowerVal.getText().toString().trim();
            String cardSupplier = mDieselFillingFundRequestTextViewCardSupplierVal.getText().toString().trim();
            String childCardNumber = mDieselFillingFundRequestTextViewChildCardNumberVal.getText().toString().trim();
            String lastDieselFillingDate = mDieselFillingFundRequestTextViewLastDieselFillingDateVal.getText().toString().trim();
            String lastDieselStock = mDieselFillingFundRequestTextViewLastDieselStockVal.getText().toString().trim();
            String lastDgHmr = mDieselFillingFundRequestTextViewLastDgHmrVal.getText().toString().trim();
            String lastEbReading = mDieselFillingFundRequestTextViewLastEbReadingVal.getText().toString().trim();
            String presentDgHmr = mDieselFillingFundRequestEditTextPresentDgHmr.getText().toString().trim();
            String hmrPhotoUpload = base64StringHmrPhotoUpload;//mDieselFillingFundRequestTextViewHmrPhotoUpload.getText().toString().trim();
            String presentDieselStock = mDieselFillingFundRequestEditTextPresentDieselStock.getText().toString().trim();
            String presentEbReading = mDieselFillingFundRequestEditTextPresentEbReading.getText().toString().trim();
            String presentEbMeterReadingKwhPhoto = base64StringPresentEbReadingKwhPhoto;//mDieselFillingFundRequestTextView.getText().toString().trim();
            String presentDateTime = mDieselFillingFundRequestEditTextPresentDateTime.getText().toString().trim();
            String dieselQuantityRequiredInLtrs = mDieselFillingFundRequestEditTextDieselQuantityRequired.getText().toString().trim();

            dieselFillingFundRequestData = new DieselFillingFundRequestData(customer, circle, state, ssa, siteName, siteId,
                    sourceOfPower, cardSupplier, childCardNumber, lastDieselFillingDate,
                    lastDieselStock, lastDgHmr, lastEbReading, presentDgHmr,
                    hmrPhotoUpload, presentDieselStock, presentEbReading,
                    presentEbMeterReadingKwhPhoto, presentDateTime, dieselQuantityRequiredInLtrs);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(dieselFillingFundRequestData);

            /*GsonRequest<DieselSubmitResposeData> dieselSubmitResposeData = new GsonRequest<>(Request.Method.POST, Constants.Submitdieselfillingtransaction, jsonString, DieselSubmitResposeData.class,
                    new Response.Listener<DieselSubmitResposeData>() {
                        @Override
                        public void onResponse(DieselSubmitResposeData response) {
                            hideBusyProgress();
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                if (response.getSuccess() == 1) {
                                    hideBusyProgress();
                                    setResult(RESULT_OK);
                                    showToast("Record submitted successfully.");
                                    finish();
                                } else {
                                    hideBusyProgress();
                                    showToast("Something went wrong");
                                }
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            hideBusyProgress();
                            Log.e("D100", error.toString());
                        }
                    });
            dieselSubmitResposeData.setRetryPolicy(Application.getDefaultRetryPolice());
            dieselSubmitResposeData.setShouldCache(false);
            Application.getInstance().addToRequestQueue(dieselSubmitResposeData, "dieselSubmitResposeData");*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean checkValidationOnSubmitDiselTicket() {
        String customer = mDieselFillingFundRequestTextViewCustomerVal.getText().toString().trim();
        String circle = mDieselFillingFundRequestTextViewCircleVal.getText().toString().trim();
        String state = mDieselFillingFundRequestTextViewStateVal.getText().toString().trim();
        String ssa = mDieselFillingFundRequestTextViewSsaVal.getText().toString().trim();
        String siteName = mDieselFillingFundRequestTextViewSiteNameVal.getText().toString().trim();
        String siteId = mDieselFillingFundRequestTextViewSiteIdVal.getText().toString().trim();
        String sourceOfPower = mDieselFillingFundRequestTextViewSourceOfPowerVal.getText().toString().trim();
        String cardSupplier = mDieselFillingFundRequestTextViewCardSupplierVal.getText().toString().trim();
        String childCardNumber = mDieselFillingFundRequestTextViewChildCardNumberVal.getText().toString().trim();
        String lastDieselFillingDate = mDieselFillingFundRequestTextViewLastDieselFillingDateVal.getText().toString().trim();
        String lastDieselStock = mDieselFillingFundRequestTextViewLastDieselStockVal.getText().toString().trim();
        String lastDgHmr = mDieselFillingFundRequestTextViewLastDgHmrVal.getText().toString().trim();
        String lastEbReading = mDieselFillingFundRequestTextViewLastEbReadingVal.getText().toString().trim();
        String presentDgHmr = mDieselFillingFundRequestEditTextPresentDgHmr.getText().toString().trim();
        String hmrPhotoUpload = base64StringHmrPhotoUpload;//mDieselFillingFundRequestTextViewHmrPhotoUpload.getText().toString().trim();
        String presentDieselStock = mDieselFillingFundRequestEditTextPresentDieselStock.getText().toString().trim();
        String presentEbReading = mDieselFillingFundRequestEditTextPresentEbReading.getText().toString().trim();
        String presentEbMeterReadingKwhPhoto = base64StringPresentEbReadingKwhPhoto;//mDieselFillingFundRequestTextView.getText().toString().trim();
        String presentDateTime = mDieselFillingFundRequestEditTextPresentDateTime.getText().toString().trim();
        String dieselQuantityRequiredInLtrs = mDieselFillingFundRequestEditTextDieselQuantityRequired.getText().toString().trim();

        if (siteId.isEmpty() || siteId == null) {
            showToast("Select Site Name");
            return false;
        } else if (presentDgHmr.isEmpty() || presentDgHmr == null) {
            showToast("Enter Present DG HMR");
            return false;
        } else if (hmrPhotoUpload.isEmpty() || hmrPhotoUpload == null) {
            showToast("Upload Photo of HMR");
            return false;
        } else if (presentDieselStock.isEmpty() || presentDieselStock == null) {
            showToast("Enter Present Diesel Stock");
            return false;
        } else if (presentEbReading.isEmpty() || presentEbReading == null) {
            showToast("Enter Present EB Reading");
            return false;
        } else if (presentEbMeterReadingKwhPhoto.isEmpty() || presentEbMeterReadingKwhPhoto == null) {
            showToast("Upload Photo of EB Reading KWH");
            return false;
        } else if (presentDateTime.isEmpty() || presentDateTime == null) {
            showToast("Select Present Date & Time");
            return false;
        } else if (dieselQuantityRequiredInLtrs.isEmpty() || dieselQuantityRequiredInLtrs == null) {
            showToast("Enter Diesel Quantity Required (in Ltrs)");
            return false;
        } else return true;

/*
        if (siteID.isEmpty() || siteID == null) {
            showToast("Select Site Name");
            return false;
        } else if (selectDgIdQrCode.isEmpty() || selectDgIdQrCode == null) {
            showToast("Select DG ID / QR Code");
            return false;
        } else if (presentDgHmr.isEmpty() || presentDgHmr == null) {
            showToast("Enter Present DG HMR");
            return false;
        } else if (hmrPhotoUpload.isEmpty() || hmrPhotoUpload == null) {
            showToast("Upload Photo of HMR");
            return false;
        } else if (tankBalanceBeforeFilling.isEmpty() || tankBalanceBeforeFilling == null) {
            showToast("Enter Tank Balance Before Filling");
            return false;
        } else if (fillingQty.isEmpty() || fillingQty == null) {
            showToast("Enter Filling Quantity");
            return false;
        } else if (dieselPrice.isEmpty() || dieselPrice == null) {
            showToast("Enter Diesel Price");
            return false;
        } else if (presentEbReading.isEmpty() || presentEbReading == null) {
            showToast("Enter Present EB Reading");
            return false;
        } else if (ebReadingKwhPhoto.isEmpty() || ebReadingKwhPhoto == null) {
            showToast("Upload Photo of EB Reading KWH");
            return false;
        } else return true;*/

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
                DecimalFormatConversion();
                if (checkValidationOnSubmitDiselTicket() == true) {
                    if (gpsTracker.canGetLocation()) {
                        if (gpsTracker.getLongitude() > 0 && gpsTracker.getLongitude() > 0) {
                            if (gpsTracker.distance(gpsTracker.getLatitude(), gpsTracker.getLongitude(), siteLatitude, siteLongitude) < 0.310686) {///// ( 0.310686 MILE == 500 Meter )
                                Log.i(DieselFillingFundRequest.class.getName(), "" + "in Area \n" + gpsTracker.distance(gpsTracker.getLatitude(), gpsTracker.getLongitude(), siteLatitude, siteLongitude));
                                showSettingsAlert();
                            } else {
                                Log.i(DieselFillingFundRequest.class.getName(), "" + "not in Area\n" + gpsTracker.distance(gpsTracker.getLatitude(), gpsTracker.getLongitude(), siteLatitude, siteLongitude));
                                alertDialogManager.Dialog("Information", "User not in area of site", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                                    @Override
                                    public void onPositiveClick() {

                                    }
                                }).show();
                            }

                        } else {
                            alertDialogManager.Dialog("Information", "Could not get your location. Please try again.", "ok", "cancel", new AlertDialogManager.onSingleButtonClickListner() {
                                @Override
                                public void onPositiveClick() {
                                    if (gpsTracker.canGetLocation()) {
                                        Log.e(MyEnergyListActivity.class.getName(), "Lat : " + gpsTracker.getLatitude() + "\n Long : " + gpsTracker.getLongitude());
                                    }
                                }
                            }).show();
                        }
                    }
                    return true;
                }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA_HmrPhotoUpload:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriHmrPhotoUpload != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriHmrPhotoUpload);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringHmrPhotoUpload = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mDieselFillingFundRequestButtonHmrPhotoUploadView.setVisibility(View.VISIBLE);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileHmrPhotoUpload = "";
                    imageFileUriHmrPhotoUpload = null;
                    mDieselFillingFundRequestButtonHmrPhotoUploadView.setVisibility(View.GONE);
                }
                break;

            case MY_PERMISSIONS_REQUEST_CAMERA_PresentEbReadingKwhPhoto:
                if (resultCode == RESULT_OK) {
                    if (imageFileUriPresentEbReadingKwhPhoto != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUriPresentEbReadingKwhPhoto);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringPresentEbReadingKwhPhoto = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mDieselFillingFundRequestButtonPresentEbReadingKwhPhotoView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFilePresentEbReadingKwhPhoto = "";
                    imageFileUriPresentEbReadingKwhPhoto = null;
                    mDieselFillingFundRequestButtonPresentEbReadingKwhPhotoView.setVisibility(View.GONE);
                }
                break;
        }
    }


}

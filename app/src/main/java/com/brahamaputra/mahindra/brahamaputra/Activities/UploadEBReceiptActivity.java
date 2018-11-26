package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputra.Application;
import com.brahamaputra.mahindra.brahamaputra.BuildConfig;
import com.brahamaputra.mahindra.brahamaputra.Data.EBBillUploadReceipt;
import com.brahamaputra.mahindra.brahamaputra.Data.EBlSubmitResposeData;
import com.brahamaputra.mahindra.brahamaputra.Data.ElectricBillProcessData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
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
import java.util.Date;

public class UploadEBReceiptActivity extends BaseActivity {

    private static final String TAG = UploadEBReceiptActivity.class.getSimpleName();

    private TextView mUploadEbReceiptEditTextTicketNumber;
    private TextView mUploadEbReceiptEditTextSiteId;
    private TextView mUploadEbReceiptEditTextSiteName;
    private TextView mUploadEbReceiptTextViewPaymentTypeVal;
    private ImageView mUploadEbReceiptButtonUploadPhoto;
    private ImageView mUploadEbReceiptButtonUploadPhotoView;
    private EBBillUploadReceipt ebBillUploadReceipt;

    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;
    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    private String imageFileName;
    private Uri imageFileNameUri = null;
    private String base64String = "";
    String request_id;
    String ticket_no;
    String site_id;
    String site_name;
    private AlertDialogManager alertDialogManager;

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_ebreceipt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Upload Receipt");

        Intent intent = getIntent();
        request_id = intent.getStringExtra("request_id");
        ticket_no = intent.getStringExtra("ticket_no");
        site_id = intent.getStringExtra("site_id");
        site_name = intent.getStringExtra("site_name");
        assignViews();
        setListners();
        alertDialogManager = new AlertDialogManager(UploadEBReceiptActivity.this);
        sessionManager = new SessionManager(UploadEBReceiptActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(UploadEBReceiptActivity.this, userId, ticketName);

        mUploadEbReceiptEditTextTicketNumber.setText(ticket_no);
        mUploadEbReceiptEditTextSiteId.setText(site_id);
        mUploadEbReceiptEditTextSiteName.setText(site_name);

        mUploadEbReceiptTextViewPaymentTypeVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(UploadEBReceiptActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_payment_type))),
                        "Type of Payment",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        mUploadEbReceiptTextViewPaymentTypeVal.setText(item.get(position));
                    }
                });
            }
        });

        mUploadEbReceiptButtonUploadPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileNameUri != null) {
                    GlobalMethods.showImageDialog(UploadEBReceiptActivity.this, imageFileNameUri);
                } else {
                    Toast.makeText(UploadEBReceiptActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });


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
                if (checkValidation()) {
                    showSettingsAlert();
                    //finish();
                }
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private boolean checkValidation() {
        String payment_type = mUploadEbReceiptTextViewPaymentTypeVal.getText().toString();
        if (request_id.isEmpty() || request_id == null) {
            showToast("Invalid Request ID ");
            return false;
        } else if (ticket_no.isEmpty() || ticket_no == null) {
            showToast("Invalid Ticket ");
            return false;
        } else if (site_id.isEmpty() || site_id == null) {
            showToast("Invalid Site ID ");
            return false;
        } else if (site_name.isEmpty() || site_name == null) {
            showToast("Invalid Site Name ");
            return false;
        } else if (payment_type.isEmpty() || payment_type == null) {
            showToast("Select Payment Type ");
            return false;
        } else if (base64String.isEmpty() || base64String == null) {
            showToast("Upload Receipt ");
            return false;
        } else return true;
    }

    private void showSettingsAlert() {

        //alertDialogManager = new AlertDialogManager(UploadEBReceiptActivity.this);
        alertDialogManager.Dialog("Confirmation", "Do you want to Upload Receipt?", "Yes", "No", new AlertDialogManager.onTwoButtonClickListner() {
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
            String paymentMode = mUploadEbReceiptTextViewPaymentTypeVal.getText().toString();


            ebBillUploadReceipt = new EBBillUploadReceipt(userId, accessToken, request_id, paymentMode, base64String);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(ebBillUploadReceipt);

            //offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);

            GsonRequest<EBlSubmitResposeData> eBlSubmitResposeDataGsonRequest = new GsonRequest<>(Request.Method.POST, Constants.SubmitEbfillingPaymentEeceipt, jsonString, EBlSubmitResposeData.class,
                    new Response.Listener<EBlSubmitResposeData>() {
                        @Override
                        public void onResponse(EBlSubmitResposeData response) {
                            hideBusyProgress();
                            if (response.getError() != null) {
                                showToast(response.getError().getErrorMessage());
                            } else {
                                if (response.getSuccess() == 1) {

                                    setResult(RESULT_OK);
                                    showToast("Receipt Uploaded successfully.");
                                    finish();
                                } else {

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
            eBlSubmitResposeDataGsonRequest.setRetryPolicy(Application.getDefaultRetryPolice());
            eBlSubmitResposeDataGsonRequest.setShouldCache(false);
            Application.getInstance().addToRequestQueue(eBlSubmitResposeDataGsonRequest, "eBlSubmitResposeDataGsonRequest");


        } catch (Exception e)

        {
            e.printStackTrace();
        }

    }


    private void assignViews() {
        mUploadEbReceiptEditTextTicketNumber = (TextView) findViewById(R.id.uploadEbReceipt_textView_ticketNumber);
        mUploadEbReceiptEditTextSiteId = (TextView) findViewById(R.id.uploadEbReceipt_textView_siteId);
        mUploadEbReceiptEditTextSiteName = (TextView) findViewById(R.id.uploadEbReceipt_textView_siteName);
        mUploadEbReceiptTextViewPaymentTypeVal = (TextView) findViewById(R.id.uploadEbReceipt_textView_paymentType_val);
        mUploadEbReceiptButtonUploadPhoto = (ImageView) findViewById(R.id.uploadEbReceipt_button_uploadPhoto);
        mUploadEbReceiptButtonUploadPhotoView = (ImageView) findViewById(R.id.uploadEbReceipt_button_uploadPhotoView);
    }

    private void setListners() {
        mUploadEbReceiptButtonUploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });
    }

    private void takePhoto() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileName = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_site.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileName);
            imageFileNameUri = FileProvider.getUriForFile(UploadEBReceiptActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileNameUri);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA:
                if (resultCode == RESULT_OK) {
                    if (imageFileNameUri != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileNameUri);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64String = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                            mUploadEbReceiptButtonUploadPhotoView.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    imageFileName = "";
                    imageFileNameUri = null;
                    mUploadEbReceiptButtonUploadPhotoView.setVisibility(View.GONE);
                }
                break;
        }
    }
}

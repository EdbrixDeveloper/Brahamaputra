package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.BuildConfig;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadEBReceiptActivity extends BaseActivity {

    private static final String TAG = UploadEBReceiptActivity.class.getSimpleName();

    private EditText mUploadEbReceiptEditTextTicketNumber;
    private EditText mUploadEbReceiptEditTextSiteId;
    private EditText mUploadEbReceiptEditTextSiteName;
    private TextView mUploadEbReceiptTextViewPaymentTypeVal;
    private ImageView mUploadEbReceiptButtonUploadPhoto;
    private ImageView mUploadEbReceiptButtonUploadPhotoView;

    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;
    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    private String imageFileName;
    private Uri imageFileNameUri = null;
    private String base64String = "";

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_ebreceipt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Upload");
        assignViews();
        setListners();

        sessionManager = new SessionManager(UploadEBReceiptActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(UploadEBReceiptActivity.this, userId, ticketName);

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
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void assignViews() {
        mUploadEbReceiptEditTextTicketNumber = (EditText) findViewById(R.id.uploadEbReceipt_editText_ticketNumber);
        mUploadEbReceiptEditTextSiteId = (EditText) findViewById(R.id.uploadEbReceipt_editText_siteId);
        mUploadEbReceiptEditTextSiteName = (EditText) findViewById(R.id.uploadEbReceipt_editText_siteName);
        mUploadEbReceiptTextViewPaymentTypeVal = (TextView) findViewById(R.id.uploadEbReceipt_textView_paymentType_val);
        mUploadEbReceiptButtonUploadPhoto = (ImageView) findViewById(R.id.uploadEbReceipt_button_uploadPhoto);
        mUploadEbReceiptButtonUploadPhotoView = (ImageView) findViewById(R.id.uploadEbReceipt_button_uploadPhotoView);
    }

    private void setListners(){
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

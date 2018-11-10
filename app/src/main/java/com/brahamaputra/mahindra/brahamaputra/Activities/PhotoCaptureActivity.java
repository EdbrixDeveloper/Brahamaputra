package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePhotoCaptureData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhotoCaptureActivity extends BaseActivity {

    private static final String TAG = PhotoCaptureActivity.class.getSimpleName();

    private ImageView mPhotoCaptureButtonSite;
    private ImageView mPhotoCaptureButtonShelter;
    private ImageView mPhotoCaptureButtonEbMeterBox;
    private ImageView mPhotoCaptureButtonSmps;
    private ImageView mPhotoCaptureButtonEbMeter;
    private ImageView mPhotoCaptureButtonDgHmr;
    private ImageView mPhotoCaptureButtonDgOverview;
    private OfflineStorageWrapper offlineStorageWrapper;

    private SessionManager sessionManager;
    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    private HotoTransactionData hotoTransactionData;
    private SitePhotoCaptureData sitePhotoCaptureData;

    private Uri imageFileUri;


    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_SITE = 101;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_SHELTER = 102;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_EB_METER_BOX = 103;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_SMPS = 104;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_EB_METER = 105;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_DG_HMR = 106;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA_DG_OVERVIEW = 107;

    private String base64StringSite = "";
    private String base64StringShelter = "";
    private String base64StringEbMeterBox = "";
    private String base64StringSmps = "";
    private String base64StringEbMeter = "";
    private String base64StringDgHmr = "";
    private String base64StringDgOverview = "";

    private String imageFileNameOfSite;
    private String imageFileNameOfShelter;
    private String imageFileNameOfEbMeterBox;
    private String imageFileNameOfSmps;
    private String imageFileNameOfEbMeter;
    private String imageFileNameOfDgHmr;
    private String imageFileNameOfDgOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_capture);

        this.setTitle("Photos To Be Capture");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sessionManager = new SessionManager(PhotoCaptureActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PhotoCaptureActivity.this, userId, ticketName);

        hotoTransactionData = new HotoTransactionData();
        assignViews();
        checkCameraPermission();
        setListner();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void setListner() {
        mPhotoCaptureButtonSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkCameraPermission()){
                    takePhotoOfSite();
                }
            }
        });

        mPhotoCaptureButtonShelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkCameraPermission()) {
                    takePhotoOfShelter();
                }
            }
        });

        mPhotoCaptureButtonEbMeterBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkCameraPermission()) {
                    takePhotoEbMeterBox();
                }
            }
        });
        mPhotoCaptureButtonSmps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkCameraPermission()) {
                    takePhotoSmps();
                }
            }
        });
        mPhotoCaptureButtonEbMeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkCameraPermission()){
                    takePhotoEbMeter();
                }
            }
        });
        mPhotoCaptureButtonDgHmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkCameraPermission()){
                    takePhotoDgHmr();
                }
            }
        });
        mPhotoCaptureButtonDgOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkCameraPermission()){
                    takePhotoDgOverview();
                }
            }
        });
    }

    private void takePhotoDgOverview() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileNameOfDgOverview = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_dgOverview.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileNameOfDgOverview);
            imageFileUri = Uri.fromFile(file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_DG_OVERVIEW);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void takePhotoDgHmr() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileNameOfDgHmr = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_dgHmr.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileNameOfDgHmr);
            imageFileUri = Uri.fromFile(file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_DG_HMR);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void takePhotoEbMeter() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileNameOfEbMeter = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_ebMeter.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileNameOfEbMeter);
            imageFileUri = Uri.fromFile(file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_EB_METER);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void takePhotoSmps() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileNameOfSmps = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_smps.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileNameOfSmps);
            imageFileUri = Uri.fromFile(file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_SMPS);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void takePhotoEbMeterBox() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileNameOfEbMeterBox = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_ebMeterBox.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileNameOfEbMeterBox);
            imageFileUri = Uri.fromFile(file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_EB_METER_BOX);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void takePhotoOfShelter() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileNameOfShelter = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_shelter.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileNameOfShelter);
            imageFileUri = Uri.fromFile(file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_SHELTER);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void takePhotoOfSite() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            imageFileNameOfSite = "IMG_" + ticketName + "_" + sdf.format(new Date()) + "_site.jpg";

            File file = new File(offlineStorageWrapper.getOfflineStorageFolderPath(TAG), imageFileNameOfSite);
            imageFileUri = Uri.fromFile(file);
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA_SITE);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_CAMERA_SITE:
                if(resultCode == RESULT_OK){
                    if (imageFileUri != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUri);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringSite = "qwer";//Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            break;

            case MY_PERMISSIONS_REQUEST_CAMERA_SHELTER:
                if(resultCode == RESULT_OK){
                    if (imageFileUri != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUri);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringShelter = "qwer";//Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            break;

            case MY_PERMISSIONS_REQUEST_CAMERA_EB_METER_BOX:
                if(resultCode == RESULT_OK){
                    if (imageFileUri != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUri);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringEbMeterBox ="qwer";// Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            break;

            case MY_PERMISSIONS_REQUEST_CAMERA_SMPS:
                if(resultCode == RESULT_OK){
                    if (imageFileUri != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUri);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringSmps = "qwer";//Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            break;

            case MY_PERMISSIONS_REQUEST_CAMERA_EB_METER:
                if(resultCode == RESULT_OK){
                    if (imageFileUri != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUri);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringEbMeter = "qwer";//Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            break;

            case MY_PERMISSIONS_REQUEST_CAMERA_DG_HMR:
                if(resultCode == RESULT_OK){
                    if (imageFileUri != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUri);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringDgHmr ="qwer";// Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            break;

            case MY_PERMISSIONS_REQUEST_CAMERA_DG_OVERVIEW:
                if(resultCode == RESULT_OK){
                    if (imageFileUri != null) {
                        try {
                            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUri);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                            byte[] bitmapDataArray = stream.toByteArray();
                            base64StringDgOverview = "qwer";//Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            break;
        }

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean checkCameraPermission() {

        /*if (ContextCompat.checkSelfPermission(PhotoCaptureActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {

            if (getFromPref(PhotoCaptureActivity.this, ALLOW_KEY)) {

                final Intent i = new Intent();
                i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                i.addCategory(Intent.CATEGORY_DEFAULT);
                i.setData(Uri.parse("package:" + PhotoCaptureActivity.this.getPackageName()));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                PhotoCaptureActivity.this.startActivity(i);

            } else if (ContextCompat.checkSelfPermission(PhotoCaptureActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(PhotoCaptureActivity.this, Manifest.permission.CAMERA))
                {
                    ActivityCompat.requestPermissions(PhotoCaptureActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(PhotoCaptureActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
                }
            }
        }*/

        if (ContextCompat.checkSelfPermission(PhotoCaptureActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(PhotoCaptureActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
        }else {
            return true;
        }


        return false;
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
                setResult(RESULT_OK);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void assignViews() {
        mPhotoCaptureButtonSite = (ImageView) findViewById(R.id.photoCapture_button_site);
        mPhotoCaptureButtonShelter = (ImageView) findViewById(R.id.photoCapture_button_shelter);
        mPhotoCaptureButtonEbMeterBox = (ImageView) findViewById(R.id.photoCapture_button_ebMeterBox);
        mPhotoCaptureButtonSmps = (ImageView) findViewById(R.id.photoCapture_button_smps);
        mPhotoCaptureButtonEbMeter = (ImageView) findViewById(R.id.photoCapture_button_ebMeter);
        mPhotoCaptureButtonDgHmr = (ImageView) findViewById(R.id.photoCapture_button_dgHmr);
        mPhotoCaptureButtonDgOverview = (ImageView) findViewById(R.id.photoCapture_button_dgOerview);
    }

    private void submitDetails() {
        try {
            hotoTransactionData.setTicketNo(ticketName);

            sitePhotoCaptureData = new SitePhotoCaptureData(imageFileNameOfSite , base64StringSite,
                    imageFileNameOfShelter , base64StringShelter,
                    imageFileNameOfEbMeterBox , base64StringEbMeterBox,
                    imageFileNameOfSmps , base64StringSmps,
                    imageFileNameOfEbMeter , base64StringEbMeter,
                    imageFileNameOfDgHmr , base64StringDgHmr,
                    imageFileNameOfDgOverview , base64StringDgOverview);

            hotoTransactionData.setSitePhotoCaptureData(sitePhotoCaptureData);
            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);
            //Toast.makeText(Land_Details.this, "Gson to json string :" + jsonString, Toast.LENGTH_SHORT).show();
            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

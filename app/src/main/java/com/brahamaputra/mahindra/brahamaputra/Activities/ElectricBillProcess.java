package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import com.brahamaputra.mahindra.brahamaputra.Data.DieselSubmitResposeData;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.UserSites;
import com.brahamaputra.mahindra.brahamaputra.Data.UserSitesList;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputra.Utils.DecimalDigitsInputFilter;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GPSTracker;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.commons.ToastMessage;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ElectricBillProcess extends BaseActivity {

    private static final String TAG = ElectricBillProcess.class.getSimpleName();
    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "";
    private String ticketName = "";
    private String ticketId = "";
    private SessionManager sessionManager;



    private ToastMessage toastMessage;
    private AlertDialogManager alertDialogManager;






    private void initCombo() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_bill_process);
        this.setTitle("Electric Bill Process");

        sessionManager = new SessionManager(ElectricBillProcess.this);
        alertDialogManager = new AlertDialogManager(ElectricBillProcess.this);
        toastMessage = new ToastMessage(ElectricBillProcess.this);
        userId = sessionManager.getSessionUserId();


        initCombo();
        set_listener();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setInputDetails();


    }

    public void set_listener() {


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
                //  startActivity(new Intent(this, HotoSectionsListActivity.class));
                return true;
            case R.id.menuDone:
                    showSettingsAlert();
                    return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void setInputDetails() {
        try {
          /*  if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");

                Gson gson = new Gson();


                mDieselFillingTextViewSiteNameVal.setText(dieselFillingData.getSiteName());
                mDieselFillingTextViewSiteDetailsVal.setText(dieselFillingData.getSiteDetails());
                mDieselFillingTextViewSiteIDVal.setText(dieselFillingData.getSiteID());
                mDieselFillingTextViewSelectDgIdQrCodeVal.setText(dieselFillingData.getSelectDgIdQrCode());
                mDieselFillingEditTextPresentDgHmr.setText(dieselFillingData.getPresentDgHmr());
                base64StringHmrPhoto= dieselFillingData.getHmrPhotoUpload();
                mDieselFillingEditTextTankBalanceBeforeFilling.setText(dieselFillingData.getTankBalanceBeforeFilling());
                mDieselFillingEditTextFillingQty.setText(dieselFillingData.getFillingQty());
                mDieselFillingTextViewFinalDieselStockVal.setText(dieselFillingData.getFinalDieselStock());
                mDieselFillingEditTextPresentEbReading.setText(dieselFillingData.getPesentEbReading());
                base64StringEbReadingKwh =dieselFillingData.getEbReadingKwhPhoto();



            } else {
                Toast.makeText(DieselFilling.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }*/
        } catch (Exception e) {
            e.printStackTrace();
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



    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
    }



}

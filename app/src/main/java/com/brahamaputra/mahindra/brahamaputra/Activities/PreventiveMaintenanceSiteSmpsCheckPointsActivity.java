package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.Manifest;
import android.app.Activity;
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
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.brahamaputra.mahindra.brahamaputra.BuildConfig;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.AlertDialogManager;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class PreventiveMaintenanceSiteSmpsCheckPointsActivity extends BaseActivity {

    private static final String TAG = PreventiveMaintenanceSiteSmpsCheckPointsActivity.class.getSimpleName();

    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsNumber;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScanView;
    private ImageView mButtonClearQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsCondition;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsConditionVal;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatus;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatusVal;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatus;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatusVal;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewDcLoadCurrent;
    private EditText mPreventiveMaintenanceSiteSmpsCheckPointsEditTextDcLoadCurrent;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewPhotoDcLoadCurrent;
    private ImageView mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrent;
    private ImageView mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrentView;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewDcLoadAmpPh;
    private EditText mPreventiveMaintenanceSiteSmpsCheckPointsEditTextDcLoadAmpPh;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteSmpsCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteSmpsCheckPointsButtonNextReading;

    String str_noOfSmpsAvailableAtSiteVal;
    String str_smpsConditionVal;
    String str_smpsControlerStatusVal;
    String str_smpsEarthingStatusVal;
    String str_segisterFaultVal;
    String str_sypeOfFaultVal;

    private AlertDialogManager alertDialogManager;

    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    /*private HotoTransactionData hotoTransactionData;
    private LandDetailsData landDetailsData;*/
    private String base64StringDcLoadCurrentPhoto = "";
    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;

    private Uri imageFileUri = null;
    private String imageFileName = "";
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_smps_check_points);
        this.setTitle("SMPS Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();

        alertDialogManager = new AlertDialogManager(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this);
        sessionManager = new SessionManager(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this);

        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this, userId, ticketName);

        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (getFromPref(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this, ALLOW_KEY)) {
                        showSettingsAlert();

                    } else if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                                Manifest.permission.CAMERA)) {
                            showAlert();
                        } else {
                            // No explanation needed, we can request the permission.
                            ActivityCompat.requestPermissions(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                                    new String[]{Manifest.permission.CAMERA},
                                    MY_PERMISSIONS_REQUEST_CAMERA);
                        }
                    }
                }
                else
                {
                    openCameraIntent();
                }
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUri != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this, imageFileUri);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_noOfSmpsAvailableAtSite);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_noOfSmpsAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsNumber);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_QRCodeScan);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_QRCodeScan);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_QRCodeScanView);
        mButtonClearQRCodeScanView = (ImageView) findViewById(R.id.button_ClearQRCodeScanView);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsCondition);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsConditionVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsControlerStatus);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsControlerStatusVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsEarthingStatus);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_smpsEarthingStatusVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewDcLoadCurrent = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_dcLoadCurrent);
        mPreventiveMaintenanceSiteSmpsCheckPointsEditTextDcLoadCurrent = (EditText) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_editText_dcLoadCurrent);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewPhotoDcLoadCurrent = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_photoDcLoadCurrent);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrent = (ImageView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_photoDcLoadCurrent);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrentView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_photoDcLoadCurrentView);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewDcLoadAmpPh = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_dcLoadAmpPh);
        mPreventiveMaintenanceSiteSmpsCheckPointsEditTextDcLoadAmpPh = (EditText) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_editText_dcLoadAmpPh);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteSmpsCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteSmpsCheckPoints_button_nextReading);
    }

    private void initCombo() {

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_noOfSMPSAvailableAtSite))),
                        "No of SMPS available at site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_noOfSmpsAvailableAtSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewNoOfSmpsAvailableAtSiteVal.setText(str_noOfSmpsAvailableAtSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_smpsCondition))),
                        "SMPS Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_smpsConditionVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsConditionVal.setText(str_smpsConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_smpsControlerStatus))),
                        "SMPS Controler Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_smpsControlerStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsControlerStatusVal.setText(str_smpsControlerStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_smpsEarthingStatus))),
                        "SMPS Earthing Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_smpsEarthingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewSmpsEarthingStatusVal.setText(str_smpsEarthingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_segisterFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewRegisterFaultVal.setText(str_segisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteSmpsCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_sypeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteSmpsCheckPointsTextViewTypeOfFaultVal.setText(str_sypeOfFaultVal);
                    }
                });
            }
        });


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

                final EditText taskEditText = new EditText(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("SETTINGS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startInstalledAppDetailsActivity(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this);
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

                final EditText taskEditText = new EditText(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("ALLOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this,
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

            imageFileUri = FileProvider.getUriForFile(PreventiveMaintenanceSiteSmpsCheckPointsActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);

            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
            startActivityForResult(pictureIntent, MY_PERMISSIONS_REQUEST_CAMERA);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_PERMISSIONS_REQUEST_CAMERA && resultCode == RESULT_OK) {
            if (imageFileUri != null) {
                try {
                    Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageFileUri);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    imageBitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                    byte[] bitmapDataArray = stream.toByteArray();
                    base64StringDcLoadCurrentPhoto = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                    mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrentView.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            imageFileName = "";
            imageFileUri = null;
            mPreventiveMaintenanceSiteSmpsCheckPointsButtonPhotoDcLoadCurrentView.setVisibility(View.GONE);
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
                onBackPressed();
                return true;

            case R.id.menuSubmit:
                //submitDetails();
                startActivity(new Intent(this, PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }
}

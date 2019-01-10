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

public class PreventiveMaintenanceSiteDgCheckPointsActivity extends BaseActivity {

    private static final String TAG = PreventiveMaintenanceSiteDgCheckPointsActivity.class.getSimpleName();

    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSite;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSiteVal;
    private LinearLayout mLinearLayoutContainer;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewDgNumber;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScan;
    private ImageView mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScanView;
    private ImageView mButtonClearQRCodeScanView;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewDgHmrReading;
    private EditText mPreventiveMaintenanceSiteDgCheckPointsEditTextDgHmrReading;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewPhotoOfDgHmr;
    private ImageView mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmr;
    private ImageView mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmrView;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingCondition;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingConditionVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevel;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevelVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTension;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTensionVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevel;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevelVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatus;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatusVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatus;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatusVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFaultVal;
    private Button mPreventiveMaintenanceSiteDgCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteDgCheckPointsButtonNextReading;

    String str_pmSiteDgcpNoOfDgAvailableAtSiteVal = "";
    String str_pmSiteDgcpDGWorkingConditionVal = "";
    String str_pmSiteDgcpCoolentLevelVal = "";
    String str_pmSiteDgcpBeltTensionVal = "";
    String str_pmSiteDgcpEngineLubeOilLevelVal = "";
    String str_pmSiteDgcpSafetyWorkingStatusVal = "";
    String str_pmSiteDgcpPowerCableConnectionStatusVal = "";
    String str_pmSiteDgcpRegisterFaultVal = "";
    String str_pmSiteDgcpTypeOfFaultVal = "";

    private AlertDialogManager alertDialogManager;

    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    /*private HotoTransactionData hotoTransactionData;
    private LandDetailsData landDetailsData;*/
    private String base64StringTakePhotoOfDgHmr = "";
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
        setContentView(R.layout.activity_preventive_maintenance_site_dg_check_points);
        this.setTitle("DG Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();

        alertDialogManager = new AlertDialogManager(PreventiveMaintenanceSiteDgCheckPointsActivity.this);
        sessionManager = new SessionManager(PreventiveMaintenanceSiteDgCheckPointsActivity.this);

        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteDgCheckPointsActivity.this, userId, ticketName);

        mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (getFromPref(PreventiveMaintenanceSiteDgCheckPointsActivity.this, ALLOW_KEY)) {
                        showSettingsAlert();

                    } else if (ContextCompat.checkSelfPermission(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                                Manifest.permission.CAMERA)) {
                            showAlert();
                        } else {
                            // No explanation needed, we can request the permission.
                            ActivityCompat.requestPermissions(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
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

        mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmrView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageFileUri != null) {
                    GlobalMethods.showImageDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this, imageFileUri);
                } else {
                    Toast.makeText(PreventiveMaintenanceSiteDgCheckPointsActivity.this, "Image not available...!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initCombo() {
        mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_noOfDgAvailableAtSite))),
                        "No of DG available at site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpNoOfDgAvailableAtSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSiteVal.setText(str_pmSiteDgcpNoOfDgAvailableAtSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_dgWorkingCondition))),
                        "DG Working Condition",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpDGWorkingConditionVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingConditionVal.setText(str_pmSiteDgcpDGWorkingConditionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevelVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_coolentLevel))),
                        "Coolent Level",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpCoolentLevelVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevelVal.setText(str_pmSiteDgcpCoolentLevelVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTensionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_beltTension))),
                        "Belt Tension",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpBeltTensionVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTensionVal.setText(str_pmSiteDgcpBeltTensionVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevelVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_engineLubeOilLevel))),
                        "Engine Lube Oil Level",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpEngineLubeOilLevelVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevelVal.setText(str_pmSiteDgcpEngineLubeOilLevelVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_safetyWorkingStatus))),
                        "Safety Working Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpSafetyWorkingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatusVal.setText(str_pmSiteDgcpSafetyWorkingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_powerCableConnecionStatus))),
                        "Power Cable Connection Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpPowerCableConnectionStatusVal= item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatusVal.setText(str_pmSiteDgcpPowerCableConnectionStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpRegisterFaultVal= item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFaultVal.setText(str_pmSiteDgcpRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteDgCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgcpTypeOfFaultVal= item.get(position);
                        mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteDgcpTypeOfFaultVal);
                    }
                });
            }
        });
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_noOfDgAvailableAtSite);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewNoOfDgAvailableAtSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_noOfDgAvailableAtSiteVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_dgNumber);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewQRCodeScan = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_QRCodeScan);
        mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScan = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_QRCodeScan);
        mPreventiveMaintenanceSiteDgCheckPointsButtonQRCodeScanView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_QRCodeScanView);
        mButtonClearQRCodeScanView = (ImageView) findViewById(R.id.button_ClearQRCodeScanView);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgHmrReading = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_dgHmrReading);
        mPreventiveMaintenanceSiteDgCheckPointsEditTextDgHmrReading = (EditText) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_editText_dgHmrReading);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewPhotoOfDgHmr = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_photoOfDgHmr);
        mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmr = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_photoOfDgHmr);
        mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmrView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_photoOfDgHmrView);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingCondition = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_dgWorkingCondition);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewDgWorkingConditionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_dgWorkingConditionVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevel = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_coolentLevel);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewCoolentLevelVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_coolentLevelVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTension = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_beltTension);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewBeltTensionVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_beltTensionVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevel = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_engineLubeOilLevel);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewEngineLubeOilLevelVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_engineLubeOilLevelVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_safetyWorkingStatus);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewSafetyWorkingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_safetyWorkingStatusVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_powerCableConnectionStatus);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewPowerCableConnectionStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_powerCableConnectionStatusVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteDgCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteDgCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteDgCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteDgCheckPoints_button_nextReading);
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

                final EditText taskEditText = new EditText(PreventiveMaintenanceSiteDgCheckPointsActivity.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(PreventiveMaintenanceSiteDgCheckPointsActivity.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("SETTINGS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startInstalledAppDetailsActivity(PreventiveMaintenanceSiteDgCheckPointsActivity.this);
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

                final EditText taskEditText = new EditText(PreventiveMaintenanceSiteDgCheckPointsActivity.this);
                android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(PreventiveMaintenanceSiteDgCheckPointsActivity.this)
                        .setTitle("Permission")
                        .setMessage("Need Camera Access")
                        .setView(taskEditText)
                        .setPositiveButton("ALLOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(PreventiveMaintenanceSiteDgCheckPointsActivity.this,
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

            imageFileUri = FileProvider.getUriForFile(PreventiveMaintenanceSiteDgCheckPointsActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);

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
                    base64StringTakePhotoOfDgHmr = Base64.encodeToString(bitmapDataArray, Base64.DEFAULT);
                    mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmrView.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            imageFileName = "";
            imageFileUri = null;
            mPreventiveMaintenanceSiteDgCheckPointsButtonPhotoOfDgHmrView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.submit_icon_menu, menu);

        MenuItem shareItem = menu.findItem(R.id.menuSubmit);

        // show the button when some condition is true
        shareItem.setVisible(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuSubmit:
                startActivity(new Intent(this, PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.class));
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

package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import com.brahamaputra.mahindra.brahamaputra.Data.GeneralSafetyMeasuresData;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.LandDetailsData;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class GeneralAndSafetyMeasures extends BaseActivity {


    final Calendar myCalendar = Calendar.getInstance();

    String str_SiteBoundaryStatus;
    String str_SiteHygieneVegitationStatus;
    String str_GateLock;
    String str_DGRoomLock;
    String str_FireExtuinguisher;
    String str_FireExtuinguisherType;
    String str_FireBucket;
    String str_SecurityStatus24x7;
    String str_NoofSecurityPerson;
    String str_CaretakerStatusUpOnEmergency;
    String str_IsSecurityCaretakeristheOwnerofSite;
    String str_CaretakerSecuritySalaryPaidBy;
    String str_CaretakerSecurityStayinginSite;
    String str_NumberofEarthPit;
    String str_LightningArresterStatus;
    String str_FencingCompoundWallCondition;
    String str_NumberoffreeODPaltformAvailable;
    String str_AlarmMultipluxerStatus;
    String str_DoorOpenSensor;
    String str_FuelSensor;
    String str_FireSmokeSensor;


    private OfflineStorageWrapper offlineStorageWrapper;
    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";
    private HotoTransactionData hotoTransactionData;
    private GeneralSafetyMeasuresData generalSafetyMeasuresData;
    private SessionManager sessionManager;

    private TextView mGeneralAndSafetyMeasuresTextViewPrevailingSLA;
    private EditText mGeneralAndSafetyMeasuresEditTextPrevailingSLA;
    private TextView mGeneralAndSafetyMeasureTextViewSiteBoundaryStatus;
    private TextView mGeneralAndSafetyMeasureTextViewSiteBoundaryStatusVal;
    private TextView mGeneralAndSafetyMeasureTextViewSiteHygieneVegitationStatus;
    private TextView mGeneralAndSafetyMeasureTextViewSiteHygieneVegitationStatusVal;
    private TextView mGeneralAndSafetyMeasureTextViewGateLock;
    private TextView mGeneralAndSafetyMeasureTextViewGateLockVal;
    private TextView mGeneralAndSafetyMeasureTextViewDGRoomLock;
    private TextView mGeneralAndSafetyMeasureTextViewDGRoomLockVal;
    private TextView mGeneralAndSafetyMeasureTextViewFireExtuinguisher;
    private TextView mGeneralAndSafetyMeasureTextViewFireExtuinguisherVal;
    private TextView mGeneralAndSafetyMeasureTextViewFireExtuinguisherType;
    private TextView mGeneralAndSafetyMeasureTextViewFireExtuinguisherTypeVal;
    private TextView mGeneralAndSafetyMeasureTextViewFireExtuinguisherExpiryDate;
    private EditText mGeneralAndSafetyMeasureEditTextFireExtuinguisherExpiryDate;
    private TextView mGeneralAndSafetyMeasureTextViewFireBucket;
    private TextView mGeneralAndSafetyMeasureTextViewFireBucketVal;
    private TextView mGeneralAndSafetyMeasureTextViewSecurityStatus24x7;
    private TextView mGeneralAndSafetyMeasureTextViewSecurityStatus24x7Val;
    private TextView mGeneralAndSafetyMeasureTextViewNoofSecurityPerson;
    private TextView mGeneralAndSafetyMeasureTextViewNoofSecurityPersonVal;
    private TextView mGeneralAndSafetyMeasureTextViewMobileNumberofSecurity;
    private EditText mGeneralAndSafetyMeasureEditTextMobileNumberofSecurity;
    private TextView mGeneralAndSafetyMeasureTextViewCaretakerStatusUpOnEmergency;
    private TextView mGeneralAndSafetyMeasureTextViewCaretakerStatusUpOnEmergencyVal;
    private TextView mGeneralAndSafetyMeasureTextViewMobileNumberofCaretaker;
    private EditText mGeneralAndSafetyMeasureEditTextMobileNumberofCaretaker;
    private TextView mGeneralAndSafetyMeasureTextViewIsSecurityCaretakeristheOwnerofSite;
    private TextView mGeneralAndSafetyMeasureTextViewIsSecurityCaretakeristheOwnerofSiteVal;
    private TextView mGeneralAndSafetyMeasureTextViewSalaryofSecurityCaretaker;
    private EditText mGeneralAndSafetyMeasureEditTextSalaryofSecurityCaretaker;
    private TextView mGeneralAndSafetyMeasureTextViewCaretakerSecuritySalaryPaidBy;
    private TextView mGeneralAndSafetyMeasureTextViewCaretakerSecuritySalaryPaidByVal;
    private TextView mGeneralAndSafetyMeasureTextViewCaretakerSecurityStayinginSite;
    private TextView mGeneralAndSafetyMeasureTextViewCaretakerSecurityStayinginSiteVal;
    private TextView mGeneralAndSafetyMeasureTextViewNumberofEarthPit;
    private TextView mGeneralAndSafetyMeasureTextViewNumberofEarthPitVal;
    private TextView mGeneralAndSafetyMeasureTextViewLightningArresterStatusVal;
    private TextView mGeneralAndSafetyMeasureTextViewLightningArresterStatus;
    private TextView mGeneralAndSafetyMeasureTextViewFencingCompoundWallCondition;
    private TextView mGeneralAndSafetyMeasureTextViewFencingCompoundWallConditionVal;
    private TextView mGeneralAndSafetyMeasureTextViewNumberoffreeODPaltformAvailable;
    private TextView mGeneralAndSafetyMeasureTextViewNumberoffreeODPaltformAvailableVal;
    private TextView mGeneralAndSafetyMeasureTextViewAlarmMultipluxerStatus;
    private TextView mGeneralAndSafetyMeasureTextViewAlarmMultipluxerStatusVal;
    private TextView mGeneralAndSafetyMeasureTextViewDoorOpenSensor;
    private TextView mGeneralAndSafetyMeasureTextViewDoorOpenSensorVal;
    private TextView mGeneralAndSafetyMeasureTextViewFuelSensor;
    private TextView mGeneralAndSafetyMeasureTextViewFuelSensorVal;
    private TextView mGeneralAndSafetyMeasureTextViewFireSmokeSensor;
    private TextView mGeneralAndSafetyMeasureTextViewFireSmokeSensorVal;

    private void assignViews() {
        mGeneralAndSafetyMeasuresTextViewPrevailingSLA = (TextView) findViewById(R.id.generalAndSafetyMeasures_textView_PrevailingSLA);
        mGeneralAndSafetyMeasuresEditTextPrevailingSLA = (EditText) findViewById(R.id.generalAndSafetyMeasures_editText_PrevailingSLA);
        mGeneralAndSafetyMeasureTextViewSiteBoundaryStatus = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_SiteBoundaryStatus);
        mGeneralAndSafetyMeasureTextViewSiteBoundaryStatusVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_SiteBoundaryStatus_val);
        mGeneralAndSafetyMeasureTextViewSiteHygieneVegitationStatus = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_SiteHygieneVegitationStatus);
        mGeneralAndSafetyMeasureTextViewSiteHygieneVegitationStatusVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_SiteHygieneVegitationStatus_val);
        mGeneralAndSafetyMeasureTextViewGateLock = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_GateLock);
        mGeneralAndSafetyMeasureTextViewGateLockVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_GateLock_val);
        mGeneralAndSafetyMeasureTextViewDGRoomLock = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_DGRoomLock);
        mGeneralAndSafetyMeasureTextViewDGRoomLockVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_DGRoomLock_val);
        mGeneralAndSafetyMeasureTextViewFireExtuinguisher = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FireExtuinguisher);
        mGeneralAndSafetyMeasureTextViewFireExtuinguisherVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FireExtuinguisher_val);
        mGeneralAndSafetyMeasureTextViewFireExtuinguisherType = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FireExtuinguisherType);
        mGeneralAndSafetyMeasureTextViewFireExtuinguisherTypeVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FireExtuinguisherType_val);
        mGeneralAndSafetyMeasureTextViewFireExtuinguisherExpiryDate = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FireExtuinguisherExpiryDate);
        mGeneralAndSafetyMeasureEditTextFireExtuinguisherExpiryDate = (EditText) findViewById(R.id.generalAndSafetyMeasure_editText_FireExtuinguisherExpiryDate);
        mGeneralAndSafetyMeasureTextViewFireBucket = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FireBucket);
        mGeneralAndSafetyMeasureTextViewFireBucketVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FireBucket_val);
        mGeneralAndSafetyMeasureTextViewSecurityStatus24x7 = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_SecurityStatus24x7);
        mGeneralAndSafetyMeasureTextViewSecurityStatus24x7Val = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_SecurityStatus24x7_val);
        mGeneralAndSafetyMeasureTextViewNoofSecurityPerson = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_NoofSecurityPerson);
        mGeneralAndSafetyMeasureTextViewNoofSecurityPersonVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_NoofSecurityPerson_val);
        mGeneralAndSafetyMeasureTextViewMobileNumberofSecurity = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_MobileNumberofSecurity);
        mGeneralAndSafetyMeasureEditTextMobileNumberofSecurity = (EditText) findViewById(R.id.generalAndSafetyMeasure_editText_MobileNumberofSecurity);
        mGeneralAndSafetyMeasureTextViewCaretakerStatusUpOnEmergency = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_CaretakerStatusUpOnEmergency);
        mGeneralAndSafetyMeasureTextViewCaretakerStatusUpOnEmergencyVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_CaretakerStatusUpOnEmergency_val);
        mGeneralAndSafetyMeasureTextViewMobileNumberofCaretaker = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_MobileNumberofCaretaker);
        mGeneralAndSafetyMeasureEditTextMobileNumberofCaretaker = (EditText) findViewById(R.id.generalAndSafetyMeasure_editText_MobileNumberofCaretaker);
        mGeneralAndSafetyMeasureTextViewIsSecurityCaretakeristheOwnerofSite = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_IsSecurityCaretakeristheOwnerofSite);
        mGeneralAndSafetyMeasureTextViewIsSecurityCaretakeristheOwnerofSiteVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_IsSecurityCaretakeristheOwnerofSite_val);
        mGeneralAndSafetyMeasureTextViewSalaryofSecurityCaretaker = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_SalaryofSecurityCaretaker);
        mGeneralAndSafetyMeasureEditTextSalaryofSecurityCaretaker = (EditText) findViewById(R.id.generalAndSafetyMeasure_editText_SalaryofSecurityCaretaker);
        mGeneralAndSafetyMeasureTextViewCaretakerSecuritySalaryPaidBy = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_CaretakerSecuritySalaryPaidBy);
        mGeneralAndSafetyMeasureTextViewCaretakerSecuritySalaryPaidByVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_CaretakerSecuritySalaryPaidBy_val);
        mGeneralAndSafetyMeasureTextViewCaretakerSecurityStayinginSite = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_CaretakerSecurityStayinginSite);
        mGeneralAndSafetyMeasureTextViewCaretakerSecurityStayinginSiteVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_CaretakerSecurityStayinginSite_val);
        mGeneralAndSafetyMeasureTextViewNumberofEarthPit = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_NumberofEarthPit);
        mGeneralAndSafetyMeasureTextViewNumberofEarthPitVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_NumberofEarthPit_val);
        mGeneralAndSafetyMeasureTextViewLightningArresterStatus = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_LightningArresterStatus);
        mGeneralAndSafetyMeasureTextViewLightningArresterStatusVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_LightningArresterStatus_val);
        mGeneralAndSafetyMeasureTextViewFencingCompoundWallCondition = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FencingCompoundWallCondition);
        mGeneralAndSafetyMeasureTextViewFencingCompoundWallConditionVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FencingCompoundWallCondition_val);
        mGeneralAndSafetyMeasureTextViewNumberoffreeODPaltformAvailable = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_NumberoffreeODPaltformAvailable);
        mGeneralAndSafetyMeasureTextViewNumberoffreeODPaltformAvailableVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_NumberoffreeODPaltformAvailable_val);
        mGeneralAndSafetyMeasureTextViewAlarmMultipluxerStatus = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_AlarmMultipluxerStatus);
        mGeneralAndSafetyMeasureTextViewAlarmMultipluxerStatusVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_AlarmMultipluxerStatus_val);
        mGeneralAndSafetyMeasureTextViewDoorOpenSensor = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_DoorOpenSensor);
        mGeneralAndSafetyMeasureTextViewDoorOpenSensorVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_DoorOpenSensor_val);
        mGeneralAndSafetyMeasureTextViewFuelSensor = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FuelSensor);
        mGeneralAndSafetyMeasureTextViewFuelSensorVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FuelSensor_val);
        mGeneralAndSafetyMeasureTextViewFireSmokeSensor = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FireSmokeSensor);
        mGeneralAndSafetyMeasureTextViewFireSmokeSensorVal = (TextView) findViewById(R.id.generalAndSafetyMeasure_textView_FireSmokeSensor_val);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );


    }


    private void initCombo() {


        mGeneralAndSafetyMeasureTextViewSiteBoundaryStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_SiteBoundaryStatus))),
                        "Site Boundary Status",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_SiteBoundaryStatus = item.get(position);
                        mGeneralAndSafetyMeasureTextViewSiteBoundaryStatusVal.setText(str_SiteBoundaryStatus);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewSiteHygieneVegitationStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_SiteHygieneVegitationStatus))),
                        "Site Hygiene Vegitation Status",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_SiteHygieneVegitationStatus = item.get(position);
                        mGeneralAndSafetyMeasureTextViewSiteHygieneVegitationStatusVal.setText(str_SiteHygieneVegitationStatus);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewGateLockVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_GateLock))),
                        "Gate Lock",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_GateLock = item.get(position);
                        mGeneralAndSafetyMeasureTextViewGateLockVal.setText(str_GateLock);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewDGRoomLockVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_DGRoomLock))),
                        "DGRoom Lock",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_DGRoomLock = item.get(position);
                        mGeneralAndSafetyMeasureTextViewDGRoomLockVal.setText(str_DGRoomLock);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewFireExtuinguisherVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_FireExtuinguisher))),
                        "Fire Extuinguisher",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_FireExtuinguisher = item.get(position);
                        mGeneralAndSafetyMeasureTextViewFireExtuinguisherVal.setText(str_FireExtuinguisher);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewFireExtuinguisherTypeVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_FireExtuinguisherType))),
                        "Fire Extuinguisher Type",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_FireExtuinguisherType = item.get(position);
                        mGeneralAndSafetyMeasureTextViewFireExtuinguisherTypeVal.setText(str_FireExtuinguisherType);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewFireBucketVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_FireBucket))),
                        "Fire Bucket",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_FireBucket = item.get(position);
                        mGeneralAndSafetyMeasureTextViewFireBucketVal.setText(str_FireBucket);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewSecurityStatus24x7Val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_SecurityStatus24x7))),
                        "Security Status 24x7",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_SecurityStatus24x7 = item.get(position);
                        mGeneralAndSafetyMeasureTextViewSecurityStatus24x7Val.setText(str_SecurityStatus24x7);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewNoofSecurityPersonVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_NoofSecurityPerson))),
                        "No of Security Person",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_NoofSecurityPerson = item.get(position);
                        mGeneralAndSafetyMeasureTextViewNoofSecurityPersonVal.setText(str_NoofSecurityPerson);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewCaretakerStatusUpOnEmergencyVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_CaretakerStatusUpOnEmergency))),
                        "Caretaker Status Up On Emergency",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_CaretakerStatusUpOnEmergency = item.get(position);
                        mGeneralAndSafetyMeasureTextViewCaretakerStatusUpOnEmergencyVal.setText(str_CaretakerStatusUpOnEmergency);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewIsSecurityCaretakeristheOwnerofSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_IsSecurityCaretakeristheOwnerofSite))),
                        "Is Security Caretaker is the Owner of Site",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_IsSecurityCaretakeristheOwnerofSite = item.get(position);
                        mGeneralAndSafetyMeasureTextViewIsSecurityCaretakeristheOwnerofSiteVal.setText(str_IsSecurityCaretakeristheOwnerofSite);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewCaretakerSecuritySalaryPaidByVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_CaretakerSecuritySalaryPaidBy))),
                        "Caretaker Security Salary Paid By",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_CaretakerSecuritySalaryPaidBy = item.get(position);
                        mGeneralAndSafetyMeasureTextViewCaretakerSecuritySalaryPaidByVal.setText(str_CaretakerSecuritySalaryPaidBy);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewCaretakerSecurityStayinginSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_CaretakerSecurityStayinginSite))),
                        "Caretaker Security Staying in Site",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_CaretakerSecurityStayinginSite = item.get(position);
                        mGeneralAndSafetyMeasureTextViewCaretakerSecurityStayinginSiteVal.setText(str_CaretakerSecurityStayinginSite);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewNumberofEarthPitVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_NumberofEarthPit))),
                        "Number of EarthPit",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_NumberofEarthPit = item.get(position);
                        mGeneralAndSafetyMeasureTextViewNumberofEarthPitVal.setText(str_NumberofEarthPit);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewLightningArresterStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_LightningArresterStatus))),
                        "Lightning Arrester Status",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_LightningArresterStatus = item.get(position);
                        mGeneralAndSafetyMeasureTextViewLightningArresterStatusVal.setText(str_LightningArresterStatus);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewFencingCompoundWallConditionVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_FencingCompoundWallCondition))),
                        "Fencing Compound Wall Condition",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_FencingCompoundWallCondition = item.get(position);
                        mGeneralAndSafetyMeasureTextViewFencingCompoundWallConditionVal.setText(str_FencingCompoundWallCondition);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewNumberoffreeODPaltformAvailableVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_NumberoffreeODPaltformAvailable))),
                        "Number of free OD Paltform Available",
                        "Close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_NumberoffreeODPaltformAvailable = item.get(position);
                        mGeneralAndSafetyMeasureTextViewNumberoffreeODPaltformAvailableVal.setText(str_NumberoffreeODPaltformAvailable);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewAlarmMultipluxerStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_AlarmMultipluxerStatus))),
                        "Alarm Multipluxer Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_AlarmMultipluxerStatus = item.get(position);
                        mGeneralAndSafetyMeasureTextViewAlarmMultipluxerStatusVal.setText(str_AlarmMultipluxerStatus);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewDoorOpenSensorVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_DoorOpenSensor))),
                        "Door Open Sensors",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_DoorOpenSensor = item.get(position);
                        mGeneralAndSafetyMeasureTextViewDoorOpenSensorVal.setText(str_DoorOpenSensor);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewFuelSensorVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_FuelSensor))),
                        "Fuel Sensor",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_FuelSensor = item.get(position);
                        mGeneralAndSafetyMeasureTextViewFuelSensorVal.setText(str_FuelSensor);
                    }
                });

            }
        });
        mGeneralAndSafetyMeasureTextViewFireSmokeSensorVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(GeneralAndSafetyMeasures.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_generalAndSafetyMeasure_FireSmokeSensor))),
                        "Fire Smoke Sensor",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_FireSmokeSensor = item.get(position);
                        mGeneralAndSafetyMeasureTextViewFireSmokeSensorVal.setText(str_FireSmokeSensor);
                    }
                });

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_and_safety_measures);
        this.setTitle("GENERAL & SAFETY MEASURES");
        sessionManager = new SessionManager(GeneralAndSafetyMeasures.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(GeneralAndSafetyMeasures.this, userId, ticketName);
        assignViews();
        initCombo();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        hotoTransactionData = new HotoTransactionData();
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


        mGeneralAndSafetyMeasureEditTextFireExtuinguisherExpiryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(GeneralAndSafetyMeasures.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        submitDetails();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dropdown_details_menu, menu);
        return true;
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mGeneralAndSafetyMeasureEditTextFireExtuinguisherExpiryDate.setText(sdf.format(myCalendar.getTime()));
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
                startActivity(new Intent(this, ACDB_DCDB.class));
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
                generalSafetyMeasuresData = hotoTransactionData.getGeneralSafetyMeasuresData();


                mGeneralAndSafetyMeasuresEditTextPrevailingSLA.setText(generalSafetyMeasuresData.getPrevailingSLA());
                mGeneralAndSafetyMeasureTextViewSiteBoundaryStatusVal.setText(generalSafetyMeasuresData.getSiteBoundaryStatus());
                mGeneralAndSafetyMeasureTextViewSiteHygieneVegitationStatusVal.setText(generalSafetyMeasuresData.getSiteHygieneVegitationStatus());
                mGeneralAndSafetyMeasureTextViewGateLockVal.setText(generalSafetyMeasuresData.getGateLock());
                mGeneralAndSafetyMeasureTextViewDGRoomLockVal.setText(generalSafetyMeasuresData.getDgRoomLock());
                mGeneralAndSafetyMeasureTextViewFireExtuinguisherVal.setText(generalSafetyMeasuresData.getFireExtuinguisher());
                mGeneralAndSafetyMeasureTextViewFireExtuinguisherTypeVal.setText(generalSafetyMeasuresData.getFireExtuinguisherType());
                mGeneralAndSafetyMeasureEditTextFireExtuinguisherExpiryDate.setText(generalSafetyMeasuresData.getFireExtuinguisherExpiryDate());
                mGeneralAndSafetyMeasureTextViewFireBucketVal.setText(generalSafetyMeasuresData.getFireBucket());
                mGeneralAndSafetyMeasureTextViewSecurityStatus24x7Val.setText(generalSafetyMeasuresData.getSecurityStatus());
                mGeneralAndSafetyMeasureTextViewNoofSecurityPersonVal.setText(generalSafetyMeasuresData.getNoofSecurityPerson());
                mGeneralAndSafetyMeasureEditTextMobileNumberofSecurity.setText(generalSafetyMeasuresData.getMobileNumberofSecurity());
                mGeneralAndSafetyMeasureTextViewCaretakerStatusUpOnEmergencyVal.setText(generalSafetyMeasuresData.getCaretakerStatusUpOnEmergency());
                mGeneralAndSafetyMeasureEditTextMobileNumberofCaretaker.setText(generalSafetyMeasuresData.getMobileNumberofCaretaker());
                mGeneralAndSafetyMeasureTextViewIsSecurityCaretakeristheOwnerofSiteVal.setText(generalSafetyMeasuresData.getIsSecurityCaretakeristheOwnerofSite());
                mGeneralAndSafetyMeasureEditTextSalaryofSecurityCaretaker.setText(generalSafetyMeasuresData.getSalaryofSecurityCaretaker());
                mGeneralAndSafetyMeasureTextViewCaretakerSecuritySalaryPaidByVal.setText(generalSafetyMeasuresData.getCaretakerSecuritySalaryPaidBy());
                mGeneralAndSafetyMeasureTextViewCaretakerSecurityStayinginSiteVal.setText(generalSafetyMeasuresData.getCaretakerSecurityStayinginSite());
                mGeneralAndSafetyMeasureTextViewNumberofEarthPitVal.setText(generalSafetyMeasuresData.getNumberofEarthPit());
                mGeneralAndSafetyMeasureTextViewLightningArresterStatusVal.setText(generalSafetyMeasuresData.getLightningArresterStatus());
                mGeneralAndSafetyMeasureTextViewFencingCompoundWallConditionVal.setText(generalSafetyMeasuresData.getFencingCompoundWallCondition());
                mGeneralAndSafetyMeasureTextViewNumberoffreeODPaltformAvailableVal.setText(generalSafetyMeasuresData.getNumberoffreeODPaltformAvailable());
                mGeneralAndSafetyMeasureTextViewAlarmMultipluxerStatusVal.setText(generalSafetyMeasuresData.getAlarmMultipluxerStatus());
                mGeneralAndSafetyMeasureTextViewDoorOpenSensorVal.setText(generalSafetyMeasuresData.getDoorOpenSensor());
                mGeneralAndSafetyMeasureTextViewFuelSensorVal.setText(generalSafetyMeasuresData.getFuelSensor());
                mGeneralAndSafetyMeasureTextViewFireSmokeSensorVal.setText(generalSafetyMeasuresData.getFireSmokeSensor());


            } else {
                Toast.makeText(GeneralAndSafetyMeasures.this, "No previous saved data available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitDetails() {
        try {
            // hotoTransactionData.setTicketNo(ticketId);


            String prevailingSLA = mGeneralAndSafetyMeasuresEditTextPrevailingSLA.getText().toString().trim();
            String siteBoundaryStatus = mGeneralAndSafetyMeasureTextViewSiteBoundaryStatusVal.getText().toString().trim();
            String siteHygieneVegitationStatus = mGeneralAndSafetyMeasureTextViewSiteHygieneVegitationStatusVal.getText().toString().trim();
            String gateLock = mGeneralAndSafetyMeasureTextViewGateLockVal.getText().toString().trim();
            String dgRoomLock = mGeneralAndSafetyMeasureTextViewDGRoomLockVal.getText().toString().trim();
            String fireExtuinguisher = mGeneralAndSafetyMeasureTextViewFireExtuinguisherVal.getText().toString().trim();
            String fireExtuinguisherType = mGeneralAndSafetyMeasureTextViewFireExtuinguisherTypeVal.getText().toString().trim();
            String fireExtuinguisherExpiryDate = mGeneralAndSafetyMeasureEditTextFireExtuinguisherExpiryDate.getText().toString().trim();
            String fireBucket = mGeneralAndSafetyMeasureTextViewFireBucketVal.getText().toString().trim();
            String securityStatus = mGeneralAndSafetyMeasureTextViewSecurityStatus24x7Val.getText().toString().trim();
            String noofSecurityPerson = mGeneralAndSafetyMeasureTextViewNoofSecurityPersonVal.getText().toString().trim();
            String mobileNumberofSecurity = mGeneralAndSafetyMeasureEditTextMobileNumberofSecurity.getText().toString().trim();
            String caretakerStatusUpOnEmergency = mGeneralAndSafetyMeasureTextViewCaretakerStatusUpOnEmergencyVal.getText().toString().trim();
            String mobileNumberofCaretaker = mGeneralAndSafetyMeasureEditTextMobileNumberofCaretaker.getText().toString().trim();
            String isSecurityCaretakeristheOwnerofSite = mGeneralAndSafetyMeasureTextViewIsSecurityCaretakeristheOwnerofSiteVal.getText().toString().trim();
            String salaryofSecurityCaretaker = mGeneralAndSafetyMeasureEditTextSalaryofSecurityCaretaker.getText().toString().trim();
            String caretakerSecuritySalaryPaidBy = mGeneralAndSafetyMeasureTextViewCaretakerSecuritySalaryPaidByVal.getText().toString().trim();
            String caretakerSecurityStayinginSite = mGeneralAndSafetyMeasureTextViewCaretakerSecurityStayinginSiteVal.getText().toString().trim();
            String numberofEarthPit = mGeneralAndSafetyMeasureTextViewNumberofEarthPitVal.getText().toString().trim();
            String lightningArresterStatus = mGeneralAndSafetyMeasureTextViewLightningArresterStatusVal.getText().toString().trim();
            String fencingCompoundWallCondition = mGeneralAndSafetyMeasureTextViewFencingCompoundWallConditionVal.getText().toString().trim();
            String numberoffreeODPaltformAvailable = mGeneralAndSafetyMeasureTextViewNumberoffreeODPaltformAvailableVal.getText().toString().trim();
            String alarmMultipluxerStatus = mGeneralAndSafetyMeasureTextViewAlarmMultipluxerStatusVal.getText().toString().trim();
            String doorOpenSensor = mGeneralAndSafetyMeasureTextViewDoorOpenSensorVal.getText().toString().trim();
            String fuelSensor = mGeneralAndSafetyMeasureTextViewFuelSensorVal.getText().toString().trim();
            String fireSmokeSensor = mGeneralAndSafetyMeasureTextViewFireSmokeSensorVal.getText().toString().trim();

            generalSafetyMeasuresData = new GeneralSafetyMeasuresData(prevailingSLA, siteBoundaryStatus, siteHygieneVegitationStatus, gateLock, dgRoomLock, fireExtuinguisher, fireExtuinguisherType, fireExtuinguisherExpiryDate, fireBucket, securityStatus, noofSecurityPerson, mobileNumberofSecurity, caretakerStatusUpOnEmergency, mobileNumberofCaretaker, isSecurityCaretakeristheOwnerofSite, salaryofSecurityCaretaker, caretakerSecuritySalaryPaidBy, caretakerSecurityStayinginSite, numberofEarthPit, lightningArresterStatus, fencingCompoundWallCondition, numberoffreeODPaltformAvailable, alarmMultipluxerStatus, doorOpenSensor, fuelSensor, fireSmokeSensor);

            hotoTransactionData.setGeneralSafetyMeasuresData(generalSafetyMeasuresData);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(hotoTransactionData);
            //Toast.makeText(Land_Details.this, "Gson to json string :" + jsonString, Toast.LENGTH_SHORT).show();

            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

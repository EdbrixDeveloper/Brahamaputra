package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.abdeveloper.library.MultiSelectDialog;
import com.abdeveloper.library.MultiSelectModel;
import com.brahamaputra.mahindra.brahamaputra.Data.EarthingCheckPointsData;
import com.brahamaputra.mahindra.brahamaputra.Data.EarthingCheckPointsParentData;
import com.brahamaputra.mahindra.brahamaputra.Data.PreventiveMaintanceSiteTransactionDetails;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreventiveMaintenanceSiteEarthingCheckPointsActivity extends BaseActivity {

    private static final String TAG = PreventiveMaintenanceSiteEarthingCheckPointsActivity.class.getSimpleName();

    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntact;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntactVal;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatus;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatusVal;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatus;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatusVal;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPit;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisible;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal;

    private LinearLayout mLinearLayoutContainer;

    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewEarthingPitNumber;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewEarthPitValue;
    private EditText mPreventiveMaintenanceSiteEarthingCheckPointsEditTextEarthPitValue;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFault;
    private TextView mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal;

    private Button mPreventiveMaintenanceSiteEarthingCheckPointsButtonPreviousReading;
    private Button mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading;

    String str_pmSiteEcpAllNutOrBoltsAreIntactVal = "";
    String str_pmSiteEcpIgbOrOgbStatusVal = "";
    String str_pmSiteEcpLightningArresterStatusVal = "";

    String str_pmSiteEcpNumberOfEarthPitVal = "";
    String str_pmSiteEcpNumberOfEarthPitVisibleVal = "";

    String str_pmSiteEcpRegisterFaultVal = "";
    String str_pmSiteEcpTypeOfFaultVal = "";


    private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;
    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    private PreventiveMaintanceSiteTransactionDetails pmSiteTransactionDetails;
    private ArrayList<EarthingCheckPointsData> earthingCheckPointsData;// replce airConditionersData

    private AlertDialogManager alertDialogManager;
    private EarthingCheckPointsParentData dataList;

    private int totalAcCount = 0;
    private int currentPos = 0;

    MultiSelectDialog multiSelectDialog;
    ArrayList<MultiSelectModel> listOfFaultsTypes;
    ArrayList<Integer> alreadySelectedTypeOfFaultList;
    ArrayList<String> typeOfFaultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_earthing_check_points);
        this.setTitle("Earthing Check Points");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();
        //////////////////////////////

        pmSiteTransactionDetails = new PreventiveMaintanceSiteTransactionDetails();
        sessionManager = new SessionManager(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this, userId, ticketName);

        //dataList = new ArrayList<>();
        earthingCheckPointsData = new ArrayList<>();
        currentPos = 0;

        listOfFaultsTypes = new ArrayList<>();
        alreadySelectedTypeOfFaultList = new ArrayList<>();

        //Code For MultiSelect Type Of Fault
        typeOfFaultList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_typeOfFault)));
        int id = 1;
        for (int i = 0; i < typeOfFaultList.size(); i++) {
            listOfFaultsTypes.add(new MultiSelectModel(id, typeOfFaultList.get(i).toString()));
            id++;
        }

        setInputDetails(currentPos);
        invalidateOptionsMenu();
        setMultiSelectModel();

    }

    private void assignViews() {
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntact = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_allNutOrBoltsAreIntact);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntactVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_allNutOrBoltsAreIntactVal);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_igbOrOgbStatus);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_igbOrOgbStatusVal);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_lightningArresterStatus);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_lightningArresterStatusVal);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPit = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_numberOfEarthPit);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_numberOfEarthPitVal);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisible = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_numberOfEarthPitVisible);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_numberOfEarthPitVisibleVal);
        mLinearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayout_container);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewEarthingPitNumber = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_earthingPitNumber);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewEarthPitValue = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_earthPitValue);
        mPreventiveMaintenanceSiteEarthingCheckPointsEditTextEarthPitValue = (EditText) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_editText_earthPitValue);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_registerFault);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_registerFaultVal);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_typeOfFault);
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_textView_typeOfFaultVal);
        mPreventiveMaintenanceSiteEarthingCheckPointsButtonPreviousReading = (Button) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_button_previousReading);
        mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading = (Button) findViewById(R.id.preventiveMaintenanceSiteEarthingCheckPoints_button_nextReading);
    }

    private void setInputDetails(int index) {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");

                Gson gson = new Gson();

                pmSiteTransactionDetails = gson.fromJson(jsonInString, PreventiveMaintanceSiteTransactionDetails.class);
                dataList = pmSiteTransactionDetails.getEarthingCheckPointsParentData();
                earthingCheckPointsData.addAll(dataList.getEarthingCheckPointsData());

                mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntactVal.setText(dataList.getAllNutBoltsAreIntact());
                mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatusVal.setText(dataList.getIgbOgbStatus());
                mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatusVal.setText(dataList.getLightningArresterStatus());
                mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal.setText(dataList.getNumberOfEarthPit());
                mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.setText(dataList.getNumberOfEarthPitVisible());

                str_pmSiteEcpNumberOfEarthPitVal = dataList.getNumberOfEarthPit();
                invalidateOptionsMenu();

                /*mAirConditionersLinearLayoutNumberOfACInWorkingCondition.setVisibility(View.GONE);
                if (!dataList.getNumberOfEarthPitVisible().isEmpty() && dataList.getNumberOfEarthPitVisible() != null) {
                    mAirConditionersLinearLayoutNumberOfACInWorkingCondition.setVisibility(View.VISIBLE);
                }
                mAirConditionersTextViewNumberOfACInWorkingConditionVal.setText(dataList.getNumberOfEarthPitVisible());*/


                if (earthingCheckPointsData != null && earthingCheckPointsData.size() > 0) {
                    mLinearLayoutContainer.setVisibility(View.VISIBLE);
                    mPreventiveMaintenanceSiteEarthingCheckPointsTextViewEarthingPitNumber.setText("Reading: #1");
                    totalAcCount = Integer.parseInt(dataList.getNumberOfEarthPit());


                    mPreventiveMaintenanceSiteEarthingCheckPointsEditTextEarthPitValue.setText(earthingCheckPointsData.get(index).getEarthPitValue());
                    mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFaultVal.setText(earthingCheckPointsData.get(index).getRegisterFault());
                    mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal.setText(earthingCheckPointsData.get(index).getTypeOfFault());

                    if (earthingCheckPointsData.get(index).getTypeOfFault() != null && earthingCheckPointsData.get(index).getTypeOfFault().length() > 0 && listOfFaultsTypes.size() > 0) {

                        //setArrayValuesOfTypeOfFault(earthingCheckPointsData.get(index).getTypeOfFault());
                        setArrayValuesOfTypeOfFault(mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal.getText().toString().trim());
                    }

                    mPreventiveMaintenanceSiteEarthingCheckPointsButtonPreviousReading.setVisibility(View.GONE);
                    mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading.setVisibility(View.VISIBLE);

                    //if (airConditionersData.size() > 1) {
                    if (totalAcCount > 1) {
                        mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading.setText("Next Reading");
                    } else {
                        mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading.setText("Finish");
                    }
                }

            } else {
                showToast("No previous saved data available");
                mLinearLayoutContainer.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void setMultiSelectModel() {
        //MultiSelectModel
        multiSelectDialog = new MultiSelectDialog()
                .title("Type of Fault") //setting title for dialog
                .titleSize(25)
                .positiveText("Done")
                .negativeText("Cancel")
                .preSelectIDsList(alreadySelectedTypeOfFaultList)
                .setMinSelectionLimit(0)
                .setMaxSelectionLimit(typeOfFaultList.size())
                //List of ids that you need to be selected
                .multiSelectList(listOfFaultsTypes) // the multi select model list with ids and name
                .onSubmit(new MultiSelectDialog.SubmitCallbackListener() {
                    @Override
                    public void onSelected(ArrayList<Integer> selectedIds, ArrayList<String> selectedNames, String dataString) {
                        //will return list of selected IDS
                        str_pmSiteEcpTypeOfFaultVal = dataString;
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteEcpTypeOfFaultVal);
                        //str_pmSiteEbmbTypeOfFaultVal = dataString;
                        //mPreventiveMaintenanceSiteEbMeterBoxTextViewTypeOfFaultVal.setText(str_pmSiteEbmbTypeOfFaultVal);
                    }

                    @Override
                    public void onCancel() {
                        Log.d(TAG, "Dialog cancelled");
                    }
                });
    }

    private void setArrayValuesOfTypeOfFault(String TypeOfFault) {

        if (!TypeOfFault.isEmpty() && TypeOfFault != null) {
            List<String> items = Arrays.asList(TypeOfFault.split("\\s*,\\s*"));
            for (String ss : items) {
                for (MultiSelectModel c : listOfFaultsTypes) {
                    if (ss.equals(c.getName())) {
                        alreadySelectedTypeOfFaultList.add(c.getId());
                        break;
                    }
                }
            }
        }
    }

    private void initCombo() {
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntactVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_allNutOrBoltsAreIntact))),
                        "All Nut/Bolts are Intact",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpAllNutOrBoltsAreIntactVal = item.get(position);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntactVal.setText(str_pmSiteEcpAllNutOrBoltsAreIntactVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_igbOrOgbStatus))),
                        "IGB/OGB Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpIgbOrOgbStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatusVal.setText(str_pmSiteEcpIgbOrOgbStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_lightningArresterStatus))),
                        "Lightning Arrester Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpLightningArresterStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatusVal.setText(str_pmSiteEcpLightningArresterStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_noOfEarthPit))),
                        "Number of Earth PIT",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position)
                    {

                        //str_pmSiteEcpNumberOfEarthPitVal = item.get(position);
                        //mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal.setText(str_pmSiteEcpNumberOfEarthPitVal);
                        /////////////////

                        str_pmSiteEcpNumberOfEarthPitVal = item.get(position);
                        invalidateOptionsMenu();
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal.setText(str_pmSiteEcpNumberOfEarthPitVal);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.setText("");//008

                        if (earthingCheckPointsData != null && earthingCheckPointsData.size() > 0) {
                            earthingCheckPointsData.clear();
                        }
                        currentPos = 0;
                        totalAcCount = 0;
                        clearFields(currentPos);

                        // Clear all field value and hide layout If Non AC or O //
                        if (str_pmSiteEcpNumberOfEarthPitVal.equals("0")) {
                            mLinearLayoutContainer.setVisibility(View.GONE);
                            //mAirConditionersLinearLayoutNumberOfACInWorkingCondition.setVisibility(View.GONE);
                        } else {
                            totalAcCount = Integer.parseInt(str_pmSiteEcpNumberOfEarthPitVal);
                            mPreventiveMaintenanceSiteEarthingCheckPointsTextViewEarthingPitNumber.setText("Reading: #1");
                            mLinearLayoutContainer.setVisibility(View.VISIBLE);
                            //mAirConditionersLinearLayoutNumberOfACInWorkingCondition.setVisibility(View.VISIBLE);
                            mPreventiveMaintenanceSiteEarthingCheckPointsButtonPreviousReading.setVisibility(View.GONE);
                            mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading.setVisibility(View.VISIBLE);
                            if (totalAcCount > 0 && totalAcCount == 1) {
                                mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading.setText("Finish");
                            } else {
                                mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading.setText("Next Reading");
                            }
                        }


                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_noOfEarthPitVisible))),
                        "Number of Earth PIT Visible",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpNumberOfEarthPitVisibleVal = item.get(position);
                        //mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.setText(str_pmSiteEcpNumberOfEarthPitVisibleVal);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.setText("");
                        if (checkValidationOnChangeNoOfEarthPitValue(mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal.getText().toString().trim(), str_pmSiteEcpNumberOfEarthPitVisibleVal, "onClick") == true) {
                            mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.setText(str_pmSiteEcpNumberOfEarthPitVisibleVal);
                        }

                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpRegisterFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFaultVal.setText(str_pmSiteEcpRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiSelectDialog.show(getSupportFragmentManager(), "multiSelectDialog");
                /*SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteEarthingCheckPoints_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteEcpTypeOfFaultVal = item.get(position);
                        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal.setText(str_pmSiteEcpTypeOfFaultVal);
                    }
                });*/
            }
        });


        ////////////////////////////////

        mPreventiveMaintenanceSiteEarthingCheckPointsButtonPreviousReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidationOfArrayFields() == true) {
                    if (currentPos > 0) {
                        //Save current ac reading
                        saveEartPitRecords(currentPos);
                        currentPos = currentPos - 1;
                        //move to Next reading
                        displayEartPitRecords(currentPos);
                    }
                }
            }
        });
        mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidationOfArrayFields() == true) {
                    if (currentPos < (totalAcCount - 1)) {
                        //Save current ac reading
                        saveEartPitRecords(currentPos);
                        currentPos = currentPos + 1;
                        //move to Next reading
                        displayEartPitRecords(currentPos);
                    } else if (currentPos == (totalAcCount - 1)) {
                        saveEartPitRecords(currentPos);
                        if (checkValidationOnChangeNoOfEarthPitValue(mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal.getText().toString().trim(), mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.getText().toString().trim(), "onSubmit") == true) {
                            submitDetails();
                            startActivity(new Intent(PreventiveMaintenanceSiteEarthingCheckPointsActivity.this, PreventiveMaintenanceSiteEbMeterBoxActivity.class));
                            finish();
                        }
                    }
                }
            }
        });

    }

    public boolean checkValidationOfArrayFields() {

        String earthPitValue = mPreventiveMaintenanceSiteEarthingCheckPointsEditTextEarthPitValue.getText().toString().trim();
        String registerFault = mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFaultVal.getText().toString().trim();
        String typeOfFault = mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal.getText().toString().trim();

        if (earthPitValue.isEmpty() || earthPitValue == null) {
            showToast("Please Enter Earth Pit Value");
            return false;
        } else if (registerFault.isEmpty() || registerFault == null) {
            showToast("Select Register Fault");
            return false;
        } else if (typeOfFault.isEmpty() || typeOfFault == null) {
            showToast("Select Type of Fault");
            return false;
        } else return true;

    }

    private void saveEartPitRecords(int pos) {

        String earthPitValue = mPreventiveMaintenanceSiteEarthingCheckPointsEditTextEarthPitValue.getText().toString().trim();
        String registerFault = mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFaultVal.getText().toString().trim();
        String typeOfFault = mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal.getText().toString().trim();

        EarthingCheckPointsData earthingCheckPointsChild = new EarthingCheckPointsData(earthPitValue, registerFault, typeOfFault);

        if (earthingCheckPointsData.size() > 0) {
            if (pos == earthingCheckPointsData.size()) {
                earthingCheckPointsData.add(earthingCheckPointsChild);
            } else if (pos < earthingCheckPointsData.size()) {
                earthingCheckPointsData.set(pos, earthingCheckPointsChild);
            }
        } else {
            earthingCheckPointsData.add(earthingCheckPointsChild);
        }
    }

    private void displayEartPitRecords(int pos) {

        if (earthingCheckPointsData.size() > 0 && pos < earthingCheckPointsData.size()) {

            mPreventiveMaintenanceSiteEarthingCheckPointsTextViewEarthingPitNumber.setText("Reading: #" + (pos + 1));

            mPreventiveMaintenanceSiteEarthingCheckPointsEditTextEarthPitValue.setText(earthingCheckPointsData.get(pos).getEarthPitValue());
            mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFaultVal.setText(earthingCheckPointsData.get(pos).getRegisterFault());
            mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal.setText(earthingCheckPointsData.get(pos).getTypeOfFault());

            if (earthingCheckPointsData.get(pos).getTypeOfFault() != null && earthingCheckPointsData.get(pos).getTypeOfFault().length() > 0 && listOfFaultsTypes.size() > 0) {
                alreadySelectedTypeOfFaultList=new ArrayList<>();
                //setArrayValuesOfTypeOfFault(earthingCheckPointsData.get(pos).getTypeOfFault());
                setArrayValuesOfTypeOfFault(mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal.getText().toString().trim());
                setMultiSelectModel();
            }

            mPreventiveMaintenanceSiteEarthingCheckPointsButtonPreviousReading.setVisibility(View.VISIBLE);
            mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading.setVisibility(View.VISIBLE);

        } else {
            clearFields(pos);
        }

        if (pos > 0 && pos < (totalAcCount - 1)) {
            mPreventiveMaintenanceSiteEarthingCheckPointsButtonPreviousReading.setVisibility(View.VISIBLE);
            mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading.setText("Next Reading");
        } else if (pos > 0 && pos == (totalAcCount - 1)) {
            mPreventiveMaintenanceSiteEarthingCheckPointsButtonPreviousReading.setVisibility(View.VISIBLE);
            mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading.setText("Finish");
        } else if (pos == 0) {
            mPreventiveMaintenanceSiteEarthingCheckPointsButtonPreviousReading.setVisibility(View.GONE);
            if (pos == (totalAcCount - 1)) {
                mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading.setText("Finish");
            } else {
                mPreventiveMaintenanceSiteEarthingCheckPointsButtonNextReading.setText("Next Reading");
            }
        }

    }

    private void submitDetails() {
        try {

            String allNutBoltsAreIntact = mPreventiveMaintenanceSiteEarthingCheckPointsTextViewAllNutOrBoltsAreIntactVal.getText().toString().trim();
            String igbOgbStatus = mPreventiveMaintenanceSiteEarthingCheckPointsTextViewIgbOrOgbStatusVal.getText().toString().trim();
            String lightningArresterStatus = mPreventiveMaintenanceSiteEarthingCheckPointsTextViewLightningArresterStatusVal.getText().toString().trim();
            String numberOfEarthPit = mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal.getText().toString().trim();
            String numberOfEarthPitVisible = mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.getText().toString().trim();

            dataList = new EarthingCheckPointsParentData(allNutBoltsAreIntact, igbOgbStatus,
                    lightningArresterStatus, numberOfEarthPit, numberOfEarthPitVisible, earthingCheckPointsData);

            pmSiteTransactionDetails.setEarthingCheckPointsParentData(dataList);

            Gson gson2 = new GsonBuilder().create();
            String jsonString = gson2.toJson(pmSiteTransactionDetails);

            offlineStorageWrapper.saveObjectToFile(ticketName + ".txt", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearFields(int indexPos) {

        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewEarthingPitNumber.setText("Reading: #" + (indexPos + 1));

        mPreventiveMaintenanceSiteEarthingCheckPointsEditTextEarthPitValue.setText("");
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewRegisterFaultVal.setText("");
        mPreventiveMaintenanceSiteEarthingCheckPointsTextViewTypeOfFaultVal.setText("");
        alreadySelectedTypeOfFaultList=new ArrayList<>();

    }

    public boolean checkValidationOnChangeNoOfEarthPitValue(String noOfEarthPitValue, String noOfEarthPitValueVisible, String methodFlag) {

        if (noOfEarthPitValue.isEmpty() || noOfEarthPitValue == null) {
            showToast("Select No of Earth Pit");
            return false;
        } else if (Integer.valueOf(noOfEarthPitValueVisible) > 0) {
            if (noOfEarthPitValueVisible.isEmpty() || noOfEarthPitValueVisible == null) {
                showToast("Select Number of Earth Pit Visible");
                return false;
            } else if (Integer.valueOf(noOfEarthPitValueVisible) > Integer.valueOf(noOfEarthPitValue)) {
                showToast("Select Earth Pit Visible is less than or equal to Earth Pit");
                return false;
            } else if ((earthingCheckPointsData.size() != Integer.valueOf(noOfEarthPitValue) && methodFlag.equals("onSubmit"))) {
                showToast("Complete the all readings.");//as a mentioned AC in no of AC provided
                return false;
            } else return true;
        } else return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.submit_icon_menu, menu);

        MenuItem shareItem = menu.findItem(R.id.menuSubmit);

        // show the button when some condition is true
        shareItem.setVisible(true);
        if (str_pmSiteEcpNumberOfEarthPitVal != null && !str_pmSiteEcpNumberOfEarthPitVal.isEmpty()) {
            if (Integer.valueOf(str_pmSiteEcpNumberOfEarthPitVal) > 0) {
                shareItem.setVisible(false);
            }
        }

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
                str_pmSiteEcpNumberOfEarthPitVal = mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal.getText().toString();

                if (str_pmSiteEcpNumberOfEarthPitVal == null || str_pmSiteEcpNumberOfEarthPitVal.equals("")) {
                    showToast("Please select no of earth pit");
                } else {
                    if (checkValidationOnChangeNoOfEarthPitValue(mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVal.getText().toString().trim(), mPreventiveMaintenanceSiteEarthingCheckPointsTextViewNumberOfEarthPitVisibleVal.getText().toString().trim(), "onSubmit") == true) {
                        submitDetails();
                        startActivity(new Intent(this, PreventiveMaintenanceSiteEbMeterBoxActivity.class));
                        finish();
                    }
                }

                //startActivity(new Intent(this, PreventiveMaintenanceSiteEbMeterBoxActivity.class));
                //finish();
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

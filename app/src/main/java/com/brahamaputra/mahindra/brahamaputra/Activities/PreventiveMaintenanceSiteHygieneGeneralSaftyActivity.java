package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.helper.OnSpinnerItemClick;
import com.brahamaputra.mahindra.brahamaputra.helper.SearchableSpinnerDialog;

import java.util.ArrayList;
import java.util.Arrays;

public class PreventiveMaintenanceSiteHygieneGeneralSaftyActivity extends BaseActivity {

    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaning;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUploadPhotoOfSitePremises;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremises;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremisesView;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaning;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaningVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTower;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTowerVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatus;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablityVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablityVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablityVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablityVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherExpiryDate;
    private EditText mLandDetailsEditTextDateOfvalidityOfAgreement;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablity;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablityVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCautionSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhotoView;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewWarningSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhotoView;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDangerSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhoto;
    private ImageView mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhotoView;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendar;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendarVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSite;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSiteVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFault;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFault;
    private TextView mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal;

    String str_pmSitePremisesCleaningVal = "";
    String str_pmSiteanyEagleOrCrowOrHoneyHivesInTowerVal = "";
    String str_pmSiteCompoundWallOrFencingStatusVal = "";
    String str_pmSiteGateLockAvailablityVal = "";
    String str_pmSiteShelterLockAvailablityVal = "";
    String str_pmSiteDgLockAvailablityVal = "";
    String str_pmSiteFireExtinguisherAvilabilityVal = "";
    String str_pmSiteNoOfFireExtinguisherVal = "";
    String str_pmSiteFireBucketVal = "";
    String str_pmSiteSafetyChartsAndCalendarVal = "";
    String str_pmSiteUnusedMaterialInSiteVal  = "";
    String str_pmSiteRegisterFaultVal = "";
    String str_pmSiteTypeOfFaultVal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_hygiene_general_safty);
        setTitle("Site Hygiene-General Safety Parameters");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assignViews();
        initCombo();
    }

    private void assignViews() {
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_sitePremisesCleaning);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_sitePremisesCleaningVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUploadPhotoOfSitePremises = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_uploadPhotoOfSitePremises);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremises = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_uploadPhotoOfSitePremises);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonUploadPhotoOfSitePremisesView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_uploadPhotoOfSitePremisesView);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaning = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_equipmentCleaning);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaningVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_equipmentCleaningVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTower = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_anyHivesInTower);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTowerVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_anyHivesInTowerVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatus = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_compoundWallFencingStatus);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_compoundWallFencingStatusVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_gateLockAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_gateLockAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_shelterLockAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_shelterLockAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_dgLockAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_dgLockAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireExtingisherAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireExtingisherAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_noOfFireExtingisherAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_noOfFireExtingisherAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherExpiryDate = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireExtingisherExpiryDate);
        mLandDetailsEditTextDateOfvalidityOfAgreement = (EditText) findViewById(R.id.landDetails_editText_dateOfvalidityOfAgreement);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablity = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireBucketAvailablity);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablityVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_fireBucketAvailablityVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCautionSignBoardPhoto = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_cautionSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhoto = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_cautionSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonCautionSignBoardPhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_cautionSignBoardPhotoView);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewWarningSignBoardPhoto = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_warningSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhoto = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_warningSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonWarningSignBoardPhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_warningSignBoardPhotoView);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDangerSignBoardPhoto = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_dangerSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhoto = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_dangerSignBoardPhoto);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyButtonDangerSignBoardPhotoView = (ImageView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_button_dangerSignBoardPhotoView);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendar = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_safetyChartsAndCalendar);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendarVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_safetyChartsAndCalendarVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSite = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_unusedMaterialInSite);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSiteVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_unusedMaterialInSiteVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_registerFault);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_registerFaultVal);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFault = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_typesOfFault);
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal = (TextView) findViewById(R.id.preventiveMaintenanceSiteHygieneGeneralSafty_textView_typesOfFaultVal);
    }


    private void initCombo() {
        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_sitePremisesCleaning))),
                        "Site Premises Cleaning",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSitePremisesCleaningVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSitePremisesCleaningVal.setText(str_pmSitePremisesCleaningVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaningVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_equipmentCleaning))),
                        "Equipment Cleaning",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteanyEagleOrCrowOrHoneyHivesInTowerVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewEquipmentCleaningVal.setText(str_pmSiteanyEagleOrCrowOrHoneyHivesInTowerVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTowerVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_anyEagleOrCrowOrHoneyHivesInTower))),
                        "Any Eagle/Crow/Honey Hives in Tower",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteanyEagleOrCrowOrHoneyHivesInTowerVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewAnyHivesInTowerVal.setText(str_pmSiteanyEagleOrCrowOrHoneyHivesInTowerVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_compoundWallOrFencingStatus))),
                        "Compound Wall/Fencing Status",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteCompoundWallOrFencingStatusVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewCompoundWallFencingStatusVal.setText(str_pmSiteCompoundWallOrFencingStatusVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_gateLockAvailablity))),
                        "Gate Lock Availablity",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteGateLockAvailablityVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewGateLockAvailablityVal.setText(str_pmSiteGateLockAvailablityVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_shelterLockAvailablity))),
                        "Shelter Lock Availablity",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteShelterLockAvailablityVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewShelterLockAvailablityVal.setText(str_pmSiteShelterLockAvailablityVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_dgLockAvailablity))),
                        "DG Lock Availablity",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteDgLockAvailablityVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewDgLockAvailablityVal.setText(str_pmSiteDgLockAvailablityVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_fireExtinguisherAvailablity))),
                        "Fire Extingisher Availablity",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteFireExtinguisherAvilabilityVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireExtingisherAvailablityVal.setText(str_pmSiteFireExtinguisherAvilabilityVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_noOfFireExtinguisher))),
                        "No of Fire Extingisher",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteNoOfFireExtinguisherVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewNoOfFireExtingisherAvailablityVal.setText(str_pmSiteNoOfFireExtinguisherVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablityVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_fireBucket))),
                        "Fire Bucket",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteFireBucketVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewFireBucketAvailablityVal.setText(str_pmSiteFireBucketVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendarVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_safetyChartsAndCalender))),
                        "Safety Charts & Calender",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteSafetyChartsAndCalendarVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewSafetyChartsAndCalendarVal.setText(str_pmSiteSafetyChartsAndCalendarVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSiteVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_unusedMaterialOnSite))),
                        "Un-Used Material in Site",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteUnusedMaterialInSiteVal = item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewUnusedMaterialInSiteVal.setText(str_pmSiteUnusedMaterialInSiteVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_registerFault))),
                        "Register Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteRegisterFaultVal= item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewRegisterFaultVal.setText(str_pmSiteRegisterFaultVal);
                    }
                });
            }
        });

        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.this,
                        new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_pmSiteHygieneGeneralSafetyParameters_typeOfFault))),
                        "Type of Fault",
                        "close", "#000000");
                searchableSpinnerDialog.showSearchableSpinnerDialog();

                searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
                    @Override
                    public void onClick(ArrayList<String> item, int position) {

                        str_pmSiteTypeOfFaultVal= item.get(position);
                        mPreventiveMaintenanceSiteHygieneGeneralSaftyTextViewTypesOfFaultVal.setText(str_pmSiteTypeOfFaultVal);
                    }
                });
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
                onBackPressed();
                return true;

            case R.id.menuSubmit:
                //submitDetails();
                startActivity(new Intent(this, PreventiveMaintenanceSiteAlarmCheckPointsActivity.class));
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

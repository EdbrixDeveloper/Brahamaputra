package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_hygiene_general_safty);
        setTitle("Site Hygiene-General Safety Parameters");
        assignViews();
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

}

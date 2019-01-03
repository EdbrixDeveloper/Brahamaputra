package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;

public class PreventiveMaintenanceSiteHygieneGeneralSaftyActivity extends BaseActivity {

    private TextView mSiteHygieneGeneralSaftyParametersTextViewSitePremisesCleaning;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewSitePremisesCleaningVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewUploadPhotoOfSitePremises;
    private ImageView mSiteHygieneGeneralSaftyParametersButtonUploadPhotoOfSitePremises;
    private ImageView mSiteHygieneGeneralSaftyParametersButtonUploadPhotoOfSitePremisesView;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewEquipmentCleaning;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewEquipmentCleaningVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewAnyHivesInTower;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewAnyHivesInTowerVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewCompoundWallFencingStatus;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewCompoundWallFencingStatusVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewGateLockAvailablity;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewGateLockAvailablityVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewShelterLockAvailablity;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewShelterLockAvailablityVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewDgLockAvailablity;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewDgLockAvailablityVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewFireExtingisherAvailablity;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewFireExtingisherAvailablityVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewNoOfFireExtingisherAvailablity;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewNoOfFireExtingisherAvailablityVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewFireExtingisherExpiryDate;
    private EditText mLandDetailsEditTextDateOfvalidityOfAgreement;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewFireBucketAvailablity;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewFireBucketAvailablityVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewCautionSignBoardPhoto;
    private ImageView mSiteHygieneGeneralSaftyParametersButtonCautionSignBoardPhoto;
    private ImageView mSiteHygieneGeneralSaftyParametersButtonCautionSignBoardPhotoView;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewWarningSignBoardPhoto;
    private ImageView mSiteHygieneGeneralSaftyParametersButtonWarningSignBoardPhoto;
    private ImageView mSiteHygieneGeneralSaftyParametersButtonWarningSignBoardPhotoView;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewDangerSignBoardPhoto;
    private ImageView mSiteHygieneGeneralSaftyParametersButtonDangerSignBoardPhoto;
    private ImageView mSiteHygieneGeneralSaftyParametersButtonDangerSignBoardPhotoView;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewSafetyChartsAndCalendar;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewSafetyChartsAndCalendarVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewUnusedMaterialInSite;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewUnusedMaterialInSiteVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewRegisterFault;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewRegisterFaultVal;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewTypesOfFault;
    private TextView mSiteHygieneGeneralSaftyParametersTextViewTypesOfFaultVal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_maintenance_site_hygiene_general_safty);
        setTitle("Site Hygiene-General Safety Parameters");
        assignViews();
    }

    private void assignViews() {
        mSiteHygieneGeneralSaftyParametersTextViewSitePremisesCleaning = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_sitePremisesCleaning);
        mSiteHygieneGeneralSaftyParametersTextViewSitePremisesCleaningVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_sitePremisesCleaningVal);
        mSiteHygieneGeneralSaftyParametersTextViewUploadPhotoOfSitePremises = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_uploadPhotoOfSitePremises);
        mSiteHygieneGeneralSaftyParametersButtonUploadPhotoOfSitePremises = (ImageView) findViewById(R.id.siteHygieneGeneralSaftyParameters_button_uploadPhotoOfSitePremises);
        mSiteHygieneGeneralSaftyParametersButtonUploadPhotoOfSitePremisesView = (ImageView) findViewById(R.id.siteHygieneGeneralSaftyParameters_button_uploadPhotoOfSitePremisesView);
        mSiteHygieneGeneralSaftyParametersTextViewEquipmentCleaning = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_equipmentCleaning);
        mSiteHygieneGeneralSaftyParametersTextViewEquipmentCleaningVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_equipmentCleaningVal);
        mSiteHygieneGeneralSaftyParametersTextViewAnyHivesInTower = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_anyHivesInTower);
        mSiteHygieneGeneralSaftyParametersTextViewAnyHivesInTowerVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_anyHivesInTowerVal);
        mSiteHygieneGeneralSaftyParametersTextViewCompoundWallFencingStatus = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_compoundWallFencingStatus);
        mSiteHygieneGeneralSaftyParametersTextViewCompoundWallFencingStatusVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_compoundWallFencingStatusVal);
        mSiteHygieneGeneralSaftyParametersTextViewGateLockAvailablity = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_gateLockAvailablity);
        mSiteHygieneGeneralSaftyParametersTextViewGateLockAvailablityVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_gateLockAvailablityVal);
        mSiteHygieneGeneralSaftyParametersTextViewShelterLockAvailablity = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_shelterLockAvailablity);
        mSiteHygieneGeneralSaftyParametersTextViewShelterLockAvailablityVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_shelterLockAvailablityVal);
        mSiteHygieneGeneralSaftyParametersTextViewDgLockAvailablity = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_dgLockAvailablity);
        mSiteHygieneGeneralSaftyParametersTextViewDgLockAvailablityVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_dgLockAvailablityVal);
        mSiteHygieneGeneralSaftyParametersTextViewFireExtingisherAvailablity = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_fireExtingisherAvailablity);
        mSiteHygieneGeneralSaftyParametersTextViewFireExtingisherAvailablityVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_fireExtingisherAvailablityVal);
        mSiteHygieneGeneralSaftyParametersTextViewNoOfFireExtingisherAvailablity = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_noOfFireExtingisherAvailablity);
        mSiteHygieneGeneralSaftyParametersTextViewNoOfFireExtingisherAvailablityVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_noOfFireExtingisherAvailablityVal);
        mSiteHygieneGeneralSaftyParametersTextViewFireExtingisherExpiryDate = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_fireExtingisherExpiryDate);
        mLandDetailsEditTextDateOfvalidityOfAgreement = (EditText) findViewById(R.id.landDetails_editText_dateOfvalidityOfAgreement);
        mSiteHygieneGeneralSaftyParametersTextViewFireBucketAvailablity = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_fireBucketAvailablity);
        mSiteHygieneGeneralSaftyParametersTextViewFireBucketAvailablityVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_fireBucketAvailablityVal);
        mSiteHygieneGeneralSaftyParametersTextViewCautionSignBoardPhoto = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_cautionSignBoardPhoto);
        mSiteHygieneGeneralSaftyParametersButtonCautionSignBoardPhoto = (ImageView) findViewById(R.id.siteHygieneGeneralSaftyParameters_button_cautionSignBoardPhoto);
        mSiteHygieneGeneralSaftyParametersButtonCautionSignBoardPhotoView = (ImageView) findViewById(R.id.siteHygieneGeneralSaftyParameters_button_cautionSignBoardPhotoView);
        mSiteHygieneGeneralSaftyParametersTextViewWarningSignBoardPhoto = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_warningSignBoardPhoto);
        mSiteHygieneGeneralSaftyParametersButtonWarningSignBoardPhoto = (ImageView) findViewById(R.id.siteHygieneGeneralSaftyParameters_button_warningSignBoardPhoto);
        mSiteHygieneGeneralSaftyParametersButtonWarningSignBoardPhotoView = (ImageView) findViewById(R.id.siteHygieneGeneralSaftyParameters_button_warningSignBoardPhotoView);
        mSiteHygieneGeneralSaftyParametersTextViewDangerSignBoardPhoto = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_dangerSignBoardPhoto);
        mSiteHygieneGeneralSaftyParametersButtonDangerSignBoardPhoto = (ImageView) findViewById(R.id.siteHygieneGeneralSaftyParameters_button_dangerSignBoardPhoto);
        mSiteHygieneGeneralSaftyParametersButtonDangerSignBoardPhotoView = (ImageView) findViewById(R.id.siteHygieneGeneralSaftyParameters_button_dangerSignBoardPhotoView);
        mSiteHygieneGeneralSaftyParametersTextViewSafetyChartsAndCalendar = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_safetyChartsAndCalendar);
        mSiteHygieneGeneralSaftyParametersTextViewSafetyChartsAndCalendarVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_safetyChartsAndCalendarVal);
        mSiteHygieneGeneralSaftyParametersTextViewUnusedMaterialInSite = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_unusedMaterialInSite);
        mSiteHygieneGeneralSaftyParametersTextViewUnusedMaterialInSiteVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_unusedMaterialInSiteVal);
        mSiteHygieneGeneralSaftyParametersTextViewRegisterFault = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_registerFault);
        mSiteHygieneGeneralSaftyParametersTextViewRegisterFaultVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_registerFaultVal);
        mSiteHygieneGeneralSaftyParametersTextViewTypesOfFault = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_typesOfFault);
        mSiteHygieneGeneralSaftyParametersTextViewTypesOfFaultVal = (TextView) findViewById(R.id.siteHygieneGeneralSaftyParameters_textView_typesOfFaultVal);
    }

}

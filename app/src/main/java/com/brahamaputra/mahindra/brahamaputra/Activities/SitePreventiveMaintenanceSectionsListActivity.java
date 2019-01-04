package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.brahamaputra.mahindra.brahamaputra.Adapters.SitePreventiveMaintenanceSectionListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePreventiveMaintenanceSection;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePreventiveMaintenanceSection;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.ArrayList;

public class SitePreventiveMaintenanceSectionsListActivity extends AppCompatActivity {

    public ListView sitePreventiveMaintenanceSections_listView_sections;
    ArrayList<SitePreventiveMaintenanceSection> dataModels;
    String[] values;
    private static SitePreventiveMaintenanceSectionListAdapter adapter;
    public static final int RESULT_READING_COMPLETED = 650;

    //vinayak code start
    /*private OfflineStorageWrapper offlineStorageWrapper;
    private SessionManager sessionManager;
    private String userId = "";
    private String ticketId = "";
    private String ticketName = "";

    private HotoTransactionData hotoTransactionData;*/
    //vinayak code end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_preventive_maintenance_sections_list);

        sitePreventiveMaintenanceSections_listView_sections = (ListView) findViewById(R.id.sitePreventiveMaintenanceSections_listView_sections);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*Intent intent = getIntent();
        String tic_Name = intent.getStringExtra("ticketName");
        this.setTitle(tic_Name);*/

        this.setTitle("Site Preventive Maintenance Sections List");


        values = getResources().getStringArray(R.array.listView_sitePreventiveMaintenanceSections_sections);
        dataModels = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (i / 2 == 0) {
                dataModels.add(new SitePreventiveMaintenanceSection("" + (i + 1), "" + values[i], 0));
            } else {
                dataModels.add(new SitePreventiveMaintenanceSection("" + (i + 1), "" + values[i], 0));
            }
            //dataModels.add(new SitePreventiveMaintenanceSection(""+(i+1),""+values[i],true));
        }

        adapter = new SitePreventiveMaintenanceSectionListAdapter(dataModels, getApplicationContext());

        sitePreventiveMaintenanceSections_listView_sections.setAdapter(adapter);
        sitePreventiveMaintenanceSections_listView_sections.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteHygieneGeneralSaftyActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, preventiveMaintenanceSiteAlarmCheckPointsActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteBatteryBankCheckPointsActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteEarthingCheckPointsActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteEbMeterBoxActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteDgCheckPointsActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteDgBatteryCheckPointsActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteAcCheckPointsActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteSmpsCheckPointsActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteRectifierModuleCheckPointActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSitePmsAmfPanelCheckPointsActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteServoCheckPointsActivity.class));
                        break;
                    case 12:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteShelterCheckPointsActivity.class));
                        break;
                    case 13:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteOtherElectricalCheckPointsActivity.class));
                        break;
                    case 14:
                        startActivity(new Intent(SitePreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceSiteOtherElectricalCheckPointsActivity.class));
                        break;

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_READING_COMPLETED && resultCode == RESULT_OK) {
            onBackPressed();
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
                onBackPressed();
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

    @Override
    protected void onResume() {
        //refreshList();
        super.onResume();
    }


    /*public void refreshList() {

        sessionManager = new SessionManager(SitePreventiveMaintenanceSectionsListActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(SitePreventiveMaintenanceSectionsListActivity.this, userId, ticketName);

        hotoTransactionData = new HotoTransactionData();
        if (getHotoObj()) {


            sitePreventiveMaintenanceSections_listView_sections = (ListView) findViewById(R.id.sitePreventiveMaintenanceSections_listView_sections);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            values = getResources().getStringArray(R.array.listView_sitePreventiveMaintenanceSections_sections);
            dataModels = new ArrayList<>();
            //Boolean greenStatus = false;
            int status = 0;

            for (int i = 0; i < values.length; i++) {
                status = checkIsSubmited(i);

                if (i / 2 == 0) {
                    dataModels.add(new SitePreventiveMaintenanceSection("" + (i + 1), "" + values[i], status));
                } else {
                    dataModels.add(new SitePreventiveMaintenanceSection("" + (i + 1), "" + values[i], status));
                }
                //dataModels.add(new SitePreventiveMaintenanceSection(""+(i+1),""+values[i],true));

            }

            adapter = new SitePreventiveMaintenanceSectionListAdapter(dataModels, getApplicationContext());

            sitePreventiveMaintenanceSections_listView_sections.setAdapter(adapter);
        }

    }

    public Boolean getHotoObj() {
        try {
            if (offlineStorageWrapper.checkOfflineFileIsAvailable(ticketName + ".txt")) {
                String jsonInString = (String) offlineStorageWrapper.getObjectFromFile(ticketName + ".txt");

                Gson gson = new Gson();

                hotoTransactionData = gson.fromJson(jsonInString, HotoTransactionData.class);

                if (hotoTransactionData != null) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public int checkIsSubmited(Integer SecNo) {
        switch (SecNo) {
            case 0:
                return hotoTransactionData.getLandDetailsData().getSubmited();
            case 1:
                return hotoTransactionData.getTowerDetailsData().getSubmited();
            *//*case 2:
                return hotoTransactionData.getEarthResistanceTowerData().getSubmited();
            case 3:
                return hotoTransactionData.getEarthResistanceEquipmentData().getSubmited();
            case 4:
                return hotoTransactionData.getElectricConnectionData().getSubmited();
            case 5:
                return hotoTransactionData.getAirConditionParentData().getSubmited();
            case 6:
                return hotoTransactionData.getSolarPowerSystemData().getSubmited();
            case 7:
                return hotoTransactionData.getPowerPlantDetailsParentData().getSubmited();
            case 8:
                return hotoTransactionData.getPowerBackupsDGParentData().getSubmited();
            case 9:
                return hotoTransactionData.getShelterData().getSubmited();
            case 10:
                return hotoTransactionData.getMediaData().getSubmited();
            case 11:
                return hotoTransactionData.getBatterySetParentData().getSubmited();
            case 12:
                return hotoTransactionData.getExternalTenantsPersonalDetailsParentData().getSubmited();
            case 13:
                return hotoTransactionData.getTotalDCLoadofSiteData().getSubmited();
            case 14:
                return hotoTransactionData.getActiveequipmentDetailsData().getSubmited();
            case 15:
                return hotoTransactionData.getPowerManagementSystemData().getSubmited();
            case 16:
                return hotoTransactionData.getGeneralSafetyMeasuresParentData().getSubmited();
            case 17:
                return hotoTransactionData.getAcdb_dcdb_data().getSubmited();
            case 18:
                return hotoTransactionData.getServoStabilizerData().getSubmited();
            case 19:
                return hotoTransactionData.getDetailsOfUnusedMaterialsParentData().getSubmited();
            case 20:
                return hotoTransactionData.getSitePhotoCaptureData().getSubmited();*//*

        }
        return 0;
    }*/


}

package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.brahamaputra.mahindra.brahamaputra.Adapters.AcPreventiveMaintenanceSectionListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTransactionData;
import com.brahamaputra.mahindra.brahamaputra.Data.PreventiveMaintenanceAcSection;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputra.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputra.commons.GlobalMethods;
import com.brahamaputra.mahindra.brahamaputra.commons.OfflineStorageWrapper;
import com.google.gson.Gson;

import java.util.ArrayList;

public class AcPreventiveMaintenanceSectionsListActivity extends BaseActivity {

    public ListView acPreventiveMaintenanceSections_listView_sections;
    ArrayList<PreventiveMaintenanceAcSection> dataModels;
    String[] values;
    private static AcPreventiveMaintenanceSectionListAdapter adapter;
    public static final int RESULT_READING_COMPLETED = 650;
    private SessionManager sessionManager;
    private String designation;
    String flag;
    String returnValue;

    //008 start

    private String customerName;
    private String circleName;
    private String stateName;
    private String ssaName;
    private String siteDBId;
    private String siteId;
    private String siteName;
    private String siteType;
    private String TicketId;
    private String TicketNO;
    private String TicketDate;
    private String acPmPlanDate;
    private String submittedDate;
    private String acPmSheduledDate;
    private String numberOfAc;
    private String modeOfOpration;
    private String vendorName;
    private String acTechnicianName;
    private String acTechnicianMobileNo;
    private String accessType;
    private String ticketAccess;
    private String acPmTickStatus;


    //008 end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_preventive_maintenance_sections_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("AC PM Sections List");

        sessionManager = new SessionManager(AcPreventiveMaintenanceSectionsListActivity.this);
        acPreventiveMaintenanceSections_listView_sections = (ListView) findViewById(R.id.acPreventiveMaintenanceSections_listView_sections);

        Intent intent = getIntent();
        //flag = intent.getStringExtra("status");

        TicketId = intent.getStringExtra("TicketId");
        TicketNO = intent.getStringExtra("TicketNO");
        TicketDate = intent.getStringExtra("TicketDate");

        acPmPlanDate = intent.getStringExtra("acPmPlanDate");
        submittedDate = intent.getStringExtra("submittedDate");
        acPmSheduledDate = intent.getStringExtra("acPmSheduledDate");

        customerName = intent.getStringExtra("customerName");
        circleName = intent.getStringExtra("circleName");
        stateName = intent.getStringExtra("stateName");
        ssaName = intent.getStringExtra("ssaName");
        siteDBId = intent.getStringExtra("siteDBId");
        siteId = intent.getStringExtra("siteId");
        siteName = intent.getStringExtra("siteName");
        siteType = intent.getStringExtra("siteType");

        numberOfAc = intent.getStringExtra("numberOfAc");
        modeOfOpration = intent.getStringExtra("modeOfOpration");
        vendorName = intent.getStringExtra("vendorName");
        acTechnicianName = intent.getStringExtra("acTechnicianName");
        acTechnicianMobileNo = intent.getStringExtra("acTechnicianMobileNo");
        accessType = intent.getStringExtra("accessType");
        ticketAccess = intent.getStringExtra("ticketAccess");
        acPmTickStatus = intent.getStringExtra("acPmTickStatus");

        designation = sessionManager.getSessionDesignation();

        int flag = 0;
        if (accessType.equals("S") && ticketAccess.equals("1") && (acPmTickStatus.equals("Open") || acPmTickStatus.equals("Reassigned"))) {
            flag = 1;
            values = new String[]{"Ticket Submission from Field Engineer"};
        } else if (accessType.equals("A") && ticketAccess.equals("1") && acPmTickStatus.equals("WIP")) {
            flag = 1;
            values = new String[]{"AC PM Process"};
        } else if (accessType.equals("S") && ticketAccess.equals("1") && acPmTickStatus.equals("WIP")) {
            flag = 1;
            values = new String[]{"AC PM Process", "Ticket Submission from Field Engineer"};
        } else {
            flag = 0;
            showToast("Unauthorised ticket status.");
            //finish();
            intent = new Intent(AcPreventiveMaintenanceSectionsListActivity.this, AcPreventiveMaintenanceDashboardActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivityForResult(intent, RESULT_OK);
        }/*else if (accessType.equals("") && ticketAccess.equals("") && acPmTickStatus.equals("")) {
            values = new String[]{"", ""};
        }*/


        /*values = getResources().getStringArray(R.array.listView_acPreventiveMaintenanceSections_sections);
        dataModels = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            if (flag.equals("Submitted by Technician")) {
                if (i / 2 == 0) {
                    dataModels.add(new PreventiveMaintenanceAcSection("" + (i + 1), "" + values[i], 0));
                } else {
                    dataModels.add(new PreventiveMaintenanceAcSection("" + (i + 1), "" + values[i], 0));
                }
            } else {
                if (values[i].equals("AC PM Process") && designation.equals("AC Technician (Mobile)")) {
                    dataModels.add(new PreventiveMaintenanceAcSection("" + (i + 1), "" + values[i], 0));
                } else if (values[i].equals("Ticket Submission from Field Engineer") && designation.equals("Site Head")) {// || designation.equals("Senior Field Support Engineer (Mobile)")
                    dataModels.add(new PreventiveMaintenanceAcSection("" + (i + 1), "" + values[i], 0));
                }
            }
        }*/
        if (flag == 1) {
            dataModels = new ArrayList<>();
            for (int i = 0; i < values.length; i++) {
                dataModels.add(new PreventiveMaintenanceAcSection("" + (i + 1), "" + values[i], 0));
            }

            adapter = new AcPreventiveMaintenanceSectionListAdapter(dataModels, getApplicationContext());

            acPreventiveMaintenanceSections_listView_sections.setAdapter(adapter);
            acPreventiveMaintenanceSections_listView_sections.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    switch (position) {
                        case 0:

                            if (dataModels.get(position).getSecName().equals("Ticket Submission from Field Engineer")) {
                                Intent acPMProcessIntent = new Intent(AcPreventiveMaintenanceSectionsListActivity.this, PreventiveMaintanceAcFieldEngineerActivity.class);

                                //008 start
                                acPMProcessIntent.putExtra("TicketId", TicketId);
                                acPMProcessIntent.putExtra("TicketNO", TicketNO);
                                acPMProcessIntent.putExtra("TicketDate", TicketDate);

                                acPMProcessIntent.putExtra("acPmPlanDate", acPmPlanDate);
                                acPMProcessIntent.putExtra("submittedDate", submittedDate);
                                acPMProcessIntent.putExtra("acPmSheduledDate", acPmSheduledDate);

                                acPMProcessIntent.putExtra("customerName", customerName);
                                acPMProcessIntent.putExtra("circleName", circleName);
                                acPMProcessIntent.putExtra("stateName", stateName);
                                acPMProcessIntent.putExtra("ssaName", ssaName);
                                acPMProcessIntent.putExtra("siteDBId", siteDBId);
                                acPMProcessIntent.putExtra("siteId", siteId);
                                acPMProcessIntent.putExtra("siteName", siteName);
                                acPMProcessIntent.putExtra("siteType", siteType);

                                acPMProcessIntent.putExtra("numberOfAc", numberOfAc);
                                acPMProcessIntent.putExtra("modeOfOpration", modeOfOpration);
                                acPMProcessIntent.putExtra("vendorName", vendorName);
                                acPMProcessIntent.putExtra("acTechnicianName", acTechnicianName);
                                acPMProcessIntent.putExtra("acTechnicianMobileNo", acTechnicianMobileNo);
                                acPMProcessIntent.putExtra("accessType", accessType);
                                acPMProcessIntent.putExtra("ticketAccess", ticketAccess);
                                acPMProcessIntent.putExtra("acPmTickStatus", acPmTickStatus);//WIP
                                //008 end

                                startActivityForResult(acPMProcessIntent, RESULT_READING_COMPLETED);
                                break;

                            } else if (dataModels.get(position).getSecName().equals("AC PM Process")) {

                                Intent acPMProcessIntent = new Intent(AcPreventiveMaintenanceSectionsListActivity.this, PreventiveMaintenanceAcTechnicianActivity.class);

                                //008 start
                                acPMProcessIntent.putExtra("TicketId", TicketId);
                                acPMProcessIntent.putExtra("TicketNO", TicketNO);
                                acPMProcessIntent.putExtra("TicketDate", TicketDate);

                                acPMProcessIntent.putExtra("acPmPlanDate", acPmPlanDate);
                                acPMProcessIntent.putExtra("submittedDate", submittedDate);
                                acPMProcessIntent.putExtra("acPmSheduledDate", acPmSheduledDate);

                                acPMProcessIntent.putExtra("customerName", customerName);
                                acPMProcessIntent.putExtra("circleName", circleName);
                                acPMProcessIntent.putExtra("stateName", stateName);
                                acPMProcessIntent.putExtra("ssaName", ssaName);
                                acPMProcessIntent.putExtra("siteDBId", siteDBId);
                                acPMProcessIntent.putExtra("siteId", siteId);
                                acPMProcessIntent.putExtra("siteName", siteName);
                                acPMProcessIntent.putExtra("siteType", siteType);

                                acPMProcessIntent.putExtra("numberOfAc", numberOfAc);
                                acPMProcessIntent.putExtra("modeOfOpration", modeOfOpration);
                                acPMProcessIntent.putExtra("vendorName", vendorName);
                                acPMProcessIntent.putExtra("acTechnicianName", acTechnicianName);
                                acPMProcessIntent.putExtra("acTechnicianMobileNo", acTechnicianMobileNo);
                                acPMProcessIntent.putExtra("accessType", accessType);
                                acPMProcessIntent.putExtra("ticketAccess", ticketAccess);
                                acPMProcessIntent.putExtra("acPmTickStatus", acPmTickStatus);//WIP
                                //008 end

                                startActivityForResult(acPMProcessIntent, RESULT_READING_COMPLETED);

                                break;
                            }

                        case 1:
                            if (dataModels.get(position).getSecName().equals("Ticket Submission from Field Engineer")) {
                                Intent acPMProcessIntent = new Intent(AcPreventiveMaintenanceSectionsListActivity.this, PreventiveMaintanceAcFieldEngineerActivity.class);
                                //acPMProcessIntent.putExtra("status", "");

                                //008 start
                                acPMProcessIntent.putExtra("TicketId", TicketId);
                                acPMProcessIntent.putExtra("TicketNO", TicketNO);
                                acPMProcessIntent.putExtra("TicketDate", TicketDate);

                                acPMProcessIntent.putExtra("acPmPlanDate", acPmPlanDate);
                                acPMProcessIntent.putExtra("submittedDate", submittedDate);
                                acPMProcessIntent.putExtra("acPmSheduledDate", acPmSheduledDate);

                                acPMProcessIntent.putExtra("customerName", customerName);
                                acPMProcessIntent.putExtra("circleName", circleName);
                                acPMProcessIntent.putExtra("stateName", stateName);
                                acPMProcessIntent.putExtra("ssaName", ssaName);
                                acPMProcessIntent.putExtra("siteDBId", siteDBId);
                                acPMProcessIntent.putExtra("siteId", siteId);
                                acPMProcessIntent.putExtra("siteName", siteName);
                                acPMProcessIntent.putExtra("siteType", siteType);

                                acPMProcessIntent.putExtra("numberOfAc", numberOfAc);
                                acPMProcessIntent.putExtra("modeOfOpration", modeOfOpration);
                                acPMProcessIntent.putExtra("vendorName", vendorName);
                                acPMProcessIntent.putExtra("acTechnicianName", acTechnicianName);
                                acPMProcessIntent.putExtra("acTechnicianMobileNo", acTechnicianMobileNo);
                                acPMProcessIntent.putExtra("accessType", accessType);
                                acPMProcessIntent.putExtra("ticketAccess", ticketAccess);
                                acPMProcessIntent.putExtra("acPmTickStatus", acPmTickStatus);//WIP
                                //008 end

                                startActivityForResult(acPMProcessIntent, RESULT_READING_COMPLETED);
                                break;
                            }


                    }
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_READING_COMPLETED && resultCode == RESULT_OK) {
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

        sessionManager = new SessionManager(AcPreventiveMaintenanceSectionsListActivity.this);
        ticketId = sessionManager.getSessionUserTicketId();
        ticketName = GlobalMethods.replaceAllSpecialCharAtUnderscore(sessionManager.getSessionUserTicketName());
        userId = sessionManager.getSessionUserId();
        offlineStorageWrapper = OfflineStorageWrapper.getInstance(AcPreventiveMaintenanceSectionsListActivity.this, userId, ticketName);

        hotoTransactionData = new HotoTransactionData();
        if (getHotoObj()) {


            acPreventiveMaintenanceSections_listView_sections = (ListView) findViewById(R.id.acPreventiveMaintenanceSections_listView_sections);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            values = getResources().getStringArray(R.array.listView_acPreventiveMaintenanceSections_sections);
            dataModels = new ArrayList<>();
            //Boolean greenStatus = false;
            int status = 0;

            for (int i = 0; i < values.length; i++) {
                status = checkIsSubmited(i);

                if (i / 2 == 0) {
                    dataModels.add(new AcPreventiveMaintenanceSection("" + (i + 1), "" + values[i], status));
                } else {
                    dataModels.add(new AcPreventiveMaintenanceSection("" + (i + 1), "" + values[i], status));
                }
                //dataModels.add(new AcPreventiveMaintenanceSection(""+(i+1),""+values[i],true));

            }

            adapter = new AcPreventiveMaintenanceSectionListAdapter(dataModels, getApplicationContext());

            acPreventiveMaintenanceSections_listView_sections.setAdapter(adapter);
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

package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.brahamaputra.mahindra.brahamaputra.Adapters.HotoSectionListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoSection;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.ArrayList;

public class HotoSectionsListActivity extends AppCompatActivity {

    public ListView hotoSections_listView_sections;
    ArrayList<HotoSection> dataModels;
    String[] values;
    private static HotoSectionListAdapter adapter;
    public static final int RESULT_READING_COMPLETED = 650;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoto_sections_list);

        hotoSections_listView_sections = (ListView)findViewById(R.id.hotoSections_listView_sections);
        this.setTitle("Readings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        values = getResources().getStringArray(R.array.listView_hotoSections_sections);
        dataModels= new ArrayList<>();
        for(int i=0;i<values.length;i++){
            if(i/2 == 0){
                dataModels.add(new HotoSection(""+(i+1),""+values[i],true));
            }else{
                dataModels.add(new HotoSection(""+(i+1),""+values[i],false));
            }
            //dataModels.add(new HotoSection(""+(i+1),""+values[i],true));

        }

        adapter= new HotoSectionListAdapter(dataModels,getApplicationContext());

        hotoSections_listView_sections.setAdapter(adapter);
        hotoSections_listView_sections.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        startActivity(new Intent(HotoSectionsListActivity.this, Land_Details.class));
                        break;
                    case 1:
                        startActivity(new Intent(HotoSectionsListActivity.this, Tower_Detail.class));
                        break;
                    case 2:
                        startActivity(new Intent(HotoSectionsListActivity.this, Earth_Resistance_Tower.class));
                        break;
                    case 3:
                        startActivity(new Intent(HotoSectionsListActivity.this, Earth_Resistance_Equipment.class));
                        break;
                    case 4:
                        startActivity(new Intent(HotoSectionsListActivity.this, Electric_Connection.class));
                        break;
                    case 5:
                        startActivity(new Intent(HotoSectionsListActivity.this, Air_Conditioners.class));
                        break;
                    case 6:
                        startActivity(new Intent(HotoSectionsListActivity.this, Solar_Power_System.class));
                        break;
                    case 7:
                        startActivity(new Intent(HotoSectionsListActivity.this, PowerPlantDetailsActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(HotoSectionsListActivity.this, Power_Backups_DG.class));
                        break;
                    case 9:
                        startActivity(new Intent(HotoSectionsListActivity.this, Shelter.class));
                        break;
                    case 10:
                        startActivity(new Intent(HotoSectionsListActivity.this,Media.class));
                        break;
                    case 11:
                        startActivity(new Intent(HotoSectionsListActivity.this,Battery_Set.class));
                        break;
                    case 12:
                        startActivity(new Intent(HotoSectionsListActivity.this,ExternalTenantsPersonaldetails.class));
                        break;
                    case 13:
                        startActivity(new Intent(HotoSectionsListActivity.this,Total_DC_Load_site.class));
                        break;
                    case 14:
                        startActivity(new Intent(HotoSectionsListActivity.this,ActiveequipmentDetails.class));
                        break;
                    case 15:
                        startActivity(new Intent(HotoSectionsListActivity.this,PowerManagementSystem.class));
                        break;
                    case 16:
                        startActivity(new Intent(HotoSectionsListActivity.this,GeneralAndSafetyMeasures.class));
                        break;
                    case 17:
                        startActivity(new Intent(HotoSectionsListActivity.this,ACDB_DCDB.class));
                        break;
                    case 18:
                        startActivity(new Intent(HotoSectionsListActivity.this,ServoStabilizer.class));
                        break;
                    case 19:
                        startActivity(new Intent(HotoSectionsListActivity.this,DetailsOfUnusedMaterials.class));
                        break;
                    case 20:
                        startActivityForResult(new Intent(HotoSectionsListActivity.this,PhotoCaptureActivity.class),RESULT_READING_COMPLETED);
                        break;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_READING_COMPLETED && resultCode == RESULT_OK){
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

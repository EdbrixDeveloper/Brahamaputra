package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.brahamaputra.mahindra.brahamaputra.R;

public class HotoSectionsListActivity extends AppCompatActivity {

    public ListView hotoSections_listView_sections;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoto_sections_list);

        hotoSections_listView_sections = (ListView)findViewById(R.id.hotoSections_listView_sections);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        hotoSections_listView_sections.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0: startActivity(new Intent(HotoSectionsListActivity.this,Land_Details.class));
                        break;
                    case 1: startActivity(new Intent(HotoSectionsListActivity.this,Tower_Detail.class));
                        break;
                    case 2: startActivity(new Intent(HotoSectionsListActivity.this,Earth_Resistance_Tower.class));
                        break;
                    case 3: startActivity(new Intent(HotoSectionsListActivity.this,Earth_Resistance_Equipment.class));
                        break;
                    case 4: startActivity(new Intent(HotoSectionsListActivity.this,Electric_Connection.class));
                        break;
                    case 6: startActivity(new Intent(HotoSectionsListActivity.this,Solar_Power_System.class));
                        break;

                    case 10: startActivity(new Intent(HotoSectionsListActivity.this,Media.class));
                        break;
                    case 11: startActivity(new Intent(HotoSectionsListActivity.this,Battery_Set.class));
                        break;
                    case 12: startActivity(new Intent(HotoSectionsListActivity.this,ExternalTenantsPersonaldetails.class));
                        break;
                    case 13: startActivity(new Intent(HotoSectionsListActivity.this,Total_DC_Load_site.class));
                        break;
                    case 14: startActivity(new Intent(HotoSectionsListActivity.this,ActiveequipmentDetails.class));
                        break;
                    case 15: startActivity(new Intent(HotoSectionsListActivity.this,PowerManagementSystem.class));
                        break;
                    case 16: startActivity(new Intent(HotoSectionsListActivity.this,GeneralAndSafetyMeasures.class));
                        break;
                    case 17: startActivity(new Intent(HotoSectionsListActivity.this,ACDB_DCDB.class));
                        break;
                    case 18: startActivity(new Intent(HotoSectionsListActivity.this,ServoStabilizer.class));
                        break;
                    case 19: startActivity(new Intent(HotoSectionsListActivity.this,DetailsOfUnusedMaterials.class));
                        break;
                }
            }
        });

    }


}

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

        hotoSections_listView_sections = (ListView) findViewById(R.id.hotoSections_listView_sections);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        hotoSections_listView_sections.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
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
                }
            }
        });

    }


}

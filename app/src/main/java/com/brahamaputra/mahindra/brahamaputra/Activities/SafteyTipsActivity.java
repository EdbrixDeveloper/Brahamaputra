package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.brahamaputra.mahindra.brahamaputra.Adapters.ExpandableListAdapter;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SafteyTipsActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saftey_tips);
        this.setTitle("Safety Tips");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Work at Height");
        listDataHeader.add("Electrical Safety");
        listDataHeader.add("Material Handling & Lifting");
        listDataHeader.add("Road Safety");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Ensure PPE 100% tie off");
        top250.add("No shot cuts use Safe Access");
        top250.add("Carry tools in tool kit");
        top250.add("No work if bad weather/ill health");


        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Ensure PPE, Gloves, Insulated tools, training & competency");
        nowShowing.add("Isolate Power before working on electrical Equipment");
        nowShowing.add("Check Earthing, CB, Wiring quality");
        nowShowing.add("Do no work with wet hands and wet tools");
        nowShowing.add("No short cuts. No work if wet");


        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Ensure certified lifting tools and equipment, PPE, training and competency");
        comingSoon.add("Away from load. Ensure barricading");


        List<String> roadSafety = new ArrayList<String>();
        roadSafety.add("Wear ISI quality helmet while driving two wheelers");
        roadSafety.add("Ensure helmet chin strap is tightly tied/locked");
        roadSafety.add("Follow Traffic Rules");
        roadSafety.add("Do not drink and drive");
        roadSafety.add("Wear seat belts while driving four wheelers");
        roadSafety.add("Follow traffic rules");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), roadSafety);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_no_button, menu);
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
}

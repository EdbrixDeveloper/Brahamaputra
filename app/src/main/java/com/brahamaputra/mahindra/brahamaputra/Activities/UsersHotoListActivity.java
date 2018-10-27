package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

import com.brahamaputra.mahindra.brahamaputra.Adapters.UserHotoExpListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Adapters.UserHotoListAdapter;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoListHeader;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoListTiketData;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsersHotoListActivity extends AppCompatActivity {

    private UserHotoListAdapter mAdapter;
    private UserHotoExpListAdapter userHotoExpListAdapter;
    public ExpandableListView userHotoList_listView_hotoList;
    private List<HotoListHeader> hotoListHeaders;
    private HashMap<Object, List<HotoListTiketData>> hotoListTiketDataMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_hoto_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        userHotoList_listView_hotoList = (ExpandableListView) findViewById(R.id.userHotoList_listView_hotoList);
      /*  mAdapter = new UserHotoListAdapter(UsersHotoListActivity.this);

        for (int i = 1; i < 30; i++) {
            mAdapter.addItem("TKT_"+i);
            if (i % 4 == 0) {
                mAdapter.addSectionHeaderItem("26/10/2018");
            }
        }
        userHotoList_listView_hotoList.setAdapter(mAdapter);*/

        prepareListData();

//        userHotoList_listView_hotoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startActivity(new Intent(UsersHotoListActivity.this,UserHotoTransactionActivity.class));
//            }
//        });

        userHotoList_listView_hotoList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                userHotoList_listView_hotoList.expandGroup(groupPosition);
                return true;
            }
        });
        userHotoList_listView_hotoList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                startActivity(new Intent(UsersHotoListActivity.this,UserHotoTransactionActivity.class));
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        hotoListHeaders = new ArrayList<>();
        hotoListTiketDataMap = new HashMap<Object, List<HotoListTiketData>>();

        // Adding child data
        List<HotoListTiketData> header1  = new ArrayList<HotoListTiketData>();
        header1.add(new HotoListTiketData("TKT_26_121"));
        header1.add(new HotoListTiketData("TKT_26_122"));
        header1.add(new HotoListTiketData("TKT_26_123"));
        hotoListHeaders.add(new HotoListHeader("26 Oct 2018", ""+header1.size()));

        List<HotoListTiketData> header2  = new ArrayList<HotoListTiketData>();
        header2.add(new HotoListTiketData("TKT_27_131"));
        header2.add(new HotoListTiketData("TKT_27_132"));
        header2.add(new HotoListTiketData("TKT_27_133"));
        header2.add(new HotoListTiketData("TKT_27_134"));
        header2.add(new HotoListTiketData("TKT_27_135"));
        hotoListHeaders.add(new HotoListHeader("27 Oct 2018", ""+header2.size()));

        List<HotoListTiketData> header3  = new ArrayList<HotoListTiketData>();
        header3.add(new HotoListTiketData("TKT_28_121"));
        header3.add(new HotoListTiketData("TKT_28_122"));
        header3.add(new HotoListTiketData("TKT_28_123"));
        hotoListHeaders.add(new HotoListHeader("28 Oct 2018", ""+header3.size()));

        List<HotoListTiketData> header4  = new ArrayList<HotoListTiketData>();
        header4.add(new HotoListTiketData("TKT_29_121"));
        header4.add(new HotoListTiketData("TKT_29_122"));
        header4.add(new HotoListTiketData("TKT_29_123"));
        header4.add(new HotoListTiketData("TKT_29_124"));
        hotoListHeaders.add(new HotoListHeader("29 Oct 2018", ""+header4.size()));

        hotoListTiketDataMap.put(hotoListHeaders.get(0), header1); // Header, Child data
        hotoListTiketDataMap.put(hotoListHeaders.get(1), header2);
        hotoListTiketDataMap.put(hotoListHeaders.get(2), header3);
        hotoListTiketDataMap.put(hotoListHeaders.get(3), header4);

        userHotoExpListAdapter = new UserHotoExpListAdapter(UsersHotoListActivity.this,hotoListHeaders,hotoListTiketDataMap);

        userHotoList_listView_hotoList.setAdapter(userHotoExpListAdapter);

        for(int i=0; i<hotoListHeaders.size();i++){
            userHotoList_listView_hotoList.expandGroup(i);
        }

    }

}

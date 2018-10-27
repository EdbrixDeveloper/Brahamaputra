package com.brahamaputra.mahindra.brahamaputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.brahamaputra.mahindra.brahamaputra.Adapters.UserHotoListAdapter;
import com.brahamaputra.mahindra.brahamaputra.R;

public class UsersHotoListActivity extends AppCompatActivity {

    private UserHotoListAdapter mAdapter;
    public ListView userHotoList_listView_hotoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_hoto_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        userHotoList_listView_hotoList = (ListView) findViewById(R.id.userHotoList_listView_hotoList);
        mAdapter = new UserHotoListAdapter(UsersHotoListActivity.this);


        for (int i = 1; i < 30; i++) {
            mAdapter.addItem("TKT_"+i);
            if (i % 4 == 0) {
                mAdapter.addSectionHeaderItem("26/10/2018");
            }
        }
        userHotoList_listView_hotoList.setAdapter(mAdapter);

        userHotoList_listView_hotoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(UsersHotoListActivity.this,UserHotoTransactionActivity.class));
            }
        });
    }

}

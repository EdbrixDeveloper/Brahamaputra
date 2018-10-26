package com.brahamaputra.mahindra.brahamaputra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UsersHotoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_hoto_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
}

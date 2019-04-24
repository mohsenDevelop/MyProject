package com.kermanifar.mohsen.myfirstapp.view.activity;


import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kermanifar.mohsen.myfirstapp.adapter.AppFeaturesAdapter;
import com.kermanifar.mohsen.myfirstapp.datafake.DataFakeGenerator;
import com.kermanifar.mohsen.myfirstapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setUpViews();
    }

    private void setUpViews() {
        setUpRecyclerView();
        setUpToolbar();
        setUpNavigationView();

        final CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator_layout);
        FloatingActionButton  floatingActionButton = findViewById(R.id.float_action_btn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout, "Float Action Button Clicked!!", Snackbar.LENGTH_LONG)
                        .setAction("Retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"Retry Button Clicked!!!",Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });

    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_app_feature);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                }else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        AppFeaturesAdapter  appFeaturesAdapter = new AppFeaturesAdapter(this, DataFakeGenerator.getAppFeature(this));
        recyclerView.setAdapter(appFeaturesAdapter);
    }

    private void setUpToolbar(){
        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(this,  R.color.white));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,0, 0);

        drawerLayout.addDrawerListener(actionBarDrawerToggle); // set action for toggle hamburger.
        actionBarDrawerToggle.syncState();

    }
    private void setUpNavigationView() {
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_menu_profile:
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        break;
                    case R.id.navigation_menu_post:
                        startActivity(new Intent(MainActivity.this, PostsActivity.class));
                        break;
                }

                return true;
            }
        });
    }

}


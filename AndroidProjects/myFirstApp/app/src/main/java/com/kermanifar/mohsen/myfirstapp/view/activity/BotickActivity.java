package com.kermanifar.mohsen.myfirstapp.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toolbar;

import com.kermanifar.mohsen.myfirstapp.R;
import com.kermanifar.mohsen.myfirstapp.adapter.ClothesViewPagerAdapter;

public class BotickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botick);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);


        ClothesViewPagerAdapter clothesViewPagerAdapter = new ClothesViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(clothesViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        setUpToolbar();
    }

    private void setUpToolbar(){
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.botick_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}

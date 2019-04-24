package com.kermanifar.mohsen.myfirstapp.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kermanifar.mohsen.myfirstapp.view.fragment.ClothesFragment;

public class ClothesViewPagerAdapter extends FragmentPagerAdapter  {

    public ClothesViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ClothesFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "مشاهده شده ها";
            case 1 :
                return "پربازدید ترین ها";
            case 2:
                return "جدیدترین ها";

             default :
                 return "";
        }
    }
}

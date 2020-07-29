package com.hh1995.myroutine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    Fragment[] fragments=new Fragment[3];
    String[] tabTitles =new String[]{"목표/인바디","일정","갤러리"};



    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments[0]=new T1Fragment();
        fragments[1]=new T2Fragment();
        fragments[2]=new T3Fragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

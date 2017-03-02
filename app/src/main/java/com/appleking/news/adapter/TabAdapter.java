package com.appleking.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.appleking.news.MainActivity;

import java.util.List;

/**
 * Created by appleking on 2017/3/2.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;


    public TabAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    //设置tablayout标题
    @Override
    public CharSequence getPageTitle(int position) {
        return MainActivity.tabTitle[position];

    }
}

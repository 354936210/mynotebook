package com.owangwang.mynotebook;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangchao on 2017/11/22.
 */

public class MyAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList = new ArrayList<Fragment>();


    public MyAdapter(FragmentManager supportFragmentManager, List<Fragment> fragmentList) {
        super(supportFragmentManager);
        this.fragmentList=fragmentList;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
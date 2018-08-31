package com.peruzal.flicks.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MoviesPagesAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    List<CharSequence> pageTitlesList;
    public MoviesPagesAdapter(FragmentManager fm, List<Fragment> fragments, List<CharSequence> pageTitles) {
        super(fm);
        fragmentList = fragments;
        pageTitlesList = pageTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitlesList.get(position);
    }
}

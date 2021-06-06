package com.besttmt.linkaround.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.besttmt.linkaround.R;
import com.besttmt.linkaround.ui.fragement.BTFragment;
import com.besttmt.linkaround.ui.fragement.CovidFragment;
import com.besttmt.linkaround.ui.fragement.ProfileFragment;
import com.besttmt.linkaround.ui.fragement.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4};
    private final Context mContext;

    private List<Fragment> allFragementList = new ArrayList<Fragment>();


    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        ProfileFragment pf = new ProfileFragment();
        BTFragment bt = new BTFragment();
        CovidFragment cv = new CovidFragment();
        RecommendFragment rcom = new RecommendFragment();
        allFragementList.add(pf);
        allFragementList.add(bt);
        allFragementList.add(cv);
        allFragementList.add(rcom);

    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return allFragementList.get(position);

        //return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }
}
package com.thecabine.sample.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.thecabine.sample.App;
import com.thecabine.sample.R;
import com.thecabine.sample.ui.ListFragment;

/**
 * Created by admin on 10/21/15.
 */
public class SamplePagerAdapter extends FragmentStatePagerAdapter {

    public SamplePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ListFragment.newInstance("event");
            case 1:
                return ListFragment.newInstance("shop");

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Context context = App.getAppContext();
        switch (position) {
            case 0:
                return context.getString(R.string.events);
            case 1:
                return context.getString(R.string.shops);
            default:
                return context.getString(R.string.not_available);
        }
    }
}
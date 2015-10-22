package com.thecabine.sample.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.thecabine.sample.R;
import com.thecabine.sample.ui.adapter.SamplePagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.sliding_tabs) TabLayout mTabLayout;
    @Bind(R.id.vpProjects) ViewPager mViewPager;
    @Bind(R.id.toolbar) Toolbar mToolbarActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbarActionBar);
        setTitle(R.string.app_name);

        mViewPager.setAdapter(new SamplePagerAdapter(getSupportFragmentManager()));

        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.setupWithViewPager(mViewPager);


    }



}

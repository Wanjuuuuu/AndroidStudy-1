package org.osori.androidstudy.week2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.osori.androidstudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager Activity
 *
 * 중요 keyword
 * ViewPager
 */

public class ViewPagerActivity extends AppCompatActivity {

    private final String TAG = "ViewPagerActivity";

    private ViewPager viewpager;
    private TabLayout tabLayout;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        viewpager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(FirstFragment.newInstance());
        fragmentList.add(SecondFragment.newInstance());
        fragmentList.add(ThirdFragment.newInstance());

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.setFragment(fragmentList);

        viewpager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewpager);
    }
}

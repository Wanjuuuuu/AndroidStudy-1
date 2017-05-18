package org.osori.androidstudy.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.osori.androidstudy.R;

/**
 * ViewPager Activity
 *
 * 중요 keyword
 * ViewPager
 * ViewHolder pattern
 */

public class ViewPagerActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
    }
}

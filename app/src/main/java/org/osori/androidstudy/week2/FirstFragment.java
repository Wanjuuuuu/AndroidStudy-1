package org.osori.androidstudy.week2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.osori.androidstudy.R;

/**
 * Created by junsu on 2017-05-20.
 */

public class FirstFragment extends Fragment {

    public static FirstFragment newInstance() {
        
        Bundle args = new Bundle();
        
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }
}

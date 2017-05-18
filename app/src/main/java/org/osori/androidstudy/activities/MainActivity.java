package org.osori.androidstudy.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.osori.androidstudy.R;
import org.osori.androidstudy.adapters.StudyListAdapter;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private RecyclerView studyListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studyListView = (RecyclerView) findViewById(R.id.study_list_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        studyListView.setLayoutManager(layoutManager);
        studyListView.setAdapter(new StudyListAdapter(this));

    }
}

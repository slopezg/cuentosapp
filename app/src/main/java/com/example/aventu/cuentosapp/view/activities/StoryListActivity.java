package com.example.aventu.cuentosapp.view.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aventu.cuentosapp.R;
import com.example.aventu.cuentosapp.businessLogic.StoryBusiness;
import com.example.aventu.cuentosapp.models.modelsDB.Story;
import com.example.aventu.cuentosapp.view.adapters.StoryAdapter;
import com.example.aventu.cuentosapp.view.interfaces.IStory;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Santiago on 10/20/17.
 */

public class StoryListActivity extends AppCompatActivity implements IStory {

    private RecyclerView rvStory;
    private StoryBusiness storyBL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_story);
        ButterKnife.inject(this);
        rvStory = (RecyclerView) findViewById(R.id.rvStory);
        storyBL = new StoryBusiness(this);
        storyBL.loadStories();
        configActionBar();
    }

    private void configActionBar() {
        getSupportActionBar().setTitle(getString(R.string.my_story_title));
    }

    @Override
    public void showStories(List<Story> stories) {
        rvStory.setLayoutManager(new GridLayoutManager(StoryListActivity.this, 2));
        rvStory.setAdapter(new StoryAdapter(StoryListActivity.this, stories));
    }
}

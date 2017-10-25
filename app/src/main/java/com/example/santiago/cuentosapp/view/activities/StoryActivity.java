package com.example.santiago.cuentosapp.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.santiago.cuentosapp.R;
import com.example.santiago.cuentosapp.models.modelsDB.Story;
import com.example.santiago.cuentosapp.models.modelsbusiness.StoryModel;

import butterknife.ButterKnife;

/**
 * Created by Santiago on 10/20/17.
 */

public class StoryActivity extends AppCompatActivity {

    private RelativeLayout ryStory;
    private FloatingActionButton fab;
    private StoryModel story;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.inject(this);
        ryStory = (RelativeLayout) findViewById(R.id.lyStory);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        getData();
        configActionBar();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoryActivity.this, PlayActivity.class);
                intent.putExtra(Story.class.getName(), story);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        story = (StoryModel) getIntent().getSerializableExtra("Story");
        String uri = "@drawable/" + story.getResourceStory();
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        ryStory.setBackgroundResource(imageResource);
    }

    private void configActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(story.getName().isEmpty() ? "Cuento" : story.getName());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}

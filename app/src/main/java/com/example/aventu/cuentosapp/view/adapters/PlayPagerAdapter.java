package com.example.aventu.cuentosapp.view.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.aventu.cuentosapp.models.modelsDB.Question;
import com.example.aventu.cuentosapp.models.modelsbusiness.StoryModel;
import com.example.aventu.cuentosapp.view.fragments.QuestionFragment;

/**
 * Created by Santiago on 10/21/17.
 */

public class PlayPagerAdapter extends FragmentPagerAdapter {

    private StoryModel story;

    public PlayPagerAdapter(FragmentManager fm, StoryModel story) {
        super(fm);
        this.story = story;
    }

    @Override
    public Fragment getItem(int position) {
        QuestionFragment questionFragment = new QuestionFragment();
        if(position == getCount() - 1){
            questionFragment.setLastQuestion();
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Question.class.getName(), story.getQuestions().get(position));
        questionFragment.setArguments(bundle);
        return questionFragment;

    }

    @Override
    public int getCount() {
        return story.getQuestions().size();
    }
}

package com.example.aventu.cuentosapp.businessLogic;

import com.example.aventu.cuentosapp.models.modelsDB.Story;
import com.example.aventu.cuentosapp.view.interfaces.IStory;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by Santiago on 10/20/17.
 */

public class StoryBusiness {

    private IStory iStory;
    private Realm realm;

    public StoryBusiness(IStory iStory) {
        this.iStory = iStory;
    }

    public void loadStories(){
        realm = Realm.getDefaultInstance();
        List<Story> results = new ArrayList<>(realm.where(Story.class).findAll());
        iStory.showStories(results);
    }
}

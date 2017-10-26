package com.example.aventu.cuentosapp.repositories;

import android.content.Context;

import com.example.aventu.cuentosapp.models.modelsDB.Story;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by Santiago on 10/21/17.
 */

public class StoryRepository {

    private Realm realm;
    private Context mContext;
    private QuestionRepository questionRepository;

    public StoryRepository(Context mContext) {
        this.mContext = mContext;
        this.questionRepository = new QuestionRepository(mContext);
    }

    public void createStories() {
        realm = Realm.getDefaultInstance();


        //Delete * from Story
        realm.beginTransaction();
        realm.where(Story.class).findAll().deleteAllFromRealm();
        realm.commitTransaction();

        //Insert new Stories
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmList<Story> stories = new RealmList();
                stories.add(newStory("1", "EL PAJARITO", "pajarito", "cuento_pajarito"));
                stories.add(newStory("2", "EL GATO DE LA TÍA PEPA", "gatotiapepa", "cuento_gatotiapepa"));
                stories.add(newStory("3", "EL PEQUEÑO PECECITO", "pececito", "cuento_pequenopececito"));
                stories.add(newStory("4", "EL NUEVO BAILE", "leon", "cuento_cumpleanossenorleon"));

                realm.insertOrUpdate(stories);
            }
        });

    }

    private Story newStory(String id, String name, String resourceImage, String resourceStory) {
        Story story = realm.createObject(Story.class);
        story.id = id;
        story.name = name;
        story.resourceImage = resourceImage;
        story.resourceStory = resourceStory;
        story.questions = questionRepository.questions(story.id);
        return story;
    }
}

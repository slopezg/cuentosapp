package com.example.santiago.cuentosapp.repositories;

import android.content.Context;

import com.example.santiago.cuentosapp.models.modelsDB.Story;

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
                int count = 0;
                while (count < 6) {
                    switch (count) {
                        case 0:
                            Story story = realm.createObject(Story.class);
                            story.id = "1";
                            story.name = "EL PAJARITO";
                            story.resourceImage = "pajarito";
                            story.resourceStory = "cuento_pajarito";
                            story.questions = questionRepository.questions(story.id);
                            stories.add(story);
                            break;

                        case 1:
                            Story story1 = realm.createObject(Story.class);
                            story1.id = "2";
                            story1.name = "EL GATO DE LA TÍA PEPA";
                            story1.resourceImage = "gatotiapepa";
                            story1.resourceStory = "cuento_gatotiapepa";
                            stories.add(story1);
                            break;

                        case 2:
                            Story story2 = realm.createObject(Story.class);
                            story2.id = "3";
                            story2.name = "EL PEQUEÑO PECECITO";
                            story2.resourceImage = "pececito";
                            story2.resourceStory = "cuento_pequenopececito";
                            stories.add(story2);
                            break;

                        case 3:
                            Story story3 = realm.createObject(Story.class);
                            story3.id = "4";
                            story3.name = "EL NUEVO BAILE";
                            story3.resourceImage = "leon";
                            story3.resourceStory = "cuento_cumpleanossenorleon";
                            stories.add(story3);
                            break;

                        /*case 4:
                            Story story4 = realm.createObject(Story.class);
                            story4.id = "5";
                            story4.name = "EL COFRE DE LOS SUEÑOS";
                            story4.resourceImage = "cofre";
                            story4.resourceStory = "cuento_cofredelossuenos";
                            stories.add(story4);
                            break;

                        case 5:
                            Story story5 = realm.createObject(Story.class);
                            story5.id = "6";
                            story5.name = "ALBOROTO EN LA COCINA";
                            story5.resourceImage = "cocina";
                            story5.resourceStory = "cuento_alborotoenlacocina";
                            stories.add(story5);
                            break;*/
                    }
                    count++;
                }
                realm.insertOrUpdate(stories);
            }
        });

    }
}

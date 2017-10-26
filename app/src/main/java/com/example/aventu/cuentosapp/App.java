package com.example.aventu.cuentosapp;

import android.app.Application;

import com.example.aventu.cuentosapp.repositories.StoryRepository;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Santiago on 10/20/17.
 */

public class App extends Application {

    private App instance;


    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        StoryRepository storyRepository = new StoryRepository(getApplicationContext());
        storyRepository.createStories();
    }
}

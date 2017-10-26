package com.example.aventu.cuentosapp.view.interfaces;

import com.example.aventu.cuentosapp.models.modelsDB.Story;

import java.util.List;

/**
 * Created by Santiago on 10/20/17.
 */

public interface IStory {
    void showStories(List<Story> stories);
}
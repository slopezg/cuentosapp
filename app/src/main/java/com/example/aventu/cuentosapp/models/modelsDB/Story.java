package com.example.aventu.cuentosapp.models.modelsDB;

import com.example.aventu.cuentosapp.models.modelsbusiness.QuestionModel;
import com.example.aventu.cuentosapp.models.modelsbusiness.StoryModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Santiago on 10/20/17.
 */

public class Story extends RealmObject {

    public String id;
    public String name;
    public String resourceImage;
    public String resourceStory;
    public RealmList<Question> questions;

    public Story() {
        id = "";
        name = "";
        resourceImage = "";
        resourceStory = "";
        questions = new RealmList<>();
    }

    public StoryModel convertToModel() {
        StoryModel storyModel = new StoryModel();
        storyModel.setId(id);
        storyModel.setName(name);
        storyModel.setResourceImage(resourceImage);
        storyModel.setResourceStory(resourceStory);
        storyModel.setQuestions(questionsToModel());
        return storyModel;
    }

    private List<QuestionModel> questionsToModel() {
        List<QuestionModel> questionModels = new ArrayList<>();
        for (Question question : questions) {
            questionModels.add(question.convertToModel());
        }
        return questionModels;
    }
}

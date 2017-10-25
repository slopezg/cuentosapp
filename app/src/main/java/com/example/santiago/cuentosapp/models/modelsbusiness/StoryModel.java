package com.example.santiago.cuentosapp.models.modelsbusiness;

import com.example.santiago.cuentosapp.models.modelsDB.Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santiago on 10/21/17.
 */

public class StoryModel implements Serializable {

    private String id;
    private String name;
    private String resourceImage;
    private String resourceStory;
    private List<QuestionModel> questions;

    public StoryModel() {
        id = "";
        name = "";
        resourceImage = "";
        resourceStory = "";
        questions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getResourceStory() {
        return resourceStory;
    }

    public void setResourceStory(String resourceStory) {
        this.resourceStory = resourceStory;
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionModel> questions) {
        this.questions = questions;
    }
}

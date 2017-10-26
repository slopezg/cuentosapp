package com.example.aventu.cuentosapp.models.modelsbusiness;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santiago on 10/21/17.
 */

public class QuestionModel implements Serializable {
    private String id;
    private String description;
    private List<AnswerModel> answers;

    public QuestionModel() {
        id = "";
        description = "";
        answers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AnswerModel> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerModel> answers) {
        this.answers = answers;
    }
}

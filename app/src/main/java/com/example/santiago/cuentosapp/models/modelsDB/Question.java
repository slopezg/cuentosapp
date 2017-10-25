package com.example.santiago.cuentosapp.models.modelsDB;

import com.example.santiago.cuentosapp.models.modelsbusiness.AnswerModel;
import com.example.santiago.cuentosapp.models.modelsbusiness.QuestionModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Santiago on 10/21/17.
 */

public class Question extends RealmObject {

    public String id;
    public String description;
    public RealmList<Answer> answers;

    public Question() {
        this.id = "";
        this.description = "";
        this.answers = new RealmList<>();
    }

    public QuestionModel convertToModel(){
        QuestionModel question = new QuestionModel();
        question.setId(id);
        question.setDescription(description);
        question.setAnswers(answersToModel());
        return question;
    }

    private List<AnswerModel> answersToModel() {
        List<AnswerModel> answerModels = new ArrayList<>();
        for (Answer answer: answers){
            answerModels.add(answer.convertToModel());
        }
        return answerModels;
    }
}

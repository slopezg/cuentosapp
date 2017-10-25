package com.example.santiago.cuentosapp.models.modelsDB;

import com.example.santiago.cuentosapp.models.modelsbusiness.AnswerModel;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by Santiago on 10/21/17.
 */

public class Answer extends RealmObject {

    public String id;
    public String description;
    public boolean right;

    public Answer() {
        this.id = "";
        this.description = "";
    }

    public AnswerModel convertToModel(){
        AnswerModel answer = new AnswerModel();
        answer.setId(id);
        answer.setDescription(description);
        answer.setRight(right);
        return answer;
    }


}

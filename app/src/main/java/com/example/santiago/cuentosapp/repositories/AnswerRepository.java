package com.example.santiago.cuentosapp.repositories;

import android.content.Context;

import com.example.santiago.cuentosapp.R;
import com.example.santiago.cuentosapp.models.modelsDB.Answer;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by Santiago on 10/21/17.
 */

public class AnswerRepository {

    private Realm realm;

    private Context mContext;

    public AnswerRepository(Context mContext) {
        this.mContext = mContext;
        realm = Realm.getDefaultInstance();
    }

    public RealmList<Answer> answers(String idStory, String idQuestion) {

        switch (idStory) {
            case "1":
                return getAnswersPajarito(idQuestion);
            default:
                return new RealmList<>();
        }
    }


    public RealmList<Answer> getAnswersPajarito(String idQuestion) {
        RealmList<Answer> answers = new RealmList();

        switch (idQuestion){
            case "101":
                Answer answer1 = realm.createObject(Answer.class);
                answer1.id = "101R1";
                answer1.description = mContext.getString(R.string.pajarito_one_question_one_answer);
                answers.add(answer1);

                Answer answer2 = realm.createObject(Answer.class);
                answer2.id = "101R2";
                answer2.description = mContext.getString(R.string.pajarito_one_question_two_answer);
                answers.add(answer2);

                Answer answer3 = realm.createObject(Answer.class);
                answer3.id = "101R3";
                answer3.description = mContext.getString(R.string.pajarito_one_question_three_answer);
                answer3.right = true;
                answers.add(answer3);

                Answer answer4 = realm.createObject(Answer.class);
                answer4.id = "101R4";
                answer4.description = mContext.getString(R.string.pajarito_one_question_four_answer);
                answers.add(answer4);
                return answers;

            case "102":
                Answer answer5 = realm.createObject(Answer.class);
                answer5.id = "102R1";
                answer5.description = mContext.getString(R.string.pajarito_two_question_one_answer);
                answers.add(answer5);

                Answer answer6 = realm.createObject(Answer.class);
                answer6.id = "102R2";
                answer6.description = mContext.getString(R.string.pajaito_two_question_two_answer);
                answers.add(answer6);

                Answer answer7 = realm.createObject(Answer.class);
                answer7.id = "102R3";
                answer7.description = mContext.getString(R.string.pajarito_two_question_three_answer);
                answer7.right = true;
                answers.add(answer7);
                return answers;

            default:
                return new RealmList<Answer>();
        }

    }
}

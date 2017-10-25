package com.example.santiago.cuentosapp.repositories;

import android.content.Context;

import com.example.santiago.cuentosapp.R;
import com.example.santiago.cuentosapp.models.modelsDB.Question;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by Santiago on 10/21/17.
 */

public class QuestionRepository {

    private Realm realm;
    private Context mContext;
    private AnswerRepository answerRepository;

    public QuestionRepository(Context mContext) {
        this.mContext = mContext;
        this.answerRepository = new AnswerRepository(mContext);
        realm = Realm.getDefaultInstance();
    }

    public RealmList<Question> questions(final String idStory) {
        switch (idStory) {
            case "1":
                return getQuestionsPajarito(idStory);
            default:
                return new RealmList<>();
        }
    }


    public RealmList<Question> getQuestionsPajarito(String idStory) {
        RealmList<Question> questions = new RealmList();

        Question question1 = realm.createObject(Question.class);
        question1.id = "101";
        question1.description = mContext.getString(R.string.pajarito_one_question);
        question1.answers = answerRepository.answers(idStory, question1.id);
        questions.add(question1);

        Question question2 = realm.createObject(Question.class);
        question2.id = "102";
        question2.description = mContext.getString(R.string.pajarito_two_question);
        question2.answers = answerRepository.answers(idStory, question2.id);
        questions.add(question2);

        /*Question question3 = realm.createObject(Question.class);
        question3.id = "103";
        question3.description = mContext.getString(R.string.pajarito_three_question);
        questions.add(question3);*/
        return questions;
    }
}

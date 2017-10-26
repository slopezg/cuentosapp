package com.example.aventu.cuentosapp.repositories;

import android.content.Context;

import com.example.aventu.cuentosapp.R;
import com.example.aventu.cuentosapp.models.modelsDB.Question;

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
            case "2":
                return getQuestionsGatoTiaPepa(idStory);
            case "3":
                return getQuestionsPececito(idStory);
            case "4":
                return getQuestionsLeon(idStory);
            default:
                return new RealmList<>();
        }
    }


    private RealmList<Question> getQuestionsPajarito(String idStory) {
        RealmList<Question> questions = new RealmList();

        questions.add(newQuestion("101", mContext.getString(R.string.pajarito_one_question), idStory));
        questions.add(newQuestion("102", mContext.getString(R.string.pajarito_two_question), idStory));
        questions.add(newQuestion("103", mContext.getString(R.string.pajarito_three_question), idStory));
        return questions;
    }

    private RealmList<Question> getQuestionsGatoTiaPepa(String idStory) {
        RealmList<Question> questions = new RealmList();

        questions.add(newQuestion("201", mContext.getString(R.string.gato_one_question), idStory));
        questions.add(newQuestion("202", mContext.getString(R.string.gato_two_question), idStory));
        questions.add(newQuestion("203", mContext.getString(R.string.gato_three_question), idStory));
        questions.add(newQuestion("204", mContext.getString(R.string.gato_four_question), idStory));
        questions.add(newQuestion("205", mContext.getString(R.string.gato_five_question), idStory));
        return questions;
    }

    private RealmList<Question> getQuestionsPececito(String idStory) {
        RealmList<Question> questions = new RealmList();

        questions.add(newQuestion("301", mContext.getString(R.string.pececito_one_question), idStory));
        questions.add(newQuestion("302", mContext.getString(R.string.pececito_two_question), idStory));
        questions.add(newQuestion("303", mContext.getString(R.string.pececito_three_question), idStory));
        questions.add(newQuestion("304", mContext.getString(R.string.pececito_four_question), idStory));
        return questions;
    }

    private RealmList<Question> getQuestionsLeon(String idStory) {
        RealmList<Question> questions = new RealmList();

        questions.add(newQuestion("401", mContext.getString(R.string.leon_one_question), idStory));
        questions.add(newQuestion("402", mContext.getString(R.string.leon_two_question), idStory));
        questions.add(newQuestion("403", mContext.getString(R.string.leon_three_question), idStory));
        questions.add(newQuestion("404", mContext.getString(R.string.leon_four_question), idStory));
        return questions;
    }

    private Question newQuestion(String idQuestion, String description, String idStory){
        Question question = realm.createObject(Question.class);
        question.id = idQuestion;
        question.description = description;
        question.answers = answerRepository.answers(idStory, question.id);
        return question;
    }
}

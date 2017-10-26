package com.example.aventu.cuentosapp.repositories;

import android.content.Context;

import com.example.aventu.cuentosapp.R;
import com.example.aventu.cuentosapp.models.modelsDB.Answer;

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
            case "2":
                return getAnswersGatoTiaPepa(idQuestion);
            case "3":
                return getAnswersPececito(idQuestion);
            case "4":
                return getAnswersLeon(idQuestion);
            default:
                return new RealmList<>();
        }
    }


    private RealmList<Answer> getAnswersPajarito(String idQuestion) {
        RealmList<Answer> answers = new RealmList();

        switch (idQuestion) {
            case "101":
                answers.add(newAnswer("101R1", mContext.getString(R.string.pajarito_one_question_one_answer), false));
                answers.add(newAnswer("101R2", mContext.getString(R.string.pajarito_one_question_two_answer), false));
                answers.add(newAnswer("101R3", mContext.getString(R.string.pajarito_one_question_three_answer), true));
                answers.add(newAnswer("101R4", mContext.getString(R.string.pajarito_one_question_four_answer), false));
                return answers;

            case "102":
                answers.add(newAnswer("102R1", mContext.getString(R.string.pajarito_two_question_one_answer), false));
                answers.add(newAnswer("102R2", mContext.getString(R.string.pajaito_two_question_two_answer), false));
                answers.add(newAnswer("102R3", mContext.getString(R.string.pajarito_two_question_three_answer), true));
                return answers;

            case "103":
                answers.add(newAnswer("103R1", mContext.getString(R.string.pajarito_three_question_one_answer), true));
                answers.add(newAnswer("103R2", mContext.getString(R.string.pajarito_three_question_two_answer), false));
                answers.add(newAnswer("103R3", mContext.getString(R.string.pajarito_three_question_three_answer), false));
                answers.add(newAnswer("103R4", mContext.getString(R.string.pajarito_three_question_four_answer), false));
                return answers;

            default:
                return new RealmList<>();
        }

    }

    private RealmList<Answer> getAnswersGatoTiaPepa(String idQuestion) {
        RealmList<Answer> answers = new RealmList();

        switch (idQuestion) {
            case "201":
                answers.add(newAnswer("201R1", mContext.getString(R.string.gato_one_question_one_answer), false));
                answers.add(newAnswer("201R2", mContext.getString(R.string.gato_one_question_two_answer), true));
                answers.add(newAnswer("201R3", mContext.getString(R.string.gato_one_question_three_answer), false));
                return answers;

            case "202":
                answers.add(newAnswer("202R1", mContext.getString(R.string.gato_two_question_one_answer), false));
                answers.add(newAnswer("202R2", mContext.getString(R.string.gato_two_question_two_answer), false));
                answers.add(newAnswer("202R3", mContext.getString(R.string.gato_two_question_three_answer), false));
                answers.add(newAnswer("202R4", mContext.getString(R.string.gato_two_question_four_answer), true));
                return answers;

            case "203":
                answers.add(newAnswer("203R1", mContext.getString(R.string.gato_three_question_one_answer), false));
                answers.add(newAnswer("203R2", mContext.getString(R.string.gato_three_question_two_answer), true));
                answers.add(newAnswer("203R3", mContext.getString(R.string.gato_three_question_three_answer), false));
                answers.add(newAnswer("203R4", mContext.getString(R.string.gato_three_question_four_answer), false));
                return answers;

            case "204":
                answers.add(newAnswer("204R1", mContext.getString(R.string.gato_four_question_one_answer), false));
                answers.add(newAnswer("204R2", mContext.getString(R.string.gato_four_question_two_answer), false));
                answers.add(newAnswer("204R3", mContext.getString(R.string.gato_four_question_three_answer), false));
                answers.add(newAnswer("204R4", mContext.getString(R.string.gato_four_question_four_answer), true));
                return answers;

            case "205":
                answers.add(newAnswer("205R1", mContext.getString(R.string.gato_five_question_one_answer), false));
                answers.add(newAnswer("205R2", mContext.getString(R.string.gato_five_question_two_answer), true));
                answers.add(newAnswer("205R3", mContext.getString(R.string.gato_five_question_three_answer), false));
                answers.add(newAnswer("205R4", mContext.getString(R.string.gato_five_question_four_answer), false));
                return answers;

            default:
                return new RealmList<>();
        }

    }

    private RealmList<Answer> getAnswersPececito(String idQuestion) {
        RealmList<Answer> answers = new RealmList();

        switch (idQuestion) {
            case "301":
                answers.add(newAnswer("301R1", mContext.getString(R.string.pececito_one_question_one_answer), true));
                answers.add(newAnswer("301R2", mContext.getString(R.string.pececito_one_question_two_answer), false));
                answers.add(newAnswer("301R3", mContext.getString(R.string.pececito_one_question_three_answer), false));
                return answers;

            case "302":
                answers.add(newAnswer("302R1", mContext.getString(R.string.pececito_two_question_one_answer), true));
                answers.add(newAnswer("302R2", mContext.getString(R.string.pececito_two_question_two_answer), false));
                answers.add(newAnswer("302R3", mContext.getString(R.string.pececito_two_question_three_answer), false));
                answers.add(newAnswer("302R4", mContext.getString(R.string.pececito_two_question_four_answer), false));
                return answers;

            case "303":
                answers.add(newAnswer("303R1", mContext.getString(R.string.pececito_three_question_one_answer), false));
                answers.add(newAnswer("303R2", mContext.getString(R.string.pececito_three_question_two_answer), false));
                answers.add(newAnswer("303R3", mContext.getString(R.string.pececito_three_question_three_answer), true));
                answers.add(newAnswer("303R4", mContext.getString(R.string.pececito_three_question_four_answer), false));
                return answers;

            case "304":
                answers.add(newAnswer("304R1", mContext.getString(R.string.pececito_four_question_one_answer), false));
                answers.add(newAnswer("304R2", mContext.getString(R.string.pececito_four_question_two_answer), false));
                answers.add(newAnswer("304R3", mContext.getString(R.string.pececito_four_question_three_answer), false));
                answers.add(newAnswer("304R4", mContext.getString(R.string.pececito_four_question_four_answer), true));
                return answers;

            default:
                return new RealmList<>();
        }

    }

    private RealmList<Answer> getAnswersLeon(String idQuestion) {
        RealmList<Answer> answers = new RealmList();

        switch (idQuestion) {
            case "401":
                answers.add(newAnswer("401R1", mContext.getString(R.string.leon_one_question_one_answer), true));
                answers.add(newAnswer("401R2", mContext.getString(R.string.leon_one_question_two_answer), false));
                answers.add(newAnswer("401R3", mContext.getString(R.string.leon_one_question_three_answer), false));
                return answers;

            case "402":
                answers.add(newAnswer("402R1", mContext.getString(R.string.leon_two_question_one_answer), false));
                answers.add(newAnswer("402R2", mContext.getString(R.string.leon_two_question_two_answer), false));
                answers.add(newAnswer("402R3", mContext.getString(R.string.leon_two_question_three_answer), false));
                answers.add(newAnswer("402R4", mContext.getString(R.string.leon_two_question_four_answer), true));
                return answers;

            case "403":
                answers.add(newAnswer("403R1", mContext.getString(R.string.leon_three_question_one_answer), false));
                answers.add(newAnswer("403R2", mContext.getString(R.string.leon_three_question_two_answer), false));
                answers.add(newAnswer("403R3", mContext.getString(R.string.leon_three_question_three_answer), true));
                answers.add(newAnswer("403R4", mContext.getString(R.string.leon_three_question_four_answer), false));
                return answers;

            case "404":
                answers.add(newAnswer("404R1", mContext.getString(R.string.leon_four_question_one_answer), true));
                answers.add(newAnswer("404R2", mContext.getString(R.string.leon_four_question_two_answer), false));
                answers.add(newAnswer("404R3", mContext.getString(R.string.leon_four_question_three_answer), false));
                return answers;

            default:
                return new RealmList<>();
        }

    }

    public Answer newAnswer(String idAnswer, String description, boolean right) {
        Answer answer = realm.createObject(Answer.class);
        answer.id = idAnswer;
        answer.description = description;
        answer.right = right;
        return answer;
    }
}

package com.example.aventu.cuentosapp.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aventu.cuentosapp.R;
import com.example.aventu.cuentosapp.models.modelsDB.Question;
import com.example.aventu.cuentosapp.models.modelsbusiness.AnswerModel;
import com.example.aventu.cuentosapp.models.modelsbusiness.QuestionModel;
import com.example.aventu.cuentosapp.view.interfaces.ICheckBox;

/**
 * Created by Santiago on 10/21/17.
 */

public class QuestionFragment extends Fragment {

    private QuestionModel question;
    private ICheckBox iCheckBox;
    private FloatingActionButton fabNext;
    private boolean lastPosition;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        question = (QuestionModel) getArguments().getSerializable(Question.class.getName());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_questions, container, false);

        this.iCheckBox = (ICheckBox) getActivity();
        LinearLayout lyQuestion = rootView.findViewById(R.id.lyQuestion);
        TextView tvQuestion = rootView.findViewById(R.id.tvQuestion);
        fabNext = rootView.findViewById(R.id.fabNext);
        tvQuestion.setText(question.getDescription());

        for (AnswerModel answer : question.getAnswers()) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setTextSize(15);
            checkBox.setText(answer.getDescription());
            checkBox.setOnCheckedChangeListener(new MyCheckedChangeListener(answer.isRight()));
            lyQuestion.addView(checkBox);
        }

        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabNext.setVisibility(View.INVISIBLE);
                iCheckBox.next();
            }
        });

        return rootView;
    }

    public void setLastQuestion() {
        this.lastPosition = true;
    }

    public class MyCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        private boolean right;

        public MyCheckedChangeListener(boolean right) {
            this.right = right;
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            iCheckBox.enableNext(right);
            fabNext.setVisibility(View.VISIBLE);
            if(lastPosition)
                fabNext.setImageResource(R.drawable.check);
            else
                fabNext.setImageResource(R.drawable.next);
        }
    }
}

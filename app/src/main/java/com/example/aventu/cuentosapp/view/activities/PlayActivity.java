package com.example.aventu.cuentosapp.view.activities;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.aventu.cuentosapp.R;
import com.example.aventu.cuentosapp.models.modelsDB.Story;
import com.example.aventu.cuentosapp.models.modelsbusiness.StoryModel;
import com.example.aventu.cuentosapp.util.CustomViewPager;
import com.example.aventu.cuentosapp.view.adapters.PlayPagerAdapter;
import com.example.aventu.cuentosapp.view.interfaces.ICheckBox;

/**
 * Created by Santiago on 10/21/17.
 */

public class PlayActivity extends AppCompatActivity implements ICheckBox {

    private CustomViewPager viewPager;
    private StoryModel story;
    private LinearLayout rlPlay;
    private int countCorrectAnswers;
    private boolean isCorrect;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        rlPlay = (LinearLayout) findViewById(R.id.rlPlay);
        story = (StoryModel) getIntent().getSerializableExtra(Story.class.getName());
        viewPager = (CustomViewPager) findViewById(R.id.vpQuestions);
        viewPager.setAdapter(new PlayPagerAdapter(getSupportFragmentManager(), story));
        viewPager.setIsEnabled(false);

        setPlayBackground();
        configActionBar();
    }

    private void setPlayBackground() {
        switch (story.getId()){
            case "1":
                rlPlay.setBackgroundResource(R.drawable.fondo_pajarito);
                break;
            case "2":
                rlPlay.setBackgroundResource(R.drawable.fondo_gatotiapepa);
                break;
            case "3":
                rlPlay.setBackgroundResource(R.drawable.fondo_pececito);
                break;
            case "4":
                rlPlay.setBackgroundResource(R.drawable.fondo_senorleon);
                break;
        }
    }

    private void configActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(story.getName().isEmpty() ? "Juego" : "Juego: " + story.getName());
        }
    }

    @Override
    public void enableNext(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Override
    public void next() {
        if (isCorrect) {
            countCorrectAnswers++;
        }
        if (viewPager.getCurrentItem() == story.getQuestions().size() - 1) {
            showResults();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    private void showResults() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle(story.getName())
                .setMessage(getMessage())
                .setCancelable(false)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();
    }

    public String getMessage() {
        if (countCorrectAnswers == 0) {
            return getString(R.string.without_correct_answers);
        } else if (countCorrectAnswers == story.getQuestions().size()) {
            return getString(R.string.all_corrects_answers);
        } else {
            return "Has contestado " + String.valueOf(countCorrectAnswers) + " pregunta(s) correctamente";
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}

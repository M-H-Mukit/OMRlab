package com.example.mukit.omrlab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class AnswerInputActivity extends AppCompatActivity {

    public static final String ANSWERS = "answers";
    RadioGroup[] radioGroups;
    int[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_answer_input);

        radioGroups = new RadioGroup[20];
        answers = new int[20];

        radioGroups[0] = (RadioGroup) findViewById(R.id.rad1);
        radioGroups[1] = (RadioGroup) findViewById(R.id.rad2);
        radioGroups[2] = (RadioGroup) findViewById(R.id.rad3);
        radioGroups[3] = (RadioGroup) findViewById(R.id.rad4);
        radioGroups[4] = (RadioGroup) findViewById(R.id.rad5);
        radioGroups[5] = (RadioGroup) findViewById(R.id.rad6);
        radioGroups[6] = (RadioGroup) findViewById(R.id.rad7);
        radioGroups[7] = (RadioGroup) findViewById(R.id.rad8);
        radioGroups[8] = (RadioGroup) findViewById(R.id.rad9);
        radioGroups[9] = (RadioGroup) findViewById(R.id.rad10);
        radioGroups[10] = (RadioGroup) findViewById(R.id.rad11);
        radioGroups[11] = (RadioGroup) findViewById(R.id.rad12);
        radioGroups[12] = (RadioGroup) findViewById(R.id.rad13);
        radioGroups[13] = (RadioGroup) findViewById(R.id.rad14);
        radioGroups[14] = (RadioGroup) findViewById(R.id.rad15);
        radioGroups[15] = (RadioGroup) findViewById(R.id.rad16);
        radioGroups[16] = (RadioGroup) findViewById(R.id.rad17);
        radioGroups[17] = (RadioGroup) findViewById(R.id.rad18);
        radioGroups[18] = (RadioGroup) findViewById(R.id.rad19);
        radioGroups[19] = (RadioGroup) findViewById(R.id.rad20);

        for(int i=0; i<20; i++) {
            final int finalI = i;
            radioGroups[i].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    answers[finalI] = (checkedId - 1) % 4 + 1;
                }
            });
        }
    }

    public void saveAnswers(View v) {
        Intent scannedImg = new Intent(AnswerInputActivity.this, scanned_img.class);
        scannedImg.putExtra(ANSWERS, answers);
        startActivity(scannedImg);
    }

}

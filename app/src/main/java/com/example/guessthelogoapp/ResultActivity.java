package com.example.guessthelogoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView txtCorrectText;
    TextView txtPercentText;
    private int totalQuestions;
    private int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtCorrectText = findViewById(R.id.correct_textview);
        txtPercentText = findViewById(R.id.percent_textview);
        Intent intent = getIntent();
        totalQuestions = intent.getIntExtra("totalQuestions",0);
        finalScore = intent.getIntExtra("finalScore",0);
        int mPercentScore = finalScore * 100 / totalQuestions;
        txtPercentText.setText(String.format("%s%%",Integer.toString(Integer.valueOf(mPercentScore))));
        String finalScoreText = getString(R.string.txtCorrectScore, Integer.toString(finalScore),Integer.toString(totalQuestions));
        txtCorrectText.setText(finalScoreText);
    }

    public void Restart(View view){
        finish();
    }

}
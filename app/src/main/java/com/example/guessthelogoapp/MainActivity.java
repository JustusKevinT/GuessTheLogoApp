package com.example.guessthelogoapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView mQuizImage;
    private String mAnswer;
    private int mScore = 0;
    private int mQuizNum = 1;
    private int QuestionNum = 0;
    private TextView mQuestionView;
    private TextView mQuizNumView;
    private Questions mQuestions = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuestionView = findViewById(R.id.question_textview);
        mQuizNumView = findViewById(R.id.quiznum_textview);
        updateQuestion();
        Button submit = findViewById(R.id.button_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mQuestions.getType(QuestionNum) == "radiobutton"){
                    if(mQuestions.getCorrectAnswers(QuestionNum).equals(mAnswer)){
                        mScore++;
                        displayToastCorrectAnswer();
                    }
                    else {
                        displayToastWrongAnswer();
                    }
                }
                SystemClock.sleep(1000);
                if(QuestionNum == mQuestions.getLength() -1){
                    Intent intentResult = new Intent(MainActivity.this, ResultActivity.class);
                    intentResult.putExtra("totalQuestions",mQuestions.getLength());
                    intentResult.putExtra("finalScore",mScore);
                    startActivity(intentResult);
                    QuestionNum = 0;
                    mQuizNum = 0;
                    mScore = 0;
                }
                else{
                    QuestionNum++;
                    mQuizNum++;
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQuestion();
                    }
                },1000);
            }
        });
    }

    private void showMainImage(){
        mQuizImage = findViewById(R.id.quiz_image);
        String image = mQuestions.getImages(QuestionNum);
        mQuizImage.setImageResource(getResources().getIdentifier(image,"drawable",getPackageName()));
    }

    private void showRadioButtonAnswers(int qnum){
        final LinearLayout answerLayout = findViewById(R.id.answers_layout);
        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(RadioGroup.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        rg.setLayoutParams(lp);
        rg.setPadding(400,0,0,0);
        final RadioButton[] rb = new RadioButton[3];
        for(int i =0; i<=2;i++){
            rb[i] = new RadioButton(this);
            rb[i].setText(mQuestions.getChoice(qnum)[i]);
            rb[i].setTextColor(Color.BLACK);
            rb[i].setPadding(10,16,8,16);
            rb[i].setTextSize(25);
            rb[i].setId(i);
            rb[i].setWidth(1000);
            rg.addView(rb[i]);
        }
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int Id) {
                mAnswer = mQuestions.getChoice(QuestionNum)[Id];
            }
        });
        answerLayout.addView(rg);
    }

    private void updateQuestion(){
        LinearLayout answer_layout = findViewById(R.id.answers_layout);
        answer_layout.removeAllViews();
        mAnswer="";
        mQuizNumView.setText(mQuizNum + "/" + String.valueOf(mQuestions.getLength()));
        mQuestionView.setText(mQuestions.getQuestions(QuestionNum));
        if(mQuestions.getType(QuestionNum) == "radiobutton"){
            showRadioButtonAnswers(QuestionNum);
        }
        showMainImage();
        ScrollView sv = findViewById(R.id.scrollView);
        sv.smoothScrollTo(0,0);
    }

    private void displayToastCorrectAnswer(){
        Toast.makeText(this,"Right or Correct Answer",Toast.LENGTH_LONG).show();
    }

    private void displayToastWrongAnswer(){
      Toast.makeText(this,"Wrong or Incorrect Answer",Toast.LENGTH_LONG).show();
    }

}
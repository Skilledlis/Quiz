package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mAButton;
    private Button mBButton;
    private Button mCButton;
    private Button mDButton;
    private Button mNextButton;
    private Button mPrevButton;
    private ImageView mQuestionImageView;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[]{
        new Question(R.string.question1, R.drawable.quastion1,'C'),
        new Question(R.string.question2, R.drawable.quastion2,'B'),
        new Question(R.string.question3, R.drawable.quastion3, 'A'),
        new Question(R.string.question4,R.drawable.quastion4, 'B'),
    };

    private int mCurrentIndex = 0;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionImageView = findViewById(R.id.question_image_view);
        mQuestionTextView = findViewById(R.id.question_text_view);

        mAButton = findViewById(R.id.A_button);
        mAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer('A');
                updateQuestion();
            }
        });

        mBButton = findViewById(R.id.B_button);
        mBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer('B');
                updateQuestion();
            }
        });

        mCButton = findViewById(R.id.C_button);
        mCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer('C');
                updateQuestion();
            }
        });

        mDButton = findViewById(R.id.D_button);
        mDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer('C');
                updateQuestion();
            }
        });

        mNextButton = findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });
        mPrevButton = findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });

        updateQuestion();
    }

    private void checkAnswer(char userPressedTrue) {
        char answerTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId;

        if (userPressedTrue == answerTrue){
            messageResId = R.string.correct_toast;
        }else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion() {
        mCurrentIndex = (mCurrentIndex+1)%mQuestionBank.length;
        int questionText = mQuestionBank[mCurrentIndex].getTextResId();
        int questionImg = mQuestionBank[mCurrentIndex].getImgResId();
        mQuestionTextView.setText(questionText);
        mQuestionImageView.setImageResource(questionImg);
    }

}
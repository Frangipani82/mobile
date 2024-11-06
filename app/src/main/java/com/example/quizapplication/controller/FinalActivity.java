package com.example.quizapplication.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapplication.databinding.ActivityFinalBinding;
import com.example.quizapplication.model.Question;

import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {

    private ActivityFinalBinding binding;
    private int score;
    private int highestScore;
    private ArrayList<Question> wrongQuestionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Enabling view binding
        binding = ActivityFinalBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Activity always can be seen in portrait mode
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Enabling full screen
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        //Getting correctAnswers from the intent
        score = getIntent().getIntExtra("correctAnswers", 0);
        binding.tvScore.setText("Score: " + score);

        //Store highest score in shared preferences to maintain it after user closes the app
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        highestScore = preferences.getInt("highestScore", 0);

        //If actual score is higher than highest score, replace highest score with actual score
       if(score > highestScore) {
           highestScore = score;
           SharedPreferences.Editor editor = preferences.edit();
           editor.putInt("highestScore", highestScore);
           editor.apply();
        }

        binding.tvHighestScore.setText("Highest score: " + highestScore);

        //Getting the wrongQuestion list and if no wrong question disable the practice button
        wrongQuestionList = (ArrayList<Question>) getIntent().getSerializableExtra("wrongList");
        if(wrongQuestionList.size() == 0) {
            binding.btnPractice.setEnabled(false);
        }

        //OnClickListener for the Play again button
        binding.btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              playAgain();
            }
        });

        //OnClickListener for the Clear highest score button
        binding.btnClearHighestScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearHighestScore();
            }
        });

        //OnClickListener for the Practice button
        binding.btnPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             goToPractice();
            }
        });
    }

    //Start to play again
    public void playAgain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //Clear the highest score field
    public void clearHighestScore(){
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        binding.tvHighestScore.setText("Highest score: " + 0);
    }

    //Go to PracticeActivity
    public void goToPractice() {
        Intent intent = new Intent(this, PracticeActivity.class);
        intent.putExtra("wrongQuestionList", wrongQuestionList);
        startActivity(intent);
        finish();
    }
}
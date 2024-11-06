package com.example.quizapplication.controller;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapplication.R;
import com.example.quizapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Enabling view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Activity always can be seen in portrait mode
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Enabling full screen
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        //Getting radio buttons for changing text color
        RadioButton radio1 = findViewById(R.id.rb_easy);
        RadioButton radio2 = findViewById(R.id.rb_medium);
        RadioButton radio3 = findViewById(R.id.rb_hard);

        //OnClickListener for the Easy button
        radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio1.setTextColor(getColor(R.color.on_chosen_container));
                radio2.setTextColor(getColor(R.color.primary));
                radio3.setTextColor(getColor(R.color.primary));
            }
        });

        //OnClickListener for the Medium button
        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio2.setTextColor(getColor(R.color.on_chosen_container));
                radio1.setTextColor(getColor(R.color.primary));
                radio3.setTextColor(getColor(R.color.primary));
            }
        });

        //OnClickListener for the Hard button
        radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio3.setTextColor(getColor(R.color.on_chosen_container));
                radio1.setTextColor(getColor(R.color.primary));
                radio2.setTextColor(getColor(R.color.primary));
            }
        });

        //OnClickListener for the Start game button
        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check if there is any radio button selected
                if(!isLevelSelected()) {
                    noSelection();
                    return;
                }

                //If yes get the level and continue to the Question Activity
                getLevel();
                continueToPlay();
            }
        });
    }

    //Get the text of the selected radio button
    public void getLevel() {
        int radioSelected = binding.rgLevelsGroup.getCheckedRadioButtonId();
        RadioButton radioChecked = findViewById(radioSelected);
        level = String.valueOf(radioChecked.getText());
    }

    //Continue to the next activity
    public void continueToPlay() {
        Intent intent = new Intent(this, QuestionsActivity.class);
        intent.putExtra("level", level);
        startActivity(intent);
        finish();
    }

    // Check if any level is selected
    private boolean isLevelSelected() {
        int selectedRadioButtonId = binding.rgLevelsGroup.getCheckedRadioButtonId();
        return selectedRadioButtonId != -1; // -1 means no selection
    }

    //If no selection make a message
    private void noSelection() {
            Toast.makeText(this, "Select level", Toast.LENGTH_SHORT).show();
    }
}
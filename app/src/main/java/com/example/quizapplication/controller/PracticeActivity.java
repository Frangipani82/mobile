package com.example.quizapplication.controller;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapplication.R;
import com.example.quizapplication.databinding.ActivityPracticeBinding;
import com.example.quizapplication.model.Question;

import java.util.ArrayList;

public class PracticeActivity extends AppCompatActivity {

    private ActivityPracticeBinding binding;
    private ArrayList<Question> wrongQList;
    private int currentQuestionIndex = 0;
    private Question currentQuestion;
    private ArrayList<String> userAnswers;
    private Question firstQuestion;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Enabling view binding
        binding = ActivityPracticeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Activity always can be seen in portrait mode
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Enabling full screen
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        //Getting the wrong question list
        wrongQList = (ArrayList<Question>) getIntent().getSerializableExtra("wrongQuestionList");

        //ArrayList for the user answers
        userAnswers = new ArrayList<>();

        //Getting first question
        firstQuestion = wrongQList.get(0);

        //Displaying first question with question type
        showQuestion(firstQuestion);
        setQuestionType();
        showQuestionRemaining();

        //Getting radio buttons for changing text color
        RadioButton radio1 = findViewById(R.id.rb_answer_1);
        RadioButton radio2 = findViewById(R.id.rb_answer_2);
        RadioButton radio3 = findViewById(R.id.rb_answer_3);
        RadioButton radio4 = findViewById(R.id.rb_answer_4);

        //OnClickListener for Answer1 radio button
        radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio1.setTextColor(getColor(R.color.on_chosen_container));
                radio2.setTextColor(getColor(R.color.primary));
                radio3.setTextColor(getColor(R.color.primary));
                radio4.setTextColor(getColor(R.color.primary));
            }
        });

        //OnClickListener for Answer2 radio button
        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio2.setTextColor(getColor(R.color.on_chosen_container));
                radio1.setTextColor(getColor(R.color.primary));
                radio3.setTextColor(getColor(R.color.primary));
                radio4.setTextColor(getColor(R.color.primary));
            }
        });

        //OnClickListener for Answer3 radio button
        radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio3.setTextColor(getColor(R.color.on_chosen_container));
                radio1.setTextColor(getColor(R.color.primary));
                radio2.setTextColor(getColor(R.color.primary));
                radio4.setTextColor(getColor(R.color.primary));
            }
        });

        //OnClickListener for Answer4 radio button
        radio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio4.setTextColor(getColor(R.color.on_chosen_container));
                radio1.setTextColor(getColor(R.color.primary));
                radio2.setTextColor(getColor(R.color.primary));
                radio3.setTextColor(getColor(R.color.primary));
            }
        });

        //Getting check boxes to change text color
        CheckBox check1 = findViewById(R.id.chk_answer_1);
        CheckBox check2 = findViewById(R.id.chk_answer_2);
        CheckBox check3 = findViewById(R.id.chk_answer_3);
        CheckBox check4 = findViewById(R.id.chk_answer_4);

        //OnClickListener for Answer1 check box
        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check1.isChecked()){
                    check1.setTextColor(getColor(R.color.on_chosen_container));
                }else{
                    check1.setTextColor(getColor(R.color.primary));
                }
            }
        });

        //OnClickListener for Answer2 check box
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check2.isChecked()){
                    check2.setTextColor(getColor(R.color.on_chosen_container));
                }else{
                    check2.setTextColor(getColor(R.color.primary));
                }
            }
        });

        //OnClickListener for Answer3 check box
        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check3.isChecked()){
                    check3.setTextColor(getColor(R.color.on_chosen_container));
                }else{
                    check3.setTextColor(getColor(R.color.primary));
                }
            }
        });

        //OnClickListener for Answer4 check box
        check4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check4.isChecked()){
                    check4.setTextColor(getColor(R.color.on_chosen_container));
                }else{
                    check4.setTextColor(getColor(R.color.primary));
                }
            }
        });

        //OnClickListener for the Next question button
        binding.btnNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 0) {
                    answerCorrect();

                    //If there is no selected answer wait until there is
                    if(!isAnyAnswerSelected(currentQuestion)) {
                        count = 0;

                    //Else changing button text
                    } else {
                        if(wrongQList.size() == 0) {
                            binding.btnNextQuestion.setText(getResources().getString(R.string.finish));
                        } else {
                            binding.btnNextQuestion.setText(getResources().getString(R.string.next_question));
                        }
                        count++;
                    }

                //At the last question go to next activity
                } else {
                    if(wrongQList.size() == 0) {
                        goToStart();
                        return;

                    //If not at the last question continue setting questions
                    } else {
                        setTexts();
                        count--;
                    }
                }
            }
        });
    }

    //Displaying the actual question
    public void showQuestion(Question q) {

        //Clearing the selection and the correct or wrong answer background
        clearRadioButtons();
        clearCheckBoxes();

        binding.tvQuestion.setText(q.getQuestion());
        if(q.getCorrectAnswers().size() == 1) {

            //Setting visibility to visible for radio button group
            binding.llAnswersCheckBoxes.setVisibility(View.GONE);
            binding.rgAnswersGroup.setVisibility(View.VISIBLE);

            binding.rbAnswer1.setText(q.getAnswers().get(0));
            binding.rbAnswer2.setText(q.getAnswers().get(1));
            binding.rbAnswer3.setText(q.getAnswers().get(2));
            binding.rbAnswer4.setText(q.getAnswers().get(3));
        } else {

            //Setting visibility to visible for checkboxes
            binding.rgAnswersGroup.setVisibility(View.GONE);
            binding.llAnswersCheckBoxes.setVisibility(View.VISIBLE);

            binding.chkAnswer1.setText(q.getAnswers().get(0));
            binding.chkAnswer2.setText(q.getAnswers().get(1));
            binding.chkAnswer3.setText(q.getAnswers().get(2));
            binding.chkAnswer4.setText(q.getAnswers().get(3));
        }
    }

    //Changing and displaying the questions on the screen
    public void setTexts() {
        binding.btnNextQuestion.setText(getResources().getString(R.string.check_answer));
        showQuestion(getCurrentQuestion());
        setQuestionType();
        showQuestionRemaining();
    }

    //Getting the actual question
    public Question getCurrentQuestion() {
        currentQuestion = wrongQList.get(currentQuestionIndex);
        return currentQuestion;
    }

    //Displaying the type of the actual question
    public void setQuestionType() {
        Question currentQuestion = getCurrentQuestion();
        if(currentQuestion.getCorrectAnswers().size() == 1) {
            binding.tvQuestionType.setText(getResources().getString(R.string.one_choice));
        } else {
            binding.tvQuestionType.setText(getResources().getString(R.string.multiple_choice));
        }
    }

    //Clearing the checks and the correct or incorrect backgrounds of the check boxes
    public void clearCheckBoxes() {
        if(binding.chkAnswer1.isChecked()) {
            binding.chkAnswer1.setChecked(false);
            binding.chkAnswer1.setBackgroundResource(R.drawable.button_background);
            binding.chkAnswer1.setTextColor(getColor(R.color.primary));
        }
        if(binding.chkAnswer2.isChecked()) {
            binding.chkAnswer2.setChecked(false);
            binding.chkAnswer2.setBackgroundResource(R.drawable.button_background);
            binding.chkAnswer2.setTextColor(getColor(R.color.primary));
        }
        if(binding.chkAnswer3.isChecked()) {
            binding.chkAnswer3.setChecked(false);
            binding.chkAnswer3.setBackgroundResource(R.drawable.button_background);
            binding.chkAnswer3.setTextColor(getColor(R.color.primary));
        }
        if(binding.chkAnswer4.isChecked()) {
            binding.chkAnswer4.setChecked(false);
            binding.chkAnswer4.setBackgroundResource(R.drawable.button_background);
            binding.chkAnswer4.setTextColor(getColor(R.color.primary));
        }
    }

    //Clearing the checks and the correct or incorrect backgrounds of the radio buttons
    private void clearRadioButtons() {
        binding.rgAnswersGroup.clearCheck();
        for(int i = 0; i < binding.rgAnswersGroup.getChildCount(); i++) {
            RadioButton button = (RadioButton) binding.rgAnswersGroup.getChildAt(i);
            button.setBackgroundResource(R.drawable.button_background);
            button.setTextColor(getColor(R.color.primary));
        }
    }

   /* Populating the userAnswers arrayList with the texts of the buttons
    and setting the background of the buttons depending if the answer is correct or not*/
    public ArrayList<String> addUserAnswer() {

        //Clearing user answers
        userAnswers.clear();
        Question currentQuestion = getCurrentQuestion();

        //Getting user answer from radio button
        if(currentQuestion.getCorrectAnswers().size() == 1) {
            int radioSelected = binding.rgAnswersGroup.getCheckedRadioButtonId();
            RadioButton radioChecked = findViewById(radioSelected);
            userAnswers.add(String.valueOf(radioChecked.getText()));
            if(currentQuestion.getCorrectAnswers().contains(String.valueOf(radioChecked.getText()))) {
                radioChecked.setBackgroundResource(R.drawable.shape_correct);
                radioChecked.setTextColor(getColor(R.color.on_correct_container));
            } else {
                radioChecked.setBackgroundResource(R.drawable.shape_not_correct);
                radioChecked.setTextColor(getColor(R.color.on_error_container));
            }

        //Getting user answers from check boxes
        } else {
            if(binding.chkAnswer1.isChecked()) {
                userAnswers.add(String.valueOf(binding.chkAnswer1.getText()));
                if(currentQuestion.getCorrectAnswers().contains(String.valueOf(binding.chkAnswer1.getText()))) {
                    binding.chkAnswer1.setBackgroundResource(R.drawable.shape_correct);
                    binding.chkAnswer1.setTextColor(getColor(R.color.on_correct_container));
                } else {
                    binding.chkAnswer1.setBackgroundResource(R.drawable.shape_not_correct);
                    binding.chkAnswer1.setTextColor(getColor(R.color.on_error_container));
                }
            }
            if(binding.chkAnswer2.isChecked()) {
                userAnswers.add(String.valueOf(binding.chkAnswer2.getText()));
                if(currentQuestion.getCorrectAnswers().contains(String.valueOf(binding.chkAnswer2.getText()))) {
                    binding.chkAnswer2.setBackgroundResource(R.drawable.shape_correct);
                    binding.chkAnswer2.setTextColor(getColor(R.color.on_correct_container));
                } else {
                    binding.chkAnswer2.setBackgroundResource(R.drawable.shape_not_correct);
                    binding.chkAnswer2.setTextColor(getColor(R.color.on_error_container));
                }
            }
            if(binding.chkAnswer3.isChecked()) {
                userAnswers.add(String.valueOf(binding.chkAnswer3.getText()));
                if(currentQuestion.getCorrectAnswers().contains(String.valueOf(binding.chkAnswer3.getText()))) {
                    binding.chkAnswer3.setBackgroundResource(R.drawable.shape_correct);
                    binding.chkAnswer3.setTextColor(getColor(R.color.on_correct_container));
                } else {
                    binding.chkAnswer3.setBackgroundResource(R.drawable.shape_not_correct);
                    binding.chkAnswer3.setTextColor(getColor(R.color.on_error_container));
                }
            }
            if(binding.chkAnswer4.isChecked()) {
                userAnswers.add(String.valueOf(binding.chkAnswer4.getText()));
                if(currentQuestion.getCorrectAnswers().contains(String.valueOf(binding.chkAnswer4.getText()))) {
                    binding.chkAnswer4.setBackgroundResource(R.drawable.shape_correct);
                    binding.chkAnswer4.setTextColor(getColor(R.color.on_correct_container));
                } else {
                    binding.chkAnswer4.setBackgroundResource(R.drawable.shape_not_correct);
                    binding.chkAnswer4.setTextColor(getColor(R.color.on_error_container));
                }
            }
        }
        return userAnswers;
    }

    // Check if any answer (radio button or checkbox) is selected
    private boolean isAnyAnswerSelected(Question q) {
        if(q.getCorrectAnswers().size() == 1) {

            // For single-choice questions, check if any radio button is selected
            int selectedRadioButtonId = binding.rgAnswersGroup.getCheckedRadioButtonId();
            return selectedRadioButtonId != -1; // -1 means no selection
        } else {

            // For multiple-choice questions, check if at least one checkbox is selected
            return binding.chkAnswer1.isChecked() || binding.chkAnswer2.isChecked() ||
                    binding.chkAnswer3.isChecked() || binding.chkAnswer4.isChecked();
        }
    }

    //Checking if answer is correct or not
    public void answerCorrect() {
        Question currentQuestion = getCurrentQuestion();

        //If no answer is selected show message
        if(!isAnyAnswerSelected(currentQuestion)) {
            Toast.makeText(this, "Select answer", Toast.LENGTH_SHORT).show();
            return;
        }
        addUserAnswer();

        //If answer is correct remove correct question
        if(currentQuestion.isAnswerCorrect(userAnswers, currentQuestion.getCorrectAnswers())) {
            wrongQList.remove(currentQuestion);

            //Next if statement is from https://claude.ai
           if(currentQuestionIndex >= wrongQList.size()) {
               currentQuestionIndex = 0;
           }
        } else {
            currentQuestionIndex++;
            if(currentQuestionIndex >= wrongQList.size()) {
                currentQuestionIndex = 0;
            }
        }
    }

    //After the last question takes the user to the MainActivity
    public void goToStart() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //Showing the remaining questions
    public void showQuestionRemaining() {
        binding.tvQuestionNumber.setText("Questions remaining: " + String.valueOf(wrongQList.size()));
    }
}
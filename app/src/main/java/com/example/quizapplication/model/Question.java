package com.example.quizapplication.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {

    private String question;
    private ArrayList<String> answers;
    private ArrayList<String> correctAnswers;
    private ArrayList<String> playerAnswers;

    //Constructor
    public Question(String question, ArrayList<String> answers, ArrayList<String> correctAnswers) {
        this.question = question;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
    }

    //Getters and setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public ArrayList<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(ArrayList<String> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public ArrayList<String> getPlayerAnswers() {
        return playerAnswers;
    }

    public void setPlayerAnswers(ArrayList<String> playerAnswers) {
        this.playerAnswers = playerAnswers;
    }


   /* Overriding the equals method to compare in the test whether the arrays
    containing the questions are equal */
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj instanceof Question) {
            Question q = (Question) obj;
            return (question.equals(q.question) &&
                    answers.equals(q.answers) &&
                    correctAnswers.equals(q.correctAnswers));
        } else return super.equals(obj);
    }

    //Method checking whether the playerAnswers is equal to correctAnswers
    public boolean isAnswerCorrect(ArrayList<String> playerAnswers, ArrayList<String> correctAnswers) {
        if(playerAnswers.equals(correctAnswers)) {
            return true;
        } else {
            return false;
        }
    }
}
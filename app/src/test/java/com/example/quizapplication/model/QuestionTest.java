package com.example.quizapplication.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class QuestionTest {

    private Question question1;
    private ArrayList<String> answers1 = new ArrayList<>();
    private ArrayList<String> correctAnswers1 = new ArrayList<>();

    @Before
    public void setQuestions() {

        //Setting up questions for all tests
        answers1.add("Monday");
        answers1.add("Tuesday");
        answers1.add("January");
        answers1.add("February");
        correctAnswers1.add("Monday");
        correctAnswers1.add("Tuesday");
        question1 = new Question("Which are days of the week?", answers1, correctAnswers1);
    }


    @Test
    public void testTestEquals() {

        //Expected return value
        boolean expected = true;

        //Setting up second question
        ArrayList<String> answers2 = new ArrayList<>();
        ArrayList<String> correctAnswers2 = new ArrayList<>();
        answers2.add("Monday");
        answers2.add("Tuesday");
        answers2.add("January");
        answers2.add("February");
        correctAnswers2.add("Monday");
        correctAnswers2.add("Tuesday");
        Question question2 = new Question("Which are days of the week?", answers2, correctAnswers2);

        //Checking if method result is the same as expected result
        boolean actual = question1.equals(question2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsAnswerCorrect() {

        //Expected result
        boolean expected = true;

        //Setting up array user answers
        ArrayList<String> userAnswers = new ArrayList<>();
        userAnswers.add("Monday");
        userAnswers.add("Tuesday");

        //Checking if method result is the same as expected result
        boolean actual = question1.isAnswerCorrect(userAnswers, correctAnswers1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetQuestion() {

        //Expected result
        boolean expected = true;
        String question = "Which are days of the week?";

        //Checking if method result is the same as expected result
        boolean actual = question.equals(question1.getQuestion());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAnswers() {

        //Expected result
        boolean expected = true;

        //Setting up answers
        ArrayList<String> answers = new ArrayList<>();
        answers.add("Monday");
        answers.add("Tuesday");
        answers.add("January");
        answers.add("February");

        //Checking if method result is the same as expected result
        boolean actual = answers.equals(question1.getAnswers());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCorrectAnswers() {

        //Expected result
        boolean expected = true;

        //Setting up correct answers
        ArrayList<String> correctAnswers = new ArrayList<>();
        correctAnswers.add("Monday");
        correctAnswers.add("Tuesday");

        //Checking if method result is the same as expected result
        boolean actual = correctAnswers.equals(question1.getCorrectAnswers());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetQuestion() {

        //Expected result
        boolean expected = true;

        //Setting new question
        String newQuestion = "What are months of the year?";
        question1.setQuestion(newQuestion);
        String actualQuestion = question1.getQuestion();

        //Checking if method result is the same as expected result
        boolean actual = newQuestion.equals(actualQuestion);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetAnswers() {

        //Expected result
        boolean expected = true;

        //Setting new answers
        ArrayList<String> newAnswers = new ArrayList<>();
        newAnswers.add("September");
        newAnswers.add("October");
        newAnswers.add("November");
        newAnswers.add("December");
        question1.setAnswers(newAnswers);
        ArrayList<String> actualAnswers = question1.getAnswers();

        //Checking if method result is the same as expected result
        boolean actual = newAnswers.equals(actualAnswers);

        Assert.assertEquals(expected, actual);
    }
}
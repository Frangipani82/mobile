package com.example.quizapplication.model;

import junit.framework.TestCase;

import org.junit.Assert;

import java.util.ArrayList;

public class QuestionsListTest extends TestCase {

    public void testGetQuestionsList() {

        //Variable for the question list and the level
        ArrayList<Question> easyExpected = new ArrayList<>();
        String easyLevel = "Easy";

        //Adding the same questions as in the original method
        ArrayList<String> easyAnswers1 = new ArrayList<String>();
        ArrayList<String> easyCorrectAnswers1 = new ArrayList<String>();
        easyAnswers1.add("Mammals");
        easyAnswers1.add("Amphibians");
        easyAnswers1.add("Reptiles");
        easyAnswers1.add("Birds");
        easyCorrectAnswers1.add("Amphibians");
        easyCorrectAnswers1.add("Reptiles");
        Question easyQuestion1 = new Question("What does the herpetology study?", easyAnswers1, easyCorrectAnswers1);
        easyExpected.add(easyQuestion1);

        ArrayList<String> easyAnswers2 = new ArrayList<String>();
        ArrayList<String> easyCorrectAnswers2 = new ArrayList<String>();
        easyAnswers2.add("Carotenoids");
        easyAnswers2.add("Betalains");
        easyAnswers2.add("Anthocyanins");
        easyAnswers2.add("Chlorophyll");
        easyCorrectAnswers2.add("Chlorophyll");
        Question easyQuestion2 = new Question("What gives the plants a green color?", easyAnswers2, easyCorrectAnswers2);
        easyExpected.add(easyQuestion2);

        ArrayList<String> easyAnswers3 = new ArrayList<String>();
        ArrayList<String> easyCorrectAnswers3 = new ArrayList<String>();
        easyAnswers3.add("30");
        easyAnswers3.add("31");
        easyAnswers3.add("32");
        easyAnswers3.add("33");
        easyCorrectAnswers3.add("32");
        Question easyQuestion3 = new Question("How many teeth does an adult human have?", easyAnswers3, easyCorrectAnswers3);
        easyExpected.add(easyQuestion3);

        ArrayList<String> easyAnswers4 = new ArrayList<String>();
        ArrayList<String> easyCorrectAnswers4 = new ArrayList<String>();
        easyAnswers4.add("Lynx");
        easyAnswers4.add("Lion");
        easyAnswers4.add("Hyena");
        easyAnswers4.add("Dingo");
        easyCorrectAnswers4.add("Lynx");
        easyCorrectAnswers4.add("Lion");
        Question easyQuestion4 = new Question("Which animals do belong to the Felidae family?", easyAnswers4, easyCorrectAnswers4);
        easyExpected.add(easyQuestion4);

        ArrayList<String> easyAnswers5 = new ArrayList<String>();
        ArrayList<String> easyCorrectAnswers5 = new ArrayList<String>();
        easyAnswers5.add("Salamander");
        easyAnswers5.add("Snake");
        easyAnswers5.add("Frog");
        easyAnswers5.add("Gecko");
        easyCorrectAnswers5.add("Salamander");
        easyCorrectAnswers5.add("Frog");
        Question easyQuestion5 = new Question("What is not a reptile?", easyAnswers5, easyCorrectAnswers5);
        easyExpected.add(easyQuestion5);

        ArrayList<String> easyAnswers6 = new ArrayList<String>();
        ArrayList<String> easyCorrectAnswers6 = new ArrayList<String>();
        easyAnswers6.add("Sumatra");
        easyAnswers6.add("Thailand");
        easyAnswers6.add("Borneo");
        easyAnswers6.add("Java");
        easyCorrectAnswers6.add("Sumatra");
        easyCorrectAnswers6.add("Borneo");
        Question easyQuestion6 = new Question("Where does the orangutan live?", easyAnswers6, easyCorrectAnswers6);
        easyExpected.add(easyQuestion6);

        ArrayList<String> easyAnswers7 = new ArrayList<String>();
        ArrayList<String> easyCorrectAnswers7 = new ArrayList<String>();
        easyAnswers7.add("Venus flytrap");
        easyAnswers7.add("Corkscrew plant");
        easyAnswers7.add("Snapdragon");
        easyAnswers7.add("Parrot pitcher plant");
        easyCorrectAnswers7.add("Snapdragon");
        Question easyQuestion7 = new Question("Which is not a carnivorous plant?", easyAnswers7, easyCorrectAnswers7);
        easyExpected.add(easyQuestion7);

        ArrayList<String> easyAnswers8 = new ArrayList<String>();
        ArrayList<String> easyCorrectAnswers8 = new ArrayList<String>();
        easyAnswers8.add("Horse");
        easyAnswers8.add("Zebra");
        easyAnswers8.add("Giraffe");
        easyAnswers8.add("Camel");
        easyCorrectAnswers8.add("Horse");
        easyCorrectAnswers8.add("Zebra");
        Question easyQuestion8 = new Question("What is not an even-toed ungulate?", easyAnswers8, easyCorrectAnswers8);
        easyExpected.add(easyQuestion8);

        ArrayList<String> easyAnswers9 = new ArrayList<String>();
        ArrayList<String> easyCorrectAnswers9 = new ArrayList<String>();
        easyAnswers9.add("Solid");
        easyAnswers9.add("Gas");
        easyAnswers9.add("Liquid");
        easyAnswers9.add("Jelly");
        easyCorrectAnswers9.add("Liquid");
        Question easyQuestion9 = new Question("What kind of texture has the food of the fly?", easyAnswers9, easyCorrectAnswers9);
        easyExpected.add(easyQuestion9);

        ArrayList<String> easyAnswers10 = new ArrayList<String>();
        ArrayList<String> easyCorrectAnswers10 = new ArrayList<String>();
        easyAnswers10.add("1-2");
        easyAnswers10.add("8-10");
        easyAnswers10.add("5-8");
        easyAnswers10.add("3-10");
        easyCorrectAnswers10.add("5-8");
        Question easyQuestion10 = new Question("Generally, how many cubs does the rabbit give birth to at once?", easyAnswers10, easyCorrectAnswers10);
        easyExpected.add(easyQuestion10);

        //Variables to get the questions from the original method
        QuestionsList actual = new QuestionsList();
        ArrayList<Question> actualQuestions = new ArrayList<>();

        //Testing the if. If the level equals easy the easy questions should be returned
        if(easyLevel.equals("Easy")) {
            actualQuestions = actual.addEasyQuestions();
        }
        Assert.assertEquals(easyExpected, actualQuestions);
    }

    public void testGetQuestionsList2() {

        //Variable for the question list and the level
        ArrayList<Question> mediumExpected = new ArrayList<>();
        String mediumLevel = "Medium";

        //Adding the same questions as in the original method
        ArrayList<String> mediumAnswers1 = new ArrayList<String>();
        ArrayList<String> mediumCorrectAnswers1 = new ArrayList<String>();
        mediumAnswers1.add("528 years");
        mediumAnswers1.add("6320 years");
        mediumAnswers1.add("3266 years");
        mediumAnswers1.add("2478 years");
        mediumCorrectAnswers1.add("3266 years");
        Question mediumQuestion1 = new Question("How old is the oldest living sequoia (tree)?", mediumAnswers1, mediumCorrectAnswers1);
        mediumExpected.add(mediumQuestion1);

        ArrayList<String> mediumAnswers2 = new ArrayList<String>();
        ArrayList<String> mediumCorrectAnswers2 = new ArrayList<String>();
        mediumAnswers2.add("Mus aculus");
        mediumAnswers2.add("Mus musculus");
        mediumAnswers2.add("Mus reolus");
        mediumAnswers2.add("Mus teanolus");
        mediumCorrectAnswers2.add("Mus musculus");
        Question mediumQuestion2 = new Question("What is the scientific name of the house mouse?", mediumAnswers2, mediumCorrectAnswers2);
        mediumExpected.add(mediumQuestion2);

        ArrayList<String> mediumAnswers3 = new ArrayList<String>();
        ArrayList<String> mediumCorrectAnswers3 = new ArrayList<String>();
        mediumAnswers3.add("360");
        mediumAnswers3.add("180");
        mediumAnswers3.add("90");
        mediumAnswers3.add("240");
        mediumCorrectAnswers3.add("360");
        Question mediumQuestion3 = new Question("How many degrees of vision a fly has?", mediumAnswers3, mediumCorrectAnswers3);
        mediumExpected.add(mediumQuestion3);

        ArrayList<String> mediumAnswers4 = new ArrayList<String>();
        ArrayList<String> mediumCorrectAnswers4 = new ArrayList<String>();
        mediumAnswers4.add("Cockroach");
        mediumAnswers4.add("Ant");
        mediumAnswers4.add("Fly");
        mediumAnswers4.add("Locust");
        mediumCorrectAnswers4.add("Ant");
        Question mediumQuestion4 = new Question("Which is the most numerous insect in the word?", mediumAnswers4, mediumCorrectAnswers4);
        mediumExpected.add(mediumQuestion4);

        ArrayList<String> mediumAnswers5 = new ArrayList<String>();
        ArrayList<String> mediumCorrectAnswers5 = new ArrayList<String>();
        mediumAnswers5.add("Waggle dance");
        mediumAnswers5.add("Thor dance");
        mediumAnswers5.add("Round dance");
        mediumAnswers5.add("Circle dance");
        mediumCorrectAnswers5.add("Waggle dance");
        Question mediumQuestion5 = new Question("What is the typical communication of the honey bees?", mediumAnswers5, mediumCorrectAnswers5);
        mediumExpected.add(mediumQuestion5);

        ArrayList<String> mediumAnswers6 = new ArrayList<String>();
        ArrayList<String> mediumCorrectAnswers6 = new ArrayList<String>();
        mediumAnswers6.add("White blood cells");
        mediumAnswers6.add("Red blood cells");
        mediumAnswers6.add("Plasma");
        mediumAnswers6.add("Platelets");
        mediumCorrectAnswers6.add("Red blood cells");
        Question mediumQuestion6 = new Question("What carries the oxygen in the blood?", mediumAnswers6, mediumCorrectAnswers6);
        mediumExpected.add(mediumQuestion6);

        ArrayList<String> mediumAnswers7 = new ArrayList<String>();
        ArrayList<String> mediumCorrectAnswers7 = new ArrayList<String>();
        mediumAnswers7.add("Cerebral cortex");
        mediumAnswers7.add("Cerebellum");
        mediumAnswers7.add("Occipital lobe");
        mediumAnswers7.add("Frontal lobe");
        mediumCorrectAnswers7.add("Occipital lobe");
        Question mediumQuestion7 = new Question("Where is the visual area in the brain?", mediumAnswers7, mediumCorrectAnswers7);
        mediumExpected.add(mediumQuestion7);

        ArrayList<String> mediumAnswers8 = new ArrayList<String>();
        ArrayList<String> mediumCorrectAnswers8 = new ArrayList<String>();
        mediumAnswers8.add("Kiwi");
        mediumAnswers8.add("Shoebill");
        mediumAnswers8.add("Pangolin");
        mediumAnswers8.add("Great potoo");
        mediumCorrectAnswers8.add("Kiwi");
        mediumCorrectAnswers8.add("Shoebill");
        mediumCorrectAnswers8.add("Great potoo");
        Question mediumQuestion8 = new Question("Which animals are birds?", mediumAnswers8, mediumCorrectAnswers8);
        mediumExpected.add(mediumQuestion8);

        ArrayList<String> mediumAnswers9 = new ArrayList<String>();
        ArrayList<String> mediumCorrectAnswers9 = new ArrayList<String>();
        mediumAnswers9.add("Golden toad");
        mediumAnswers9.add("Dodo");
        mediumAnswers9.add("Hoatzin");
        mediumAnswers9.add("Sword-billed hummingbird");
        mediumCorrectAnswers9.add("Golden toad");
        mediumCorrectAnswers9.add("Dodo");
        Question mediumQuestion9 = new Question("Which animals are extinct?", mediumAnswers9, mediumCorrectAnswers9);
        mediumExpected.add(mediumQuestion9);

        ArrayList<String> mediumAnswers10 = new ArrayList<String>();
        ArrayList<String> mediumCorrectAnswers10 = new ArrayList<String>();
        mediumAnswers10.add("Gibbon");
        mediumAnswers10.add("Swan");
        mediumAnswers10.add("Hamster");
        mediumAnswers10.add("Llama");
        mediumCorrectAnswers10.add("Gibbon");
        mediumCorrectAnswers10.add("Swan");
        Question mediumQuestion10 = new Question("Which animals choose their partner for a lifetime?", mediumAnswers10, mediumCorrectAnswers10);
        mediumExpected.add(mediumQuestion10);

        //Variables to get the questions from the original method
        QuestionsList actual = new QuestionsList();
        ArrayList<Question> actualQuestions = new ArrayList<>();

        //Testing the else if. If the level equals medium the medium questions should be returned
        if(mediumLevel.equals("Medium")) {
            actualQuestions = actual.addMediumQuestions();
        }
        Assert.assertEquals(mediumExpected, actualQuestions);
    }
    
    public void testGetQuestionsList3() {

        //Variable for the question list and the level
        ArrayList<Question> hardExpected = new ArrayList<>();

        //Adding the same questions as in the original method
        ArrayList<String> hardAnswers1 = new ArrayList<String>();
        ArrayList<String> hardCorrectAnswers1 = new ArrayList<String>();
        hardAnswers1.add("Mouse lemur");
        hardAnswers1.add("Mini lemur");
        hardAnswers1.add("Big-eyed lemur");
        hardAnswers1.add("Woolly lemur");
        hardCorrectAnswers1.add("Mouse lemur");
        Question hardQuestion1 = new Question("What kind of lemur is Mort from Madagascar?", hardAnswers1, hardCorrectAnswers1);
        hardExpected.add(hardQuestion1);

        ArrayList<String> hardAnswers2 = new ArrayList<String>();
        ArrayList<String> hardCorrectAnswers2 = new ArrayList<String>();
        hardAnswers2.add("206");
        hardAnswers2.add("234");
        hardAnswers2.add("270");
        hardAnswers2.add("258");
        hardCorrectAnswers2.add("270");
        Question hardQuestion2 = new Question("How many bones does a newborn human have?", hardAnswers2, hardCorrectAnswers2);
        hardExpected.add(hardQuestion2);

        ArrayList<String> hardAnswers3 = new ArrayList<String>();
        ArrayList<String> hardCorrectAnswers3 = new ArrayList<String>();
        hardAnswers3.add("Takakia ceratophylla");
        hardAnswers3.add("Tetraphis pellucida");
        hardAnswers3.add("Oedipodium grachianum");
        hardAnswers3.add("Andreaea almina");
        hardCorrectAnswers3.add("Oedipodium grachianum");
        hardCorrectAnswers3.add("Andreaea almina");
        Question hardQuestion3 = new Question("What kinds of moss do not exist?", hardAnswers3, hardCorrectAnswers3);
        hardExpected.add(hardQuestion3);

        ArrayList<String> hardAnswers4 = new ArrayList<String>();
        ArrayList<String> hardCorrectAnswers4 = new ArrayList<String>();
        hardAnswers4.add("Os lunatum");
        hardAnswers4.add("Os cuboideum");
        hardAnswers4.add("Os naviculare");
        hardAnswers4.add("Os capitatum");
        hardCorrectAnswers4.add("Os lunatum");
        hardCorrectAnswers4.add("Os capitatum");
        Question hardQuestion4 = new Question("Which human bones form part of the hand?", hardAnswers4, hardCorrectAnswers4);
        hardExpected.add(hardQuestion4);

        ArrayList<String> hardAnswers5 = new ArrayList<String>();
        ArrayList<String> hardCorrectAnswers5 = new ArrayList<String>();
        hardAnswers5.add("68 billion");
        hardAnswers5.add("2 trillion");
        hardAnswers5.add("35 trillion");
        hardAnswers5.add("950 billion");
        hardCorrectAnswers5.add("35 trillion");
        Question hardQuestion5 = new Question("Generally, how many red blood cells are in the human body?", hardAnswers5, hardCorrectAnswers5);
        hardExpected.add(hardQuestion5);

        ArrayList<String> hardAnswers6 = new ArrayList<String>();
        ArrayList<String> hardCorrectAnswers6 = new ArrayList<String>();
        hardAnswers6.add("Titan beetle");
        hardAnswers6.add("Giant stick insect");
        hardAnswers6.add("Goliath beetle");
        hardAnswers6.add("Hercules beetle");
        hardCorrectAnswers6.add("Giant stick insect");
        Question hardQuestion6 = new Question("Which is the biggest insect from the following?", hardAnswers6, hardCorrectAnswers6);
        hardExpected.add(hardQuestion6);

        ArrayList<String> hardAnswers7 = new ArrayList<String>();
        ArrayList<String> hardCorrectAnswers7 = new ArrayList<String>();
        hardAnswers7.add("Yangtze finless porpoise");
        hardAnswers7.add("Javan rhino");
        hardAnswers7.add("Amour leopard");
        hardAnswers7.add("Hawksbill turtle");
        hardCorrectAnswers7.add("Javan rhino");
        Question hardQuestion7 = new Question("Which of the rarest animal from the following?", hardAnswers7, hardCorrectAnswers7);
        hardExpected.add(hardQuestion7);

        ArrayList<String> hardAnswers8 = new ArrayList<String>();
        ArrayList<String> hardCorrectAnswers8 = new ArrayList<String>();
        hardAnswers8.add("Mimic octopus");
        hardAnswers8.add("Blue-ringed octopus");
        hardAnswers8.add("Flapjack octopus");
        hardAnswers8.add("Ghost octopus");
        hardCorrectAnswers8.add("Blue-ringed octopus");
        Question hardQuestion8 = new Question("What kind of octopus does Octopussy have in the James Bond movie?", hardAnswers8, hardCorrectAnswers8);
        hardExpected.add(hardQuestion8);

        ArrayList<String> hardAnswers9 = new ArrayList<String>();
        ArrayList<String> hardCorrectAnswers9 = new ArrayList<String>();
        hardAnswers9.add("Reptiles");
        hardAnswers9.add("Fishes");
        hardAnswers9.add("Mammals");
        hardAnswers9.add("Birds");
        hardCorrectAnswers9.add("Mammals");
        Question hardQuestion9 = new Question("What kind of animals belong to the Trichechidae family?", hardAnswers9, hardCorrectAnswers9);
        hardExpected.add(hardQuestion9);

        ArrayList<String> hardAnswers10 = new ArrayList<String>();
        ArrayList<String> hardCorrectAnswers10 = new ArrayList<String>();
        hardAnswers10.add("Elephant shrew");
        hardAnswers10.add("Opossum");
        hardAnswers10.add("Bandicoot");
        hardAnswers10.add("Mole");
        hardCorrectAnswers10.add("Opossum");
        hardCorrectAnswers10.add("Bandicoot");
        Question hardQuestion10 = new Question("Which animals are marsupials?", hardAnswers10, hardCorrectAnswers10);
        hardExpected.add(hardQuestion10);

        //Variables to get the questions from the original method
        QuestionsList actual = new QuestionsList();

        //Testing the else. If there is no level the hard questions should be returned
        ArrayList<Question> actualQuestions = actual.addHardQuestions();

        Assert.assertEquals(hardExpected, actualQuestions);
    }
}
package org.launchcode.lesson6.studio;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.lesson6.studio.question.CheckboxQuestion;
import org.launchcode.lesson6.studio.question.MultipleChoiceQuestion;
import org.launchcode.lesson6.studio.question.Question;
import org.launchcode.lesson6.studio.question.TrueOrFalseQuestion;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class QuizTest {

    ArrayList<MultipleChoiceQuestion> multipleChoiceQuestions = new ArrayList<>();
    ArrayList<TrueOrFalseQuestion> trueOrFalseQuestions = new ArrayList<>();
    ArrayList<CheckboxQuestion> checkboxQuestions = new ArrayList<>();

    @Before
    public void setup() {
        MultipleChoiceQuestion question = new MultipleChoiceQuestion("Polymorphism refers to:");
        question.addMultipleChoice("a", "One object inheriting another");
        question.addMultipleChoice("b", "An abstract class with many classes extending from it");
        question.addMultipleChoice("c", "The practice of storing an object of one type in a variable of another type");
        question.addMultipleChoice("d", "Shapeshifting");

        question.setActualAnswer("a");
        multipleChoiceQuestions.add(question);

        TrueOrFalseQuestion torFQuestion = new TrueOrFalseQuestion("True/False: When making class diagrams, the main idea is to get the design rules just right so that you won’t need to update your classes in the future.");
        torFQuestion.setActualAnswer('F');

        trueOrFalseQuestions.add(torFQuestion);

        CheckboxQuestion checkboxQuestion = new CheckboxQuestion("Describe the Java programming language, check all that apply:");
        checkboxQuestion.check("It is object oriented");
        checkboxQuestion.check( "It is popular");
        checkboxQuestion.uncheck( "It is case insensitive");
        checkboxQuestion.uncheck("Latest stable version is 8");

        checkboxQuestions.add(checkboxQuestion);
    }

    @Test
    public void testAddQuestionAndAnswer_multipleChoice() {
        Question question = multipleChoiceQuestions.get(0);

        Quiz quiz = new Quiz();
        quiz.addQuestionAndAnswer(question, "c");

        assertFalse(quiz.isAnswerCorrect(question));

    }

    @Test
    public void testAddQuestionAndAnswer_trueOrFalse() {
        Question question = trueOrFalseQuestions.get(0);

        Quiz quiz = new Quiz();
        quiz.addQuestionAndAnswer(question, "F");

        assertTrue(quiz.isAnswerCorrect(question));
    }


    @Test
    public void testAddQuestionAndAnswer_checkbox() {
        CheckboxQuestion question = checkboxQuestions.get(0);
        Quiz quiz = new Quiz();
        String [] selections = {"It is object oriented","It is popular"};
        quiz.addQuestionAndAnswer(question,
                question.hashcode(selections));

        assertTrue(quiz.isAnswerCorrect(question));
    }

    @Test
    public void testGrade() {
        Quiz quiz = new Quiz();
        String [] selections = {"It is object oriented","It is popular"};
        quiz.addQuestionAndAnswer(checkboxQuestions.get(0),
                checkboxQuestions.get(0).hashcode(selections));
        quiz.addQuestionAndAnswer( trueOrFalseQuestions.get(0), "F");
        quiz.addQuestionAndAnswer(multipleChoiceQuestions.get(0), "a");

        char grade = quiz.getGrade();
        assertEquals('A', grade);
        assertEquals("Terrific!", quiz.getMessage(grade));
    }


}

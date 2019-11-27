package org.launchcode.lesson6.studio.generator;

import com.google.gson.Gson;
import org.launchcode.lesson6.studio.Quiz;
import org.launchcode.lesson6.studio.question.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class QuizGenerator {
    public static final String QUESTIONS_JSON = "resources/questions.json";

    private static QuizQuestion[] quizQuestions;

    public static Quiz generateQuiz() throws FileNotFoundException {
        quizQuestions = new Gson().fromJson(new FileReader(QUESTIONS_JSON), QuizQuestion[].class);

        Quiz quiz = new Quiz();

        for(QuizQuestion quizQuestion: quizQuestions) {
            if((int)(Math.random() * 2) + 0 == 1) {
                if (quizQuestion.getQuestionType().equals(QuestionType.CHECKBOX)) {
                    quiz.addQuestion(quizQuestion.toCheckBoxQuestion());
                } else if (quizQuestion.getQuestionType().equals(QuestionType.MULTI_CHOICE)) {
                    quiz.addQuestion(quizQuestion.toMultipleChoiceQuestion());
                } else if (quizQuestion.getQuestionType().equals(QuestionType.TRUE_OR_FALSE)) {
                    quiz.addQuestion(quizQuestion.toTrueOrFalseQuestion());
                }
            }
        }
        return quiz;
    }
}

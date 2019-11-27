package org.launchcode.lesson6.studio;

import org.launchcode.lesson6.studio.generator.QuizGenerator;
import org.launchcode.lesson6.studio.question.Question;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class QuizRunner {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Java LC101 Quiz!");

        Quiz quiz = QuizGenerator.generateQuiz();

        for (Question question : quiz.getQuestions()) {
            System.out.println(question.toString());

            Set<String> steps = question.getSteps();
            int selections = 0;
            if (steps != null && steps.size() > 0) {
                for (String step : steps) {
                    System.out.print(step + " (Y/N) ");
                    String answer = in.next();
                    if (answer.equals("Y")) {
                        selections += step.hashCode();
                    }
                    in.nextLine();
                }
                quiz.addQuestionAndAnswer(question, selections+"");
            } else {
                String answer = in.nextLine();
                quiz.addQuestionAndAnswer(question, answer);
            }
        }

        char grade = quiz.getGrade();
        System.out.println("Quiz Grade: " + grade + "; " + quiz.getMessage(grade));
    }
}

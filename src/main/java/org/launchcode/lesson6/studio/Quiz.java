package org.launchcode.lesson6.studio;
import org.launchcode.lesson6.studio.question.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Quiz {

    private HashMap<Question, String> questionAnswerHashMap = new HashMap<>();

    public void addQuestionAndAnswer(Question question, String givenAnswer) {
        questionAnswerHashMap.put(question, givenAnswer);
    }

    public void addQuestion(Question question) {
        addQuestionAndAnswer(question, null);
    }

    public Set<Question> getQuestions() {
         return questionAnswerHashMap.keySet();
    }

    public boolean isQuizLoaded() {
        return getQuestions().size() > 3;
    }

    public boolean isAnswerCorrect(Question question) {
        if (questionAnswerHashMap.get(question) != null) {
            return (question.getActualAnswer()).equals(questionAnswerHashMap.get(question));
        } else {
            return false;
        }
    }

    public char getGrade() {
        int total = questionAnswerHashMap.size();
        double score = 0;
        for (Question question : questionAnswerHashMap.keySet()) {
            if (isAnswerCorrect(question)) {
                score += 1;
            }
        }
        double grade = score/total * 100;
        if (grade >= 90) {
            return 'A';
        } else if (grade >= 80) {
            return 'B';
        } else if (grade >= 70) {
            return 'C';
        } else if (grade >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public String getMessage(char grade) {
        switch (grade) {
            case 'A':
               return "Terrific!";
            case 'B':
               return "Good Job!";
            case 'C':
               return "Doing OK! Keep trying!";
            case 'D':
               return "Sorry! Better luck next time!";
            case 'F':
               return "Sorry! Try again!";
        }
        return "";
    }
}

package org.launchcode.lesson6.studio.generator;

import org.launchcode.lesson6.studio.question.CheckboxQuestion;
import org.launchcode.lesson6.studio.question.MultipleChoiceQuestion;
import org.launchcode.lesson6.studio.question.QuestionType;
import org.launchcode.lesson6.studio.question.TrueOrFalseQuestion;

import java.util.HashMap;

public class QuizQuestion {
    private QuestionType questionType;

    private String question;

    private String answer;

    private HashMap<String, String> multipleChoices = new HashMap<>();

    public HashMap<String, Boolean> getCheckAllThatApply() {
        return checkAllThatApply;
    }

    public void setCheckAllThatApply(HashMap<String, Boolean> checkAllThatApply) {
        this.checkAllThatApply = checkAllThatApply;
    }

    private HashMap<String, Boolean> checkAllThatApply = new HashMap<>();

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public HashMap<String, String> getMultipleChoices() {
        return multipleChoices;
    }

    public void setMultipleChoices(HashMap<String, String> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }

    public CheckboxQuestion toCheckBoxQuestion () {
        CheckboxQuestion checkboxQuestion = new CheckboxQuestion(question);
        checkboxQuestion.setCheckAllThatApply(this.checkAllThatApply);
        return checkboxQuestion;
    }

    public MultipleChoiceQuestion toMultipleChoiceQuestion () {
        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion(question);
        multipleChoiceQuestion.setActualAnswer(answer);
        multipleChoiceQuestion.setMultipleChoices(multipleChoices);
        return multipleChoiceQuestion;
    }

    public TrueOrFalseQuestion toTrueOrFalseQuestion() {
        TrueOrFalseQuestion trueOrFalseQuestion = new TrueOrFalseQuestion(question);
        trueOrFalseQuestion.setActualAnswer(answer.charAt(0));
        return trueOrFalseQuestion;
    }

}


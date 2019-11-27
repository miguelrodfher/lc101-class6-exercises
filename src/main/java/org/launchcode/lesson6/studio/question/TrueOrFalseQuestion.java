package org.launchcode.lesson6.studio.question;

import org.launchcode.lesson6.studio.question.Question;

public class TrueOrFalseQuestion extends Question {

    private char actualAnswer;

    public String getActualAnswer() {
        return actualAnswer + "";
    }

    public void setActualAnswer(char actualAnswer) {
        this.actualAnswer = actualAnswer;
    }

    public TrueOrFalseQuestion(String questionString) {
        super(questionString);
    }
}

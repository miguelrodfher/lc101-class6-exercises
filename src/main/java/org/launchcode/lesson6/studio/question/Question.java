package org.launchcode.lesson6.studio.question;

import java.util.Set;

public abstract class Question {
    private String questionString;

    public abstract String getActualAnswer();

    public Question(String questionString) {
        this.questionString = questionString;
    }

    public String getQuestion() {
        return questionString;
    }

    public void setQuestion(String question) {
        this.questionString = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question1 = (Question) o;

        return getQuestion().equals(question1.getQuestion());

    }

    @Override
    public int hashCode() {
        return getQuestion().hashCode();
    }

    @Override
    public String toString() {
        return "\n" + questionString + "\n";
    }

    public Set<String> getSteps() {
        return null;
    }
}

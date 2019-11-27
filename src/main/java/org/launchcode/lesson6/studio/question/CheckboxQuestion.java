package org.launchcode.lesson6.studio.question;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CheckboxQuestion extends Question {

    private HashMap<String, Boolean> checkAllThatApply = new HashMap();

    public CheckboxQuestion(String questionString) {
        super(questionString);
    }

    public HashMap<String, Boolean> getCheckAllThatApply() {
        return checkAllThatApply;
    }

    public void setCheckAllThatApply(HashMap<String, Boolean> checkAllThatApply) {
        this.checkAllThatApply = checkAllThatApply;
    }

    public void check(String key) {
        this.checkAllThatApply.put(key, true);
    }

    public void uncheck(String key) {
        this.checkAllThatApply.put(key, false);
    }

    @Override
    public String getActualAnswer() {
        int actualAnswer = 0;
        for(String key:  checkAllThatApply.keySet()) {
            if (checkAllThatApply.get(key)) {
                actualAnswer += key.hashCode();
            }
        }
        return String.valueOf(actualAnswer);
    }

    public String hashcode(String[] keys) {
        int selected = 0;
        for (String key : keys) {
            selected += key.hashCode();
        }
        return String.valueOf(selected);
    }

    @Override
    public Set<String> getSteps() {
        return checkAllThatApply.keySet();
    }

    @Override
    public String toString() {
        return "\n" + getQuestion() + " (Answer with Y/N for each one.)" + "\n";
    }
}

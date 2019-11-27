package org.launchcode.lesson6.studio.question;

import java.util.HashMap;

public class MultipleChoiceQuestion extends Question {

    private String actualAnswer;

    private HashMap<String, String> multipleChoices = new HashMap();

    public String getActualAnswer() {
        return actualAnswer;
    }

    public void setActualAnswer(String actualAnswer) {
        this.actualAnswer = actualAnswer;
    }

    public MultipleChoiceQuestion(String questionString) {
        super(questionString);
    }

    public HashMap<String, String> getMultipleChoices() {
        return multipleChoices;
    }

    public void setMultipleChoices(HashMap<String, String> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }

    public void addMultipleChoice (String String, String choice) {
        this.multipleChoices.put(String, choice);
    }

    @Override
    public String toString() {
        String questionStr = super.toString();
        for (String key : multipleChoices.keySet()) {
            questionStr += key + ".)" + " " + multipleChoices.get(key) + "\n";
        }
        return questionStr;
    }
}

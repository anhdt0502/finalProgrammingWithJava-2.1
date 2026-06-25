package model;

import java.io.Serializable;

public class Definition implements Serializable {

    private DefinitionType type;

    private String meaning;

    private String sentence;

    private String sentenceMeaning;

    public Definition() {
    }

    public Definition(DefinitionType type,
                      String meaning,
                      String sentence,
                      String sentenceMeaning) {

        this.type = type;
        this.meaning = meaning;
        this.sentence = sentence;
        this.sentenceMeaning = sentenceMeaning;
    }

    public DefinitionType getType() {
        return type;
    }

    public void setType(DefinitionType type) {
        this.type = type;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentenceMeaning() {
        return sentenceMeaning;
    }

    public void setSentenceMeaning(String sentenceMeaning) {
        this.sentenceMeaning = sentenceMeaning;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(type).append(": ").append(meaning);

        if(sentence != null && !sentence.isBlank()){

            sb.append("\nSentence: ")
                    .append(sentence);

            sb.append("\nMeaning : ")
                    .append(sentenceMeaning);

        }

        return sb.toString();
    }

}
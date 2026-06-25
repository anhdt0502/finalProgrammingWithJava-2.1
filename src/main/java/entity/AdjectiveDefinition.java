package entity;

public class AdjectiveDefinition extends Definition {

    private String sentence;
    private String sentenceMeaning;

    public AdjectiveDefinition() {
    }

    public AdjectiveDefinition(
            String content,
            String sentence,
            String sentenceMeaning) {

        super(content);
        this.sentence = sentence;
        this.sentenceMeaning = sentenceMeaning;
    }

    public String getSentence() {
        return sentence;
    }

    public String getSentenceMeaning() {
        return sentenceMeaning;
    }
}
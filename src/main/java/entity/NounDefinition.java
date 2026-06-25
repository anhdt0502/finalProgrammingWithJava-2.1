package entity;

public class NounDefinition extends Definition {

    private String sentence;
    private String sentenceMeaning;

    public NounDefinition() {
    }

    public NounDefinition(
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
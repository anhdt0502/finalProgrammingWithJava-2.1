package entity;

public abstract class ExampleDefinition extends Definition {

    protected String sentence;

    protected String sentenceMeaning;

    public ExampleDefinition() {
    }

    public ExampleDefinition(String content,
                             String sentence,
                             String sentenceMeaning) {

        super(content);

        this.sentence = sentence;

        this.sentenceMeaning = sentenceMeaning;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getMeaning() {
        return sentenceMeaning;
    }

    public void setMeaning(String meaning) {
        this.sentenceMeaning = sentenceMeaning;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("- ")
                .append(content)
                .append("\n");

        if(sentence != null && !sentence.isBlank()){

            builder.append("= ")
                    .append(sentence)
                    .append("\n");

            if(sentenceMeaning != null && !sentenceMeaning.isBlank()){

                builder.append("+ ")
                        .append(sentenceMeaning)
                        .append("\n");
            }

        }

        return builder.toString();
    }

}
package entity;

public class NounDefinition extends ExampleDefinition {

    public NounDefinition() {
    }

    public NounDefinition(String content,
                          String sentence,
                          String sentenceMeaning) {

        super(content, sentence, sentenceMeaning);

    }

    @Override
    public DefinitionType getType() {
        return DefinitionType.NOUN;
    }


}
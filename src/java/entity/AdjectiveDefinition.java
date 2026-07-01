package entity;

public class AdjectiveDefinition extends ExampleDefinition {

    public AdjectiveDefinition() {
    }

    public AdjectiveDefinition(String content,
                               String sentence,
                               String sentenceMeaning) {

        super(content, sentence, sentenceMeaning);

    }

    @Override
    public DefinitionType getType() {
        return DefinitionType.ADJECTIVE;
    }

}
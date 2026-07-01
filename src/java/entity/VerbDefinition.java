package entity;

public class VerbDefinition extends ExampleDefinition {

    public VerbDefinition() {
    }

    public VerbDefinition(String content,
                          String sentence,
                          String sentenceMeaning) {

        super(content, sentence, sentenceMeaning);

    }

    @Override
    public DefinitionType getType() {
        return DefinitionType.VERB;
    }

}
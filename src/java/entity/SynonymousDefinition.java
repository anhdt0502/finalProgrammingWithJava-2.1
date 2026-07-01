package entity;

public class SynonymousDefinition extends Definition {

    public SynonymousDefinition() {
    }

    public SynonymousDefinition(String content) {

        super(content);

    }

    @Override
    public DefinitionType getType() {
        return DefinitionType.SYNONYMOUS;
    }

    @Override
    public String toString() {

        return "- " + content;

    }

}
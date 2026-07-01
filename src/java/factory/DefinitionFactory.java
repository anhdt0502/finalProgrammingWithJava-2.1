package factory;

import entity.AdjectiveDefinition;
import entity.Definition;
import entity.DefinitionType;
import entity.NounDefinition;
import entity.PronunciationDefinition;
import entity.SynonymousDefinition;
import entity.VerbDefinition;

public final class DefinitionFactory {

    private DefinitionFactory() {

    }

    public static Definition create(
            DefinitionType type,
            String content,
            String sentence,
            String sentenceMeaning) {

        switch (type) {

            case PRONOUN:

                return new PronunciationDefinition(
                        content
                );

            case NOUN:

                return new NounDefinition(
                        content,
                        sentence,
                        sentenceMeaning
                );

            case ADJECTIVE:

                return new AdjectiveDefinition(
                        content,
                        sentence,
                        sentenceMeaning
                );

            case VERB:

                return new VerbDefinition(
                        content,
                        sentence,
                        sentenceMeaning
                );

            case SYNONYMOUS:

                return new SynonymousDefinition(
                        content
                );

            default:

                throw new IllegalArgumentException(
                        "Unknown Definition Type."
                );

        }

    }

}
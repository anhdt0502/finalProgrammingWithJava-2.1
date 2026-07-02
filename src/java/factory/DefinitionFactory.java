package factory;

import entity.*;

public class DefinitionFactory {

    private DefinitionFactory() {
    }

    public static Definition create(
            DefinitionType type,
            String content,
            String sentence,
            String meaning) {

        return create(type, content, sentence, meaning, null);

    }

    public static Definition create(
            DefinitionType type,
            String content,
            String sentence,
            String meaning,
            String audioPath) {

        switch (type) {

            case PRONOUN:

                PronunciationDefinition pronunciation =
                        new PronunciationDefinition(content);

                pronunciation.setAudioPath(audioPath);

                return pronunciation;

            case NOUN:

                return new NounDefinition(
                        content,
                        sentence,
                        meaning
                );

            case ADJECTIVE:

                return new AdjectiveDefinition(
                        content,
                        sentence,
                        meaning
                );

            case VERB:

                return new VerbDefinition(
                        content,
                        sentence,
                        meaning
                );

            case SYNONYMOUS:

                return new SynonymousDefinition(content);

            default:

                throw new IllegalArgumentException(
                        "Unknown definition type."
                );

        }

    }

}
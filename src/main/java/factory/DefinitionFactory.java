package factory;

import entity.*;

public class DefinitionFactory {

    public static Definition create(
            String type,
            String content,
            String sentence,
            String sentenceMeaning) {

        switch (type) {

            case "-p":
            case "--pronoun":
                return new PronunciationDefinition(
                        content,
                        ""
                );

            case "-n":
            case "--noun":
                return new NounDefinition(
                        content,
                        sentence,
                        sentenceMeaning
                );

            case "-a":
            case "--adjective":
                return new AdjectiveDefinition(
                        content,
                        sentence,
                        sentenceMeaning
                );

            case "-v":
            case "--verb":
                return new VerbDefinition(
                        content,
                        sentence,
                        sentenceMeaning
                );

            case "-s":
            case "--synonymous":
                return new SynonymousDefinition(
                        content
                );

            default:
                throw new RuntimeException(
                        "Unknown type");
        }
    }
}
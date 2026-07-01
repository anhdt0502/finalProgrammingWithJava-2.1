package controller;

import entity.DefinitionType;
import request.Request;
import service.AudioService;
import service.DictionaryService;

import java.util.Scanner;

public class DefineHandler implements ActionHandler {

    private final DictionaryService dictionaryService;

    private final Scanner scanner;

    public DefineHandler() {

        dictionaryService = DictionaryService.getInstance();

        scanner = new Scanner(System.in);

    }

    @Override
    public void handle(Request request) {

        if (request.getParams().isEmpty()) {

            System.out.println("Missing definition type!");

            return;

        }

        String option = request.getParams().get(0);

        DefinitionType type;

        switch (option) {

            case "-p":
            case "--pronoun":
                type = DefinitionType.PRONOUN;
                break;

            case "-n":
            case "--noun":
                type = DefinitionType.NOUN;
                break;

            case "-a":
            case "--adjective":
                type = DefinitionType.ADJECTIVE;
                break;

            case "-v":
            case "--verb":
                type = DefinitionType.VERB;
                break;

            case "-s":
            case "--synonymous":
                type = DefinitionType.SYNONYMOUS;
                break;

            default:

                System.out.println("Unknown definition type!");

                return;

        }

        String content;

        String sentence = "";

        String meaning = "";

        switch (type) {

            case PRONOUN:

                System.out.print("Pronunciation: ");

                content = scanner.nextLine();

                dictionaryService.define(
                        request.getKeyword(),
                        type,
                        content,
                        "",
                        ""
                );

                System.out.print("Audio file path (leave blank if none): ");
                String path = scanner.nextLine();

                if (!path.isBlank()) {
                    AudioService.upload(request.getKeyword(), path);
                }

                return;

            case SYNONYMOUS:

                System.out.print("Synonymous: ");

                content = scanner.nextLine();

                break;

            case NOUN:

                System.out.print("Noun definition: ");

                content = scanner.nextLine();

                System.out.print("Sentence (leave blank if none): ");

                sentence = scanner.nextLine();

                if (!sentence.isBlank()) {

                    System.out.print("Sentence meaning: ");

                    meaning = scanner.nextLine();

                }

                break;

            case ADJECTIVE:

                System.out.print("Adjective definition: ");

                content = scanner.nextLine();

                System.out.print("Sentence (leave blank if none): ");

                sentence = scanner.nextLine();

                if (!sentence.isBlank()) {

                    System.out.print("Sentence meaning: ");

                    meaning = scanner.nextLine();

                }

                break;

            case VERB:

                System.out.print("Verb definition: ");

                content = scanner.nextLine();

                System.out.print("Sentence (leave blank if none): ");

                sentence = scanner.nextLine();

                if (!sentence.isBlank()) {

                    System.out.print("Sentence meaning: ");

                    meaning = scanner.nextLine();

                }

                break;

            default:

                return;

        }

        dictionaryService.define(
                request.getKeyword(),
                type,
                content,
                sentence,
                meaning
        );

    }

}
package controller;

import entity.DefinitionType;
import request.Request;
import service.AudioService;
import service.DictionaryService;

import java.util.Scanner;

public class DefineHandler implements ActionHandler {

    private final DictionaryService dictionaryService;
    private final AudioService audioService;
    private final Scanner scanner;

    public DefineHandler() {

        dictionaryService = DictionaryService.getInstance();
        audioService = AudioService.getInstance();
        scanner = new Scanner(System.in);

    }

    @Override
    public void handle(Request request) {

        if (request.getParams().isEmpty()) {

            System.out.println("Missing definition type!");

            return;

        }

        DefinitionType type = parseType(request.getParams().get(0));

        if (type == null) {

            System.out.println("Unknown definition type!");

            return;

        }

        String content = "";
        String sentence = "";
        String meaning = "";

        switch (type) {

            case PRONOUN -> {

                System.out.print("Pronunciation: ");

                content = scanner.nextLine();

                System.out.print("Audio file path (leave blank if none): ");

                String audioPath = scanner.nextLine().trim();
                String savedAudio = null;
                if (!audioPath.isBlank()) {

                    try {

                        savedAudio = audioService.uploadAudio(
                                audioPath,
                                request.getKeyword()
                        );

                        System.out.println("Audio uploaded!");

                    } catch (Exception e) {

                        System.out.println(e.getMessage());

                        return;

                    }

                }


                boolean created = dictionaryService.define(

                                request.getKeyword(),

                                DefinitionType.PRONOUN,

                                content,

                                "",

                                "",

                                savedAudio

                        );

                if (created) {

                    System.out.println("@"
                            + request.getKeyword()
                            + " is not existed in database, created new one!");

                }

                System.out.println("Saved!");

                return;

            }

            case SYNONYMOUS -> {

                boolean created = false;

                while (true) {

                    System.out.print("Synonymous (Enter to finish): ");

                    String synonym = scanner.nextLine().trim();

                    if (synonym.isBlank()) {
                        break;
                    }

                    boolean isNew = dictionaryService.define(

                            request.getKeyword(),

                            DefinitionType.SYNONYMOUS,

                            synonym,

                            "",

                            "",

                            null

                    );

                    if (isNew) {
                        created = true;
                    }

                }

                if (created) {

                    System.out.println("@"
                            + request.getKeyword()
                            + " is not existed in database, created new one!");

                }

                System.out.println("Saved!");

                return;

            }

            case NOUN -> {

                System.out.print("Noun definition: ");
                content = scanner.nextLine();

                System.out.print("Sentence (leave blank if none): ");
                sentence = scanner.nextLine();

                if (!sentence.isBlank()) {

                    System.out.print("Sentence meaning: ");
                    meaning = scanner.nextLine();

                }

            }

            case ADJECTIVE -> {

                System.out.print("Adjective definition: ");
                content = scanner.nextLine();

                System.out.print("Sentence (leave blank if none): ");
                sentence = scanner.nextLine();

                if (!sentence.isBlank()) {

                    System.out.print("Sentence meaning: ");
                    meaning = scanner.nextLine();

                }

            }

            case VERB -> {

                System.out.print("Verb definition: ");
                content = scanner.nextLine();

                System.out.print("Sentence (leave blank if none): ");
                sentence = scanner.nextLine();

                if (!sentence.isBlank()) {

                    System.out.print("Sentence meaning: ");
                    meaning = scanner.nextLine();

                }

            }

        }

        boolean created = dictionaryService.define(

                request.getKeyword(),

                type,

                content,

                sentence,

                meaning,

                null

        );

        if(created){

            System.out.println("@"
                    + request.getKeyword()
                    + " is not existed in database, created new one!");

        }

        System.out.println("Saved!");



    }

    private DefinitionType parseType(String option) {

        return switch (option) {

            case "-p", "--pronoun" -> DefinitionType.PRONOUN;

            case "-n", "--noun" -> DefinitionType.NOUN;

            case "-a", "--adjective" -> DefinitionType.ADJECTIVE;

            case "-v", "--verb" -> DefinitionType.VERB;

            case "-s", "--synonymous" -> DefinitionType.SYNONYMOUS;

            default -> null;

        };

    }

}
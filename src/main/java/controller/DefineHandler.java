package controller;

import entity.*;
import factory.DefinitionFactory;
import request.Request;
import service.AudioService;
import service.DictionaryService;
import storage.FileStorage;

import java.util.Scanner;

public class DefineHandler
        implements ActionHandler {

    @Override
    public void execute(Request request) throws Exception {

        Scanner sc = new Scanner(System.in);

        String type = request.getParams().get(0);

        System.out.print("Definition: ");

        String content = sc.nextLine();

        String sentence = "";
        String meaning = "";

        if (!type.equals("-s") && !type.equals("-p")) {

            System.out.print("Sentence: ");

            sentence = sc.nextLine();

            if (!sentence.isBlank()) {System.out.print("Sentence meaning: ");
                meaning = sc.nextLine();
            }
        }
        Definition definition;
        if(type.equals("-p") || type.equals("--pronoun")) {

            System.out.print("Audio file path: ");

            String source =
                    sc.nextLine();

            String savedAudioPath = AudioService.uploadAudio(source, request.getKeyword());

            definition = new PronunciationDefinition(content, savedAudioPath);
        }
        else {
            definition = DefinitionFactory.create(
                            type,
                            content,
                            sentence,
                            meaning);
        }


        DictionaryService service = DictionaryService.getInstance();

        Word word = service.find(request.getKeyword());

        if (word == null) {

            word = new Word(request.getKeyword());

            service.addWord(word);

            System.out.println(
                    "@"
                            + request
                            .getKeyword()
                            + " created!");
        }
        word.getDefinitions().removeIf(d -> d instanceof PronunciationDefinition);
        word.addDefinition(definition);
        FileStorage storage = new FileStorage();
        storage.save(word);

        System.out.println("Saved!");
    }
}

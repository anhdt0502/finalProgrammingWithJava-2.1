package controller;

import entity.Definition;
import entity.PronunciationDefinition;
import entity.Word;
import request.Request;
import service.AudioPlayer;
import service.SearchService;

import java.util.List;
import java.util.Scanner;

public class LookupHandler implements ActionHandler {

    @Override
    public void handle(Request request) {

        SearchService searchService = SearchService.getInstance();

        List<Word> result = searchService.search(request.getKeyword());

        if (result.isEmpty()) {

            System.out.println("Not found!");

            return;

        }

        searchService.showResult(result);

        Word word = searchService.choose(result);

        if (word == null) {

            return;

        }

        System.out.println();
        System.out.println(word);

        PronunciationDefinition pronunciation = getPronunciation(word);

        if (pronunciation == null
                || pronunciation.getAudioPath() == null
                || pronunciation.getAudioPath().isBlank()) {

            return;

        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Press P to play pronunciation (Enter to skip): ");

        String input = scanner.nextLine().trim();

        if (!input.equalsIgnoreCase("P")) {

            return;

        }

        boolean success = AudioPlayer.play(pronunciation.getAudioPath());

        if (!success) {

            System.out.println("Cannot play audio.");

        }

    }


    private PronunciationDefinition getPronunciation(Word word) {

        for (Definition definition : word.getDefinitions()) {

            if (definition instanceof PronunciationDefinition pronunciation) {

                return pronunciation;

            }

        }

        return null;

    }

}
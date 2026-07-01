package controller;

import entity.Definition;
import entity.PronunciationDefinition;
import entity.Word;
import request.Request;
import service.AudioPlayer;
import service.DictionaryService;

import java.util.Scanner;

public class LookupHandler implements ActionHandler {

    @Override
    public void handle(Request request) {

        DictionaryService
                .getInstance()
                .lookup(request.getKeyword());

        Scanner scanner =
                new Scanner(System.in);

        System.out.print(
                "Press P to play pronunciation (other key to exit): ");

        String input =
                scanner.nextLine();

        if (!input.equalsIgnoreCase("P")) {

            return;

        }

        Word word =
                DictionaryService
                        .getInstance()
                        .find(request.getKeyword());

        if (word == null) {

            return;

        }

        if (word.getAudioFile() == null
                || word.getAudioFile().isBlank()) {

            System.out.println(
                    "Audio not found.");

            return;

        }

        AudioPlayer.play(
                word.getAudioFile());

    }

}
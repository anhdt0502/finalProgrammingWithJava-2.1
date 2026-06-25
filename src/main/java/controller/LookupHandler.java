package controller;

import entity.*;
import request.Request;
import service.AudioPlayer;
import service.DictionaryService;

import java.util.Scanner;

public class LookupHandler implements ActionHandler {

    @Override
    public void execute(
            Request request) {

        Word word =
                DictionaryService
                        .getInstance()
                        .find(
                                request
                                        .getKeyword());

        if (word == null) {

            System.out.println(
                    "Not found!");

            return;
        }

        System.out.println("@" + word.getKeyword());


        Scanner sc = new Scanner(System.in);

        for (Definition d : word.getDefinitions()) {
            if (d instanceof PronunciationDefinition p) {

                System.out.println(
                        "Pronunciation: "
                                + p.getContent());

                System.out.println(
                        "Audio: "
                                + p.getAudioFile());

                System.out.print(
                        "Play audio (Y/N): ");

                String choice = sc.nextLine();

                if (choice.equalsIgnoreCase("Y")) {

                    AudioPlayer.play(
                            p.getAudioFile());
                }
            }
        }
    }
}

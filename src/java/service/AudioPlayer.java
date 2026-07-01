package service;

import java.awt.Desktop;
import java.io.File;

public class AudioPlayer {

    private AudioPlayer() {

    }

    public static void play(String filePath) {

        try {

            File file = new File(filePath);

            if (!file.exists()) {

                System.out.println("Audio file not found!");

                return;

            }

            new ProcessBuilder(
                    "cmd",
                    "/c",
                    "start",
                    "",
                    file.getAbsolutePath()
            ).start();

        } catch (Exception e) {

            System.out.println("Cannot play audio!");

            e.printStackTrace();

        }

    }

}
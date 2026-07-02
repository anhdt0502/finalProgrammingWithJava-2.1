package service;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public final class AudioPlayer {

    private AudioPlayer() {
    }


    public static boolean play(String filePath) {

        if (filePath == null || filePath.isBlank()) {
            return false;
        }

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Audio file not found!");
            return false;
        }

        try {

            if (Desktop.isDesktopSupported()) {

                Desktop.getDesktop().open(file);

            } else {

                new ProcessBuilder(
                        "cmd",
                        "/c",
                        "start",
                        "",
                        file.getAbsolutePath()
                ).start();

            }

            return true;

        } catch (IOException e) {
            System.out.println("Cannot play audio!");

            return false;

        }

    }

}
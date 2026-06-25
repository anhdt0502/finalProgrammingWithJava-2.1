package service;

import java.awt.Desktop;
import java.io.File;

public class AudioPlayer {

    public static void play(String path) {

        try {

            File file = new File(path);

            if(file.exists()) {

                Desktop.getDesktop()
                        .open(file);
            }
            else {

                System.out.println(
                        "Audio file not found!");
            }

        } catch (Exception e) {

            System.out.println(
                    e.getMessage());
        }
    }
}
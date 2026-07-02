package service;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public final class AudioPlayer {

    private AudioPlayer() {
    }

    /**
     * Phát file audio.
     *
     * @param filePath đường dẫn file mp3/wav...
     * @return true nếu phát thành công
     */
    public static boolean play(String filePath) {

        if (filePath == null || filePath.isBlank()) {
            return false;
        }

        File file = new File(filePath);

        if (!file.exists()) {
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

            return false;

        }

    }

}
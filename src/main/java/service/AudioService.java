package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AudioService {

    private static final String AUDIO_FOLDER = "data/audio/";

    public String uploadAudio(String sourcePath, String word) {

        try {

            File source = new File(sourcePath);

            if (!source.exists()) {
                System.out.println("Không tìm thấy file.");
                return null;
            }

            File folder = new File(AUDIO_FOLDER);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String fileName = source.getName();

            String extension =
                    fileName.substring(fileName.lastIndexOf("."));

            File destination =
                    new File(folder, word + extension);

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            return destination.getPath();

        } catch (IOException e) {
            System.out.println("Upload thất bại.");
            return null;
        }

    }

}
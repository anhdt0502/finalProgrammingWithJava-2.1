package service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AudioService {

    private static AudioService instance;

    private static final String AUDIO_FOLDER = "audio";

    private AudioService() {
        File folder = new File(AUDIO_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public static AudioService getInstance() {
        if (instance == null) {
            instance = new AudioService();
        }
        return instance;
    }

    /**
     * Upload file mp3
     */
    public String uploadAudio(String sourcePath, String keyword) throws Exception {

        File source = new File(sourcePath);

        if (!source.exists()) {
            throw new Exception("Audio file not found!");
        }

        String extension = sourcePath.substring(sourcePath.lastIndexOf("."));

        File destination = new File(AUDIO_FOLDER,
                keyword.toLowerCase() + extension);

        Files.copy(
                source.toPath(),
                destination.toPath(),
                StandardCopyOption.REPLACE_EXISTING
        );

        return destination.getPath().replace("\\", "/");
    }

}
package service;

import java.io.File;
import java.io.IOException;
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

    public String uploadAudio(String sourcePath,
                              String keyword) throws IOException {

        if (sourcePath == null || sourcePath.isBlank()) {

            return null;

        }

        File source = new File(sourcePath);

        if (!source.exists()) {

            throw new IOException("Audio file not found!");

        }

        String fileName = source.getName();

        int index = fileName.lastIndexOf(".");

        String extension = index >= 0
                ? fileName.substring(index)
                : "";

        File destination = new File(
                AUDIO_FOLDER,
                keyword.toLowerCase() + extension
        );


        Files.copy(
                source.toPath(),
                destination.toPath(),
                StandardCopyOption.REPLACE_EXISTING
        );
        System.out.println("Copy to: " + destination.getAbsolutePath());

        return destination.getPath().replace("\\", "/");

    }


    public boolean deleteAudio(String audioPath) {

        if (audioPath == null || audioPath.isBlank()) {

            return false;

        }

        File file = new File(audioPath);

        return file.exists() && file.delete();

    }


    public boolean exists(String audioPath) {

        if (audioPath == null || audioPath.isBlank()) {

            return false;

        }

        return new File(audioPath).exists();

    }

}
package service;

import entity.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AudioService {

    private static final String AUDIO_FOLDER = "audio";

    static {

        try {

            Files.createDirectories(
                    Paths.get(AUDIO_FOLDER));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static void upload(
            String keyword,
            String sourcePath) {

        try {

            Path source =
                    Paths.get(sourcePath);

            if (!Files.exists(source)) {

                System.out.println(
                        "Audio file not found!");

                return;

            }

            String extension = "";

            String fileName =
                    source.getFileName().toString();

            int index =
                    fileName.lastIndexOf(".");

            if (index != -1) {

                extension =
                        fileName.substring(index);

            }

            Path target =
                    Paths.get(
                            AUDIO_FOLDER,
                            keyword + extension
                    );

            Files.copy(
                    source,
                    target,
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING
            );

            DictionaryService service =
                    DictionaryService.getInstance();

            Word word =
                    service.find(keyword);

            if (word != null) {

                word.setAudioFile(
                        target.toString());

                service.saveWord(word);

            }

            System.out.println(
                    "Audio uploaded successfully.");

        } catch (Exception e) {

            System.out.println(
                    "Upload failed!");

            e.printStackTrace();

        }

    }

}
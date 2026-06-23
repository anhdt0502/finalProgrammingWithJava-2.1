import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AudioManager {

    public static String uploadAudio(String sourcePath) {

        try {

            File source = new File(sourcePath);

            if (!source.exists()) {
                System.out.println("File does not exist.");
                return null;
            }

            File folder = new File("audio");

            if (!folder.exists()) {
                folder.mkdir();
            }

            File destination = new File(folder, source.getName());

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            return destination.getPath();

        } catch (IOException e) {

            System.out.println("Upload failed!");

            return null;
        }

    }

}
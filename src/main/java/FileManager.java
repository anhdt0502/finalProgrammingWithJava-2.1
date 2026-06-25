import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileManager {

    public static void save(Dictionary dictionary,String path){

    }

    public static Dictionary load(String path){

        return null;
    }
    public static String copyAudioFile(String sourcePath, String word) {

        try {

            File source = new File(sourcePath);

            if (!source.exists()) {
                return null;
            }

            File audioFolder =
                    new File("data/audio");

            if (!audioFolder.exists()) {
                audioFolder.mkdirs();
            }

            String extension =
                    source.getName()
                            .substring(
                                    source.getName()
                                            .lastIndexOf(".")
                            );

            File destination =
                    new File(audioFolder,
                            word + extension);

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            return destination.getPath();

        } catch (IOException e) {

            e.printStackTrace();

            return null;
        }
    }

}
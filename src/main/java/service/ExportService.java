package service;

import entity.*;

import java.io.FileWriter;
import java.util.Map;

public class ExportService {

    public void export(
            String path,
            Map<String, Word> data)
            throws Exception {

        FileWriter writer =
                new FileWriter(path);

        for (Word word : data.values()) {

            writer.write(
                    "@" + word.getKeyword()
                            + "\n");

            for (Definition def :
                    word.getDefinitions()) {

                writer.write(
                        "- "
                                + def.getContent()
                                + "\n");
            }

            writer.write("\n");
        }

        writer.close();
    }
}
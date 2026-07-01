package service;

import entity.Word;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class ExportService {

    private static ExportService instance;

    private ExportService() {

    }

    public static ExportService getInstance() {

        if (instance == null) {

            instance = new ExportService();

        }

        return instance;

    }

    public void export(String filePath) {

        Collection<Word> words =
                DictionaryService
                        .getInstance()
                        .getAllWords();

        if (words.isEmpty()) {

            System.out.println("Dictionary is empty.");

            return;

        }

        try {

            File file = new File(filePath);

            File parent = file.getParentFile();

            if (parent != null && !parent.exists()) {

                parent.mkdirs();

            }

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(file));

            int total = words.size();

            int count = 0;

            int percent = 10;

            for (Word word : words) {

                writer.write(word.toString());

                writer.newLine();

                writer.newLine();

                count++;

                int current =
                        count * 100 / total;

                if (current >= percent) {

                    System.out.print(
                            percent + "%...");

                    percent += 10;

                }

            }

            writer.close();

            System.out.println("Done!");

        } catch (IOException e) {

            System.out.println("Export failed.");

        }

    }

}
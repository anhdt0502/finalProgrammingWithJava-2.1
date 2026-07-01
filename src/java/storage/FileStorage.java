package storage;

import entity.Word;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileStorage {

    private static final String DB_FOLDER = "database";

    static {

        File folder = new File(DB_FOLDER);

        if (!folder.exists()) {

            folder.mkdirs();

        }

    }

    /**
     * Lưu một Word xuống file.
     */
    public void save(Word word) {

        if (word == null) {

            return;

        }

        File file = new File(
                DB_FOLDER,
                word.getKeyword().toLowerCase() + ".def"
        );

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream(file))) {

            oos.writeObject(word);

        } catch (IOException e) {

            System.out.println(
                    "Cannot save word: "
                            + word.getKeyword());

            e.printStackTrace();

        }

    }

    /**
     * Đọc một Word theo keyword.
     */
    public Word load(String keyword) {

        if (keyword == null || keyword.isBlank()) {

            return null;

        }

        File file = new File(
                DB_FOLDER,
                keyword.toLowerCase() + ".def"
        );

        if (!file.exists()) {

            return null;

        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream(file))) {

            return (Word) ois.readObject();

        } catch (Exception e) {

            System.out.println(
                    "Cannot load word: "
                            + keyword);

            return null;

        }

    }

    /**
     * Đọc toàn bộ database.
     */
    public Map<String, Word> loadAll() {

        Map<String, Word> dictionary =
                new LinkedHashMap<>();

        File folder = new File(DB_FOLDER);

        File[] files = folder.listFiles();

        if (files == null) {

            return dictionary;

        }

        for (File file : files) {

            if (!file.isFile()
                    || !file.getName().endsWith(".def")) {

                continue;

            }

            try (ObjectInputStream ois =
                         new ObjectInputStream(
                                 new FileInputStream(file))) {

                Word word =
                        (Word) ois.readObject();

                dictionary.put(
                        word.getKeyword().toLowerCase(),
                        word
                );

            } catch (Exception e) {

                System.out.println(
                        "Cannot read file: "
                                + file.getName());

            }

        }

        return dictionary;

    }

    /**
     * Lưu toàn bộ từ điển.
     */
    public void saveAll(
            Map<String, Word> dictionary) {

        if (dictionary == null) {

            return;

        }

        for (Word word : dictionary.values()) {

            save(word);

        }

    }

    /**
     * Xóa một Word.
     */
    public boolean delete(String keyword) {

        if (keyword == null
                || keyword.isBlank()) {

            return false;

        }

        File file = new File(
                DB_FOLDER,
                keyword.toLowerCase() + ".def"
        );

        return file.exists() && file.delete();

    }
    public int count() {

        File folder = new File(DB_FOLDER);

        File[] files = folder.listFiles(
                (dir, name) ->
                        name.endsWith(".def")
        );

        return files == null ? 0 : files.length;

    }

}
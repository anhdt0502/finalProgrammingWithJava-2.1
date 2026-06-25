package storage;

import entity.Word;

import java.io.*;

public class FileStorage {

    private static final String DB_FOLDER = "database";

    static {
        new File(DB_FOLDER).mkdirs();
    }

    public void save(Word word) {

        try {

            FileOutputStream fos =
                    new FileOutputStream(
                            DB_FOLDER + "/"
                                    + word.getKeyword()
                                    + ".def");

            ObjectOutputStream oos =
                    new ObjectOutputStream(fos);

            oos.writeObject(word);

            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Word load(String keyword) {

        try {

            FileInputStream fis =
                    new FileInputStream(
                            DB_FOLDER + "/"
                                    + keyword
                                    + ".def");

            ObjectInputStream ois =
                    new ObjectInputStream(fis);

            Word word =
                    (Word) ois.readObject();

            ois.close();

            return word;

        } catch (Exception e) {
            return null;
        }
    }

    public void delete(String keyword) {

        File file =
                new File(
                        DB_FOLDER + "/"
                                + keyword
                                + ".def");

        file.delete();
    }
}
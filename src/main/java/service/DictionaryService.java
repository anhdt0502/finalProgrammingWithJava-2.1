package service;

import entity.Word;
import storage.FileStorage;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class DictionaryService {

    private static DictionaryService instance;

    // Map để lookup O(1)
    private Map<String, Word> dictionary;

    private DictionaryService() {
        dictionary = new LinkedHashMap<>();
        loadDatabase();
    }

    private void loadDatabase() {

        File folder = new File("database");

        File[] files = folder.listFiles();

        if(files == null) {
            return;
        }

        FileStorage storage = new FileStorage();

        for(File file : files) {

            if(file.getName().endsWith(".def")) {

                String keyword = file.getName().replace(".def", "");

                Word word = storage.load(keyword);

                if(word != null) {
                    dictionary.put(keyword, word);
                }
            }
        }
    }

    public static DictionaryService getInstance() {

        if (instance == null) {
            instance = new DictionaryService();
        }

        return instance;
    }

    public Word find(String keyword) {
        return dictionary.get(keyword.toLowerCase());
    }

    public void addWord(Word word) {
        dictionary.put(word.getKeyword().toLowerCase(), word);
    }

    public void drop(String keyword) {
        dictionary.remove(keyword.toLowerCase());
    }

    public Map<String, Word> getDictionary() {
        return dictionary;
    }
}
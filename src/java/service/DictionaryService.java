package service;

import entity.Definition;
import entity.DefinitionType;
import entity.Word;
import factory.DefinitionFactory;
import storage.FileStorage;

import java.io.File;
import java.util.*;

public class DictionaryService {

            private static DictionaryService instance;

            private Map<String, Word> dictionary;

            private FileStorage storage;

            private DictionaryService(FileStorage storage) {

                dictionary = new LinkedHashMap<>();
//                storage = new FileStorage();
                this.storage = storage;

                loadDatabase();
        }

        public static DictionaryService getInstance() {

        if (instance == null) {
            instance = new DictionaryService(new FileStorage());
        }

        return instance;
        }


         public void loadDatabase() {

        dictionary.clear();

        dictionary.putAll(storage.loadAll());

     }


//      Tra từ

         public Word find(String keyword) {

        if (keyword == null) {
            return null;
        }

        return dictionary.get(keyword.toLowerCase());

         }

         public boolean containsWord(String keyword) {
        if(keyword == null){

            return false;

        }

        return dictionary.containsKey(keyword.toLowerCase());

        }


    /**
     * Thêm hoặc cập nhật từ
     */
        public void saveWord(Word word) {

            if (word == null) {

                return;

            }

            dictionary.put(
                    word.getKeyword().toLowerCase(),
                    word
            );

            storage.save(word);

        }

    /**
     * Chỉ thêm vào RAM
     */
        public void addWord(Word word) {

            if (word == null) {

                return;

            }

            dictionary.put(
                    word.getKeyword().toLowerCase(),
                    word
            );

            storage.save(word);
        }
        public void save() {

        storage.saveAll(dictionary);

        }
        public void define(String keyword,
                       DefinitionType type,
                       String content,
                       String sentence,
                       String meaning) {

            Word word = find(keyword);

            if (word == null) {

            word = new Word(keyword);

            dictionary.put(
                    keyword.toLowerCase(),
                    word
            );

            System.out.println(
                    "@" + keyword + " is not existed in database, created new one!"
            );

        }

            Definition definition = DefinitionFactory.create(
                        type,
                        content,
                        sentence,
                        meaning
                );

            word.addDefinition(definition);

            storage.save(word);

            System.out.println("Saved!");

    }

    /**
     * Xóa cả RAM và file
     */
    public boolean drop(String keyword) {

        if (!containsWord(keyword)) {
            return false;
        }

        dictionary.remove(keyword.toLowerCase());
        storage.delete(keyword);

        return true;



    }

    /**
     * Reload toàn bộ dữ liệu
     */
    public void reload() {

        loadDatabase();

    }

    /**
     * Lấy toàn bộ từ điển
     */
    public Collection<Word> getAllWords() {

        return dictionary.values();

    }


    public int size() {

        return dictionary.size();

    }
    public void lookup(String keyword) {

        SearchService searchService = SearchService.getInstance();

        List<Word> result = searchService.search(keyword);

        if (result.isEmpty()) {

            System.out.println("Not found!");

            return;

        }

        searchService.showResult(result);

        Word word =
                searchService.choose(result);

        if (word == null) {
            return;
        }

        System.out.println();
        System.out.println(word);

    }

}
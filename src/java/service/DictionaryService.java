package service;

import entity.Definition;
import entity.DefinitionType;
import entity.PronunciationDefinition;
import entity.Word;
import factory.DefinitionFactory;
import storage.FileStorage;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DictionaryService {

    private static DictionaryService instance;

    private final Map<String, Word> dictionary;

    private final FileStorage storage;

    private DictionaryService(FileStorage storage) {

        this.storage = storage;

        this.dictionary = new LinkedHashMap<>();

        loadDatabase();

    }

    public static DictionaryService getInstance() {

        if (instance == null) {

            instance = new DictionaryService(new FileStorage());

        }

        return instance;

    }

    /**
     * Load toàn bộ dữ liệu từ ổ cứng.
     */
    public final void loadDatabase() {

        dictionary.clear();

        dictionary.putAll(storage.loadAll());

    }

    /**
     * Reload lại dữ liệu.
     */
    public void reload() {

        loadDatabase();

    }

    /**
     * Lấy Word theo keyword.
     */
    public Word find(String keyword) {

        if (keyword == null || keyword.isBlank()) {

            return null;

        }

        return dictionary.get(keyword.trim().toLowerCase());

    }

    /**
     * Kiểm tra từ tồn tại.
     */
    public boolean containsWord(String keyword) {

        return find(keyword) != null;

    }

    /**
     * Thêm mới hoặc cập nhật Word.
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


    public boolean define(String keyword,
                          DefinitionType type,
                          String content,
                          String sentence,
                          String meaning,
                          String audioPath) {

        Word word = find(keyword);

        boolean created = false;

        if (word == null) {

            word = new Word(keyword);

            dictionary.put(

                    keyword.toLowerCase(),

                    word

            );

            created = true;

        }

        Definition definition = DefinitionFactory.create(

                type,
                content,
                sentence,
                meaning,
                audioPath

        );

        word.addDefinition(definition);

        storage.save(word);

        return created;

    }


    public boolean drop(String keyword) {

        if (!containsWord(keyword)) {

            return false;

        }

        dictionary.remove(keyword.toLowerCase());

        storage.delete(keyword);

        return true;

    }

    /**
     * Upload audio phát âm.
     */
    public boolean uploadAudio(String keyword,
                               String audioPath) {

        Word word = find(keyword);

        if (word == null) {

            return false;

        }

        for (Definition definition : word.getDefinitions()) {

            if (definition instanceof PronunciationDefinition pronunciation) {

                pronunciation.setAudioPath(audioPath);

                storage.save(word);

                return true;

            }

        }

        return false;

    }

    /**
     * Lưu toàn bộ database.
     */
    public void saveAll() {

        storage.saveAll(dictionary);

    }

    /**
     * Danh sách tất cả Word.
     */
    public Collection<Word> getAllWords() {

        return dictionary.values();

    }

    /**
     * Số lượng Word.
     */
    public int size() {

        return dictionary.size();

    }

}
package service;

import model.Word;

import java.util.ArrayList;
import java.util.List;

public class DictionaryService {

    private List<Word> words = new ArrayList<>();

    private AudioService audioService = new AudioService();

    public void addWord(Word word) {
        words.add(word);
    }

    public List<Word> getWords() {
        return words;
    }

    public Word findByEnglish(String english) {

        for (Word word : words) {

            if (word.getEnglish().equalsIgnoreCase(english)) {
                return word;
            }

        }

        return null;
    }

    public boolean uploadAudio(String english, String sourcePath) {

        Word word = findByEnglish(english);

        if (word == null) {
            return false;
        }

        String newPath =
                audioService.uploadAudio(sourcePath, english);

        if (newPath == null) {
            return false;
        }

        word.setPronunciationFile(newPath);

        return true;

    }

}
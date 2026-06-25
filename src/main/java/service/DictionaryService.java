package service;

import model.Definition;
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
    public void defineWord(DefinitionType type,
                           String english,
                           String meaning,
                           String sentence,
                           String sentenceMeaning){

        Word word = findWord(english);

        if(word == null){

            word = new Word(english);

            words.add(word);

            System.out.println("@"+english+
                    " is not existed in database, created new one!");

        }

        Definition definition =
                new Definition(type,
                        meaning,
                        sentence,
                        sentenceMeaning);

        word.addDefinition(definition);

        System.out.println("Saved!");

    }

}
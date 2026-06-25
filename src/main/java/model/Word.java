package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Word implements Serializable {

    private String english;

    private String pronunciation;

    private String audioFile;

    private List<Definition> definitions =
            new ArrayList<>();

    public Word() {
    }

    public Word(String english) {
        this.english = english;
    }

    public Word(String en, String vi) {
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public void addDefinition(Definition definition){

        definitions.add(definition);

    }

}
package entity;

import java.io.Serializable;
import java.util.LinkedList;

public class Word implements Serializable {

    private String keyword;

    private LinkedList<Definition> definitions;

    public Word(String keyword) {

        this.keyword = keyword;
        definitions = new LinkedList<>();
    }

    public String getKeyword() {
        return keyword;
    }

    public LinkedList<Definition> getDefinitions() {
        return definitions;
    }

    public void addDefinition(
            Definition definition) {

        definitions.add(definition);
    }
}
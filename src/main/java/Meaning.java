import entity.Definition;

import java.io.Serializable;
import java.util.ArrayList;

public class Meaning implements Serializable {

    private String type; // Noun, Verb, Adj...
    private ArrayList<Definition> definitions;

    public Meaning() {
        definitions = new ArrayList<>();
    }

    public Meaning(String type) {
        this.type = type;
        definitions = new ArrayList<>();
    }

    // Getter Setter
    public String getType() {
        return type;

    }
    public void setType(String type) {
        this.type = type;
    }
    public ArrayList<Definition> getDefinitions() {
        return definitions;
    }
    public void setDefinitions(ArrayList<Definition> definitions) {
        this.definitions = definitions;
    }
    public void addDefinition(Definition definition) {
        definitions.add(definition);
    }
    public void removeDefinition(Definition definition) {
        definitions.remove(definition);
    }
    @Override
    public String toString() {
        return "Meaning{" + "type=" + type + ", definitions=" + definitions + '}';
    }

}
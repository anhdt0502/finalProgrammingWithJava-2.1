import java.io.Serializable;
import java.util.ArrayList;

public class Word implements Serializable {
    private String word;
    private String pronunciation;
    private ArrayList<Meaning> mraning;
    private ArrayList<String> synonyms;
    public Word() {
        mraning = new ArrayList<>();
        synonyms = new ArrayList<>();
    }
    public Word(String word, String pronunciation) {
        this.word = word;
        this.pronunciation = pronunciation;
        mraning = new ArrayList<>();
        synonyms = new ArrayList<>();

    }

}

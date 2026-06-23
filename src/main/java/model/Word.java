import java.io.Serializable;
import java.util.ArrayList;

public class Word implements Serializable {
    private String word;
    private String pronunciation;
    private ArrayList<Meaning> meanings;
    private ArrayList<String> synonyms;
    private String audioPath;
    public Word() {
        meanings = new ArrayList<>();
        synonyms = new ArrayList<>();
    }
    public Word(String word, String pronunciation) {
        this.word = word;
        this.pronunciation = pronunciation;

        meanings = new ArrayList<>();
        synonyms = new ArrayList<>();


    }
    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

}

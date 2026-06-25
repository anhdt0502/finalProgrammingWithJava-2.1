import entity.Word;

import java.io.Serializable;
import java.util.ArrayList;

public class Dictionary implements Serializable {

    private ArrayList<Word> words;

    public Dictionary() {
        words = new ArrayList<>();
    }

    public ArrayList<Word> getWords() {
        return words;
    }
}
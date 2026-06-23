import java.io.Serializable;

public class Definition implements Serializable {

    private String meaning;
    private String example;

    public Definition() {
    }

    public Definition(String meaning, String example) {
        this.meaning = meaning;
        this.example = example;
    }

    // Getter Setter
}
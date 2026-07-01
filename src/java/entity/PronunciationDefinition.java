package entity;

public class PronunciationDefinition extends Definition {

    private String audioPath;

    public PronunciationDefinition() {
    }

    public PronunciationDefinition(String pronunciation) {
        super(pronunciation);

        this.audioPath = audioPath;

    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    @Override
    public DefinitionType getType() {
        return DefinitionType.PRONOUN;
    }

    @Override
    public String toString() {

        return content;

    }

}
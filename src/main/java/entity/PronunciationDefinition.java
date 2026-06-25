package entity;

public class PronunciationDefinition extends Definition {

    private String audioFile;

    public PronunciationDefinition() {
    }

    public PronunciationDefinition(
            String pronunciation,
            String audioFile) {

        super(pronunciation);
        this.audioFile = audioFile;
    }

    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }
}
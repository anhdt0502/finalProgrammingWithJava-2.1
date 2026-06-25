package entity;

import java.io.Serializable;

public abstract class Definition implements Serializable {

    protected String content;

    public Definition() {
    }

    public Definition(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
package entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Word implements Serializable {

    private static final long serialVersionUID = 1L;

    private String keyword;

    private String audioFile;


    private LinkedList<Definition> definitions;

    public Word() {

        definitions = new LinkedList<>();

    }

    public Word(String keyword) {

        this.keyword = keyword.toLowerCase();

        definitions = new LinkedList<>();

    }

    public String getKeyword() {

        return keyword;

    }

    public void setKeyword(String keyword) {

        this.keyword = keyword.toLowerCase();

    }

    public String getAudioFile() {

        return audioFile;

    }

    public void setAudioFile(String audioFile) {

        this.audioFile = audioFile;

    }

    public List<Definition> getDefinitions() {

        return definitions;

    }

    public void setDefinitions(LinkedList<Definition> definitions) {

        this.definitions = definitions;

    }

    public void addDefinition(Definition definition) {

        definitions.add(definition);

    }

    private void appendDefinitionGroup(StringBuilder builder,
                                       DefinitionType type) {

        boolean found = false;

        for (Definition definition : definitions) {

            if (definition.getType() == type) {

                if (!found) {

                    builder.append("* ")
                            .append(getTypeName(type))
                            .append("\n");

                    found = true;

                }

                builder.append(definition)
                        .append("\n");

            }

        }

    }

    private String getTypeName(DefinitionType type) {

        switch (type) {

            case PRONOUN:
                return "Phát âm";

            case NOUN:
                return "Danh từ";

            case ADJECTIVE:
                return "Tính từ";

            case VERB:
                return "Động từ";

            case SYNONYMOUS:
                return "Tương đồng";

            default:
                return "";
        }

    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("@")
                .append(keyword)
                .append("\n");

        appendDefinitionGroup(builder, DefinitionType.PRONOUN);

        appendDefinitionGroup(builder, DefinitionType.NOUN);

        appendDefinitionGroup(builder, DefinitionType.ADJECTIVE);

        appendDefinitionGroup(builder, DefinitionType.VERB);

        appendDefinitionGroup(builder, DefinitionType.SYNONYMOUS);

        if (audioFile != null && !audioFile.isBlank()) {

            builder.append("\n")
                    .append("[Audio Available]")
                    .append("\n");

        }

        return builder.toString();

    }

}
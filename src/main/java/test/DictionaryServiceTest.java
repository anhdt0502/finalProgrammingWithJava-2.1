package test;

import entity.Word;
import org.junit.jupiter.api.Test;
import service.DictionaryService;

import static org.junit.jupiter.api.Assertions.*;

public class DictionaryServiceTest {

    @Test
    public void testAddWord() {

        DictionaryService service =
                DictionaryService
                        .getInstance();

        Word word =
                new Word("positive");

        service.addWord(word);

        assertNotNull(
                service.find(
                        "positive"));
    }

    @Test
    public void testDropWord() {

        DictionaryService service =
                DictionaryService
                        .getInstance();

        service.drop(
                "positive");

        assertNull(
                service.find(
                        "positive"));
    }
}
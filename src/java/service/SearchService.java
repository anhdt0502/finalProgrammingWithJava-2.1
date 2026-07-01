package service;

import entity.Definition;
import entity.DefinitionType;
import entity.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchService {

    private static SearchService instance;

    private final DictionaryService dictionaryService;

    private SearchService() {

        dictionaryService = DictionaryService.getInstance();

    }

    public static SearchService getInstance() {

        if (instance == null) {

            instance = new SearchService();

        }

        return instance;

    }

    /**
     * Tìm gần đúng theo keyword.
     */
    public List<Word> search(String keyword) {

        List<Word> result = new ArrayList<>();

        if (keyword == null || keyword.isBlank()) {

            return result;

        }

        keyword = keyword.toLowerCase();

        for (Word word : dictionaryService.getAllWords()) {

            if (word.getKeyword().toLowerCase().contains(keyword)) {

                result.add(word);

            }

        }

        return result;

    }

    /**
     * Hiển thị danh sách kết quả.
     */
    public void showResult(List<Word> words) {

        if (words.isEmpty()) {

            System.out.println("Not found!");

            return;

        }

        System.out.println("Result:");

        int index = 1;

        for (Word word : words) {

            System.out.printf(
                    "%d. %s - %s%n",
                    index++,
                    word.getKeyword(),
                    getMainType(word)
            );

        }

    }

    /**
     * Người dùng chọn kết quả.
     */
    public Word choose(List<Word> words) {

        if (words.isEmpty()) {

            return null;

        }

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Choose (0 to cancel): ");

            try {

                int choice =
                        Integer.parseInt(
                                scanner.nextLine()
                        );

                if (choice == 0) {

                    return null;

                }

                if (choice >= 1
                        && choice <= words.size()) {

                    return words.get(choice - 1);

                }

                System.out.println("Invalid choice!");

            } catch (NumberFormatException e) {

                System.out.println("Please enter a number!");

            }

        }

    }

    /**
     * Lấy loại định nghĩa đầu tiên để hiển thị.
     */
    private String getMainType(Word word) {

        if (word.getDefinitions().isEmpty()) {

            return "Unknown";

        }

        Definition definition =
                word.getDefinitions().get(0);

        return getTypeName(
                definition.getType()
        );

    }

    /**
     * Chuyển DefinitionType sang chuỗi hiển thị.
     */
    private String getTypeName(
            DefinitionType type) {

        switch (type) {

            case PRONOUN:
                return "Pronunciation";

            case NOUN:
                return "Noun";

            case ADJECTIVE:
                return "Adjective";

            case VERB:
                return "Verb";

            case SYNONYMOUS:
                return "Synonymous";

            default:
                return "Unknown";

        }

    }

}
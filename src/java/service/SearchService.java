package service;

import entity.Definition;
import entity.DefinitionType;
import entity.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SearchService {

    private static SearchService instance;

    private final DictionaryService dictionaryService;

    private final Scanner scanner;

    private SearchService() {

        dictionaryService = DictionaryService.getInstance();

        scanner = new Scanner(System.in);

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

        if (keyword == null || keyword.isBlank()) {

            return Collections.emptyList();

        }

        keyword = keyword.trim().toLowerCase();

        List<Word> result = new ArrayList<>();

        for (Word word : dictionaryService.getAllWords()) {

            if (word.getKeyword().toLowerCase().contains(keyword)) {

                result.add(word);

            }

        }

        return result;

    }

    /**
     * Hiển thị kết quả tìm kiếm.
     */
    public void showResult(List<Word> words) {

        if (words == null || words.isEmpty()) {

            System.out.println("Not found!");

            return;

        }

        System.out.println("\nResult:");

        for (int i = 0; i < words.size(); i++) {

            Word word = words.get(i);

            System.out.printf(
                    "%d. %s (%s)%n",
                    i + 1,
                    word.getKeyword(),
                    getMainType(word)
            );

        }

    }

    /**
     * Người dùng chọn một kết quả.
     */
    public Word choose(List<Word> words) {

        if (words == null || words.isEmpty()) {

            return null;

        }

        while (true) {

            System.out.print("Choose (0 to cancel): ");

            String input = scanner.nextLine().trim();

            try {

                int choice = Integer.parseInt(input);

                if (choice == 0) {

                    return null;

                }

                if (choice >= 1 && choice <= words.size()) {

                    return words.get(choice - 1);

                }

                System.out.println("Invalid choice!");

            } catch (NumberFormatException e) {

                System.out.println("Please enter a number!");

            }

        }

    }

    /**
     * Lấy loại định nghĩa đầu tiên.
     */
    private String getMainType(Word word) {

        if (word == null || word.getDefinitions().isEmpty()) {

            return "Unknown";

        }

        Definition definition = word.getDefinitions().getFirst();

        return switch (definition.getType()) {

            case PRONOUN -> "Pronunciation";

            case NOUN -> "Noun";

            case ADJECTIVE -> "Adjective";

            case VERB -> "Verb";

            case SYNONYMOUS -> "Synonymous";

        };

    }

}
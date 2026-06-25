

import model.Word;
import service.DictionaryService;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    private DictionaryService service =
            new DictionaryService();

    public void run() {

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm từ");
            System.out.println("2. Upload file phát âm");
            System.out.println("3. Hiển thị");
            System.out.println("0. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    addWord();

                    break;

                case 2:

                    uploadAudio();

                    break;

                case 3:

                    showWords();

                    break;

                case 0:

                    return;

            }

        }

    }

    private void addWord() {

        System.out.print("English: ");
        String en = scanner.nextLine();

        System.out.print("Vietnamese: ");
        String vi = scanner.nextLine();

        service.addWord(new Word(en, vi));

    }

    private void uploadAudio() {

        System.out.print("Nhập từ: ");
        String word = scanner.nextLine();

        System.out.print("Đường dẫn file mp3/wav: ");
        String path = scanner.nextLine();

        if (service.uploadAudio(word, path)) {
            System.out.println("Upload thành công.");
        } else {
            System.out.println("Upload thất bại.");
        }

    }

    private void showWords() {

        for (Word word : service.getWords()) {
            System.out.println(word);
            System.out.println("--------------------");
        }

    }

}
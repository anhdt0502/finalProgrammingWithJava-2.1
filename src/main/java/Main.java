import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();
        DictionaryManager manager = new DictionaryManager();

        int choice;

        do {

            menu.display();

            System.out.print("Choose an option (1-7): ");

            choice = scanner.nextInt();
            scanner.nextLine();      // Xóa ký tự Enter

            switch (choice) {

                case 1:
                    System.out.println("== ADD ==");
                    // manager.addWord();
                    break;

                case 2:
                    System.out.println("== LOOKUP ==");
                    // manager.lookup();
                    break;

                case 3:
                    System.out.println("== UPDATE ==");
                    // manager.updateWord();
                    break;

                case 4:
                    System.out.println("== DELETE ==");
                    // manager.deleteWord();
                    break;

                case 5:
                    System.out.println("== SHOW ==");
                    // manager.showAll();
                    break;

                case 6:
                    System.out.println("== SAVE ==");
                    // manager.save();
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println();

        } while (choice != 7);

        scanner.close();
    }
}
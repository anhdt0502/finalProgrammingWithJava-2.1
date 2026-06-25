import model.DefinitionType;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.run();
        String input = scanner.nextLine();

        String[] arr = input.split("\\s+");

        String option = arr[1];

        String english = arr[2];
        DefinitionType type = switch (option){

            case "--noun", "-n" -> DefinitionType.NOUN;

            case "--verb", "-v" -> DefinitionType.VERB;

            case "--adjective", "-a" -> DefinitionType.ADJECTIVE;

            case "--pronoun", "-p" -> DefinitionType.PRONOUN;

            case "--synonymous", "-s" -> DefinitionType.SYNONYMOUS;

            default -> throw new IllegalArgumentException();
        };

    }


}
import controller.RequestController;
import controller.RequestParser;
import request.Request;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RequestParser parser =
                new RequestParser();

        RequestController controller = new RequestController();


        System.out.println("""
                          lookup <word>
                          define -a <word>
                          define -n <word>
                          define -v <word>
                          define -p <word>
                          define -s <word>
                          drop <word>
                          export <file>
                          exit
                             """);

        while (true) {

            try {


                System.out.print("\nAction: ");

                String input =
                        sc.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {

                    System.out.println("Program ended!");

                    break;
                }
//                if (input.equalsIgnoreCase("help")) {
//
//                    System.out.println("""
//                          lookup <word>
//                          define -a <word>
//                          define -n <word>
//                          define -v <word>
//                          define -p <word>
//                          define -s <word>
//                          drop <word>
//                          export <file>
//                          exit
//                             """);
//
//                    continue;
//                }


                if (input.isBlank()) {
                    continue;
                }

                Request request = parser.parse(input);

                controller.execute(request);

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
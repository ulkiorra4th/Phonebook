package CLI;

import java.util.ArrayList;

public final class ConsoleOutput {
    public static void showWelcomeMessage() {
        System.out.println("--------------------------------Welcome to PhoneBook!--------------------------------\n");
        System.out.println("To get all numbers by lastname:\t\t\t SELECT WHERE LASTNAME IS [last_name]");
        System.out.println("To get all numbers by their digits sum:\t SELECT WHERE SUM IS [digits_sum]");
        System.out.println("To get all numbers/names:\t\t\t\t SELECT ALL [NUMBERS or NAMES]\n");
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public static void showException(Exception e) {
        System.out.println("ERROR: " + e.getMessage().toUpperCase());
    }

    public static void showResponse(ArrayList<String> response) {
        for (String line : response) {
            System.out.println(line);
        }
    }

    public static void showEmptyResponseMessage() {
        System.out.println("EMPTY SET");
    }
}

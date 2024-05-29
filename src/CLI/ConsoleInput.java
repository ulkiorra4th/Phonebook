package CLI;

import java.util.Scanner;

public final class ConsoleInput {
    private static Scanner in = new Scanner(System.in);

    public static String read() {
        System.out.print("> ");
        return in.nextLine().toUpperCase();
    }

}

package tictactoe.io;

import java.util.Scanner;

public class Input {
    private Input() {}

    public static String read(String message) {
        if (message != null) Output.write(message + " ");

        return new Scanner(System.in).nextLine();
    }
}

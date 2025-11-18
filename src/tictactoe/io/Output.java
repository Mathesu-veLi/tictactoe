package tictactoe.io;

public final class Output {
    private Output() {}

    public static void writeNewLine() {
        write(null);
    }

    public static void write(Object obj) {
        write(obj, true);
    }

    public static void write(Object object, boolean addNewLine) {
        if (object == null) System.out.println();
        else {
            if (addNewLine) System.out.println(object);
            else
                System.out.print(object);
        }
    }
}

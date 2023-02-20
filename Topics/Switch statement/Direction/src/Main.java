import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "move";
        switch (scanner.nextByte()) {
            case 0 -> System.out.println("do not " + text);
            case 1 -> System.out.println(text + " up");
            case 2 -> System.out.println(text + " down");
            case 3 -> System.out.println(text + " left");
            case 4 -> System.out.println(text + " right");
            default -> System.out.println("error!");
        }
    }
}
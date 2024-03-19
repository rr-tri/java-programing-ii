
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = 0;
        int second = 0;
        while (true) {
            if (second > 100) {
                second = 100;
            }
            if (first > 100) {
                first = 100;
            }
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            System.out.print("> ");

            String input = scan.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];
            if (command.equals("quit")) {
                break;
            }

            int amount = Integer.valueOf(parts[1]);

            if (command.equals("add")) {
                if (amount < 0) {
                    continue;
                }
                first += amount;
                continue;
            }

            if (command.equals("move")) {
                if (amount < 0) {
                    continue;
                }
                if (first - amount >= 0) {
                    second += amount;
                    first -= amount;
                } else {
                    second += first;
                    first = 0;
                }

                continue;
            }
            if (command.equals("remove")) {
                if (amount < 0) {
                    continue;
                }
                if (second - amount >= 0) {
                    second -= amount;
                } else {
                    second = 0;
                }
                if (amount > 100) {
                    second = 0;
                }
            }

        }
    }

}

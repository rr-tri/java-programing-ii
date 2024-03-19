
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int n = 0;
        while (true) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            if (input > 0) {
                sum += input;
                n++;
            }
        }
        if (sum > 0) {
            System.out.println((double) sum / n);
        } else {

            System.out.println("Cannot calculate the average");

        }
    }
}


import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Scanner scan = new Scanner(System.in);
        Checker check = new Checker();

        System.out.print("Enter a String: ");
        String day = scan.nextLine();
        printCheck(check.isDayOfWeek(day));

        System.out.print("Enter a String: ");
        String time = scan.nextLine();
        printCheck(check.timeOfDay(time));

        System.out.print("Enter a String: ");
        String vowel = scan.nextLine();
        printCheck(check.allVowels(vowel));
    }

    public static void printCheck(boolean value) {
        if (value) {
            System.out.println("The form is correct.");
        } else {
            System.out.println("The form is incorrect.");
        }
    }
}

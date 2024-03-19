
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputs = new ArrayList<>();
        
        while (true) {
            Integer input = scanner.nextInt();
            if (input < 0) {
                break;
            }
            inputs.add(input);
        }

//        inputs.forEach(input->{
//            if(input>=1 && input<=5){
//            System.out.println(input);
//            }
//        });
        inputs.stream()
                .filter(a -> a >= 1 && a <= 5)
                .forEach(i -> System.out.println(i));
    }
}

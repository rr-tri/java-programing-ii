
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Container first = new Container();
        Container second  = new Container();

        while (true) {
            System.out.println("First: " + first );
            System.out.println("Second: " + second);
            System.out.print("> ");
            String input = scan.nextLine();
            String[] parts = input.split(" ");
            
            
            String command = parts[0];
            if (command.equals("quit")) {
                break;
            }

            int amount = Integer.valueOf(parts[1]);

            if (command.equals("add")) {
                first.add(amount);
                continue;
            }

            if (command.equals("move")) {
                if (amount < 0) {
                    continue;
                }
                if(first.contains()-amount >= 0 ){
                    second.add(amount);
                    first.remove(amount);
                }else{
                    second.add(first.contains());
                    first.remove(100);
                }
                
                continue;
            }
            
            if (command.equals("remove")) {
               second.remove(amount);
            }

        }
    }

}

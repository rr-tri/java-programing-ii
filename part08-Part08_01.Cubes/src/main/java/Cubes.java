
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String input = scanner.nextLine();
            if(input.equals("end")){
                break;
            }else{
                
                try{
                    int num = Integer.parseInt(input);
                    if(num>0){
                    System.out.println(num*num*num);
                }else{
                    System.out.println(num);
                }
                }catch (Exception e){
                    System.out.println("Try again: " + e.getMessage());
                }
            }
            
        }
    }
}

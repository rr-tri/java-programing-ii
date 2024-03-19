
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Checker {
    
    public boolean isDayOfWeek(String string){
        String regx = "^(mon|tue|wed|thu|fri|sat|sun)$";
        return string.matches(regx);
    }
    public boolean allVowels(String string){
        String regx = "^[aeiouAEIOU]*$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    public boolean timeOfDay(String string){
         String regx = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}


/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test {
    
    public static void main(String[] args) {
Object ageObj = 20; // Pattern matching in switch often uses Object or sealed types

        switch (ageObj) {
            case Integer a when a >= 65 -> System.out.println("Senior");
            case Integer a when a >= 18 -> System.out.println("Adult");
            case Integer a -> System.out.println("Young");
            default -> System.out.println("Invalid input");
        }
    }
}
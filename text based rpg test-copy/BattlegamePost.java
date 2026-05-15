
/**
 * Write a description of class Post here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class BattlegamePost{ 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        class Character {
            
        String name ;
        double hp;
        boolean alive;
        
        Character (String n, double h) {
            
            name = n;
            hp = h; 
            alive = true;
        
        }
        
        
        void takeDmg(double dmg) {
            
            hp-= dmg;
            if (hp <= 0) {
                
            alive = false; 
}
        } 
}
        
       Character Player = new Character("Player", 50);
       Character Goblin = new Character("Goblin", 50);
       
       System.out.print("Battle start");
       
       while (Player.alive && Goblin.alive){ 
           
        System.out.Print("1.Punch 2.Kick")
        
}
}
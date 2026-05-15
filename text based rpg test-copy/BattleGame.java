
/**
 * Write a description of class Pre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class BattleGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        class Character {
    String name;
    double hp;
    boolean alive;

    Character(String n, double h) {
        name = n;
        hp = h;
        alive = true;
    }

    void takeDamage(double dmg) {
        hp -= dmg;
        if (hp <= 0) {
            hp = 0;
            alive = false;
        }
    }
}
        
        Character player = new Character("Player", 50);
        Character enemy = new Character("Goblin", 50);

        System.out.println("Battle Start!");

        while (player.alive  && enemy.alive) {
            System.out.println("\nChoose your attack: 1 = Punch, 2 = Kick");
            int choice = 0;
            while (!sc.hasNextInt()) sc.next(); // ignore invalid input
            choice = sc.nextInt();

            double dmg = 0;
            if (choice == 1) {
                dmg = randomDamage(5, 10);
                System.out.println("You punch the enemy for " + dmg + " damage!");
            } else if (choice == 2) {
                dmg = randomDamage(8, 15);
                System.out.println("You kick the enemy for " + dmg + " damage!");
            } else {
                System.out.println("Invalid choice, you missed!");
                continue; // skip enemy attack if invalid
            }

            enemy.takeDamage(dmg);
            System.out.println(enemy.name + " HP: " + enemy.hp);

            if (!enemy.alive) {
                System.out.println("You defeated the " + enemy.name + "!");
                break;
            }

            // Enemy attack
            double enemyDmg = randomDamage(4, 12);
            player.takeDamage(enemyDmg);
            System.out.println(enemy.name + " attacks you for " + enemyDmg + " damage!");
            System.out.println(player.name + " HP: " + player.hp);

            if (!player.alive) {
                System.out.println("You were defeated! Game over!");
            }
        }
    }

    public static double randomDamage(double min, double max) {
        return min + Math.random() * (max - min);
    }
}
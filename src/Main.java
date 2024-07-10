import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter attributes for Player A:");
        int healthA = getPositiveInteger(scanner, "Health");
        int strengthA = getPositiveInteger(scanner, "Strength");
        int attackA = getPositiveInteger(scanner, "Attack");

        System.out.println("Enter attributes for Player B:");
        int healthB = getPositiveInteger(scanner, "Health");
        int strengthB = getPositiveInteger(scanner, "Strength");
        int attackB = getPositiveInteger(scanner, "Attack");

        AttackStrategy attackStrategy = new StrengthBasedAttackStrategy();
        DefenseStrategy defenseStrategy = new StrengthBasedDefenseStrategy();

        Player playerA = new Player(healthA, strengthA, attackA, attackStrategy, defenseStrategy);
        Player playerB = new Player(healthB, strengthB, attackB, attackStrategy, defenseStrategy);

        Arena arena = new Arena(playerA, playerB);
        arena.fight();

        scanner.close();
    }

    public static int getPositiveInteger(Scanner scanner, String attributeName) {
        int value;
        while (true) {
            System.out.print(attributeName + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive integer.");
                System.out.print(attributeName + ": ");
                scanner.next(); // discard non-integer input
            }
            value = scanner.nextInt();
            if (value > 0) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        }
        return value;
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        AttackStrategy attackStrategy = new StrengthBasedAttackStrategy();
        DefenseStrategy defenseStrategy = new StrengthBasedDefenseStrategy();

        Player playerA = new Player(50, 5, 10, attackStrategy, defenseStrategy);
        Player playerB = new Player(10, 10, 5, attackStrategy, defenseStrategy);

        Arena arena = new Arena(playerA, playerB);
        arena.fight();
    }
}

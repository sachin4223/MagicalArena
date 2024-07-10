public class ArenaTest {
    public static void main(String[] args) {
        AttackStrategy attackStrategy = new StrengthBasedAttackStrategy();
        DefenseStrategy defenseStrategy = new StrengthBasedDefenseStrategy();
        Player playerA = new Player(50, 5, 10, attackStrategy, defenseStrategy);
        Player playerB = new Player(100, 10, 5, attackStrategy, defenseStrategy);
        Arena arena = new Arena(playerA, playerB);

        arena.fight();

        boolean onlyOneAlive = playerA.isAlive() != playerB.isAlive();
        assert onlyOneAlive : "Failed fight test - both players cannot be alive or dead";

        System.out.println("ArenaTest passed.");
    }
}

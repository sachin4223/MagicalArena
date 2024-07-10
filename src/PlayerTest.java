public class PlayerTest {
    public static void main(String[] args) {
        AttackStrategy attackStrategy = new StrengthBasedAttackStrategy();
        DefenseStrategy defenseStrategy = new StrengthBasedDefenseStrategy();
        Player player = new Player(100, 10, 5, attackStrategy, defenseStrategy);

        // Test takeDamage
        player.takeDamage(20);
        assert player.getHealth() == 80 : "Failed takeDamage test";

        // Test isAlive
        assert player.isAlive() : "Failed isAlive test";
        player.takeDamage(100);
        assert !player.isAlive() : "Failed isAlive test after damage";

        // Test attack
        int damage = player.attack(4);
        assert damage == 20 : "Failed attack test";

        // Test defend
        int defense = player.defend(3);
        assert defense == 30 : "Failed defend test";

        System.out.println("PlayerTest passed.");
    }
}

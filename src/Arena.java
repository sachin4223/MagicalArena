// Arena class to manage the combat between two players
public class Arena {
    private Player playerA;
    private Player playerB;
    private Dice dice;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.dice = new Dice();
    }

    public void fight() {
        Player attacker, defender;

        // Determine initial attacker and defender based on health
        if (playerA.getHealth() < playerB.getHealth()) {
            attacker = playerA;
            defender = playerB;
        } else {
            attacker = playerB;
            defender = playerA;
        }

        // Continue fighting until one player dies
        while (playerA.isAlive() && playerB.isAlive()) {
            executeTurn(attacker, defender);
            // Print health of both players after each turn
            System.out.printf("Player A Health: %d, Player B Health: %d%n", playerA.getHealth(), playerB.getHealth());
            // Alternate turns
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        // Announce the winner
        System.out.println(playerA.isAlive() ? "Player A wins!" : "Player B wins!");
    }

    private void executeTurn(Player attacker, Player defender) {
        String attackerName = (attacker == playerA) ? "Player A" : "Player B";
        String defenderName = (defender == playerA) ? "Player A" : "Player B";

        System.out.printf("%s is attacking %s%n", attackerName, defenderName);

        int attackRoll = dice.roll();
        int defendRoll = dice.roll();

        int attackDamage = attacker.attack(attackRoll);
        int defendDamage = defender.defend(defendRoll);

        int damageToDefender = attackDamage - defendDamage;
        if (damageToDefender > 0) {
            defender.takeDamage(damageToDefender);
        }

        // Print turn details
        System.out.printf("%s rolls: %d, %s rolls: %d, Damage to %s: %d, %s's Health: %d%n",
                attackerName, attackRoll, defenderName, defendRoll, defenderName, Math.max(damageToDefender, 0), defenderName, defender.getHealth());
    }
}

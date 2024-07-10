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

        if (playerA.getHealth() < playerB.getHealth()) {
            attacker = playerA;
            defender = playerB;
        } else {
            attacker = playerB;
            defender = playerA;
        }

        while (playerA.isAlive() && playerB.isAlive()) {
            executeTurn(attacker, defender);
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        if (playerA.isAlive()) {
            System.out.println("Player A wins!");
        } else {
            System.out.println("Player B wins!");
        }
    }

    private void executeTurn(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defendRoll = dice.roll();

        int attackDamage = attacker.attack(attackRoll);
        int defendDamage = defender.defend(defendRoll);

        int damageToDefender = attackDamage - defendDamage;
        if (damageToDefender > 0) {
            defender.takeDamage(damageToDefender);
        }

        System.out.printf("Attacker rolls: %d, Defender rolls: %d, Damage to Defender: %d, Defender's Health: %d%n",
                attackRoll, defendRoll, Math.max(damageToDefender, 0), defender.getHealth());
    }
}

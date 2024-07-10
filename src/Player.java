// Player class using strategy patterns for attack and defense
public class Player {
    private int health;
    private int strength;
    private int attack;
    private AttackStrategy attackStrategy;
    private DefenseStrategy defenseStrategy;

    public Player(int health, int strength, int attack, AttackStrategy attackStrategy, DefenseStrategy defenseStrategy) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        this.attackStrategy = attackStrategy;
        this.defenseStrategy = defenseStrategy;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public int attack(int diceRoll) {
        return attackStrategy.calculateDamage(attack, diceRoll);
    }

    public int defend(int diceRoll) {
        return defenseStrategy.calculateDefense(strength, diceRoll);
    }
}

// Concrete strategy for attack based on strength
public class StrengthBasedAttackStrategy implements AttackStrategy {
    @Override
    public int calculateDamage(int attack, int diceRoll) {
        return attack * diceRoll;
    }
}

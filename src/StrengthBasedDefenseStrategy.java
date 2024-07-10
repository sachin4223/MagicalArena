// Concrete strategy for defense based on strength
public class StrengthBasedDefenseStrategy implements DefenseStrategy {
    @Override
    public int calculateDefense(int strength, int diceRoll) {
        return strength * diceRoll;
    }
}

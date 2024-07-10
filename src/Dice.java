import java.util.Random;

// Dice class to simulate rolling a six-sided die
public class Dice {
    private static final int SIDES = 6;
    private Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(SIDES) + 1;
    }
}

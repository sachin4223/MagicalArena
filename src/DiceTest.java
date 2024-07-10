public class DiceTest {
    public static void main(String[] args) {
        Dice dice = new Dice();
        boolean allRollsValid = true;
        for (int i = 0; i < 100; i++) {
            int roll = dice.roll();
            if (roll < 1 || roll > 6) {
                allRollsValid = false;
                break;
            }
        }
        if (allRollsValid) {
            System.out.println("DiceTest passed.");
        } else {
            System.out.println("DiceTest failed.");
        }
    }
}

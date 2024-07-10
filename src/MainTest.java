import java.util.Scanner;
import java.io.ByteArrayInputStream;

public class MainTest {

    public static void main(String[] args) {
        testGetPositiveInteger();
        testMainWithValidInput();
    }

    public static void testGetPositiveInteger() {
        String input = "10\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        int result = Main.getPositiveInteger(scanner, "Test");

        assert result == 10 : "Failed getPositiveInteger test";

        System.out.println("getPositiveInteger test passed.");
    }

    public static void testMainWithValidInput() {
        String input = "50\n5\n10\n100\n10\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try {
            Main.main(null);
            System.out.println("Main test with valid input passed.");
        } catch (Exception e) {
            System.out.println("Main test with valid input failed.");
            e.printStackTrace();
        }
    }
}

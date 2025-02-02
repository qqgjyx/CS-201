import java.util.ArrayList;
import java.util.Scanner;

public class PINCombinations {
    // Array mapping digits to their corresponding letters
    private static final String[] KEYPAD = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int attemptCount = 0;

            while (true) {
                System.out.print("Enter a PIN with a maximum of 6 digits: ");
                String input = scanner.nextLine();

                // Check if the input is valid
                if (input.matches("[2-9]{1,6}")) {
                    ArrayList<String> combinations = new ArrayList<>();
                    generateCombinations(input, 0, "", combinations);
                    System.out.println("Possible strings: " + combinations);
                    break;
                } else {
                    attemptCount++;
                    if (attemptCount >= 10) {
                        throw new IllegalArgumentException("Too many incorrect attempts. Please enter a valid PIN.");
                    }
                    System.out.println("Invalid input. Please try again.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException thrown" + e);
        }
    }

    private static void generateCombinations(String digits, int index, String current, ArrayList<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            generateCombinations(digits, index + 1, current + letters.charAt(i), result);
        }
    }
}

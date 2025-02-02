import java.util.InputMismatchException;
import java.util.Scanner;

public class AdditionOfDigits {
    static int RecursiveAddition(int input) {
        int positiveMark = 1;
        //        uncomment this if you want always positive sum of digits, even for negative input
        //        positiveMark = input >= 0 ? 1 : -1;
        int reminder = input % 10 * positiveMark;
        if (reminder == input) {
            return reminder;
        } else {
            int quotient = (input - reminder) / 10;
            return RecursiveAddition(quotient) + reminder;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        while (true) {
            try {
                System.out.println("Addition of all digits of the number is: " + RecursiveAddition(scanner.nextInt()));
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter an integer again: ");
                scanner.next();
            }
        }
    }
}


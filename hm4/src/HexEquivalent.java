import java.util.InputMismatchException;
import java.util.Scanner;

public class HexEquivalent {

    static char[] hexNumber = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    //As said by prof on Ed, no need to consider float, negative number
    static String getHexEquivalent(int num){
        if (num < 0) {
            throw new IllegalArgumentException("negative integer");
        }
        int intReminder = num % 16;
        int intQuotient = num - intReminder;
        char hexReminder = hexNumber[intReminder];
        if (intQuotient == 0){
            return String.valueOf(hexReminder);
        } else {
            return getHexEquivalent(intQuotient/16)+hexReminder;
        }
    }

//TODO:  static String getHexEquivalent(double num){}

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a decimal number (positive integer): ");
            int input = scanner.nextInt();
            System.out.println("It's hex equivalent: \n" + getHexEquivalent(input));
//                System.out.println(Integer.toHexString(input));
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException caught: " + e);
        } catch (IllegalArgumentException e1) {
            System.out.println("IllegalArgumentException caught: " + e1);
        }
    }
}

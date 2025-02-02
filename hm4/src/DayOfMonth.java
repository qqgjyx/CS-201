import java.util.InputMismatchException;
import java.util.Scanner;

public class DayOfMonth {
    static String[] months = {"January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"};
    static int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter an integer between 1 and 12: ");
            int input = scanner.nextInt();
            System.out.println(months[input - 1] + " has " + dom[input - 1] + " days. ");
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException caught " );
        } catch (IndexOutOfBoundsException e2) {
            System.out.println("wrong number");
        }
    }
}

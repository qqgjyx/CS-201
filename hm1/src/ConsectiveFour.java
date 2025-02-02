import java.util.Scanner;

public class ConsectiveFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of values: ");
        int size = scanner.nextInt();
        int[] values = new int[size];
        System.out.print("Enter the values: ");
        boolean result = false;
        for (int i = 0; i < size; i++) {
            values[i] = scanner.nextInt();
            if ( i >= 3 && !result && values[i] == values[i-1] && values[i] == values[i-2] && values[i] == values[i-3]) {
                result = true;
            }
        }
        if (result) {
            System.out.println("The list has consecutive fours");
        } else {
            System.out.println("The list has no consecutive fours");
        }
        scanner.close();
    }
}

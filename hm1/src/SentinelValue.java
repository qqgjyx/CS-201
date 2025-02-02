import java.util.Scanner;

public class SentinelValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int count = 0;
        int sentinel = -1;
        double average;
        double salary;
        System.out.print("Enter salary values (-1 to terminate): ");
        while ((salary = scanner.nextDouble()) != sentinel) {
            sum += salary;
            count++;
        }
        if (count > 0) {
            average = sum / count;
            System.out.println("Average salary: " + average);
        } else {
            System.out.println("Invalid inputs");
        }
        scanner.close();
    }
}

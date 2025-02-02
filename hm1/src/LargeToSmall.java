import java.util.Scanner;

public class LargeToSmall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three integers: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int max = Math.max(x, Math.max(y, z));
        int min = Math.min(x, Math.min(y, z));
        double result = Math.pow(max, min);
        System.out.println(result);
        scanner.close();
    }
}

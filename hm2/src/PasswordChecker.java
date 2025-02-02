import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int leastLength = 8;
        boolean hasUppercase;
        boolean hasLowercase;
        boolean hasDigit;
        String password;

        System.out.println("""
                Please enter a password that meets the following criteria:
                • Must have at least 8 characters
                • Must have at least one uppercase letter, one lowercase letter, and one digit""");
        System.out.print("Please enter a password: ");
        while (true) {
            password = scanner.nextLine();
            hasUppercase = password.matches(".*[A-Z].*");
            hasLowercase = password.matches(".*[a-z].*");
            hasDigit = password.matches(".*\\d.*");

            if (password.length() >= leastLength && hasUppercase && hasLowercase && hasDigit) {
                break;
            }
            System.out.print("Please enter a password again: ");
        }
        System.out.println("The password is okay!");

        scanner.close();
    }
}


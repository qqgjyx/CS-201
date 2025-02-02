import java.util.Scanner;
public class IsItSameRow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an English word: ");
        String word = scanner.nextLine().toLowerCase();
        boolean row1 = false;
        boolean row2 = false;
        boolean row3 = false;
        for (char c : word.toCharArray()) {
            if ("qwertyuiop".contains(String.valueOf(c))) row1 = true;
            else if ("asdfghjkl".contains(String.valueOf(c))) row2 = true;
            else if ("zxcvbnm".contains(String.valueOf(c))) row3 = true;
        }
        if ((row1 && !row2 && !row3) || (!row1 && row2 && !row3) || (!row1 && !row2 && row3)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        scanner.close();
    }
}


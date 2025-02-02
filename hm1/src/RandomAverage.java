import java.util.Random;

public class RandomAverage {
    public static void main(String[] args) {
        Random random = new Random();
        double sum = 0;
        double min = 1;
        double max = 0;
        int n = 5;
        for (int i = 0; i < n; i++) {
            double randomNum = random.nextDouble();
            sum += randomNum;
            min = Math.min(randomNum, min);
            max = Math.max(randomNum, max);
        }
        double average = sum / n;
        System.out.println("Average: " + average);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Normalization {
    // return the biggest elements of the input array, i.e., arr[] here.
    // do NOT use the java-built in function Math.max [2 points]
    public static double max(double[] arr){
        // your solutions start here
        double v = arr[0];
        for (double value : arr) {
            if (v < value) {
                v = value;
            }
        }
        return v;
    }
    // return the smallest elements of the input array, i.e., arr[] here.
    // do NOT use the java-built in function Math.min [2 points]
    public static double min(double[] arr){
        // your solutions start here
        double v = arr[0];
        for (double value : arr) {
            if (v > value) {
                v = value;
            }
        }
        return v;
    }
    // scaling the input array, i.e., arr[] here, so that each element is between 0 and 1
    // by subtracting the minimum value from each element
    // and then dividing each element by the difference
    // between the minimum and maximum values. [4 points]
    public static void scale(double[] arr){
        // your solutions start here
        if (arr.length == 0) {
            throw new IllegalArgumentException("No valid input");
        }
        double min = min(arr);
        double max = max(arr);
        if (max == min) {
            throw new IllegalArgumentException("Numbers all equal");
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (arr[i] - min) / (max - min);
            }
        }
    }
    // get user’s input and output the scaled array [4 points]
    public static void main(String[] args)
    {
        // ask user to enter some float-point or integer numbers
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some float-point or integer numbers (enter 'end' or non-numerical to terminate): ");
        // and put them into java array with type ‘double’
        double[] arr = new double[0];
        while (scanner.hasNextInt() || scanner.hasNextDouble()) {
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = Double.parseDouble(scanner.next());
        }
//        System.out.println(Arrays.toString(arr));
        // then call the method ‘scale’
        try {
            scale(arr);
            // then output the ‘scaled’ (or normalized) array.
            System.out.println("Scaled array: " + Arrays.toString(arr));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown: " + e);
        } finally {
            scanner.close();
        }
    }
}


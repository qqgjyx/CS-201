import java.util.Scanner;

public class DotProduct {
    public static void main(String[] args) {
        int m1, n1, m2, n2;
        int[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] matrixB = {
                {7, 8},
                {9, 10},
                {11, 12}
        };
        //codes make input possible, uncomment if necessary
        /*
        System.out.print("Enter the columns and rows for two matrices (m1 n1 m2 n2) (Enter -1 for default): ");
        Scanner scanner = new Scanner(System.in);
        if ((m1 = scanner.nextInt()) != -1) {
            n1 = scanner.nextInt();
            m2 = scanner.nextInt();
            n2 = scanner.nextInt();
            //System.out.printf("%d %d %d %d", m1, n1, m2, n2);
            matrixA = new int[m1][n1];
            matrixB = new int[m2][n2];
            for (int m = 0; m < m1; m++) {
                System.out.printf("Enter %d numbers for the row %d in matrixA: ", n1, m+1);
                for (int n = 0; n < n1; n++) {
                    matrixA[m][n] = scanner.nextInt();
                }
            }
            for (int m = 0; m < m2; m++) {
                System.out.printf("Enter %d numbers for the row %d in matrixB: ", n2, m+1);
                for (int n = 0; n < n2; n++) {
                    matrixB[m][n] = scanner.nextInt();
                }
            }
        }
        */
        m1 = matrixA.length;
        n1 = matrixA[0].length;
        m2 = matrixB.length;
        n2 = matrixB[0].length;
        if (n1 != m2) {
            System.out.println("Error: Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
        }
        int[][] result = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n1; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        // System.out.println("Resulting Matrix:");
        // Print the first row of the resulting matrix
        for (int j = 0; j < n2; j++) {
            System.out.print(result[0][j] + " ");
        }
        System.out.println();
        // Print the rest row of the resulting matrix
        /*
        for (int i = 1; i < m1 - 1; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        */
        // Print the last row of the resulting matrix
        for (int j = 0; j < n2; j++) {
            System.out.print(result[m1 - 1][j] + " ");
        }
    }
}


import java.util.Scanner;
public class exponemed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for the matrices: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for the matrices: ");
        int cols = scanner.nextInt();
        System.out.println("Enter elements of the first matrix:");
        int[][] matrix1 = inputMatrix(scanner, rows, cols);
        System.out.println("Enter elements of the second matrix:");
        int[][] matrix2 = inputMatrix(scanner, rows, cols);

        System.out.println("\nMatrix Addition:");
        int[][] sum = addMatrices(matrix1, matrix2);
        printMatrix(sum);

        System.out.println("\nMatrix Subtraction:");
        int[][] difference = subtractMatrices(matrix1, matrix2);
        printMatrix(difference);

        if (rows == cols) {
            System.out.println("\nMatrix Multiplication:");
            int[][] product = multiplyMatrices(matrix1, matrix2);
            printMatrix(product);
        } else {
            System.out.println("\nMatrix Multiplication not possible. Number of columns in the first matrix must match the number of rows in the second matrix.");
        }

        scanner.close();
    }

    public static int[][] inputMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element at (" + i + ", " + j + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix2[0].length;
        int commonDim = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < commonDim; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

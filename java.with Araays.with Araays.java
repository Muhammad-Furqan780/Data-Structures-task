import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {

        // 1. Declaration and initialization
        int[] numbers = {10, 20, 30, 40, 50};

        // Or declare with a size (default values are 0)
        int[] scores = new int[5];

        // 2. Assigning values by index
        scores[0] = 90;
        scores[1] = 85;
        scores[2] = 70;
        scores[3] = 95;
        scores[4] = 60;

        // 3. Accessing elements
        System.out.println("First element: " + numbers[0]);
        System.out.println("Length: " + numbers.length);

        // 4. Traversing with a for loop
        System.out.println("Using for loop:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        // 5. Traversing with a for-each loop
        System.out.println("Using for-each loop:");
        for (int n : scores) {
            System.out.print(n + " ");

        }
        System.out.println();

        // 6. Sorting
        Arrays.sort(scores);
        System.out.println("Sorted: " + Arrays.toString(scores));

        // 7. Searching (array must be sorted for binary search)
        int index = Arrays.binarySearch(scores, 85);
        System.out.println("Index of 85: " + index);

        // 8. Copying
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copy: " + Arrays.toString(copy));

        // 9. Sum and maximum
        int sum = 0, max = numbers[0];
        for (int n : numbers) {
            sum += n;
            if (n > max) max = n;
        }
        System.out.println("Sum: " + sum + ", Max: " + max);

        // 10. Two-dimensional array
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("2D array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
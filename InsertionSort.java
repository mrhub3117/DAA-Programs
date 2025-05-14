import java.util.Scanner;
import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        insertionSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));

        sc.close();
    }
}

WITH TIME COMPLEXITY:
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        long startTime = System.nanoTime(); // Start time tracking

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        long endTime = System.nanoTime(); // End time tracking
        long executionTime = endTime - startTime;
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Execution Time (nanoseconds): " + executionTime);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        insertionSort(arr);

        System.out.println("Time Complexity:");
        System.out.println("- **Best Case (Sorted Array):** O(n)");
        System.out.println("- **Worst Case (Reverse Sorted Array):** O(n²)");
        System.out.println("- **Average Case:** O(n²)");

        sc.close();
    }
}


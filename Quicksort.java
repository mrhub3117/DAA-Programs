import java.util.Scanner;

public class Quicksort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = low - 1; 
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        
        System.out.println("Enter " + n + " integer elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();  

        
        quickSort(arr, 0, arr.length - 1);


        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}


METHOD_2 FOR TIME COMPLEXITY n=5000:

import java.util.Random;
import java.util.Arrays;

public class QuickSortAnalysis {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 5000; 
        int[] arr = new int[n];

        
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10000); 

        long startTime = System.nanoTime(); 
        quickSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime(); 

        long duration = (endTime - startTime) / 1000000; 

        System.out.println("Sorted array (First 10 Elements): " + Arrays.toString(Arrays.copyOf(arr, 10)));
        System.out.println("Time taken to sort " + n + " elements: " + duration + " ms");
    }
}


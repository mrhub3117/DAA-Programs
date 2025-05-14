import java.util.*;

class SubsetSum {
    static void findSubsets(int[] arr, int d, List<Integer> subset, int index) {
        if (d == 0) {
            System.out.println(subset);
            return;
        }
        if (index == arr.length || d < 0)
            return;

        
        subset.add(arr[index]);
        findSubsets(arr, d - arr[index], subset, index + 1);

        
        subset.remove(subset.size() - 1);
        findSubsets(arr, d, subset, index + 1);
    }

    static void subsetSumSolver(int[] arr, int d) {
        List<Integer> subset = new ArrayList<>();
        System.out.println("Subsets whose sum is " + d + ":");
        findSubsets(arr, d, subset, 0);
    }

    public static void main(String[] args) {
        int[] S = {1, 2, 5, 6, 8};
        int d = 9;
        subsetSumSolver(S, d);
    }
}

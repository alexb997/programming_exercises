import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, 0, results);
        return results;
    }

    private static void backtrack(int[] nums, int start, List<List<Integer>> results) {
        if (start == nums.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            results.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, results);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {5, 2, 9};
        System.out.println(Arrays.toString(nums));

        List<List<Integer>> permutations = permute(nums);
        System.out.println("All possible permutations:");

        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}

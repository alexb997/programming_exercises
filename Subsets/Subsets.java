import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private static void backtrack(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> results) {
        results.add(new ArrayList<>(currentSubset));

        for (int i = index; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            backtrack(nums, i + 1, currentSubset, results);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 8};
        System.out.println(Arrays.toString(nums));

        List<List<Integer>> subsets = subsets(nums);
        System.out.println("All possible subsets:");

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}

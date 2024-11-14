import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSumPermutations {

    private static long modifiedSum(List<Integer> nums) {
        long runningSum = 0;
        long totalSum = 0;
        for (int num : nums) {
            runningSum += num;
            totalSum += runningSum;
        }
        return totalSum;
    }

    private static boolean nextPermutation(List<Integer> nums) {
        int n = nums.size();
        int i = n - 2;
        while (i >= 0 && nums.get(i) >= nums.get(i + 1)) {
            i--;
        }
        if (i < 0) return false;
        int j = n - 1;
        while (nums.get(j) <= nums.get(i)) {
            j--;
        }
        Collections.swap(nums, i, j);
        Collections.reverse(nums.subList(i + 1, n));

        return true;
    }

    public static long maxModifiedSum(List<Integer> nums) {
        List<Integer> currentPermutation = new ArrayList<>(nums);
        Collections.sort(currentPermutation);

        long maxSum = Long.MIN_VALUE;

        do {
            for (Integer num : currentPermutation) {
                System.out.print(num + " ");
            }
            System.out.println();
            long currentSum = modifiedSum(currentPermutation);
            maxSum = Math.max(maxSum, currentSum);
        } while (nextPermutation(currentPermutation));

        return maxSum;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 2, 2, 5);
        long maxSum = maxModifiedSum(nums);
        System.out.println("Maximum Sum from Permutations: " + maxSum);
    }
}

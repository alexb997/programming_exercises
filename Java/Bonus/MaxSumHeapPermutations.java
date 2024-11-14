import java.util.ArrayList;
import java.util.List;

public class MaxSumHeapPermutations {
    private static long incrementalModifiedSum(List<Integer> nums) {
        long runningSum = 0;
        long totalSum = 0;
        for (int num : nums) {
            runningSum += num;
            totalSum += runningSum;
        }
        return totalSum;
    }

    private static void heapPermutation(List<Integer> nums, int size, long[] maxSum) {
        if (size == 1) {
            maxSum[0] = Math.max(maxSum[0], incrementalModifiedSum(nums));
            return;
        }
        for (int i = 0; i < size; i++) {
            heapPermutation(nums, size - 1, maxSum);

            if (size % 2 == 1) {
                swap(nums, 0, size - 1);
            } else {
                swap(nums, i, size - 1);
            }
        }
    }

    private static void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
    public static long maxModifiedSum(List<Integer> nums) {
        long[] maxSum = {Long.MIN_VALUE};
        List<Integer> currentPermutation = new ArrayList<>(nums);
        heapPermutation(currentPermutation, nums.size(), maxSum);
        return maxSum[0];
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 5, 7);
        long maxSum = maxModifiedSum(nums);
        System.out.println("Maximum Sum from Permutations: " + maxSum);
    }
}

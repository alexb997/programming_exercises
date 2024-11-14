import java.util.*;

public class DynamicAccumulation {

    private static List<Integer> modifyList(List<Integer> nums) {
        List<Integer> modifiedList = new ArrayList<>(nums);
        long runningSum = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            int current = nums.get(i);
            if (current % 2 == 0) {
                modifiedList.set(i, (int)(current + runningSum));
            } else {
                modifiedList.set(i, (int)(current - runningSum));
            }
            runningSum += current;
        }
        return modifiedList;
    }
    private static long weightedSum(List<Integer> nums) {
        long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i) * (i + 1);
        }
        return sum;
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

    public static long maxWeightedSum(List<Integer> nums) {
        List<Integer> modifiedNums = modifyList(nums);
        Collections.sort(modifiedNums);
        Set<List<Integer>> processedPermutations = new HashSet<>();
        long maxWeightedSum = Long.MIN_VALUE;

        do {

            if (!processedPermutations.contains(modifiedNums)) {
                processedPermutations.add(new ArrayList<>(modifiedNums));
                long currentWeightedSum = weightedSum(modifiedNums);
                maxWeightedSum = Math.max(maxWeightedSum, currentWeightedSum);
            }
        } while (nextPermutation(modifiedNums));
        for (List<Integer> permutation : processedPermutations) {
            for (Integer num : permutation) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        return maxWeightedSum;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(0, 4, 7, 6);
        long maxSum = maxWeightedSum(nums);
        System.out.println("Maximum Weighted Sum from Unique Permutations: " + maxSum);
    }
}

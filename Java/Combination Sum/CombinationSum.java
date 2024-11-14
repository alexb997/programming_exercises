import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    private static void backtrack(List<List<Integer>> result, List<Integer> combination, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            combination.add(candidates[i]);
            backtrack(result, combination, candidates, target - candidates[i], i + 1);
            combination.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> combinations = solution(candidates, target);

        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}

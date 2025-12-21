import java.util.ArrayList;
import java.util.List;

public class lc39 {
    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        lc39 solution = new lc39();
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();

        helperFunction(target, candidates, 0, sequence, res);
        return res;
    }

    private void helperFunction(
            int target,
            int[] arr,
            int startIndex,
            List<Integer> sequence,
            List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(sequence)); // copy
            return;
        }

        if (target < 0)
            return;

        for (int i = startIndex; i < arr.length; i++) {
            sequence.add(arr[i]); // choose
            helperFunction(target - arr[i], arr, i, sequence, ans); // reuse allowed
            sequence.remove(sequence.size() - 1); // backtrack
        }
    }
}

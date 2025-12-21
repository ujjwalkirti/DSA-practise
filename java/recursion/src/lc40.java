import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc40 {
    public static void main(String[] args) {
        int[] candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        lc40 obj = new lc40();
        System.out.println(obj.combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> sequence = new ArrayList<>();
        helperFunction(target, candidates, 0, sequence, ans);
        return ans;
    }

    private void helperFunction(int target, int[] arr, int index, List<Integer> sequence, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(sequence));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > target)
                break;

            sequence.add(arr[i]);
            helperFunction(target - arr[i], arr, i + 1, sequence, ans);
            sequence.remove(sequence.size() - 1);
        }

    }

}

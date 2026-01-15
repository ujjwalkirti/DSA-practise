import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc15 {
    public static void main(String[] args) {
        lc15 obj = new lc15();
        int[] nums = { -1, -1, 0, 1, 2 };
        System.out.println(obj.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // sort the nums array in ascending order
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int el = nums[i];
            if (el > 0) {
                break;
            }
            if (i > 0 && el == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum + el == 0) {
                    // fill with list of nums[left], el, nums[right]
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(el);
                    list.add(nums[right]);
                    ans.add(list);
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;

                } else if (sum > -1 * el) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}

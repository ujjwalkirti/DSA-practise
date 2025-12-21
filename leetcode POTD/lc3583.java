
public class lc3583 {
    public static void main(String[] args) {
        int[] nums = new int[] { 6, 3, 6 };
        System.out.println(new lc3583().specialTriplets(nums));
    }

    public int specialTriplets(int[] nums) {
        long ans = 0;
        int N = 100001;
        int[] leftFreq = new int[N * 2];
        int[] rightFreq = new int[N * 2];
        for (int x : nums) {
            rightFreq[x]++;
        }

        for (int i = 0; i < nums.length; i++) {
            rightFreq[nums[i]]--;
            int target = 2 * nums[i];
            if (target <= N * 2) {
                ans += (long) rightFreq[target] * leftFreq[target];
            }

            leftFreq[nums[i]]++;
        }
        return (int) (ans % 1000000007);
    }
}

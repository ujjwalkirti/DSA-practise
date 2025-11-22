class lc3190 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4 };
        System.out.println(minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int remainder = nums[i] % 3;
            if (remainder != 0) {
                ans++;
            }
        }
        return ans;
    }
}

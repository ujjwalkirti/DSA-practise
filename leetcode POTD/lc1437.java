class lc1437 {
    public static void main(String[] args) {
        lc1437 obj = new lc1437();
        int[] nums = new int[] { 1, 0, 0, 1, 0, 1};
        int k = 2;
        System.out.println(obj.kLengthApart(nums, k));
    }

    public boolean kLengthApart(int[] nums, int k) {
        boolean decision = true;
        int indexOfLastEncounteredOne = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 && indexOfLastEncounteredOne != -1) {
                if ((i-indexOfLastEncounteredOne) <= k) {
                    decision = false;
                    break;
                } else {
                    indexOfLastEncounteredOne = i;
                }
            } else if (nums[i] == 1 && indexOfLastEncounteredOne == -1) {
                indexOfLastEncounteredOne = i;
            }
        }
        return decision;
    }
}

import java.util.HashMap;

public class leetcode1248 {
    public static void main(String[] args) {
        leetcode1248 obj = new leetcode1248();
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(obj.numberOfSubarrays(nums, k));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0, sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                sum+=1;
            }else{
                sum+=0;
            }
            if(map.containsKey(sum-k)){
                count+= map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

}

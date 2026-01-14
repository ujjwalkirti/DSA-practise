
import java.util.HashMap;
import java.util.Map;

public class lc3 {
    public static void main(String[] args) {
        lc3 obj = new lc3();
        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            int index = map.getOrDefault(key, -1);
            // you did not find that element in map
            if (index == -1) {
                map.put(key, i);
            } else {
                left = Math.max(left, index + 1);
                map.put(key, i);
            }
            right = i;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

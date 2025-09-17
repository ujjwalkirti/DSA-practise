import java.util.HashMap;

public class leetcode1358 {
    public static void main(String[] args) {
        leetcode1358 obj = new leetcode1358();
        String s = "abcabc";

        System.out.println(obj.numberOfSubstrings(s));
    }

    public int numberOfSubstrings(String s) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        count = map.get('a')*map.get('b')*map.get('c')*6;
        return count;
    }
}

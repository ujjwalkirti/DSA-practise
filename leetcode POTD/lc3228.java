
class LC3228 {

    public static void main(String[] args) {
        LC3228 obj = new LC3228();
        String s = "1001101";
        System.out.println(obj.maxOperations(s));
    }

    public int maxOperations(String s) {
        int count_ones = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count_ones++;
            }
            if (i + 1 < s.length() && s.charAt(i) == '1' && s.charAt(i + 1) == '0') {
                ans += count_ones;
            }

        }
        return ans;
    }
}

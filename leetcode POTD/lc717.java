class lc717 {
    public static void main(String[] args) {
        int[] bits = new int[] { 1, 1,1, 0 };
        lc717 obj = new lc717();
        boolean ans = obj.isOneBitCharacter(bits);
        System.out.println(ans);
    }

    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        }
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 1) {
                if (i == bits.length - 2) {
                    return false;
                } else {
                    i += 2;
                }
            } else {
                if (i == bits.length - 1) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}

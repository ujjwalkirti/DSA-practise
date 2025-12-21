import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next(); // read the binary string
            int indexAtWhich1WasFound = -1;
            int maxDistanceBetween1And0 = 0;
            if (s.length() > 0 && s.charAt(0) != '1') {

                int lastOneIndex = s.lastIndexOf('1');

                if (lastOneIndex != -1) {
                    int d = s.length() - lastOneIndex; // shift amount

                    // cyclic right rotation
                    s = s.substring(lastOneIndex) + s.substring(0, lastOneIndex);
                }
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') {
                    if (indexAtWhich1WasFound != -1) {
                        maxDistanceBetween1And0 = Math.max(maxDistanceBetween1And0, i - indexAtWhich1WasFound);
                    }
                } else {
                    indexAtWhich1WasFound = i;
                }
            }
            System.out.println(maxDistanceBetween1And0);
        }

        sc.close();
    }

}

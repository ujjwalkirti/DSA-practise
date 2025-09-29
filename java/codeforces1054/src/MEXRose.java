import java.util.*;

public class MEXRose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                a.add(sc.nextInt());
            }
            System.out.println(noOfChanges(n, k, a));
        }
    }

    static int noOfChanges(int n, int k, ArrayList<Integer> a) {
        Set<Integer> set = new HashSet<>(a);
        int count = 0;
        int missingCount = 0;
        // Check all numbers < k
        for (int i = 0; i < k; i++) {
            if (!set.contains(i)) {
                missingCount++;
            }
        }

        // If k is present, must remove it
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i)==k){
                count++;
            }
        }

        count += Math.max(missingCount-count,0);

        return count;
    }
}

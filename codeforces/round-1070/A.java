import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int count = 0;
            int max = 1;
            for (int i = 0; i < n; i++) {
                int number = sc.nextInt();
                if (number < max) {
                    count++;
                } else {
                    max = number;
                }
            }
            System.out.println(count);
        }

        sc.close();
    }
}

import java.util.HashMap;
import java.util.Scanner;

public class AandB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AandB obj = new AandB();
        int t = sc.nextInt();   // number of test cases
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();     // length of string
            String s = sc.next();     // read the string
            char[] c = s.toCharArray();  // convert to char array
            System.out.println(obj.noOfOperations(n, c));
        }
    }

    int noOfOperations(int n, char[] c) {
        int count = 0, i=0;
        while(i<c.length){
            for (int j = i; j < c.length; j++) {
                if(c[j]!= c[i]){
                    char temp = c[i];
                    c[i] = c[j];
                    c[j] = temp;
                    i=j;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}

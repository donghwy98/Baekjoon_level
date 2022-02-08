package greedy;
import java.util.Arrays;
import java.util.Scanner;
public class ATM {
    public static int N;
    public static int[] P;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        P = new int[N];
        for(int i=0; i<N; i++) {
            P[i] = scanner.nextInt();
        }
        Arrays.sort(P);
        System.out.println(waitingSum(0));
    }
    private static int waitingSum(int n) {
        int tmp = 0;
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += tmp + P[i];
            tmp += P[i];
        }
        return sum;
    }
}

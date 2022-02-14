package number;
import java.util.Scanner;
public class BinomialCoefficient_2 {
    public static int N;
    public static int K;
    public static int[][] dp;
    public static final int div = 10007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        dp = new int[N+1][K+1];
        System.out.println(BC(N, K));
    }
    private static int BC(int n, int k) {
        //이미 탐색한 값이 있으면 재활용
        if(dp[n][k] >0) {
            return dp[n][k];
        }
        //양쪽 끝 값은 항상 1
        if(k==0 || n==k) {
            return dp[n][k] = 1;
        }
        /**
         * nCm = n-1Cm-1 + n-1Cm
         */
        return dp[n][k] = (BC(n-1, k-1)+BC(n-1, k)) % div;
    }
}

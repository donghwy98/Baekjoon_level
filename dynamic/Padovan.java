package dynamic;
import java.util.Scanner;
public class Padovan {
    public static Long[] dp = new Long[101];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        int test = scanner.nextInt();

        for(int i=0; i<test; i++) {
            int n = scanner.nextInt();
            System.out.println(padovan(n));
        }
    }
    private static long padovan(int n) {
        if(dp[n] == null){
            dp[n] = padovan(n-2) + padovan(n-3);
        }
        return dp[n];
    }
}

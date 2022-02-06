package dynamic;
import java.util.Scanner;
public class LongestSubsequence {
    public static int N;
    public static int[] A;
    //각 위치에서의 최대 부분수열 길이 입력
    public static Integer[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        A = new int[N];
        dp = new Integer[N];
        dp[0] = 1;
        for(int i=0; i<N; i++) {
            A[i] = scanner.nextInt();
        }
        for(int i=0; i<N; i++){
            dp[i] = LS(i);
        }
        int max = dp[0];
        for(int i=0; i<N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
    private static int LS(int n) {
        if(dp[n]==null) {
            dp[n] = 1;
            //n-1부터 0까지 A[n]보다 작은 값 찾으며 재귀호출
            for(int i=n-1; i>=0; i--){
                if(A[i] < A[n]) {
                    dp[n] = Math.max(dp[n], LS(i)+1);
                }
            }
        }
        return dp[n];
    }
}

package dynamic;
import java.util.Scanner;
public class SequenceSum {
    public static int N;
    public static int[] arr;
    public static Integer[] dp;
    public static int max;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scanner.nextInt();
        }
        dp = new Integer[N];
        dp[0] = arr[0];
        max = arr[0];
        SeqSum(N-1);
        System.out.println(max);
    }
    private static int SeqSum(int n) {
        if(dp[n]==null){
            dp[n] = Math.max(SeqSum(n-1)+arr[n], arr[n]);
            max = Math.max(dp[n], max);
        }
        return dp[n];
    }
}

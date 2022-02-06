package dynamic;
import java.util.Scanner;
public class BinTile {
    public static int[] dp = new int[1000001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        //dp 초기화
        for(int i=0; i<dp.length; i++){
            if(i==0)
                dp[i] = 0;
            else if(i==1)
                dp[i] = 1;
            else if(i==2)
                dp[i] = 2;
            else
                dp[i] = -1;
        }
        System.out.println(count(N));
    }
    private static int count(int n) {
        if(dp[n] == -1) {
            dp[n] = (count(n-1) + count(n - 2)) % 15746;
        }
        return dp[n];
    }
}

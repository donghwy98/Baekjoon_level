package dynamic;
import java.util.Scanner;
public class Fibonacci {
    public static Integer[][] dp = new Integer[41][2];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        dp[0][0] = 1; //n=0일때 0 호출 횟수
        dp[0][1] = 0; //n=0일때 1 호출 횟수
        dp[1][0] = 0; //n=1일때 0 호출 횟수
        dp[1][1] = 1; //n=1일때 1 호출 횟수
        int test = scanner.nextInt();
        for(int i=0; i<test; i++){
            int n = scanner.nextInt();
            fibonacci(n);
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
    private static Integer[] fibonacci(int n) {
        //아직 탐색하지 않은 값인 경우
        if(dp[n][0] == null || dp[n][1] == null) {
            //각 n에 대한 0과 1 호출 횟수를 재귀 호출
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        //[n][0]과 [n][1]을 담고있는 [n] 반환
        return dp[n];
    }
}

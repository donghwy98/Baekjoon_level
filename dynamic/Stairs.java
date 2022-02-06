package dynamic;
import java.util.Scanner;
public class Stairs {
    public static int stairs;
    public static int[] scores;
    public static Integer[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        stairs = scanner.nextInt();
        scores = new int[stairs+1];
        dp = new Integer[stairs+1];

        for(int i=1; i<=stairs; i++) {
            scores[i] = scanner.nextInt();
        }
        dp[0] = scores[0];
        dp[1] = scores[1];
        if(stairs>=2){
            dp[2] = scores[1] + scores[2];
        }
        System.out.println(find(stairs));
    }
    /**
     * n-3  n-2  n-1  n
     * n번째 계단을 밟는 경우의 수는 두 개뿐
     * (연속된 세 개 계단을 모두 밟을 수 없기 때문에)
     *   1. n-3 → n-1 → n
     *   2. n-2 → n
     */
    private static int find(int n) {
        if(dp[n] == null) {
            dp[n] = Math.max(find(n-2), find(n-3)+scores[n-1]) +scores[n];
        }
        return dp[n];
    }
}

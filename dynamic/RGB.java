package dynamic;
import java.util.Scanner;
public class RGB {
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;
    public static int[][] dp;
    public static int[][] cost;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n][3];
        cost = new int[n][3];
        for(int i=0; i<n; i++) {
            cost[i][Red] = scanner.nextInt();
            cost[i][Green] = scanner.nextInt();
            cost[i][Blue] = scanner.nextInt();
        }
        dp[0][Red] = cost[0][Red];
        dp[0][Green] = cost[0][Green];
        dp[0][Blue] = cost[0][Blue];

        int minCost = Math.min(paint(n-1, Red), Math.min(paint(n-1, Green), paint(n-1, Blue)));
        System.out.println(minCost);
    }
    private static int paint(int n, int color) {
        if(dp[n][color] == 0) {
            if(color == Red) {
                dp[n][Red] = Math.min(paint(n-1, Green), paint(n-1, Blue)) + cost[n][Red];
            }
            if(color == Green) {
                dp[n][Green] = Math.min(paint(n-1, Red), paint(n-1, Blue)) + cost[n][Green];
            }
            if(color == Blue) {
                dp[n][Blue] = Math.min(paint(n-1, Red), paint(n-1, Green)) + cost[n][Blue];
            }
        }
        return dp[n][color];
    }
}

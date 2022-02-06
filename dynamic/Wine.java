package dynamic;
import java.util.Scanner;
public class Wine {
    public static int n;
    public static int[] wines;
    public static Integer[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dp = new Integer[n+1];
        wines = new int[n+1];
        for(int i=1; i<n+1; i++) {
            wines[i] = scanner.nextInt();
        }
        dp[0] = 0;
        dp[1] = wines[1];
        if(n>1) {
            dp[2] = wines[1]+wines[2];
        }
        System.out.println(drink(n));
    }
    /**
     * n번째 와인을 먹는 경우의 수 2개와
     *    1) n-3, n-2,    , n
     *    2) n-3,    , n-1, n
     * n번째 와인을 안 먹는 경우의 수 1개
     * (n-1번째에서의 최댓값)
     *    1) drink(n-1)
     * 최댓값 비교
     */
    //drink(n) = n번째 위치에서 먹은 와인의 누적 값
    private static int drink(int n) {
        if(dp[n] == null){
            dp[n] = Math.max(
                       Math.max(drink(n-2), drink(n-3)+wines[n-1])+wines[n],
                       drink(n-1)
                    );
        }
        return dp[n];
    }
}

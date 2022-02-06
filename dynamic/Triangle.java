package dynamic;
import java.util.Scanner;
import static java.lang.Math.max;
public class Triangle {
    // 삼각형을 입력받을 arr
    public static int[][] arr;
    // 경로의 합을 입력할 dp
    public static Integer[][] dp;
    public static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n][n];
        dp = new Integer[n][n];
        //삼각형 입력
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        //삼각형의 가장 아래층만 dp에 복사
        for(int i=0; i<n; i++) {
            dp[n-1][i] = arr[n-1][i];
        }
        System.out.println(maxRoute(0, 0));
    }

    //depth = 삼각형의 층, idx = 해당 층에서의 위치
    public static int maxRoute(int depth, int idx) {
        /**
         * dp 삼각형의 맨 아래층은 arr 삼각형의 값을 복사했으니
         * 그 위층 부터 탐색하면서 비어있을 경우
         * 'arr 삼각형에서 현 위치 값 + 아래층의 최댓값'을 입력
         * dp 삼각형의 꼭대기(dp[0][0])는 경로 합의 최댓값이 입력됨
         */
        if(dp[depth][idx] == null) {
            dp[depth][idx] = max(maxRoute(depth+1, idx), maxRoute(depth+1, idx+1))
                    + arr[depth][idx];
        }
        if(depth == n-1) {
            return dp[depth][idx];
        }
        return dp[depth][idx];
    }

}

package number;
import java.util.Scanner;
public class Bridge {
    public static int T;
    public static int N;
    public static int M;
    public static int[][] dp = new int[30][30];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for(int i=0; i<T; i++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            System.out.println(combi(M,N));
        }
    }
    /**
     * 서로 다른 M개에서 N개를 뽑는 경우이므로
     * 조합 공식으로 나타내면 mCn!!
     * 조합은 순서를 고려하지 않음
     */
    private static int combi(int m, int n) {
        //이미 탐색한 값이 있으면 재활용
        if(dp[m][n] > 0){
            return dp[m][n];
        }
        //양쪽 끝 값은 항상 1
        if(n==0 || m==n) {
            return dp[m][n]=1;
        }
        //nCm = n-1Cm-1 + n-1Cm
        return dp[m][n]=combi(m-1, n-1)+combi(m-1,n);

    }
}

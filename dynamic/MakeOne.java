package dynamic;

import java.util.Scanner;

public class MakeOne {
    public static int N;
    //최소 연산 횟수가 저장되는 배열
    public static Integer[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        dp = new Integer[N+1];
        //N=0,1일 때 연산 수는 0
        dp[0]=0;
        dp[1]=0;
        System.out.println(makeOne(N));
    }
    /**
     * N => dp[N]
     * 1     0
     * 2     1     dp[2]는 dp[1]+1
     * 3     1     dp[3]은 dp[1]+1
     * 4     2     dp[4]는 dp[2]+2
     * .....       ....이전 dp 활용
     */
    private static int makeOne(int N){
        if(dp[N] == null){
            if(N%6 == 0) {
                dp[N] = Math.min(makeOne(N-1),
                        Math.min(makeOne(N/3), makeOne(N/2))) + 1;
            }
            else if(N%3 == 0) {
                dp[N] = Math.min(makeOne(N/3), makeOne(N-1)) + 1;
            }
            else if(N%2 == 0) {
                dp[N] = Math.min(makeOne(N/2), makeOne(N-1)) + 1;
            }
            else {
                dp[N] = makeOne(N-1) + 1;
            }
        }
        return dp[N];
    }
}

package dynamic;
import java.util.Scanner;
public class FunnyFunction {
    /**
     * 함수 w에서 a, b, c 중
     * 하나라도 20 초과면 w(20, 20, 20) 호출하고,
     * 하나라도 0 이하면 1 반환하므로
     * 각 배열의 크기가 21을 넘지 않음
     */
    public static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if(a==-1 && b==-1 && c==-1) {
                break;
            }
            sb.append("w("+a+", "+b+", "+c+") = ").append(w(a, b, c)).append("\n");
        }
        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {
        // a, b, c 모두 범위를 벗어나지 않으면서 '메모이제이션' 된 경우
        if(inRange(a, b, c) && dp[a][b][c]!=0){
            return dp[a][b][c];
        }
        if(a<=0 || b<=0 || c<=0) {
            return 1;
        }
        if(a>20 || b>20 || c>20) {
            dp[20][20][20] = w(20, 20, 20);
            return dp[20][20][20];
        }
        if(a<b && b<c) {
            dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return dp[a][b][c];
        }
        else {
            dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
            return dp[a][b][c];
        }
    }
    /**
     * 배열을 참조하려고 할 때
     * a, b, c 모두 범위 안에 있는지 확인
     */
    private static boolean inRange(int a, int b, int c) {
        return 0<=a && a<=20 && 0<=b && b<=20 && 0<=c && c<=20;
    }

}

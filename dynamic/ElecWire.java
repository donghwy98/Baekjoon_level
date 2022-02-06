package dynamic;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class ElecWire {
    public static int N;
    public static int[][] wire;
    public static Integer[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        dp = new Integer[N];
        //wire[][0]은 A 전봇대
        //wire[][1]는 B 전봇대
        wire = new int[N][2];
        for(int i=0; i<N; i++) {
            wire[i][0] = scanner.nextInt();
            wire[i][1] = scanner.nextInt();
        }
        //A전봇대를 기준으로 오름차순 정렬
        Arrays.sort(wire, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int max=0;
        //A전봇대를 기준으로 연결가능한 개수 탐색/최댓값 찾기
        for(int i=0; i<N; i++) {
            max = Math.max(link(i), max);
        }
        //총 전선 수 -연결 가능한 최대 전선 수 = 제거해야할 전선 수
        System.out.println(N-max);
    }
    /**
     * A전봇대의 n번째 전선이 B전봇대에 연결된 위치보다
     * A전봇대의 i번째 전선이 B전봇대에 연결된 위치가 크면
     * 연결 가능
     */
    private static int link(int n) {
        if(dp[n]==null) {
            dp[n] = 1;
            for(int i=n+1; i<dp.length; i++) {
                if(wire[n][1]<wire[i][1]) {
                    //연결 가능한 경우의 수 중 최댓값을 dp에 저장
                    dp[n] = Math.max(dp[n], link(i)+1);
                }
            }
        }
        return dp[n];
    }
}

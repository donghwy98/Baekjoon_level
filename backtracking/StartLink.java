package backtracking;
import java.util.Scanner;
public class StartLink {
    public static int[][] s;
    public static int n;
    public static boolean[] visit;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = new int[n][n];
        visit = new boolean[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                s[i][j] = scanner.nextInt();
            }
        }
        combine(0, 0);
        System.out.println(min);
    }

    private static void combine(int idx, int teams) {
        //팀 조합이 완성된 경우
        if(teams == n/2){
            statDiff();
            return;
        }
        for(int i=idx; i<n; i++){
            //방문하지 않은 경우(생성 초기값이 false)
            if(!visit[i]){
                //방문으로 변경하고 재귀호출
                visit[i]=true;
                combine(i+1, teams+1);
                //재귀 끝나면 방문 초기화
                visit[i] = false;
            }
        }
    }

    //능력치 차이 계산
    private static void statDiff() {
        int startTeam = 0;
        int linkTeam = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                //visit이 true인 사람들은 스타트팀
                if(visit[i]==true && visit[j]==true){
                    startTeam += (s[i][j]+s[j][i]);
                }
                //visit이 false인 사람들은 링크팀
                else if(visit[i]==false && visit[j]==false){
                    linkTeam += (s[i][j]+s[j][i]);
                }
            }
        }
        int diff = Math.abs(startTeam - linkTeam);
        min = Math.min(diff, min);
    }
}
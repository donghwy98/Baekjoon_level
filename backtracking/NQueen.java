package backtracking;
import java.util.Scanner;
public class NQueen {

    public static int[] arr;
    public static int N;
    public static int answer = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        arr = new int[N];

        NQueen(0);
        System.out.println(answer);
    }

    public static void NQueen(int level){
        if(level==N){
            answer++;
            return;
        }
        for(int i=0; i<N; i++){
            arr[level] = i;
            if(check(level)){
                NQueen(level+1);
            }
        }
    }
    public static boolean check(int col) {
        for(int i=0; i<col; i++){
            //행에 퀸이 존재하는 경우
            if(arr[col] == arr[i]){
                return false;
            }
            //대각선 상에 퀸이 존재하는 경우 (열의 차와 행의 차가 같은 경우)
            else if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {
                return false;
            }
        }
        return true;
    }
}

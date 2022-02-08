package greedy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class MeetingRoom {
    public static int N;
    public static int[][] times;
    public static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        times = new int[N][2];
        for(int i=0; i<N; i++) {
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
        }
        //끝나는 시간을 기준으로 정렬
        Arrays.sort(times, new Comparator<int[]> (){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        System.out.println(assignment());
    }
    private static int assignment() {
        int endTime = 0;
        for(int i=0; i<N; i++){
            /**
             * 이전 회의의 종료시간(endTime)이
             * 다음 회의의 시작시간보다 같거나 빠르면
             * endTime을 다음 회의의 종료시간으로 갱신
             */
            if(endTime<=times[i][0]){
                endTime=times[i][1];
                count++;
            }
        }
        return count;
    }
}


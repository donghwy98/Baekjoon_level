package geometry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Turret {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            System.out.println(calculate(x1, y1, r1, x2, y2, r2));
        }
    }

    public static int calculate(int x1, int y1, int r1, int x2, int y2, int r2){
        //중점 사이의 거리의 제곱
        int d = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        //중점이 같고 반지름도 같은 경우
        if(x1==x2 && y1==y2 && r1==r2) {
            return -1;
        }
        //중점 사이의 거리보다 반지름의 합이 작은 경우(만나지 않는 두 원)
        else if(d>Math.pow(r1+r2, 2)) {
            return 0;
        }
        //중점 사이의 거리보다 반지름의 차가 큰 경우(원 안에 만나지 않는 원)
        else if(d<Math.pow(r2-r1, 2)) {
            return 0;
        }
        //중점 사이의 거리와 반지름의 차가 같은 경우(내접하는 원)
        else if(d==Math.pow(r2-r1, 2)) {
            return 1;
        }
        //중점 사이의 거리와 반지름의 합이 같은 경우(외접하는 원)
        else if(d==Math.pow(r1+r2, 2)) {
            return 1;
        }
        //그 외의 경우 겹치면서 두 점에서 만나는 원
        else {
            return 2;
        }
    }
}

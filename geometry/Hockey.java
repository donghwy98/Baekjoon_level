package geometry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Hockey {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        for(int i=0; i<P; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int px = Integer.parseInt(st.nextToken());
            int py = Integer.parseInt(st.nextToken());
            //사람이 안에 있는지 확인
            boolean inside = inside(W, H, X, Y, px, py);
            if(inside) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean inside(int W, int H, int X, int Y, int px, int py) {
        //네모 안에 있는 경우
        if(X<=px && px<=X+W && Y<=py && py<=Y+H) {
            return true;
        }
        double Ld = Math.pow(px-X, 2) + Math.pow(py-(Y+(H/2)), 2);
        double Rd = Math.pow(px-(X+W), 2) + Math.pow(py-(Y+(H/2)), 2);
        //좌우 반 원 안에 있는 경우
        if(Ld<=Math.pow(H/2, 2) || Rd<=Math.pow(H/2, 2)) {
            return true;
        }
        else
            return false;
    }
}

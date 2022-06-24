package geometry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LittlePrince {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                //시작점이 행성계 안에 있는지
                boolean checkStart = false;
                //도착점이 행성계 안에 있는지
                boolean checkDest = false;
                //시작점이 행성 안에 있으면 true
                if(Math.pow(x1-cx,2)+Math.pow(y1-cy,2) < Math.pow(r,2))
                    checkStart = true;
                //도착점이 행성 안에 있으면 true
                if(Math.pow(x2-cx,2)+Math.pow(y2-cy,2) < Math.pow(r,2))
                    checkDest = true;
                //두 곳이 모두 내부 또는 모두 외부에 있는 경우
                if(checkStart && checkDest)
                    continue;
                //두 곳이 서로 다른 곳에 있는 경우
                else if(checkStart || checkDest)
                    answer++;
            }
            System.out.println(answer);
        }
    }
}

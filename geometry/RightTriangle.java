package geometry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class RightTriangle {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] triangle = {Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            if (triangle[0] == 0) {
                return;
            }
            else {
                if (triangle[0] > triangle[1] && triangle[0] > triangle[2]) {
                    if (triangle[0] * triangle[0] == (triangle[1] * triangle[1]) + (triangle[2] * triangle[2])) {
                        System.out.println("right");
                    } else {
                        System.out.println("wrong");
                    }
                }
                if (triangle[1] > triangle[0] && triangle[1] > triangle[2]) {
                    if (triangle[1] * triangle[1] == (triangle[0] * triangle[0]) + (triangle[2] * triangle[2])) {
                        System.out.println("right");
                    } else {
                        System.out.println("wrong");
                    }
                }
                if (triangle[2] > triangle[0] && triangle[2] > triangle[1]) {
                    if (triangle[2] * triangle[2] == (triangle[0] * triangle[0]) + (triangle[1] * triangle[1])) {
                        System.out.println("right");
                    } else {
                        System.out.println("wrong");
                    }
                }
            }
        }
    }
}

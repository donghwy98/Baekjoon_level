package geometry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class FourthDot {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] a = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

        st = new StringTokenizer(br.readLine(), " ");
        int[] b = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

        st = new StringTokenizer(br.readLine(), " ");
        int[] c = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

        int[] d = new int[2];

        if( a[0]==b[0] ) {
            d[0] = c[0];
        }
        else if(a[0]==c[0]) {
            d[0] = b[0];
        }
        else if(b[0]==c[0]) {
            d[0] = a[0];
        }

        if( a[1]==b[1] ) {
            d[1] = c[1];
        }
        else if(a[1]==c[1]) {
            d[1] = b[1];
        }
        else if(b[1]==c[1]) {
            d[1] = a[1];
        }

        System.out.println(d[0]+" "+d[1]);

    }
}

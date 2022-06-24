package geometry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Taxi {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        double r = Double.parseDouble(br.readLine());
        double Euclidea = r*r*Math.PI;
        double NonEuclidea = 2*r*r;
        System.out.println(String.format("%.6f", Euclidea));
        System.out.println(String.format("%.6f", NonEuclidea));

    }
}

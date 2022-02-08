package greedy;
import java.util.Scanner;
public class GasStation {
    public static int N;
    public static long[] distances;
    public static long[] gasPrices;
    public static long sum = 0;
    public static long minCost;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        distances = new long[N-1];
        gasPrices = new long[N];
        for(int i=0; i<N-1; i++) {
            distances[i] = scanner.nextLong();
        }
        for(int i=0; i<N; i++) {
            gasPrices[i] = scanner.nextLong();
        }
        System.out.println(cost());
    }
    /**
     * 현재 주유소의 가격이 이전 주유소보다 비쌀 경우
     * 이전 주유소의 가격으로 계산
     * ex) 5 2 4 1 --→ 5 2 2 1
     */
    private static long cost() {
        minCost = gasPrices[0];
        for(int i=0; i<N-1; i++) {
            //현재 주유소가 이전 주요소보다 쌀 때 minCost 갱신
            if(gasPrices[i] < minCost) {
                minCost = gasPrices[i];
            }
            sum += (minCost * distances[i]);
        }
        return sum;
    }
}

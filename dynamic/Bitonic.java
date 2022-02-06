package dynamic;
import java.util.Scanner;
public class Bitonic {
    public static int N;
    public static int[] A;
    //증가하는 부분수열의 최대길이 저장
    public static Integer[] dpAsc;
    //감소하는 부분수열의 최대길이 저장
    public static Integer[] dpDesc;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        A = new int[N];
        dpAsc = new Integer[N];
        dpDesc = new Integer[N];

        for (int i=0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i=0; i < N; i++) {
            ASC(i);
            DESC(i);
        }
        /**
         * 증가/감소하는 부분수열의 최대 길이는
         * <dpAsc>
         *   1,2,3,4,5가 이루는 수열의 길이 5
         * <dpDesc>
         *   5,2,1이 이루는 수열의 길이 3
         * 두 부분수열에서 원소 5가 중복되므로
         * 1을 빼주면 전체 수열의 최대 길이 바이토닉 부분수열
         */
        int max = 0;
        for(int i=0; i<N; i++){
            max = Math.max(dpAsc[i]+dpDesc[i]-1, max);
        }
        System.out.println(max);
    }
    //맨 앞부터 n까지 증가하는 부분수열의 최대길이
    private static int ASC(int n) {
        if(dpAsc[n]==null){
            dpAsc[n] = 1;
            for(int i=n-1; i>=0; i--) {
                if(A[i]<A[n]){
                    dpAsc[n] = Math.max(dpAsc[n], ASC(i)+1);
                }
            }
        }
        return dpAsc[n];
    }
    //n부터 맨 마지막까지 감소하는 부분수열의 최대길이
    private static int DESC(int n) {
        if(dpDesc[n]==null){
            dpDesc[n] = 1;
            for(int i=n+1; i<dpDesc.length; i++) {
                if(A[n]>A[i]){
                    dpDesc[n] = Math.max(dpDesc[n], DESC(i)+1);
                }
            }
        }
        return dpDesc[n];
    }
}

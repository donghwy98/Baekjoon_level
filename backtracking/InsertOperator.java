package backtracking;
import java.util.Scanner;
public class InsertOperator {
    public static int max = Integer.MIN_VALUE;//최댓값 초기값 설정
    public static int min = Integer.MAX_VALUE;//최솟값 초기값 설정
    public static int[] operators; //각 연산자 개수
    public static int[] numbers; //각 숫자
    public static int N; //숫자의 개수

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //숫자 입력
        N = scanner.nextInt();
        numbers = new int[N];
        for(int i=0; i<N; i++){
            numbers[i] = scanner.nextInt();
        }
        //연산자 개수 입력 +, -, *,/
        operators = new int[4];
        for(int i=0; i<4; i++){
            operators[i] = scanner.nextInt();
        }
        calculation(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void calculation(int num, int idx) {
        //모든 연산자를 사용한 경우
        if(idx==N){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for(int i=0; i<4; i++) {
            //연산자 개수가 1개 이상인 경우
            if(operators[i]>0){
                //재귀호출마다 해당 연산자 개수를 1 감소시키며 0이 되면 다음 연산자로 넘어감
                operators[i]--;
                switch(i){
                    case 0:
                        calculation(num + numbers[idx], idx+1);
                        break;
                    case 1:
                        calculation(num - numbers[idx], idx+1);
                        break;
                    case 2:
                        calculation(num * numbers[idx], idx+1);
                        break;
                    case 3:
                        calculation(num / numbers[idx], idx+1);
                        break;
                }
                //재귀호출 끝나면 연산자 개수 복구
                operators[i]++;
            }
        }
    }
}

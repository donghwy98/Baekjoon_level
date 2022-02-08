package greedy;
import java.util.Scanner;
public class LostParenthesis {
    public static String formula;
    public static String[] minusSplit;
    public static String[] plusSplit;
    public static int answer=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        formula = scanner.nextLine();
        System.out.println(parenthesis());
    }
    /**
     * 최솟값을 만들려면 큰 수를 음수로 만드는게 좋으니
     * "-"를 기준으로 문자열을 분리하고
     * 덧셈 부분을 먼저 계산한 뒤
     * 뺄셈 부분 계산
     */
    private static int parenthesis() {
        //공식을 "-"를 기준으로 분리
        minusSplit = formula.split("-");
        for(int i=0; i<minusSplit.length; i++) {
            //분리한 공식을 "+"를 기준으로 분리, 먼저 계산
            plusSplit = minusSplit[i].split("\\+");
            int tmp=0;
            for (String num : plusSplit) {
                tmp += Integer.parseInt(num);
            }
            if(i==0){
                answer += tmp;
            } else {
                answer -= tmp;
            }
        }
        return answer;
    }
}

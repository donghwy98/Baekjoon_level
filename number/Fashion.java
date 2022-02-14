package number;
import java.util.HashMap;
import java.util.Scanner;
public class Fashion {
    public static int T;
    public static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        while(T > 0) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            n = scanner.nextInt();
            while(n > 0) {
                String name = scanner.next();
                String category = scanner.next();
                /**
                 * 해당 종류의 옷이 해시맵에 있으면?
                 *   >>해당 종류의 개수를 +1
                 * 해당 종류의 옷이 해시맵에 없으면?
                 *   >>해당 종류 입력, 개수 1
                 */
                if(hashMap.containsKey(category)) {
                    hashMap.put(category, hashMap.get(category)+1);
                } else {
                    hashMap.put(category, 1);
                }
                n--;
            }
            int answer = 1;
            for(int day : hashMap.values()) {
                //안 입는 경우를 고려하여 각 종류별 옷의 개수에 +1 해 준 값을 곱함
                answer *= (day+1);
            }
            //알몸이 되는 날을 빼줌
            System.out.println(answer-1);
            T--;
        }
    }
}

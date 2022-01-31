package sort_12;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class WordSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		String[] arr = new String[num];
		scanner.nextLine();
		
		for(int i=0; i<num; i++) {
			arr[i] = scanner.nextLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				else {
					return s1.length() - s2.length();
				}
			}
		});
		
		System.out.println(arr[0]);
		
		for(int i=1; i<num; i++) {
			if(!arr[i].equals(arr[i-1])) {
				System.out.println(arr[i]);
			}
		}
		scanner.close();
	}
}

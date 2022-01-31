package sort_12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class AgeSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Person[] person = new Person[num];

		for(int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			person[i] = new Person(age, name);
		}
		Arrays.sort(person, new Comparator<Person>() {
			@Override
			public int compare(Person s1, Person s2) {
				return s1.age - s2.age;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<num; i++) {
			sb.append(person[i]);
		}
		System.out.println(sb);
	}
	public static class Person {
		int age;
		String name;
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}
}





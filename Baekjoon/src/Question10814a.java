import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Question10814a {
    public static class person {
        int age;
        String name;

        public person (int age,String name) {
            this.age = age;
            this.name = name;
        }
        public String toString () {

            return ""+age+" "+name+"\n";
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        person[] arr = new person[testCase];
        for (int i = 0; i < testCase;i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            String two = st.nextToken();
            arr[i] = new person(one,two);
        }
        //정렬
        Arrays.sort(arr, new Comparator<person>() {
            @Override
            public int compare(person o1, person o2) {
                return o1.age - o2.age;
            }
        });
        for (int i = 0; i < testCase;i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}

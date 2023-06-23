import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Question2535 {
    static class a  {
        int country;
        int students;
        int score;

      public a (int country,int students,int score) {
            this.country = country;
            this.score = score;
            this.students = students;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        a[] result = new a[testCase];
        int[] people = new int[testCase];

        StringTokenizer st;
        for (int i = 0; i < testCase;i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            result[i] = new a(one, two, three);
        }

        Arrays.sort(result, new Comparator<a>() {
            @Override
            public int compare(a o1, a o2) {
                return o2.score - o1.score;
            }
        });
        int check = 0;
        for (int i = 0; i < testCase;i++) {
            if (check == 3) {
                break;
            } else {
                if (people[result[i].country] < 2) { //해당국가가 2번이하로 받은경우
                    people[result[i].country] += 1;
                    System.out.println(""+result[i].country+" "+result[i].students+"");
                    check += 1; //한명뽑음
                }
            }
        }
    }
}

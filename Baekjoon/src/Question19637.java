
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question19637 {
    public static void main(String[] args) throws IOException {
        new Question19637().code();
    }
    public void code () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Type[] arr = new Type[N];

        for (int i = 0; i < N;i++) {
            String str = br.readLine();
            String[] cut = str.split(" ");

            arr[i] = new Type(cut[0], Integer.parseInt(cut[1])); //객체배열생성
        }

        for (int i = 0; i < M;i++) {
            long num = Integer.parseInt(br.readLine());

            int start = 0;
            int end = N - 1;

            while (start < end) {
                int middle = ((start + end) / 2);

                if (arr[middle].power < num) { //입력값이 더큰경우
                    start = middle + 1;
                } else { //반대의경우
                    end = middle;
                }
            }
            sb.append(arr[start].alpha).append("\n");
        }
        System.out.println(sb);
    }
     class Type { //객체를 이용
        String alpha;
        int power;
        public Type (String alpha,int power) {
            this.alpha = alpha;
            this.power = power;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Question22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> keyward = new HashSet<>(); //키워드

        for (int i = 0; i < N; i++) { //키워드 저장
            String str = br.readLine();
            keyward.add(str);
        }
        for (int i = 0; i < M; i++) { //글입력
            String str = br.readLine();

            String[] cut = str.split(",");

            for (String s : cut) {
                if (keyward.contains(s)) {
                    keyward.remove(s);
                }
            }
            sb.append(keyward.size()).append("\n");

        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Question17219 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String,String> hash = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < N;i++) {
            String str = br.readLine();
            String[] cut = str.split(" ");

            hash.put(cut[0],cut[1]);
        }
        for (int i = 0 ; i < M;i++) {
            String str = br.readLine();

            if (hash.containsKey(str)) {
                sb.append(hash.get(str)).append("\n");
            }
        }
        System.out.println(sb);
    }
}

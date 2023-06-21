import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        HashSet<Integer> arr = new HashSet<>();

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < testCase;i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> result = new ArrayList<>(arr);
        Collections.sort(result);
        for (Integer s : result) {
            sb.append(s).append(" ");
        }
        System.out.println(sb);
    }
}

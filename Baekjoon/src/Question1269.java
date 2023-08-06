import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question1269 {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer> A = new HashMap<>();
        HashMap<Integer,Integer> B = new HashMap<>();
        int result = 0;

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a;i++) {
            int num = Integer.parseInt(st.nextToken());

            if (A.containsKey(num)) {
                A.put(num, A.get(num) + 1);
            }
            else {
                A.put(num, 1);
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < b;i++) {
            int num = Integer.parseInt(st.nextToken());

            if (B.containsKey(num)) {
                B.put(num,B.get(num) + 1);
            }
            else {
                B.put(num,1);
            }
        }
        //A - B
        for (Integer s : A.keySet()) {
            if (!B.containsKey(s)) {
                result += A.get(s);
            }
        }
        for (Integer s : B.keySet()) {
            if (!A.containsKey(s)) {
                result += B.get(s);
            }
        }
        System.out.println(result);
    }
}

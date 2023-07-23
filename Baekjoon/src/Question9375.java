import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase;i++) {
            int result = 1;
            HashMap<String,Integer> arr = new HashMap<>();

            int N = Integer.parseInt(br.readLine());

            while (N --> 0) {
                String str = br.readLine();
                String[] cut = str.split(" ");

                if (arr.containsKey(cut[1])) { //만약에 이미 존재하는것이라면
                    arr.put(cut[1], arr.get(cut[1]) + 1); //개수 value + 1추가
                }
                else { //존재하지 않는다면
                    arr.put(cut[1],1); //해시로 새로추가
                }
            }
            for (Integer s : arr.values()) { //values에 저장된 값 + 1하여
                result *= (s + 1);
            }
            sb.append(result - 1).append("\n"); //마지막은 경우의수 - 1을한다 -1은 아무것도입지않은경우
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Question10546 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            String str = br.readLine();
            if (hashMap.containsKey(str)) hashMap.put(str,hashMap.get(str) + 1);
            else hashMap.put(str,1);
        }
        for (int i = 0; i < testCase - 1; i++) {
            String str = br.readLine();
            if (hashMap.containsKey(str)) hashMap.put(str, (hashMap.get(str) + 1));
        }
        for (String s : hashMap.keySet()) {
            if ((hashMap.get(s) % 2) == 1) { //완주한사람이 짝수 = 모두완주 홀수 = 한명완주못함
                sb.append(s).append("\n");
            }
        }
        System.out.println(sb);
    }
}

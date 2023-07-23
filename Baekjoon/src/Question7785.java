import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Question7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<String,String> arr = new LinkedHashMap<>();

        for (int i = 0; i < testCase;i++) {
            String str = br.readLine();
            String[] cut = str.split(" ");

            //cut[0] = 이름 cut[1] = 출석여부
            if (arr.containsKey(cut[0])) { //해당직원이 이미있는데
                arr.remove(cut[0]);
            }
            else { //해당직원없는경우
                arr.put(cut[0],cut[1]);
            }
        }
        ArrayList<String> result = new ArrayList<>(arr.keySet());
        Collections.sort(result);
        for (int i = result.size()-1;i >= 0 ;i--) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}

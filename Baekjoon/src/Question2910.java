import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Question2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        LinkedHashMap<Integer,Integer> arr = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N;i++) {
           String str = br.readLine();
           String[] cut = str.split(" ");

           for (int j = 0; j < cut.length;j++) {
               if (Integer.parseInt(cut[j]) <= C) {//C보다 작거나같을때
                   if (arr.containsKey(Integer.parseInt(cut[j]))) { //넣은수가 이미존재
                       arr.put(Integer.parseInt(cut[j]),arr.get(Integer.parseInt(cut[j])) + 1); //개수 1개추가
                   }
                   else { //처음나오는경우
                       arr.put(Integer.parseInt(cut[j]),1);
                   }
               }
           }
          Set<Map.Entry<Integer,Integer>> entrySet = arr.entrySet(); //value값을 찾아 key를 출력해야하기 때문에 entry사용
           while (N --> 0) {
               for (Map.Entry<Integer,Integer> entry : entrySet) {
                   if (entry.getValue() == N) { //N과 value의 수가 같은것을 그 수만큼반복하여 출력
                       for (int j = 0; j < entry.getValue();j++) {
                           sb.append(entry.getKey()).append(" ");
                       }
                   }
               }
           }
            System.out.println(sb);
        }
    }
}

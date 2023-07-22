import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question20551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(br.readLine()); //미리배열에 넣고 솔트
        }
        Arrays.sort(arr); //배열을 정렬 후
        for (int i = 0 ; i < N;i++) {
            if (!hashMap.containsKey(arr[i])) { //값을 넣을때 중복을빼고 index만 가져오기 위함
                hashMap.put(arr[i],i);
            }
        }
        //중복제거단계
        for (int i = 0; i < M;i++) {
            int num = Integer.parseInt(br.readLine());

            if (hashMap.containsKey(num)) {
                sb.append(hashMap.get(num)).append("\n");
            }
            else {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}

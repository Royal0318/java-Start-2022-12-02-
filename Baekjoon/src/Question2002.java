import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Question2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int testCase = Integer.parseInt(br.readLine());

        HashMap<String,Integer> arr = new HashMap<>();

        for (int i = 0; i < testCase;i++) {
            arr.put(br.readLine(), i);
        }
        int[] rank = new int[testCase];
        for (int i = 0; i < testCase;i++) { //나온순서
            rank[i] = arr.get(br.readLine()); //value 에저장된 i값을 temp에 넣음
        }
        for (int i = 0; i < testCase - 1;i++) {
            for (int j = i + 1;j < testCase;j++) {
                if (rank[i] > rank[j]) {
                    result += 1;
                    break;
                }
            }
        }
        System.out.println(result);
        //기존에 번호는 0 ~ 4까지였는데 자신번호밑에 번호가있다는것은 추월했다는의미가된다!
    }
}

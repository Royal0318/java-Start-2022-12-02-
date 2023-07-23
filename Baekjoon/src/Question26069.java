import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Question26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int testCase = Integer.parseInt(br.readLine());

        HashSet<String> arr = new HashSet<>();

        arr.add("ChongChong");

        for (int i = 0; i < testCase;i++) {
            String str = br.readLine();
            String[] cut = str.split(" ");

            if (arr.contains(cut[0]) || arr.contains(cut[1])) { //첫번째 사람이
                arr.add(cut[1]);
                arr.add(cut[0]);
            }
        }
        System.out.println(arr.size());
    }
}

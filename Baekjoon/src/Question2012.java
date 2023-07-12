import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Question2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N;i++) {
           arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        long result = 0;
        for (int i = 0;i < N;i++) {
           result += Math.abs(arr.get(i) - (i + 1));
        }
        System.out.println(result);
    }
}

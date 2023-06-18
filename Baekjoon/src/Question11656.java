import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Question11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < str.length();i++) {
            String[] cut = str.split("", i + 1);
            arr.add(cut[i]);
        }
        Collections.sort(arr);
        for (String s : arr) {
            System.out.println(s);
        }
    }
}

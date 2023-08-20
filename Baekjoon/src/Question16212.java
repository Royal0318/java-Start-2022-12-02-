import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Question16212 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] cut = str.split(" ");
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0 ; i < N;i++) {
            arr.add(Integer.parseInt(cut[i]));
        }
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (Integer s : arr) {
            sb.append(s).append(" ");
        }
        System.out.println(sb);
    }
}

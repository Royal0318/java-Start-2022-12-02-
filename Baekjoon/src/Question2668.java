import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Question2668 {
    static int[] arr;
    static boolean[] check;
    static int N;
    static int temp;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        result = new ArrayList<>();
        arr = new int[N + 1];
        check = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; i++) {
            check[i] = true;
            temp = i;
            dfs(i);
            check[i] = false; //안되는경우 돌아가면서 초기화
        }
        Collections.sort(result); //정답출력
        System.out.println(result.size());
        for (int s : result) {
            System.out.println(s);
        }
    }

    public static void dfs(int a) {
        if (temp == arr[a]) {
            result.add(temp);
        }
        if (!check[arr[a]]) {
            check[arr[a]] = true;
            dfs(arr[a]);
            check[arr[a]] = false; //안되는경우 돌아가면서 초기화
        }
    }
}

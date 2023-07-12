import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Question1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean check = false;
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N;i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);

        //정렬후에 제일마지막에 위치한3개를 비교해서 가장큰길이가 나머지 2개의 변보다 크기가 작을경우에 성립!
        for (int i = (N - 1);i >= 2;i--) {
            if (arr.get(i) < (arr.get(i - 1) + arr.get(i - 2))) {
                System.out.println(arr.get(i) + arr.get(i - 1) + arr.get(i - 2));
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println(-1);
        }
    }
}

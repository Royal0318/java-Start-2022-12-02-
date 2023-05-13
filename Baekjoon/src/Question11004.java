import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        ArrayList<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        if (N >= 1 && N <= 1000000) {
            System.out.println(arr.get(A-1));
        } else if (N >= 1000001 && N <= 2000000) {
            System.out.println(arr.get(A-1));
        } else if (N >= 2000001 && N <= 3000000) {
            System.out.println(arr.get(A-1));
        } else if (N >= 3000001 && N <= 4000000) {
            System.out.println(arr.get(A-1));
        } else {
            System.out.println(arr.get(A-1));
        }
    }
    /*
    여러가지 방법이있다 퀵정렬,Arrays.sort,Collects.sort....
    나는 이방법을써봤는데 생각보다 느려서 다른방법도 해봐야겠다
     */
}

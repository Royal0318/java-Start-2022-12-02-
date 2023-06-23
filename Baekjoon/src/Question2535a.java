import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Question2535a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        String[][] arr = new String[testCase][3];
        int[] check = new int[testCase];
        for (int i = 0; i < testCase;i++) {
            String[] cut = br.readLine().split(" ");
            arr[i][0] = cut[0]; //국가번호
            arr[i][1] = cut[1]; //학생번호
            arr[i][2] = cut[2]; //점수
        }
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o2[2]) - Integer.parseInt(o1[2]);
            }
        });
        System.out.println(""+arr[0][0]+" "+arr[0][1]+"");
        System.out.println(""+arr[1][0]+" "+arr[1][1]+"");
        check[Integer.parseInt(arr[0][0])] += 1;
        check[Integer.parseInt(arr[1][0])] += 1;
        for (int i = 2;i < testCase;i++) {
            if ( check[Integer.parseInt(arr[i][0])] < 2) {
                System.out.println(""+arr[i][0]+" "+arr[i][1]+"");
                break;
            }
        }
    }
}

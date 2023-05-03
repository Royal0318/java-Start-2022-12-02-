import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question14492 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        int result = 0;
        int[][] arr = new int[testCase][testCase];
        int[][] arr2 = new int[testCase][testCase];

        for (int i = 0; i < testCase; i++) { //arr행렬
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < testCase; i++) { //arr2행렬
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //token을쓰면 시간단축에 좋다
        for (int i = 0; i < testCase; i++) {
            for (int j = 0; j < testCase; j++) {
                for (int k = 0; k < testCase; k++) {
                    if (arr[i][k] * arr2[k][j] == 1) {
                        //값을구할때 arr과 arr2의 곱이 1이나오면 그 행렬에 들어가는값은 1이되므로 다른건 계산할필요없이 break시킨다
                        result += 1;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
        /*
        3X3 부울행렬 구하는 방법은 (0,0)이 (0,0),(1,0),(2,0)을 계산후
        (0,1)이 (0,0),(1,0),(2,0) (0,2)이 (0,0),(1,0),(2,0) 를계산
        (1,0)이 (0,0),(1,0),(2,0) ....계속실행한다
         */
    }
}

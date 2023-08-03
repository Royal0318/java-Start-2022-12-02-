import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10157 {
    static int[] X = {-1,0,1,0};
    static int[] Y = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int findNumber = Integer.parseInt(br.readLine());
        int[][] arr = new int[R][C];

        arr[0][0] = 1;

        int x = 0;
        int y = 0;
        int temp = 0;

        while (true) {
            if (arr[x][y] == findNumber) {
                System.out.println(""+(x + 1)+" "+(y + 1)+"");
                return;
            }
            if (arr[x][y] == (R * C)) {
                System.out.println(0);
                return;
            }
            int one = x + X[temp];
            int two = y + Y[temp];

            //범위를 벗어나지 않는값 내에서
            if (one >= 0 && two >= 0 && one < R && two < C && arr[one][two] == 0) {
                arr[one][two] = arr[x][y] + 1;
                //새로운 arr은 전에 있던 좌표arr[x][y]의 값 + 1을 추가
                x = one;
                y = two;
            }
            else {
                temp = (temp + 1) % 4;
                //좌표 4칸 temp값
            }
        }
    }
}

import java.util.Scanner;

public class Question2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        int[][] arr = new int[15][15];

        for (int i = 0; i < 15;i++) {
            arr[i][1] = 1; //세로는 ?층1은 모두 1명만 산다
            arr[0][i] = i; //가로는 0층의 가로인데 i호라면 i호 인원수만큼 살기때문에 i로 함
        }
        for (int i = 1; i < 15;i++) {
            for (int j = 1; j < 15;j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]);
            }
        }
        //각각 사람수를 미리 배열값에 넣어논다
        for (int i = 0; i < testCase;i++) {
            int one = sc.nextInt();
            int two = sc.nextInt();
            System.out.println(""+arr[one][two]+"");
        }
    }
}

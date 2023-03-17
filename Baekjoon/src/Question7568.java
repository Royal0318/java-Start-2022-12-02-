import java.util.Scanner;

public class Question7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                //자신과같은것은 비교하지않으므로 continue문으로 패스한다
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    //그 이후 하나를 고정시키고 자기보다 둘다큰것은 rank를올린다
                    rank += 1;
                }
            }
            System.out.println("" + rank + "");
        }
    }
}

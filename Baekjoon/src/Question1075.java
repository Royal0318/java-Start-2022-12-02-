import java.util.Scanner;
public class Question1075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[] arr = new int[45];
        //지문을 확인하면 n의 결과값이 1000까지 제한되어있다 즉 n이 45라면 1035이므로 초과 그러므로 n은최대 44까지 가능하다
        for (int j = 0; j < arr.length; j++) {
            arr[j] = (((j+1) * ((j+1) + 1)) / 2);
        }
        //각 배열값에 수를 저장한다 위식말고 등차수열로도 가능하다
        for (int i = 0; i < testCase;i++) {
            int n = sc.nextInt();
            int check = 0;
            for (int j = 0; j < 45; j++) {
                for (int k = 0; k < 45; k++) {
                    for (int y = 0; y < 45; y++) {
                        if ((arr[j] + arr[k] + arr[y]) == n) {
                            check = 1;
                            break;
                        }
                    }
                }
            }
            //3중포문을통해 모든 경우의수를 구한다
            System.out.println(check);
        }
    }
}

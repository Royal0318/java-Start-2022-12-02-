import java.io.*;

public class Question3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 9;
        int[] arr = new int[n];
        int[] check = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = (i+1); j < n; j++) {
                if ((sum - (arr[i] + arr[j]) == 100)) {
                    check[i] = 1;
                    check[j] = 1;
                    for (int k = 0; k < n; k++) {
                        if (check[k] == 0) {
                            System.out.println(""+arr[k]+"");
                        }
                    }
                }
            }
        }
        /*
        해설 : 총 9개의 입력을 받는다 그렇다면 9개의 수를 모두더해 나머지 2개만 골라내면된다
        그렇기 때문에 for문을 이용하여 브루드포스 알고리즘을사용했다
        나머지 2개를 고르기 위해 한 숫자씩 고정시켜 빼보았다
        예를들면 arr[0] = 7 arr[1] = 8 arr[2] = 10 arr[3] = 13 일때
        arr[0]을 고정시키고 arr[1]부터 쭉빼보면서 if문 (100이성립하는가?)를 판단하여
        100이면 해당 배열값에 check[i] = 1을부여해 출력할때 해당값은출력되지 않도록 하였다
         */
    }
}

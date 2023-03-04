import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(br.readLine());
        int[] arr = new int[index];
        int sum = 0;

        for (int i = 0; i < index; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            //만약 arr[i]가 0이라면 뒤에있는값을 보고 판단한다 만약에 뒤에있는값이 0이라면 그 다음으로 넘어가서 판단하고 0이 아니라면 뒤의값을 0을 만들어준다
            if (arr[i] == 0) {
                for (int j = i; j >= 0;j--) {
                    //for문을 이용해 i부터 0까지 역으로 for문을 돌린다 만약 arr[j]가 0이라면 그뒤로가고 아니라면 그값을 0으로 만들고 break를한다
                    if (arr[j] != 0) {
                        arr[j] = 0;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < index;i++) {
            sum += arr[i];
        }
        System.out.println(""+sum+"");
    }
}

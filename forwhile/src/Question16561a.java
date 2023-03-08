import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question16561a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 1;
        int count = 2;
        for (int i = 9;i <n;i+=3) {
           sum += count;
            count += 1;
        }
        System.out.println(""+sum+"");
        //9인경우 1가지 12인경우 3가지 15인경우 6가지이면 등차수열로 처음에 2 다음에 3 그다음에 4 1씩증가한다
    }
}

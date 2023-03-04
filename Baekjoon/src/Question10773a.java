import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Question10773a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int top = -1;

        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[K];

        for(int i = 0; i < K; i++) {
            System.out.println(""+top+"");
            int number = Integer.parseInt(br.readLine());
            //미리 배열값에 넣지 않고 그값이 0인가 0이아닌가를 판단하여 0이 아니라면 배열값에 할당한다
            /*
            1 ---> 0이 아니기 때문에 top값은 0이되며 arr[0]에 1이 추가
            3 ---> 0이 아니기 때문에 top값은 1이되며 arr[1]에 3이 추가
            7 ---> 0이 아니기 때문에 top값은 2이되며 arr[2]에 7이 추가
            4 ---> 0이 아니기 때문에 top값은 3이되며 arr[3]에 4이 추가
            0 ---> 0이기 때문에 top값은 2가 되며 배열값은 추가 안됨
            0 ---> 0이기 때문에 top값은 1가 되며 배열값은 추가 안됨
            7 ---> 0이 아니기 때문에 top값은 2가되며 arr[2]가 7 --> 4로 변경
            0 ---> 0이기 때문에 top값은 1이 되며 배열값은 추가 안됨
            0 ---> 0이기 때문에 top값은 0이 되며 배열값은 추가 안됨
            6 ---> 0이 아니기 때문에 top값은 1가되며 arr[1]가 3 --> 6으로 변경
            최종결론
            arr[0] = 1
            arr[1] = 6
            arr[2] = 4
            arr[3] = 4
            까지 생성되었으며 top값은 1로 마무리 되었기 때문에 arr[0 ~ 1]까지만 실행하면
            출력은 1 6 = 7이 나온다

             */
            if (number == 0) {
                top--;
            }
            else {
                top++;
                arr[top] = number;
            }
        }
        int sum = 0;
        for (int i = 0; i <= top; i++) {
            sum += arr[i];
            System.out.println(""+arr[i]+"");
        }
        System.out.println(sum);

    }
}

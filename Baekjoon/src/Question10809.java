
import java.util.Scanner;

public class Question10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];
        //a ~ z까지 총 26개 이기때문에 26으로 설정

        for (int i = 0 ; i < 26;i++) {
            arr[i] = -1;
            //처음에 모든 값을 -1로 한다 -1로하는이유는 입력한 String에 존재하지 않는경우 -1을 출력하기 때문이다
        }
        String str = sc.next();

        for (int i = 0; i < str.length();i++) {
            int index = str.charAt(i) - 97;
            /*
            index에 -97 or "a" 를 해주는이유는 아스키 코드 때문이다
            a 는 10진수로 97 이라는 값에 대응된다
            만약 b 라는 문자가 ch 에 담겨있을 경우 b - 'a' 또는 b - 97 을 하면 1 이 되고, arr[1] 은 문자 b를 가리키는 것을 의미한다.
            시작이 0에서 시작하기 때문임
             */
            if (arr[index] == -1) {
                arr[index] = i;
            }
            //만약 arr[index] == - 1이라는 뜻은 한번도 중복되지 않았다는 의미이므로 arr[index]가 -1이였다가 i값으로 변경됨
        }
        for (int s : arr) {
            System.out.println(s);
        }
    }
}

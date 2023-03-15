import java.util.Scanner;
public class Question2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        for (int i = 1; i < n; i++) {
            int sum = 0;
            int length = 0;
            //i값이 입력한값보다 크면 안됨

            String str = "" + i + "";
            length = str.length();
            //i값을 chatAt를통해 길이를 추출하여 length변수에 담는다

            for (int j = 0; j < length; j++) {
                sum += str.charAt(j) - '0';
            }
            //각자릿수의 숫자들을 sum변수에 담음 '0'이없으면 아스키코드를 읽기때문에 조심하자
            if ((i + sum) == n) {
                answer = i;
                break;
            }
        }
        //i와 sum값이 n과같은경우 정답변수에 i값을 넣고 for문탈출
        System.out.println(answer);
    }
}

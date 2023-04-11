import java.util.Scanner;
import java.util.Stack;

public class Question1935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double two = 0;
        double one = 0;
        //결과식이 double타입이기 때문에 변수도 더블형으로 선언

        Stack<Double> stack = new Stack<>();

        int testCase = sc.nextInt();

        double[] arr = new double[testCase];
        //알파벳을 arr에 저장하는형태

        String str = sc.next();

        for (int i = 0; i < testCase; i++) {
            arr[i] = sc.nextInt();
            //arr[0] = 1이라고 가정했을 시 나중에 str.chat(i)가 A가 나온경우 - 'A'로 변환하면 0이 나온다 그렇다는것은 arr[0] = 1과 같기때문
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*') {
                two = stack.pop();
                one = stack.pop();
                stack.push(one * two);
            } else if (str.charAt(i) == '+') {
                two = stack.pop();
                one = stack.pop();
                stack.push(one + two);
            } else if (str.charAt(i) == '/') {
                two = stack.pop();
                one = stack.pop();
                stack.push(one / two);
            } else if (str.charAt(i) == '-') {
                two = stack.pop();
                one = stack.pop();
                stack.push(one - two);
            } else if (str.charAt(i) >= 'A' || str.charAt(i) <= 'Z') {
                stack.push(arr[str.charAt(i) - 'A']);
                //만약에 A가나온경우 알파벳A의 아스키코드 숫자는 65이다 -'A'를하여 변환하면 결과값은 0(65 -65) 이 되지만 push를할때 arr[str.chatat - 'A']를하게되면 arr[0]이되고 그값은 1이된다
            }
        }
        double result = stack.pop();
        System.out.printf("%.2f",result);
    }
}

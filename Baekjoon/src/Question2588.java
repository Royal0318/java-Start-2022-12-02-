import java.io.*;

public class Question2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int one = Integer.parseInt(br.readLine());
        //1번째 값은 int로 받는다
        String two = br.readLine();
        //2번째 값은 String으로 받는다 one의 3자리를 각각의 숫자 하나하나씩곱해야 하기 때문이다
        int two1 = two.charAt(0) - '0';
        // int two1 = two.charAt(0); 일반적으로 이렇게 하면 아스키 코드에 따라서 다른값이 나온다 그러므로
        // int two1 = two.charAt(0) - '0'; 뒤에 - '0'을 적어야 아스키코드에서 정수값으로 변환이된다
        int two2 = two.charAt(1) - '0';
        int two3 = two.charAt(2) - '0';
        System.out.println(""+(one * (two3))+"");
        System.out.println(""+(one * (two2))+"");
        System.out.println(""+(one * (two1))+"");
        System.out.println(""+((one * (two3)) + (one * (two2) * 10) + (one * (two1) * 100))+"");

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Question10826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        이 문제는 입력에 따라 수가 무한정 커지므로 일반적인 int와 long으로는 구할 수 없다 그러므로 다른 방법이 필요하다
        이 문제는 BigInteger를 사용하여 푸는 문제이다

        BigInteger는 무한대 정수이므로 무한정 큰 수를 구하기 위해서는 꼭 써야한다
        기본적으로 클래스 변수는 3가지고 있다 Zero,ONE,TEN
        사칙연산 같은경우
        add(Biginteger val)        // 더하기
        subtract(Biginteger val)  // 빼기
        mutiply(Biginteger val)   // 곱하기
        devide(Biginteger val)    // 나누기
        equals(Object x)           // 값이 같은지 비교
        위 5가지 방법이 존재한다
         */
        int num = Integer.parseInt(br.readLine());
        BigInteger[] arr = new BigInteger[num + 1];
        //BigInteger배열 선언
       for (int i = 0;i < arr.length;i++) {
           if (i == 0) {
               arr[0] = BigInteger.ZERO;
           } else if (i == 1) {
               arr[1] = BigInteger.ONE;
           } else {
               arr[i] = arr[i-1].add(arr[i-2]);
           }
       }
        System.out.println(""+arr[num]+"");
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question25497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Stack<Character> stackL = new Stack<>(); //L과 R을 담는스택
        Stack<Character> stackS = new Stack<>(); //S와 K를 담는스택
        int result = 0; //정답
        /*
        이 문제에서 중요한것은 사전 기술 없이 본 기술을 사용했을 경우에는
        게임의 스크립트가 꼬여서 이후 사용하는 기술들이 정상적으로 발동되지 않는다 라는말이다 무슨말이냐면
        예시가 S12K2일경우 S는 stackS에 담길것이고 숫자 1과 2는 카운트된다
        그 다음에 k가 오기때문에 StackS가 pop되서 stack이 비어있다 그상태에서 2까지 입력시 전부 count되기 때문에 정답은 4가 나온다
        다른 예시를 보자

        1LKR1인경우를보자 1은 아무것도없는상태이기 때문에 체크된다
        L은 StackL에 쌓인다  하지만 K를넣은경우에 스택이 비어있는상태 이기 때문에 break된다
        왜 브레이크가 되냐면 L은 stackL에쌓인것이지 stackS에 쌓인것이 아니기 때문이다
        그러므로 그뒤에존재하는 R1도 쓸모가없어지기 때문에 1만 카운트되는것이다
         */
        String str = br.readLine();

        for (int i = 0; i < testCase;i++) {
            if (str.charAt(i) == 'L') {
                stackL.push(str.charAt(i));
            } else if (str.charAt(i) == 'S') {
                stackS.push(str.charAt(i));
                //L과 S는 push한다
            } else if (str.charAt(i) == 'R') {
                if (!stackL.empty()) { //비어있지 않은것이라면 L이 들어있는것이기때문에 서로 pop
                    result += 1;
                    stackL.pop();
                } else { //만약 비어있다면 R과 K는 올수없다
                    break;
                }
            } else if (str.charAt(i) == 'K') {
                if (!stackS.empty()) { //비어있지 않은것이라면 S가 들어있는것이기때문에 서로 pop
                    result += 1;
                    stackS.pop();
                } else {
                    break;
                }
            } else {
                result += 1;
            }
        }
        System.out.println(result);
    }
}

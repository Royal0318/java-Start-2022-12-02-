import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question11721a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int temp = str.length(); //전체 length저장
        for (int i = 0; i < str.length();i+= 10) {
            if ((i + 10)  <= str.length()) {
                System.out.println(str.substring(i,(i + 10)));
            } else {
                System.out.println(str.substring(i,temp));
            }
        }
        /*
        subString을 이용하는 방법이다 subString은 문자열을 자르는 방법인데
        시작지점,끝지점을 입력하여 자를 수 있는 간편한 문법이다
        i가 0에서 length까지 10의 배수로 증가한다
        처음에 0인상태에서 if문이 동작하여 10 <= length니까
        출력을 한번 실시한다 subString i = 0부터 10까지
        예를들어 전체 길이가 19라고 가정해보자 처음에 0부터 10까지 한번출력하고
        10 ~ 19까지 9개를 출력해야한다
        이러면 i는 10인상태에서 동작할것인데 i가 10이고 if문을 보면 i + 10이기 때문에
        else 문이 동작한다 그렇게하면 sub String (10에서 temp 마지막까지)출력을 하게된다
         */
    }
}

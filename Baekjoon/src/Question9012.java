import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question9012 {
    static Stack<String> sta = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            System.out.println(check(br));
        }
    }

    static String check(BufferedReader br) throws IOException {
        sta.clear();
        //한바퀴 돌때마다 스택을 초기화시켜준다
        String str = br.readLine();
        //최종적으로 스택이 0이되어야 올바른 조건이 성립된다

        for (int i = 0; i < str.length(); i++) {
            String a = "" + str.charAt(i) + "";
            int size = sta.size();

            if (size == 0) {
                //size가 0인상태에서 )가 나오는경우 에러가 발생하기 때문에 따로 if문을 만들어줘야한다
                if (a.equals(")")) {
                    return "NO";
                    //또 pop을하는경우 에러가 발생하기 때문에 이부분은 바로 리턴을 보낸다
                } else {
                    sta.push("(");
                    //0인상태에서는 (나올경우 푸쉬는가능
                }
            } else {
                if (a.equals(")")) {
                    //0이 아닌상태는 자유롭게 푸쉬와 팝이가능
                    sta.pop();
                } else {
                    sta.push("(");
                }
            }
        }
        if (sta.size() == 0) {
            return "YES";
        } else {
            return "NO";
        }
        //for문에서 탈출시 size가0이되어야 조건이 성립하므로 0인경우 YES 아닌경우 NO를 리턴
    }
}

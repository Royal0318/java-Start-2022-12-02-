import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question16120 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < str.length();i++) {
            if (str.charAt(i) == 'P') { //스택에서 p가나오면  push
                stack.push(str.charAt(i));
            }
            else { //p가아니고 A인경우
                if (stack.size() >= 2 && i < str.length() - 1 && str.charAt(i + 1) == 'P') { //p가2개이상이며 다음이p인경우
                    //length - 1을해야하는이유 i가끝까지 갈경우 i + 1에서 indexout오류발생 반레 : PPPAPPAPPPA
                    //그렇기때문에 str.charAt(i + 1보다 먼저작성해야함)
                    stack.pop();
                    stack.pop();
                }
                else { //그렇지않은경우 맞지않음
                    System.out.println("NP");
                    return;
                }
            }
        }
        if (stack.size() == 1) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}

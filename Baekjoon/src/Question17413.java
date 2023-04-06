import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();

        boolean check = false;

        for (int i = 0; i < str.length();i++) {

           if (str.charAt(i) == '<') {
               check = true; //체크시작

               while (!stack.empty()) { //<가시작되었을때 비어있지 않은경우 즉 다른문자열이 존재하는경우
                   System.out.print(stack.pop()); //pop하면 거꾸로 출력됨
               }
               System.out.print(str.charAt(i)); //<를 출력

           } else if (str.charAt(i) == '>') { //>가 나왔을경우 수집종료
               check = false; //true를 false로 바꿈
               System.out.print(str.charAt(i)); //>를출력함

           } else if (check) { //true즉 <>안에 존재하는경우는 그대로 출력한다 (check = true)
               System.out.print(str.charAt(i));

           } else {
               if (str.charAt(i) == ' ') { //만약 안에 존재하지 않는데 false인 공백이라면
                   while (!stack.empty()) { //비어있지않은경우 pop하며 거꾸로출력
                       System.out.print(stack.pop());
                   }
                   System.out.print(str.charAt(i));
               } else {
                   stack.push(str.charAt(i));
               }
           }
        }
        while (!stack.empty()) {
            //공백후 마지막에 문자열이 주어졌을때 그것을 출력하기 위해서 다시 pop해 출력함
            System.out.print(stack.pop());
        }
    }
}

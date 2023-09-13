import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>(); //스택선언
        StringBuilder sb = new StringBuilder(); //폭발하고 남은문자열을 합치기위한 선언

        String str = br.readLine(); //문자열
        String boomStr = br.readLine(); //폭발 문자열 기준

        for (int i = 0 ; i < str.length();i++) {
            boolean check = false;
            stack.push(str.charAt(i)); //순서대로 스택에 저장

            if (stack.size() >= boomStr.length()) {
                /*
                 스택에 저장된길이가 비교문자열 기준과 같아지거나 커진경우 비교를 시작한다
                 스택에 저장된 문자열과 비교문자열이 서로 다른경우 추가해도 가능하지만 같은경우 폭발시키며
                 stack.size가 2이상이 되어 3부터 넘어갈경우 1개의 스택이 쌓일때마다 비교문자열과 비교를 시작한다
                 비교대상인 문자열의 시작은 length 0부터 시작하며 스택같은경우 stack.size() - boomStr.length() + j로 시작한다 (j는 for문을 돌수록 비교index 크기를 높여주기 위함)
                 즉 stack.size가 7이라고 가정했을때 2개씩 비교해야하므로 7 - 2 = 5 시작점은 5가되며 스택은 5부터시작 비교대상 문자열은 j값이 0에서 시작하므로
                 0에서 시작한다 즉 5와 0에서 비교를 시작하여 비교대상 문자열 길이만큼 for문을 돌기 시작한다
                 */

                for (int j = 0 ; j < boomStr.length();j++) {
                    if (stack.get(stack.size() - boomStr.length() + j) != boomStr.charAt(j)) { //stack에 저장된 문자열과 다른경우 저장가능
                        check = true;
                        break;
                    }
                }
                if (!check) { //서로문자열이 달라서 추가가 가능한경우
                    for (int j = 0 ; j < boomStr.length();j++) { //비교문자열 길이만큼 폭발시킴
                        stack.pop();
                    }
                }
            }
        }
        for (Character s : stack) sb.append(s); //스택에 남은 문자열 순차적으로 저장
        if (sb.length() != 0) {
            System.out.println(sb);
            return;
        }
        System.out.println("FRULA");
    }
}
/*
중요한것 : 스택의 비교 시작지점을 찾아야함
 */
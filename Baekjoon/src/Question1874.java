import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int max = 0;

        boolean check = false;
        int testCase = Integer.parseInt(br.readLine());

        int first = Integer.parseInt(br.readLine()); //첫번째숫자를입력
        max = first; //max변수에 넣어줌

        for (int i = 1; i <= first; i++) {
            stack.push(i);
            sb.append("+").append("\n");
        }
        //1번째는 무조건 수열에맞게 푸쉬해준다
        stack.pop();
        sb.append("-").append("\n");

        for (int i = 0; i < (testCase - 1); i++) { //나머지횟수(첫번째 횟수를 제외하고 입력받음)
            int num = Integer.parseInt(br.readLine());

            if (max < num) {
                for (int j = (max + 1); j <= num; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
                max = num;
                //만약 num이 max보다 클경우 max + 1부터 num까지 푸쉬하며 입력한 num은 pop해준다 그리고 num값을 max에 할당
            } else {
                //만약 num이 max보다 작은경우에는
                if (num == stack.pop()) {
                    //pop한값이 num와 같은경우에 -를 출력한다
                    sb.append("-").append("\n");
                } else {
                    //그 값이 같지않은경우에는 그 수열이없다는 뜻이므로 NO를 출력한다
                    check = true;
                }
            }
        }
        if (check) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
        /*
        예를들어 테스트케이스가 5 값 1 2 5 3 4 를 입력했다고 가정해보자
        가장처음에 오는것은 무조건 push지만 입력한 값은 마지막에 pop한다
        그러므로 1이생겼지만 다시 1이 pop된다 그래서 스택은 없다
        다음에 2를 입력했을경우 스택에 2가쌓이지만 다시 pop된다
        다음에 5를 입력한경우 3부터 5까지쌓인다 (3,4,5) 하지만 5는 pop하기 때문에
        스택에는 3,4가 쌓인다
        다음에 3을입력했는데 max값은 5다 max < num이 성립되지않기때문에
        else문으로 넘아간다 그런대 pop하는값은 4인데 num은 3이기때문에 check = true이기때문에
        출력은 No가 된다

        예를들어 테스트케이스가 8 값  4 3 6 8 7 5 2 1 를 입력했다고 가정해보자
        처음에max는 4이고 스택에 1 2 3 4가 쌓인다 하지만 4는 pop된다
        num = 3 max는4이기때문에 else문으로 이동 pop과 num과 일치하기때문에 스택에는 1 2만남는다
        num = 6인경우 max보다 크기 때문에 스택에는 5 6 이 쌓여 1 2 5 6이되며 6은 pop된다
        num = 8이기때문에 max보다 크다 스택에는 1 2 5 7 8 이되지만 8은 pop된다
        num = 7,5,2,1,같은경우 max보다 작고 pop하는경우 모두 일치하기 때문에 No가출력되지않고
        append로 합친 문자열들이 출력됨
         */
    }
}

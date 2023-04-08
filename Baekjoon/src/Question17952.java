import java.util.Scanner;
import java.util.Stack;

public class Question17952 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>(); //점수를 담는 스택
        Stack<Integer> timeStack = new Stack<>(); //시간을 담는 스택
        int totalScore = 0; //총 누적점수

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {

            int homework = sc.nextInt(); //숙제수 무조건1개

            if (homework == 1) { //만약 1개라면
                int score = sc.nextInt(); //숙제를 풀었을때 얻는 점수 입력받음

                stack.push(score); //점수를담는 stack에 push한다

                int leftTime = sc.nextInt(); //그숙제를 해결하는데 걸리는시간
                timeStack.push(leftTime-1); //새로운 숙제를 받자마자 시작하기때문에 leftTime -1분

                int value = timeStack.pop(); //바로 타임스택을 pop한다
                if (value == 0) { //만약 곧바로 0이되는경우
                    totalScore += stack.peek();
                    //stack에 존재하는 점수를 스코어변수에 담음
                    stack.pop(); //timestack도 사라졌으니 같이 pop된다
                } else {
                    //0이 아닌경우 다시 push하여 추가
                    timeStack.push(value);
                }
            } else { //만약에 입력이 0이라면은
                if (!stack.empty() && !timeStack.empty()) { //스택이 비어있지 않은경우
                    int value = timeStack.pop();
                    value -= 1;
                    //비어있지 않은경우 가장최근 타임을 1분차감한다

                    if (value == 0) { //만약 최상단에 위치한 숙제가 0분 즉 완료했다면
                        totalScore += stack.peek(); //stack최상단에 위치하는 점수를 변수에담음
                        stack.pop();
                        //timestack이 pop되었기 때문이 같이해줌
                    } else {
                        timeStack.push(value);
                    }
                }
            }
        }
        System.out.println(totalScore);
    }
}

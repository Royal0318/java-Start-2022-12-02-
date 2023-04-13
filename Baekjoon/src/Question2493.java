import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Question2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> top = new Stack<>();
        Stack<Integer> index = new Stack<>();

        for (int i = 1; i <= testCase;i++) {
            int hight = (Integer.parseInt(st.nextToken()));

            while (true) {
                if (!top.empty()) { //스택이 비어있지 않은경우 비교대상
                    if (top.peek() < hight) {
                        top.pop();
                        index.pop();
                    } else {
                        System.out.print(""+index.peek()+" ");
                        top.push(hight);
                        index.push(i);
                        break;
                    }
                    /*
                    hight값이 더 큰경우 스택을pop한다 hight값이 더 크기 때문에 다음에 스택이 와도
                    가장밑에있는 스택은 도달하지 않기 때문이다
                     */
                } else { //스택이 비어있는경우
                    System.out.print("0 ");
                    top.push(hight);
                    index.push(i);
                    break;
                }
            }
        }
    }
}
/*
시뮬레이션을 돌려보자  (6 9 5 7 4)
i = 1                              i = 2                                       i = 3                                   i = 4                                    i = 5
hight = 6                      hight = 9                                     hight = 5                               hight = 7                                 hight = 4
하지만 스택이 비어있기             top.peek : 6                                  top.peek : 9                            top.peek : 5                              top.peek : 7
때문에 0을출력하고                hight가 더 크기 때문에 hight,top                 hight가 더 작기 때문에                     hight가 더 크기 때문에                       top이 더 크기 때문에
i와 hight를 push                두개의 스택을 모두 비움                           index : 2를 출력 후                      가장위에를 pop하고 다시 while을 돔             index : 4출력하고 push
                               그리고 다시 while을 돌면 맨밑에else로              i = 3과 hight 5 를 push                 그러면   top : 9  index : 2 이기 때문에
top : 6                        도달하기 때문에 0을출력하고 i = 2와 9를 push                                               다시 작아진다 그러면 index : 2를 출력하고 푸쉬
index : 1                      top : 9  index : 2                         top : 5  index : 3                         top : 7  index : 4                          top : 4  index : 5
                                                                          top : 9  index : 2                         top : 9  index : 2                          top : 7  index : 4
                                                                                                                                                                 top : 9  index : 2

  출 : 0                             출 : 0 0                                      출 : 0 0 2                            출 0 0 2 2                               출 : 0 0 2 2 4

 */

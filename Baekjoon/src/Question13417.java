import java.util.*;
public class Question13417 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = sc.nextInt();
        for (int i = 0; i < testCase;i++) {
            ArrayList<String> arr = new ArrayList<>();
            Queue<String> queue = new LinkedList<>();

            int inputNumber = sc.nextInt();
            for (int j = 0; j < inputNumber;j++) {
                st = new StringTokenizer(sc.next());
                queue.offer(st.nextToken()); //Tokenizer로 문자열을 잘라서 큐에 넣음
            }
            arr.add(queue.poll()); //1번째 값은 first로 비교해야하기 때문에 미리 arr에넣는다

            String first = arr.get(0);
            char firstChar = first.charAt(0); //char끼리 비교하기위해 문자열을 char형으로 변환


            for (int j = 0; j < (inputNumber - 1);j++) { //1개는 이미 pop하였으므로 전체 number - 1번 돌음
                String second = queue.poll(); //pop하면서 2번째문자열저장
                char secondChar = second.charAt(0); //char형으로 변환한다

                if (firstChar >= secondChar) { //그래서 first가 더 먼저오는 문자열인경우는 숫자로 변환했을때 first가 더크다 그렇기 때문에 index 0자리에 넣는다
                    arr.add(0, second);
                    firstChar = secondChar; //다음 비교를위해 문자열 새로갱신
                } else {
                    arr.add(second); //반대인경우 add를 해준다 즉 맨오른쪽에 넣는다는뜻
                }
            }
            for (String b : arr) {
                sb.append(b);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

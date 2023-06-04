import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        String[] arr = new String[testCase];
        int[] strike = new int[testCase];
        int[] ball = new int[testCase];
        int result = 0;//정답개수

        for (int i = 0; i < testCase;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken(); //처음에 영수가외치는 번호
            strike[i] = Integer.parseInt(st.nextToken()); //각케이스마다 스트라이크개수
            ball[i] = Integer.parseInt(st.nextToken()); //각 케이스마다 볼의개수
        }
        for (int i = 1 ; i< 10;i++) {
            for (int j = 1 ; j< 10;j++) {
                if (i == j) { //continue문을 통해 숫자중복은 pass한다
                    continue;
                }
                for (int k = 1 ; k< 10;k++) {
                    if (i == k || j == k) {
                        continue;
                    }//3자리의 중복을 모두 피한경우에 스트라이크 볼 체크
                    boolean check = true; //해당번호가 주어진 케이스의 스트라이크와 볼이 같은지확인
                    for (int q = 0; q < testCase;q++) { //테스트 케이스만큼 돈다
                        int strikeNum = 0; //스트라이크 개수
                        int ballNum = 0; //볼의개수
                        if (arr[q].charAt(0) - '0' == i) { //스트라이크 체크
                            strikeNum += 1;
                        }
                        if (arr[q].charAt(1) - '0' == j) {
                            strikeNum += 1;
                        }
                        if (arr[q].charAt(2) - '0' == k) {
                            strikeNum += 1;
                        }
                        //스트라이크는 각각의 숫자의 자리수만 맞으면된다
                        if (arr[q].charAt(0) - '0' == j || arr[q].charAt(0) - '0' == k) { //볼체크
                            ballNum += 1;
                        }
                        if (arr[q].charAt(1) - '0' == i || arr[q].charAt(1) - '0' == k) { //볼체크
                            ballNum += 1;
                        }
                        if (arr[q].charAt(2) - '0' == i || arr[q].charAt(2) - '0' == j) { //볼체크
                            ballNum += 1;
                        }
                        //볼같은경우 자신의 자리를 제외한나머지의 자리수를 모두 체크해야함
                        if (strike[q] != strikeNum || ball[q] != ballNum) { //둘중하나라도 안맞으면 false하고 탈출
                            check = false;
                            break;
                        }
                    }
                    if (check) { //만약에 둘다맞는경우 정답 + 1
                        result += 1;
                    }
                }
            }
        }
        System.out.println(result);
    }
}

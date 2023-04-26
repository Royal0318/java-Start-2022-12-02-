import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken()); //양동이 개수
        int distance = Integer.parseInt(st.nextToken()); //곰이 양쪽으로 닿는거리

        int temp = 0;
        int max = 0;

        int[] arr = new int[1000001]; //거리가 100만까지 존재하기때문

        for (int i = 0; i < testCase;i++) {
            st = new StringTokenizer(br.readLine());
            int gi = Integer.parseInt(st.nextToken()); //얼음무게
            int xi = Integer.parseInt(st.nextToken()); //떨어진 거리
            arr[xi] = gi; //거리를 배열에 담아 그 거리에 도달하면 얼음무게를 계산
        }
        while (true) { //while을이용하여 각각의 값을 비교하는방법 구상하자
            //양끝까지 거리는 2k + 1
            for (int i = 0; i <= ((distance * 2) + 1) && i <= 1000000; i++) { //곰의 오른쪽 거리만큼이며 한계가 100만까지
                temp += arr[i]; //배열에 저장했던 얼음무게를 result에 저장
                System.out.println(temp);
            }
            //0부터 distance가 3이라면 i < 7까지
        }
    }
}

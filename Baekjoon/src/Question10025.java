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

        int[] arr = new int[1000001]; //거리가 100만까지 존재하기때문

        for (int i = 0; i < testCase;i++) {
            st = new StringTokenizer(br.readLine());
            int gi = Integer.parseInt(st.nextToken()); //얼음무게
            int xi = Integer.parseInt(st.nextToken()); //떨어진 거리
            arr[xi] = gi; //거리를 배열에 담아 그 거리에 도달하면 얼음무게를 계산
        }

        int temp = ((distance * 2) + 1); //엘버트가 닿을수있는 거리의합
        int max = 0;
        int sum = 0;

        for (int i = 0;i <= 1000000;i++) { // 1부터 100만까지 탐색
            if (i >= temp) { //i가 늘어나면서 앞에꺼는 하나씩삭제해간다 //즉 범위는 변하지 않고 그대로 움직이되 위치만 바뀌는것
                sum -= arr[i - temp];
            }
            sum += arr[i]; //
            if (max < sum) { //sum이 클때마다 계속 max값이 변함
                max = sum;
            }
        }
        System.out.println(max);
        /*
        예를들어 i가 7에 도달했을때 temp가 7이라면은 슬라이드를 움직일때이다 i >= temp 즉 7 >=7 에 만족하므로 sum -= arr[i - temp] 즉 sum -= arr[7 - 7] 0이 되므로
        arr[0]부터 삭제하고 if문밑에 sum += arr[i]번을 추가하면서 뒤에는 삭제 앞에서는 추가 하는 방식으로 진행됨
         */
    }
}

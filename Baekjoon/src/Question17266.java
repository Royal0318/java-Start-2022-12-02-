import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question17266 {
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());//굴다리의 총 갯수

        int M = Integer.parseInt(br.readLine());//가로등 갯수

        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M;i++) {
            arr[i] = Integer.parseInt(st.nextToken()); //굴다리에 가로등 설치위치
        }

        int result = 0; //정답
        int start = 0; //start지점
        int end = N; //끝지점

        while (start <= end) { //시작지점이 끝지점에 도달하였을때 탈출조건
            int high = ((start + end) / 2); //중간지점이면서 가로등의 높이

            if (check(high)) { //true
                result = high; //최소높이를 구하라고하였기때문에 result에저장
                end = high - 1; //높이를 줄여서 다시 탐색
            }
            else { //false라는것은 빚이 전체적으로 닿지않는다는 뜻이므로 도달하기위해서 가로등의 높이를 늘린다
                start = high + 1;
            }
        }
        System.out.println(result); //정답출력
    }
    public static boolean check (int high) {
        int prev = 0; //가로등의 마지막 빚의 범위값

        for (int i = 0; i < arr.length;i++) {
            if ((arr[i] - high) <= prev) { //가로등 설치위치 - 높이 <= 마지막으로 비춘 사거리
                prev = arr[i] + high; //arr[i]에 위치하는 가로등이 비출수있는범위
            } else { //그렇지않으면 도달하지못하므로 false를 하여 위치를높인다
                return false;
            }
        }
        //마지막 위치도 확인 (굴다리 총 개수 - 해당 위치의 최대 빚 사거리)
        return N - prev <= 0; //그값이 0보다 작아야 범위안에 들어온다는 뜻이다
    }
}
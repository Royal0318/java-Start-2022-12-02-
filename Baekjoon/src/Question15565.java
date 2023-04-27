import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        ArrayList<Integer> lian = new ArrayList<>(); //라이언 위치저장

        st = new StringTokenizer(br.readLine());
        for (int i = 0;i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] == 1) { //만약에 라이언 (1번이라면) 이 존재한다면
                lian.add(i + 1); //라이언이 저장된 위치를 저장
            }
        }
        if (lian.size() < K) { //라이언 개수가 K보다 작은경우 계산불가이므로 종료
            System.out.println(-1);
        } else { //그렇지 않은경우 계산시작
            int start = 0; //시작점
            int end = (K - 1); //끝지점

            int min = Integer.MAX_VALUE; //최고값을 지정하고 작은수존재시 바꿈
            while (end < lian.size()) { //end포인터지점은 Arraylist index - 1까지만반복
                int sum = (lian.get(end) - lian.get(start) + 1);
                /*
                sum은 시작지점과 끝지점 + 1이다 즉 무슨말이냐면 라이언이 1번이니까 1이 나올때마다
                count를 하는데 그 count가 K랑같아질때 count의 인덱스 번호를 출력한다
                1번 라이언의 위치만 따로 Arraylist에 담아두고선 끝지점 - 시작지점 + 1을하면 같은것이기때문에
                이 방법을 사용 한번할때마다 슬라이딩윈도우 + 투포인터를 이용하여 시작지점과 끝지점을 1칸씩 이동시킴
                 */
                min = Math.min(min, sum);
                //가장작은값 고름
                start += 1;
                end += 1;
                //1회 반복시 다음위치로 이동시켜 다시 계산
            }
            System.out.println(min);
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //맵 칸수
        int M = Integer.parseInt(st.nextToken()); //바구니 크기

        int result = 0; //정답
        int start = 1; //시작부분
        int end = M; //끝부분
        int apple = Integer.parseInt(br.readLine());//사과개수

        if (M == 1) {
            for (int i = 0 ; i < apple;i++) {
                int J = Integer.parseInt(br.readLine());

                if ((J - start) > 0) { //바구니오른쪽
                    result += (J - start);
                }
                else if ((J - start < 0)) { //바구니왼쪽
                    result += (start - J);
                }
                start = J;
            }
        }
        else {
            for (int i = 0; i < apple; i++) {
                int J = Integer.parseInt(br.readLine()); //사과가떨어지는위치

                if ((J - start) < 0 && (J - end) < 0) { //사과위치 - 시작or끝이 음수 --> 바구니보다 왼쪽
                    result += start - J;
                    start = J; //시작위치변경
                    end = ((start + M) - 1); //끝위치변경
                } else if ((J - start) > 0 && (J - end) > 0) { //바구니보다 오른쪽
                    result += J - end;
                    end = J;
                    start = ((end - M) + 1);
                }
            }
        }
        System.out.println(result);
    }
}

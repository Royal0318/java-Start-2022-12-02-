import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1049 {
    static int pieceTotalPrice;
    static int piece_SetTotalPrice;
    static int setTotalPrice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //끊어진개수
        int M = Integer.parseInt(st.nextToken()); //테스트케이스개수

        st = new StringTokenizer(br.readLine());
        int setMin = Integer.parseInt(st.nextToken());
        int pieceMin = Integer.parseInt(st.nextToken());

        for (int i = 1; i < M; i++) { //M이 2이상시
            st = new StringTokenizer(br.readLine());
            int setPrice = Integer.parseInt(st.nextToken());
            int piecePrice = Integer.parseInt(st.nextToken());

            if (setMin > setPrice) setMin = setPrice;
            if (pieceMin > piecePrice) pieceMin = piecePrice;
        }
        pieceTotalPrice = (pieceMin * N); //낱개만사는경우
        if ((N % 6) == 0) {
            piece_SetTotalPrice = ((N / 6) * setMin);//세트 + 낱개로사는경우
        } else {
            piece_SetTotalPrice = ((N / 6 + 1) * setMin);
        }
        setTotalPrice = (((N / 6) * setMin) + (N - ((N / 6) * 6)) * pieceMin);//세트만사는경우
        int temp = Math.min(pieceTotalPrice, piece_SetTotalPrice);
        System.out.println(Math.min(temp, setTotalPrice));
    }
}

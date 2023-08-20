import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Question8979 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //국가의수
        int K = Integer.parseInt(st.nextToken()); //등수를 알고싶은 국가번호

        int[][] arr = new int[N][5]; //메달개수 3개

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] cut = str.split(" ");

            arr[i][0] = Integer.parseInt(cut[0]); //나라 번호
            arr[i][1] = Integer.parseInt(cut[1]); //금
            arr[i][2] = Integer.parseInt(cut[2]); //은
            arr[i][3] = Integer.parseInt(cut[3]); //동
        }

        if (N == 1) {
            System.out.println(1);
            return;
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[2] == o2[2]) {
                    return Integer.compare(o1[3], o2[3]); //o2 - o1으로 내림차순변경
                }
                return Integer.compare(o1[2], o2[2]);
            }
            else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int indexSave = 0;
        int rank = 1;
        for (int i = 0 ; i < N;i++) {
            if (arr[i][0] == K) {
                indexSave = i;
                break;
            }
        }
        for (int i = N-1;i >= 0;i--) { //마지막인덱스부터 올라오면서 체크
            if (arr[indexSave][1] == arr[i][1] && arr[indexSave][2] == arr[i][2] && arr[indexSave][3] == arr[i][3]) {
                break; //정렬되었기때문에 다른경우 거기서 종료
            }
            else { //같지않은경우 랭크올림
                rank ++;
            }
        }
        System.out.println(rank);
    }
}

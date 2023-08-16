import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question19941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); //닿는범위
        int result = 0;//정답

        String str = br.readLine();

        char[] arr = str.toCharArray(); //char배열에 str단어를쪼개서 저장

        for (int i = 0 ; i < N;i++) {
            int left = Math.max(i - K,0);//왼쪽버거먹을때(index벗어나지않도록 max사용)
            int right = Math.min(i + K,N - 1);// 오른쪽버거먹을때 (최대값벗어나지않도록) 최대범위

            for (int j = left ; j <= right;j++) {
                if (arr[i] == 'H' && arr[j] == 'P') { //햄버거와사람이 존재하면 점으로덮음
                    arr[i] = '.';
                    arr[j] = '.';
                    result += 1;
                    break;
                }
            }
        }
        /*
        중요한것은 최대의수가나오는것은 사람이 가장멀리있는버거를 가질때이다
         */
        System.out.println(result);
    }
}

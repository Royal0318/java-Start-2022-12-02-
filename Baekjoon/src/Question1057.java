import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int im = Integer.parseInt(st.nextToken());

        /*
        핵심은 다음라운드에 진출할때 번호를 1부터 다시배정받는다는것이다 그렇다는뜻은
        자신의 번호 + 1 / 2를 하게되었을때 그변수값이 다음라운드에 자기가 부여받는 번호가 되는것이다
         */
        int count = 0;
        while (kim != im) { //지민과 한수가 같아질때까지
            kim = ((kim + 1) / 2);
            im = ((im + 1) / 2);
            count += 1;
        }
        System.out.println(count);
    }
}

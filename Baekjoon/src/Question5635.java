import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        String[] name = new String[testCase];
        int max = Integer.MIN_VALUE; //가장 나이가적은사람을 구할때씀
        int indexSave = 0; //적은사람을 구할때 i값 저장 저장하는이유는 나중에 이름을 출력하기위함
        int indexSave2 = 0;
        int min = Integer.MAX_VALUE; //가장나이가 많은사람

        for (int i = 0; i < testCase; i++) {
            String str = br.readLine();
            String[] cut = str.split(" "); //공백을 기준으로 String배열에 저장

            name[i] = cut[0];
            int days = Integer.parseInt(cut[1]);
            int month = (Integer.parseInt(cut[2]) * 31);
            int years = (Integer.parseInt(cut[3]) * 365);

            int total = (days + month + years); //int 3개를 비교하지말고 한번에 합치는 방법이좋다 그래서 최대값이 나이가 적은사람이고 최소값이 나이가 많은사람이 된다

            if (max < total) { //나이가 적은사람
                max = total;
                indexSave = i;
            }
            if (min > total) {
                min = total;
                indexSave2 = i;
            }

        }
        System.out.println(""+name[indexSave]+"\n"+name[indexSave2]+"");
    }
}

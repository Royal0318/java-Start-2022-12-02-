import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Question14469 {
    public static class saveNum  { //배열에 객체로 저장
        public int one;
        public int two;
        saveNum (int one,int two) {
            this.one = one;
            this.two = two;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        saveNum[] arr = new saveNum[testCase];

        for (int i = 0 ; i < testCase;i++) {
            String str = br.readLine();
            String[] cut = str.split(" ");

            arr[i] = new saveNum(Integer.parseInt(cut[0]),Integer.parseInt(cut[1]));
            //인스턴스 생성후 입력값 저장
        }

        Arrays.sort(arr, new Comparator<saveNum>() { //정렬
            @Override
            public int compare(saveNum o1, saveNum o2) {
                return o1.one - o2.one;
            }
        });

        int time = 0;
        for (int i = 0 ; i < testCase;i++) {
            if (time <= arr[i].one) time = (arr[i].one + arr[i].two);
            else time = (time + arr[i].two);
        }
        System.out.println(time);
    }
}

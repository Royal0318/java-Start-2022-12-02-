import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Question14713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int birdTextCount = 0; //앵무새가 말한수
        int N = Integer.parseInt(br.readLine());

        Queue<String> arr[] = new LinkedList[N]; //큐배열 선언
        for (int i = 0; i < N; i++) arr[i] = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] cut = str.split(" ");//공백을 기준으로 자름
            birdTextCount += cut.length;

            for (int j = 0; j < cut.length; j++) {
                arr[i].add(cut[j]); //큐배열에 자른만큼 단어를 넣는다
            }
        }
        String L = br.readLine(); //cse가 받아적은 문자열조합
        String[] lCut = L.split(" ");
        int lTextCount = lCut.length;

        if (birdTextCount != lTextCount) { //반례1 : 앵무새가 말한 단어수와 cse가받아적은 단어수가 다른경우 Impossible
            System.out.println("Impossible");

        } else {
            for (int i = 0; i < lCut.length; i++) {
                String temp = lCut[i]; //cse가 말한 단어 하나하나씩 앵무새들의 peek와 비교한다
                boolean check = false;

                for (int j = 0; j < N; j++) {
                    if (Objects.equals(arr[j].peek(), temp)) {
                        arr[j].poll(); //그배열 부분 가장먼저 pop
                        check = true;
                    }
                }
                if (!check) { //전체배열의 peek를 봐도 일치하지않는경우
                    System.out.println("Impossible");
                    return;
                }
            }
            boolean emptyCheck = false;
            for (int i = 0; i < N; i++) {
                if (!arr[i].isEmpty()) {
                    emptyCheck = true; //만약 단어가 남아있는경우
                    break;
                }
            }
            if (emptyCheck) System.out.println("Impossible"); //반례2 : 일치해도 마지막에 단어가 남아있는경우 Impossible
            else System.out.println("Possible");
        }
    }
}

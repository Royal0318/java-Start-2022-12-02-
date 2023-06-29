import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Question9536 {
    static ArrayList<String> arr = new ArrayList<>();
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) { //각 테스트케이스만큼 돌아서 출력한다
            StringBuilder sb = new StringBuilder(); //반복될때마다 초기화

            String str = br.readLine();
            String[] cut = str.split(" "); //섞인울음소리들을 Arraylist에 저장
            arr.addAll(Arrays.asList(cut));

            check = new boolean[arr.size()];

            while (true) {
                String sound = br.readLine();

                String[] soundCut = sound.split(" ");

                if (Objects.equals(sound, "what does the fox say?")) { //종료문
                    break;
                } else {
                    for (int j = 0; j < arr.size(); j++) { //저장된 Arraylist.size만큼 도는데
                        //울음소리가 존재할경우 해당 index번호를 true로바꿈
                        if (Objects.equals(soundCut[2], arr.get(j))) {
                            check[j] = true;
                        }
                    }
                }
            }
            for (int j = 0; j < arr.size(); j++) {
                if (!check[j]) { //false인 부분 즉 울음소리가 나오지않은것이 여우의 울음소리이므로 저장
                    sb.append(arr.get(j)).append(" ");
                }
            }
            System.out.println(sb);
            arr.clear();
        }
    }
}

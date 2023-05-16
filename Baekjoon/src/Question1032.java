import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        String[] arr = new String[50];
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < testCase; i++) { //?번째 문자열
            arr[i] = br.readLine();
        }
        boolean check = false;

        for (int i = 0 ; i < arr[0].length(); i++) { //첫째줄의 문자열을 고정시킨다
            char save = arr[0].charAt(i);
            for (int j = 1 ; j < testCase; j++) { //나머지가 돌면서 문자열을 비교한다
                if (save != arr[j].charAt(i)) { //하나라도 맞지않은경우 ?을저장
                   sb.append("?");
                   check = true;
                   break;
                }
            }
            if (!check) { //만약 for문을 다돌았을때 false라면 문자열이 모두 맞는다는뜻이므로 그 문자열을 저장
                sb.append(arr[0].charAt(i));
            } else {
                check = false;
            }
        }
        System.out.println(sb);
    }
}

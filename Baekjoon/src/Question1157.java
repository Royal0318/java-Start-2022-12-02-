import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1157 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
        //입력값들을 대문자로 변환해줌 대소문자 상관이 없기때문
        int max = 0;
        int result = 0;
        int check = 0;

        if (str.length() == 1) {
            System.out.println(str);
            //만약 1글자만 입력하는경우 해당 값이 제일 큰값이기때문에 그 문자를출력후 종료
        } else {
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - 65;
                arr[index] += 1;
            }
            //그렇지 않은경우 각 문자들이 몇번나왔는지 체크한다
            for (int i = 0; i < 26; i++) {
                if (max < arr[i]) {
                    result = i;
                    max = arr[i];
                }
            }
            //max의 초기값은 0이며 arr[i]값이 더 클경우 max에 값과 i값을 할당
            for (int i = 0; i < 26; i++) {
                if (i == result) {
                    continue;
                }
                //다시 for문을 돌려 max보다 큰 값이 중복존재하는지 확인한다
                //max를 2번 카운트할수없으므로 i와 result가 같을때 패스하고 넘김
               if (max == arr[i]) {
                   check = 1;
                   break;
               }
            }
            if (check == 1) {
                System.out.println("?");
            } else {
                System.out.print((char) (result+65));
                //아스키코드를 통해 result + 65값을 문자로변환
            }
        }
    }
}

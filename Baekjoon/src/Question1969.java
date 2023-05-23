import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        int stringNum = Integer.parseInt(st.nextToken());
        int result = 0;
        String[] arr = new String[testCase]; //테스트케이스만큼 배열을 생성
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase;i++) {
            arr[i] = br.readLine();
        }

        for (int j = 0; j < stringNum;j++) {
            int[] alpha = new int[26];//알파벳개수 저장 한번돌때마다 계속초기화
            int max = Integer.MIN_VALUE; //가장많이나온 알파벳의 number를 저장
            int max2 = Integer.MIN_VALUE; //가장많이 나온 알파벳의 횟수를 저장

            for (int i = 0; i < testCase; i++) {
                int a = arr[i].charAt(j) - 'A'; //해당 알파벳을 숫자로 변환한다
                alpha[a] += 1; //나온횟수만큼 1씩 추가
            }
            for (int i = 0; i < 26; i++) { //동일하게 나온경우 알파벳순서먼저이다
                if (max2 < alpha[i]) { //만약에 max2보다 더 많이 나온경우 max에 해당알파벳 저장
                    max = i;
                    max2 = alpha[i]; //그리고 횟수도 같이저장한다
                }
            }
            sb.append((char) (max + 65)); //숫자에서 문자로 다시 변환하여 저장한다
        }
        for (int i = 0; i < testCase; i++) {
            for (int j = 0; j < stringNum; j++) {
                if (sb.charAt(j) != arr[i].charAt(j)) {
                    result += 1;
                }
            }
        }
        //Hamming Distance 문자열이 완성되면 각 입력한 문자열과 비교하여 맞지않는 횟수를 카운트
        System.out.println("" + sb + "\n" + result + "");
    }
}
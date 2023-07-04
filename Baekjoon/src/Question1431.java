import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Question1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        String[] arr = new String[testCase];

        for (int i = 0; i < testCase;i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) { //길이가 같으면
                   int o1Sum = sumNumber(o1); //각 문자열에 섞여있는 자리수합을 비교
                   int o2Sum = sumNumber(o2);

                   if (o1Sum == o2Sum) { //그래도 같아서 case3로 가는경우
                      return o1.compareTo(o2); //사전순으로 비교 숫자가 알파벳보다 사전순
                   }
                   else {
                       return o1Sum - o2Sum;
                   }
                }
                else { //길이가다르면
                    return o1.length() - o2.length(); //짧은것이 먼저옴
                }
            }
        });
        for (String s : arr) {
            System.out.println(s);
        }
    }
    public static int sumNumber (String o) {
        int numberSum = 0;

        for (int i = 0; i < o.length();i++) {
            if (o.charAt(i) > '0' && o.charAt(i) <= '9') {
                numberSum += o.charAt(i) - '0';
            }
        }
        return numberSum;
    }
}

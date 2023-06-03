import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Question1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String[] arr = new String[testCase];

        for (int i = 0;i < testCase;i++) {
            arr[i] = br.readLine(); //테스트 케이스들을 String형태로 입력한다
        }
        int temp = 1; //temp를 밖에 빼놔도 상관없다 문자열 가장 처음까지 오기전에 정답이 도출되어 탈출되기때문이다
        while (true) { //답이 나올때까지 반복
            HashSet<String> result = new HashSet<>(); //중복제거
            for (int i = 0; i < testCase;i++) {
                String cut = arr[i].substring(arr[i].length() - temp);
                //서브스트링을 이용해 끝에서부터 한칸씩 자른다
                result.add(cut); //그값들을 해시셋에 add한다
            }
            if (result.size() == testCase) { //해시셋은 중복을 제거해주기때문에 정답이라면 테스트케이스와 해시셋사이즈가 같을것이다
                //만약에 중복이존재하면 삭제되어 index가 줄기때문에 맞지않으면  temp를 늘려서 다음을 자르도록한다
                System.out.println(temp);
                break;
            } else {
                temp += 1;
            }
        }
    }
}

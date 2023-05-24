import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Question1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        ArrayList<String> result = new ArrayList<>(); //정답을 넣는 리스트
        ArrayList<String> arr = new ArrayList<>(); //처음 문자열을 넣는 리스트

        for (int i = 0; i < testCase; i++) {
            arr.add(br.readLine());
        }

        for (String str : arr) { //for each문을 돌려서
            if (max < Collections.frequency(arr, str)) { //중복값이 가장 많이나온 부분이 존재할때
                max = Collections.frequency(arr,str);
                result.clear(); //그 전에 추가된것을 초기화하고
                result.add(str); //새로운 문자열을 저장
            } else if (max == Collections.frequency(arr,str)) {
                result.add(str); //같은경우도 저장한다
            }
        }
        Collections.sort(result); //알파벳순으로 정렬해줌
        System.out.println(result.get(0)); //가장앞에것을 출력
    }
}

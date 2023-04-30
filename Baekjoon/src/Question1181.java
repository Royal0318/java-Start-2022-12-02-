import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Question1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int index = 0;
        int temp = 1;
        int length = Integer.MIN_VALUE; //최저값 선언

        /*
        이문제의 풀이는 3가지 방식으로 나눠서 진행한다
        1.중복을제거
        2.알파벳 순서대로 나열
        3.각 문자열 lengh길이가 작은길이만큼 출력
         */
        HashSet<String> has = new HashSet<>(); //처음에HashSet을 이용하여 중복을 제거한다
        ArrayList<String> arr2 = new ArrayList<>();

        for (int i = 0; i < testCase;i++) {
            has.add(br.readLine()); //Hashset을 이용하면 자동으로 중복을 제거한다
        }
        for (String a : has) {
            arr2.add(index, a);
            if (length < a.length()) {
                length = a.length();
            }
            index += 1;
        }
        //그 다음 Arraylist에 중복이 걸러진 문자열을 저장한다 그렇게 함과 동시에 문자열의 최대 길이를 구한다 밑에 while에 써야하기 때문
        Collections.sort(arr2);
        //collections.sort를 통해 알파벳 순서대로 정렬한다
        while (temp <= length) {
            for (String test : arr2) {
                if (test.length() == temp) {
                    System.out.println(test);
                }
            }
            temp += 1;
        }
        /*
        temp가 1이니까 1부터 최대길이 length까지 돈다 그러면서 for-each문으로 문자열 길이를 1부터 아까 저장한
        최대길이 변수까지 돌면서 출력한다
        이미 컬렉션 솔트를 통해서 문자열이 정렬되었기 때문에 길이만 구하면 또 문자열 정렬을 하지않도된다
         */
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question1755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        HashMap<Character, String> arr = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        arr.put('0', "zero");
        arr.put('1', "one");
        arr.put('2', "two");
        arr.put('3', "three");
        arr.put('4', "four");
        arr.put('5', "five");
        arr.put('6', "six");
        arr.put('7', "seven");
        arr.put('8', "eight");
        arr.put('9', "nine");

        for (int i = M;i <= N;i++) {
            String str = String.valueOf(i); //char형을 String으로 변환,길이만큼돌리기위해 String으로 변환했음
            StringBuilder str2 = new StringBuilder(); //문자를붙이기위해 선언

            for (int j = 0; j < str.length();j++) {
                int num = str.charAt(j) - '0'; //다시 int로 변환
                char c = (char) (num + '0'); //숫자 -- > char형으로 변환

                str2.append(arr.get(c)); //예를들어 char가 8이라면 eight를 담는다
            }
            map.put(str2.toString(), i);
            //8이라면   eight/8 을넣는다 즉 String/Integer
        }

        List<String> result = new ArrayList<>(map.keySet()); //sort를 할수있도록 List로 변환
        Collections.sort(result); //keyset이기때문에 알파벳이빠른순으로 나옴

        int count = 1;

        for (String out : result) {
            System.out.print(map.get(out)); //out String에 들어있는 value를 값 출력

            if ((count % 10) == 0) { //10개를 출력한경우
                System.out.println(); //한줄띄움
            } else {
                System.out.print(" "); //나머지 존재시 공백띄움
            }
            count += 1;
        }
    }
}
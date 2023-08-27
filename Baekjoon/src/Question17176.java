import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class Question17176 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = {' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        ArrayList<Character> arr = new ArrayList<>();
        ArrayList<Character> strArr = new ArrayList<>();

        int testCase = Integer.parseInt(br.readLine());
        String N = br.readLine();
        String[] cut = N.split(" ");

        for (String s : cut) arr.add(charArr[Integer.parseInt(s)]); //어레이리스트에 각알파벳을 넣는다

        String str = br.readLine();

        for (int i = 0 ; i < str.length();i++) { //어레이리스트에 각알파벳을 넣는다
            strArr.add(str.charAt(i));
        }
        if (testCase != str.length()) { //비교대상 두개의길이가 다르면 애초에 성립되지않음
            System.out.println("n");
            return;
        }
        Collections.sort(arr); //두 리스트를 sort하여
        Collections.sort(strArr);
        for (int i = 0 ; i < arr.size();i++) { //일치하지않는알파벳이존재하면 n이다
            if (arr.get(i) != strArr.get(i)) {
                System.out.println("n");
                return;
            }
        }
        System.out.println("y");
    }
}

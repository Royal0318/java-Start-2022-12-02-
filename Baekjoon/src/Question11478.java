import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Question11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashSet<String> hashSet = new HashSet<>(); //Arraylist를 사용시 시간초과가 발생하기에 해시셋을 사용
        for (int i = 0; i < str.length();i++) {
            for (int j = i; j <= str.length();j++) { //str.length까지 돌림
                hashSet.add(str.substring(i, j));
                //i범위부터 j범위까지 자르면서 저장한다 해시셋에서 자동으로중복을 거른다
            }
        }
        System.out.println(hashSet.size() - 1); //전체 나온값에 -1을한다
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class Question20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        HashMap<String,Integer> arr = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0;i < testCase;i++) {
            String str = br.readLine();

            int idx = str.indexOf('.'); //.을기준으로 앞에 글자 수 추출
            String temp = str.substring(idx + 1); //idx + 1을 더해서 .이후의 값을 temp에 담는다

            if (arr.containsKey(temp)) { //containsKey(변수)로 돌려서 원래 존재하는놈일경우
                arr.put(temp, arr.get(temp) + 1);
              //새로운것은else로 저장하고 if문은 중복되는것이 존재하는경우다 그렇기 때문에 중복되는것이 나온다면 arr.get(temp) 즉 temp가있는것을 개수와 함께불러들여와 1을추가한다
            } else {//새로운놈
                arr.put(temp, 1);
                //새로운놈이라면 temp문자열을 저장하고 1을 추가한다 1을추가하는것은 1개가 나왔기 때문에 1을 추가하는것이다
                result.add(temp); //Arraylist에도 똑같이 저장한다
            }
        }
        Collections.sort(result); //String만일단 sort한다
        for (String s : result) {
            sb.append(s).append(" ").append(arr.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}

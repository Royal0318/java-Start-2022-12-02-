import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class Question4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String,Integer> arr = new TreeMap<>();
        /*
        Hash는 put할때 정렬되지않는다 LinkdHash는 넣는순서는 유지시켜주지만 그외에 순서는 불가능하기 때문에
        그런정렬까지 해주는 TreeMap사용
         */

        StringBuilder sb = new StringBuilder();
        double count = -1;

        while (true) {
            String str = br.readLine();
            count += 1;

            if (str == null || str.length() == 0) { //종료조건이 따로주어지지 않음
                for (String s : arr.keySet()) {
                    double temp = ((arr.get(s)/count) * 100);
                    sb.append(s).append(" ").append(String.format("%.4f", temp)).append("\n");
                    //String format을 이용하여 소수점4째자리까지 출력하도록함
                }
                System.out.println(sb);
                return;
            }

            if (arr.containsKey(str)) {
                arr.put(str, arr.get(str) + 1);
            }
            else {
                arr.put(str,1);
            }
        }
    }
}

import java.io.IOException;
import java.util.*;

public class Question11652 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        HashMap<Long, Long> arr = new HashMap<>();
        long keyMax = Integer.MIN_VALUE;
        long valuesMax = Integer.MIN_VALUE;
        long testCase = sc.nextInt();

        for (int i = 0; i < testCase;i++) { //입력부
            long input = sc.nextLong();

            if (arr.containsKey(input)) {
                arr.put(input, arr.get(input) + 1);
            }
            else {
                arr.put(input, 1L);
            }
        }
        Set<Map.Entry<Long,Long>> setArr = arr.entrySet();
        for (Map.Entry<Long, Long> s : setArr) {
            if (s.getValue() > valuesMax) { //vale값이 큰경우 그값이 정답이므로 저장
                valuesMax = s.getValue();
                keyMax = s.getKey();
            } else if (s.getValue() == valuesMax) {
                keyMax = Math.min(s.getKey(), keyMax);
            }
        }
        System.out.println(keyMax);
    }
}
/*
 방법2)getorDefault를 사용한 방법
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long m = Long.parseLong(br.readLine());
            map.put(m, map.getOrDefault(m, 0) + 1);
        }
        int max = -1;
        long num = 0;
        for (long l : map.keySet()) {
            if (map.get(l) > max) {
                max = map.get(l);
                num = l;
            } else if (map.get(l) == max) {
                num = Math.min(l, num);
            }
        }
        System.out.println(num);
    }

}
 */

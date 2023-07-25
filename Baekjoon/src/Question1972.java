import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

public class Question1972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            boolean check = false;
            String str = br.readLine();

            if (Objects.equals(str, "*")) {
                break;
            }
            else {
                if (str.length() == 1 || str.length() == 2) { //예외처리 문자열1개는무조건 서프라이징
                    System.out.println(""+str+" is surprising.");
                }
                else {
                    for (int i = 0; i < (str.length() - 1); i++) { //한바퀴돌때마다 초기화
                        HashMap<String, Integer> arr = new HashMap<>();

                        for (int j = 0; j < (str.length() - i - 1); j++) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str.charAt(j)).append(str.charAt(j + i + 1));
                            String temp = String.valueOf(sb2);

                            if (arr.containsKey(temp)) { //만약에 같은 문자열이 존재하는경우는 유일성X
                                check = true;
                                break;
                            }
                            else { //한번도 나오지않은 문자열인경우
                                arr.put(temp, 1);
                            }
                        }
                        if (check) { //같은문자열 나올시 Not 서프라이징
                            System.out.println(""+str+" is NOT surprising.");
                            break;
                        }
                    }
                    if (!check) { //만약 false라면 모두 겹치지 않는다는뜻
                        System.out.println(""+str+" is surprising.");
                    }
                }
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question4659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        ArrayList<Character> arr = new ArrayList<>(); //모음
        arr.add('a');
        arr.add('e');
        arr.add('i');
        arr.add('o');
        arr.add('u');
        while (true) {
            String str = br.readLine();

            if (str.equals("end")) { //종료조건
                System.out.println(sb);
                return;
            }
            //조건1
            boolean alphaCheck = false;
            for (int i = 0 ; i < str.length();i++) {
                if (arr.contains(str.charAt(i))) { //모음최소1개 존재시 성립
                    alphaCheck = true;
                    break;
                }
            }
            if (!alphaCheck) { //성립 X
                sb.append("<").append(str).append("> is not acceptable.").append("\n");
            }
            else { //조건2
                boolean volconCheck = false;
                for (int i = 0 ; i < str.length() - 2;i++) {
                    if (arr.contains(str.charAt(i)) && arr.contains(str.charAt(i + 1)) && arr.contains(str.charAt(i + 2))) { //모음3개연속
                        sb.append("<").append(str).append("> is not acceptable.").append("\n");
                        volconCheck = true;
                        break;
                    }
                    if (!arr.contains(str.charAt(i)) && !arr.contains(str.charAt(i + 1)) && !arr.contains(str.charAt(i + 2))) { //자음3개연속
                        sb.append("<").append(str).append("> is not acceptable.").append("\n");
                        volconCheck = true;
                        break;
                    }
                }
                if (!volconCheck) { //조건3
                    boolean passCheck = false;
                    for (int i = 0 ; i < str.length() - 1;i++) {
                        if (str.charAt(i) == str.charAt(i + 1)) {
                            if (str.charAt(i) == 'e' || str.charAt(i) == 'o') {
                                continue;
                            }
                            sb.append("<").append(str).append("> is not acceptable.").append("\n");
                            passCheck = true;
                            break;
                        }
                    }
                    if (!passCheck) {
                        sb.append("<").append(str).append("> is acceptable.").append("\n");
                    }
                }
            }
        }
    }
}

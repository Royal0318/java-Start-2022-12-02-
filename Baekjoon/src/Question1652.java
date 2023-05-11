import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        char[][] arr = new char[testCase][testCase];

        for (int i = 0; i < testCase; i++) {
            String str = br.readLine();
            for (int j = 0; j < testCase; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int a = 0; //가로카운트
        int b = 0; //세로카운트
        int start = 0; //while문 시작
        String str2 = ".."; //비교하는 문자열 지문에 ..이 2개이상이면 카운트
        while (start < testCase) { //가로열체크
            boolean xcount = false;
            for (int j = 0; j < testCase - 1; j++) {
                if (arr[start][j] == '.' && !xcount) { //해당문자열이 점이면서 false라면 통과 true인것은 x를만났다는뜻이다
                    if (arr[start][j] == str2.charAt(0) && arr[start][j + 1] == str2.charAt(1)) {
                        a += 1;
                        xcount = true; //비교해서 맞는경우 true로 바꿈
                    }
                } else if (arr[start][j] == 'X') { //만약에 X라면 false로 바꿈 예를들어 ..X..이 것도 1개로보는것이 아닌 누울자리가 2개라는뜻이다
                    //그렇기때문에 처음에 1개가 카운트되고 X를만나면 초기화하며 다시 뒤에 2개이상 나오면 카운트가 가능한것
                    xcount = false;
                }
            }
            xcount = false;
            for (int j = 0; j < testCase - 1; j++) { //세로열 체크
                if (arr[j][start] == '.' && !xcount) {
                    if (arr[j][start] == str2.charAt(0) && arr[j + 1][start] == str2.charAt(1)) {
                        b += 1;
                        xcount = true;
                    }
                } else if (arr[j][start] == 'X') {
                    xcount = false;
                }
            }
            start += 1;
            //세로도 같은방법으로 진행한다
        }
        System.out.println(""+a+" "+b+"");
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class Question1283 {
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //Arraylist를 사용하면 contains를 적극활용!해야하는문제!
        int testCase = Integer.parseInt(br.readLine());

        ArrayList<Character> arr = new ArrayList<>();

        for (int i = 0; i < testCase;i++) {
            int indexSave = 0; //비어있어서 추가되는 알파벳의 위치(index를 저장한는 변수)
            sb.setLength(0); //한번돌때마다 초기화
            check = false;

            String str = br.readLine();

            String upper = str.toUpperCase(Locale.forLanguageTag(str)); //대문자로 변환
            //비교는 대문자로 담는거는 소문자로 담는다
            if (!arr.contains(upper.charAt(0))) { //가장처음은 먼저비교
                arr.add(upper.charAt(0)); //없는경우 추가한다
                check = true;
            } else {
                for (int j = 1; j < (str.length() - 1); j++) {
                    if (str.charAt(j) == ' ') {
                        //빈칸을 만난경우 다음문장이 존재하는것인지 확인
                        if (!arr.contains(upper.charAt(j + 1))) { //빈칸다음은 맨앞자리기때문에 비교해봄
                            arr.add(upper.charAt(j + 1)); //없는경우 추가한다
                            indexSave = (j + 1); //위치저장
                            check = true;
                            break; //찾았으면 바로 탈출
                        }
                    }
                }
                if (!check) { //만약에 앞자리들이 모두 존재한다면
                    for (int j = 0; j < str.length(); j++) { //처음부터 끝까지 돌면서 없는것추가
                        if (!arr.contains(upper.charAt(j)) && upper.charAt(j) != ' ') { //빈칸은 건너띄어야하기때문에 &&꼭 필요!
                            arr.add(upper.charAt(j));
                            indexSave = j;
                            check = true;
                            break;
                        }
                    }
                }
            }
            if (check) { //비어있는 것을 추가한적이있는경우
                for (int j = 0; j < str.length(); j++) {
                    if (j == indexSave) { //indexSave에 저장된 번호의 알파벳만 괄호쳐줌
                        sb.append("[" + str.charAt(j) + "]");
                    } else { //나머지는 그냥붙친다
                        sb.append(str.charAt(j));
                    }
                }
                System.out.println(sb);
            }
            else { //추가한적이없고 모두 존재하는 알파벳인경우 문장그대로출력
                System.out.println(str);
            }
        }
    }
}
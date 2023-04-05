import java.util.Scanner;

public class Question1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int result = 0;

        for (int i = 0; i < testCase; i++) {
            String str = sc.next();
            boolean[] arr = new boolean[26];
            //알파벳이 총 26개이기때문
            boolean temp = true;
            //주의할점은 초기의 불린은 false이다

            for (int j = 0; j < str.length(); j++) {
                int index = str.charAt(j) - 'a'; //-97도 가능
                //String값을 입력하면 index에 0번째 알파벳을 진수로 변환한다 a는 0 z는 25이다

                if (arr[index] == true) { //만약에 그 값이 전에 사용된적이 있는경우는 arr[알파벳index]가 true가 되었을것이다 25번참고
                    if (str.charAt(j) != str.charAt(j-1)) {
                        temp = false;
                        //만약 전의 값이 연속되지 않는경우 false
                    }
                    //만약 사용한적이있다면 그것이 전의 알파벳과 연속되는지 봐야한다 연속되면 통과지만 연속되지않으면 띄엄띄엄 나왔기 때문에 통과되지 못한다
                } else { //사용한적이 아예없는경우
                    arr[index] = true;
                    //해당 알파벳을 신규등록
                }
            }
            if (temp) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}

import java.util.Scanner;

public class Question2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int one = sc.nextInt();
        int two = sc.nextInt();
        int three = sc.nextInt();

        int sum = (one * two * three);

        String str = ""+sum+"";

        for (int i = 0 ; i < 10;i++) { //0 ~ 9까지
            int count = 0;
            for (int j = 0 ; j < str.length();j++) {
                if (str.charAt(j) - '0' == i) {
                    //i숫자를 고정시키고 전체 문자열을 돌면서 같으면 count를 올린다 그 이후 다돌면 출력후 초기화
                    count += 1;
                }
            }
            System.out.println(count);
        }
    }
}

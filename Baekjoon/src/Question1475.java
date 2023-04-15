import java.util.Arrays;
import java.util.Scanner;

public class Question1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        //총  0 ~ 9까지 10개의 배열을 생성
        String str = sc.next();

        for (int i = 0; i < str.length();i++) {
            if (str.charAt(i) - '0' == 6 || str.charAt(i) - '0' == 9) {
                arr[6] += 1;
                //str.chatat값이 6이나 9가 나올시 arr[6]에 몰아넣는다
            } else {
               arr[str.charAt(i) - '0'] += 1;
               //나머지는 해당 배열에 넣음
            }
        }
        if ((arr[6] % 2) == 0) { //만약넣은값이짝수라면 2로 나눈 몫만큼 세트가된다
            arr[6] = (arr[6] / 2);
        } else { //홀수인경우 몫과 나머지를 더한값이 세트가된다
            arr[6] = ((arr[6] % 2) + (arr[6] / 2));
        }
        Arrays.sort(arr);
        //Arraysort로 정렬하여 끝index - 1 가장큰값 출력
        System.out.println(arr[arr.length-1]);
    }
}

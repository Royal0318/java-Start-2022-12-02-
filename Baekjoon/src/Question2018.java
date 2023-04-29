import java.util.Scanner;

public class Question2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int start = 1; //시작지점
        int end = 1; //끝지점
        int sum = 1; //수의합
        int result = 1; //정답
//배열 아닌경우
       while (end != num) { //end가 num와 같아지면 break로 자동탈출되서 정답도출
           if (sum == num) { //같으면 end조정
               end += 1;
               result += 1;
               sum = (sum + end);
           } else if (sum > num) { //크면 start조정
               sum = (sum - start);
               start += 1;
           } else { //그외에는 end조정
               end += 1;
               sum = (sum + end);
           }
       }
        System.out.println(result);
    }
}

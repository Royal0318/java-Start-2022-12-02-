import java.util.Scanner;

public class Question1924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int days = sc.nextInt();
        int daysSum = 0;
        int[] monthArr = {31,28,31,30,31,30,31,31,30,31,30,31};
        //각각의 월을 배열에 저장
        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        //일요일부터시작하여 토요일까지 이어지는문자열을 저ㅏㅈㅇ
        for (int i = 0;i < (month - 1);i++) {
            daysSum += monthArr[i];
        }
        //구하고자 하는 달 = (1월부터 구하는달 - 1) 까지 예를들어 3월이면 1월 2월의 일수를 더함
        //그 이후에 구하는 일수를 1월2월 일수더한곳에 추가로더함
        System.out.println(day[(daysSum + days) % 7]);
        //day배열에 1월과 2월 + days 더한 값에 7을나눠 나머지의 숫자가 배열에 들어감
    }
}

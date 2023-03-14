import java.util.Scanner;

public class Question2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int number = sc.nextInt();
        int[] arr = new int[n];
        int temp = 0;
        int result = 0;
        //값을 비교할 변수2개를 만듬

        for (int i = 0; i < arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        //테스트 케이스만큼 값을 입력하여 배열에 저장
        for (int i = 0; i < (n-2) ; i++) {
            for (int j = (1 + i); j < n ; j++) {
                for (int k = (1 + j); k < n ; k++) {
                    temp = (arr[i] + arr[j] + arr[k]);
                    if (temp == number) {
                        result = number;
                        break;
                    }
                    if (result <= temp && temp <= number) {
                        result = temp;
                    }
                }
            }
        }
        /*
        카드는 중복되지 않기때문에 여러가지 경우의수를 고려해야한다 예를들어 입력을 5라고 하고 5 6 7 8 9 를입력한경우 다음과같이 진행된다
        5             6              7              8             9
        O             O              O                                 1가지
        O             O                             O                  2가지
        O             O                                           O    3가지
        O                            O              O                  4가지
        O                            O                            O    5가지
        O                                           O             O    6가지
                     O               O              O                  7가지
                     O               O                            O    8가지
                     O                              O             O    9가지
                                     O              O             O    10가지

         이렇게 카드가 중복되지 않고 구하는법은 5C3 즉 컴비네이션을 이용하여 10가지가 존재한다
       처음에 나온값을 temp변수에 넣어 그값이 number와같으면 가장큰값이 되므로break문을 통해 바로 Println으로 출력하면되지만
       그렇지 않은경우 result변수와 비교하여 그값이 크고 number보다 작은경우 if문이 성립하여 temp변수에 있는 값이 result로 이동된다
       다음에 한바퀴 돌아 다시 temp에 값이 들어가고 그값을 아까 넣은 result와 비교하여 크다면 result변수에 넣고 크지않으면 지나가는것을
       반복하여 최종적으로 가장 가까운 값이나 number와같은 값이 출력되게 되는것이다
         */
        System.out.println(result);
    }
}


import java.util.Scanner;

/*
처음에 몇 명의 돈을 추가할 지 입력받는다.
	예를들어 3명으로 한다면
	3을 입력받았으면 아래처럼 나타난다.

	1번째 손님 추가할 금액 : 10000
	2번째 손님 추가할 금액 : 10000
	3번째 손님 추가할 금액 : 10000
	이렇게 쓰면, 바로 아래처럼 나타난다.
	1번째 손님이 가진 금액 : 10000
	2번째 손님이 가진 금액 : 10000
	3번째 손님이 가진 금액 : 10000
	그리고, 바로 몇 번째 손님의 돈을 뺄 지 질문한다.
	강사는 2번째라고 하겠다.
	그렇게 하면, 얼마를 빼겠냐고 질문한다.
	이 때에, 돈을 뺐을 당시 돈이 0원이 된다면 해당 손님의 번호는 사라진다.
	예시를 들겠다.

	몇 번째 손님을 선택하겠습니까 : 2
	얼마를 빼시겠습니까 : 10000

	1번째 손님이 가진 금액 : 10000
	2번째 손님이 가진 금액 : 10000

	손님의 돈을 얼마를 빼든, 빼면 바로 위처럼 몇 번까지 존재하고, 얼마를 가지고 있는지를 나타낸다.
	따라서, 현재 위 같은 경우, 2번 손님의 돈이 0원이 되어 삭제되고, 3번의 손님이 2번으로 바뀐 걸 확인할 수 있다.
	위 같은 문제를 만들어보고,

	마지막에는 현재 남은 손님들의 돈이 합쳐서 얼마나 존재하는지를 나타내고, 현재 몇 번까지 존재하는질 나타내보자.
	또한, 처음에 있었던 3명은 얼마를 가지고 있었고, 현재는 얼마가 남았는지, 총액을 알아내고,
	둘이 얼마나 차액이 벌어졌는지를 나타내자.
	손님 선택과 뺄 금액에서 둘 다 0을 입력하면 종료된다.
 */
public class forwhile31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Peoplemoneysum = 0;
        int Lastpeoplemoneysum = 0;
        System.out.println("몇명의 돈을 추가받으시겠습니까?");
        int Totalpeople = sc.nextInt();

        int[] arr = new int[Totalpeople];

        for (int i = 0; i < Totalpeople; i++) {
            System.out.println("" + (i + 1) + "번째 손님의 금액");
            arr[i] = sc.nextInt();
            Peoplemoneysum += arr[i];
            Lastpeoplemoneysum += arr[i];
        }
        for (int i = 0; i < Totalpeople; i++) {
            System.out.println("" + (i + 1) + "번째 손님의 금액 : " + arr[i] + "원");
        }
        for (int j = 0; j <= Totalpeople; j++) {
            System.out.println("몇번째 손님의 돈을 차감하시겠습니까? 안내 : 해당 손님의 돈이 0원이 되면 자동 삭제됩니다");
            int Peoplechoice = sc.nextInt() - 1;
            System.out.println("얼마를 차감하시겠습니까?");
            int Moneydelete = sc.nextInt();

            Lastpeoplemoneysum -= Moneydelete; //차감하는만큼 누적
            arr[Peoplechoice] = (arr[Peoplechoice] - Moneydelete); //해당 손님의 돈을 차감

            if (arr[Peoplechoice] <= 0) {
                for (int i = Peoplechoice; i < (Totalpeople - 1); i++) {
                    arr[i] = arr[i + 1];
                }
                Totalpeople--;
                for (int i = 0; i <= (Totalpeople - 1); i++) {
                    System.out.println("" + (i + 1) + "번째 손님의 금액 : " + arr[i] + "원");
                }
            } else {
                for (int i = 0; i < Totalpeople; i++) {
                    System.out.println("" + (i + 1) + "번째 손님의 금액 : " + arr[i] + "원");
                }
            }
        }
        System.out.println("처음에 가지고 있던 손님의 돈의 총합 : " + Peoplemoneysum + "원");
        System.out.println("현재 남은 돈 : " +Lastpeoplemoneysum+ "원");
        System.out.println("둘의 차액 : " + (Peoplemoneysum - Lastpeoplemoneysum) + "원");
    }
}

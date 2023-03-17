import java.util.Scanner;

public class Question2851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int score = 0;

        for (int i = 0;i < 10 ; i++) {
            arr[i] = sc.nextInt();
        }
        score += arr[0];
        for (int i = 1;i < 10 ; i++) {
            score += arr[i];
            if (score > 100) {
                score -= arr[i];
                int temp = (score + arr[i]);

                if (Math.abs(100 - (score)) < Math.abs(100 - temp)) {
                    break;
                } else {
                    score = temp;
                }
            } else if (score == 100) {
                break;
            }
        }
        /*
        1번째 버섯은 무조건 먹어야하는 조건이 존재한다 2번째부터 먹기시작하여 그값이 100일때 예외처리로 break를 한다
        예외처리를 해주는이유는 100일때는 그값보다 근사값이 없기 때문이다 100보다 클경우 절대값으로 비교하여 오른쪽이 더큰경우에는
        다음버섯을 먹기전이 가장 큰값이 되며 왼쪽이나 같은경우 더 큰수를 먹는 조건에 부합 그리고 다음버섯을 먹으면
        그값이 더 100과 가깝기 때문에 score = temp로 스코어 변수에 템프값을 넣어준다
         */
        System.out.println(""+score+"");
    }
}

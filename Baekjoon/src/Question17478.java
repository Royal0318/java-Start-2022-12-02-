import java.util.Scanner;

public class Question17478 {
    static String underbar = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        f(n);
    }
    static void f (int n) {
        String line = underbar;
        if (n == 0) {
            System.out.println(""+line+"\"재귀함수가 뭔가요?\"");
            System.out.println(""+line+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(""+line+"라고 답변하였지.");
        } else {
            System.out.println(""+line+"\"재귀함수가 뭔가요?\"");
            System.out.println(""+line+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(""+line+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(""+line+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            underbar += "____";
            f(n-1);

            System.out.println(""+line+"라고 답변하였지.");
            /*
            매커니즘이 하노이의탑과 비슷하다 처음에 n값을 입력받은 후 n이 0이될때까지 else를 실행하면서 underbar를 계속추가한다
            그렇기때문에 별도의 변수가 필요한것이다 그 역할이 String line이다 그 이후 n이 0이된후에 if문이 실행되면서
            언더바 + println이 실행하고   f(n-1);까지 실행하였기 때문에 그다음은
            System.out.println(""+line+"라고 답변하였지.");
            를 실행하게 되는것이다
             */
        }
    }
}

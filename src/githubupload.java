문제)사람 이름, 음식 이름, 음식 가격은 변수를 입력받고
	은는을를의등과 원, 어치,지불이라는 단어는 변수로 지정하시오

	철수와 영희는 함께 음식을 준비했습니다.
	철수는 토마토, 감자, 주스를 샀습니다.
	영희는 떡, 마늘, 양파를 샀습니다.
	토마토는 2000원, 감자는 800원, 주스는 1200원입니다.
	떡은 6200원, 마늘은 2000원, 양파는 3200원입니다.
	총 합은 ?원이 나왔습니다.
	철수는 ?원을 지불하고
	영희는 ?원을 지불하였습니다.
	영희는 철수보다 ?원을 더 지불했습니다.
    
   주의사항! 단어도 변수로 지정하고 가격도 변수로 지정하세요!




import java.util.Scanner;

public class githubupload {
    public static void manin(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1.감자  \n2.옥수수  \n3.수박");
        int foodselect = sc.nextInt();

        if (foodselect == 1) {
            System.out.println("감자를 선택하셨습니다.");
            System.out.println("\n1.1000원어치 구매 \n2.2000원어치 구매 \n3.3000원어치 구매");
            int moneyselect = sc.nextInt();
            if (moneyselect == 1) {
                System.out.println("감자를 1000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(1000 * num)+"원 입니다");
            }
            if (moneyselect == 1) {
                System.out.println("감자를 2000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(2000 * num)+"원 입니다");
            }
            if (moneyselect == 1) {
                System.out.println("감자를 3000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(3000 * num)+"원 입니다");
            }
        }
        if (foodselect == 2) {
            System.out.println("옥수수를 선택하셨습니다.");
            System.out.println("\n1.4000원어치 구매 \n2.5000원어치 구매 \n3.6000원어치 구매");
            int moneyselect = sc.nextInt();
            if (moneyselect == 1) {
                System.out.println("옥수수를 4000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(4000 * num)+"원 입니다");
            }
            if (moneyselect == 2) {
                System.out.println("옥수수를 5000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(5000 * num)+"원 입니다");
            }
            if (moneyselect == 3) {
                System.out.println("옥수수를 6000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(6000 * num)+"원 입니다");
            }
        }
        if (foodselect == 3) {
            System.out.println("수박을 선택하셨습니다.");
            System.out.println("\n1.10000원어치 구매 \n2.20000원어치 구매 \n3.30000원어치 구매");
            int moneyselect = sc.nextInt();
            if (moneyselect == 1) {
                System.out.println("수박을 10000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(10000 * num)+"원 입니다");
            }
            if (moneyselect == 2) {
                System.out.println("수박을 20000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(20000 * num)+"원 입니다");
            }
            if (moneyselect == 3) {
                System.out.println("수박을 30000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(30000 * num)+"원 입니다");
            }
        }
    }
}

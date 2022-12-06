/*Scanner를 사용하여 간단하게 입력을 하고 원하는 변수를 출력으로 나타내보는 문제를 풀었다!!
출력값을 여러개 붙혔을 때 가독성이 좋지 않으므로 \n을 하면 출력값과 출력값사이에 공백이 생겨 가독성이 좋아진다!
문)
사람이름,음식이름,음식가격을 변수로 입력받으며 "은, 는, 을, 를, 의, 원, 어치, 지불"이라는 단어는 변수로 지정하시오
철수와 영희는 함께 음식을 준비했습니다
철수는 토마토,감자,주스를 샀으며 영희는 떡,마늘,양파를 샀습니다
토마토는 100원, 감자는 100원, 주스는 100원이며
떡은 100원, 마늘은 100원, 양파는 100원입니다
총합은 100원이 나왔으며 철수는 100원을 지불하고 영희는 100원을 지불하였으며 영희는 철수보다 100원을 더 지불하였습니다
주의사항! ?값은 출력시 입력값이 다를때마다 항상 달라야한다 위 문제에 맞는 코드를 작성하시오 */

import java.util.Scanner;

public class Decemberfirst {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String variable = "는";
        String variable2 = "와";
        String variable3 = "은";
        String variable4 = "를";
        String variable5 = "원";
        String variable6 = "보다";
        String variable7 = "지불";


        System.out.println("\n사람 이름 2명을 입력해주세요");
        String People = sc.next();
        String People2 = sc.next();

        System.out.println("\n"+People+"가 구매한 음식이름 3가지를 적어주세요");
        String food = sc.next();
        String food2 = sc.next();
        String food3 = sc.next();

        System.out.println("구매한 음식 3가지의 가격을 적어주세요 ");
        int Price = sc.nextInt();
        int Price2 = sc.nextInt();
        int Price3 = sc.nextInt();
        int total = (Price + Price2 + Price3);

        System.out.println("\n"+People2+"가 구매한 음식이름 3가지를 적어주세요");
        String food4 = sc.next();
        String food5 = sc.next();
        String food6 = sc.next();

        System.out.println("구매한 음식 3가지의 가격을 적어주세요 ");
        int Price4 = sc.nextInt();
        int Price5 = sc.nextInt();
        int Price6 = sc.nextInt();
        int total2 = (Price4 + Price5 + Price6);

        System.out.println("\n"+People+""+variable+""+food+""+variable2+""+food2+""+variable2+""+food3+""+variable4+"샀습니다");
        System.out.println("\n"+People2+""+variable+""+food4+""+variable2+""+food5+""+variable2+""+food6+""+variable4+"샀습니다");
        System.out.println("\n"+food+""+variable+""+Price+""+variable5+""+food2+""+variable+""+Price2+""+variable5+""+food3+""+variable+""+Price3+""+variable5+"입니다");
        System.out.println("\n"+food4+""+variable+""+Price4+""+variable5+""+food5+""+variable+""+Price5+""+variable5+""+food6+""+variable+""+Price6+""+variable5+"입니다");
        System.out.println("\n총 합은 "+(total + total2)+""+variable5+"나왔으며");
        System.out.println("\n"+People+""+variable+""+total+""+variable5+""+variable7+"하고");
        System.out.println("\n"+People2+""+variable+""+total2+""+variable5+""+variable7+"하였으며");
        System.out.println("\n"+People+""+variable3+""+People2+""+variable6+""+(total - total2)+""+variable5+""+variable7+"했습니다");
    }
}

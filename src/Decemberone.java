Scanner를 사용하여 간단하게 입력을 하고 원하는 변수를 출력으로 나타내보는 문제를 풀었다!!
문)사람이름,음식이름,음식가격을 변수로 입력받으며 "은, 는, 을, 를, 의, 원, 어치, 지불"이라는 단어는 변수로 지정하시오
철수와 영희는 함께 음식을 준비했습니다
철수는 토마토,감자,주스를 샀으며 영희는 떡,마늘,양파를 샀습니다
토마토는 100원, 감자는 100원, 주스는 100원이며
떡은 100원, 마늘은 100원, 양파는 100원입니다
총합은 100원이 나왔으며 철수는 100원을 지불하고 영희는 100원을 지불하였으며 영희는 철수보다 100원을 더 지불하였습니다
?값은 출력시 입력값이 다를때마다 항상 달라야한다
위 코드를 작성하시오



import java.util.Scanner;

public class Decemberone {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = "는";
        String b = "와";
        String c = "은";
        String d = "를";
        String e = "원";
        String f = "보다";
        String g = "지불";


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

        System.out.println("\n"+People+""+a+""+food+""+b+""+food2+""+b+""+food3+""+d+"샀습니다");
        System.out.println("\n"+People2+""+a+""+food4+""+b+""+food5+""+b+""+food6+""+d+"샀습니다");

        System.out.println("\n"+food+""+a+""+Price+""+e+""+food2+""+a+""+Price2+""+e+""+food3+""+a+""+Price3+""+e+"입니다");
        System.out.println("\n"+food4+""+a+""+Price4+""+e+""+food5+""+a+""+Price5+""+e+""+food6+""+a+""+Price6+""+e+"입니다");

        System.out.println("\n총 합은 "+(total + total2)+""+e+"나왔으며");
        System.out.println("\n"+People+""+a+""+total+""+e+""+g+"하고");
        System.out.println("\n"+People2+""+a+""+total2+""+e+""+g+"하였으며");
        System.out.println("\n"+People+""+c+""+People2+""+f+""+(total - total2)+""+e+""+g+"했습니다");
    }
}
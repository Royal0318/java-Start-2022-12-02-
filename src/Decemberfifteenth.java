/*
조건 : 문제의 예시에는 음식이 3가지로 분류되어 있으며
if문만 사용가능 반복문은 사용X
문 )
갑과 을이 있습니다
둘이가진 금액은 10000원으로 처음에 용돈을 추가적으로 입력받습니다
입력 받은 후 현재 금액이 얼마인지 바로 나타내준 후
바로 떡볶이,우동,과자를 입력받는다
그 후에 몇개를 주문할건지 메시지가 나타나며
개수를 입력할 때 돈이 부족한 경우가 생긴다면 추가적으로 용돈을 받는다 추가용돈은 1번만 받을 수 있다
돈이 부족하지 않은 경우는 떡볶이의 가격과 남은 가격과 함께 다음 음식으로 넘어간다
용돈을 받은 후에 값이 그래도 구매가격보다 적을경우 프로그램을 종료시키며
만약 돈이 부족해서 추가적으로 용돈을 받은 후 "라면은 얼마를 입력받아서 얼마가 되었다" 라는 형식으로 나타내며
그곳에서 돈이 부족하지 않은경우 떡볶이 가격과 남은 가격 문장과 함께 다음음식으로 넘어가게 된다
돈이 부족하지 않고 음식을 모두 구매했다면 프로그램을 종료시키며
추가적으로 용돈을 받은 후에도 돈이 부족할경우 바로 프로그램을 종료 시키도록 코드를 구현하시오
 */
import java.util.Scanner;
public class Decemberfifteenth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0; //제어변수

        System.out.println("갑과 을의 가진 용돈은 10000원 입니다 추가용돈을 적어주세요");
        int Money = sc.nextInt() + 10000;

        System.out.println("현재 갑과 을이 가지고 있는 금액은 총 " + Money + "원 입니다");
        System.out.println("\n떡볶이,우동,과자의 가격을 각각 적어주세요");
        int Food = sc.nextInt(); //떡볶이
        int Food2 = sc.nextInt(); //우동
        int Food3 = sc.nextInt(); //과자

        if (count == 0) {
            System.out.println("\n떡볶이를 몇개 주문하시겠습니까?");
            int FoodNumber = sc.nextInt();
            int TotalPrice = (Food * FoodNumber);

            if (TotalPrice > Money) {
                System.out.println("" + (TotalPrice - Money) + "원 부족합니다 추가 용돈을 적어주세요");
                int PlusMoney = sc.nextInt();
                if ((Money + PlusMoney) < TotalPrice) {
                    System.out.println("용돈을 받아도 부족하기 때문에 프로그램을 종료합니다");
                    return;
                }
                System.out.println("" + PlusMoney + "원을 받아 총 " + ((Money + PlusMoney) - TotalPrice) + "원이 되었습니다");
                Money += (PlusMoney - TotalPrice);
                count = 1;
            }
            if (count == 0) {
                System.out.println("떡볶이를 주문하고 남은금액은 " + (Money - TotalPrice) + "원입니다");
                Money -= TotalPrice;
            }
            System.out.println("\n우동을 몇개 주문하시겠습니까?");
            int FoodNumber2 = sc.nextInt();
            int TotalPrice2 = (Food2 * FoodNumber2);

            if (count != 0) {
                if (TotalPrice2 > Money) {
                    System.out.println("용돈을 추가적으로 받았기 때문에 프로그램을 종료합니다");
                    return;
                } else if (TotalPrice2 < Money) {
                    System.out.println("우동을 주문하고 남은금액은 " + (Money - TotalPrice2) + "원입니다");
                    Money -= TotalPrice2;
                }
            }
            if (count == 0) {
                if (TotalPrice2 > Money) {
                    System.out.println("" + (TotalPrice2 - Money) + "원 부족합니다 추가 용돈을 적어주세요");
                    int PlusMoney = sc.nextInt();
                    if ((Money + PlusMoney) < TotalPrice2) {
                        System.out.println("용돈을 받아도 부족하기 때문에 프로그램을 종료합니다");
                        return;
                    }
                    System.out.println("" + PlusMoney + "원을 받아 총 " + ((Money + PlusMoney) - TotalPrice2) + "원이 되었습니다");
                    Money += (PlusMoney - TotalPrice2);
                    count = 1;
                }
            }
            if (count == 0) {
                System.out.println("우동을 주문하고 남은금액은 " + (Money - TotalPrice2) + "원입니다");
                Money -= TotalPrice2;
            }
            System.out.println("\n과자를 몇개 주문하시겠습니까?");
            int FoodNumber3 = sc.nextInt();
            int TotalPrice3 = (Food3 * FoodNumber3);

            if (count != 0) {
                if (TotalPrice3 > Money) {
                    System.out.println("용돈을 추가적으로 받았기 때문에 프로그램을 종료합니다");
                    return;
                } else if (TotalPrice3 < Money) {
                    System.out.println("과자를 주문하고 남은금액은 " + (Money - TotalPrice3) + "원입니다");
                    Money -= TotalPrice3;
                }
            }
            if (count == 0) {
                if (TotalPrice3 > Money) {
                    System.out.println("" + (TotalPrice3 - Money) + "원 부족합니다 추가 용돈을 적어주세요");
                    int PlusMoney = sc.nextInt();
                    if ((Money + PlusMoney) < TotalPrice3) {
                        System.out.println("용돈을 받아도 부족하기 때문에 프로그램을 종료합니다");
                        return;
                    }
                    System.out.println("" + PlusMoney + "원을 받아 총 " + ((Money + PlusMoney) - TotalPrice3) + "원이 되었습니다");
                    return;
                }
            }
            if (count == 0) {
                System.out.println("과자를 주문하고 남은금액은 " + (Money - TotalPrice3) + "원입니다");
            }
        }
    }
}
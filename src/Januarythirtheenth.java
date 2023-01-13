import java.util.Scanner;

public class Januarythirtheenth {
    public static void main(String[] args) { //종료

    }
    public static int main() { //변수보관
        int Twodan = 2;
        int FoodPriceSum = 0;
        int RetryCount = 0;
        int CalculatorSum = 0;
        return MenuSelect(Twodan,FoodPriceSum,RetryCount,CalculatorSum);
    }
    public static int MenuSelect (int Twodan,int FoodPriceSum,int RetryCount,int CalculatorSum) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.구구단 \n2.음식점 \n3.계산기 \n4.종료");
            int Select = sc.nextInt();

            if (Select == 1) {
                return Gugudan(Twodan,FoodPriceSum,RetryCount,CalculatorSum);
            } else if (Select == 2) {
                return Restaurant(Twodan,FoodPriceSum,RetryCount,CalculatorSum);
            } else if (Select == 3) {
                return Calculator(Twodan,FoodPriceSum,RetryCount,CalculatorSum);
            } else if (Select == 4) {
                System.out.println("총 금액은 "+FoodPriceSum+"원 입니다");
                return 0;
            } else {
                System.out.println();
            }
        }
    }
    public static int Gugudan(int Twodan,int FoodPriceSum,int RetryCount,int CalculatorSum) {
        while (Twodan <= 9) {
            System.out.println(""+2+" X "+Twodan+" = "+(2 * Twodan)+"");
            Twodan++;
        }
        return MenuSelect(Twodan,FoodPriceSum,RetryCount,CalculatorSum);
    }
    public static int  Restaurant(int Twodan,int FoodPriceSum,int RetryCount,int CalculatorSum) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.볶음밥[7,000원] \n2.짜장면[6,000원] \n3.탕수육 \n4.종료");
            int FoodSelect = sc.nextInt();

            if (FoodSelect == 1) {
                return Rice(Twodan,FoodPriceSum,RetryCount,CalculatorSum);
            } else if (FoodSelect == 2) {
                return Noodle(Twodan,FoodPriceSum,RetryCount,CalculatorSum);
            } else if (FoodSelect == 3) {
               return Splash(Twodan,FoodPriceSum,RetryCount,CalculatorSum);
            } else if (FoodSelect == 4) {
                return MenuSelect(Twodan,FoodPriceSum,RetryCount,CalculatorSum);
            } else {
                System.out.println();
            }
        }
    }
    public static int Rice (int Twodan,int FoodPriceSum,int RetryCount,int CalculatorSum) { //볶음밥
        if (RetryCount == 0) {
            FoodPriceSum += 7000;
            System.out.println("볶음밥을 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
        } else {
            System.out.println("볶음밥을 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
        }
        return Restaurant(Twodan, FoodPriceSum, RetryCount,CalculatorSum);
    }
    public static int Noodle (int Twodan,int FoodPriceSum,int RetryCount,int CalculatorSum) { //짜장면
        if (RetryCount == 0) {
            FoodPriceSum += 6000;
            System.out.println("짜장면을 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
        } else {
            System.out.println("짜장면을 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
        }
        return Restaurant(Twodan, FoodPriceSum, RetryCount,CalculatorSum);
    }
    public static int Splash (int Twodan,int FoodPriceSum,int RetryCount,int CalculatorSum) { //탕수욕
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.대[21,000]원 \n2.중[18,000]원 \n3.소[15,000]원 \n4.이전");
            int SizeSelect = sc.nextInt();

            if (SizeSelect <= 0 || SizeSelect >= 5) {
                System.out.println();
            }
            if (RetryCount == 0) {
                if (SizeSelect == 1) {
                    FoodPriceSum += 21000;
                    RetryCount += 1;
                    System.out.println("탕수육 대를 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
                    return Restaurant(Twodan, FoodPriceSum, RetryCount,CalculatorSum);
                }
                if (SizeSelect == 2) {
                    FoodPriceSum += 18000;
                    RetryCount += 1;
                    System.out.println("탕수육 중을 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
                    return Restaurant(Twodan, FoodPriceSum, RetryCount,CalculatorSum);
                }
                if (SizeSelect == 3) {
                    FoodPriceSum += 15000;
                    RetryCount += 1;
                    System.out.println("탕수육 소를 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
                    return Restaurant(Twodan, FoodPriceSum, RetryCount,CalculatorSum);
                }
            } else {
                if (SizeSelect == 1) {
                    System.out.println("탕수육 대를 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
                } else if (SizeSelect == 2) {
                    System.out.println("탕수육 중을 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
                } else if (SizeSelect == 3) {
                    System.out.println("탕수육 소를 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
                } else {
                    return Restaurant(Twodan, FoodPriceSum, RetryCount,CalculatorSum);
                }
                return Restaurant(Twodan, FoodPriceSum, RetryCount,CalculatorSum);
            }
            if (SizeSelect == 4) {
                return Restaurant(Twodan, FoodPriceSum, RetryCount,CalculatorSum);
            }
        }
    }
    public static int Calculator(int Twodan,int FoodPriceSum,int RetryCount,int CalculatorSum) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.더하기  2.빼기");
            int CalculatorMenuSelect = sc.nextInt();

            if (CalculatorMenuSelect == 1) {
                return Plus(Twodan,FoodPriceSum,RetryCount,CalculatorSum);
            } else if (CalculatorMenuSelect == 2) {
                return Minus(Twodan,FoodPriceSum,RetryCount,CalculatorSum);
            } else {
                System.out.println();
            }
        }
    }
    public static int Plus (int Twodan,int FoodPriceSum,int RetryCount,int CalculatorSum) {
        Scanner sc = new Scanner(System.in);
        System.out.println("더하고싶은 2개의 수를 각각 입력하세요");
        int Number = sc.nextInt();
        int Number2 = sc.nextInt();
        System.out.println(""+Number+" + "+Number2+" = "+(Number + Number2)+"");
        CalculatorSum += (Number + Number2);
        return Calculator(Twodan,FoodPriceSum,RetryCount,CalculatorSum);
    }
    public static int Minus (int Twodan,int FoodPriceSum,int RetryCount,int CalculatorSum) {
        Scanner sc = new Scanner(System.in);
        System.out.println("값을 입력하세요");

    }
}

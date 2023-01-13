import java.util.Scanner;

public class Januarythirtheenth {
    public static void main(String[] args) {
        System.out.println("총 금액은 "+main()+"원 입니다");
    }
    public static int main() { //변수보관
        int FoodPriceSum = 0;
        int CalculatorSum = 0;
        int RetryCount = 0;
        int CalculatorCount = 0;
        return MenuSelect(FoodPriceSum,RetryCount,CalculatorSum,CalculatorCount);
    }
    public static int MenuSelect (int FoodPriceSum,int RetryCount,int CalculatorSum,int CalculatorCount) {
        Scanner sc = new Scanner(System.in);
        int Twodan = 1;
        System.out.println("1.구구단 \n2.음식점 \n3.계산기 \n4.종료");
        int Select = sc.nextInt();

        if (Select == 1) {
            return Gugudan(Twodan,FoodPriceSum, RetryCount, CalculatorSum, CalculatorCount);
        } else if (Select == 2) {
            return Restaurant(FoodPriceSum, RetryCount, CalculatorSum, CalculatorCount);
        } else if (Select == 3) {
            return Calculator(FoodPriceSum, RetryCount, CalculatorSum, CalculatorCount);
        } else if (Select == 4) {
            return FoodPriceSum;
        } else {
            return MenuSelect(FoodPriceSum, RetryCount, CalculatorSum, CalculatorCount);
        }
    }
    public static int Gugudan(int Twodan,int FoodPriceSum,int RetryCount,int CalculatorSum,int CalculatorCount) {
        while (Twodan <= 9) {
            System.out.println(""+2+" X "+Twodan+" = "+(2 * Twodan)+"");
            Twodan++;
        }
        return MenuSelect(FoodPriceSum,RetryCount,CalculatorSum,CalculatorCount);
    }
    public static int  Restaurant(int FoodPriceSum,int RetryCount,int CalculatorSum,int CalculatorCount) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.볶음밥[7,000원] \n2.짜장면[6,000원] \n3.탕수육 \n4.종료");
            int FoodSelect = sc.nextInt();

            if (FoodSelect == 1) {
                return Rice(FoodPriceSum,RetryCount,CalculatorSum,CalculatorCount);
            } else if (FoodSelect == 2) {
                return Noodle(FoodPriceSum,RetryCount,CalculatorSum,CalculatorCount);
            } else if (FoodSelect == 3) {
                return Splash(FoodPriceSum,RetryCount,CalculatorSum,CalculatorCount);
            } else if (FoodSelect == 4) {
                if (FoodPriceSum > 0) {
                    RetryCount += 1;
                }
                return MenuSelect(FoodPriceSum,RetryCount,CalculatorSum,CalculatorCount);
            } else {
                System.out.println();
            }
        }
    }
    public static int Rice (int FoodPriceSum,int RetryCount,int CalculatorSum,int CalculatorCount) { //볶음밥
        if (RetryCount == 0) {
            FoodPriceSum += 7000;
            System.out.println("볶음밥을 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
        } else {
            System.out.println("볶음밥을 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
        }
        return Restaurant(FoodPriceSum, RetryCount,CalculatorSum,CalculatorCount);
    }
    public static int Noodle (int FoodPriceSum,int RetryCount,int CalculatorSum,int CalculatorCount) { //짜장면
        if (RetryCount == 0) {
            FoodPriceSum += 6000;
            System.out.println("짜장면을 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
        } else {
            System.out.println("짜장면을 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
        }
        return Restaurant(FoodPriceSum, RetryCount,CalculatorSum,CalculatorCount);
    }
    public static int Splash (int FoodPriceSum,int RetryCount,int CalculatorSum,int CalculatorCount) { //탕수욕
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
                    System.out.println("탕수육 대를 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
                    return Restaurant(FoodPriceSum, RetryCount,CalculatorSum,CalculatorCount);
                }
                if (SizeSelect == 2) {
                    FoodPriceSum += 18000;
                    System.out.println("탕수육 중을 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
                    return Restaurant(FoodPriceSum, RetryCount,CalculatorSum,CalculatorCount);
                }
                if (SizeSelect == 3) {
                    FoodPriceSum += 15000;
                    System.out.println("탕수육 소를 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
                    return Restaurant(FoodPriceSum, RetryCount,CalculatorSum,CalculatorCount);
                }
            } else {
                if (SizeSelect == 1) {
                    System.out.println("탕수육 대를 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
                } else if (SizeSelect == 2) {
                    System.out.println("탕수육 중을 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
                } else if (SizeSelect == 3) {
                    System.out.println("탕수육 소를 주문하여 현재 누적금액은 " + FoodPriceSum + "원 입니다");
                } else {
                    return Restaurant(FoodPriceSum, RetryCount,CalculatorSum,CalculatorCount);
                }
                return Restaurant(FoodPriceSum, RetryCount,CalculatorSum,CalculatorCount);
            }
            if (SizeSelect == 4) {
                return Restaurant(FoodPriceSum, RetryCount,CalculatorSum,CalculatorCount);
            }
        }
    }
    public static int Calculator(int FoodPriceSum,int RetryCount,int CalculatorSum,int CalculatorCount) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.더하기  2.빼기");
            int CalculatorMenuSelect = sc.nextInt();

            if (CalculatorMenuSelect == 1) {
                return Plus(FoodPriceSum,RetryCount,CalculatorSum,CalculatorCount);
            } else if (CalculatorMenuSelect == 2) {
                return Minus(FoodPriceSum,RetryCount,CalculatorSum,CalculatorCount);
            } else {
                System.out.println();
            }
        }
    }
    public static int Plus (int FoodPriceSum,int RetryCount,int CalculatorSum,int CalculatorCount) {
        Scanner sc = new Scanner(System.in);
        if (CalculatorCount == 0) {
            System.out.println("더하고싶은 2개의 수를 각각 입력하세요");
            int Number = sc.nextInt();
            int Number2 = sc.nextInt();
            System.out.println("" + Number + " + " + Number2 + " = " + (Number + Number2) + "");
            CalculatorSum += (Number + Number2);
            CalculatorCount += 1;
        } else {
            System.out.println("값을 입력하세요");
            int Plus = sc.nextInt();
            System.out.println("" + CalculatorSum + " + " + Plus + " = " + (CalculatorSum + Plus) + "");
            CalculatorSum += Plus;
        }
        return MenuSelect(FoodPriceSum, RetryCount, CalculatorSum,CalculatorCount);
    }
    public static int Minus (int FoodPriceSum,int RetryCount,int CalculatorSum,int CalculatorCount) {
        Scanner sc = new Scanner(System.in);
        if (CalculatorCount == 0) {
            System.out.println("빼고싶은 2개의 수를 각각 입력하세요");
            int Number = sc.nextInt();
            int Number2 = sc.nextInt();

            if (Number < Number2) {
                System.out.println("두 번째 값이 더 클 수 없습니다");
            } else {
                System.out.println("" + Number + " - " + Number2 + " = " + (Number - Number2) + "");
                CalculatorSum += (Number + Number2);
                CalculatorCount += 1;
            }
        } else {
            System.out.println("값을 입력하세요");
            int Minus = sc.nextInt();
            System.out.println("" + CalculatorSum + " - " + Minus + " = " + (CalculatorSum - Minus) + "");
            CalculatorSum -= Minus;
        }
        return MenuSelect(FoodPriceSum, RetryCount, CalculatorSum,CalculatorCount);
    }
}

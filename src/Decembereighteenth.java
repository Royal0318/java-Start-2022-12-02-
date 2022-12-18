/*
4명의 이름과 점수를 각각받아 서로대조하는 코드를 만드시오
단! 반복문과 if문만사용한다
 */


import java.util.Scanner;
public class Decembereighteenth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("4명의 이름을 각각 적어주세요");
        String People = sc.next();
        String People2 = sc.next();
        String People3 = sc.next();
        String People4 = sc.next();

        System.out.println("4명의 점수를 각각 적어주세요");
        int num = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int num4 = sc.nextInt();

        System.out.println("\n" + People + "의 점수는" + num + "점이고\n" + People2 + "의 점수는" + num2 + "이며\n" + People3 + "의 점수는" + num3 + "이며\n" + People4 + "의 점수는" + num4 + "점 입니다");

        System.out.println("\n1." + People + "\n2." + People2 + "\n3." + People3 + "\n4." + People4 + "\n5.종료");



        while (true) {
            System.out.println("대조 할 2명을 골라주세요");
            int answer = sc.nextInt();
            int answer2 = sc.nextInt();

            if (answer == 1 && answer2 == 2) {
                if (num > num2) {
                    System.out.println("" + People + "가" + People2 + "보다 더 큽니다!");
                    //1이 2보다 큰경우
                } else if (num < num2) { //1이 2보다 작은경우
                    System.out.println("" + People2 + "가" + People + "보다 더 큽니다!");

                } else {
                    System.out.println("둘이 값이 동일합니다");

                }
            }
            if (answer == 1 && answer2 == 3) {
                if (num > num3) {
                    System.out.println("" + People + "가" + People3 + "보다 더 큽니다!");
                    //1이 3보다 큰경우
                } else if (num < num3) { //1이 3보다 작은경우
                    System.out.println("" + People3 + "가" + People + "보다 더 큽니다!");

                } else {
                    System.out.println("둘이 값이 동일합니다");

                }
            }
            if (answer == 1 && answer2 == 4) {
                if (num > num4) {
                    System.out.println("" + People + "가" + People4 + "보다 더 큽니다!");
                    //1이 4보다 큰경우
                } else if (num < num4) { //1이 4보다 작은경우
                    System.out.println("" + People4 + "가" + People + "보다 더 큽니다!");

                } else {
                    System.out.println("둘이 값이 동일합니다");

                }
            }
            if (answer == 2 && answer2 == 1) {
                if (num2 > num) {
                    System.out.println("" + People2 + "가" + People + "보다 더 큽니다!");
                    //2이 1보다 큰경우
                } else if (num2 < num) { //2이 1보다 작은경우
                    System.out.println("" + People + "가" + People2 + "보다 더 큽니다!");
                } else {
                    System.out.println("둘이 값이 동일합니다");
                }
            }
            if (answer == 2 && answer2 == 3) {
                if (num2 > num3) {
                    System.out.println("" + People2 + "가" + People3 + "보다 더 큽니다!");
                    //2이 3보다 큰경우
                } else if (num2 < num3) { //2이 3보다 작은경우
                    System.out.println("" + People3 + "가" + People2 + "보다 더 큽니다!");
                } else {
                    System.out.println("둘이 값이 동일합니다");
                }
            }
            if (answer == 2 && answer2 == 4) {
                if (num2 > num4) {
                    System.out.println("" + People2 + "가" + People4 + "보다 더 큽니다!");
                    //2이 4보다 큰경우
                } else if (num2 < num4) { //2이 4보다 작은경우
                    System.out.println("" + People4 + "가" + People2 + "보다 더 큽니다!");
                } else {
                    System.out.println("둘이 값이 동일합니다");
                }
            }
            if (answer == 3 && answer2 == 1) {
                if (num3 > num) {
                    System.out.println("" + People3 + "가" + People + "보다 더 큽니다!");
                    //3이 1보다 큰경우
                } else if (num3 < num) { //3이 1보다 작은경우
                    System.out.println("" + People + "가" + People3 + "보다 더 큽니다!");
                } else {
                    System.out.println("둘이 값이 동일합니다");
                }
            }
            if (answer == 3 && answer2 == 2) {
                if (num3 > num2) {
                    System.out.println("" + People3 + "가" + People2 + "보다 더 큽니다!");
                    //3이 2보다 큰경우
                } else if (num3 < num2) { //3이 2보다 작은경우
                    System.out.println("" + People2 + "가" + People3 + "보다 더 큽니다!");
                } else {
                    System.out.println("둘이 값이 동일합니다");
                }
            }
            if (answer == 3 && answer2 == 4) {
                if (num3 > num4) {
                    System.out.println("" + People3 + "가" + People4 + "보다 더 큽니다!");
                    //3이 4보다 큰경우
                } else if (num3 < num4) { //3이 2보다 작은경우
                    System.out.println("" + People4 + "가" + People3 + "보다 더 큽니다!");
                } else {
                    System.out.println("둘이 값이 동일합니다");
                }
            }
            if (answer == 4 && answer2 == 1) {
                if (num4 > num) {
                    System.out.println("" + People4 + "가" + People + "보다 더 큽니다!");
                    //4가 1보다 큰경우
                } else if (num4 < num) { //4가 1보다 작은경우
                    System.out.println("" + People + "가" + People4 + "보다 더 큽니다!");
                } else {
                    System.out.println("둘이 값이 동일합니다");
                }
            }
            if (answer == 4 && answer2 == 2) {
                if (num4 > num2) {
                    System.out.println("" + People4 + "가" + People2 + "보다 더 큽니다!");
                    //4가 2보다 큰경우
                } else if (num4 < num2) { //4가 2보다 작은경우
                    System.out.println("" + People2 + "가" + People4 + "보다 더 큽니다!");
                } else {
                    System.out.println("둘이 값이 동일합니다");
                }
            }
            if (answer == 4 && answer2 == 3) {
                if (num4 > num3) {
                    System.out.println("" + People4 + "가" + People3 + "보다 더 큽니다!");
                    //4가 3보다 큰경우
                } else if (num4 < num3) { //4가 3보다 작은경우
                    System.out.println("" + People3 + "가" + People4 + "보다 더 큽니다!");
                } else {
                    System.out.println("둘이 값이 동일합니다");
                }
            }
            if (answer == 1 && answer2 == 1 || answer == 2 && answer2 == 2 || answer == 3 && answer2 == 3 || answer == 4 && answer2 == 4) {
                System.out.println("서로 같은 사람은 비교 할 수 없습니다");
            } else if (answer == 1 && answer2 == 5 || answer == 2 && answer2 == 5 || answer == 3 && answer2 == 5 || answer == 4 && answer2 == 5 || answer == 5 && answer2 == 1 || answer == 5 && answer2 == 2 || answer == 5 && answer2 == 3 || answer == 5 && answer2 == 4) {
                System.out.println("잘못된 입력입니다! 다시해주세요!");
            } else if (answer == 5 && answer2 == 5) {
                System.out.println("시스템을 종료합니다");
                break;
            }
        }
    }
}

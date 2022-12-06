/*
if와 else if의 두번째 시간이다 이번에는 if와 else if를 활용하여 체중과 키만 입력하면 자동으로 bmi값을 도출하는
코드를 만들었다 여기에서 새로 도입되는 개념이 double이라는 개념인데 일반적으로 사용하는 int값은 정수값 즉 - 1, 1, 0 이 아닌
실수값 0.1, 0.002값까지 입력 받을 수 있기때문에 소숫점까지 사용해야하는 문제에 사용하면 요긴하게 쓸 수 있다
그리고 추가적으로 주의해야 할 것이 입력받을때는 cm이지만 bmi계산식은 m로 환산해야 하기 때문에 잘 환산 해야한다.
double a = sc.nextDouble(); : 173.6 입력가능
int a = sc.nextint(); : 173까지만 가능 173.6불가능
double과 같은 개념인 float라는 개념도 존재한다
float a = sc.nextFloat();로 입력을 받으면 되고
입력을 받지않고 나타낼시
double a = 173.3D;
float a = 173.3F; 로 적어주면 된다

문)키(cm)와 체중(kg)를 입력받고
bmi가 30이상은 고도비만
24이상 30미만은 비만
22이상 24미만은 과체중
18.5이상 22미만은 정상
18.5미만은 저체중
이라는 bmi지수를 이용하여 결과값이 도출되도록 코드를 작성하라
bmi계산식  = 체중/키(m) * 키(m)
*/

import java.util.Scanner;
public class Decemberfifth {
    public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    double bmi = 0;

    System.out.println("키(cm)를 입력하세요.");
    double height = sc.nextDouble();
    System.out.println("체중(kg)을 입력하세요.");
    int weight = sc.nextInt();

    //bmi계산식 (체중/키(m) * 키(m))
    bmi = (weight/((height * height)/10000));

    if (bmi >= 30) {
        System.out.println("bmi는 "+bmi+"이며 고도비만입니다.");
    } else if (bmi >= 24 && bmi <= 29) {
        System.out.println("bmi는 "+bmi+"이며 비만입니다.");
    } else if (bmi >= 22 && bmi <= 24) {
        System.out.println("bmi는 "+bmi+"이며 과체중입니다.");
    } else if (bmi >= 18.5 && bmi <= 22) {
        System.out.println("bmi는 "+bmi+"이며 정상입니다.");
    } else {
        System.out.println("bmi는 "+bmi+"이며 저체중입니다");
    }
    }
}

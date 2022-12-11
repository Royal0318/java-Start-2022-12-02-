/*
문) while문을 이용하여 0 부터 1000까지 10씩 증가 후 다시 1000에서 500까지 10씩 떨어지는 연속되는 코드를 만드시오
예) 0 ~ 200
   200 ~ 100
   끝
 */
public class Decemberteenth2 {
    public static void main(String[] args) {
        int f = 0;

        while (f <= 1000) {
            System.out.println("" + f + "");
            f = f + 10;
        }
        while (f > 500) {
            f = f - 10;
            System.out.println("" + f + "");
        }
    }
}

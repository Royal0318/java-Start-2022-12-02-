/*
기본적으로 0의 숫자를 가지고 있는 f가 있다.
f는 10씩 증가하며, 총 1000까지만 늘어난다
그 다음, f가 0까지 다시 10씩 떨어지는 상황을
출력하시오.
 */
public class forwhile6 {
    public static void main(String[] args) {
        int Start = 0;

        while (Start < 1000) {
            System.out.println(""+Start+"");
            Start += 10;
        }
        //1000까지는 도달하지 않고 990에서 마지막으로 10을받아서 1000을출력후 다시 내려감
        while (Start >= 0) {
            System.out.println(""+Start+"");
            Start -= 10;
        }
    }
}
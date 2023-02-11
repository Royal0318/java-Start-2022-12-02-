
public class forwhile7 {
    public static void main(String[] args) {
        for (int i = 0;i < 1000;i+=10) {
            //0부터 시작하여 990까지 10씩 증가
            System.out.println(""+i+"");
        }
        for (int i = 1000;i >= 0;i-=10) {
            //1000부터 시작하여 0까지 10씩 감소
            System.out.println(""+i+"");
        }
    }
}
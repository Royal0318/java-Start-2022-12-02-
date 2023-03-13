import java.util.Scanner;
public class Question1526 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int check = 0;
        //str.length와 check가 같으면은 7과4가 모두포함되어있다는뜻

        for (int i = 1; i <= n; i++) {
            String str = "" + i + "";
            //처음에 i를 가지고 조건을 찾는다
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '7' || str.charAt(j) == '4') {
                    check += 1;
                    if (str.length() == check) {
                        max = i;
                    }
                }
            }
            /*
            만약에 i의 각 index번호에 7과 4가 존재시 check변수가 올라간다 check변수와 length와같은경우
            그값은 7과4가 모두존재하는다는 의미이기 때문에 해당값을 max변수에 대입한다
             */
            check = 0;
        }
        System.out.println("" + max + "");
    }
}

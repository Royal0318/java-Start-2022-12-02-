import java.util.Scanner;

public class Question25501 {
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        //testcase를 입력

        for (int i = 0; i < testCase;i++) {
            result = 0;
            System.out.println(isPalindrome(sc.next()) + " " + result);
            //포문으로 진입하여 sc.next로 String값을 받음
        }
    }
    public static int isPalindrome (String s) {
        return recursion(s, 0, s.length()-1);
        //만약에 String입력을 ABBA라고 가정할때 넘겨주는 값은 (ABBC,0,ABBA의 인덱스4 - 1 해서 3을넘김)
    }
    public static int recursion (String s, int l, int r){
        /*
        처음에는 l이 0이고 r이 3이고 l은 ABBA의 가장 앞쪽A부터 시작 r은 가장 뒤쪽부터 시작하여
         else부터 돈다 만약에 l과 r의 문자값이 다른경우에는 else if가 발동하여 0을 리턴
         모두같다고 판단하였을경우 1을 리턴한다

         여기서 주의할점이
  System.out.println(isPalindrome(sc.next()+" "+result+""));
  System.out.println(isPalindrome(sc.next()) + " " + result);
  이 2개의 출력이 각각 다르게 나오는데 그 이유는
         */
        result += 1;
        if(l >= r) {
            return 1;
        } else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        } else {
            return recursion(s, l+1, r-1);
        }
    }
}

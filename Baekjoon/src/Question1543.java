import java.util.Scanner;

public class Question1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String find = sc.nextLine();

        int result = 0;
        int findLength = find.length();

        String str = ""+a+"";
        String str2 = ""+find+"";
        for (int i = 0 ; i <= (a.length()-find.length());i++) {
            System.out.println(i);
            int count = 0;

            for (int j = 0 ; j < find.length();j++) {
                if (str.charAt(j + i) != str2.charAt(j)) {
                    //일일히 find의 문자열을 이동시킬 필요가없다 a의 각각의문자열을 str2의 위치그대로랑 비교하면된다
                    //a의 문자열은 (j + i)즉 인덱스번호만 지정되고 str2의 가장처음인덱스랑 계속 비교하며 나아간다
                    break;
                } else {
                    count += 1;
                    //두개의 문자열이 같은경우에는 count에 1을 추가
                }
            }
            if (count == findLength) {
                //find의 length가 count와 같다는뜻은 a의문자열이find와 모두 같다는 의미와같으므로 이제 중복되지않도록 다음으로 옮겨야하는데
                //만약에 a가 = aaaaa이고 find가 aa라면 index 0과 1을비교했으니 2부터 시작해야하므로
                //i값은 1바퀴돌면 1이되므로 거기에 1개를 추가해 2부터 돌도록하기위해 str2.length-1을 준것
                result += 1;
                i += str2.length()-1;
            }
        }
        System.out.println(result);
    }
}

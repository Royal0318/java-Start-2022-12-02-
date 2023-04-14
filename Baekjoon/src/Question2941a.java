import java.util.Scanner;

public class Question2941a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String[] str2 = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        for (String s : str2) {
            if (str.contains(s)) { //str2[i]에들은것을 검사
                str = str.replace(s, " ");
            }
        }
        System.out.println(str.length());
    }
}
/*
String배열에 문자열을 입력한후 for문을 통해서 검사한다
for문이 str2배열을 돌면서 str에 str2의문자가 존재하는지 검사한다
만약에 존재하는경우 str에존재하는 해당문자열은 공백처리를하고 나중에 str길이만큼 출력한다
 */
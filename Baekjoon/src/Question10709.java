import java.util.Scanner;

public class Question10709 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        char[][] arr = new char[a][b];
        int[][] result = new int[a][b];

        for (int i = 0; i < a;i++) {
            int time = 0;
            boolean check = false;
            String str = sc.next(); //a의 개수만큼 입력

            for (int j = 0; j < b; j++) {
                arr[i][j] = str.charAt(j); //한개씩 쪼개면서 배열에 넣는다
                if (arr[i][j] == 'c') { //만약에 넣은값이 구름이라면
                    if (check) { //구름인데 true인것은뒤에 구름이 한번이상 나왔다는 증거
                        time = 0;
                    } else { //false는 한번도 구름이 나오지않았기때문에 true로 전환
                        check = true;
                    }
                    result[i][j] = 0; //구름은 무조건 0으로 배치하기때문에 if던 else if던 동일
                }
                else if (arr[i][j] == '.') {
                    if (!check) { //false가나온것은 구름이 한번도나오지않았기때문에 그 앞에값들은 시간이지나도 계속 -1이다
                        result[i][j] = -1;
                    }
                    else { //앞에 구름이 이미나왔으므로 1분마다 구름이 몇분걸리는지 체크
                        time += 1;
                        result[i][j] = time;
                    }
                }
            }
        }
        for (int i = 0; i < a;i++) {
            for (int j = 0; j < b;j++) {
                if (j == b - 1) {
                    sb.append(result[i][j]);
                } else {
                    sb.append(result[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

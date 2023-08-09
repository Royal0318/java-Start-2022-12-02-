import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Question28256 {
    static int[] X = {-1,0,1,0};
    static int[] Y = {0,1,0,-1};
    static char[][] arr;
    static boolean[][] check;
    static int recursiveCount = 0;
    static ArrayList<Integer> arrayList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            int count = 0;
            boolean xCheck = false;
            arrayList = new ArrayList<>();
            arr = new char[3][3];
            check = new boolean[3][3];

            for (int j = 0; j < 3; j++) {
                String str = br.readLine();
                for (int k = 0; k < 3; k++) {
                    arr[j][k] = str.charAt(k);
                    if (arr[j][k] == 'O') { //O가하나라도 존재하는지 체크
                        xCheck = true;
                    }
                }
            }

            String str = br.readLine();
            String[] cut = str.split(" ");

            if (Integer.parseInt(cut[0]) == 0 && xCheck) { //반례를 위해 처음 N값이 0이라면 0이출력되야한다
                sb.append(0).append("\n");
            }
            else if (Integer.parseInt(cut[0]) == 0 && !xCheck) { //두번째반례 : 모두 X인 상태에서 0을 입력하면 맞는답이므로 1이 출력되야한다
                sb.append(1).append("\n");
            }
            else {
                for (int j = 1; j <= Integer.parseInt(cut[0]); j++) {
                    arrayList.add(Integer.parseInt(cut[j])); //나머지 a(n)을 Arraylist에 저장
                }

                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (arr[j][k] == 'O' && !check[j][k]) {
                            dfs(j, k); //dfs를 통해 재귀를돔
                            count += 1; //전체 o이 몇개가 뭉쳐져있는지 체크하는 변수

                            for (int l = 0; l < arrayList.size(); l++) {
                                if (arrayList.get(l) == recursiveCount) { //리스트에 담긴 a(n)중에 재귀를돌면서 체크한 O의 개수와 일치하는 부분이 존재하는지 확인한다
                                    arrayList.remove(l); //만약에 존재한다면 리스트의 값을 삭제하고 탈출
                                    break;
                                }
                            }
                            recursiveCount = 0; //다음 dfs를위하여 초기화
                        }
                    }
                }
                if (arrayList.size() == 0 && Integer.parseInt(cut[0]) == count) sb.append(1).append("\n"); //다음 테스트케이스를 확인하기위함
                //만약에 리스트의 사이즈가 0이아니라는것은 a(n)의 값이 맞지 않아서 남아있다는 뜻 그리고 N의 사이즈와 count즉 O의 개수가 일치하는지 확인해야한다
                //예를들어 count개수보다 N이 크거나 작은경우는 무조건 0이 출력되야한다
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb); //정답출력
    }
    public static void dfs (int a,int b) {
        recursiveCount += 1; //재귀를 돔 (O카운트 시작)
        check[a][b] = true;

        for (int i = 0 ; i < 4;i++) {
            int one = a + X[i];
            int two = b + Y[i];

            if (one >= 0 && two >= 0 && one < 3 && two < 3 && !check[one][two] && arr[one][two] == 'O') {
                //범위를 벗어나지 않으면서 방문하지 않은경우 && O만 재귀를 돔
                dfs(one, two);
            }
        }
    }
}


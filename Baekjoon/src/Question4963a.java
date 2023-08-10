
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question4963a {
    static int[][] arr;
    static boolean[][] check;
    static int[] X = {-1,-1,-1,0,1,1,1,0};
    static int[] Y = {-1,0,1,1,1,0,-1,-1};
    static int count = 0;
    static int h;
    static int w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken()); //높이
            w = Integer.parseInt(st.nextToken()); //너비

            if (w == 0 && h == 0) {
                System.out.println(sb);
                return;
            }
            else if (h == 0) {
                sb.append(0).append("\n");
            }
            else {
                arr = new int[w + 1][h + 1];
                check = new boolean[w + 1][h + 1];

                for (int i = 0 ; i < w;i++) {
                    String str = br.readLine();
                    String[] cut = str.split(" ");

                    for (int j = 0 ; j < h;j++) {
                        arr[i][j] = Integer.parseInt(cut[j]);
                    }
                }
                for (int i = 0 ; i < w;i++) {
                    for (int j = 0 ; j < h;j++) {
                        if (arr[i][j] == 1 && !check[i][j]) {
                            bfs(i,j);
                        }
                    }
                }
                sb.append(count).append("\n");
                count = 0;
            }
        }
    }
    public static void bfs (int a,int b) {
        count += 1;
        Queue<Point> queue = new LinkedList<>();
        check[a][b] = true;
        queue.add(new Point(a,b));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0 ; i < 8;i++) {
                int one = point.x + X[i];
                int two = point.y + Y[i];

                if (one < 0 || two < 0) continue;

                if (arr[one][two] == 0 || check[one][two]) continue;

                check[one][two] = true;
                queue.add(new Point(one,two));
            }
        }
    }
}

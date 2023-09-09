import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question5800 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int classNumber = 1;

        for (int i = 0 ; i < testCase;i++) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            int gap = 0;

            String str = br.readLine();
            String[] cut = str.split(" ");


            int[] arr = new int[Integer.parseInt(cut[0]) + 1];

            for (int j = 1 ; j <= Integer.parseInt(cut[0]);j++) {
                arr[j] = Integer.parseInt(cut[j]);

                if (max < arr[j]) max = arr[j]; //max
                if (min > arr[j]) min = arr[j]; //min
            }
            Arrays.sort(arr);

            for (int j = Integer.parseInt(cut[0]);j > 1;j--) {
                if ((arr[j] - arr[j - 1]) > gap) gap = (arr[j] - arr[j - 1]);
            }

            sb.append("Class "+classNumber+"\n").append("Max "+max+", Min "+min+", Largest gap "+gap+"\n");
            classNumber ++;
        }
        System.out.println(sb);
    }
}

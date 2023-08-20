import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question2870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        ArrayList<String> arr = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");

        for (int i = 0 ; i < testCase;i++) {
            String str = br.readLine();
            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) { //matcher.find로 존재하면 true이다
                String num = matcher.group().replaceAll("^0+", ""); //0을발견시 공백으로채움
                if (num.length() == 0) arr.add("0");
                else arr.add(num);
            }
        }
        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                else {
                    return o1.length() - o2.length();
                }
            }
        });
        for (String s : arr) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}

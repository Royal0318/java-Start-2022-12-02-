import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Question16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> groupName = new ArrayList<>();
        LinkedHashMap<String,Integer> memberName = new LinkedHashMap<>();

        for (int i = 0; i < N;i++) {
            String group = br.readLine(); //그룹이름
            int memberNumber = Integer.parseInt(br.readLine()); //총 멤버수

            for (int j = 0; j < memberNumber; j++) {
                String name = br.readLine();

                groupName.add(group);
                memberName.put(name,(memberName.size() - 1) + 1);
            }
        }

        ArrayList<String> str = new ArrayList<>(memberName.keySet());

        for (int i = 0; i < M;i++) { //질문부
            ArrayList<String> result = new ArrayList<>();

            String name = br.readLine();
            int question = Integer.parseInt(br.readLine());

            if (question == 0) { //0은 팀에 속해있는 멤버를 정렬하여 출력
                for (int j = 0; j < groupName.size();j++) {
                    if (Objects.equals(groupName.get(j), name)) {
                        result.add(str.get(j));
                    }
                }
                Collections.sort(result);
                for (String s : result) {
                    sb.append(s).append("\n");
                }
            }
            else { //1은 멤버가 속한 그룹이름을 출력
                int temp = memberName.get(name); //멤버이름의 index번호 저장
                sb.append(groupName.get(temp)).append("\n");
            }
        }
        System.out.println(sb);
    }
}

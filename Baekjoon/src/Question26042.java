import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Question26042 {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>(); //큐선언

        int lastNumber = 0;
        int lengthSave = 0;
        for (int i = 0 ; i < testCase;i++) {
            String str = br.readLine();

            String[] cut = str.split(" ");

            if (cut.length == 1) { //가장 앞에사람 식사
                queue.poll();
            }
            else { //사람 새로 추가
                queue.add(Integer.parseInt(cut[1])); //사람추가

                if (lengthSave < queue.size()) {
                    lastNumber = Integer.parseInt(cut[1]);//마지막 번호 추가
                    lengthSave = queue.size();//큐 사이즈 저장
                }
                else if (lengthSave == queue.size()) { //전에것과 비교하여
                    if (Integer.parseInt(cut[1]) < lastNumber) { //전에 lastNum이작은경우 바꿈 (작은값 찾아야하니까)
                        lastNumber = Integer.parseInt(cut[1]);
                    }
                }
            }
        }
        System.out.println(""+lengthSave+" "+lastNumber+"");
    }
}

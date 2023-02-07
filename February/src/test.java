import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
         test2 han = new test2("홍길동","ab","경기도");
        test2 kim = new test2("김민지","b","충청도");
        test2 lee = new test2("최현우","a","부산");

        ArrayList<test2> test = new ArrayList<>();
        test.add(han);
        test.add(kim);
        test.add(lee);

        for (test2 arr2 : test) {
            arr2.dawd();
        }
    }
}

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class codeup1528 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        f();
        if (f() == 0) {
            bw.write("*");
            bw.flush();
            bw.close();
        }
    }
    static int f () {
        return 0;
    }
}

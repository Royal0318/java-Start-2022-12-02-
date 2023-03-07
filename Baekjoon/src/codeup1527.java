import java.io.*;

public class codeup1527 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        f();
        if (f() == 0) {
            bw.write("123");
            bw.flush();
            bw.close();
        }
    }

    static int f() {
        return 0;
    }
}

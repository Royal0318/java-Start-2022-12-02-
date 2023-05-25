import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Phone implements mobilePhone {
    private String text;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    Scanner sc = new Scanner(System.in);
    int TIMEOUT = 30000;
    Timer m = new Timer();
    TimerTask task;
    @Override
    public void display() {
        timeOver(); //타이머시작
        System.out.println("텍스트를 입력하세요");
        setText(sc.next());

        System.out.println("입력한 텍스트는 "+getText()+"입니다");
        m.cancel();
    }
    @Override
    public void timeOver () {
        task = new TimerTask() {
            public void run() {
                System.out.println("30초가 지났으므로 프로그램이 자동적으로 종료됩니다");
                System.exit(0);
            }
        };
        m.schedule(task, TIMEOUT);
    }
    @Override
    public void on() {
        System.out.println("휴대폰이 켜졌습니다");
    }

    @Override
    public void off() {
        System.out.println("휴대폰이 꺼졌습니다");
        m.cancel();
    }
}

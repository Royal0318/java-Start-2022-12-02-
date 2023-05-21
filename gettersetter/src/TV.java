import java.util.Scanner;

public class TV implements Television{
Scanner sc = new Scanner(System.in);
    int now = 1; //지금채널
    boolean tvSwitch = false; //전원 on off확인
    @Override
    public void channelUp() {
        if (now == 1) {
            System.out.println("TV가 켜졌습니다 현재 채널번호는 : "+now+"번 입니다");
            now += 1;
        } else if (now <= Television.channel) {
            System.out.println("채널을 올렸습니다 현재 채널 번호는 : "+now+"번 입니다");
            now += 1;
        } else {
            now = 1;
        }
    }

    @Override
    public void channelDown() {
        now -= 1;
        System.out.println("채널을 내렸습니다 현재 채널 번호는 : "+now+"번 입니다");
    }

    @Override
    public void on() {
        tvSwitch = true;
        System.out.println("TV가 켜졌습니다 현재 채널 번호는 : "+now+"번 입니다.");
    }

    @Override
    public void off() {
        tvSwitch = false;
        now = 1;
        System.out.println("TV가 꺼졌습니다 현재 채널 번호는 : "+now+"번입니다.");
    }

    @Override
    public void channelSelect() {
            System.out.println("채널 변경 번호 입력 : ");
            now = sc.nextInt();

            System.out.println("채널을 " + now + "번으로 변경했습니다 현재 채널 번호는 " + now + "번 입니다");

    }
}

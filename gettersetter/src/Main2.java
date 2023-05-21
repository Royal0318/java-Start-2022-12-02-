public class Main2 {
    public static void main(String[] args) {
        Television samsung = new TV();

        for (int i = 0; i < 4; i++) {
            samsung.channelUp();
        }
        System.out.println("\n");
        Television lg = new TV();
        lg.on();
        lg.channelSelect();
        lg.channelDown();
        samsung.off();
    }
}

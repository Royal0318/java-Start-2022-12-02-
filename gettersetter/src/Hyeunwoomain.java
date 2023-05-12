import java.util.Scanner;

public class Hyeunwoomain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HyeunwooReposity myLife = new HyeunwooReposity();

        myLife.inputName(sc);
        myLife.inputOld(sc);
        myLife.inputAddress(sc);
        myLife.inputPhoneNumber(sc);
        myLife.inputHobby(sc);
        myLife.inputSex(sc);
        myLife.inputBorn(sc);
        myLife.inputJop(sc);
        myLife.outputInformation();
    }
}
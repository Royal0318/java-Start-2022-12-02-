import java.util.Scanner;

public class Array2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] gameCardArr = new int[3][4];
        int[][] correctAnswerArr = new int[3][4];
        Array3 object = new Array3(gameCardArr,correctAnswerArr,0,0);
        Array3 sumObject = new Array3();

        object.answerInput(sc);
    }
}

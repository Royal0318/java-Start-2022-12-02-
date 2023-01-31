package ObjectOrientation;

import java.util.Scanner;

public class JanuaryThirtiethfirst {
    public static void main(String[] args) {
        //게임리스트에서 종료버튼을 누를시 출력되어 시스템종료
        System.out.println(""+GameNameMake()+"");
    }
    public static String GameNameMake () {
        //게임제목 정하는 메소드
        Scanner sc = new Scanner(System.in);
        //4번째 게임의 기획서 작성 양식
        System.out.println("4번째 게임의 제목을 정해주세요");
        String Game4 = sc.next();
        System.out.println("4번째 게임의 설명을 적어주세요");
        String Game4Explanation = sc.next();
        System.out.println("4번째 게임의 장르를 적어주세요");
        String Game4Genre = sc.next();
        System.out.println("4번째 게임의 플레이 방식을 적어주세요");
        String Game4Rull = sc.next();
        System.out.println("4번째 게임의 제작자 이름을 적어주세요 \n안내 : 최대 3명까지 입력 가능합니다 3명 미만일시 없음을 적어주세요");
        String Game4Producers = sc.next();
        String Game4Producers2 = sc.next();
        String Game4Producers3 = sc.next();
        System.out.println("4번째 게임의 제작 시작기간과 종료기간을 각각 적어주세요");
        String Game4MakePeriod = sc.next();
        String Game4MakePeriod2 = sc.next();
        System.out.println("4번째 게임의 예상 매출액을 적어주세요");
        String Game4Sale = sc.next();

        //5번째 게임의 기획서 작성 양식
        System.out.println("5번째 게임의 제목을 정해주세요");
        String Game5 = sc.next();
        System.out.println("5번째 게임의 설명을 적어주세요");
        String Game5Explanation = sc.next();
        System.out.println("5번째 게임의 장르를 적어주세요");
        String Game5Genre = sc.next();
        System.out.println("5번째 게임의 플레이 방식을 적어주세요");
        String Game5Rull = sc.next();
        System.out.println("5번째 게임의 제작자 이름을 적어주세요 \n안내 : 최대 3명까지 입력 가능합니다 3명 미만일시 없음을 적어주세요");
        String Game5Producers = sc.next();
        String Game5Producers2 = sc.next();
        String Game5Producers3 = sc.next();
        System.out.println("5번째 게임의 제작 시작기간과 종료기간을 각각 적어주세요");
        String Game5MakePeriod = sc.next();
        String Game5MakePeriod2 = sc.next();
        System.out.println("5번째 게임의 예상 매출액을 적어주세요");
        String Game5Sale = sc.next();
        return LookGameExplanation(Game4,Game5,Game4Explanation,Game4Genre,Game4Rull,Game4Producers,Game4Producers2,Game4Producers3,Game4MakePeriod,Game4MakePeriod2,Game4Sale,Game5Explanation,Game5Genre,Game5Rull,Game5Producers,Game5Producers2,Game5Producers3,Game5MakePeriod,Game5MakePeriod2,Game5Sale);
    }
    public static String LookGameExplanation(String Game4,String Game5,String Game4Explanation,String Game4Genre,String Game4Rull,String Game4Producers,String Game4Producers2,String Game4Producers3,String Game4MakePeriod,String Game4MakePeriod2,String Game4Sale,String Game5Explanation,String Game5Genre,String Game5Rull,String Game5Producers,String Game5Producers2,String Game5Producers3,String Game5MakePeriod,String Game5MakePeriod2,String Game5Sale) {
        //게임 제목 리스트중에서 기획서내용을 보기위한 선택메소드
        Scanner sc = new Scanner(System.in);
        JanuaryThirtiethfirst2 TotalGame = new JanuaryThirtiethfirst2("Card Game", "빨리 보스잡기 게임", "격투게임",""+Game4+"",""+Game4Explanation+"",""+Game4Genre+"",""+Game4Rull+"",""+Game4Producers+"",""+Game4Producers2+"",""+Game4Producers3+"",""+Game4MakePeriod+"",""+Game4MakePeriod2+"",""+Game4Sale+"",""+Game5+"",""+Game5Explanation+"",""+Game5Genre+"",""+Game5Rull+"",""+Game5Producers+"",""+Game5Producers2+"",""+Game5Producers3+"",""+Game5MakePeriod+",",""+Game5MakePeriod2+"",""+Game5Sale+"");

        while (true) {
            TotalGame.GameMainList();
            int GameListInput = sc.nextInt();
            if (GameListInput == 1 || GameListInput == 2 || GameListInput == 3 || GameListInput == 4 || GameListInput == 5) {
                return ListDescription(GameListInput,Game4,Game5,Game4Explanation,Game4Genre,Game4Rull,Game4Producers,Game4Producers2,Game4Producers3,Game4MakePeriod,Game4MakePeriod2,Game4Sale,Game5Explanation,Game5Genre,Game5Rull,Game5Producers,Game5Producers2,Game5Producers3,Game5MakePeriod,Game5MakePeriod2,Game5Sale);
            } else if (GameListInput == 6) {
                return "<<<시스템을 종료합니다>>>";
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
    public static String ListDescription (int GameListInput,String Game4,String Game5,String Game4Explanation,String Game4Genre,String Game4Rull,String Game4Producers,String Game4Producers2,String Game4Producers3,String Game4MakePeriod,String Game4MakePeriod2,String Game4Sale,String Game5Explanation,String Game5Genre,String Game5Rull,String Game5Producers,String Game5Producers2,String Game5Producers3,String Game5MakePeriod,String Game5MakePeriod2,String Game5Sale) {
        //보고싶은 기획서의 번호를 리턴시켜 받은메소드에서 판별하여 해당 기획서를 출력시킴
        JanuaryThirtiethfirst2 TotalGame = new JanuaryThirtiethfirst2("Card Game", "빨리 보스잡기 게임", "격투게임",""+Game4+"",""+Game4Explanation+"",""+Game4Genre+"",""+Game4Rull+"",""+Game4Producers+"",""+Game4Producers2+"",""+Game4Producers3+"",""+Game4MakePeriod+"",""+Game4MakePeriod2+"",""+Game4Sale+"",""+Game5+"",""+Game5Explanation+"",""+Game5Genre+"",""+Game5Rull+"",""+Game5Producers+"",""+Game5Producers2+"",""+Game5Producers3+"",""+Game5MakePeriod+",",""+Game5MakePeriod2+"",""+Game5Sale+"");
        if (GameListInput == 1) {
            TotalGame.GameListExplanation();
        } else if (GameListInput == 2) {
            TotalGame.Game2ListExplanation();
        } else if (GameListInput == 3) {
            TotalGame.Game3ListExplanation();
        } else if (GameListInput == 4) {
            TotalGame.Game4ListExplanation();
        } else if (GameListInput == 5) {
            TotalGame.Game5ListExplanation();
        } else {
            System.out.println("잘못된 입력입니다");
        }
        //기획서 출력후 다시 기획서를 선택할 수 있도록 리턴시킴
        return LookGameExplanation (Game4,Game5,Game4Explanation,Game4Genre,Game4Rull,Game4Producers,Game4Producers2,Game4Producers3,Game4MakePeriod,Game4MakePeriod2,Game4Sale,Game5Explanation,Game5Genre,Game5Rull,Game5Producers,Game5Producers2,Game5Producers3,Game5MakePeriod,Game5MakePeriod2,Game5Sale);
    }
}

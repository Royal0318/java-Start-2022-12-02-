import java.util.Objects;
import java.util.Scanner;

public class Array5 {
    int[][] age;
    int[][] familyMembers;
    int[][] phoneFrontNumber;
    int[][] phoneBackNumber;
    String[][] name;

    Array5 () {

    }
    Array5 (int[][] age, int[][] familyMembers,int[][] phoneFrontNumber,int[][] phoneBackNumber, String[][] name) {
        this.age = age;
        this.familyMembers = familyMembers;
        this.phoneFrontNumber = phoneFrontNumber;
        this.phoneBackNumber = phoneBackNumber;
        this.name = name;
    }
    void systemMainMenu (Scanner sc) {
        System.out.println("1.입주자 등록 2.입주자 이사 3.세대정보 조회 4.시스템 종료");
        int systemMenuChoice = sc.nextInt();

        switch (systemMenuChoice) {
            case 1 :
                aptInformationChoice(sc);
                break;
            case 2 :
                occupantMove(sc);
                break;
            case 3 :
                findingResidentsSystem(sc);
                break;
            case 4 :
                System.out.println("시스템을 종료합니다");
                System.exit(0);
                break;
            default :
                System.out.println("잘못된 입력입니다");
                systemMainMenu(sc);
        }
    }
    void aptInformationChoice (Scanner sc) {
        System.out.println("입주자의 아파트 라인 번호를 적어주세요");
        System.out.println("1.1호 Line \n2.2호 Line \n3.3호 Line \n4.4호 Line \n5.5호 Line");
        int aptLine = sc.nextInt() - 1;

        if (aptLine >= 0 && aptLine <= 4) {
            System.out.println("입주자의 아파트 호수에 맞는 번호를 적어주세요");
            System.out.println("1."+(((aptLine + 1) * 100) + 1)+"호 2."+(((aptLine + 1) * 100) + 2)+"호 3."+(((aptLine + 1) * 100) + 3)+"호 4."+(((aptLine + 1) * 100) + 4)+"호 5."+(((aptLine + 1) * 100) + 5)+"호");
            int aptHoSelect = sc.nextInt() - 1;

            if (aptHoSelect >= 0 && aptHoSelect <= 4) {
                registration(aptLine,aptHoSelect,sc);
            } else {
                System.out.println("잘못된 입력입니다");
                aptInformationChoice(sc);
            }
        } else {
            System.out.println("잘못된 입력입니다");
            aptInformationChoice(sc);
        }
    }
    void registration (int aptLine,int aptHoSelect,Scanner sc) {
        //입주자 이름,나이,세대수,휴대폰번호,호수
        System.out.println("<<<입주자 정보를 입력합니다>>>");
        System.out.println("1.입주자 이름을 적어주세요");
        name[aptLine][aptHoSelect] = sc.next();
        System.out.println("======저장이 완료되었습니다======");
        ageInput(aptLine,aptHoSelect,sc);
    }
    void ageInput (int aptLine,int aptHoSelect,Scanner sc) {
        System.out.println("입주자 나이를 적어주세요 (1 ~ 200세 제한)");
        age[aptLine][aptHoSelect] = sc.nextInt();

        if (age[aptLine][aptHoSelect] >= 1 && age[aptLine][aptHoSelect] <= 200) {
            System.out.println("======저장이 완료되었습니다======");
            familyMemberInput(aptLine,aptHoSelect,sc);
        } else {
            System.out.println("나이를 다시 입력해주세요");
            ageInput(aptLine,aptHoSelect,sc);
        }
    }
    void familyMemberInput (int aptLine,int aptHoSelect,Scanner sc) {
        System.out.println("가족 구성원 수를 입력해주세요");
        familyMembers[aptLine][aptHoSelect] = sc.nextInt();
        System.out.println("======저장이 완료되었습니다======");
        phonenumberInput(aptLine,aptHoSelect,sc);
    }
    void phonenumberInput (int aptLine,int aptHoSelect,Scanner sc) {
        System.out.println("입주민 대표 전화번호 앞,뒤 4자리를 입력해주세요 예) 010-1234-5678 --> 1234 enter 5678 enter");
        phoneFrontNumber[aptLine][aptHoSelect] = sc.nextInt();
        phoneBackNumber[aptLine][aptHoSelect] = sc.nextInt();

        if (phoneFrontNumber[aptLine][aptHoSelect] >= 1000 && phoneFrontNumber[aptLine][aptHoSelect] <= 9999 && phoneBackNumber[aptLine][aptHoSelect] >= 1000 && phoneBackNumber[aptLine][aptHoSelect] <= 9999) {
            System.out.println("======저장이 완료되었습니다======");
            systemMainMenu(sc);
        } else {
            System.out.println("잘못된 입력입니다");
            phonenumberInput(aptLine,aptHoSelect,sc);
        }
    }
    void occupantMove (Scanner sc) {
        System.out.println("이사하는 세대의 호수를 적어주세요");
        int aptHo = sc.nextInt();

        if (aptHo >= 101 && aptHo <= 105) {
            occupantMoveComplete(0,((aptHo%100) - 1),sc);
        } else if (aptHo >= 201 && aptHo <= 205) {
            occupantMoveComplete(1,((aptHo%200) - 1),sc);
        } else if (aptHo >= 301 && aptHo <= 305) {
            occupantMoveComplete(2,((aptHo%300) - 1),sc);
        } else if (aptHo >= 401 && aptHo <= 405) {
            occupantMoveComplete(3,((aptHo%400) - 1),sc);
        } else {
            occupantMoveComplete(4,((aptHo%500) - 1),sc);
        }
    }
    void occupantMoveComplete (int line,int ho,Scanner sc) {
        if (age[line][ho] != 0) {
            age[line][ho] = 0;
            familyMembers[line][ho] = 0;
            phoneFrontNumber[line][ho] = 0;
            phoneBackNumber[line][ho] = 0;
            name[line][ho] = "";
            System.out.println("이사가 완료되었습니다");
        } else {
            System.out.println("해당 호수는 공실입니다");
        }
        systemMainMenu(sc);
    }
    void findingResidentsSystem (Scanner sc) {
        System.out.println("1.이름으로 찾기 2.휴대폰 번호로 찾기 3.아파트 라인,호수로 찾기");
        int findMenuChoice = sc.nextInt();

        switch (findMenuChoice) {
            case 1 :
                nameFind(sc);
            case 2 :
                phonenumberFind(sc);
            case 3 :
                aptlinefind(sc);
            default :
                System.out.println("잘못된 입력입니다");
                systemMainMenu(sc);
        }
    }
    void nameFind (Scanner sc) {
        int checkCompleteTemp = 0;
        System.out.println("찾는분 성함을 적어주세요");
        String nameInput = sc.next();

        for (int i = 0 ; i < 5;i++) {
            for (int j = 0; j < 5; j++) {
                if (Objects.equals(name[i][j], "" + nameInput + "")) {
                    System.out.println("==============조회결과==============");
                    System.out.println("세대 위치 : "+(i + 1)+"동 "+(((i + 1) * 100) + j + 1)+"호");
                    System.out.println("세대주 성명 : " + name[i][j] + "");
                    System.out.println("세대주 나이 : " + age[i][j] + "세");
                    System.out.println("세대주 가족구성원 : " + familyMembers[i][j] + "명");
                    System.out.println("세대주 전화번호 : 010-" + phoneFrontNumber[i][j] + "-" + phoneBackNumber[i][j] + "\n");
                    checkCompleteTemp = 1;
                }
            }
        }
        if (checkCompleteTemp == 0) {
            System.out.println("검색결과가 없습니다");
        }
        systemMainMenu(sc);
    }
    void phonenumberFind (Scanner sc) {
        int checkCompleteTemp = 0;
        System.out.println("입주민 대표 전화번호 앞,뒤 4자리를 입력해주세요 예) 010-1234-5678 --> 1234 enter 5678 enter");
        int frontNumber = sc.nextInt();
        int backNumber = sc.nextInt();
        for (int i = 0 ; i < 5;i++) {
            for (int j = 0; j < 5; j++) {
                if (phoneFrontNumber[i][j] == frontNumber && phoneBackNumber[i][j] == backNumber) {
                    System.out.println("==============조회결과==============");
                    System.out.println("세대주 성명 : " + name[i][j] + "");
                    System.out.println("세대주 나이 : " + age[i][j] + "세");
                    System.out.println("세대주 가족구성원 : " + familyMembers[i][j] + "명");
                    System.out.println("세대주 전화번호 : 010-" + phoneFrontNumber[i][j] + "-" + phoneBackNumber[i][j] + "\n");
                    checkCompleteTemp = 1;
                }
            }
        }
        if (checkCompleteTemp == 0) {
            System.out.println("검색결과가 없습니다");
        }
        systemMainMenu(sc);
    }
    void aptlinefind (Scanner sc) {
        System.out.println("조회할 아파트의 라인 번호를 적어주세요");
        System.out.println("1.1호 Line \n2.2호 Line \n3.3호 Line \n4.4호 Line \n5.5호 Line");
        int aptLine = sc.nextInt() - 1;

        System.out.println("조회할 아파트 호수를 적어주세요");
        System.out.println("1."+(((aptLine + 1) * 100) + 1)+"호 2."+(((aptLine + 1) * 100) + 2)+"호 3."+(((aptLine + 1) * 100) + 3)+"호 4."+(((aptLine + 1) * 100) + 4)+"호 5."+(((aptLine + 1) * 100) + 5)+"호");
        int aptHoSelect = sc.nextInt() - 1;

        if (age[aptLine][aptHoSelect] != 0) {
            System.out.println("=================조회결과=================");
            System.out.println("세대주 성명 : "+name[aptLine][aptHoSelect]+"");
            System.out.println("세대주 나이 : "+age[aptLine][aptHoSelect]+"세");
            System.out.println("세대주 가족구성원 : "+familyMembers[aptLine][aptHoSelect]+"명");
            System.out.println("세대주 전화번호 : 010-"+phoneFrontNumber[aptLine][aptHoSelect]+"-"+phoneBackNumber[aptLine][aptHoSelect]+"\n");
        } else {
            System.out.println("해당 호수는 공실입니다");
        }
        systemMainMenu(sc);
    }
}

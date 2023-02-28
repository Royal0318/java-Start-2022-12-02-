import java.util.Objects;
import java.util.Scanner;

public class Array5 {
    int[][] age;
    //101호부터 505호까지 총 25호수가 존재하므로 5X5인 2차원배열 나이를 저장
    int[][] familyMembers;
    //5X5호수의 가족 구성원 수를 저장
    int[][] phoneFrontNumber;
    //5X5호수의 휴대폰 앞 번호 4자리를 저장
    int[][] phoneBackNumber;
    //5X5호수의 휴대폰 뒷 번호 4자리를 저장
    String[][] name;
    //5X5호수의 세대주 이름을 저장

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
        //메인메뉴
        System.out.println("1.입주자 등록 2.입주자 이사 3.세대정보 조회 4.시스템 종료");
        int systemMenuChoice = sc.nextInt();

        switch (systemMenuChoice) {
            //Scanner는 main에서 공유하기 때문에 각 메소드마다 Scanner를 공유
            case 1 :
                aptLineSelect(sc);
                //입주자 등록절차를 시작한다 아파트 라인부터 시작
                break;
            case 2 :
                occupantMove(sc);
                //아파트를 이사하기위한 메소드로 리턴
                break;
            case 3 :
                findingResidentsSystem(sc);
                //세대정보를 조회할수있는 3가지 방법인 메소드로 리턴
                break;
            case 4 :
                System.out.println("시스템을 종료합니다");
                System.exit(0);
                break;
            default :
                System.out.println("잘못된 입력입니다");
                break;
        }
        systemMainMenu(sc);
    }
    void aptLineSelect (Scanner sc) {
        //아파트 라인을 입력받는 메소드이다 aptLine에 입력받으면 실제 index번호와 다르므로 -1을 적용 후 aptHoSelect에 (aptline번호와 Scanner리턴)
        System.out.println("입주자의 아파트 라인 번호를 적어주세요");
        System.out.println("1.1호 Line \n2.2호 Line \n3.3호 Line \n4.4호 Line \n5.5호 Line");
        int aptLine = sc.nextInt() - 1;

        if (aptLine >= 0 && aptLine <= 4) {
            aptHoSelect(aptLine,sc);
        } else {
            System.out.println("잘못된 입력입니다");
            aptLineSelect(sc);
        }
    }
    void aptHoSelect (int aptLine,Scanner sc) {
        //입주를 원하는 아파트 호수를 선택한다 aptLine의 번호에 따라 출력되는 호수가 다르며 호수번호를 입력 시 조건문에 범위가 벗어나는지확인 및 해당 호수에 사람이 살고있는지 조건확인
        System.out.println("입주자의 아파트 호수에 맞는 번호를 적어주세요");
        System.out.println("1."+(((aptLine + 1) * 100) + 1)+"호 2."+(((aptLine + 1) * 100) + 2)+"호 3."+(((aptLine + 1) * 100) + 3)+"호 4."+(((aptLine + 1) * 100) + 4)+"호 5."+(((aptLine + 1) * 100) + 5)+"호");
        int aptHoSelect = sc.nextInt() - 1;

        if (aptHoSelect >= 0 && aptHoSelect <= 5 && age[aptLine][aptHoSelect] == 0) {
            informationRegistration(aptLine,aptHoSelect,sc);
            //입주조건이 모두 만족되는경우 입주자 정보를 입력하는 informationRegistration 메소드로 (aptLine,aptHoSelect,sc)를 리턴보냄
        } else {
            System.out.println("해당 호수에 사람이 살고있거나 잘못된 입력입니다");
            aptHoSelect(aptLine,sc);
        }
    }
    void informationRegistration (int aptLine,int aptHoSelect,Scanner sc) {
        //입주자 정보를 입력하기 시작하는 메소드
        System.out.println("<<<입주자 정보를 입력합니다>>>\n");
        System.out.println("1.입주자 이름을 적어주세요");
        name[aptLine][aptHoSelect] = sc.next();
        //입주를 원하는 Line과 Ho의 번호를 받으면 2차원 배열name에 저장한다
        System.out.println("======저장이 완료되었습니다======");
        ageInput(aptLine,aptHoSelect,sc);
    }
    void ageInput (int aptLine,int aptHoSelect,Scanner sc) {
        //입주자 나이를 입력받는 메소드
        System.out.println("2.입주자 나이를 적어주세요 (1 ~ 200세 제한)");
        age[aptLine][aptHoSelect] = sc.nextInt();
        //2차원 배열 age에 나이값을 저장하며 나이가 조건 범위안에 만족할 시 familyMemberInput로 리턴보냄

        if (age[aptLine][aptHoSelect] >= 1 && age[aptLine][aptHoSelect] <= 200) {
            System.out.println("======저장이 완료되었습니다======");
            familyMemberInput(aptLine,aptHoSelect,sc);
        } else {
            System.out.println("나이를 다시 입력해주세요");
            ageInput(aptLine,aptHoSelect,sc);
        }
    }
    void familyMemberInput (int aptLine,int aptHoSelect,Scanner sc) {
        //가족구성원 수를 입력받는 메소드 위와같은 방법으로 구성원 수를 입력받는다 지금까지 받은 값들은 모두 같은배열 index번호에 저장된다
        System.out.println("3.가족 구성원 수를 입력해주세요");
        familyMembers[aptLine][aptHoSelect] = sc.nextInt();
        System.out.println("======저장이 완료되었습니다======");
        phonenumberInput(aptLine,aptHoSelect,sc);
    }
    void phonenumberInput (int aptLine,int aptHoSelect,Scanner sc) {
        //휴대폰 번호를 입력받는 메소드 앞자리와 뒷자리가 4자리의 한계값 (1000 ~ 9999까지)조건을 만족하면 정보입력이 끝나며 다시 메인메뉴로 리턴된다
        System.out.println("4.입주민 대표 전화번호 앞,뒤 4자리를 각각 입력해주세요 예) 010-1234-5678 --> 1234 enter 5678 enter");
        phoneFrontNumber[aptLine][aptHoSelect] = sc.nextInt();
        phoneBackNumber[aptLine][aptHoSelect] = sc.nextInt();

        if (phoneFrontNumber[aptLine][aptHoSelect] >= 1000 && phoneFrontNumber[aptLine][aptHoSelect] <= 9999 && phoneBackNumber[aptLine][aptHoSelect] >= 1000 && phoneBackNumber[aptLine][aptHoSelect] <= 9999) {
            System.out.println("======모든 저장이 완료되었습니다======");
            systemMainMenu(sc);
        } else {
            System.out.println("잘못된 입력입니다");
            phonenumberInput(aptLine,aptHoSelect,sc);
        }
    }
    void occupantMove (Scanner sc) {
        //이사하는 세대를 입력받는 메소드
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
        /*
        아파트 호수를 적으면 각 호수에 따라 occupantMoveComplete로 보내지는 값이 달라진다 (Line값,(아파트 호수 % 호수 맨앞자리) - 1)을 리턴보낸다
        예를들어 303호이면 Line2를 리턴보내며 (실제index번호와 차이가있기 때문),(303 % 300) = 3이므로 -1을 계산해서 2를 리턴보낸다 (마찬가지로 index차이 존재)
         */
    }
    void occupantMoveComplete (int line,int ho,Scanner sc) {
        //이사가 완료되면 해당 집은 공실이 되므로 모든 변수값을 초기화해주며 다시 메인메뉴로 리턴됨
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
        //세대주를 찾을때 3가지 방법으로 찾을 수 있다 찾는방법을 선택하는 메소드
        System.out.println("1.이름으로 찾기 2.휴대폰 번호로 찾기 3.아파트 라인,호수로 찾기");
        int findMenuChoice = sc.nextInt();

        switch (findMenuChoice) {
            case 1 :
                nameFind(sc);
                //이름으로 찾는 방법 (Scanner)
            case 2 :
                phonenumberFind(sc);
                //휴대폰 번호로 찾는 방법 (Scanner)
            case 3 :
                aptInformationfind(sc);
                //아파트 라인과 호수로 찾는 방법 (Scanner)
            default :
                System.out.println("잘못된 입력입니다");
                systemMainMenu(sc);
        }
    }
    void nameFind (Scanner sc) {
        //이름으로 찾는 방법
        int checkCompleteTemp = 0;
        /*
        이름으로 세대주를 찾을때 2중 for문을 통해 index를 순서대로 돌려 저장된 이름과 비교한다 일치할시 checkCompleteTemp에 1을부과하며
        찾지못한경우 0이므로 for문을 빠져나와 검색결과가 존재하지 않는다는 메시지를 출력한다
         */
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
        //휴대폰 번호로 찾는 방법
        int checkCompleteTemp = 0;
        /*
        위와같은 방법으로 2중for문으로 처음에 입주자 번호와 일치한지 검사한다 일치할경우 1이부여 일치하지 않는경우 0이 부여된다
         */
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
    void aptInformationfind (Scanner sc) {
        //아파트 라인과 호수로 찾는방법
        System.out.println("조회할 아파트의 라인 번호를 적어주세요");
        System.out.println("1.1호 Line \n2.2호 Line \n3.3호 Line \n4.4호 Line \n5.5호 Line");
        int aptLine = sc.nextInt() - 1;
        //실제 입력하는 번호값은 index와 차이가 존재하기 때문

        System.out.println("조회할 아파트 호수를 적어주세요");
        System.out.println("1."+(((aptLine + 1) * 100) + 1)+"호 2."+(((aptLine + 1) * 100) + 2)+"호 3."+(((aptLine + 1) * 100) + 3)+"호 4."+(((aptLine + 1) * 100) + 4)+"호 5."+(((aptLine + 1) * 100) + 5)+"호");
        int aptHoSelect = sc.nextInt() - 1;
        //실제 입력하는 번호값은 index와 차이가 존재하기 때문

        if (age[aptLine][aptHoSelect] != 0) {
            //입주자 이름을 입력할땐 최소 1세부터 입력이 가능하였으므로 다른 변수를만들지 않고 age array를 이용하여 조건문을 만들었습니다
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

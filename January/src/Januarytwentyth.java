import java.util.Scanner;

public class Januarytwentyth {
    public static void main(String[] args) {
        //25명의 주민들이 모두 선택한경우 출력된 후 종료된다
        System.out.println("" + VariablesSave() + "");
    }
    public static int VariablesSave() {
        int ICount = 0; //for문의 i와 j가 독립적으로 돌지 못하므로 카운트를 도와주는 변수
        int JCount = 0;
        int Count = 101; //101호부터 시작이기때문에 호수 행렬에 부여하기위한 변수
        int[][] OutputCountSave = new int[5][5];
        int[][] ResidentAge = new int[5][5];
        int[][] AptHo = new int[5][5]; //아파트 호수 행렬
        int[][] PhoneFrontNumber = new int[5][5]; //입주자의 휴대폰번호 행렬
        int[][] PhoneBackNumber = new int[5][5];
        int[][] PersonalNumber = new int[5][5]; //입주자의 주민등록번호 행렬
        String[][] NameInputarr = new String[5][5]; //입주자 이름을 입력받는 행렬

        for (int i = 0;i < 5;i++) { //전체 행렬값에 호수를 부여한다
            for (int j = 0;j < 5;j++) {
                AptHo[i][j] = Count;
                Count++;
            }
            Count = Count + 95; //105호가 끝나면 201호부터 시작되도록 더해줌
        }
        return Menu(PersonalNumber,PhoneFrontNumber,PhoneBackNumber,ResidentAge,AptHo,NameInputarr, ICount, OutputCountSave,JCount,Count);
    }

    public static int Menu(int[][] PersonalNumber,int[][] PhoneFrontNumber,int[][] PhoneBackNumber,int[][] ResidentAge, int[][] AptHo, String[][] NameInputarr, int ICount, int[][] OutputCountSave,int JCount,int Count) {
        //이사와 입주를 선택 할 수 있도록 하는 메인 메소드
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("<<<아파트 입주 프로그램>>>  \n안내 : 101 ~ 105호, 201 ~ 205호, 301 ~ 305호, 401 ~ 405호, 501 ~ 505호까지 원하는 아파트에 입주가 가능합니다");//들어갈수있는곳 아닌곳보여주기
            System.out.println("1.이사  \n2.입주  \n3.프로그램 닫기 \n4.아파트 입주자 명부 보기");
            int Select = sc.nextInt();

            if (Select == 1) { //이사를 선택한 경우 MoveOut메소드로 리턴 값을 보냄
                return MoveOut(PersonalNumber,PhoneFrontNumber,PhoneBackNumber,ResidentAge,AptHo,NameInputarr, ICount, OutputCountSave, JCount, Count);
            } else if (Select == 2) { //이사를 선택한 경우 MoveIn메소드로 리턴 값을 보냄
                return MoveIn(PersonalNumber,PhoneFrontNumber,PhoneBackNumber,ResidentAge,AptHo,NameInputarr, ICount, OutputCountSave, JCount, Count);
            } else if (Select == 3) {
                System.out.println("<<<아파트 관리 프로그램을 종료합니다>>>");
                System.exit(1);
            } else if (Select == 4) {
                System.out.println("호수를 입력하여 명부를 확인해주세요");
                int TenantlistCheck = sc.nextInt();
                ICount = ((TenantlistCheck / 100) - 1);
                JCount = ((TenantlistCheck % 100) - 1);
                if (PersonalNumber[ICount][JCount] == 0) {
                    System.out.println("안내 : 입주자가 없습니다\n");
                } else {
                    return Tenantlist(PersonalNumber,PhoneFrontNumber,PhoneBackNumber,ResidentAge,AptHo,NameInputarr, ICount, OutputCountSave, JCount, Count);
                }
            } else {
                System.out.println("잘못된 입력입니다\n");
            }
        }
    }


    public static int MoveIn(int[][] PersonalNumber,int[][] PhoneFrontNumber,int[][] PhoneBackNumber,int[][] ResidentAge, int[][] AptHo, String[][] NameInputarr, int ICount, int[][] OutputCountSave,int JCount,int Count) {
        //입주 절차를 할 수 있는 메소드
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("입주를 원하는 호수를 적어주세요");
            int HouseSelect = sc.nextInt();

            if (HouseSelect < 101 || HouseSelect > 505) {
                System.out.println("잘못된 입력입니다");
            } else {
                return ResidentNameMethod(HouseSelect, PersonalNumber, PhoneFrontNumber, PhoneBackNumber, ResidentAge, AptHo, NameInputarr, ICount, OutputCountSave, JCount, Count);
            }
        }
    }
    public static int ResidentNameMethod (int HouseSelect,int[][] PersonalNumber,int[][] PhoneFrontNumber,int[][] PhoneBackNumber,int[][] ResidentAge, int[][] AptHo, String[][] NameInputarr, int ICount, int[][] OutputCountSave,int JCount,int Count) {
        //입주자 이름를 입력받는 메소드
        Scanner sc = new Scanner(System.in);
        ICount = ((HouseSelect / 100) - 1);
        JCount = ((HouseSelect % 100) - 1);
        if (ResidentAge[ICount][JCount] != 0) { //이미 사람이 입주한 곳에 중복으로 입주하려는경우 메시지를 출력한다
            System.out.println("해당 호수에 사람이 살고 있습니다");
            ICount = 0;
            JCount = 0;
            return MoveIn(PersonalNumber, PhoneFrontNumber, PhoneBackNumber, ResidentAge, AptHo, NameInputarr, ICount, OutputCountSave, JCount, Count);
        } else {
            while (true) {
                System.out.println("입주자 이름 입력"); //입주자 이름입력
                String Name = sc.next();
                NameInputarr[ICount][JCount] = Name;
                OutputCountSave[ICount][JCount] += 1;

                System.out.println("입주자 나이 입력 \n안내 : 1세 ~ 200세까지 입력 가능합니다"); //입주자 나이 입력
                int Age = sc.nextInt();
                if (Age < 0 || Age > 200) {
                    System.out.println("잘못된 입력입니다!");
                } else {
                    return PhoneNumberMethod(Age, PersonalNumber, PhoneFrontNumber, PhoneBackNumber, ResidentAge, AptHo, NameInputarr, ICount, OutputCountSave, JCount, Count);
                }

            }
        }
    }
    public static int PhoneNumberMethod (int Age,int[][] PersonalNumber,int[][] PhoneFrontNumber,int[][] PhoneBackNumber,int[][] ResidentAge, int[][] AptHo, String[][] NameInputarr, int ICount, int[][] OutputCountSave,int JCount,int Count) {
        //입주자 전화번호를 입력받는 메소드
        Scanner sc = new Scanner(System.in);
        while (true) {
            ResidentAge[ICount][JCount] = Age;
            System.out.println("입주자 전화번호 앞 4자리를 입력 \n예)010-1234-5678 ---> 1234");
            int PhoneFrontNumberInput = sc.nextInt();
            PhoneFrontNumber[ICount][JCount] = PhoneFrontNumberInput;
            if (PhoneFrontNumberInput < 1000 || PhoneFrontNumberInput > 9999) {
                System.out.println("잘못된 입력입니다!");
            } else {
                System.out.println("입주자 전화번호 뒤 4자리를 입력 \n예)010-1234-5678 ---> 5678");
                int PhoneBackNumberInput = sc.nextInt();
                PhoneBackNumber[ICount][JCount] = PhoneBackNumberInput;
                if (PhoneBackNumberInput < 1000 || PhoneBackNumberInput > 9999) {
                    System.out.println("잘못된 입력입니다!");
                } else {
                    return PersonalNumberMethod(PersonalNumber, PhoneFrontNumber, PhoneBackNumber, ResidentAge, AptHo, NameInputarr, ICount, OutputCountSave, JCount, Count);
                }
            }
        }
    }
    public static int PersonalNumberMethod(int[][] PersonalNumber,int[][] PhoneFrontNumber,int[][] PhoneBackNumber,int[][] ResidentAge, int[][] AptHo, String[][] NameInputarr, int ICount, int[][] OutputCountSave,int JCount,int Count) {
        //입주자 주민등록번호를 입력받는 메소드
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("입주자 주민등록번호 입력 (앞 6자리)");
            int PersonalNumberInput = sc.nextInt();
            if (PersonalNumberInput < 100000 || PersonalNumberInput > 999999) {
                System.out.println("잘못된 입력입니다!");
            } else {
                PersonalNumber[ICount][JCount] = PersonalNumberInput;
                System.out.println("<<<입주를 완료하였습니다!>>>");
                return AptInformation(PersonalNumber, PhoneFrontNumber, PhoneBackNumber, ResidentAge, AptHo, NameInputarr, ICount, OutputCountSave, JCount, Count);
            }
        }
    }

    public static int MoveOut(int[][] PersonalNumber,int[][] PhoneFrontNumber,int[][] PhoneBackNumber,int[][] ResidentAge, int[][] AptHo, String[][] NameInputarr, int ICount, int[][] OutputCountSave,int JCount,int Count) {
        //이사 절차를 할 수 있는 메소드
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("이사갈 호수를 적어주세요");
            int HouseNumber = sc.nextInt();

            if (HouseNumber < 101 || HouseNumber > 505) {
                System.out.println("잘못된 입력입니다");
            } else {
                ICount = ((HouseNumber / 100) - 1); //원하는 호수를 입력한 후 100으로 나눠 I값을 대체함
                JCount = ((HouseNumber % 100) - 1); //원하는 호수를 입력한 후 100으로 나눠 J값을 대체함
                if (ResidentAge[ICount][JCount] == 0) { //해당 호수에 아무도 살고있지 않는데 이사를 하려는 경우
                    System.out.println("해당 호수에 아무도 없습니다");
                    ICount = 0;
                    JCount = 0;
                } else { //이사를 간 후 개인정보들을 초기화시킨다
                    ResidentAge[ICount][JCount] = 0;
                    NameInputarr[ICount][JCount] = "";
                    PhoneFrontNumber[ICount][JCount] = 0;
                    PhoneBackNumber[ICount][JCount] = 0;
                    PersonalNumber[ICount][JCount] = 0;
                    System.out.println("<<<이사를 완료하였습니다!>>>");
                }
                return AptInformation(PersonalNumber,PhoneFrontNumber,PhoneBackNumber,ResidentAge,AptHo,NameInputarr, ICount, OutputCountSave, JCount, Count);
            }
        }
    }

    public static int AptInformation(int[][] PersonalNumber,int[][] PhoneFrontNumber,int[][] PhoneBackNumber,int[][] ResidentAge,int[][] AptHo,String[][] NameInputarr,int ICount,int[][] OutputCountSave,int JCount,int Count) {
        //전체적인 아파트내에 거주하는 주민의 개인정보를 볼 수 있는 메소드
        for (int i = 0; i < 5; i++) {
            System.out.println("---------------------------------------------------------------------------------------------------");
            for (int j = 0; j < 5; j++) {
                if (OutputCountSave[i][j] == 0) {
                    System.out.printf("ㅣ" + AptHo[i][j] + "호 : ");
                } else {
                    System.out.printf("ㅣ" + AptHo[i][j] + "호 : "+NameInputarr[i][j]+"");
                }
            }
            System.out.println();
        }
        ICount = 0; //개인정보 출력 후 초기화시켜 다음사람이 재선택할 수 있도록 함
        JCount = 0;
        System.out.println("---------------------------------------------------------------------------------------------------");
        return Menu(PersonalNumber,PhoneFrontNumber,PhoneBackNumber,ResidentAge,AptHo,NameInputarr,ICount,OutputCountSave,JCount,Count);
    }
    public static int Tenantlist (int[][] PersonalNumber,int[][] PhoneFrontNumber,int[][] PhoneBackNumber,int[][] ResidentAge, int[][] AptHo, String[][] NameInputarr, int ICount, int[][] OutputCountSave,int JCount,int Count) {
        System.out.println("==================================================");
        System.out.println("                <<<입주자 명부>>>                       \n이름 :"+NameInputarr[ICount][JCount]+"\n나이 :"+ResidentAge[ICount][JCount]+"세\n주민등록번호 :"+PersonalNumber[ICount][JCount]+"\n전화번호 :010-"+PhoneFrontNumber[ICount][JCount]+"-"+PhoneBackNumber[ICount][JCount]+"");
        System.out.println("==================================================");
        return Menu(PersonalNumber,PhoneFrontNumber,PhoneBackNumber,ResidentAge,AptHo,NameInputarr,ICount,OutputCountSave,JCount,Count);
    }
}

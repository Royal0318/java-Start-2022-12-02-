/*
[문제출제1]- 처음에 개인정보들을 입력받는다 > 나이, 성별, 전화번호, 주민번호, 카드 비밀번호 4자리.
	[문제출제2] - 처음 주민번호를 입력할 때 6자리를 입력받게 하고, 만약 6자리가 안 된다면 3번의 기회를 주고, 프로그램을 종료시켜라.
틀리고 나서 3회는 2회로 삭감된다
	단, 종료시키기 전에 입력한 숫자가 6자리보다 안 된다면 기회 한 번을 더 주시고, 6자리보다 크다면 기회를 두 번 더 주세요. 물론 기회는 누적됩니다.
	test상으로, 기회가 몇 개가 남았는지 상시 나타내주세요.

	[문제출제3]- 만약 입력된 주민번호가 일치하다면, 카드 번호 4자리를 입력할 수 있게 하라. 이 역시 4자리가 되지 않는다면 3번의 기회를 주고, 프로그램을 종료시켜라.
	[문제출제3]- 그 후 1.계좌 조회. 2.계좌 입금 3.계좌 출금이 가능하도록 설정하여라. 단, 처음에 2번과 3번을 입력할 시 [처음에는 계좌 조회만 가능합니다.]라는 문구가 나타나게 하여라.
	[문제출제4]- 1번을 입력할 경우 계좌에 얼마가 들어있는지 나오게 하고, 그 상황에서 다시 첫 번째 상황으로 이동할 수 있게 하여라.
	[문제출제5]- 첫 번째 상황으로 이동했다면 1번을 누를 시 [계좌 조회는 1회만 가능합니다]가 나타나도록 하고, 2, 3번만 입력할 수 있게 하여라.
	[문제출제6] - 2번을 입력 시 금액을 입금할 수 있게 하여라. 단, 이는 출금할 수 있는 것과 연관시켜야 한다.
	[문제출제7] - 3번을 누를 시 계좌에서 돈을 뺄 수 있게 하고, 가지고 있는 돈보다 많이 출금하려 할 시 [잔액이 부족합니다.] 라는 문구가 뜨게 하여라.
	[문제출제8]- 절대 계좌 내에서 –라는 금액이 보이면 안 된다.
 */
import java.util.Scanner;

public class forwhile21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Count = 0;
        int PersonalChance = 3; //주민등록번호찬스
        int Check = 0; //처음 계좌조회 여부확인
        int Accountmoney = 0; //총 가지고있는 돈
        int Frontnumber = 0; //전화번호 앞자리
        int Backnumber = 0; //전화번호 뒷자리

        while (true) {
            if (Count == 0) {
                System.out.println("나이를 입력해주세요 (1 ~ 200세)");
                int Age = sc.nextInt();

                if (Age < 1 || Age > 200) {
                    System.out.println("나이를 다시 입력해주세요");
                } else {
                    System.out.println("귀하의 나이는 " + Age + "세 입니다");
                    Count = 1;
                }
            }
            if (Count == 1) {
                System.out.println("성별을 적어주세요 (예)남 or 여)");
                String Gender = sc.next();

                if (Gender.equals("남") || Gender.equals("여")) {
                    System.out.println("귀하의 성별은 "+Gender+"입니다");
                    Count = 2;
                } else {
                    System.out.println("성별을 다시 적어주세요");
                }

            }
            if (Count == 2) {
                System.out.println("국번 제외 전화번호 앞 4자리를 적어주세요 (예)010-1234-5678 --- > 1234)");
               Frontnumber = sc.nextInt();

                if (Frontnumber >= 1000 && Frontnumber < 10000) {
                    Count = 3;
                } else {
                    System.out.println("번호를 다시 입력해주세요");
                }

            }
            if (Count == 3) {
                System.out.println("국번 제외 전화번호 뒤 4자리를 적어주세요 (예)010-1234-5678 --- > 5678)");
                Backnumber = sc.nextInt();

                if (Backnumber > 1000 && Backnumber < 10000) {
                    System.out.println("귀화의 휴대폰 번호는 010-"+Frontnumber+"-"+Backnumber+"입니다");
                    Count = 4;
                } else {
                    System.out.println("번호를 다시 입력해주세요");
                }
            }
            if (Count == 4) {
                System.out.println("주민등록번호 뒤 7자리를 입력해주세요 (예)960318-1234567 --> 1234567)");
                int Pesonalnumber = sc.nextInt();

                if (Pesonalnumber > 10000 && Pesonalnumber < 9999999) {
                    Count = 5;
                }
                if (Pesonalnumber < 1000000) {
                    //7자리보다 적은경우 기회1회 제공
                    PersonalChance -= 1;
                    if (PersonalChance >= 1) {
                        System.out.println("다시 입력해주세요 남은기회 : "+PersonalChance+"회");
                    } else if (PersonalChance == 0) {
                        System.out.println("마지막 기회입니다!");
                    } else {
                        System.out.println("기회를 모두 사용하였으므로 프로그램이 종료됩니다");
                        break;
                    }
                }
                if (Pesonalnumber > 9999999) {
                    //7자리보다 큰경우 기회2회 제공
                    PersonalChance -= 1;
                    if (PersonalChance >= 1) {
                        System.out.println("다시 입력해주세요 남은기회 : "+PersonalChance+"회");
                    } else if (PersonalChance == 0 || PersonalChance == -1) {
                        System.out.println("마지막 기회입니다!");
                    } else {
                        System.out.println("기회를 모두 사용하였으므로 프로그램이 종료됩니다");
                        break;
                    }
                }
            }
            if (Count == 5) {
                System.out.println("카드 비밀번호 4자리를 입력해주세요");
                int Cardnumber = sc.nextInt();

                if (Cardnumber < 1000 || Cardnumber > 9999) {
                    PersonalChance -= 1;
                    if (PersonalChance >= 1) {
                        System.out.println("다시 입력해주세요 남은기회 : " + PersonalChance + "회");
                    } else {
                        System.out.println("기회를 모두 사용하였으므로 프로그램이 종료됩니다");
                        break;
                    }
                } else {
                    Count = 6;
                }
            }
            if (Count == 6) {
                System.out.println("1.계좌 조회. 2.계좌 입금 3.계좌 출금 4.시스템종료");
                int Accountmenu = sc.nextInt();

                 if (Accountmenu == 4) {
                    System.out.println("프로그램을 종료합니다");
                    break;
                }

                if (Check == 0) {
                    if (Accountmenu == 1) {
                        System.out.println("현재 잔액은 : "+Accountmoney+"원 입니다");
                        Check = 1;
                    } else if (Accountmenu == 2 || Accountmenu == 3) {
                        System.out.println("처음에는 계좌조회만 가능합니다");
                    }
                } else {
                    if (Accountmenu == 1) {
                        System.out.println("계좌조회는 1회만 가능합니다");
                    } else if (Accountmenu == 2) {
                        System.out.println("입금할 금액을 적어주세요");
                        int Deposit = sc.nextInt();

                        if (Deposit < 1) {
                            System.out.println("최소 1원부터 입금 가능합니다");
                        } else {
                            Accountmoney += Deposit;
                            System.out.println("입금이 완료되었습니다 잔액 : "+Accountmoney+"원");
                        }
                    } else if (Accountmenu == 3) {
                        System.out.println("출금할 금액을 적어주세요");
                        int Withdrawal = sc.nextInt();

                        if (Accountmoney < Withdrawal) {
                            System.out.println("출금 금액이 더 클 수 없습니다");
                        } else {
                            Accountmoney -= Withdrawal;
                            System.out.println("출금이 완료되었습니다 잔액 : "+Accountmoney+"원");
                        }
                    } else {
                        System.out.println("잘못된 입력입니다");
                    }
                }
            }
        }
    }
}

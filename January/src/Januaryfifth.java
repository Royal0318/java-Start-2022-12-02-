/*
음식 종류 다섯가지, 다음 손님, 종료버튼,돈갚기,제어까지 해서 총 9개 메뉴를 만들어주세요.
 15명의 사람이 있다. 메뉴를 주고 그들이 무엇을 사면 총 얼마가 남았는지에 관한 코딩을 작성해보아라.
   [예 : a[8]에 존자해는 사람이 25000원을 가지고 있을 때 1번 타코야키 2000원을 사먹으면 23000원이 되게 해보아라.]

   [문제출제 : 개발자가 정한 5개의 음식 메뉴와 환불, 돈 갚기, 다음손님 버튼, 몇 번째 손님을 제어할 건지에 대한 메뉴, 종료버튼까지 총 9개의 메뉴가 존재한다.]
   [문제출제 1: 단, 금액이 부족하다면 금액이 부족합니다. 라는 문구가 표시되며 다시 고를 수 있게 하며,
   금액이 있는 음식 종류들 중 아무것도 살 수 없는 상태라면 [소지금이 부족합니다]라는 문구와 함께
   다시 선택할 지 물어보시고, 만약 다시 선택한다면 다시 선택할 수 있게, 만약 아니라면 다음으로 넘어가는 상황을 코딩하시오.
   [문제출제 2 : 각각손님이 몇 번째인지 출력되도록 하시오.]
   [문제출제 3 : 절대로 음수값이 나와서는 안 됨.]
   [문제출제 4 : 만약 돈이 부족하다면 그 다음 순번 사람에게 돈을 꾸는 상황을 코딩하시오.]
   [문제출제 5 : 만약 결제가 완료됐다면 각각 무엇을 주문했는지, 돈이 얼만큼 남았는지 출력하시오.]
   [문제출제 6 : 그리고 마지막 나온 출력값 [가지고 있는 돈]들의 합을 구하시오.]
   [문제출제 7 : 단, 0~4번 사람까지는 20000원을, 5~9번까지의 손님들은 10000원을 가지고 있게끔 코딩하시오.]
   [문제출제 8 : 단, 10~14번 번 손님의 가지고 있는 돈은 scanf로 받을 수 있게 하시오]
   [문제출제 9 : 몇 번째 손님을 제어할지에 대한 메뉴는 내가 예를 들어 지금 현재 5번째 손님일 때,
   해당 버튼을 누르면 5번째 손님은 잠시 내버려두고, 해당 원하는 번째 손님을 제어할 수 있습니다.
   단, 해당 제어하기 버튼으로 들어간 손님의 메뉴에서만 [ 이전 손님으로 돌아가기 ] 버튼이 생기게 되며, [ 다음 손님으로 ] 를 누를 경우 '이전 손님으로 돌아가기밖에 할 수 없습니다.'가 출력된다.]

   [문제출제 9 : 단, 문제출제 7,8번의 경우에는 if문 한 번, 반복문 한 번으로 제한합니다. if or for[while]] - else는 사용하지 않음.
   if한 번 쓰시고, for 한 번 쓰셔도 되고,[문제출제9에만 해당 함]
   if한 번만 쓰셔도 되시고,[문제출제9에만 해당 함]
   for문 한 번만 쓰셔도 됩니다.[문제출제9에만 해당 함]

   [문제출제 10 : 만약 주문이 완료되었다면 아래를 실행하시오.]
예시)
   ===주문표===
타코야키 x 10 = 20000원

===1번째 손님===
원래 가지고 있던 금액 :10000000원
타코야키 x 10 = 20000원
현재 가지고 있는 금액 : 980000원
빚 진 금액 : ?원
빚을 청산하고 남은 금액 : ?원
미납 된 금액 : ?원
빌려준 금액 : ?원
단!
위처럼, 아예 구매하지 않은 음식이나 사람은 나타나지 않습니다.
또한, 1번째 손님이 주문을 하지 않고, 3번의 손님이 주문하였다해도
해당 손님은 1번이 되게 해주세요.
돈이 부족한 경우, 돈을 빌릴 수 있는 시스템.
한 사람 한 사람 빌리는 시스템이기 때문에,

2번 사람이 돈을 꿀 때는 3번사람에게 꾸게 될 것.

그리고 선택지 1.더 빌린다 2.빌리지 않는다.
인데, 이거는 돈을 빌렸는데도 돈이 더 부족할 떄는 자동으로 4번에게 꾸게 되고,[3번이 아님]
만약 돈을 꾸게 되었을 때 돈이 부족하지 않다면,
무엇을 사먹을 수 있습니다.
무엇을 무엇을 사먹을 수 있습니다.
처럼 나타내세요.

또한, 돈이 충분해져도 더 빌릴 수가 있고, 빌리지 않을 수도 있습니다.
더 빌린다고 할 경우 현재 빌린 사람의 다음 순번 사람에게 돈을 꾸게 됩니다.
이번 문제는 함수형을 사용하지 않고 푼다
 */
import java.util.Scanner;
public class Januaryfifth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TotalMoney = 150000;
        int Count2 = 0;
        int ControlCount = 0;
        int BackCount = 0;
        int SnackCount = 0;
        int BreadCount = 0;
        int FruitCount = 0;
        int DrinkCount = 0;
        int FishCount = 0;
        int[] arr = new int[15];
        int[] Snack = new int[15];
        int[] Bread = new int[15];
        int[] Fruit = new int[15];
        int[] Drink = new int[15];
        int[] Fish = new int[15];
        int[] PayBackSum = new int[15]; //빚 관련 array
        int[] DebtSum = new int[15]; //빚 관련 array
        int[] lendSum = new int[15]; //빌려준 돈관련 array
        int[] BorrowArr0 = new int[15];
        int[] BorrowArr1 = new int[15];
        int[] BorrowArr2 = new int[15];
        int[] BorrowArr3 = new int[15];
        int[] BorrowArr4 = new int[15];
        int[] BorrowArr5 = new int[15];
        int[] BorrowArr6 = new int[15];
        int[] BorrowArr7 = new int[15];
        int[] BorrowArr8 = new int[15];
        int[] BorrowArr9 = new int[15];
        int[] BorrowArr10 = new int[15];
        int[] BorrowArr11 = new int[15];
        int[] BorrowArr12 = new int[15];
        int[] BorrowArr13 = new int[15];
        int[] BorrowArr14 = new int[15];
        arr[0] = 20000; arr[5] = 10000;
        arr[1] = 20000; arr[6] = 10000;
        arr[2] = 20000; arr[7] = 10000;
        arr[3] = 20000; arr[8] = 10000;
        arr[4] = 20000; arr[9] = 10000;
        for (int i = 10; i < 15; i++) {
            System.out.println(""+i+"번째 손님의 돈을 입력 해주세요");
            arr[i] = sc.nextInt();
            TotalMoney += arr[i];
            if (arr[i] < 0) {
                System.out.println("잘못된 입력입니다");
                i--;
            }
        }
        for (int i = 0; i < 15; i++) {
            int NumFixCount = 0; //다시 메뉴판으로 돌아오면은 초기화되도록설정
            int OutPutCount = 0;
            System.out.println("\n1.과자 1500원  \n2.빵 1000원  \n3.과일 2500원  \n4.음료수 1000원   \n5.생선 4000원  \n6.다음 손님  \n7.종료버튼 \n8.제어 \n9.돈갚기");

            if (ControlCount == 1) {//제어로 진입시 나타난다
                System.out.println("10.이전 손님으로 돌아가기\n");
            }
            System.out.println("" + (i + 1) + "번째 손님의 선택입니다 \n안내 : 현재 소지 금액 "+arr[i]+"원");
            int Select = sc.nextInt();

            if (Select < 1 || Select > 9 && ControlCount == 0) {
                System.out.println("잘못된 입력입니다");
                i--;
            }
            if (Select < 1 || Select > 10 && ControlCount == 1) {
                System.out.println("잘못된 입력입니다");
                i--;
            }
            if (Select == 6 || Select == 7 || Select == 8) {
                if (ControlCount == 1) {
                    System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
                    i--;
                }
            } else if (Select == 10) {
                i = BackCount - 1;
                ControlCount = 0; //컨트롤값 초기화
            }
            if (Select == 1) { /////////과자
                System.out.println("구매할 개수를 적어주세요");
                int Number = sc.nextInt();
                if (arr[i] < (1500 * Number)) { //돈이부족한경우
                    arr[i] -= (1500 * Number); //미리 계산되고 돈을 보충했을경우 자동구매되도록 설계
                    TotalMoney -= (1500 * Number);
                    Snack[i] += Number; //과자 개수 카운트하는 변수
                    Count2 = 1; //돈이 부족할경우
                } else {
                    System.out.println("주문이 완료되었습니다");
                    Snack[i] += Number;
                    SnackCount += 1;
                    arr[i] -= (1500 * Number);
                    TotalMoney -= (1500 * Number);
                    i = i - 1;//계속주문하기위해
                }
            } else if (Select == 2) {/////////빵
                System.out.println("구매할 개수를 적어주세요");
                int Number = sc.nextInt();
                if (arr[i] < (1000 * Number)) {
                    arr[i] -= (1000 * Number);
                    TotalMoney -= (1000 * Number);
                    Bread[i] += Number;
                    Count2 = 1;
                } else {
                    System.out.println("주문이 완료되었습니다");
                    Bread[i] += Number;
                    BreadCount += 1;
                    arr[i] -= (1000 * Number);
                    TotalMoney -= (1000 * Number);
                    i = i - 1;
                }
            } else if (Select == 3) {/////////과일
                System.out.println("구매할 개수를 적어주세요");
                int Number = sc.nextInt();
                if (arr[i] < (2500 * Number)) {
                    arr[i] -= (2500 * Number);
                    TotalMoney -= (2500 * Number);
                    Fruit[i] += Number;
                    Count2 = 1;
                } else {
                    System.out.println("주문이 완료되었습니다");
                    Fruit[i] += Number;
                    FruitCount += 1;
                    arr[i] -= (2500 * Number);
                    TotalMoney -= (2500 * Number);
                    i = i - 1;
                }
            } else if (Select == 4) {/////////음료수
                System.out.println("구매할 개수를 적어주세요");
                int Number = sc.nextInt();
                if (arr[i] < (1000 * Number)) {
                    arr[i] -= (1000 * Number);
                    TotalMoney -= (1000 * Number);
                    Drink[i] += Number;
                    Count2 = 1;
                } else {
                    System.out.println("주문이 완료되었습니다");
                    Drink[i] += Number;
                    DrinkCount += 1;
                    arr[i] -= (1000 * Number);
                    TotalMoney -= (1000 * Number);
                    i = i - 1;
                }
            } else if (Select == 5) {/////////생선
                System.out.println("구매할 개수를 적어주세요");
                int Number = sc.nextInt();
                if (arr[i] < (4000 * Number)) {
                    arr[i] -= (4000 * Number);
                    TotalMoney -= (4000 * Number);
                    Fish[i] += Number;
                    Count2 = 1;
                } else {
                    System.out.println("주문이 완료되었습니다");
                    Fish[i] += Number;
                    FishCount += 1;
                    arr[i] -= (4000 * Number);
                    TotalMoney -= (4000 * Number);
                    i = i - 1;
                }
            } else if (Select == 6) {
                if (SnackCount == 0 && BreadCount == 0 && FishCount == 0 && FruitCount == 0 && DrinkCount == 0) {
                    System.out.println();
                }
                if (SnackCount != 0 || BreadCount != 0 || FishCount != 0 || FruitCount != 0 || DrinkCount != 0) {
                    SnackCount = 0;BreadCount = 0;FishCount = 0;FruitCount = 0;DrinkCount = 0; //다음 손님으로 넘어갈 때 구매한 카운트 초기화
                    Count2 = 0;
                }
            } else if (Select == 7) {
                if (ControlCount == 0) {
                    for (int j = 0; j <= i; j++) {
                        if (Snack[j] == 0 && Bread[j] == 0 && Fruit[j] == 0 && Drink[j] == 0 && Fish[j] == 0) {
                            continue; //하나도 구매하지 않은경우 출력되지 않도록 설정한다
                        }
                        OutPutCount += 1;
                        System.out.println("============주문표============");
                        if (Snack[j] >= 1) {
                            System.out.println("과자 X " + Snack[j] + " = " + (Snack[j] * 1500) + "원");
                        }
                        if (Bread[j] >= 1) {
                            System.out.println("빵 X " + Bread[j] + " = " + (Bread[j] * 1000) + "원");
                        }
                        if (Fruit[j] >= 1) {
                            System.out.println("과일 X " + Fruit[j] + " = " + (Fruit[j] * 2500) + "원");
                        }
                        if (Drink[j] >= 1) {
                            System.out.println("음료수 X " + Drink[j] + " = " + (Drink[j] * 1000) + "원");
                        }
                        if (Fish[j] >= 1) {
                            System.out.println("생선 X " + Fish[j] + " = " + (Fish[j] * 4000) + "원");
                        }

                        System.out.println("===========" + OutPutCount + "번째 손님===========");

                        if (Snack[j] >= 1) {
                            System.out.println("과자 X " + Snack[j] + " = " + (Snack[j] * 1500) + "원");
                        }
                        if (Bread[j] >= 1) {
                            System.out.println("빵 X " + Bread[j] + " = " + (Bread[j] * 1000) + "원");
                        }
                        if (Fruit[j] >= 1) {
                            System.out.println("과일 X " + Fruit[j] + " = " + (Fruit[j] * 2500) + "원");
                        }
                        if (Drink[j] >= 1) {
                            System.out.println("음료수 X " + Drink[j] + " = " + (Drink[j] * 1000) + "원");
                        }
                        if (Fish[j] >= 1) {
                            System.out.println("생선 X " + Fish[j] + " = " + (Fish[j] * 4000) + "원");
                        }
                        System.out.println("현재 가지고 있는 금액 : " + arr[j] + "원  \n빛 진 금액 : " + DebtSum[j] + "원  \n빚을 청산하고 남은 금액 : " + (DebtSum[j] - PayBackSum[j]) + "원  \n미납 된 금액 : " + (DebtSum[j] - PayBackSum[j]) + "원  \n빌려준 금액 : " + lendSum[j] + "원 \n안내 : 해당 손님 제어를 원하시면 8번 제어하기 --> "+(j + 1)+"번을 입력해주세요\n");
                        SnackCount = 0;
                        BreadCount = 0;
                        FishCount = 0;
                        FruitCount = 0;
                        DrinkCount = 0; //다음손님이 물건을 고를때 누적되지 않도록 초기화
                        Count2 = 0; //처음에 손님이고르고 다음손님으로 넘어갈때 count도 초기화
                    }
                }
            } else if (Select == 8) {
                if (ControlCount == 0 && i == 0) {
                    System.out.println("최소 2번째 손님부터 제어가 가능합니다");
                    i--;
                } else if (ControlCount == 0) {
                    System.out.println("몇번째 손님을 제어 하시겠습니까?");
                    BackCount = i; //이전손님의 순서를 미리 저장
                    i = sc.nextInt() - 2;
                    ControlCount = 1;
                }
            } else if (Select == 9) {
                System.out.println("몇번째 손님에게 갚겠습니까?");
                int PeopleSelect = sc.nextInt() - 1;
                System.out.println("얼마를 갚겠습니까?");
                int PayBackMoney = sc.nextInt();

                if (PeopleSelect < 0 || PeopleSelect > 15) {
                    System.out.println("잘못된 입력입니다");
                    i--;
                } else if (PayBackMoney < 0) {
                    System.out.println("잘못된 입력입니다");
                    i--;
                }

                //비효율적임
                for (int k = PeopleSelect; k <= PeopleSelect; k++) {
                    if (i == 0) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr0[k] == 0) { //빌린돈이 0원이라면 빌리지 않은것이니까 내역이 없다고 나옴
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr0[k] < PayBackMoney) { //빌린돈보다 많이 갚는경우
                                System.out.println("빌린 돈은 "+BorrowArr0[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr0[k] >= PayBackMoney) {
                                BorrowArr0[k] -= PayBackMoney; //몇번째 사람에게 빌렸는지 알려주는 배열값에 담긴 돈을 뺌
                                arr[PeopleSelect - 1] -= PayBackMoney; //빌린사람의 돈을 차감
                                lendSum[PeopleSelect] -= PayBackMoney; //빌려준사람의 빌린값에서 차감
                                arr[PeopleSelect] += PayBackMoney; //빌려준사람의 돈을 추가
                                PayBackSum[i] += PayBackMoney; //마지막 종료조건을 위해 빌려준 돈을 모두 합산
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr0[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 1) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr1[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr1[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr1[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr1[k] >= PayBackMoney) {
                                BorrowArr1[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr1[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 2) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr2[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr2[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr2[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr2[k] >= PayBackMoney) {
                                BorrowArr2[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr2[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 3) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr3[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr3[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr3[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr1[k] >= PayBackMoney) {
                                BorrowArr3[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr3[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 4) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr4[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr4[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr1[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr4[k] >= PayBackMoney) {
                                BorrowArr4[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr4[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 5) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr5[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr5[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr5[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr5[k] >= PayBackMoney) {
                                BorrowArr5[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr5[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 6) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr6[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr6[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr6[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr5[k] >= PayBackMoney) {
                                BorrowArr6[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr6[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 7) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr7[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr7[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr7[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr7[k] >= PayBackMoney) {
                                BorrowArr6[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr7[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 8) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr8[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr8[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr8[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr8[k] >= PayBackMoney) {
                                BorrowArr8[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr8[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 9) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr9[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr9[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr9[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr9[k] >= PayBackMoney) {
                                BorrowArr9[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr9[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 10) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr10[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr10[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr10[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr10[k] >= PayBackMoney) {
                                BorrowArr10[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr10[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 11) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr11[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr11[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr11[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr11[k] >= PayBackMoney) {
                                BorrowArr11[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr11[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 12) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr12[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr12[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr12[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr12[k] >= PayBackMoney) {
                                BorrowArr12[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr12[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 13) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr13[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr13[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr13[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr13[k] >= PayBackMoney) {
                                BorrowArr13[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr13[k]+"원");
                                i--;
                                break;
                            }
                        }
                    } else if (i == 14) {
                        if (i == k) {
                            System.out.println("자신에게 돈을 갚을 수 없습니다");
                            i--;
                            break;
                        } else if (BorrowArr14[k] == 0) {
                            System.out.println("돈을 빌린 내역이 없습니다");
                            i--;
                            break;
                        } else if (k > 0) {
                            if (BorrowArr14[k] < PayBackMoney) {
                                System.out.println("빌린 돈은 "+BorrowArr14[k]+"원이며 그 값을 초과 할 수 없습니다");
                                i--;
                            } else if (BorrowArr14[k] >= PayBackMoney) {
                                BorrowArr14[k] -= PayBackMoney;
                                arr[PeopleSelect - 1] -= PayBackMoney;
                                lendSum[PeopleSelect] -= PayBackMoney;
                                arr[PeopleSelect] += PayBackMoney;
                                PayBackSum[i] += PayBackMoney;
                                System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : "+BorrowArr14[k]+"원");
                                i--;
                                break;
                            }
                        }
                    }
                }
            }
            if (Count2 == 1) { ////////////////////돈빌림,돈이부족할때 여기로넘어온다
                if (arr[i] < 1000) {
                    System.out.println("돈이 부족합니다 다시 선택하시겠습니까?  \n1.Yes  \n2.No(돈빌리기)");
                    int ReSelect = sc.nextInt();

                    if (ReSelect == 1) {
                        System.out.println();
                    } else if (ReSelect == 2) {
                        for (int j = i; j < 15; j++) {
                            System.out.println("빌리고싶은 금액을 적어주세요");
                            int Borrow = sc.nextInt();
                            arr[j + 1] -= Borrow; //돈을 빌려주는사람
                            arr[j - NumFixCount] += Borrow; //돈을 받는사람

                            for (int k = j; k <= j; k++) {
                                if (k - NumFixCount == 0) {
                                    BorrowArr0[k + 1] += Borrow;
                                } else if (k - NumFixCount == 1) {
                                    BorrowArr1[k + 1] += Borrow;
                                } else if (k - NumFixCount == 2) {
                                    BorrowArr2[k + 1] += Borrow;
                                } else if (k - NumFixCount == 3) {
                                    BorrowArr3[k + 1] += Borrow;
                                } else if (k - NumFixCount == 4) {
                                    BorrowArr4[k + 1] += Borrow;
                                } else if (k - NumFixCount == 5) {
                                    BorrowArr5[k + 1] += Borrow;
                                } else if (k - NumFixCount == 6) {
                                    BorrowArr6[k + 1] += Borrow;
                                } else if (k - NumFixCount == 7) {
                                    BorrowArr7[k + 1] += Borrow;
                                } else if (k - NumFixCount == 8) {
                                    BorrowArr8[k + 1] += Borrow;
                                } else if (k - NumFixCount == 9) {
                                    BorrowArr9[k + 1] += Borrow;
                                } else if (k - NumFixCount == 10) {
                                    BorrowArr10[k + 1] += Borrow;
                                } else if (k - NumFixCount == 11) {
                                    BorrowArr11[k + 1] += Borrow;
                                } else if (k - NumFixCount == 12) {
                                    BorrowArr12[k + 1] += Borrow;
                                } else if (k - NumFixCount == 13) {
                                    BorrowArr13[k + 1] += Borrow;
                                } else if (k - NumFixCount == 14) {
                                    BorrowArr14[k + 1] += Borrow;
                                }
                            }
                            if (arr[j + 1] >= 0 && arr[j - NumFixCount] >= 0) { //다음사람이 가지고있는 돈보다 적게 빌리지만 계산된값이 음수가 아니라 통과된경우
                                lendSum[j + 1] += Borrow; //다음 사람이 빌려준 금액을 누적
                                DebtSum[j - NumFixCount] += Borrow; //빛진금액 누적
                                System.out.println("" + Borrow + "원을 빌려 현재 " + arr[j - NumFixCount] + "원  \n다음사람의 돈은 " + arr[j + 1] + "원 입니다  \n1.추가로 빌린다  2.빌리지 않는다");
                                int BorrowSelect = sc.nextInt();//가진돈은 물건값을 구매하고 남은돈이다

                                if (BorrowSelect == 1) {
                                    if (ControlCount == 0) {
                                        NumFixCount += 1;//더 빌리는경우 그 사람이 계속 고정되고 빌려주는사람만 다다음사람으로 이동되도록 해야하기 때문에 더빌릴때마다 count가 늘어남
                                    } else if (ControlCount != 0) {
                                        NumFixCount += 1;
                                    }
                                } else if (BorrowSelect == 2) {
                                    if (arr[j - NumFixCount] >= 4000) {
                                        System.out.println("안내 : 과자,빵,과일,음료수.생선을 구매 할 수 있습니다");
                                    } else if (arr[j - NumFixCount] < 4000 && arr[j - NumFixCount] >= 2500) {
                                        System.out.println("안내 : 과자,빵,과일,음료수를 구매 할 수 있습니다");
                                    } else if (arr[j - NumFixCount] < 2500 && arr[j - NumFixCount] >= 1500) {
                                        System.out.println("안내 : 과자,빵,음료수를 구매 할 수 있습니다");
                                    } else if (arr[j - NumFixCount] < 1500 && arr[j - NumFixCount] >= 1000) {
                                        System.out.println("안내 : 빵,음료수를 구매 할 수 있습니다");
                                    }
                                    i--;
                                    break;
                                } else {
                                    System.out.println("잘못된 입력입니다");
                                    break;
                                }
                            } else if (Borrow == 0 || Borrow < 0) {
                                System.out.println("최소 1원 이상 빌릴 수 있습니다");
                                j--;
                            } else if (arr[j + 1] < 0) {//다음사람이 가지고있는 돈보다 많이 빌리려고 하는경우
                                arr[j + 1] += Borrow;
                                arr[j - NumFixCount] -= Borrow; //받거나 준것 그대로 반환
                                System.out.println("다음사람이 가진 돈은 "+arr[j + 1]+"원이며 이보다 더 많이 빌릴 수 없습니다");
                                j--;
                            } else if (arr[j + 1] > 0 && arr[j - NumFixCount] < 0) {
                                System.out.println("돈을 "+-(arr[j - NumFixCount])+"원 부족합니다 돈을 더 빌리세요");
                                NumFixCount += 1;
                            } else {
                                System.out.println("잘못된 입력입니다");
                                i--;
                            }
                        }
                        Count2 = 0; //루프를 빠져나오면서 Count값 초기화
                    }
                }
            }
        }
        System.out.println("모든 사람의 남은 금액은 "+TotalMoney+"원 입니다");
    }
}
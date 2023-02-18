import java.util.Scanner;
public class forwhile38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Count = 0; //각 메뉴로 넘겨주는 변수
        int Controlconditionscheck = 0;  //제어상황을 확인한다 0이면 제어를 하지않은상태 1이면 제어를 하고있는상태
        int Rememberinumber = 0; //제어를 들어가기전 현재i값을 저장하는 변수
        int iControler = 0; //제어를 할때 i값을 변환시킬수 있도록 도와주는 보조변수
        int Sequentialoutputcount = 0; //물건을 구매한 손님의 순서만출력되도록 count해주는 변수
        int Peopletotalmoney = 0; //가지고있는돈 - 사용한돈
        int[] Defttotalsum = new int[15]; //전체 빚진금액
        int[] Borrowtotalsum = new int[15]; //전체 빌려준금액
        int[] Paybacktotalsum = new int[15]; //전체 갚은금액
        int[] Originalamount = new int[15]; //모든 사람이 가지고 있는 원래의 돈을 저장하는 배열
        int[][] MoneyandFoodnumber = new int[15][6]; //15명의사람이 총 5가지의 음식개수를 기억하도록함
        int[][] Deftmoney = new int[15][15]; //빚진금액
        int[][] Borrowmoney = new int[15][15]; //빌려준금액
        //횡렬 1번 = 과자개수
        //2번 = 빵개수
        //3번 = 과일개수
        //4번 = 생선개수
        //5번 = 술개수
        MoneyandFoodnumber[0][0] = 20000;
        MoneyandFoodnumber[1][0] = 20000;
        MoneyandFoodnumber[2][0] = 20000;
        MoneyandFoodnumber[3][0] = 20000;
        MoneyandFoodnumber[4][0] = 20000;
        MoneyandFoodnumber[5][0] = 10000;
        MoneyandFoodnumber[6][0] = 10000;
        MoneyandFoodnumber[7][0] = 10000;
        MoneyandFoodnumber[8][0] = 10000;
        MoneyandFoodnumber[9][0] = 10000;

        for (int i = 10; i < 15; i++) {
            System.out.println("" + (i + 1) + "번째 손님의 돈");
            MoneyandFoodnumber[i][0] = sc.nextInt();
            if (MoneyandFoodnumber[i][0] < 1) {
                System.out.println("돈은 최소 1원부터 입력 가능합니다");
                MoneyandFoodnumber[i][0] = 0;
                i--;
            } else {
                Peopletotalmoney += MoneyandFoodnumber[i][0];
            }
        }
        for (int i = 0;i < 15;i++) {
            Originalamount[i] += MoneyandFoodnumber[i][0];
        }
        System.out.println("<<<모든 사람의 돈 입력이 완료되었습니다>>>");

        for (int i = 0; i < 14; i = iControler) {
            int Foodorderpricesave = 0; //가격 저장
            int BorrowOrdercheck = 0; //계속빌리는경우 체크가 올라가서 다음사람 다다음사람에게 빌리도록함
            if (Controlconditionscheck == 0) {
                System.out.println("1.과자[1300원] 2.빵[1100원] 3.과일[2500원] 4.생선[4000원] 5.술[10000원] 6.환불 7.돈갚기 8.다음손님 9.제어");
            } else {
                System.out.println("1.과자[1300원] 2.빵[1100원] 3.과일[2500원] 4.생선[4000원] 5.술[10000원] 6.환불 7.돈갚기 8.다음손님 9.제어 10.이전 손님으로 돌아가기");
            }
            System.out.println("" + (i + 1) + "번째 손님의 선택입니다 잔액 : " + MoneyandFoodnumber[i][0] + "원");
            int Meinmenuchoice = sc.nextInt();

            if (Meinmenuchoice == 1) {
                Foodorderpricesave = 1300;
                Count = 1;
            } else if (Meinmenuchoice == 2) {
                Foodorderpricesave = 1100;
                Count = 1;
            } else if (Meinmenuchoice == 3) {
                Foodorderpricesave = 2500;
                Count = 1;
            } else if (Meinmenuchoice == 4) {
                Foodorderpricesave = 4000;
                Count = 1;
            } else if (Meinmenuchoice == 5) {
                Foodorderpricesave = 10000;
                Count = 1;
            } else if (Meinmenuchoice == 6) {
                Count = 3;
            } else if (Meinmenuchoice == 7) {
                Count = 4;
            } else if (Meinmenuchoice == 8) {
                if (Controlconditionscheck == 0) {
                    Count = 5;
                } else {
                    System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
                }
            } else if (Meinmenuchoice == 9) {
                if (i > 0) {
                    Count = 6;
                } else {
                    System.out.println("최소 2번째 손님부터 가능합니다");
                }
            } else if (Meinmenuchoice == 10) {
                if (Controlconditionscheck == 0) {
                    System.out.println("잘못된 입력입니다");
                } else {
                    iControler = Rememberinumber;
                    Controlconditionscheck = 0;
                    Rememberinumber = 0;
                    Count = 0;
                }
            }
            if (Count == 1) {
                //주문메뉴
                System.out.println("몇개를 주문하시겠습니까?");
                int Foodordernumber = sc.nextInt();
                MoneyandFoodnumber[i][0] -= (Foodorderpricesave * Foodordernumber);

                if (MoneyandFoodnumber[i][0] < 0) {
                    System.out.println("돈이 " + (MoneyandFoodnumber[i][0] * -1) + "원 부족합니다 추가로 빌리시겠습니까? 1.Yes 2.No");
                    int Borrowchoice = sc.nextInt();

                    while (true) {
                        if (Borrowchoice == 1) {
                            System.out.println("얼마를 빌리시겠습니까?");
                            int Borrowmoneyinput = sc.nextInt();
                            MoneyandFoodnumber[i][0] += Borrowmoneyinput; //빌리는사람은 돈이 증가하며

                            if ((MoneyandFoodnumber[i + 1 + BorrowOrdercheck][0] - Borrowmoneyinput) < 0) {
                                System.out.println("다음 사람이 가지고 있는 잔액보다 많이 빌릴 수 없습니다 다음사람 잔액 : " + MoneyandFoodnumber[i + 1 + BorrowOrdercheck][0] + "원");
                                MoneyandFoodnumber[i][0] -= Borrowmoneyinput;
                            } else if (MoneyandFoodnumber[i][0] < 0) {
                                System.out.println("돈이 부족합니다 다시 입력해주세요");
                                MoneyandFoodnumber[i][0] -= Borrowmoneyinput;
                            } else {
                                Defttotalsum[i] += Borrowmoneyinput; //i번째 사람이 빚지고있는 전체금액
                                Borrowtotalsum[i + 1 + BorrowOrdercheck] += Borrowmoneyinput; //빌려준사람이 얼마나 빌려줬는지 체크
                                MoneyandFoodnumber[i + 1 + BorrowOrdercheck][0] -= Borrowmoneyinput; //빌려주는사람은 돈을 차감한다
                                Deftmoney[i][i + 1 + BorrowOrdercheck] += Borrowmoneyinput; //빌리는사람은 누구에게 빚이있는지 기억하는 배열
                                Borrowmoney[i + 1 + BorrowOrdercheck][i] += Borrowmoneyinput; // 빌려주는사람은 누구에게 빌려줬는지 체크

                                System.out.println("돈을 " + Borrowmoneyinput + "원을 빌려 총 " + MoneyandFoodnumber[i][0] + "원이 되었습니다 추가적으로 빌리겠습니까?  1.Yes 2.No");
                                int Plusborrowchoice = sc.nextInt();

                                if (Plusborrowchoice == 1) {
                                    BorrowOrdercheck += 1;
                                } else if (Plusborrowchoice == 2) {
                                    Count = 2;
                                    break;
                                } else {
                                    System.out.println("잘못된 입력입니다");
                                    break;
                                }
                            }
                        } else if (Borrowchoice == 2) {
                            MoneyandFoodnumber[i][0] += (Foodorderpricesave * Foodordernumber);
                            break;
                        } else {
                            System.out.println("잘못된 입력입니다");
                            MoneyandFoodnumber[i][0] += (Foodorderpricesave * Foodordernumber);
                            break;
                        }
                    }
                } else {
                    Count = 2;
                }
                if (Count == 2) {
                    //save된 가격을 바탕으로 어떤 음식을 삿는지 판단하고 추가함
                    if (Foodorderpricesave == 1300) {
                        MoneyandFoodnumber[i][1] += Foodordernumber;
                    } else if (Foodorderpricesave == 1100) {
                        MoneyandFoodnumber[i][2] += Foodordernumber;
                    } else if (Foodorderpricesave == 2500) {
                        MoneyandFoodnumber[i][3] += Foodordernumber;
                    } else if (Foodorderpricesave == 4000) {
                        MoneyandFoodnumber[i][4] += Foodordernumber;
                    } else {
                        MoneyandFoodnumber[i][5] += Foodordernumber;
                    }
                    System.out.println("구매가 완료되었습니다");
                }
            } else if (Count == 3) {
                if (MoneyandFoodnumber[i][1] == 0 && MoneyandFoodnumber[i][2] == 0 && MoneyandFoodnumber[i][3] == 0 && MoneyandFoodnumber[i][4] == 0 && MoneyandFoodnumber[i][5] == 0) {
                    System.out.println("음식을 구매한 내역이 없습니다");
                } else {
                    while (true) {
                        System.out.println("어떤 음식을 환불하시겠습니까? 1.과자 2.빵 3.과일 4.생선 5.술 6,돌아가기");
                        int Refundmenuchoice = sc.nextInt();

                        if (Refundmenuchoice == 6) {
                            break;
                        } else if (Refundmenuchoice < 1 || Refundmenuchoice > 6) {
                            System.out.println("잘못된 입력입니다");
                        }
                        if (MoneyandFoodnumber[i][Refundmenuchoice] != 0) {
                            MoneyandFoodnumber[i][Refundmenuchoice] -= 1;
                            if (Refundmenuchoice == 1) {
                                MoneyandFoodnumber[i][0] += 1300;
                            } else if (Refundmenuchoice == 2) {
                                MoneyandFoodnumber[i][0] += 1100;
                            } else if (Refundmenuchoice == 3) {
                                MoneyandFoodnumber[i][0] += 2500;
                            } else if (Refundmenuchoice == 4) {
                                MoneyandFoodnumber[i][0] += 4000;
                            } else if (Refundmenuchoice == 5) {
                                MoneyandFoodnumber[i][0] += 10000;
                            }
                            System.out.println("환불이 완료되었습니다");
                            break;
                        } else {
                            System.out.println("수량을 다시 확인해주세요 \n1.과자 : " + MoneyandFoodnumber[i][1] + "개 \n2.빵 : " + MoneyandFoodnumber[i][2] + "개 \n3.과일 : " + MoneyandFoodnumber[i][3] + "개 \n4.생선 : " + MoneyandFoodnumber[i][4] + "개 \n5.술 : " + MoneyandFoodnumber[i][5] + "개");
                        }
                    }
                }
            } else if (Count == 4) {
                while (true) {
                    System.out.println("몇번째 손님에게 돈을 갚겠습니까?");
                    int Paybackpeoplechoice = sc.nextInt() - 1;

                    if (Deftmoney[i][Paybackpeoplechoice] >= 1 && Borrowmoney[Paybackpeoplechoice][i] >= 1) {
                        System.out.println("얼마를 갚겠습니까? " + (Paybackpeoplechoice + 1) + "번째 손님에게 빌린 금액 : " + Deftmoney[i][Paybackpeoplechoice] + "원");
                        int Paybackmoney = sc.nextInt();

                        if (Deftmoney[i][Paybackpeoplechoice] >= Paybackmoney && MoneyandFoodnumber[i][0] > Paybackmoney) {
                            Deftmoney[i][Paybackpeoplechoice] -= Paybackmoney;
                            Borrowmoney[Paybackpeoplechoice][i] -= Paybackmoney;
                            MoneyandFoodnumber[i][0] -= Paybackmoney;
                            MoneyandFoodnumber[Paybackpeoplechoice][0] += Paybackmoney;
                            Paybacktotalsum[i] -= Paybackmoney;
                            System.out.println("돈을 성공적으로 갚았습니다 해당 손님에게 남은 빚 : "+Deftmoney[i][Paybackpeoplechoice]+"원\n");
                            iControler -= 1;
                            break;
                        } else {
                            System.out.println("갚는돈이 더 많거나 자신이 가지고있는 금액을 초과해서 갚을 수 없습니다");
                        }
                    } else {
                        System.out.println("돈을 빌린내역이 없습니다");
                    }
                }
                iControler += 1;
            } else if (Count == 5) {
                for (int j = 0; j < 15; j++) {
                    if (MoneyandFoodnumber[j][1] == 0 && MoneyandFoodnumber[j][2] == 0 && MoneyandFoodnumber[j][3] == 0 && MoneyandFoodnumber[j][4] == 0 && MoneyandFoodnumber[j][5] == 0) {
                        continue;
                    } else {
                        Sequentialoutputcount += 1;
                    }
                    System.out.println("=================" + Sequentialoutputcount + "번째 손님의 주문서================");
                    if (MoneyandFoodnumber[j][1] >= 1) {
                        System.out.println("과자 X " + MoneyandFoodnumber[j][1] + "개 = " + (MoneyandFoodnumber[j][1] * 1300) + "원");
                    }
                    if (MoneyandFoodnumber[j][2] >= 1) {
                        System.out.println("빵 X " + MoneyandFoodnumber[j][2] + "개 = " + (MoneyandFoodnumber[j][2] * 1100) + "원");
                    }
                    if (MoneyandFoodnumber[j][3] >= 1) {
                        System.out.println("과일 X " + MoneyandFoodnumber[j][3] + "개 = " + (MoneyandFoodnumber[j][3] * 2500) + "원");
                    }
                    if (MoneyandFoodnumber[j][4] >= 1) {
                        System.out.println("생선 X " + MoneyandFoodnumber[j][4] + "개 = " + (MoneyandFoodnumber[j][4] * 4000) + "원");
                    }
                    if (MoneyandFoodnumber[j][5] >= 1) {
                        System.out.println("술 X " + MoneyandFoodnumber[j][5] + "개 = " + (MoneyandFoodnumber[j][5] * 10000) + "원");
                    }
                    System.out.println("=================================================");
                    System.out.println("처음에 가지고 있던 금액 : " + Originalamount[j] + "원");
                    System.out.println("현재 가지고 있는 금액 : "+MoneyandFoodnumber[j][0]+"원");
                    System.out.println("전체 빌려준  금액 : " + Borrowtotalsum[j] + "원");
                    System.out.println("전체 빚진금액 : " + Defttotalsum[j] + "원");
                    System.out.println("빚을 청산하고 남은 금액 : " + (Defttotalsum[j] - Paybacktotalsum[j]) + "원");
                    System.out.println("=================================================");
                }
                Sequentialoutputcount = 0;
                iControler += 1;
            } else if (Count == 6) {
                Rememberinumber += i; //제어를 하기전 현재 i값의 번호를 따로 저장하고 10.이전손님으로 돌아갈때 이전의 손님번호로 되돌리기위한 변수
                System.out.println("몇번째 손님을 제어하시겠습니까?");
                iControler = sc.nextInt() - 1; //icontrol에 입력을 받음으로써 for문의 i값을 결정한다 -1이 있는이유는 1번째 손님이라면 index는 0번이기 때문이다
                Controlconditionscheck = 1; //제어상황을 확인한다 0이면 제어를 하지않은상태 1이면 제어를 하고있는상태
                Count = 0;
            }
        }
        System.out.println("전체 손님의 남은돈은 총 "+Peopletotalmoney+"원 입니다");
    }
}

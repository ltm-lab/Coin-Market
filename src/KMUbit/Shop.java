package KMUbit;

import java.util.Scanner;

public class Shop extends Coin {
	static void buy_coin(int coin, int cnt) {
		if (coin > 0 && coin < 7) {
			int useMoney = price[coin - 1] * cnt;

			if (Player.money >= useMoney) {
				Player.money -= useMoney;
				Player.my_coins[coin - 1] += cnt;
				System.out.println("  코인 매수!");
			} else {
				System.out.println("  소지금이 적어 코인 매수에 실패하였습니다.");
			}
		} else {
			System.out.println("  해당 번호에 해당하는 코인이 없어 매수에 실패하였습니다.");
		}
	}

	static void sell_coin(int coin, int cnt) {
		if (coin > 0 && coin < 7) {
			int useMoney = price[coin - 1] * cnt;

			if (Player.my_coins[coin - 1] >= cnt) {
				Player.my_coins[coin - 1] -= cnt;
				Player.money += useMoney;
				System.out.println("  코인 매도!");
			} else {
				System.out.println("  현재 보유하고 있는 코인보다 많은 코인을 매도할 수 없습니다.");
			}
		} else {
			System.out.println("  해당 번호에 해당하는 코인이 없어 매도에 실패하였습니다.");
		}
	}

	static void buy_hint(int coin, int level) {
		if (coin > 0 && coin < 7) {
			if (level == 1) {
				if (Player.money >= 5000) {
					Player.money -= 5000;

					if (tm_price[coin - 1] > price[coin - 1]) {
						System.out.println("  " + coins[coin - 1] + "은(는) 내일 가격이 [상승]할 예정입니다.");
					} else {
						System.out.println("  " + coins[coin - 1] + "은(는) 내일 가격이 [하락]할 예정입니다.");
					}
				} else {
					System.out.println("  소지금이 적어 하급정보 구매를 실패하였습니다.");
				}
			} else if (level == 2) {
				if (Player.money >= 10000) {
					Player.money -= 10000;

					if (tm_price[coin - 1] > price[coin - 1]) {
						System.out.println(
								"  " + coins[coin - 1] + "은(는) 내일 가격이 [" + tm_percent[coin - 1] + "% 상승]할 예정입니다.");
					} else {
						System.out.println(
								"  " + coins[coin - 1] + "은(는) 내일 가격이 [" + -tm_percent[coin - 1] + "% 하락]할 예정입니다.");
					}
				} else {
					System.out.println("  소지금이 적어 고급정보 구매를 실패하였습니다.");
				}
			} else {
				System.out.println("  해당 등급에 해당하는 힌트가 없어 힌트 구매에 실패하였습니다.");
			}
		} else {
			System.out.println("  해당 번호에 해당하는 코인이 없어 힌트 구매에 실패하였습니다.");
		}
	}

	static void buy_item(int type) {
		Scanner sc = new Scanner(System.in);
		if (type == 1) {
			System.out.print("  채굴하실 코인의 번호를 입력해주세요 : ");
			int cn = sc.nextInt();
			if (Player.money >= 200000) {
				if (cn > 0 && cn < 7) {
					Player.money -= 200000;
					Player.have_item[0] = cn - 1;
					System.out.println("  다음 턴 부터 [" + coins[cn - 1] + "]의 채굴을 시작합니다!");
				} else {
					System.out.println("  해당 번호에 해당하는 코인이 없어 채굴기 구매에 실패하였습니다.");
				}
			} else {
				System.out.println("  소지금이 부족하여 채굴기 구매에 실패하였습니다.");
			}
		} else if (type == 2) {
			if (Player.have_item[1] == 0) {
				if (Player.money >= 200000) {
					Player.money -= 200000;
					Player.have_item[1] = 1;
					System.out.println("  다음 턴 부터 소지금 50,000원의 채굴을 시작합니다!");
				} else {
					System.out.println("  소지금이 부족하여 채굴기 구매에 실패하였습니다.");
				}
			} else {
				System.out.println("  이미 현금채굴기를 보유하고 있습니다.");
			}
		} else {
			System.out.println("  해당하는 번호의 채굴기가 없어 구매에 실패하였습니다.");
		}
	}
}

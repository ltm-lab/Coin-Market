package KMUbit;

public class Shop extends Coin {
	static void buy_coin(int coin, int cnt) {
		if (coin > 0 && coin < 7) {
			int useMoney = price[coin - 1] * cnt;

			if (Player.money >= useMoney) {
				Player.money -= useMoney;
				Player.my_coins[coin - 1] += cnt;
				System.out.println("���� �ż�!");
			} else {
				System.out.println("�������� ���� ���� �ż��� �����Ͽ����ϴ�.");
			}
		} else {
			System.out.println("�ش� ��ȣ�� �ش��ϴ� ������ ���� �ż��� �����Ͽ����ϴ�.");
		}
	}

	static void sell_coin(int coin, int cnt) {
		if (coin > 0 && coin < 7) {
			int useMoney = price[coin - 1] * cnt;

			if (Player.my_coins[coin - 1] >= cnt) {
				Player.my_coins[coin - 1] -= cnt;
				Player.money += useMoney;
				System.out.println("���� �ŵ�!");
			} else {
				System.out.println("���� �����ϰ� �ִ� ���κ��� ���� ������ �ŵ��� �� �����ϴ�.");
			}
		} else {
			System.out.println("�ش� ��ȣ�� �ش��ϴ� ������ ���� �ŵ��� �����Ͽ����ϴ�.");
		}
	}

	static void buy_hint(int coin, int level) {
		if (coin > 0 && coin < 7) {
			if (level == 1) {
				if (Player.money >= 5000) {
					Player.money -= 5000;

					if (tm_price[coin - 1] > price[coin - 1]) {
						System.out.println(coins[coin - 1] + "��(��) ���� ������ [���]�� �����Դϴ�.");
					} else {
						System.out.println(coins[coin - 1] + "��(��) ���� ������ [�϶�]�� �����Դϴ�.");
					}
				} else {
					System.out.println("�������� ���� �ϱ����� ���Ÿ� �����Ͽ����ϴ�.");
				}
			} else if (level == 2) {
				if (Player.money >= 10000) {
					Player.money -= 10000;

					if (tm_price[coin - 1] > price[coin - 1]) {
						System.out.println(coins[coin - 1] + "��(��) ���� ������ [" + tm_percent[coin - 1] + "% ���]�� �����Դϴ�.");
					} else {
						System.out.println(coins[coin - 1] + "��(��) ���� ������ [" + -tm_percent[coin - 1] + "% �϶�]�� �����Դϴ�.");
					}
				} else {
					System.out.println("�������� ���� ������� ���Ÿ� �����Ͽ����ϴ�.");
				}
			} else {
				System.out.println("�ش� ��޿� �ش��ϴ� ��Ʈ�� ���� ��Ʈ ���ſ� �����Ͽ����ϴ�.");
			}
		} else {
			System.out.println("�ش� ��ȣ�� �ش��ϴ� ������ ���� ��Ʈ ���ſ� �����Ͽ����ϴ�.");
		}
	}
}

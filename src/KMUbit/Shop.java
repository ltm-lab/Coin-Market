package KMUbit;

public class Shop extends Coin {
	static void buy_coin(int coin, int cnt) {
		if (coin > 0 && coin < 7) {
			int useMoney = price[coin - 1] * cnt;

			if (Player.money >= useMoney) {
				Player.money -= useMoney;
				Player.my_coins[coin - 1] += cnt;
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
			} else {
				System.out.println("���� �����ϰ� �ִ� ���κ��� ���� ������ �ŵ��� �� �����ϴ�.");
			}
		} else {
			System.out.println("�ش� ��ȣ�� �ش��ϴ� ������ ���� �ŵ��� �����Ͽ����ϴ�.");
		}
	}

	static void buy_hint(int coin, int level) {
		if (level == 1) {

		} else if (level == 2) {

		} else {

		}
	}
}

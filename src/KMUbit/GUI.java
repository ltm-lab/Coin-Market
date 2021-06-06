package KMUbit;

import java.util.Scanner;

public class GUI extends Player {
	static void title() {
		System.out.println("  ==================================================================");
		System.out.println("  |                          KMUbit(v1.0)                          |");
		System.out.println("  ==================================================================");
	}

	static void clear() {
		for (int i = 0; i < 15; i++)
			System.out.println();
	}

	static void startGame() {
		Scanner sc = new Scanner(System.in);
		title();
		System.out.println("  |                                                                |");
		System.out.println("  |                          1. ���� ����                            |");
		System.out.println("  |                          2. ���� ����                            |");
		System.out.println("  |                                                                |");
		System.out.println("  ==================================================================");
		int input = sc.nextInt();
		if (input == 1) {
			clear();
			inGame();
		} else if (input == 2) {
			clear();
			gameInfo();
		} else {
			System.out.println("������ �����մϴ�.");
		}
	}

	static void inGame() {
		while (gameOver) {
			turnOver = true;
			tomorrow();
			while (turnOver) {
				crntCoin();
			}
			today();
			if (money >= 1000000)
				gameOver = false;
		}
		endGame(true);
	}

	static void gameInfo() {
		Scanner sc = new Scanner(System.in);
		title();
		System.out.println("  |                                                                |");
		System.out.println("  |       �� ������ �ƹ��ų� ������ ������ ���θŸ� �ùķ��̼� �����Դϴ�.       |");
		System.out.println("  |   ������ ������ ������ �Ÿ��Ͽ� ������ ��ǥġ(100����)�� �޼��Ͻø� Ŭ����!   |");
		System.out.println("  |                                                                |");
		System.out.println("  |                      Developed By �ƹ��ų���                     |");
		System.out.println("  |                                                                |");
		System.out.println("  ==================================================================");
		System.out.print("  �ʱ�ȭ������ ���÷��� 1�� �Է����ּ���.\n");
		int input = sc.nextInt();
		if (input == 1) {
			clear();
			startGame();
		} else {
			clear();
			endGame(false);
		}
	}

	static void endGame(boolean type) {
		if (type) {
			title();
			System.out.println("  |                                                                |");
			System.out.println("  |           " + day + "�� ���� ��ǥ�ݾ��� �޼��Ͽ� ������ Ŭ���� �Ͽ����ϴ�!           |");
			System.out.println("  |                                                                |");
			System.out.println("  |                      Thanks for playing!                       |");
			System.out.println("  |                                                                |");
			System.out.println("  ==================================================================");
		} else {
			title();
			System.out.println("  |                                                                |");
			System.out.println("  |                �߸��� �Է����� ���� ������ ����Ǿ����ϴ�!                |");
			System.out.println("  |                                                                |");
			System.out.println("  |                      Thanks for playing!                       |");
			System.out.println("  |                                                                |");
			System.out.println("  ==================================================================");
		}
	}

	static void crntCoin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("  ==================================================================");
		System.out.printf("  |                 KMUbit(Day " + day + ")            ���� ������ : %06d��   |\n", money);
		System.out.println("  ==================================================================");
		System.out.println("  | ��ȣ |    ����    |   ����ü�   |  ��������  |   �򰡱ݾ�   |   �����   |");
		System.out.println("  ------------------------------------------------------------------");
		for (int i = 0; i < 6; i++) {
			System.out.printf("  | %d |   %s    |    %04d    |   %03d   |   %06d   |   %02d%%   |\n", (i + 1), coins[i],
					price[i], my_coins[i], my_coins[i] * price[i], percent[i]);
		}
		System.out.println("  ==================================================================");
		System.out.println("  1: ���� �ż�, 2: ���� �ŵ�, 3: ���� ����, 4: ä���� ����, 5: �� ���� ");
		int input = sc.nextInt();
		if (input == 1) {
			System.out.print("  �ż��� ���ι�ȣ �� ���� ������ �Է����ּ���.\n  ex)1 10 ");
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			clear();
			buy_coin(tmp1, tmp2);
		} else if (input == 2) {
			System.out.print("  �ŵ��� ���ι�ȣ �� ���� ������ �Է����ּ���.\n  ex)1 10 ");
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			clear();
			sell_coin(tmp1, tmp2);
		} else if (input == 3) {
			System.out.print("  ������ Ȯ���ϰ� ���� ���� ��ȣ�� ���� ����� �Է����ּ���. \n  1: �ϱ�����(5,000��), 2: �������(10,000��)\n  ex)2 1 ");
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			clear();
			buy_hint(tmp1, tmp2);
		} else if (input == 4) {
			System.out.print(
					"  �����Ͻ� ä���� ������ �������ּ���.(200,000��)\n  1: ����ä����(�� �ϸ��� �����Ͻ� ������ 10���� ä���մϴ�.)\n  2: ����ä����(�� �ϸ��� 50,000���� �������� ä���մϴ�.) ");
			int type = sc.nextInt();
			clear();
			buy_item(type);
		} else if (input == 5) {
			turnOver = false;
			clear();
			System.out.println("  ���� ���� �Ǿ����ϴ�.");
			if (have_item[0] != -1) {
				my_coins[have_item[0]] += 10;
				System.out.println("  ����ä���Ⱑ [" + coins[have_item[0]] + "]�� 10�� ä���Ͽ����ϴ�!");
			}
			if (have_item[1] == 1) {
				money += 50000;
				System.out.println("  ����ä���Ⱑ 50,000���� ä���Ͽ����ϴ�!");
			}
		} else {
			clear();
			endGame(false);
		}
	}

	public static void main(String[] args) {
		startGame();
	}
}

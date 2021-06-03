package KMUbit;

import java.util.Scanner;

public class GUI extends Player {
	static void title() {
		System.out.println("==================================================================");
		System.out.println("|                          KMUbit(v1.0)                          |");
		System.out.println("==================================================================");
	}

	static void clear() {
		for (int i = 0; i < 15; i++)
			System.out.println();
	}

	static void startGame() {
		Scanner sc = new Scanner(System.in);
		title();
		System.out.println("|                                                                |");
		System.out.println("|                          1. ���� ����                            |");
		System.out.println("|                          2. ���� ����                            |");
		System.out.println("|                                                                |");
		System.out.println("==================================================================");
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
			tomorrow();
			while (turnOver) {
				crntCoin();
			}
			today();
		}
		endGame(true);
	}

	static void gameInfo() {
		Scanner sc = new Scanner(System.in);
		title();
		System.out.println("|                                                                |");
		System.out.println("|        �� ������ �ƹ��ų� ������ ������ ���θŸ� �ùķ��̼� �����Դϴ�.        |");
		System.out.println("|        ������ ������ ������ �Ÿ��Ͽ� ������ ��ǥġ�� �޼��Ͻø� Ŭ����!        |");
		System.out.println("|                                                                |");
		System.out.println("|                      Developed By �ƹ��ų���                      |");
		System.out.println("|                                                                |");
		System.out.println("==================================================================");
		System.out.print("�ʱ�ȭ������ ���÷��� 1�� �Է����ּ���.");
		int input = sc.nextInt();
		if (input == 1) {
			clear();
			startGame();
		} else
			endGame(false);
	}

	static void endGame(boolean type) {
		if (type) {
			title();
			System.out.println("|                                                                |");
			System.out.println("|      " + day + "�� ���� ��ǥ�ݾ��� �޼��Ͽ� ������ Ŭ���� �Ͽ����ϴ�!       |");
			System.out.println("|                                                                |");
			System.out.println("|                      Thanks for playing!                       |");
			System.out.println("|                                                                |");
			System.out.println("==================================================================");
		} else {
			title();
			System.out.println("|                                                                |");
			System.out.println("|                �߸��� �Է����� ���� ������ ����Ǿ����ϴ�!                |");
			System.out.println("|                                                                |");
			System.out.println("|                      Thanks for playing!                       |");
			System.out.println("|                                                                |");
			System.out.println("==================================================================");
		}
	}

	static void crntCoin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==================================================================");
		System.out.println("|                        KMUbit(Day " + day + ")                        |");
		System.out.println("==================================================================");
		System.out.println("| ��ȣ |    ����    |   ����ü�   |  ��������  |   �򰡱ݾ�   |   �����   |");
		System.out.println("------------------------------------------------------------------");
		for (int i = 0; i < 6; i++) {
			System.out.println("| " + (i + 1) + " |    " + coins[i] + "    |    " + price[i] + "    |   " + my_coins[i]
					+ "   |   " + (my_coins[i] * price[i]) + "   |  " + percent[i] + "%  |");
		}
		System.out.println("==================================================================");
		System.out.print("1: ���� �ż�, 2: ���� �ŵ�, 3: ������ ����, 4: �� ����");
		int input = sc.nextInt();
		if (input == 1) {
			System.out.print("�ż��� ���ι�ȣ �� ���� ������ �Է����ּ���. ex)1 10 ");
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			buy_coin(tmp1, tmp2);
		} else if (input == 2) {
			System.out.print("�ŵ��� ���ι�ȣ �� ���� ������ �Է����ּ���. ex)1 10 ");
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			sell_coin(tmp1, tmp2);
		} else if (input == 3) {
			System.out.print("������ Ȯ���ϰ� ���� ���� ��ȣ�� ��Ʈ ������ �Է����ּ���.(1: �ʱ���Ʈ, 2: �����Ʈ) ex)2 1 ");
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			buy_hint(tmp1, tmp2);
		} else if (input == 4) {
			turnOver = false;
		} else {
			endGame(false);
		}
	}

	public static void main(String[] args) {
		startGame();
	}
}

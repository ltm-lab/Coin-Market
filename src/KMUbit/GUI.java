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
			// inGame();
		} else if (input == 2) {
			clear();
			gameInfo();
		} else {
			System.out.println("������ �����մϴ�.");
		}

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
			System.out.println("������ �����մϴ�.");
	}

	static void crntcoin() {
		title();
		System.out.println("|      ����      |    ����ü�    |   ��������   |   �򰡱ݾ�   |  �����  |");
		System.out.println("------------------------------------------------------------------");
		for (int i = 0; i < 6; i++) {
			System.out.println("|     " + coins[i] + "    |    " + price[i] + "    |   " + my_coins[i]
					+ "   |   �򰡱ݾ�   |  " + percent[i] + "%  |");
		}
		System.out.println("==================================================================");
		clear();
	}

	public static void main(String[] args) {
		startGame();
	}
}

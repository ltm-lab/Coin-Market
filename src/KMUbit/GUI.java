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
		System.out.println("|                          1. 게임 시작                            |");
		System.out.println("|                          2. 게임 정보                            |");
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
			System.out.println("게임을 종료합니다.");
		}

	}

	static void gameInfo() {
		Scanner sc = new Scanner(System.in);
		title();
		System.out.println("|                                                                |");
		System.out.println("|        이 게임은 아무거나 팀에서 개발한 코인매매 시뮬레이션 게임입니다.        |");
		System.out.println("|        한정된 돈으로 코인을 매매하여 소지금 목표치를 달성하시면 클리어!        |");
		System.out.println("|                                                                |");
		System.out.println("|                      Developed By 아무거나팀                      |");
		System.out.println("|                                                                |");
		System.out.println("==================================================================");
		System.out.print("초기화면으로 가시려면 1을 입력해주세요.");
		int input = sc.nextInt();
		if (input == 1) {
			clear();
			startGame();
		} else
			System.out.println("게임을 종료합니다.");
	}

	static void crntcoin() {
		title();
		System.out.println("|      코인      |    현재시세    |   보유개수   |   평가금액   |  등락폭  |");
		System.out.println("------------------------------------------------------------------");
		for (int i = 0; i < 6; i++) {
			System.out.println("|     " + coins[i] + "    |    " + price[i] + "    |   " + my_coins[i]
					+ "   |   평가금액   |  " + percent[i] + "%  |");
		}
		System.out.println("==================================================================");
		clear();
	}

	public static void main(String[] args) {
		startGame();
	}
}

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
			inGame();
		} else if (input == 2) {
			clear();
			gameInfo();
		} else {
			System.out.println("게임을 종료합니다.");
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
			endGame(false);
	}

	static void endGame(boolean type) {
		if (type) {
			title();
			System.out.println("|                                                                |");
			System.out.println("|      " + day + "일 만에 목표금액을 달성하여 게임을 클리어 하였습니다!       |");
			System.out.println("|                                                                |");
			System.out.println("|                      Thanks for playing!                       |");
			System.out.println("|                                                                |");
			System.out.println("==================================================================");
		} else {
			title();
			System.out.println("|                                                                |");
			System.out.println("|                잘못된 입력으로 인해 게임이 종료되었습니다!                |");
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
		System.out.println("| 번호 |    코인    |   현재시세   |  보유개수  |   평가금액   |   등락폭   |");
		System.out.println("------------------------------------------------------------------");
		for (int i = 0; i < 6; i++) {
			System.out.println("| " + (i + 1) + " |    " + coins[i] + "    |    " + price[i] + "    |   " + my_coins[i]
					+ "   |   " + (my_coins[i] * price[i]) + "   |  " + percent[i] + "%  |");
		}
		System.out.println("==================================================================");
		System.out.print("1: 코인 매수, 2: 코인 매도, 3: 아이템 구매, 4: 턴 종료");
		int input = sc.nextInt();
		if (input == 1) {
			System.out.print("매수할 코인번호 와 구매 개수를 입력해주세요. ex)1 10 ");
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			buy_coin(tmp1, tmp2);
		} else if (input == 2) {
			System.out.print("매도할 코인번호 와 구매 개수를 입력해주세요. ex)1 10 ");
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			sell_coin(tmp1, tmp2);
		} else if (input == 3) {
			System.out.print("정보를 확인하고 싶은 코인 번호와 힌트 정보를 입력해주세요.(1: 초급힌트, 2: 고급힌트) ex)2 1 ");
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

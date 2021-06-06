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
		System.out.println("  |                          1. 게임 시작                            |");
		System.out.println("  |                          2. 게임 정보                            |");
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
			System.out.println("게임을 종료합니다.");
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
		System.out.println("  |       이 게임은 아무거나 팀에서 개발한 코인매매 시뮬레이션 게임입니다.       |");
		System.out.println("  |   한정된 돈으로 코인을 매매하여 소지금 목표치(100만원)를 달성하시면 클리어!   |");
		System.out.println("  |                                                                |");
		System.out.println("  |                      Developed By 아무거나팀                     |");
		System.out.println("  |                                                                |");
		System.out.println("  ==================================================================");
		System.out.print("  초기화면으로 가시려면 1을 입력해주세요.\n");
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
			System.out.println("  |           " + day + "일 만에 목표금액을 달성하여 게임을 클리어 하였습니다!           |");
			System.out.println("  |                                                                |");
			System.out.println("  |                      Thanks for playing!                       |");
			System.out.println("  |                                                                |");
			System.out.println("  ==================================================================");
		} else {
			title();
			System.out.println("  |                                                                |");
			System.out.println("  |                잘못된 입력으로 인해 게임이 종료되었습니다!                |");
			System.out.println("  |                                                                |");
			System.out.println("  |                      Thanks for playing!                       |");
			System.out.println("  |                                                                |");
			System.out.println("  ==================================================================");
		}
	}

	static void crntCoin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("  ==================================================================");
		System.out.printf("  |                 KMUbit(Day " + day + ")            현재 소지금 : %06d원   |\n", money);
		System.out.println("  ==================================================================");
		System.out.println("  | 번호 |    코인    |   현재시세   |  보유개수  |   평가금액   |   등락폭   |");
		System.out.println("  ------------------------------------------------------------------");
		for (int i = 0; i < 6; i++) {
			System.out.printf("  | %d |   %s    |    %04d    |   %03d   |   %06d   |   %02d%%   |\n", (i + 1), coins[i],
					price[i], my_coins[i], my_coins[i] * price[i], percent[i]);
		}
		System.out.println("  ==================================================================");
		System.out.println("  1: 코인 매수, 2: 코인 매도, 3: 정보 구매, 4: 채굴기 구매, 5: 턴 종료 ");
		int input = sc.nextInt();
		if (input == 1) {
			System.out.print("  매수할 코인번호 와 구매 개수를 입력해주세요.\n  ex)1 10 ");
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			clear();
			buy_coin(tmp1, tmp2);
		} else if (input == 2) {
			System.out.print("  매도할 코인번호 와 구매 개수를 입력해주세요.\n  ex)1 10 ");
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			clear();
			sell_coin(tmp1, tmp2);
		} else if (input == 3) {
			System.out.print("  정보를 확인하고 싶은 코인 번호와 정보 등급을 입력해주세요. \n  1: 하급정보(5,000원), 2: 고급정보(10,000원)\n  ex)2 1 ");
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			clear();
			buy_hint(tmp1, tmp2);
		} else if (input == 4) {
			System.out.print(
					"  구매하실 채굴기 종류를 선택해주세요.(200,000원)\n  1: 코인채굴기(매 턴마다 선택하신 코인을 10개씩 채굴합니다.)\n  2: 현금채굴기(매 턴마다 50,000원의 소지금을 채굴합니다.) ");
			int type = sc.nextInt();
			clear();
			buy_item(type);
		} else if (input == 5) {
			turnOver = false;
			clear();
			System.out.println("  다음 날이 되었습니다.");
			if (have_item[0] != -1) {
				my_coins[have_item[0]] += 10;
				System.out.println("  코인채굴기가 [" + coins[have_item[0]] + "]를 10개 채굴하였습니다!");
			}
			if (have_item[1] == 1) {
				money += 50000;
				System.out.println("  현금채굴기가 50,000원을 채굴하였습니다!");
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

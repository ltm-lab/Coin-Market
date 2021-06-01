package KMUbit;

import java.util.Random;

public class Coin {
	public static String[] coins = { "도기코인", "빝으코인", "국민코인", "이다리움", "비타캐쉬", "빗토렌트" };

	static int[] price = { 1000, 1000, 1000, 1000, 1000, 1000 };
	static int[] tm_price = new int[6];
	static int[] percent = new int[6];

	public static int due = 1;

	public static void today() {
		for (int i = 0; i < 6; i++) {
			price[i] = tm_price[i];
		}
	}

	public static void tomorrow() {
		due++;
		Random random = new Random();

		for (int i = 0; i < 6; i++) { // 다음 날 가격 랜덤 설정
			tm_price[i] = (int) (Math.random() * 1500);
		}

		// percent 업데이트
		for (int i = 0; i < 6; i++) {
			if (tm_price[i] >= price[i]) { // 코인 오름 or 똑같음
				percent[i] = ((tm_price[i] - price[i]) / 10);
			} else {
				percent[i] = ((price[i] - tm_price[i]) / 10);
			}
		}
	}
}

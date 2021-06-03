package KMUbit;

public class Coin {
	public static String[] coins = { "도기코인", "빝으코인", "국민코인", "이다리움", "비타캐쉬", "빗토렌트" };

	static int[] price = { 1000, 1000, 1000, 1000, 1000, 1000 };
	static int[] tm_price = new int[6];
	static int[] percent = new int[6];
	static int[] tm_percent = new int[6];

	public static int day = 1;

	public static void today() {
		for (int i = 0; i < 6; i++) {
			price[i] = tm_price[i];
			percent[i] = tm_percent[i];
		}
		day++;
	}

	public static void tomorrow() {
		for (int i = 0; i < 6; i++) { // 다음 날 가격 랜덤 설정
			tm_price[i] = (int) (Math.random() * 1500);
		}

		// percent 업데이트
		for (int i = 0; i < 6; i++) {
			if (tm_price[i] >= price[i]) { // 코인 오름 or 똑같음
				tm_percent[i] = ((tm_price[i] - price[i]) / 10);
			} else {
				tm_percent[i] = -((price[i] - tm_price[i]) / 10);
			}
		}
	}
}

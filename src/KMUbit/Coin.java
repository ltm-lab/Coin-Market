package KMUbit;

public class Coin {
	public static String[] coins = { "��������", "��������", "��������", "�̴ٸ���", "��Ÿĳ��", "���䷻Ʈ" };

	static int[] price = { 1000, 1000, 1000, 1000, 1000, 1000 };
	static int[] tm_price = new int[6];
	static int[] percent = new int[6];
	static int[] tm_percent = new int[6];
	static int[] random1 = new int[20];

	public static int day = 1;

	public static void today() {
		for (int i = 0; i < 6; i++) {
			price[i] = tm_price[i];
			percent[i] = tm_percent[i];
		}
		day++;
	}

	public static void tomorrow() {

		for (int i = 0; i < 6; i++) { // ���� �� ���� ���� ����
			double a = Math.random() * 30;
			double b = 0;
			if (a <= 10) // 3���� 1 Ȯ����
			{
				do {
					b = Math.random() * 500;
					tm_price[i] = (int) (price[i] + b); // ���� ����+ 1 ~ 500

				} while (tm_price[i] <= 0);

			}
			if (a > 10 & a <= 20) // 3���� 1 Ȯ����
			{
				do {
					b = Math.random() * 500;
					tm_price[i] = (int) (price[i] - b); // ���� ����- 1 ~ 500

				} while (tm_price[i] <= 0);

			}
			if (a > 20 & a <= 25) {
				do {
					b = Math.random() * 300 + 500;
					tm_price[i] = (int) (price[i] + b); // ���� ����+ 500 ~ 800

				} while (tm_price[i] <= 0);

			}

			if (a > 26 & a <= 30) {
				do {
					b = Math.random() * 300 + 500;
					tm_price[i] = (int) (price[i] - b); // ���� ����- 500 ~ 800

				} while (tm_price[i] <= 0);

			}
		}

		// percent ������Ʈ
		for (int i = 0; i < 6; i++) {
			if (tm_price[i] >= price[i]) { // ���� ���� or �Ȱ���
				tm_percent[i] = ((tm_price[i] - price[i]) / 10);
			} else {
				tm_percent[i] = -((price[i] - tm_price[i]) / 10);
			}
		}
	}
}

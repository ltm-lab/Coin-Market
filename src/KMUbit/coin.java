package KMUbit;

import java.util.Random;

public class Coin {
	public static String[] coins = { "��������", "��������", "��������", "�̴ٸ���", "��Ÿĳ��", "���䷻Ʈ" };

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

		for (int i = 0; i < 6; i++) { // ���� �� ���� ���� ����
			tm_price[i] = (int) (Math.random() * 1500);
		}

		// percent ������Ʈ
		for (int i = 0; i < 6; i++) {
			if (tm_price[i] >= price[i]) { // ���� ���� or �Ȱ���
				percent[i] = ((tm_price[i] - price[i]) / 10);
			} else {
				percent[i] = ((price[i] - tm_price[i]) / 10);
			}
		}
	}
}

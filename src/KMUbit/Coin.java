package KMUbit;

public class Coin {
	public static String[] coins = { "��������", "��������", "��������", "�̴ٸ���", "��Ÿĳ��", "���䷻Ʈ" };

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
		for (int i = 0; i < 6; i++) { // ���� �� ���� ���� ����
			tm_price[i] = (int) (Math.random() * 1500);
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

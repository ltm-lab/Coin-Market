package KMUbit;

public class shop extends coin {
	static void crntcoin() {
		gui.title();
		System.out.println("|      ����      |    ����ü�    |   ��������   |   �򰡱ݾ�   |  �����  |");
		System.out.println("------------------------------------------------------------------");
		for (int i = 0; i < 6; i++) {
			System.out.println("|     " + coins[i] + "    |    " + coin.price[i] + "    |   ��������   |   �򰡱ݾ�   |  "
					+ coin.percent[i] + "%  |");
		}
		System.out.println("==================================================================");
		System.out.println();
	}

	public static void main(String[] args) {
		crntcoin();
		tomorrow();
		today();
		crntcoin();
		tomorrow();
		today();
		crntcoin();
		tomorrow();
		today();
		crntcoin();
	}
}

package KMUbit;

public class shop extends coin {
	static void crntcoin() {
		gui.title();
		System.out.println("|      코인      |    현재시세    |   보유개수   |   평가금액   |  등락폭  |");
		System.out.println("------------------------------------------------------------------");
		for (int i = 0; i < 6; i++) {
			System.out.println("|     " + coins[i] + "    |    " + coin.price[i] + "    |   보유개수   |   평가금액   |  "
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

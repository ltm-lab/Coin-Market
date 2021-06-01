package KMUbit;

public class GUI extends Shop {
	static void title() {
		System.out.println("==================================================================");
		System.out.println("|                          KMUbit(v1.0)                          |");
		System.out.println("==================================================================");
	}

	static void crntcoin() {
		title();
		System.out.println("|      코인      |    현재시세    |   보유개수   |   평가금액   |  등락폭  |");
		System.out.println("------------------------------------------------------------------");
		for (int i = 0; i < 6; i++) {
			System.out.println("|     " + coins[i] + "    |    " + price[i] + "    |   보유개수   |   평가금액   |  "
					+ percent[i] + "%  |");
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

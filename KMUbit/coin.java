package KMUbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class coin {

	public static ArrayList<Integer> price = new ArrayList<>(Arrays.asList(1, 1));
	public static ArrayList<Integer> tm_price = new ArrayList<>(Arrays.asList(30, 30));
	public static ArrayList<Double> percent = new ArrayList<>(Arrays.asList(0.0, 0.0));
	public static int due = 1;

	public static void main(String[] args) {

		today();
		tomorrow();
		today();
		tomorrow();
		today();

	}

	public static void tomorrow() {
		due++;
		Random random = new Random();

		ArrayList<Integer> tm_price = new ArrayList<>();
		for (int i = 0; i < 2; i++) { // 코인 개수 만큼
			int a = (int) (Math.random() * 100);

			tm_price.add(i, a); // 내일 가격 랜덤으로 업데이트

		}

		// percent 업데이트
		ArrayList<Double> percent = new ArrayList<>();
		for (int i = 0; i < 2; i++) {

			if (tm_price.get(i) >= price.get(i)) { // 코인 오름 or 똑같음

				double a = ((tm_price.get(i) - price.get(i)) / (double) price.get(i)) * 100;
				percent.add(i, a); // 상승폭 저장

			} else {

				double b = ((price.get(i) - tm_price.get(i)) / (double) tm_price.get(i)) * 100;
				percent.add(i, -b); // 하락폭 저장
			}

		}

		System.out.printf("코인 1은 내일 " + tm_price.get(0) + "원 일 것입니다.\n");
		System.out.printf("코인 2는 내일 " + tm_price.get(1) + "원 일 것입니다.\n");

		System.out.printf("코인 1의 (예상)변동률 " + percent.get(0) + "퍼센트, 코인 2의 (예상)변동률" + percent.get(1) + "퍼센트\n");
	}

	public static void today() {
		price = tm_price; // 내일 가격을 오늘 가격에 업데이트

		System.out.print("@@@@" + due + "일째@@@@\n");

		System.out.printf("코인 1은 오늘" + price.get(0) + "원, 코인 2는 오늘" + price.get(1) + "원\n");

		System.out.printf("코인 1의 변동률 " + percent.get(0) + "퍼센트, 코인 2의 변동률" + percent.get(1) + "퍼센트\n");

	}

}
